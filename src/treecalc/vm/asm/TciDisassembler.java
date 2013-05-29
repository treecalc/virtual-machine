package treecalc.vm.asm;

import static treecalc.vm.TciMachine.*;

import java.io.PrintStream;
import java.util.BitSet;
import java.util.Collection;

import treecalc.vm.asm.TciAssembler.Asm;
import treecalc.vm.asm.TciAssembler.Calc;
import treecalc.vm.asm.TciAssembler.Func;
import treecalc.vm.asm.TciAssembler.Input;
import treecalc.vm.asm.TciAssembler.Instruction;
import treecalc.vm.asm.TciAssembler.Node;
import treecalc.vm.asm.TciAssembler.NodeCalc;
import treecalc.vm.asm.TciAssembler.Table;
import treecalc.vm.asm.TciAssembler.TableColumn;

public class TciDisassembler {
	/**
	 * position in array = BFInfo.getId()
	 */
	private static BFInfo[] bfinfos;
	private static PrintStream out;
	static {
		Collection<BFInfo> bf = BFInfo.getBasisfunctions();
		int max=0;
		for (BFInfo bfinfo : bf) {
			int id = bfinfo.getId();
			if (id>max) {
				max = id;
			}
		}
		bfinfos = new BFInfo[max+1];
		for (BFInfo bfinfo : bf) {
			int id = bfinfo.getId();
			bfinfos[id] = bfinfo;
		}
	}
	public static void print(Asm asm, PrintStream out, boolean trace) {
		TciDisassembler.out = out;
		printCalcs(asm, trace);
		printNodes(asm, trace);
		printTables(asm, trace);
		printFuncs(asm, trace);
		printFormulas(asm, trace);
	}
	
	private static void printCalcs(Asm asm, boolean trace) {
		Calc[] calcs = asm.calcs;
		out.println(".calcs size=" + calcs.length);
		for (int i=0; i<calcs.length; i++) {
			Calc calc = calcs[i];
			out.print(".calc");
			out.print(" calc=" + i);
			out.print(" name=" + calc.name);
			out.print(" nargs=" + calc.nargs);
			if (calc.rootaccessSum) {
				out.print(" computestartnode=" + calc.rootaccessNode);
			} else {
				out.print(" computenode=" + calc.rootaccessNode);
			}
			out.println();
		}
	}
	
	private static void printNodes(Asm asm, boolean trace) {
		Node[] nodes = asm.nodes;
		out.println(".nodes size=" + nodes.length);
		for (int i=0; i<nodes.length; i++) {
			Node node = nodes[i];
			out.print(".node node=" + i);
			out.print(" id=" + node.nameid);
			if (node.name!=null && !node.name.equals(node.nameid)) {
				out.print(" name=\"" + node.name + "\"");
			}
			out.println();
			printNodecalc(node, asm, trace);
			printCalcdef(node, asm, trace);
			printCalctotal(node, asm, trace);
			printEdges(node, asm, trace);
		}
		printFuncs(asm, trace);
		printInputCalcids(asm, trace);
		printInputs(asm, trace);
	}
	

	private static void printNodecalc(Node node, Asm asm, boolean trace) {
		NodeCalc[] nodecalcs = node.nodecalcList;
		for (int i=0; i<nodecalcs.length; i++) {
			NodeCalc nodecalc = nodecalcs[i];
			if (nodecalc!=null) {
				out.print(".nodecalc node=" + node.id);
				out.print(" calc=" + nodecalc.calcid);
				out.print(" formula=" + nodecalc.formula);
				out.println();
			}
		}
	}

	private static void printCalcdef(Node node, Asm asm, boolean trace) {
		BitSet nco = node.nco;
		printCalcBitset(nco, ".calcdef", node, asm, trace);
	}

	private static void printCalctotal(Node node, Asm asm, boolean trace) {
		BitSet nct = node.nct;
		printCalcBitset(nct, ".calcdef", node, asm, trace);
	}

	private static void printCalcBitset(BitSet bs, String prefix, Node node, Asm asm, boolean trace) {
		int start=0;
		int nodeindex = node.id;
		while ((start = bs.nextSetBit(start))>=0) {
			/* index has now next index of set bit */
			/* find next which is not set */
			int end = bs.nextClearBit(start);
			if (end<0) {
				end = asm.calcs.length-1;
			} else {
				end--;
			}
			out.print(prefix);
			out.print(" node=");
			out.print(nodeindex);
			if (start==end) {
				out.print(" calc=");
				out.print(start);
			} else {
				out.print(" calc_rangestart=");
				out.print(start);
				out.print(" calc_rangeend=");
				out.print(end);
			}
			out.println();
			start = end+1;
			if (start>=asm.calcs.length) {
				break;
			}
		}
	}

	private static void printEdges(Node node, Asm asm, boolean trace) {
		int nodeid = node.id;
		int[] edges = asm.edges[nodeid];
		out.print(".edges");
		out.print(" from=" + nodeid);
		out.print(" size=" + edges.length);
		out.println();
		for (int i=0; i<edges.length; i++) {
			out.print(".edge");
			out.print(" ind=" + i);
			out.print(" from=" + nodeid);
			out.print(" to=" + edges[i]);
			out.println();
		}
	}

	private static void printTables(Asm asm, boolean trace) {
		Table[] tables = asm.tables;
		out.println(".tables size=" + tables.length);
		for (int i=0; i<tables.length; i++) {
			printTable(tables[i], asm, trace);
		}
	}

	private static void printTable(Table table, Asm asm, boolean trace) {
		//.table table=0 name=T_LI_CHANNEL rows=3 cols=4 shuffled=false directaccess=true directaccessoffset=1
		out.print(".table table=" + table.id);
		out.print(" name=" + table.name);
		out.print(" rows=" + table.rows);
		out.print(" cols=" + table.cols);
		out.print(" shuffled=" + table.shuffled);
		out.print(" directaccess=" + table.directaccess);
		if (table.directaccess) {
			out.print(" directaccessoffset=" + table.directaccessoffset);
		}
		out.println();

		/* columns */
		TableColumn[] cols = table.tablecolumnarr;
		for (int i=0; i<cols.length; i++) {
			TableColumn col = cols[i];
			out.print(".tablecol table=" + table.id + " col=" + col.colind);
			out.print(" name=\"" + col.name + "\"");
			out.print(" numeric=" + col.numeric);
			out.print(" numericsuper=" + col.numericsuper);
			out.print(" numericunique=" + col.numericunique);
			out.println();
		}

		/* data */
		String[] data = table.data;
		for (int indvalue=0; indvalue<data.length; indvalue++) {
			int indrow = indvalue / table.cols;
			int indcol = indvalue % table.cols;
			out.print(".tablevalue");
			out.print(" table=");
			out.print(table.id);
			out.print(" ind=");
			out.print(indvalue);
			out.print(" row=");
			out.print(indrow);
			out.print(" col=");
			out.print(indcol);
			out.print(" value=");
			out.print('"');
			out.print(data[indvalue]);
			out.print('"');
			out.println();
		}
		
		/* rows */
		if (table.shuffled) {
			int[] oo = table.oo;
			for (int indrow=0; indrow<table.rows; indrow++) {
				out.print(".tablerow");
				out.print(" table=");
				out.print(table.id);
				out.print(" row=");
				out.print(indrow);
				out.print(" oo=");
				out.print(oo[indrow]);
				out.println();
			}
		}
	}

	private static void printFuncs(Asm asm, boolean trace) {
		Func[] funcs = asm.funcs;
		out.println(".funcs size=" + funcs.length);
		for (int i=0; i<funcs.length; i++) {
			Func func = funcs[i];
			out.print(".func");
			out.print(" func=");
			out.print(func.funcid);
			out.print(" name=");
			out.print(func.name);
			out.print(" args=");
			out.print(func.nargs);
			out.print(" formula=");
			out.print(func.formula);
			out.println();
		}
	}
	
	private static void printInputCalcids(Asm asm, boolean trace) {
		String[] inputcalcnames = asm.inputcalcnames;
		out.println(".inputcalcids size=" + inputcalcnames.length);
		for (int i=0; i<inputcalcnames.length; i++) {
			String inputcalcname = inputcalcnames[i];
		    out.print(".inputcalcid icalc=" + i);
		    out.print(" name=" + inputcalcname);
		    out.println();
		}
	}
	
	private static void printInputs(Asm asm, boolean trace) {
		Input[] inputs = asm.inputs;
		out.println(".inputs size=" + inputs.length);
		for (int i=0; i<inputs.length; i++) {
			printInput(inputs[i], asm, trace);
		}
	}
	
	private static void printInput(Input input, Asm asm, boolean trace) {
		out.print(".input");
		out.print(" input=");
		out.print(input.inputid);
		out.print(" name=");
		out.print(input.name);

		int[] autocounters = input.autocounters;
		int aclen = autocounters == null ? 0 : autocounters.length;
		out.print(" autocounters=");
		out.print(aclen);
		
		out.print(" choiceable=");
		out.print(input.isChoiceable);
		out.println();

		for (int i=0; i<aclen; i++) {
			out.print(".inputautocounter");
			out.print(" input=");
			out.print(input.inputid);
			out.print(" ind=");
			out.print(i);
			out.print(" counter=");
			out.println(autocounters[i]);
		}
		int[] formulas = input.inputcalcFormulas;
		for (int i=0; i<formulas.length; i++) {
			int formula = formulas[i];
			if (formula>=0) {
				out.print(".inputcalc");
				out.print(" input=" + input.inputid);
				out.print(" icalc=" + i);
				out.print(" formula=" + formula);
				out.println();
			}
		}
	}
	
	private static void printFormulas(Asm asm, boolean trace) {
		out.println(".formulas size=" + asm.formulaOffset.length);
		int indFormula = 0;
		byte[] bytecode = asm.bytecode;
		int pcsize = bytecode.length;
		int pclen = (int) Math.ceil(Math.log10(pcsize));
		String pcformat = " %" + pclen + "d: ";
		int pc=0;
		while(pc<bytecode.length) {
			int pcstart = pc;
			if (indFormula<asm.formulaOffset.length && pcstart==asm.formulaOffset[indFormula]) {
				if (indFormula>0) {
					out.println(".formuladone");
				}
				out.print(".formula");
				out.print(" formula=" + indFormula);
				out.print(" simple=" + asm.formulaSimple[indFormula]);
				out.println();
				indFormula++;
			}
			
			out.print(String.format(pcformat, pc));
			int instrid = bytecode[pc++] & 0xFF;
			if (trace) {
				out.print("byte1=" + instrid + ", ");
			}
			int op1=0;
			int op2=0;
			int op3=0;
			int op4=0;
			/* decode operation */
			if (instrid > 0x7F) { //additional operands?
				instrid = instrid & 0x7F;
				int opdescr = bytecode[pc++] & 0xFF;
				if (trace) {
					out.print("byte2=" + opdescr + ", ");
				}
				int optype = opdescr & 0x3;
				// op<n>: 00 done, 01 byte, 11 int
				switch(optype) {
				case 1:	
					op1 = bytecode[pc++] & 0xFF;
					if (trace) {
						out.print("byte3=" + op1 + ", ");
					}
					break;
				case 2:
					if (trace) {
						out.print("byte3=" + (bytecode[pc] & 0xFF) + ", "); 
						out.print("byte4=" + (bytecode[pc+1] & 0xFF) + ", ");
					}
			        op1 = ((bytecode[pc++] & 0xFF)<< 8)
				        | ((bytecode[pc++] & 0xFF)    );
			        break;
				case 3:
					if (trace) {
						out.print("byte3=" + (bytecode[pc] & 0xFF) + ", "); 
						out.print("byte4=" + (bytecode[pc+1] & 0xFF) + ", "); 
						out.print("byte5=" + (bytecode[pc+2] & 0xFF) + ", "); 
						out.print("byte6=" + (bytecode[pc+3] & 0xFF) + ", ");
					}
			        op1 = ((bytecode[pc++] & 0xFF)<<24) 
				        	| ((bytecode[pc++] & 0xFF)<<16)
				        	| ((bytecode[pc++] & 0xFF)<< 8)
				        	| ((bytecode[pc++] & 0xFF)    );
			        break;
				}
				optype = opdescr>>2 & 0x3;
				if (optype>0) {
					switch(optype) {
					case 1:	
						if (trace) {
							out.print("byte" + (pc-pcstart) + "=" + (bytecode[pc] & 0xFF) + ", ");
						}
						op2 = bytecode[pc++] & 0xFF; 
						break;
					case 2:
						if (trace) {
							out.print("byte" + (pc  -pcstart) + "=" + (bytecode[pc  ] & 0xFF) + ", "); 
							out.print("byte" + (pc+1-pcstart) + "=" + (bytecode[pc+1] & 0xFF) + ", ");
						}
				        op2 = ((bytecode[pc++] & 0xFF)<< 8)
					        | ((bytecode[pc++] & 0xFF)    );
				        break;
					case 3:
						if (trace) {
							out.print("byte" + (pc  -pcstart) + "=" + (bytecode[pc  ] & 0xFF) + ", "); 
							out.print("byte" + (pc+1-pcstart) + "=" + (bytecode[pc+1] & 0xFF) + ", "); 
							out.print("byte" + (pc+2-pcstart) + "=" + (bytecode[pc+2] & 0xFF) + ", "); 
							out.print("byte" + (pc+3-pcstart) + "=" + (bytecode[pc+3] & 0xFF) + ", ");
						}
				        op2 = ((bytecode[pc++] & 0xFF)<<24) 
					        	| ((bytecode[pc++] & 0xFF)<<16)
					        	| ((bytecode[pc++] & 0xFF)<< 8)
					        	| ((bytecode[pc++] & 0xFF)    );
				        break;
					}
					optype = opdescr>>4 & 0x3;
					if (optype>0) {
						switch(optype) {
						case 1:
							if (trace) {
								out.print("byte" + (pc-pcstart) + "=" + (bytecode[pc] & 0xFF) + ", ");
							}
							op3 = bytecode[pc++] & 0xFF; 
							break;
						case 2:
							if (trace) {
								out.print("byte" + (pc  -pcstart) + "=" + (bytecode[pc  ] & 0xFF) + ", "); 
								out.print("byte" + (pc+1-pcstart) + "=" + (bytecode[pc+1] & 0xFF) + ", ");
							}
					        op3 = ((bytecode[pc++] & 0xFF)<< 8)
						        | ((bytecode[pc++] & 0xFF)    );
					        break;
						case 3:
							if (trace) {
								out.print("byte" + (pc  -pcstart) + "=" + (bytecode[pc  ] & 0xFF) + ", "); 
								out.print("byte" + (pc+1-pcstart) + "=" + (bytecode[pc+1] & 0xFF) + ", "); 
								out.print("byte" + (pc+2-pcstart) + "=" + (bytecode[pc+2] & 0xFF) + ", "); 
								out.print("byte" + (pc+3-pcstart) + "=" + (bytecode[pc+3] & 0xFF) + ", ");
							}
					        op3 = ((bytecode[pc++] & 0xFF)<<24) 
						        	| ((bytecode[pc++] & 0xFF)<<16)
						        	| ((bytecode[pc++] & 0xFF)<< 8)
						        	| ((bytecode[pc++] & 0xFF)    );
					        break;
						}
						optype = opdescr>>6 & 0x3;
						if(optype>0) {
							switch(optype) {
							case 1:
								if (trace) {
									out.print("byte" + (pc-pcstart) + "=" + (bytecode[pc] & 0xFF) + ", ");
								}
								op4 = bytecode[pc++] & 0xFF; 
								break;
							case 2:
								if (trace) {
									out.print("byte" + (pc  -pcstart) + "=" + (bytecode[pc  ] & 0xFF) + ", "); 
									out.print("byte" + (pc+1-pcstart) + "=" + (bytecode[pc+1] & 0xFF) + ", ");
								}
						        op4 = ((bytecode[pc++] & 0xFF)<< 8)
							        | ((bytecode[pc++] & 0xFF)    );
						        break;
							case 3:
								if (trace) {
									out.print("byte" + (pc  -pcstart) + "=" + (bytecode[pc  ] & 0xFF) + ", "); 
									out.print("byte" + (pc+1-pcstart) + "=" + (bytecode[pc+1] & 0xFF) + ", "); 
									out.print("byte" + (pc+2-pcstart) + "=" + (bytecode[pc+2] & 0xFF) + ", "); 
									out.print("byte" + (pc+3-pcstart) + "=" + (bytecode[pc+3] & 0xFF) + ", ");
								}
						        op4 = ((bytecode[pc++] & 0xFF)<<24) 
							        	| ((bytecode[pc++] & 0xFF)<<16)
							        	| ((bytecode[pc++] & 0xFF)<< 8)
							        	| ((bytecode[pc++] & 0xFF)    );
						        break;
							}
					    }
				   	}
				}
			}
			Instruction instr = null;
			try {
				instr = TciAssembler.getInstructionById(instrid);
				out.print(instr.getName());
				
				if (instrid==INSTR_PUSHCONST) {
					out.print(' ');
					Object constant = asm.constants[op1];
					if (constant instanceof Integer) {
						out.print(constant.toString());
					} else if (constant instanceof Double) {
						out.print(constant.toString());
					} else {
						out.print("\"" + constant.toString() + "\"");
					}
				} else {
					for (int i=0; i<instr.getOpSize(); i++) {
						out.print(' ');
						switch(i) {
						case 0: out.print(op1); break;
						case 1: out.print(op2); break;
						case 2: out.print(op3); break;
						case 3: out.print(op4); break;
						}
					}
				}
				if (instr.getOpSize()>0) {
					out.print(" //");
					for (int i=0; i<instr.getOpSize(); i++) {
						out.print(' ');
						out.print(instr.getOpname(i));
						out.print('=');
						switch(i) {
						case 0: out.print(op1); break;
						case 1: out.print(op2); break;
						case 2: out.print(op3); break;
						case 3: out.print(op4); break;
						}
					}
				}
			} catch (Exception e) {
				out.print(" ... could not decode. Check Instruction setup and binary format.");
			}
			/* dispatch */
			switch(instrid) {
			case INSTR_BUILTIN                     : //"builtinid", OPTYPE_BYTE, "nargs", OPTYPE_INT) //arg1 ... arg_nargs -- result
				out.print(" // " + bfinfos[op1].getJavaname());
				break;
			case INSTR_CALLFUNC                    : { //"funcid", OPTYPE_INT, "nargs", OPTYPE_INT) //arg1 ... arg_nargs -- result
				Func func = asm.funcs[op1];
				out.print(" // " + func.name);
				break;
			}
			case INSTR_PUSHCONST                   : //"constant", OPTYPE_CONST) // -- a   ; taken from constant pool
				out.print(" // " + asm.constants[op1].toString());
				break;
			case INSTR_TABCELL                     : //"tableid", OPTYPE_INT) //rownr colnr -- result
				out.print(" // " + asm.tables[op1].name);
				break;
			case INSTR_TABCELL_CN                  : //"tableid", OPTYPE_INT) //rownr colname -- result  
				out.print(" // " + asm.tables[op1].name);
				break;
			case INSTR_TABCELLS                    : //"tableid", OPTYPE_INT) //rownrfrom rownrto colnrfrom colnrto -- result  
				out.print(" // " + asm.tables[op1].name);
				break;
			case INSTR_TABCELLS_CN                 : //"tableid", OPTYPE_INT) //rownrfrom rownrto colnamefrom colnameto -- result  
				out.print(" // " + asm.tables[op1].name);
				break;
			case INSTR_TABCELLSCOL                 : //"tableid", OPTYPE_INT) //rownrfrom rownrto colnr -- result  
				out.print(" // " + asm.tables[op1].name);
				break;
			case INSTR_TABCELLSCOL_CN              : //"tableid", OPTYPE_INT) //rownrfrom rownrto colname -- result  
				out.print(" // " + asm.tables[op1].name);
				break;
			case INSTR_TABCELLSROW                 : //"tableid", OPTYPE_INT) //rownr colnrfrom colnrto -- result  
				out.print(" // " + asm.tables[op1].name);
				break;
			case INSTR_TABCELLSROW_CN              : //"tableid", OPTYPE_INT) //rownr colnamefrom colnameto -- result  
				out.print(" // " + asm.tables[op1].name);
				break;
			case INSTR_TABFINDEXACT                : //"tableid", OPTYPE_INT, "nargs", OPTYPE_BYTE) //arg1 ... arg_nargs -- result
				out.print(" // " + asm.tables[op1].name);
				break;
			case INSTR_TABFINDEXACTCOLUMN          : //"tableid", OPTYPE_INT, "nargs", OPTYPE_BYTE, "colind", OPTYPE_INT) // arg1 ... arg_nargs -- result
				out.print(" // " + asm.tables[op1].name + "." + asm.tables[op1].tablecolumnarr[op3].name);
				break;
			case INSTR_TABFINDEXACTCOLUMNBYNAME    : //"tableid", OPTYPE_INT, "nargs", OPTYPE_BYTE) //arg1 ... arg_nargs colname -- result
				out.print(" // " + asm.tables[op1].name);
				break;
			case INSTR_TABFINDINTERVALDOWNCOLUMN   : //"tableid", OPTYPE_INT, "nargs", OPTYPE_BYTE) //arg1 ... arg_nargs colname -- result
				out.print(" // " + asm.tables[op1].name);
				break;
			case INSTR_TABFINDINTERVALUP           : //"tableid", OPTYPE_INT) //arg -- result
				out.print(" // " + asm.tables[op1].name);
				break;
			case INSTR_TABFINDINTERVALUPCOLUMN     : //"tableid", OPTYPE_INT, "nargs", OPTYPE_BYTE) //arg1 ... arg_nargs colname -- result
				out.print(" // " + asm.tables[op1].name);
				break;
			case INSTR_TABFINDROWEXACT             : //"tableid", OPTYPE_INT, "nargs", OPTYPE_BYTE) //arg1 ... arg_nargs -- result
				out.print(" // " + asm.tables[op1].name);
				break;
			default:
				break;
			} //end of dispatch switch
			out.println();
		}
		if (pc>0) {
			out.println(".formuladone");
		}
		
	}
}
