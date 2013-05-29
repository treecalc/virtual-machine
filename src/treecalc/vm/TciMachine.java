package treecalc.vm;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import treecalc.rt.B;
import treecalc.rt.ExceptionCalculation;
import treecalc.rt.ExceptionNeedMoreInput;
import treecalc.rt.S;
import treecalc.rt.V;
import treecalc.rt.VDouble;
import treecalc.rt.VList;
import treecalc.rt.VNull;
import treecalc.vm.asm.TciAssembler.Asm;
import treecalc.vm.asm.TciAsmReaderWriter;
import treecalc.vm.asm.TciAssembler;
import treecalc.vm.asm.TciAssembler.Calc;
import treecalc.vm.asm.TciAssembler.Func;
import treecalc.vm.asm.TciAssembler.Input;
import treecalc.vm.asm.TciAssembler.Instruction;
import treecalc.vm.asm.TciAssembler.Node;
import treecalc.vm.asm.TciAssembler.NodeCalc;
import treecalc.vm.asm.TciAssembler.Table;

public final class TciMachine implements S {
	public static boolean TRACE = false;
	private static int indent=0;
	private static void indent() {
		for (int i=0; i<indent; i++) {
			System.out.print(' ');
		}
	}
//	public static final boolean TRACE=false;
	public static final byte INSTR_NOP                            = 0x00 ; //no operation
	public static final byte INSTR_ADD                            = 0x01 ;
	public static final byte INSTR_ADDNOTNULL                     = 0x02 ;
	public static final byte INSTR_AND                            = 0x03 ;
	public static final byte INSTR_BIGEQ0                         = 0x04 ;
	public static final byte INSTR_BUILTIN                        = 0x05 ;
	public static final byte INSTR_CALLDYNFUNC                    = 0x06 ;
	public static final byte INSTR_CALLFORMULA                    = 0x07 ;
	public static final byte INSTR_CALLFORMULADYN                 = 0x08 ; 
	public static final byte INSTR_CALLFUNC                       = 0x09 ;
	public static final byte INSTR_CALLNODECALC                   = 0x0A ;
	public static final byte INSTR_CALLNODECALCLIST               = 0x0B ;
	public static final byte INSTR_CALLNODECALCSUM                = 0x0C ;
	public static final byte INSTR_CMPBIG                         = 0x0D ;
	public static final byte INSTR_CMPBIGEQ                       = 0x0E ;
	public static final byte INSTR_CMPNEQ                         = 0x0F ;
	public static final byte INSTR_CMPSEQ                         = 0x10 ;
	public static final byte INSTR_CMPSEQI                        = 0x11 ;
	public static final byte INSTR_CMPSG                          = 0x12 ;
	public static final byte INSTR_CMPSGEQ                        = 0x13 ;
	public static final byte INSTR_CMPSGEQI                       = 0x14 ;
	public static final byte INSTR_CMPSGI                         = 0x15 ;
	public static final byte INSTR_CMPSL                          = 0x16 ;
	public static final byte INSTR_CMPSLEQ                        = 0x17 ;
	public static final byte INSTR_CMPSLEQI                       = 0x18 ;
	public static final byte INSTR_CMPSLI                         = 0x19 ;
	public static final byte INSTR_CMPSML                         = 0x1A ;
	public static final byte INSTR_CMPSMLEQ                       = 0x1B ;
	public static final byte INSTR_CMPSNEQ                        = 0x1C ;
	public static final byte INSTR_CMPSNEQI                       = 0x1D ;
	public static final byte INSTR_CREATELIST0                    = 0x1E ;
	public static final byte INSTR_CREATELIST1                    = 0x1F ;
	public static final byte INSTR_CREATELISTN                    = 0x20 ;
	public static final byte INSTR_DIV                            = 0x21 ;
	public static final byte INSTR_DIVINT                         = 0x22 ;
	public static final byte INSTR_DUP                            = 0x23 ;
	public static final byte INSTR_DYNCOMPUTE                     = 0x24 ;
	public static final byte INSTR_EQ                             = 0x25 ;
	public static final byte INSTR_ERROR                          = 0x26 ;
	public static final byte INSTR_GETFUNCREF                     = 0x27 ;
	public static final byte INSTR_GETINPUT                       = 0x28 ;
	public static final byte INSTR_GETINPUT0                      = 0x29 ;
	public static final byte INSTR_GETINPUTCALC                   = 0x2A ;
	public static final byte INSTR_GETINPUTCALC0                  = 0x2B ;
	public static final byte INSTR_GETINPUTRAW                    = 0x2C ;
	public static final byte INSTR_GETINPUTRAW0                   = 0x2D ;
	public static final byte INSTR_GETINPUTRAWSELF                = 0x2E ;
	public static final byte INSTR_GOTO                           = 0x2F ;
	public static final byte INSTR_IFBIG                          = 0x30 ;
	public static final byte INSTR_IFBIGEQ                        = 0x31 ;
	public static final byte INSTR_IFFALSE                        = 0x32 ;
	public static final byte INSTR_IFNOTNULL                      = 0x33 ;
	public static final byte INSTR_IFNULL                         = 0x34 ;
	public static final byte INSTR_IFNUMEQUAL                     = 0x35 ;
	public static final byte INSTR_IFSEQI                         = 0x36 ;
	public static final byte INSTR_IFSML                          = 0x37 ;
	public static final byte INSTR_IFSMLEQ                        = 0x38 ;
	public static final byte INSTR_IFTRUE                         = 0x39 ;
	public static final byte INSTR_IFZERO                         = 0x3A ;
	public static final byte INSTR_INPUTTESTNULL                  = 0x3B ;
	public static final byte INSTR_LISTAPPENDELEM1                = 0x3C ;
	public static final byte INSTR_LISTELEM1                      = 0x3D ;
	public static final byte INSTR_LOAD                           = 0x3E ;
	public static final byte INSTR_MODINT                         = 0x3F ;
	public static final byte INSTR_MULT                           = 0x40 ;
	public static final byte INSTR_OVER                           = 0x41 ;
	public static final byte INSTR_POP                            = 0x42 ;
	public static final byte INSTR_POWER                          = 0x43 ;
	public static final byte INSTR_PUSHCONST                      = 0x44 ;
	public static final byte INSTR_PUSHCONST0                     = 0x45 ;
	public static final byte INSTR_PUSHCONST1                     = 0x46 ;
	public static final byte INSTR_PUSHNULL                       = 0x47 ;
	public static final byte INSTR_PUSHTIMESCOUNTER               = 0x48 ;
	public static final byte INSTR_RETURN                         = 0x49 ;
	public static final byte INSTR_SAPPEND                        = 0x4A ;
	public static final byte INSTR_STORE                          = 0x4B ;
	public static final byte INSTR_SUB                            = 0x4C ;
	public static final byte INSTR_TABCELL                        = 0x4D ;
	public static final byte INSTR_TABCELLS                       = 0x4E ;
	public static final byte INSTR_TABCELLSCOL                    = 0x4F ;
	public static final byte INSTR_TABCELLSCOL_CN                 = 0x50 ;
	public static final byte INSTR_TABCELLSROW                    = 0x51 ;
	public static final byte INSTR_TABCELLSROW_CN                 = 0x52 ;
	public static final byte INSTR_TABCELLS_CN                    = 0x53 ;
	public static final byte INSTR_TABCELL_CN                     = 0x54 ;
	public static final byte INSTR_TABCOLS                        = 0x55 ;
	public static final byte INSTR_TABFINDEXACT                   = 0x56 ;
	public static final byte INSTR_TABFINDEXACTCOLUMN             = 0x57 ;
	public static final byte INSTR_TABFINDEXACTCOLUMNBYNAME       = 0x58 ;
	public static final byte INSTR_TABFINDINTERVALDOWNCOLUMN      = 0x59 ;
	public static final byte INSTR_TABFINDINTERVALUP              = 0x5A ;
	public static final byte INSTR_TABFINDINTERVALUPCOLUMN        = 0x5B ;
	public static final byte INSTR_TABFINDROWEXACT                = 0x5C ;
	public static final byte INSTR_TABREFCELL                     = 0x5D ;
	public static final byte INSTR_TABREFCELLS                    = 0x5E ;
	public static final byte INSTR_TABREFCELLSCOL                 = 0x5F ;
	public static final byte INSTR_TABREFCELLSCOL_CN              = 0x60 ;
	public static final byte INSTR_TABREFCELLSROW                 = 0x61 ;
	public static final byte INSTR_TABREFCELLSROW_CN              = 0x62 ;
	public static final byte INSTR_TABREFCELLS_CN                 = 0x63 ;
	public static final byte INSTR_TABREFCELL_CN                  = 0x64 ;
	public static final byte INSTR_TABREFFINDEXACT                = 0x65 ;
	public static final byte INSTR_TABREFFINDEXACTCOLUMN          = 0x66 ;
	public static final byte INSTR_TABREFFINDINTERVALDOWNCOLUMN   = 0x67 ;
	public static final byte INSTR_TABREFFINDINTERVALUP           = 0x68 ;
	public static final byte INSTR_TABREFFINDINTERVALUPCOLUMN     = 0x69 ;
	public static final byte INSTR_TABREFFINDROWEXACT             = 0x6A ;
	public static final byte INSTR_TABROWS                        = 0x6B ;
	public static final byte INSTR_TIMES_INCTOP                   = 0x6C ;
	public static final byte INSTR_TIMES_POP                      = 0x6D ;
	public static final byte INSTR_TIMES_PUSH                     = 0x6E ;
	public static final byte INSTR_TREE_NODECALCFORMULA           = 0x6F ;
	public static final byte INSTR_TREE_NODECALCOWN               = 0x70 ;
	public static final byte INSTR_TREE_NODECALCTOTAL             = 0x71 ;
	public static final byte INSTR_TREE_NODEFORMULAINC            = 0x72 ;
	public static final byte INSTR_TREE_NODEFORMULATIMES          = 0x73 ;
	public static final byte INSTR_TREE_NODETIMESID               = 0x74 ;
	public static final byte INSTR_TREE_SUBNODES_COUNTER          = 0x75 ;
	public static final byte INSTR_TREE_SUBNODES_GET              = 0x76 ;
	public static final byte INSTR_UNMINUS                        = 0x77 ;
	public static final byte INSTR_UNPLUS                         = 0x78 ;
	public static final byte INSTR_XOR                            = 0x79 ;

	public final Asm asm;
	private int maxcachesize = 2000;
	
	/* "static" name mapping for a module */
	private HashMap<String,Integer> in; //input names -> index
    private HashMap<String,Integer> cni; //calc name -> index
    private HashMap<String,Integer> fn; //func name -> index
    private HashMap<String,Integer> tn; //table name -> index

    private int INPUTCALC_VECTOR = -1;
    private int INPUTCALC_REFERENCE = -1;
    private int INPUTCALC_TABLE  = -1;
    private int INPUTCALC_FILTER = -1;
    private int INPUTCALC_DISPLAY = -1;
    private int INPUTCALC_DISPLAYTEXT = -1;
    
    /* virtual maschine stacks and state */
	private V[] stack = new V[65536];
	private long[] callstack = new long[65536];
	private Object[] keystack = new Object[8192];

	/* V-constants for speedup */
	private V[] vconstants;
    
	/* profiling information */
	public ProfilingData profilingData;
	public class ProfilingData {
		private final int size;
		private final ProfilingFormula[] profilingFormulaArr;
		private final long[] timesFormula;
		public ProfilingData(int size) {
			this.size = size;
			this.profilingFormulaArr = new ProfilingFormula[size];
			this.timesFormula = new long[size];
		}
		public ProfilingFormula getProfilingFormula(int formulaid) {
			ProfilingFormula prof = profilingFormulaArr[formulaid];
			if (prof==null) {
				prof = new ProfilingFormula(this, asm.formulaSimple[formulaid]);
				profilingFormulaArr[formulaid] = prof;
			}
			return prof;
		}
		
		@Override 
		public String toString() {
			StringBuffer s = new StringBuffer(4096);
			s.append("formulaid;simple;memactive;counter;time;cachelookup;cachehit;cachehitratio\n");
			for (int i=0; i<size; i++) {
				ProfilingFormula prof = profilingFormulaArr[i];
				if (prof==null) {
					continue;
				}
				int onecounter = prof.counterTotal;
				long onetime = prof.timetotal;
				int cacheSearch = prof.cacheTotalLookup;
				int cacheHit = prof.cacheTotalHit;
				int cacheMisses = cacheSearch - cacheHit;
				BigDecimal cacheRatio = BigDecimal.ZERO;
				if (cacheSearch>0) {
					cacheRatio = BigDecimal.valueOf(cacheHit).divide(BigDecimal.valueOf(cacheSearch),  2,  RoundingMode.HALF_UP); 
				}
				if (onecounter>0) {
					s.append(i + ";" + asm.formulaSimple[i] + ";" + prof.memoactive + ";" + onecounter + ";" + onetime 
							+ ";" + cacheSearch + ";" + cacheHit + ";" + cacheRatio + ";" 
							+ "\n");
				}
			}
			return s.toString();
		}
	}
	public String getStatistics() {
		return this.profilingData.toString();
	}
	public static class ProfilingFormula {
		private final ProfilingData profData;
		public ProfilingFormula(ProfilingData profData, boolean issimple) {
			this.profData = profData;
			this.issimple = issimple;
			this.memoactive = !issimple; //true; //!issimple;
		}
		private boolean issimple;
		private boolean memoactive;
		private int  counter;
		private int  counterTotal;
		private long time;
		private long timetotal;
		private int  cacheLookup;
		private int  cacheWrite;
		private int  cacheHit;
		private int  cacheTotalLookup;
		private int  cacheTotalWrite;
		private int  cacheTotalHit;
		private int  topcsp=-1;
		
		public void incCounter() {
			this.counter++;
			this.counterTotal++;
		}
		public  long startTimer(int csp) {
			long timecurrent = System.currentTimeMillis();
			if (topcsp==-1) {
				topcsp = csp;
				time -= timecurrent;
				timetotal -= timecurrent;
			}
			return timecurrent;
		}
		public long endTimer(int csp) {
			long timecurrent = System.currentTimeMillis();
			if (csp==topcsp) {
				time += timecurrent;
				timetotal += timecurrent;
				topcsp=-1;
			}
			return timecurrent;
		}
		public void reset() {
			/* reset everything but not the total fields */
			this.counter=0;
//			this.time=0; //does not work because of recursive calls 
			this.cacheLookup=0;
			this.cacheWrite=0;
			this.cacheHit=0;
		}
		public void cacheHit() {
			this.cacheHit++;
			this.cacheTotalHit++;
		}
		public void cacheLookup() {
			this.cacheLookup++;
			this.cacheTotalLookup++;
		}
		public void cacheWrite() {
			this.cacheWrite++;
			this.cacheTotalWrite++;
		}
	}
//	private ThreadMXBean threadMx;
//	threadMx = ManagementFactory.getThreadMXBean();
//	threadMx.getCurrentThreadCpuTime();
//	System.nanoTime();
	
	
	public TciMachine(final Asm asm) {
		this(asm, -1);
	}
	public TciMachine(final Asm asm, int maxcachesize) {
    	this.asm = asm;
    	if (maxcachesize > 0) {
    		this.maxcachesize = maxcachesize;
    	}
		
		/* initialize 0d input */
		int inputsize = asm.inputs.length;
		inputvalues0dim = new V[inputsize];

		vconstants = new V[asm.constants.length]; 
		
		/* initialize "static" name mappings */
		in = new HashMap<String,Integer>(inputsize, 0.5f);
		for (Input input : asm.inputs){
			in.put(input.name, input.inputid);
		}
		String[] icn = asm.inputcalcnames;
		int icsize = icn.length;
		ic = new HashMap<String,Integer>(icsize, 0.2f);
		for (int i=0; i<icsize; i++) {
			ic.put(icn[i], i);
		}
		Integer ick = ic.get("VECTOR");
		if (ick!=null) {
			this.INPUTCALC_VECTOR = ick;
		}
		ick = ic.get("REFERENCE");
		if (ick!=null) {
			this.INPUTCALC_REFERENCE = ick;
		}
		ick = ic.get("TABLE");
		if (ick!=null) {
			this.INPUTCALC_TABLE = ick;
		}
		ick = ic.get("FILTER");
		if (ick!=null) {
			this.INPUTCALC_FILTER = ick;
		}
		ick = ic.get("DISPLAY");
		if (ick!=null) {
			this.INPUTCALC_DISPLAY = ick;
		}
		ick = ic.get("DISPLAYTEXT");
		if (ick!=null) {
			this.INPUTCALC_DISPLAYTEXT = ick;
		}
		
		Calc[] calcs = asm.calcs;
		int calcssize = calcs.length;
		cni = new HashMap<String,Integer>(calcssize, 0.5f);
		for (int i=0; i<calcssize; i++) {
			Calc calc = calcs[i];
			cni.put(calc.name + ":" + calc.nargs, i);
		}
		Func[] funcs = asm.funcs;
		int funcssize = funcs.length;
		fn = new HashMap<String,Integer>(funcssize, 0.5f);
		for (int i=0; i<funcssize; i++) {
			Func func = funcs[i];
			fn.put(func.name, i);
		}
		Table[] tables = asm.tables;
		int tablessize = tables.length;
		tn = new HashMap<String, Integer>(tablessize, 0.5f);
		for (int i=0; i<tablessize; i++) {
			Table table = tables[i];
			tn.put(table.name, i);
		}
//		for (int i=0; i<asm.formulaOffset.length; i++) {
//			asm.formulaSimple[i] = false;
//		}
		/* profiling */
		profilingData = new ProfilingData(asm.formulaOffset.length);
	}

	/**
	 * values for inputs without indizes, or with all '0' indizes.
	 * Those are NOT written into inputvalues, just into this "fast access" array.
	 */
	private V[] inputvalues0dim;

	/**
	 * HashMap<IntList, V> first value is inputid, then indizes follow.
	 *        The last index is >0 for sure,
	 *        minimum length of the int[] is 2 (otherwise the value lands in inputvalues0dim).
	 */
	private HashMap<IntList, V> inputvalues = new HashMap<IntList, V>(1024, 0.5f);

	public int getInputIndex(String nameUppercase) {
		Integer i = in.get(nameUppercase);
		return i!=null ? i : -1;
	}
	@Override
	public void reset() {
		inputvalues0dim = new V[asm.inputs.length];
		inputvalues     = new HashMap<IntList, V>(Math.max(inputvalues.size(),asm.inputs.length), 0.5f);
	}
	/* input calc names (e.g. visible) */   
	private HashMap<String,Integer> ic;
	
	private int getInputCalcIndex(final String nameUpper) {
		Integer ind = ic.get(nameUpper);
		return ind!=null ? ind : -1;
	}
	

	/**
	 * Get input as set from outside.
	 * Indizes are normalized by cutting of trailing zeros.
	 * @param inputid
	 * @param index
	 * @return null if notfound, the value as V otherwise
	 */
	@Override
	public V getInput(final int inputid, final V...index) throws ExceptionNeedMoreInput {
		final int indexlen = index!=null ? index.length : 0;
		if (indexlen==0) {
			final V ret = inputvalues0dim[inputid];
			if (ret!=null) {
				return ret;
			} else {
				throw new ExceptionNeedMoreInput(asm.inputs[inputid].name, inputid, (int[])null);
			}
		}
		int indNonZero=-1;
		int[] indarr = new int[indexlen];
		for (int i=0; i<indexlen; i++) {
			int ind = (int) index[i].longValue();
			if (ind>0) {
				indNonZero=i;
				indarr[i]=ind;
			}
		}
		if (indNonZero<0) {
			final V ret = inputvalues0dim[inputid];
			if (ret!=null) {
				return ret;
			} else {
				throw new ExceptionNeedMoreInput(asm.inputs[inputid].name, inputid, (int[])null);
			}
		}
		final V ret = inputvalues.get(new IntList(inputid, indarr, indNonZero+1));
		if (ret!=null) {
			return ret;
		} else {
			throw new ExceptionNeedMoreInput(asm.inputs[inputid].name, inputid, indarr);
		}
	}

	@Override
	public boolean getInputIsNull(String name) {
		final Object[] parsedname = parseSetvarName(name);
		if (parsedname==null) {
			return true;
		}
		final String justnameUpper = (String) parsedname[0];
		final int[]  index = (int[]) parsedname[1];
		final int inputid = getInputIndex(justnameUpper);
		if (inputid<0) {
			return true;
		}
		V[] vindex;
		if (index==null) {
			vindex = new V[0];
		} else {
			int indexlen = index.length;
			vindex = new V[indexlen];
			for (int i=0; i<indexlen; i++) {
				vindex[i] = V.getInstance(index[i]);
			}
		}
		try {
			getInput(inputid, vindex);
			return false;
		} catch (ExceptionNeedMoreInput e) {
			return true;
		}
	}

	@Override
	public V[] getAutocounterValues(int[] autocounters) {
		/* get values of active counters */
		int clen = autocounters.length;
		V[] valarr = new V[clen]; /* might be shortened afterwards */
		int valarrsize=0;
		int lastnotzero=-1;
		for (int i=0; i<clen; i++) {
			int c = autocounters[i];
			/* search appropriate active counter */
			for (int j=timesSize; --j>=0;) {
				long cand = timesStack[j];
				int  id = (int) cand;
				if (id==c) {
					int val = (int) (cand >> 32);
					if(val>0) {
						lastnotzero=valarrsize;
						valarr[valarrsize] = V.getInstance(val);
					} else {
						valarr[valarrsize] = VDouble.vdbl0;
					}
					valarrsize++;
					break;
				}
			}
		}
		if (lastnotzero+1<clen) {
			return Arrays.copyOf(valarr, lastnotzero+1);
		} else {
			return valarr;
		}
	}

	@Override
	public V getInputAutocounter(int inputid, int[] autocounters) {
		/* get values of active counters */
		int clen = autocounters.length;
		int[] valarr = new int[clen]; /* might be shortened afterwards */
		int valarrsize=0;
		int lastnotzero=-1;
		for (int i=0; i<clen; i++) {
			int c = autocounters[i];
			/* search appropriate active counter */
			for (int j=timesSize; --j>=0;) {
				long cand = timesStack[j];
				int  id = (int) cand;
				if (id==c) {
					int val = (int) (cand >> 32);
					if(val>0) {
						lastnotzero=valarrsize;
						valarr[valarrsize] = val;
					}
					valarrsize++;
					break;
				}
			}
		}
		if (lastnotzero<0) {
			final V ret = inputvalues0dim[inputid];
			if (ret!=null) {
				return ret;
			} else {
				throw new ExceptionNeedMoreInput(asm.inputs[inputid].name, inputid, (int[])null);
			}
		} else {
			final V ret = inputvalues.get(new IntList(inputid, valarr, lastnotzero+1));
			if (ret!=null) {
				return ret;
			} else {
				throw new ExceptionNeedMoreInput(asm.inputs[inputid].name, inputid, valarr);
			}
		}
	}

	@Override
	public void setInput(int inputid, V value, int...index) {
		if (!cacheEmpty) {
			initCache();
		}
		int indexlen = index.length;
		if (indexlen==0) {
			inputvalues0dim[inputid]=value;
		}
		int i;
		for (i=index.length; --i>=0; ) {
			int ind = index[i];
			if (ind>0) {
				break;
			}
		}
		if (i<0) {
			inputvalues0dim[inputid]=value;
			return;
		}
		inputvalues.put(new IntList(inputid, index, i+1), value);
	}

	@Override
	public void setInput(String name, String value) {
		if (!cacheEmpty) {
			initCache();
		}
		Object[] parsedname = parseSetvarName(name);
		if (parsedname==null) {
			return;
		}
		String justnameUpper = (String) parsedname[0];
		int[]  index = (int[]) parsedname[1];
		int inputid = getInputIndex(justnameUpper);
		if (index==null) {
			inputvalues0dim[inputid]=V.getInstance(value);
			return;
		}
		inputvalues.put(new IntList(inputid, index, index.length), V.getInstance(value));
	}

	@Override 
	public List<String[]> getInputList(int inputid, int...index) {
		if (index==null) {
			return calcInputList(inputid);
		}
		int indexlen = index.length;
		V[] vindex = new V[indexlen];
		for (int i=0; i<indexlen; i++) {
			vindex[i] = V.getInstance(index[i]);
		}
		return calcInputList(inputid, vindex);
	}
	/*
	 * name: inputname, case insensitive, optional with indizes in [] separted by ,
	 * e.g. A_Age, A_Age[5,3], A_Age[0, 00, 1]
	 */
	@Override
	public List<String[]> getInputList(String name) {
		Object[] parsedname = parseSetvarName(name);
		if (parsedname==null) {
			return null;
		}
		String justnameUpper = (String) parsedname[0];
		int[]  index = (int[]) parsedname[1];
		int inputid = getInputIndex(justnameUpper);
		return getInputList(inputid, index);
	}

	public String calculateMaintree(int calcindex, String...args) {
		int arglen = args!=null ? args.length : 0;
		if(arglen>0) {
			V[] argsV = new V[arglen];
			for (int i=0; i<arglen; i++) {
				argsV[i] = V.getInstance(args[i]);
			}
			return cmt(calcindex, argsV).stringValue();
		} else {
			return cmt(calcindex).stringValue();
		}
	}

	@Override
	public String calculateMaintree(String name) {
		Object[] parseRet = parseCalcname(name);
		String calcname = parseRet!=null ? (String) parseRet[0] : null;
		int calcindex = getCalcIndex(calcname);
		if(calcindex>=0) {
			return cmt(calcindex, (V[]) parseRet[1]).stringValue();
		} else {
			throw new ExceptionCalculation("invalid calculation name" + name, null);
		}
	}

	/**
	 * @param setvarname: name[index1;index2;index3;...;indexN]
	 * whitespaces enthalten -> diese sind dann TEIL DES NAMENS index :
	 * whitespaces vor index ok; nach index fehler; f�hrende 0 ok index
	 * weggelassen -> wie 0
	 * name[index1;...;indexN;0;...;0] -> wie name[index1;...;indexN]
	 * @return null on error or Object array of length 2
	 *    ret[0]: name without index, everything uppercase
	 *    ret[1]: int[] with normalized indizes, or null is there is none
	 */
	private static Object[] parseSetvarName(String setvarname) {
		/*  Examples
		 *   parseSetvarName("A_Test[3;5]") = "A_Test;3;5"
		 *   parseSetvarName("A_Test[ 03; 05; 00]") = "A_Test;3;5"
		 *   parseSetvarName("A_Test[0;0]") = "A_Test"
		 *   parseSetvarName("A_Test[0;0;1]") = "A_Test;;1"
		 *   parseSetvarName("A_Test[;;1]") = "A_Test;;1"
		 *
		 *   //A_Test[1]=ok
		 *   //A_Test[;1]=ok
		 *   //A_Test[1;;2]=ok
		 *   //A_Test=error
		 *   //A_Test =error
		 *   //A_Test [1]=error
		 *   //A_Test[1] =ok
		 *   //A_Test[ 1; 2]=ok
		 *   //A_Test[ 1 ; 2]=error
		 *   //A_Test[ 1;;]=ok
		 *   //A_Test[  ;;2]=ok
		 *   //A_Test[  ;  ; 2]=ok
		 *   //A_Test[  ;  ; ]=ok
		 *   //A_Test[+1]=error
		 *   //A_Test[001]=ok
		 *
		 */
		if (setvarname == null) {
			return new Object[] { "", null };
		}
		int slen = setvarname.length();
		if (slen == 0) {
			return new String[] { "", null };
		}
		int indStartBracket = setvarname.indexOf('[');
		/* no opening bracket -> everything is the name */
		if (indStartBracket<0) {
			String ret = setvarname.toUpperCase();
			return new Object[] { ret, null };
		}
		/* name: everything up to '[' */
		String name = setvarname.substring(0, indStartBracket).toUpperCase();

		int[] ind = new int[10];
		// start parsing after initial '['
		StringCharacterIterator i = new StringCharacterIterator(setvarname, indStartBracket+1);
		char c = i.current();
		int lastNotZero = -1;
		// get arguments
		for (int indind=0; c != StringCharacterIterator.DONE; indind++) {
			while (c==' ' || c=='\t' || c=='\f' || c=='\r' || c=='\n') { //eat whitespaces
				c = i.next();
			}
			int index = 0;
			loop1: while(true) {
				switch(c) {
				case '0': index*=10; break;
				case '1': index*=10; index+=1; break;
				case '2': index*=10; index+=2; break;
				case '3': index*=10; index+=3; break;
				case '4': index*=10; index+=4; break;
				case '5': index*=10; index+=5; break;
				case '6': index*=10; index+=6; break;
				case '7': index*=10; index+=7; break;
				case '8': index*=10; index+=8; break;
				case '9': index*=10; index+=9; break;
				default: break loop1;
				}
				c = i.next();
			}
			if (index>0) {
				lastNotZero = indind;
				if (indind>ind.length) {
					ind = Arrays.copyOf(ind, indind*2);
				}
				ind[indind] = index;
			}
			if (c != ';' && c!=',') {
				break;
			}
			c = i.next();
		}
		if (c != ']') {
			return null;
		}
		c = i.next();
		while (c==' ' || c=='\t' || c=='\f' || c=='\r' || c=='\n') {
			c = i.next();
		}
		if (c != StringCharacterIterator.DONE) {
			return null;
		}
		if (lastNotZero<0) {
			return new Object[] { name, null };
		}
		int[] ret = Arrays.copyOf(ind, lastNotZero+1);
		return new Object[] { name, ret };
	}

	private static class IntList {
		long key;
		int[] vals;
		int keylen;
		IntList(int ikey, int[] vals, int len) {
			if (len<=0) {
				this.key = ikey;
				return;
			}
			this.key = (long) ikey << 32 + vals[0];
			if (len>1) {
				keylen = len-1;
				int[] v = new int[keylen];
				System.arraycopy(vals, 1, v, 0, keylen);
				this.vals = v;
			}
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (int) (key ^ (key >>> 32));
			result = prime * result + keylen;
			result = prime * result + Arrays.hashCode(vals);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			IntList other = (IntList) obj;
			if (key != other.key)
				return false;
			if (keylen != other.keylen)
				return false;
			if (!Arrays.equals(vals, other.vals))
				return false;
			return true;
		}
	}

	private static char getInteger(CharacterIterator i, char c, StringBuffer token) {
		if (!Character.isDigit(c)) {
			throw new ExceptionCalculation("invalid argument: digit expected instead of '" + c + "'", null);
		}
		while (Character.isDigit(c)) {
			token.append(c);
			c=i.next();
		}
		return c;
	}

	private static char getExponent(CharacterIterator i, char c, StringBuffer token) {
		// EXPONENT => e[-]?[0-9]+
		if (c!='e' && c!='E')
			throw new ExceptionCalculation("invalid argument: exponent 'E' expected instead of '" + c + "'", null);
		token.append('e');
		c=i.next();
		if (c=='-') {
			token.append('-');
			c=i.next();
		}
		return getInteger(i, c, token);
	}

	/**
	 * @param calcname: F_Test, F_Test(1, 2), A_Test[5], A_Test[5].visible, T_Table[3, 5], T_Table[3].text 
	 * @return  Object[5]:
	 *          [0]: String nameUppercase + ':' + args.length
	 *          [1]: V[] args
	 *          [2]: nameUppercase
	 *          [3]: String calcnameUppercase (or null)
	 *          [4]: Integer type - 0:no parens, 1:(), 2:[]
	 */
	public static Object[] parseCalcname(String calcname) {
		if (calcname == null || calcname.length() == 0) {
			return null;
		}
		char c;
		List<V> arg=null;
		StringBuffer token;
		StringCharacterIterator i = new StringCharacterIterator(calcname);
		int type = 0; // 0: no parenthesis; 1:function; 2:table
		token = new StringBuffer(30);
		/* skip leading whitespaces */
		c = i.first();
		while (Character.isWhitespace(c)) {
			c = i.next();
		}
		int inddot=-1;
		while (!(c == '(' || c == '[' || Character.isWhitespace(c) || c == StringCharacterIterator.DONE)) {
			token.append(Character.toUpperCase(c));
			if (c=='.') {
				inddot=i.getIndex();
			}
			c = i.next();
		}
		String name = token.toString();

		/* eat whitespaces before '(' */
		while (Character.isWhitespace(c)) {
			c = i.next();
		}

		/* eat (|[ */
		if (c == '(') {
			type = 1; // function with parameters
			c = i.next();
		} else if (c == '[') { // table access
			type = 2;
			c = i.next();
		} else { 
			type = 0; // no arguments
		}
		while (Character.isWhitespace(c)) {
			c = i.next();
		}
		if (type==0 && c!=StringCharacterIterator.DONE) {
			return null;
		}
		boolean first=true;
		/* get arguments */
		while (c != StringCharacterIterator.DONE) {
			token = new StringBuffer(5);
			/* are at beginning of next argument */
			while (Character.isWhitespace(c)) {
				c = i.next();
			}
			if ((type==1 && c==')') || (type==2 && c==']')) {
				break;
			}
			if (!first && (c==',' || c==';')) {
				c=i.next();
				while (Character.isWhitespace(c)) {
					c = i.next();
				}
			}

			first=false;
			if (c == '"') {
				c = i.next();
				while (true) {
					if (c == '"') {
						c = i.next();
						if (c == '"') {
							token.append(c);
							c = i.next();
						} else {
							break;
						}
					} else {
						if (c==StringCharacterIterator.DONE) {
							return null;
						}
						token.append(c);
						c = i.next();
					}
				}
				if (arg==null) {
					arg = new ArrayList<V>(3);
				}
				arg.add(V.getInstance(token.toString()));
				token = new StringBuffer(5); // 5 as this is called after the name only -> indizes will follow, those are short
			} else {
				//  -?{INTEGER}
				//  -?{INTEGER}[.,]?{EXPONENT}
				//  -?{INTEGER}[.,]{INTEGER}{EXPONENT}?
				//  -?[.,]{INTEGER}{EXPONENT}?     ohne - mit .: gef�hrlicher Fall
				if (c=='-') {
					//gotMinus=true;
					token.append(c);
					c=i.next();
				}
				if (c==',' || c=='.') {
					//  [.,]{INTEGER}{EXPONENT}?
					token.append('.');
					c=i.next();
					c=getInteger(i, c, token);
					if(c=='e' || c=='E')
						c=getExponent(i, c, token);

					if (arg==null) {
						arg = new ArrayList<V>(3);
					}
					arg.add(V.getInstance(token.toString()));
					token = new StringBuffer(5); // 5 as this is called after the name only -> indizes will follow, those are short
				}
				else {
					//  {INTEGER}
					//  {INTEGER}[.,]?{EXPONENT}
					//  {INTEGER}[.,]{INTEGER}{EXPONENT}?
					boolean done=false;
					if (!Character.isDigit(c))
						return null;
					c = getInteger(i, c, token);
					if (c=='.' || c==',') {
						// special Case: {INTEGER} gefolgt von ',' als Parameter-Trennzeichen
						//  {INTEGER}[.,]{EXPONENT}
						//  {INTEGER}[.,]{INTEGER}{EXPONENT}?
						if (c==',') {
							c=i.next();
							if (!Character.isDigit(c) && c!='e' && c!='E') {
								done=true;
								if (arg==null) {
									arg = new ArrayList<V>(3);
								}
								arg.add(V.getInstance(token.toString()));
								token = new StringBuffer(5); // 5 as this is called after the name only -> indizes will follow, those are short
							}
							c=i.previous();
						}
						if (!done) {
							token.append('.');
							c=i.next();
							if (c=='e' || c=='E') {
								c = getExponent(i, c, token);
								if (arg==null) {
									arg = new ArrayList<V>(3);
								}
								arg.add(V.getInstance(token.toString()));
								token = new StringBuffer(5); // 5 as this is called after the name only -> indizes will follow, those are short
							} else if (Character.isDigit(c)) {
								c = getInteger(i, c, token);
								if (c=='e' || c=='E')
									c = getExponent(i, c, token);
								if (arg==null) {
									arg = new ArrayList<V>(3);
								}
								arg.add(V.getInstance(token.toString()));
								token = new StringBuffer(5); // 5 as this is called after the name only -> indizes will follow, those are short
							} else
								return null;

						}
					} else if (c=='e' || c=='E'){
						//  {INTEGER}{EXPONENT}
						c = getExponent(i, c, token);
						if (arg==null) {
							arg = new ArrayList<V>(3);
						}
						arg.add(V.getInstance(token.toString()));
						token = new StringBuffer(5); // 5 as this is called after the name only -> indizes will follow, those are short
					} else { 
						//  {INTEGER}
						if (arg==null) {
							arg = new ArrayList<V>(3);
						}
						arg.add(V.getInstance(token.toString()));
						token = new StringBuffer(5); // 5 as this is called after the name only -> indizes will follow, those are short
					}
				}
			} // end of parsing one argument

			while (Character.isWhitespace(c)) {
				c = i.next();
			}
		}

		if (type==1 || type==2) {
			if (type==1 && c!=')') {
				throw new ExceptionCalculation ("')' missing", null);
			}
			if (type==2 && c!=']') {
				throw new ExceptionCalculation ("']' missing", null);
			}
			c=i.next();
		}

		while (Character.isWhitespace(c)) {
			c = i.next();
		}

		String subcalcname = null;
		if (c=='.') {
			subcalcname = calcname.substring(i.getIndex()+1).toUpperCase();
			c = StringCharacterIterator.DONE;
		}

		if (c!=StringCharacterIterator.DONE) {
			return null;
		}

		V[] args;
		if (arg==null) {
			args = new V[0];
		} else {
			args = arg.toArray(new V[0]);
		}
		if (inddot>=0 && type==0) {
			subcalcname = name.substring(inddot+1);
			name = name.substring(0, inddot);
		}
		Object[] ret = new Object[] { name+':'+args.length, args, name, subcalcname, type };
		return ret;
	}
	/**
	 * left  32bit: counter
	 * right 32bit: timesid 
	 */
	//0: CURRENT_A_LI_MAINLAYERS
	//1: CURRENT_A_LI_RIDERS
	private long[] timesStack = new long[10];
	private int    timesLen   = 10;
	private int    timesSize  = 0;
	@Override
	public void pushTimesCounter(int timesid) {
		long newval = timesid;
		if (timesLen<=timesSize) {
			timesLen <<= 1;
			timesStack = Arrays.copyOf(timesStack, timesLen);
		}
		timesStack[timesSize++] = newval;
	}

	@Override
	public void incTimesCounterTop() {
		timesStack[timesSize-1] += 0x100000000L;
	}

	@Override
	public void setTimesCounterTop(int value) {
		int i = timesSize-1;
		int counterid = (int) timesStack[i];
		long newval = ((long)value<<32) + counterid;
		timesStack[i] = newval;
	}

	@Override
	public void popTimesCounter() {
		timesSize--;
	}

	@Override
	public int getTimesCounter(int timesid) {
		for (int i=timesSize; --i>=0;) {
			long cand = timesStack[i];
			int  id = (int) cand;
			if (id==timesid) {
				return (int) (cand >> 32);
			}
		}
		return 0;
	}

	@Override
	public V getTimesCounterV(int timesid) {
		for (int i=timesSize; --i>=0;) {
			long cand = timesStack[i];
			int  id = (int) cand;
			if (id==timesid) {
				int val = (int) (cand >> 32);
				return V.getInstance(val);
			}
		}
		return VDouble.vdbl0;
	}

	public V getTimesCounterVException(int timesid) {
		for (int i=timesSize; --i>=0;) {
			long cand = timesStack[i];
			int  id = (int) cand;
			if (id==timesid) {
				int val = (int) (cand >> 32);
				return V.getInstance(val);
			}
		}
		return B.bf_error(V.getInstance("counter with id " + timesid + " not active."));
	}
	
	public static class CacheKey {
		private final int id;
		private final V[] args;
		private final long[] counters;
		public CacheKey(int id, V[] args, long[] counters) {
			this.id = id;
			this.args = args;
			this.counters = counters;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Arrays.hashCode(args);
			result = prime * result + Arrays.hashCode(counters);
			result = prime * result + id;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;			}
			if (!(obj instanceof CacheKey)) {
				return false;
			}
			CacheKey other = (CacheKey) obj;
			if (id != other.id) {
				return false;
			}
			if (!Arrays.equals(args, other.args)) {
				return false;
			}
			if (!Arrays.equals(counters, other.counters)) {
				return false;
			}
			return true;
		}
		@Override
		public String toString() {
			return "CacheKey [id=" + id + ", args=" + Arrays.toString(args)
					+ (counters!=null ? ", counters=" + Arrays.toString(counters) : "") + "]";
		}
	}

	private static class LruCache<Key,Value> extends LinkedHashMap<Key, Value> {
		private static final long serialVersionUID = 1L;
		private final int lrucachesize;
		private final int maxsize; 
		public LruCache(int lrucachesize, float loadFactor) {
			super(lrucachesize, loadFactor, true);
			this.lrucachesize = lrucachesize;
			this.maxsize = (int) (lrucachesize * loadFactor) - 2;
		}
		protected boolean removeEldestEntry(Map.Entry<Key, Value> eldest) {
			return size() >= maxsize;
		}
	}

	private void initCache() {
		cache = new LruCache<Object,V>(maxcachesize, 0.5f);
		cacheEmpty = true;
	}

	private boolean cacheEmpty;
	private LruCache<Object,V> cache;
	{
		initCache();
	}

	@Override
	public Object getCacheKey(final int id, final V...args) {
		return new CacheKey(id, args, timesSize==0 ? null : Arrays.copyOf(timesStack, timesSize));
	}

	@Override
	public V readCache(final Object key) {
		return cache.get(key);
	}

	@Override
	public void writeCache(final Object key, final V value) {
		cache.put(key, value);
		cacheEmpty = false;
	}

	@Override
	public String calculateInput(final String name) {
		final Object[] parsedname = parseSetvarName(name);
		if (parsedname==null) {
			return null;
		}
		final String justnameUpper = (String) parsedname[0];
		final int[]  index = (int[]) parsedname[1];
		final int inputid = getInputIndex(justnameUpper);
		if (inputid<0) {
			throw new ExceptionCalculation("Invalid inputname " + name, name);
		}
		V[] vindex;
		if (index==null) {
			vindex = new V[0];
		} else {
			int indexlen = index.length;
			vindex = new V[indexlen];
			for (int i=0; i<indexlen; i++) {
				vindex[i] = V.getInstance(index[i]);
			}
		}
		final V ret = calcInputAccess(inputid, vindex);
		return ret.stringValue();
	}

	@Override
	public String calculateInputCalc(String name, String calcname) {
		final Object[] parsedname = parseSetvarName(name);
		if (parsedname==null) {
			return null;
		}
		final String justnameUpper = (String) parsedname[0];
		final int[]  index = (int[]) parsedname[1];
		final int inputid = getInputIndex(justnameUpper);
		V[] vindex;
		if (index==null) {
			vindex = new V[0];
		} else {
			int indexlen = index.length;
			vindex = new V[indexlen];
			for (int i=0; i<indexlen; i++) {
				vindex[i] = V.getInstance(index[i]);
			}
		}
		final int inputcalcid = getInputCalcIndex(calcname.toUpperCase());
		if (inputcalcid<0) {
			throw new ExceptionCalculation("invalid calcname " + calcname, null);
		}
		final V ret = calcInputCalc(inputid, inputcalcid, vindex);
		return ret.stringValue();
	}

	@Override
	public String calculateFunction(String name) {
		Object[] parseRet = parseCalcname(name);
		String funcnameUpper = (String) parseRet[2];
		V[] vargs = (V[]) parseRet[1];
		int funcindex = getFuncIndex(funcnameUpper);
		return calcFunc(funcindex, vargs).stringValue();
	}

	@Override
	public String calculateTable(String name) {
		Object[] parseRet = parseCalcname(name);
		String tabnameUpper = (String) parseRet[2];
		V[] vargs = (V[]) parseRet[1];
		String colname = (String) parseRet[3];
		final V ret;
		if (colname==null) {
			ret = tabaccessCallExact(tabnameUpper, vargs); 
		} else {
			ret = tabaccessCallExactCol(
					tabnameUpper, 
					colname,
					vargs
					);
		}
		return ret.stringValue();
	}
	@Override
	public long getCalculateId(String name) {
		/* <0 if notfound, id to be used with calculate(int id,...) otherwise
		 * high int: index; low int: lowest bits encode what it is, higher bits have additional index if necessary
		 * calcindex     000.....000: calc  (number of arguments is fixed to the number of arguments we got in name!)
		 * inputindex    000.....001: input 
		 * inpid         calcid..010: input-calc
		 * funcid        000.....011: func
		 * tabid         000.....100: table
		 * tabid         colind..101: table-col
		 */
		Object[] parseRet = parseCalcname(name);
		String nameWithParamcounter = (String) parseRet[0];
//		V[] args = (V[]) parseRet[1];
		String nameUpper = (String) parseRet[2];
		String calcnameUppercase = (String) parseRet[3];
		int type = (Integer) parseRet[4];
		switch (type) {
		case 0: { //calc without parameters or input or function without parameters
			if (calcnameUppercase==null) {
				/* calc? */
				final int calcindex = getCalcIndex(nameWithParamcounter);
				if (calcindex>=0) {
					return ((long)calcindex<<32) + 0L;
				}
				/* input? */
				final int inputindex = getInputIndex(nameUpper);
				if (inputindex>=0) {
					return ((long)inputindex<<32) + 1L;
				}
				/* function? */
				final int funcindex = getFuncIndex(nameUpper);
				if (funcindex>=0) {
					return ((long)funcindex<<32) + 3L;
				}
				/* table? */
				final int tabindex = getTableid(nameUpper);
				if (tabindex>=0) {
					return ((long)tabindex<<32) + 4L;
				}
				/* calc with number of parameters (:numparam)? */
				final int calcindex2 = getCalcIndex(nameUpper);
				if (calcindex2>=0) {
					return ((long)calcindex2<<32) + 0L;
				}
			} else {
				/* input-calc */
				final int inputindex = getInputIndex(nameUpper);
				if (inputindex>=0) {
					final int inputcalcid = getInputCalcIndex(calcnameUppercase);
					if (inputcalcid>=0) {
						return ((long)inputindex<<32)
								+ (long) ((int)(inputcalcid<<3)) //make sure it doesn't shift into inputindex 
								+ 2L;
					}
				}
				final int tabindex = getTableid(nameUpper);
				if (tabindex>=0) {
					int colind = tabaccessCallColindex(
							tabindex, 
							calcnameUppercase
							);
					return ((long)tabindex<<32)
							+ (long) ((int)(colind<<3)) //make sure it doesn't shift into inputindex 
							+ 5L;
				}
			}
			break;
		}
		case 1: { //calc or function
			/* calc? */
			if (calcnameUppercase!=null) {
				break;
			}
			final int calcindex = getCalcIndex(nameWithParamcounter);
			if (calcindex>=0) {
				return ((long)calcindex<<32) + 0L;
			}
			/* function? */
					final int funcindex = getFuncIndex(nameUpper);
					if (funcindex>=0) {
						return ((long)funcindex<<32) + 3L;
					}
					break;
		}
		case 2: { //input or table
			if (calcnameUppercase==null) {
				final int inputindex = getInputIndex(nameUpper);
				if (inputindex>=0) {
					return ((long)inputindex<<32) + 1L;
				}
				final int tabindex = getTableid(nameUpper);
				if (tabindex>=0) {
					return ((long)tabindex<<32) + 4L;
				}
				break;
			} else {
				final int inputindex = getInputIndex(nameUpper);
				if (inputindex>=0) {
					final int inputcalcid = getInputCalcIndex(calcnameUppercase);
					if (inputcalcid>=0) {
						return inputindex + inputcalcid;
					}
					break;
				}
				final int tabindex = getTableid(nameUpper);
				if (tabindex>=0) {
					int colind = tabaccessCallColindex(
							tabindex, 
							calcnameUppercase
							);
					return ((long)tabindex<<32)
							+ (long) ((int)(colind<<3)) //make sure it doesn't shift into inputindex 
							+ 5L;
				}
			}
		} //end of case 2
		} //end of switch
		throw new ExceptionCalculation("invalid calculation string '" + name + "'", null);
	}
	@Override
	public String calculate(String name) {
		Object[] parseRet = parseCalcname(name);
		String nameWithParamcounter = (String) parseRet[0];
		V[] args = (V[]) parseRet[1];
		String nameUpper = (String) parseRet[2];
		String calcnameUppercase = (String) parseRet[3];
		int type = (Integer) parseRet[4];
		switch (type) {
		case 0: { //calc without parameters or input or function without parameters
			if (calcnameUppercase==null) {
				/* calc? */
				final int calcindex = getCalcIndex(nameWithParamcounter);
				if (calcindex>=0) {
					return cmt(calcindex, args).stringValue();
				}
				/* input? */
				final int inputindex = getInputIndex(nameUpper);
				if (inputindex>=0) {
					return calcInputAccess(inputindex, args).stringValue();
				}
				/* function? */
				final int funcindex = getFuncIndex(nameUpper);
				if (funcindex>=0) {
					return calcFunc(funcindex, args).stringValue();
				}
			} else {
				/* input-calc */
				final int inputindex = getInputIndex(nameUpper);
				if (inputindex<0) {
					break;
				}
				final int inputcalcid = getInputCalcIndex(calcnameUppercase);
				if (inputcalcid<0) {
					break;
				}
				return calcInputCalc(inputindex, inputcalcid, args).stringValue();
			}
			break;
		}
		case 1: { //calc or function
			/* calc? */
			if (calcnameUppercase!=null) {
				break;
			}
			final int calcindex = getCalcIndex(nameWithParamcounter);
			if (calcindex>=0) {
				return cmt(calcindex, args).stringValue();
			}
			/* function? */
					final int funcindex = getFuncIndex(nameUpper);
					if (funcindex>=0) {
						return calcFunc(funcindex, args).stringValue();
					}
					break;
		}
		case 2: { //input or table
			if (calcnameUppercase==null) {
				final int inputindex = getInputIndex(nameUpper);
				if (inputindex>=0) {
					return calcInputAccess(inputindex, args).stringValue();
				}
				final int tabindex = getTableid(nameUpper);
				if (tabindex>=0) {
					return tabaccessCallExact(tabindex, args).stringValue();
				}
				break;
			} else {
				final int inputindex = getInputIndex(nameUpper);
				if (inputindex>=0) {
					final int inputcalcid = getInputCalcIndex(calcnameUppercase);
					if (inputcalcid<0) {
						break;
					}
					return calcInputCalc(inputindex, inputcalcid, args).stringValue();
				}
				final int tabindex = getTableid(nameUpper);
				if (tabindex>=0) {
					return tabaccessCallExactCol(
							tabindex,
							calcnameUppercase,
							args).stringValue();
				}
			}
		} //end of case 2
		} //end of switch
		throw new ExceptionCalculation("invalid calculation string '" + name + "'", null);
	}
	@Override
	public String calculate(long id) {
		return calculate(id, (int[]) null);
	}
	@Override
	public String calculate(long id, String... args) {
		V[] vargs;
		if (args==null) {
			vargs = new V[0];
		} else {
			final int len = args.length;
			vargs = new V[args.length];
			for (int i=0; i<len; i++) {
				vargs[i] = V.getInstance(args[i]);
			}
		}
		int index = (int) (id>>32);
		int lowint  = (int) id;
		int whatitis = lowint & 0x7;
		switch (whatitis) {
		case 0: { //calcindex     000.....000: calc
			return cmt(index, vargs).stringValue();
		}
		case 1: { // inputindex    000.....001: input
			return calcInputAccess(index, vargs).stringValue();
		}
		case 2: { // inpid         calcid..010: input-calc
			final int calcid = lowint >> 3;
			return calcInputCalc(index, calcid, vargs).stringValue();
		}
		case 3:  { //funcid        000.....011: func
			return calcFunc(index, vargs).stringValue();
		}
		case 4:  { //tabid         000.....100: table
			return tabaccessCallExact(index, vargs).stringValue();
		}
		case 5: { //tabid         colind..101: table-col
			final int colind = lowint >> 3;
								return tabaccessCallExactColind(
										index,
										colind,
										vargs
										).stringValue();
		}
		}
		throw new ExceptionCalculation("invalid calculation id: " + id, null);
	}
	@Override
	public String calculate(long id, int... args) {
		V[] vargs;
		if (args==null) {
			vargs = new V[0];
		} else {
			final int len = args.length;
			vargs = new V[args.length];
			for (int i=0; i<len; i++) {
				vargs[i] = V.getInstance(args[i]);
			}
		}
		int index = (int) (id>>32);
		int lowint  = (int) id;
		int whatitis = lowint & 0x7;
		switch (whatitis) {
		case 0: { //calcindex     000.....000: calc
			return cmt(index, vargs).stringValue();
		}
		case 1: { // inputindex    000.....001: input
			return calcInputAccess(index, vargs).stringValue();
		}
		case 2: { // inpid         calcid..010: input-calc
			final int calcid = lowint >> 3;
			return calcInputCalc(index, calcid, vargs).stringValue();
		}
		case 3:  { //funcid        000.....011: func
			return calcFunc(index, vargs).stringValue();
		}
		case 4:  { //tabid         000.....100: table
			return tabaccessCallExact(index, vargs).stringValue();
		}
		case 5: { //tabid         colind..101: table-col
			final int colind = lowint >> 3;
					return tabaccessCallExactColind(
							index,
							colind,
							vargs
							).stringValue();
		}
		}
		throw new ExceptionCalculation("invalid calculation id: " + id, null);
	}
	@Override
	public boolean needed(String inputname, String calcname) {
		final Object[] parsedname = parseSetvarName(inputname);
		if (parsedname==null) {
			return false;
		}
		final String justnameUpper = (String) parsedname[0];
		int[] index = (int[]) parsedname[1];
		if (index==null) {
			index = new int[0];
		}
		final int inputid = getInputIndex(justnameUpper);
		if (inputid<0) {
			throw new ExceptionCalculation("Invalid inputname " + inputname, inputname);
		}
		int indexlen = index.length;
		V[] vindex = new V[indexlen];
		for (int i=0; i<indexlen; i++) {
			vindex[i] = V.getInstance(index[i]);
		}
		V value = getInput(inputid, vindex);
		setInput(inputid, null, index); // set to undefined
		boolean needed = false;
		try {
			calculate(calcname);
			needed = false;
		} catch (ExceptionNeedMoreInput e) {
			needed = true;
			String inputnameNeeded = e.getInputname();
			if (inputnameNeeded.equalsIgnoreCase(justnameUpper)) {
				int[] indexNeeded = e.getIndex();
				int neededLen = indexNeeded!=null ? indexNeeded.length : 0;
				if (neededLen==indexlen) {
					for (int i=0; i<indexlen; i++) {
						if (indexNeeded[i]!=index[i]) {
							needed = false;
							break;
						}
					}
				} else if (neededLen<indexlen) {
					for (int i=0; i<neededLen; i++) {
						if (indexNeeded[i]!=index[i]) {
							needed = false;
							break;
						}
					}
					for (int i=neededLen; i<indexlen; i++) {
						if (index[i]!=0) {
							needed = false;
							break;
						}
					}
				} else if (neededLen>indexlen) {
					for (int i=0; i<indexlen; i++) {
						if (indexNeeded[i]!=index[i]) {
							needed = false;
							break;
						}
					}
					for (int i=indexlen; i<neededLen; i++) {
						if (indexNeeded[i]!=0) {
							needed = false;
							break;
						}
					}
				}
			}
		}
		setInput(inputid, value, index); // set to original value
		return needed;
	}

	private HashMap<String,S> submodels = new HashMap<String,S>();
	public S getSubmodel(String vpmname) {
		S submodel = submodels.get(vpmname);
		if (submodel!=null) {
			return submodel;
		}
		String modelname = new File(vpmname).getName().toLowerCase();
		int ind = modelname.lastIndexOf('.');
		if (ind>0) {
			modelname = modelname.substring(0, ind);
		}
		modelname = modelname.replaceAll("\\W", "_");
		String filename = modelname + ".tci";
		try {
			Asm asmsub = TciAsmReaderWriter.read(filename);
			submodel = new TciMachine(asmsub);
			submodels.put(vpmname,  submodel);
			return submodel;
		} catch (IOException e) {
		}
		return null;
	}
	
	private List<String[]> calcInputList(int inputid, V...args) {
		Input input = asm.inputs[inputid];
		if (input.formulaVector>=0) {
			V vlist = run(INSTR_GETINPUTCALC, inputid, INPUTCALC_VECTOR, args.length, 0, args);
			if (vlist instanceof VList) {
				final List<V> olist = vlist.listValue();
				final int len = olist.size();
				final ArrayList<String[]> ret = new ArrayList<String[]>(len);
				for (V elem : olist) {
					final List<V> ilist = elem.listValue();
					final String key = ilist.get(0).stringValue();
					final String value = ilist.get(1).stringValue();
					ret.add(new String[] { key, value });
				}
				return ret;
			} else {
				return new ArrayList<String[]>(0);
			}
		} else if (input.formulaReference>=0) {
			final V submodelname = run(INSTR_GETINPUTCALC, inputid, INPUTCALC_REFERENCE, args.length, 0, args);
			S sub = this.getSubmodel(submodelname.stringValue());
			if (sub==null) {
				return new ArrayList<String[]>(0);
			}
			final List<String[]> list = sub.getInputList(input.name + (args.length>0 ? Arrays.toString(args) : "")); 
			if (input.formulaFilter<0 && input.formulaDisplaytext<0) {
				return list;
			} else {
				final int len = list.size();
				final ArrayList<String[]> ret = new ArrayList<String[]>(len);
				for (int indrow=0; indrow<len; indrow++) {
					final String[] keyvalue = list.get(indrow);
					final String key = keyvalue[0];
					final V vkey = V.getInstance(key);
					if (input.formulaFilter>=0) {
		            	V[] argsfilter = new V[3];
						switch(args.length) {
						case 0: argsfilter[0] = VDouble.vdbl0; argsfilter[1] = VDouble.vdbl0; break;
						case 1: argsfilter[0] = V.getInstance(args); argsfilter[1] = VDouble.vdbl0; break;
						default: argsfilter[0] = V.getInstance(args); argsfilter[1] = args[1]; 
						}
						argsfilter[2] = vkey;
						final V resultfilter = run(INSTR_CALLFORMULA, input.formulaFilter, 3, 0, 0, argsfilter);
						if (!resultfilter.booleanValue()) {
							continue;
						}
						V text = V.getInstance(keyvalue[1]);
						if (input.formulaDisplaytext>=0) {
			            	V[] argsdt = new V[4];
							switch(args.length) {
							case 0: argsdt[0] = VDouble.vdbl0; argsdt[1] = VDouble.vdbl0; break;
							case 1: argsdt[0] = V.getInstance(args); argsdt[1] = VDouble.vdbl0; break;
							default: argsdt[0] = V.getInstance(args); argsdt[1] = args[1]; 
							}
							argsdt[2] = vkey;
							argsdt[3] = text;
							V vdisplaytext = run(INSTR_CALLFORMULA, input.formulaDisplaytext, 4, 0, 0, argsdt);
							if (vdisplaytext!=null && vdisplaytext!=VNull.vnull) {
								text = vdisplaytext;
							}
						}
					}
				}
				return ret;
			}
		} else if (input.formulaTable>=0) {
		      final V vtabname = run(INSTR_GETINPUTCALC, inputid, INPUTCALC_TABLE, args.length, 0, args);
              Integer tabind = tn.get(vtabname.stringValue().toUpperCase());
              if (tabind==null) {
            	  return new ArrayList<String[]>(0);
              }
              Table table = asm.tables[tabind];
              int coltext;
              if (input.formulaDisplay>=0) {
	  		      final V vcolname = run(INSTR_GETINPUTCALC, inputid, INPUTCALC_DISPLAY, args.length, 0, args);
	  		      coltext = TciMachineTabaccess.getColindex(table, vcolname.stringValue());
	  		      if (coltext<0) {
	  		    	  coltext=1;
	  		      } 
              } else {
            	  coltext = 1;
              }
              V vlist = TciMachineTabaccess.getCells(table, V.getInstance(1), V.getInstance(table.rows), V.getInstance(1), V.getInstance(table.cols));
		      if (vlist instanceof VList) {
		         final List<V> olist = vlist.listValue();
		         final int len = olist.size();
		         final ArrayList<String[]> ret = new ArrayList<String[]>(len);
		         for (V elem : olist) {
		            final List<V> ilist = elem.listValue();
		            final V vkey = ilist.get(0);
		            if (input.formulaFilter>=0) {
		            	V[] argsfilter = new V[3];
						switch(args.length) {
						case 0: argsfilter[0] = VDouble.vdbl0; argsfilter[1] = VDouble.vdbl0; break;
						case 1: argsfilter[0] = V.getInstance(args); argsfilter[1] = VDouble.vdbl0; break;
						default: argsfilter[0] = V.getInstance(args); argsfilter[1] = args[1]; 
						}
						argsfilter[2] = vkey;
						final V resultfilter = run(INSTR_CALLFORMULA, input.formulaFilter, 3, 0, 0, argsfilter);
						if (!resultfilter.booleanValue()) {
							continue;
						}
		            }
		            final String key = vkey.stringValue();
		            V vvalue = ilist.get(coltext);
		            if (input.formulaDisplaytext>=0) {
		            	V[] argsdt = new V[4];
						switch(args.length) {
						case 0: argsdt[0] = VDouble.vdbl0; argsdt[1] = VDouble.vdbl0; break;
						case 1: argsdt[0] = V.getInstance(args); argsdt[1] = VDouble.vdbl0; break;
						default: argsdt[0] = V.getInstance(args); argsdt[1] = args[1]; 
						}
						argsdt[2] = vkey;
						argsdt[3] = vvalue;
						V vdisplaytext = run(INSTR_CALLFORMULA, input.formulaDisplaytext, 4, 0, 0, argsdt);
						if (vdisplaytext!=null && vdisplaytext!=VNull.vnull) {
							vvalue = vdisplaytext;
						}
		            }
		            final String value = vvalue.stringValue();
		            ret.add(new String[] { key, value });
		         }
		         return ret;
		      } else {
		    	  return new ArrayList<String[]>(0);
		      }
		} else {
			return new ArrayList<String[]>(0);
		}
	}
	/**
	 * Calculate main tree
	 * @param calcindex
	 * @param args
	 * @return sum of all active calcs, computation starts in the root node 
	 */
	private V cmt(int calcindex, V...args)  {
		Calc calc = asm.calcs[calcindex];
		int nargs = calc.nargs;
		if (nargs!=args.length) {
			throw new ExceptionCalculation("Calc " + calc.name + " expects " + nargs + " arguments, but got just " + args.length + ", please check the interface call.", null);
		}                 
		int nodeid = calc.rootaccessNode;
		if (calc.rootaccessSum) {
//			V[] a = new V[5];
//			a[0] = V.getInstance(args);
//			a[1] = V.getInstance(nodeid);
//			a[2] = V.getInstance(calcindex);
//			a[3] = V.getInstance(args.length);
//			a[4] = VDouble.vdbl1;
//			return run(INSTR_CALLFORMULA, asm.formulaMaxvar.length-1, a.length, 0, 0, a);
			return run(INSTR_CALLNODECALCSUM, nodeid, calcindex, nargs, 1, args);
		} else {
//			Node node = asm.nodes[nodeid];
//			NodeCalc nodecalc = node.nodecalcList[calcindex];
//			int formula = nodecalc.formula;
//			int start = asm.formulaOffset[formula];
			return run(INSTR_CALLNODECALC, nodeid, calcindex, nargs, 0, args);
		}
	}
	private int getCalcIndex(String calcnameUppercase) {
		Integer calcindex = cni.get(calcnameUppercase);
		return calcindex!=null ? calcindex : -1;
	}
	private V calcInputAccess(int inputid, V...args) {
		return run(INSTR_GETINPUT, inputid, args.length, 0, 0, args);
	}
	private V calcInputCalc(int inputid, int inputcalc, V...args) {
		return run(INSTR_GETINPUTCALC, inputid, inputcalc, args.length, 0, args);
	}
	private V calcFunc(int funcindex, V[] vargs) {
		Func func = asm.funcs[funcindex];
//		int formula = func.formula;
		int nargs = func.nargs;
//		int start = asm.formulaOffset[formula];
		if (vargs.length!=nargs) {
			throw new ExceptionCalculation("Function " + func.name + " expects " + nargs + " arguments, but got " + vargs.length + ", please check the interface call.", null);
		}
		return run(INSTR_CALLFUNC, funcindex, nargs, 0, 0, vargs);
	}
	private V tabaccessCallExactCol(String tabname, String colname, V[] dynargs) {
		Integer tabind = tn.get(tabname);
		if (tabind==null) {
			B.bf_error(V.getInstance("table '" + tabname + "' not found"));
		}
		return TciMachineTabaccess.findExactColumn(asm.tables[tabind], V.getInstance(colname), dynargs);
	}
	private V tabaccessCallExactCol(int tabindex, String colname, V[] dynargs) {
		return TciMachineTabaccess.findExactColumn(asm.tables[tabindex], V.getInstance(colname), dynargs);
	}
	private V tabaccessCallExact(String tabname, V[] dynargs) {
		Integer tabind = tn.get(tabname);
		if (tabind==null) {
			B.bf_error(V.getInstance("table '" + tabname + "' not found"));
		}
		return TciMachineTabaccess.findExact(asm.tables[tabind], dynargs);
	}
	private V tabaccessCallExact(int tabindex, V[] vargs) {
		return TciMachineTabaccess.findExact(asm.tables[tabindex], vargs);
	}
	private int tabaccessCallColindex(int tabindex, String calcnameUppercase) {
		return TciMachineTabaccess.getColindex(asm.tables[tabindex], calcnameUppercase);
	}
	private V tabaccessCallExactColind(int index, int colind, V[] vargs) {
		return TciMachineTabaccess.findExactColumnIndex(asm.tables[index], colind, vargs);
	}
	
	private int getFuncIndex(String funcnameUpper) {
		Integer i = fn.get(funcnameUpper);
		if (i==null) {
			throw new ExceptionCalculation("invalid function name: " + funcnameUpper, null);
		}
		return i;
	}

	private int getTableid(String tabnameUpper) {
		Integer i = tn.get(tabnameUpper);
		return i!=null ? i : -1;
	}

	private V run(final int instridStart, final int op1Start, final int op2Start, final int op3Start, final int op4Start, V...vargs) {
		int pc  = -1; //program counter
		int sp  = -1; //stack pointer ... points to current top
		int bp  =  0; //base pointer .... points to first argument, followed by the other arguments, the local vars and the operand stack elements 
		int csp =  0; //call stack pointer ... points to next free slot
		int ksp = -1; //key stack pointer ... points to current top

		int instrid = instridStart;  //instruction
		int op1     = op1Start;      //operand1
		int op2     = op2Start;      //operand2
		int op3     = op3Start;      //operand3
		int op4     = op4Start;      //operand4

		final byte[] bytecode = asm.bytecode; 
		final V[] stack = this.stack;
		final long[] callstack = this.callstack;
		final Object[] keystack = this.keystack;
		final Object[] constants = this.asm.constants;
		final V[] vconstants = this.vconstants;
		final Node[] nodes = this.asm.nodes;
		final int[][] edges = this.asm.edges;
		V ret = null;
		double right;
		double left;
		
		
		indent=0;
		
		/* push arguments to stack */
		System.arraycopy(vargs, 0, stack, 0, vargs.length);
		sp += vargs.length;
		
//		/* push -1 as return address */
//		callstack[0] = -1; //pc
//		callstack[1] = 0; //bp
//		callstack[2] = -1; //funcid
//		callstack[3] = 0 (no caching), 1 (caching)0; //runtime
//      callstack[4] = 0 //runtime in ms
//		csp += 5; 
//		ksp += 1;
		
		for (;;) { //interpreter loop
			/* TODO performance: decode formula only once (->adjust jump locations!) */
			if (TRACE) {
				indent();
				for (int i=sp+1; i<stack.length; i++) {
					if (stack[i]!=null) {
//						System.out.println("stackerror: sp=" + sp + " but stack[" + i + "] not null: " + stack[i]);
					}
				}
				System.out.print(pc + ": ");
				Instruction instr = TciAssembler.getInstructionById(instrid);
				System.out.print(instr.getName());
				for (int i=0; i<instr.getOpSize(); i++) {
					System.out.print(' ');
					System.out.print(instr.getOpname(i));
					System.out.print('=');
					switch(i) {
					case 0: System.out.print(op1); break;
					case 1: System.out.print(op2); break;
					case 2: System.out.print(op3); break;
					case 3: System.out.print(op4); break;
					}
				}
				System.out.print(", stack before: ");
				System.out.print(Arrays.toString(Arrays.copyOfRange(stack, bp, sp+1)));
				System.out.print(", callstack before: ");
				System.out.print(Arrays.toString(Arrays.copyOf(callstack, csp)));
				System.out.print(", timescounter before: ");
				for (int it=0; it<this.timesSize; it++) {
					long tv = this.timesStack[it];
					int counter = (int) ((tv >>32) & 0xFFFF);
					int timesid = (int) ( tv       & 0xFFFF);
					System.out.print(timesid + "=" + counter + " ");
				}
				System.out.print(", keystack before: ");
				System.out.print(Arrays.toString(Arrays.copyOf(keystack, ksp+1)));
				System.out.println();
			}

			/* calling a formula put outside switch ... here we have the data to be set to trigger the call */
			int call_formulaid=-1; //<0: do not call
			int call_bp = 0;
			int call_nargs = 0; //<0: call_args has to be normalized after caching
			V[] call_args = null;
			
			/* dispatch */
			switch(instrid) {
			case INSTR_NOP                         : // --
				break;
			case INSTR_ADD                         : //a b -- a+b
				stack[sp-1] = V.getInstance(stack[sp-1].doubleValue() + stack[sp].doubleValue());
				stack[sp--] = null;
				break;
			case INSTR_ADDNOTNULL                  : { //a b -- a+b if a not null, b not null; null of a null and b null; a if a not null but b null; b otherwise
				V a = stack[sp-1];
				V b = stack[sp];
				int i = (a!=VNull.vnull ? 2 : 0) + (b!=VNull.vnull ? 1 : 0);
				switch(i) {
				case 0: break;
				case 1: stack[sp-1] = b; break;
				case 2: break; //a is already in stack[sp-1]
				case 3: stack[sp-1] = V.getInstance(a.doubleValue() + b.doubleValue()); break;
				}
				stack[sp--] = null;
				break;
			}
			case INSTR_AND                         : //a b -- a&&b
				stack[sp-1] = stack[sp-1].booleanValue() && stack[sp].booleanValue() ? VDouble.vdbl1 : VDouble.vdbl0;
				stack[sp--] = null;
				break;
			case INSTR_BIGEQ0                      : //a -- a>=0
				left = stack[sp].doubleValue();
				stack[sp] = left>=0 || Math.abs(left)<=1e-7 ? VDouble.vdbl1 : VDouble.vdbl0;
				break;
			case INSTR_BUILTIN                     : //"builtinid", OPTYPE_BYTE, "nargs", OPTYPE_INT) //arg1 ... arg_nargs -- result
				/* TODO performance: "denormalize" into instrid */
				switch (op1) {
				case 0: // "bf_false"
					stack[++sp] = VDouble.vdbl0;
					break;
				case 1: // "bf_not"
					stack[sp] = stack[sp].booleanValue() ? VDouble.vdbl0 : VDouble.vdbl1;
					break;
				case 2: // "bf_true"
					stack[++sp] = VDouble.vdbl0;
					break;
				/* external data access */
				case 3: // "bf_select"
					throw new ExceptionCalculation(op1 + " not implemented yet in TciMaschine", null);
				case 4: // "bf_selectx"
					throw new ExceptionCalculation(op1 + " not implemented yet in TciMaschine", null);
				case 5: // "bf_v_select"
					throw new ExceptionCalculation(op1 + " not implemented yet in TciMaschine", null);
				case 6: // "bf_v_selectx"
					throw new ExceptionCalculation(op1 + " not implemented yet in TciMaschine", null);
				/* string functions */
				case 7: // "bf_format" 2, 2, true
					stack[sp-1] = stack[sp-1].bf_format(stack[sp]);
					stack[sp--] = null;
					break;
				case 8: // "bf_instr" 2, 2, true
					stack[sp-1] = stack[sp-1].bf_instr(stack[sp]);
					stack[sp--] = null;
					break;
				case 9: // "bf_left" 2, 2, true
					stack[sp-1] = stack[sp-1].bf_left(stack[sp]);
					stack[sp--] = null;
					break;
				case 10: // "bf_length" 1, 1, true
					stack[sp] = V.getInstance(stack[sp].stringValue().length());
					break;
				case 11: // "bf_mid" 2, 3, true
					if (op2==2) {
						stack[sp-1] = stack[sp-1].bf_mid(stack[sp]);
						stack[sp--] = null;
					} else {
						stack[sp-2] = stack[sp-2].bf_mid(stack[sp-1], stack[sp]);
						stack[sp--] = null;
						stack[sp--] = null;
					}
					break;
				case 12: // "bf_right" 2, 2, true
					stack[sp-1] = stack[sp-1].bf_right(stack[sp]);
					stack[sp--] = null;
					break;
				case 13: // "bf_strcmp" 2, 2, true
					stack[sp-1] = V.getInstance(stack[sp-1].toString().compareTo(stack[sp].stringValue()));
					stack[sp--] = null;
					break;
				case 14: // "bf_stricmp" 2, 2, true
					stack[sp-1] = V.getInstance(stack[sp-1].toString().compareToIgnoreCase(stack[sp].stringValue()));
					break;
				case 15: // "bf_subst" 3, 3, true
					stack[sp-2] = stack[sp-2].bf_subst(stack[sp-1], stack[sp]);
					stack[sp--] = null;
					stack[sp--] = null;
					break;
				case 16: // "bf_tolower" 1, 1, true
					stack[sp] = stack[sp].bf_tolower();
					break;
				case 17: // "bf_toupper" 1, 1, true
					stack[sp] = stack[sp].bf_toupper();
					break;
				case 18: // "bf_trim" 1, 1, true
					stack[sp] = stack[sp].bf_toupper();
					break;
				case 19: // "bf_chr"´1, 1, true
					stack[sp] = stack[sp].bf_chr();
					break;
				case 20: // "bf_ansi" 1, 1, true
					stack[sp] = stack[sp].bf_ansi();
					break;
				case 21: // "bf_oem" 1, 1, true
					stack[sp] = stack[sp].bf_oem();
					break;
				/* math functions */
				case 22: // "bf_round" 1, 2, true
					if (op2==1) {
						stack[sp] = stack[sp].bf_round();
					} else {
						stack[sp-1] = stack[sp-1].bf_round(stack[sp]);
						stack[sp--] = null;
					}
					break;
				case 23: // "bf_ceil" 1, 1, true
					stack[sp] = stack[sp].bf_ceil();
					break;
				case 24: // "bf_floor" 1, 1, true
					stack[sp] = stack[sp].bf_floor();
					break;
				case 25: // "bf_min"
					sp = sp - op2 + 1;
					stack[sp] = B.bf_min(Arrays.copyOfRange(stack, sp, sp+op2));
					Arrays.fill(stack, sp+1, sp+op2, null);
					break;
				case 26: // "bf_max"
					sp = sp - op2 + 1;
					stack[sp] = B.bf_max(Arrays.copyOfRange(stack, sp, sp+op2));
					Arrays.fill(stack, sp+1, sp+op2, null);
					break;
				case 27: // "bf_sqrt" 1, 1, true
					stack[sp] = stack[sp].bf_sqrt();
					break;
				case 28: // "bf_exp" 1, 1, true
					stack[sp] = stack[sp].bf_exp();
					break;
				case 29: // "bf_fmod" 2, 2, true
					stack[sp-1] = stack[sp-1].bf_fmod(stack[sp]);
					stack[sp--] = null;
					break;
				case 30: // "bf_abs" 1, 1, true
					stack[sp] = stack[sp].bf_abs();
					break;
				/* unimportant math functions */
				case 31: // "bf_acos"
					stack[sp] = B.bf_acos(stack[sp]);
					break;
				case 32: // "bf_asin"
					stack[sp] = B.bf_asin(stack[sp]);
					break;
				case 33: // "bf_atan"
					stack[sp] = B.bf_atan(stack[sp]);
					break;
				case 34: // "bf_atan2"
					stack[sp-1] = B.bf_atan2(stack[sp-1], stack[sp]);
					stack[sp--] = null;
					break;
				case 35: // "bf_cos"
					stack[sp] = B.bf_cos(stack[sp]);
					break;
				case 36: // "bf_cosh"
					stack[sp] = B.bf_cosh(stack[sp]);
					break;
				case 37: // "bf_sin"
					stack[sp] = B.bf_sin(stack[sp]);
					break;
				case 38: // "bf_sinh"
					stack[sp] = B.bf_sinh(stack[sp]);
					break;
				case 39: // "bf_tan"
					stack[sp] = B.bf_tan(stack[sp]);
					break;
				case 40: // "bf_tanh"
					stack[sp] = B.bf_tanh(stack[sp]);
					break;
				case 41: // "bf_log"
					stack[sp] = B.bf_log(stack[sp]);
					break;
				case 42: // "bf_log10"
					stack[sp] = B.bf_log10(stack[sp]);
					break;
				/* date functions */
				case 43: // "bf_date" 4, 5, false
					if (op2==4) {
						stack[sp-3] = B.bf_date(stack[sp-3], stack[sp-2], stack[sp-1], stack[sp]);
						stack[sp--] = null;
						stack[sp--] = null;
						stack[sp--] = null;
					} else { //op2==5
						stack[sp-4] = B.bf_date(stack[sp-4], stack[sp-3], stack[sp-2], stack[sp-1], stack[sp]);
						stack[sp--] = null;
						stack[sp--] = null;
						stack[sp--] = null;
						stack[sp--] = null;
					}
					break;
				case 44: // "bf_dateday" 1, 1, true
					stack[sp] = stack[sp].bf_dateday();
					break;
				case 45: // "bf_day" 1, 1, true
					stack[sp] = stack[sp].bf_day();
					break;
				case 46: // "bf_daydate" 2, 2, true
					stack[sp-1] = stack[sp-1].bf_daydate(stack[sp]);
					stack[sp--] = null;
					break;
				case 47: // "bf_days" 1, 1, true
					stack[sp] = stack[sp].bf_days();
					break;
				case 48: // "bf_month" 1, 1, true
					stack[sp] = stack[sp].bf_month();
					break;
				case 49: // "bf_months" 1, 1, true
					stack[sp] = stack[sp].bf_months();
					break;
				case 50: // "bf_now" 1, 1, false
					stack[sp] = B.bf_now(stack[sp]);
					break;
				case 51: // "bf_year" 1, 1, true
					stack[sp] = stack[sp].bf_year();
					break;
				case 52: // "bf_years" 1, 1, true
					stack[sp] = stack[sp].bf_years();
					break;
				/* list */
				case 53: // "bf_list" 0, -1, false
					sp = sp - op2 + 1;
					if (op2>0) {
						stack[sp] = B.bf_list(Arrays.copyOfRange(stack, sp, sp+op2));
						Arrays.fill(stack, sp+1, sp+op2, null);
					} else {
						stack[sp] = B.bf_list();
					}
					break;
				case 54: // "bf_v_concat" 2, 2, true
					stack[sp-1] = stack[sp-1].bf_v_concat(stack[sp]);
					stack[sp] = null;
					break;
				case 55: // "bf_v_construct" 1, 1, true
					stack[sp] = stack[sp].bf_v_construct();
					break;
				case 56: // "bf_v_delete" 2, 2, true
					stack[sp-1] = stack[sp-1].bf_v_delete(stack[sp]);
					stack[sp--] = null;
					break;
				case 57: // "bf_v_element" 2, -1, true
					sp = sp - op2 + 1;
					stack[sp] = stack[sp].bf_v_element(Arrays.copyOfRange(stack, sp+1, sp+op2));
					Arrays.fill(stack, sp+1, sp+op2, null);
					break;
				case 58: // "bf_v_elements" 3, 3, true
					stack[sp-2] = stack[sp-2].bf_v_elements(stack[sp-1], stack[sp]);
					stack[sp--] = null;
					stack[sp--] = null;
					break;
				case 59: // "bf_v_first" 1, 1, true
					stack[sp] = stack[sp].bf_v_first();
					break;
				case 60: // "bf_v_front" 1, 1, true
					stack[sp] = stack[sp].bf_v_front();
					break;
				case 61: // "bf_v_insert" 3, 3, true
					stack[sp-2] = stack[sp-2].bf_v_insert(stack[sp-1], stack[sp]);
					stack[sp--] = null;
					stack[sp--] = null;
					break;
				case 62: // "bf_v_last" 1, 1, true
					stack[sp] = stack[sp].bf_v_last();
					break;
				case 63: // "bf_v_length" 1, 1, ture
					stack[sp] = stack[sp].bf_v_length();
					break;
				case 64: // "bf_v_max" 1, 1, true
					stack[sp] = stack[sp].bf_v_max();
					break;
				case 65: // "bf_v_min" 1, 1, true
					stack[sp] = stack[sp].bf_v_min();
					break;
				case 66: // "bf_v_numsort" 1, 1, true
					stack[sp] = stack[sp].bf_v_numsort();
					break;
				case 67: // "bf_v_replace" 3, 3, true
					stack[sp-2] = stack[sp-2].bf_v_replace(stack[sp-1], stack[sp]);
					stack[sp--] = null;
					stack[sp--] = null;
					break;
				case 68: // "bf_v_rest" 1, 1, true
					stack[sp] = stack[sp].bf_v_rest();
					break;
				case 69: // "bf_v_sort" 1, 1, true
					stack[sp] = stack[sp].bf_v_sort();
					break;
				case 70: // "bf_v_string", 2, 2, true
					stack[sp-1] = stack[sp-1].bf_v_string(stack[sp]);
					stack[sp--] = null;
					break;
				case 71: // "bf_v_stringx"
					stack[sp] = stack[sp].bf_v_stringx();
					break;
				case 72: // "bf_v_trans" 1, 1, true
					stack[sp] = stack[sp].bf_v_trans();
					break;
				/* information */
				case 73: // "bf_isbool" 1, 1, true
					stack[sp] = stack[sp].bf_isbool();
					break;
				case 74: // "bf_isdate" 1, 1, true
					stack[sp] = stack[sp].bf_isdate();
					break;
				case 75: // "bf_isinteger" 1, 1, true
					stack[sp] = stack[sp].bf_isinteger();
					break;
				case 76: // "bf_isnumber" 1, 1, true
					stack[sp] = stack[sp].bf_isnumber();
					break;
				case 77: // "bf_istime" 1, 1, true
					stack[sp] = stack[sp].bf_istime();
					break;
				/* dynamic call */
				case 78: // "bf_vpmtry" 2, -1, false
					sp = sp - op2 + 1;
					stack[sp] = B.bf_vpmtry(stack[sp], stack[sp+1], Arrays.copyOfRange(stack, sp+2, sp+op2));
					Arrays.fill(stack, sp+1, sp+op2, null);
					break;
				case 79: // "bf_vpmexist" 1, 3, false
					switch(op2) {
					case 1: 
						stack[sp] = B.bf_vpmexist(stack[sp]);
						break;
					case 2: 
						stack[sp-1] = B.bf_vpmexist(stack[sp-1], stack[sp]);
						stack[sp--] = null;
						break;
					case 3:
						stack[sp-2] = B.bf_vpmexist(stack[sp-2], stack[sp-1], stack[sp]);
						stack[sp--] = null;
						stack[sp--] = null;
						break;
					}
					break;
				case 80: // "bf_error" 1, 2, false
					if(op2==1) {
						stack[sp] = B.bf_error(stack[sp]);
					} else { //op2==2
						stack[sp-1] = B.bf_error(stack[sp-1], stack[sp]);
						stack[sp--] = null;
					}
					break;
				case 81: // "bf_const" 1, 1, false
					stack[sp] = B.bf_const(stack[sp]);
					break;
				case 82: // "bf_getprivateprofilestring" 4, 4, false
					stack[sp-3] = B.bf_getprivateprofilestring(stack[sp-3], stack[sp-2], stack[sp-1], stack[sp]);
					stack[sp--] = null;
					stack[sp--] = null;
					stack[sp--] = null;
					break;
				}
				break; // end of builtin
			case INSTR_CALLDYNFUNC                 : { //"nargs", OPTYPE_BYTE) //arg1 ... arg_nargs funcref -- result 
				Func func = asm.funcs[stack[sp].funcrefValue()];
				stack[sp--] = null; //get rid of funcref
				int formulaid = func.formula;
				
				call_formulaid = formulaid;
				call_nargs = op1;
				call_bp = sp - call_nargs + 1;
				break;
			}
			case INSTR_CALLFORMULA                 : { //"formulaid", OPTYPE_INT, "nargs", OPTYPE_INT) //arg1 ... arg_nargs -- result
				call_formulaid = op1;
				call_nargs = op2;
				call_bp = sp - call_nargs + 1;
				break;
			}
			case INSTR_CALLFORMULADYN               : { //formulaid nargs arg_list -- result
				call_formulaid = (int) stack[sp-2].longValue();
				call_nargs = (int) stack[sp-1].longValue();
				call_args = stack[sp].listValue().toArray(new V[0]);
				stack[sp--] = null;
				stack[sp--] = null;
				stack[sp--] = null;
				call_bp = sp+1;
				break;
			}
			case INSTR_CALLFUNC                    : { //"funcid", OPTYPE_INT, "nargs", OPTYPE_INT) //arg1 ... arg_nargs -- result
				Func func = asm.funcs[op1];
				call_formulaid = func.formula;
				call_nargs = op2;
				call_bp = sp - call_nargs + 1;
				break;
			}
			case INSTR_CALLNODECALC                : { //"nodeid", OPTYPE_INT, "calcid", OPTYPE_INT, "nargs", OPTYPE_BYTE) // arg1 ... arg_nargs -- result
				call_formulaid = nodes[op1].nodecalcList[op2].formula;
				call_nargs = op3; 
				call_bp = sp - call_nargs + 1;
				break;
			}
			case INSTR_CALLNODECALCLIST            : { //"nodeid", OPTYPE_INT, "calcid", OPTYPE_INT, "nargs", OPTYPE_BYTE, "selfcall", OPTYPE_BYTE) // arg1 ... arg_nargs -- result
				/* just call the formula that does the summation */
//				out.println("   ; argument 0: arguments_list");
//				out.println("   ; argument 1: nodeid");
//				out.println("   ; argument 2: calcid");
//				out.println("   ; argument 3: nr of parameters");
//				out.println("   ; argument 4: selfcall (0/1)");
//				out.println("   ; argument 5: resultlist");
				call_formulaid = 0;

				V nodeid = V.getInstance(op1);
				V calcid = V.getInstance(op2);
				V nargs = V.getInstance(op3);
				V selfcall  = V.getInstance(op4);
				
				call_bp = sp - op3 + 1; //points to return value now
				V args = V.getInstance(Arrays.copyOfRange(stack, call_bp, call_bp + op3));
				/* remove arg1 ... arg_n  from stack */
				Arrays.fill(stack, call_bp, call_bp + op3, null);
				sp = call_bp - 1;
				call_args = new V[] { args, nodeid,	calcid,	nargs, selfcall, VList.getInstanceMaxSize(8)};
				call_nargs = 6;
				break;
			}
			case INSTR_CALLNODECALCSUM             : { //"nodeid", OPTYPE_INT, "calcid", OPTYPE_INT, "nargs", OPTYPE_BYTE, "selfcall", OPTYPE_BYTE) // arg1 ... arg_nargs -- result
				/* just call the formula that does the summation */
//				out.println("   ; argument 0: arguments_list");
//				out.println("   ; argument 1: nodeid");
//				out.println("   ; argument 2: calcid");
//				out.println("   ; argument 3: nr of parameters");
//				out.println("   ; argument 4: selfcall (0/1)");

				call_formulaid = 1;

				V nodeid = V.getInstance(op1);
				V calcid = V.getInstance(op2);
				V nargs = V.getInstance(op3);
				V selfcall  = V.getInstance(op4);
				
				call_bp = sp - op3 + 1; //points to return value now
				V args = V.getInstance(Arrays.copyOfRange(stack, call_bp, call_bp + op3));
				/* remove arg1 ... arg_n  from stack */
				Arrays.fill(stack, call_bp, call_bp + op3, null);
				call_nargs = 5;
				call_args = new V[] { args, nodeid, calcid, nargs, selfcall };
				break;
			}
			case INSTR_CMPBIG                      : // a b -- a> b (numerical)
				right = stack[sp].doubleValue();
				stack[sp--] = null;
				left = stack[sp].doubleValue();
				stack[sp] = left>right ? VDouble.vdbl1 : VDouble.vdbl0;
				break;
			case INSTR_CMPBIGEQ                    : // a b -- a>=b (numerical)
				right = stack[sp].doubleValue();
				stack[sp--] = null;
				left = stack[sp].doubleValue();
				stack[sp] = left>=right || Math.abs(left-right)<1e-7 ? VDouble.vdbl1 : VDouble.vdbl0;
				break;
			case INSTR_CMPNEQ                      : // a b -- a!=b (numerical)
				right = stack[sp].doubleValue();
				stack[sp--] = null;
				left = stack[sp].doubleValue();
				stack[sp] = Math.abs(left-right)>=1e-7 ? VDouble.vdbl1 : VDouble.vdbl0;
				break;
			case INSTR_CMPSEQ                      : // a b -- a==b (string case-sensitive)
				stack[sp-1] = stack[sp-1].stringValue().equals(stack[sp].stringValue()) ? VDouble.vdbl1 : VDouble.vdbl0;
				stack[sp--] = null;
				break;
			case INSTR_CMPSEQI                     : // a b -- a==b (string case-insensitive)
				stack[sp-1] = stack[sp-1].stringValue().equalsIgnoreCase(stack[sp].stringValue()) ? VDouble.vdbl1 : VDouble.vdbl0;
				stack[sp--] = null;
				break;
			case INSTR_CMPSG                       : // a b -- a> b (string case-sensitive)
				stack[sp-1] = stack[sp-1].stringValue().compareTo(stack[sp].stringValue())>0 ? VDouble.vdbl1 : VDouble.vdbl0;
				stack[sp--] = null;
				break;
			case INSTR_CMPSGEQ                     : // a b -- a>=b (string case-sensitive)
				stack[sp-1] = stack[sp-1].stringValue().compareTo(stack[sp].stringValue())>=0 ? VDouble.vdbl1 : VDouble.vdbl0;
				stack[sp--] = null;
				break;
			case INSTR_CMPSGEQI                    : // a b -- a>=b (string case-insensitive)
				stack[sp-1] = stack[sp-1].stringValue().compareToIgnoreCase(stack[sp].stringValue())>=0 ? VDouble.vdbl1 : VDouble.vdbl0;
				stack[sp--] = null;
				break;
			case INSTR_CMPSGI                      : // a b -- a> b (string case-insensitive)
				stack[sp-1] = stack[sp-1].stringValue().compareToIgnoreCase(stack[sp].stringValue())>0 ? VDouble.vdbl1 : VDouble.vdbl0;
				stack[sp--] = null;
				break;
			case INSTR_CMPSL                       : // a b -- a< b (string case-sensitive)
				stack[sp-1] = stack[sp-1].stringValue().compareTo(stack[sp].stringValue())<0 ? VDouble.vdbl1 : VDouble.vdbl0;
				stack[sp--] = null;
				break;
			case INSTR_CMPSLEQ                     : // a b -- a<=b (string case-sensitive)
				stack[sp-1] = stack[sp-1].stringValue().compareTo(stack[sp].stringValue())<=0 ? VDouble.vdbl1 : VDouble.vdbl0;
				stack[sp--] = null;
				break;
			case INSTR_CMPSLEQI                    : // a b -- a<=b (string case-insensitive)
				stack[sp-1] = stack[sp-1].stringValue().compareToIgnoreCase(stack[sp].stringValue())<=0 ? VDouble.vdbl1 : VDouble.vdbl0;
				stack[sp--] = null;
				break;
			case INSTR_CMPSLI                      : // // a b -- a< b (string case-insensitive)
				stack[sp-1] = stack[sp-1].stringValue().compareToIgnoreCase(stack[sp].stringValue())<0 ? VDouble.vdbl1 : VDouble.vdbl0;
				stack[sp--] = null;
				break;
			case INSTR_CMPSML                      : // a b -- b< a (numerical)
				right = stack[sp].doubleValue();
				stack[sp--] = null;
				left = stack[sp].doubleValue();
				stack[sp] = left<right  ? VDouble.vdbl1 : VDouble.vdbl0;
				break;
			case INSTR_CMPSMLEQ                    : // a b -- a<=b (numerical)
				right = stack[sp].doubleValue();
				stack[sp--] = null;
				left = stack[sp].doubleValue();
				stack[sp] = left<=right || Math.abs(left-right)<1e-7 ? VDouble.vdbl1 : VDouble.vdbl0;
				break;
			case INSTR_CMPSNEQ                     : // a b -- b!=a (string case-sensitive)   
				stack[sp-1] = stack[sp-1].stringValue().equals(stack[sp].stringValue()) ? VDouble.vdbl0 : VDouble.vdbl1;
				stack[sp--] = null;
				break;
			case INSTR_CMPSNEQI                    : // a b -- b!=a (string case-insensitive)
				stack[sp-1] = stack[sp-1].stringValue().equalsIgnoreCase(stack[sp].stringValue()) ? VDouble.vdbl0 : VDouble.vdbl1;
				stack[sp--] = null;
				break;
			case INSTR_CREATELIST0                 : // -- empty list
				stack[++sp] = VList.EMPTYLIST;
				break;
			case INSTR_CREATELIST1                 : // a -- list(a)
				stack[sp] = VList.valueOf(new V[] { stack[sp] });
				break;
			case INSTR_CREATELISTN                 : // n -- list with max capacity n
				stack[sp] = VList.getInstanceMaxSize((int) stack[sp].longValue());
				break;
			case INSTR_DIV                         : // d1 d2 -- d1/d2
				stack[sp-1] = V.getInstance(stack[sp-1].doubleValue() / stack[sp].doubleValue());
				stack[sp--] = null;
				break;
			case INSTR_DIVINT                      : // d1 d2 -- d1 DIV d2
				stack[sp-1] = stack[sp-1].divint(stack[sp]);
				stack[sp--] = null;
				break;
			case INSTR_DUP                         : // a -- a a
				stack[sp+1] = stack[sp];
				sp++;
				break;
			case INSTR_DYNCOMPUTE                  : { // modelname calculatestring -- result
				S sub = getSubmodel(stack[sp-1].stringValue());
				stack[sp-1] = V.getInstance(sub.calculate(stack[sp].stringValue()));
				stack[sp--] = null;
				break;
			}
			case INSTR_EQ                          : // n1 n2 -- n1==n2 (numerical) 
				right = stack[sp].doubleValue();
				stack[sp--] = null;
				left = stack[sp].doubleValue();
				stack[sp] = left==right || Math.abs(left-right)<=1e-7 ? VDouble.vdbl1 : VDouble.vdbl0;
				break;
			case INSTR_ERROR : //msg --
				ret = stack[sp];
				stack[sp--] = null;
				B.bf_error(ret);
				break;
//			case INSTR_EXIT                        : { // a --      ; pc set, stack frame removed etc.
//				ret = stack[sp];
//				Arrays.fill(stack, 0, sp+1, null);
//				if (TRACE) {
//					indent(); 
//					System.out.print(pc + ": ");
//					System.out.println("exit with value " + ret.stringValue()); 
//				}
//				indent--;
//				return ret;
//			}
			case INSTR_GETFUNCREF                  : { // funcname -- funcref
				String funcname = stack[sp].stringValue().toUpperCase();
				Integer funcid = this.fn.get(funcname);
				if (funcid==null) {
					stack[sp] = B.bf_error(V.getInstance("Function '" + funcname + "' not defined"));
				} else {
					stack[sp] = V.getInstanceFuncref(funcid);
				}
				break;
			}
			case INSTR_GETINPUT                    : { //"inputid", OPTYPE_INT, "nargs", OPTYPE_BYTE) //arg1 ... arg_nargs -- result
				Input input = asm.inputs[op1];
				int formulaid = input.formulaCheck;
				sp = sp - op2 + 1; //points to return value .. which was arg1 on call
				for (op3=op2; --op3>=0; ) {
					if (stack[sp+op3].doubleValue()!=0.0) {
						break;
					}
				}
				op3++; //op3 has number of indizes > 0 
				V[] args = op3>0 ? Arrays.copyOfRange(stack, sp, sp+op3) : null;
				Arrays.fill(stack, sp, sp+op2, null);
				if (formulaid>=0) {
					call_formulaid = formulaid;
					call_bp = sp;
					switch(op3) {
					case 0: stack[call_bp] = VDouble.vdbl0; stack[call_bp+1] = VDouble.vdbl0; break;
					case 1: stack[call_bp] = V.getInstance(args); stack[call_bp+1] = VDouble.vdbl0; break;
					default: stack[call_bp] = V.getInstance(args); stack[call_bp+1] = args[1]; 
					}
					call_nargs = op3;
				} else {
					stack[sp] = this.getInput(op1, args);
				}
				break;
			}
			case INSTR_GETINPUT0                   : { //"inputid", OPTYPE_INT) // -- result
				Input input = asm.inputs[op1];
				int[] ac = input.autocounters;
				V[] acValues;
				int acLen = ac.length;
				if (acLen>0) {
					acValues = this.getAutocounterValues(ac);
					acLen = acValues.length;
				} else {
					acValues = null;
				}
				int formulaid = input.formulaCheck;
				if (formulaid>=0) {
					call_formulaid = formulaid;
					call_bp = sp+1;
					call_nargs = acLen;
					switch(acLen) {
					case 0: stack[call_bp] = VDouble.vdbl0; stack[call_bp+1] = VDouble.vdbl0; break;
					case 1: stack[call_bp] = V.getInstance(acValues); stack[call_bp+1] = VDouble.vdbl0; break;
					default: stack[call_bp] = V.getInstance(acValues); stack[call_bp+1] = acValues[1]; 
					}
				} else {
					stack[++sp] = this.getInputAutocounter(op1, ac);
				}
				break;
			}
			case INSTR_GETINPUTCALC                : { //"inputid", OPTYPE_INT, "inputcalcid", OPTYPE_INT, "nargs", OPTYPE_BYTE) // arg1 ... arg_n -- result
				Input input = asm.inputs[op1];
				call_formulaid = input.inputcalcFormulas[op2];
				call_bp = sp - op3 + 1; //points to return value .. which was arg1 on call
				for (op4=op3; --op4>=0; ) {
					if (stack[call_bp+op4].doubleValue()!=0.0) {
						break;
					}
				}
				op4++; //op4 has number of arguments > 0 now
				call_nargs = op4;
				V[] args = Arrays.copyOfRange(stack, call_bp, call_bp+op4);
				Arrays.fill(stack, call_bp, call_bp+op3, null);
				switch(op4) {
				case 0: stack[call_bp] = VDouble.vdbl0; stack[call_bp+1] = VDouble.vdbl0; break;
				case 1: stack[call_bp] = V.getInstance(args); stack[call_bp+1] = VDouble.vdbl0; break;
				default: stack[call_bp] = V.getInstance(args); stack[call_bp+1] = args[1]; 
				}
				break;
			} 
			case INSTR_GETINPUTCALC0               : { //"inputid", OPTYPE_INT, "inputcalcid", OPTYPE_INT) // -- result
				Input input = asm.inputs[op1];
				call_formulaid = input.inputcalcFormulas[op2];
				call_bp = sp+1;
				
				int[] ac = input.autocounters;
				V[] acValues = null;
				int acLen = ac.length;
				if (acLen>0) {
					acValues = this.getAutocounterValues(ac);
					acLen = acValues.length;
				}
				call_nargs = acLen;
				switch(acLen) {
				case 0: stack[call_bp] = VDouble.vdbl0; stack[call_bp+1] = VDouble.vdbl0; break;
				case 1: stack[call_bp] = V.getInstance(acValues); stack[call_bp+1] = VDouble.vdbl0; break;
				default: stack[call_bp] = V.getInstance(acValues); stack[call_bp+1] = acValues[1]; 
				}
				break;
			} 
			case INSTR_GETINPUTRAW                 : //"inputid", OPTYPE_INT, "nargs", OPTYPE_BYTE) // arg1 ... arg_nargs -- result
				if (op2>0) {
					sp = sp - op2 + 1; //points to return value .. which was arg1 on call
					V[] args = Arrays.copyOfRange(stack, sp, sp+op2);
					Arrays.fill(stack, sp+1, sp+op2, null);
					stack[sp] = this.getInput(op1, args);
				} else {
					stack[++sp] = this.inputvalues0dim[op1];
				}
				break;
			case INSTR_GETINPUTRAW0                : //"inputid", OPTYPE_INT) // -- result
				Input input = asm.inputs[op1];
				int[] ac = input.autocounters;
				V[] acValues = null;
				int acLen = ac.length;
				if (acLen>0) {
					acValues = this.getAutocounterValues(ac);
					acLen = acValues.length;
				}
				if (acLen==0) {
					stack[++sp] = this.inputvalues0dim[op1];
				} else {
					stack[++sp] = this.getInput(op1, acValues);
				}
				break;
			case INSTR_GETINPUTRAWSELF             : //"inputid", OPTYPE_INT) // index -- result
				stack[sp] = this.getInput(op1, stack[sp].listValue().toArray(new V[0]));
				break;
			case INSTR_GOTO                        : //"label", OPTYPE_LABEL) // --  ; pc set
				pc = op1;
				break;
			case INSTR_IFBIG                       : //"label", OPTYPE_LABEL) // a b --   ; pc set if a>=b
				right = stack[sp].doubleValue();
				stack[sp--] = null;
				left = stack[sp].doubleValue();
				stack[sp--] = null;
				if (left>right) {
					pc = op1;
				}
				break;
			case INSTR_IFBIGEQ                     : //"label", OPTYPE_LABEL) // a b --   ; pc set if a>=b
				right = stack[sp].doubleValue();
				stack[sp--] = null;
				left = stack[sp].doubleValue();
				stack[sp--] = null;
				if (left>=right || Math.abs(left-right)<=1e-7) {
					pc = op1;
				}
				break;
			case INSTR_IFFALSE                     : //"label", OPTYPE_LABEL) // a --     ; pc set if a==false(0)
				if (!stack[sp].booleanValue()) {
					pc = op1;
				}
				stack[sp--] = null;
				break;
			case INSTR_IFNOTNULL                   : //"label", OPTYPE_LABEL) // a --     ; pc set if a==false(0)
				if (stack[sp]!=VNull.vnull) {
					pc = op1;
				}
				stack[sp--] = null;
				break;
			case INSTR_IFNULL                     : //"label", OPTYPE_LABEL) // a --     ; pc set if a==false(0)
				if (stack[sp]==VNull.vnull) {
					pc = op1;
				}
				stack[sp--] = null;
				break;
			case INSTR_IFNUMEQUAL                  : //"label", OPTYPE_LABEL) // a b --   ; pc set if a==b (numerical) 
				right = stack[sp].doubleValue();
				stack[sp--] = null;
				left = stack[sp].doubleValue();
				stack[sp--] = null;
				if (left==right || Math.abs(left-right)<=1e-7) {
					pc = op1;
				}
				break;
			case INSTR_IFSEQI                      : //"label", OPTYPE_LABEL) // a b --   ; pc set if a==b (string case-insensitive)
				if (stack[sp-1].stringValue().equalsIgnoreCase(stack[sp].stringValue())) {
					pc = op1;
				}
				stack[sp--] = null;
				stack[sp--] = null;
				break;
			case INSTR_IFSML                       : //"label", OPTYPE_LABEL) // a b --   ; pc set if a<b
				right = stack[sp].doubleValue();
				stack[sp--] = null;
				left = stack[sp].doubleValue();
				stack[sp--] = null;
				if (left<right) {
					pc = op1;
				}
				break;
			case INSTR_IFSMLEQ                     : //"label", OPTYPE_LABEL) // a b --   ; pc set if a<b
				right = stack[sp].doubleValue();
				stack[sp--] = null;
				left = stack[sp].doubleValue();
				stack[sp--] = null;
				if (left<right || Math.abs(left-right)<=1e-7) {
					pc = op1;
				}
				break;
			case INSTR_IFTRUE                      : //"label", OPTYPE_LABEL) // a   --   ; pc set if a==true(1)
				if (stack[sp].booleanValue()) {
					pc = op1;
				}
				stack[sp--] = null;
				break;
			case INSTR_IFZERO                      : //"label", OPTYPE_LABEL) // a   --   ; pc set if a==0
				if (stack[sp].doubleValue()==0) {
					pc = op1;
				}
				stack[sp--] = null;
				break;
			case INSTR_INPUTTESTNULL               : // inputdescr -- b
				stack[sp] = this.getInputIsNull(stack[sp].stringValue()) ? VDouble.vdbl1 : VDouble.vdbl0;
				break;
				
			case INSTR_LISTAPPENDELEM1             : // list a -- list(..., a)  ; existing list is changed!
				if (stack[sp]!=VNull.vnull) { //null elements are not added to the list
					stack[sp-1].listValue().add(stack[sp]);
				}
				stack[sp--] = null;
				break;
			case INSTR_LISTELEM1                   : // n list -- a    ;list[n]
				stack[sp-1] = stack[sp].listValue().get((int) stack[sp-1].longValue());
				stack[sp--] = null;
				break;
			case INSTR_LOAD                        : //"varid", OPTYPE_BYTE) // -- a      ; local var [varid]
				stack[++sp] = stack[bp+op1];
				break;
			case INSTR_MODINT                      : // d1 d2 -- d1 % d2  
				stack[sp-1] = stack[sp-1].modint(stack[sp]);
				stack[sp--] = null;
				break;
			case INSTR_MULT                        : // d1 d2 -- d1*d2
				stack[sp-1] = V.getInstance(stack[sp-1].doubleValue() * stack[sp].doubleValue());
				stack[sp--] = null;
				break;
			case INSTR_OVER                        : // a b -- a b a
				stack[sp+1] = stack[sp-1];
				sp++;
				break;
			case INSTR_POP                         : // a --
				stack[sp--] = null;
				break;
			case INSTR_POWER                       : // n1 n2 -- n1^n2
				stack[sp-1] = V.getInstance(Math.pow(stack[sp-1].doubleValue(), stack[sp].doubleValue()));
				stack[sp--] = null;
				break;
			case INSTR_PUSHCONST                   : //"constant", OPTYPE_CONST) // -- a   ; taken from constant pool
				V tmp = vconstants[op1];
				if (tmp!=null) {
					stack[++sp] = tmp;
				} else {
					tmp = vconstants[op1] = stack[++sp] = V.getInstance(constants[op1].toString());
				}
				break;
			case INSTR_PUSHCONST0                  : // -- 0
				stack[++sp] = VDouble.vdbl0;
				break;
			case INSTR_PUSHCONST1                  : // -- 1
				stack[++sp] = VDouble.vdbl1;
				break;
			case INSTR_PUSHNULL                    : // -- null
				stack[++sp] = VNull.vnull;
				break;
			case INSTR_PUSHTIMESCOUNTER            : //"counterid", OPTYPE_BYTE) // -- n  ; current value of times-counter with id==n1
				stack[++sp] = this.getTimesCounterV(op1); /* TODO: use getTimesCounterVException in special cases? ... check modelling rules first */ 
				break;
			case INSTR_RETURN                      : { // a --      ; pc set, stack frame removed etc.
				csp-=5;
				int formulaid=(int)callstack[csp+2];
				boolean caching = callstack[csp+3]==1;
				/* profiling */
				//xxx ProfilingFormula prof = profilingData.getProfilingFormula(formulaid);
				stack[bp] = stack[sp]; //move result to top of stack of caller
				if(sp>bp) {
					Arrays.fill(stack, bp+1, sp+1, null); //clean up stack
				}
				sp = bp;
				/* write result into cache */
				//xxx long timems = prof.endTimer(csp) - callstack[csp+4];
				if (caching) {
					writeCache(keystack[ksp], stack[bp]);
					keystack[ksp--]=null;
					//xxx prof.cacheWrite();
					/* check cache hit rate */
//					if (prof.cacheLookup % 100 ==0 && (prof.cacheHit==0 || (prof.cacheLookup / prof.cacheHit)>2)) {
//						prof.memoactive = false;
//					}
//					/* check profile data after a couple of calls*/
//					if (prof.counter==50) {
//						prof.memoactive = true;
//						
//						if (prof.cacheHit==0 || (prof.cacheLookup / prof.cacheHit)>3 && (timems>10 || prof.time>10)) {
//							prof.memoactive = false;
//						}
//					}
//						double cost = 400;
//						double benefit = (double) prof.cacheHit / prof.cacheLookup * prof.time;
//						if (cost>benefit) {
//							prof.memoactive = false;
//						}
				} else {
					/* runtime-based activation */
//					if (!prof.issimple && (timems>10 || prof.time>10)) {
//						prof.memoactive = true;
//					}
				}
				pc = (int) callstack[csp];
				bp = (int) callstack[csp+1];
//				if (asm.formulaSimple[formulaid]) {
//					/* turn on caching if computation takes some time */
//					/* problem: falls ich es einschalte während andere aktiv */
//					if (timems>0 || prof.time>0) {
//						asm.formulaSimple[formulaid] = false;
//					}
//				} else {
//					/* turn off caching if not good */
//					if (prof.cacheLookup>10 && prof.cacheLookup % 10 ==0 && (prof.cacheHit==0 || (prof.cacheLookup / prof.cacheHit)>5)) {
//						asm.formulaSimple[formulaid] = true;
//						prof.reset();
//					}
//				}
				/* end of profiling */
				indent--;
				break;
			}
			case INSTR_SAPPEND                     : // s1 s2 -- s3   ; s3==s1 & s2
				String sright = stack[sp].stringValue();
				stack[sp--] = null;
				String sleft = stack[sp].stringValue();
				if (sright.length()==0) {
					break;
				} else {
					stack[sp] = V.getInstance(sleft + sright);
				}
				break;
			case INSTR_STORE                       : //"varid", OPTYPE_BYTE) // a --      ; local var [varid] set to a
				stack[bp+op1] = stack[sp];
				stack[sp--] = null;
				break;
			case INSTR_SUB                         : // n1 n2 -- (n1-n2)
				stack[sp-1] = V.getInstance(stack[sp-1].doubleValue() - stack[sp].doubleValue());
				stack[sp--] = null;
				break;
			case INSTR_TABCELL                     : //"tableid", OPTYPE_INT) //rownr colnr -- result
				stack[sp-1] = TciMachineTabaccess.getCell(asm.tables[op1], stack[sp-1], stack[sp]);
				stack[sp--] = null;
				break;
			case INSTR_TABCELL_CN                  : //"tableid", OPTYPE_INT) //rownr colname -- result  
				stack[sp-1] = TciMachineTabaccess.getCellByName(asm.tables[op1], stack[sp-1], stack[sp]);
				stack[sp--] = null;
				break;
			case INSTR_TABCELLS                    : //"tableid", OPTYPE_INT) //rownrfrom rownrto colnrfrom colnrto -- result  
				stack[sp-3] = TciMachineTabaccess.getCells(asm.tables[op1], stack[sp-3], stack[sp-2], stack[sp-1], stack[sp]);
				stack[sp--] = null;
				stack[sp--] = null;
				stack[sp--] = null;
				break;
			case INSTR_TABCELLS_CN                 : //"tableid", OPTYPE_INT) //rownrfrom rownrto colnamefrom colnameto -- result  
				stack[sp-3] = TciMachineTabaccess.getCellsByName(asm.tables[op1], stack[sp-3], stack[sp-2], stack[sp-1], stack[sp]);
				stack[sp--] = null;
				stack[sp--] = null;
				stack[sp--] = null;
				break;
			case INSTR_TABCELLSCOL                 : //"tableid", OPTYPE_INT) //rownrfrom rownrto colnr -- result  
				stack[sp-2] = TciMachineTabaccess.getCellsColumn(asm.tables[op1], stack[sp-2], stack[sp-1], stack[sp]);
				stack[sp--] = null;
				stack[sp--] = null;
				break;
			case INSTR_TABCELLSCOL_CN              : //"tableid", OPTYPE_INT) //rownrfrom rownrto colname -- result  
				stack[sp-2] = TciMachineTabaccess.getCellsColumnByName(asm.tables[op1], stack[sp-2], stack[sp-1], stack[sp]);
				stack[sp--] = null;
				stack[sp--] = null;
				break;
			case INSTR_TABCELLSROW                 : //"tableid", OPTYPE_INT) //rownr colnrfrom colnrto -- result  
				stack[sp-2] = TciMachineTabaccess.getCellsRow(asm.tables[op1], stack[sp-2], stack[sp-1], stack[sp]);
				stack[sp--] = null;
				stack[sp--] = null;
				break;
			case INSTR_TABCELLSROW_CN              : //"tableid", OPTYPE_INT) //rownr colnamefrom colnameto -- result  
				stack[sp-2] = TciMachineTabaccess.getCellsRowByName(asm.tables[op1], stack[sp-2], stack[sp-1], stack[sp]);
				stack[sp--] = null;
				stack[sp--] = null;
				break;
			case INSTR_TABCOLS                     : //tabref -- n
				stack[sp] = V.getInstance(asm.tables[(int)stack[sp].longValue()].cols);
				break;
			case INSTR_TABFINDEXACT                : //"tableid", OPTYPE_INT, "nargs", OPTYPE_BYTE) //arg1 ... arg_nargs -- result
				sp = sp - op2 + 1;
				stack[sp] = TciMachineTabaccess.findExact(asm.tables[op1], Arrays.copyOfRange(stack, sp, sp+op2));
				Arrays.fill(stack, sp+1, sp+op2, null);
				break;
			case INSTR_TABFINDEXACTCOLUMN          : //"tableid", OPTYPE_INT, "nargs", OPTYPE_BYTE, "colind", OPTYPE_INT) // arg1 ... arg_nargs -- result
				sp = sp - op2 + 1;
				stack[sp] = TciMachineTabaccess.findExactColumnIndex(asm.tables[op1], op3, Arrays.copyOfRange(stack, sp, sp+op2));
				Arrays.fill(stack, sp+1, sp+op2, null);
				break;
			case INSTR_TABFINDEXACTCOLUMNBYNAME    : //"tableid", OPTYPE_INT, "nargs", OPTYPE_BYTE) //arg1 ... arg_nargs colname -- result
				sp = sp - op2 - 1 + 1;
				stack[sp] = TciMachineTabaccess.findExactColumn(asm.tables[op1], stack[sp+op2], Arrays.copyOfRange(stack, sp, sp + op2 ));
				Arrays.fill(stack, sp+1, sp+op2+1, null);
				break;
			case INSTR_TABFINDINTERVALDOWNCOLUMN   : //"tableid", OPTYPE_INT, "nargs", OPTYPE_BYTE) //arg1 ... arg_nargs colname -- result
				sp = sp - op2 - 1 + 1;
				stack[sp] = TciMachineTabaccess.findIntervalDownColumn(asm.tables[op1], stack[sp+op2], Arrays.copyOfRange(stack, sp, sp + op2));
				Arrays.fill(stack, sp+1, sp+op2+1, null);
				break;
			case INSTR_TABFINDINTERVALUP           : //"tableid", OPTYPE_INT) //arg -- result
				stack[sp] = TciMachineTabaccess.findIntervalUp(asm.tables[op1], stack[sp]);
				break;
			case INSTR_TABFINDINTERVALUPCOLUMN     : //"tableid", OPTYPE_INT, "nargs", OPTYPE_BYTE) //arg1 ... arg_nargs colname -- result
				sp = sp - op2 - 1 + 1;
				stack[sp] = TciMachineTabaccess.findIntervalUpColumn(asm.tables[op1], stack[sp+op2], Arrays.copyOfRange(stack, sp, sp + op2));
				Arrays.fill(stack, sp+1, sp+op2+1, null);
				break;
			case INSTR_TABFINDROWEXACT             : //"tableid", OPTYPE_INT, "nargs", OPTYPE_BYTE) //arg1 ... arg_nargs -- result
				sp = sp - op2 + 1;
				stack[sp] = V.getInstance(TciMachineTabaccess.findRowExact(asm.tables[op1], Arrays.copyOfRange(stack, sp, sp+op2)));
				Arrays.fill(stack, sp+1, sp+op2, null);
				break;
			case INSTR_TABREFCELL                  : { //rownr colnr tabref -- result  
				String tabname = stack[sp].stringValue().toUpperCase();
				Integer tabind = tn.get(tabname);
				if (tabind==null) {
					stack[sp] = B.bf_error(V.getInstance("table '" + tabname + "' not found"));
				} else {
					stack[sp] = TciMachineTabaccess.getCell(asm.tables[tabind], stack[sp-2], stack[sp-1]);
				}
				stack[sp--] = null;
				stack[sp--] = null;
				break;
			}
			case INSTR_TABREFCELLS                 : { //rownrfrom rownrto colnrfrom colnrto tabref -- result  
				String tabname = stack[sp].stringValue().toUpperCase();
				Integer tabind = tn.get(tabname);
				if (tabind==null) {
					stack[sp] = B.bf_error(V.getInstance("table '" + tabname + "' not found"));
				} else {
					stack[sp] = TciMachineTabaccess.getCells(asm.tables[tabind], stack[sp-4], stack[sp-3], stack[sp-2], stack[sp-1]);
				}
				stack[sp--] = null;
				stack[sp--] = null;
				stack[sp--] = null;
				stack[sp--] = null;
				break;
			}
			case INSTR_TABREFCELLSCOL              : { //rownrfrom rownrto colnr tabref -- result  
				String tabname = stack[sp].stringValue().toUpperCase();
				Integer tabind = tn.get(tabname);
				if (tabind==null) {
					stack[sp] = B.bf_error(V.getInstance("table '" + tabname + "' not found"));
				} else {
					stack[sp] = TciMachineTabaccess.getCellsColumn(asm.tables[tabind], stack[sp-3], stack[sp-2], stack[sp-1]);
				}
				stack[sp--] = null;
				stack[sp--] = null;
				stack[sp--] = null;
				break;
			}
			case INSTR_TABREFCELLSROW              : { //rownr colnrfrom colnrto tabref -- result  
				String tabname = stack[sp].stringValue().toUpperCase();
				Integer tabind = tn.get(tabname);
				if (tabind==null) {
					stack[sp] = B.bf_error(V.getInstance("table '" + tabname + "' not found"));
				} else {
					stack[sp] = TciMachineTabaccess.getCellsRow(asm.tables[tabind], stack[sp-3], stack[sp-2], stack[sp-1]);
				}
				stack[sp--] = null;
				stack[sp--] = null;
				stack[sp--] = null;
				break;
			}
			case INSTR_TABREFCELL_CN               : { //rownr colname tabref -- result  
				String tabname = stack[sp].stringValue().toUpperCase();
				Integer tabind = tn.get(tabname);
				if (tabind==null) {
					stack[sp] = B.bf_error(V.getInstance("table '" + tabname + "' not found"));
				} else {
					stack[sp] = TciMachineTabaccess.getCellByName(asm.tables[tabind], stack[sp-2], stack[sp-1]);
				}
				stack[sp--] = null;
				stack[sp--] = null;
				break;
			}
			case INSTR_TABREFCELLS_CN              : { //rownrfrom rownrto colnamefrom colnameto tabref -- result  
				String tabname = stack[sp].stringValue().toUpperCase();
				Integer tabind = tn.get(tabname);
				if (tabind==null) {
					stack[sp] = B.bf_error(V.getInstance("table '" + tabname + "' not found"));
				} else {
					stack[sp] = TciMachineTabaccess.getCellsByName(asm.tables[tabind], stack[sp-4], stack[sp-3], stack[sp-2], stack[sp-1]);
				}
				stack[sp--] = null;
				stack[sp--] = null;
				stack[sp--] = null;
				stack[sp--] = null;
				break;
			}
			case INSTR_TABREFCELLSCOL_CN           : { //rownrfrom rownrto colname tabref -- result  
				String tabname = stack[sp].stringValue().toUpperCase();
				Integer tabind = tn.get(tabname);
				if (tabind==null) {
					stack[sp] = B.bf_error(V.getInstance("table '" + tabname + "' not found"));
				} else {
					stack[sp] = TciMachineTabaccess.getCellsColumnByName(asm.tables[tabind], stack[sp-3], stack[sp-2], stack[sp-1]);
				}
				stack[sp--] = null;
				stack[sp--] = null;
				stack[sp--] = null;
				break;
			}
			case INSTR_TABREFCELLSROW_CN           : { //rownr colnamefrom colnameto tabref -- result  
				String tabname = stack[sp].stringValue().toUpperCase();
				Integer tabind = tn.get(tabname);
				if (tabind==null) {
					stack[sp] = B.bf_error(V.getInstance("table '" + tabname + "' not found"));
				} else {
					stack[sp] = TciMachineTabaccess.getCellsRowByName(asm.tables[tabind], stack[sp-3], stack[sp-2], stack[sp-1]);
				}
				stack[sp--] = null;
				stack[sp--] = null;
				stack[sp--] = null;
				break;
			}
			case INSTR_TABREFFINDEXACT             : { //"nargs", OPTYPE_BYTE) //arg1 ... arg_nargs tabref -- result
				sp = sp - op1 - 1 + 1;
				String tabname = stack[sp+op1].stringValue().toUpperCase();
				Integer tabind = tn.get(tabname);
				if (tabind==null) {
					B.bf_error(V.getInstance("table '" + tabname + "' not found"));
				} else {
					stack[sp] = TciMachineTabaccess.findExact(asm.tables[tabind], Arrays.copyOfRange(stack, sp, sp+op1));
				}
				Arrays.fill(stack, sp+1, sp+op1+1, null);
				break;
			}
			case INSTR_TABREFFINDEXACTCOLUMN       : { //"nargs", OPTYPE_BYTE) //arg1 ... arg_nargs colname tabref -- result
				sp = sp - op1 - 2 + 1;
				String tabname = stack[sp+op1+1].stringValue().toUpperCase();
				Integer tabind = tn.get(tabname);
				if (tabind==null) {
					B.bf_error(V.getInstance("table '" + tabname + "' not found"));
				} else {
					stack[sp] = TciMachineTabaccess.findExactColumn(asm.tables[tabind], stack[sp+op1], Arrays.copyOfRange(stack, sp, sp+op1));
				}
				Arrays.fill(stack, sp+1, sp+op1+2, null);
				break;
			}
			case INSTR_TABREFFINDINTERVALDOWNCOLUMN: { //"nargs", OPTYPE_BYTE) //arg1 ... arg_nargs colname tabref -- result
				sp = sp - op1 - 2 + 1;
				String tabname = stack[sp+op1+1].stringValue().toUpperCase();
				Integer tabind = tn.get(tabname);
				if (tabind==null) {
					B.bf_error(V.getInstance("table '" + tabname + "' not found"));
				} else {
					stack[sp] = TciMachineTabaccess.findIntervalDownColumn(asm.tables[tabind], stack[sp+op1], Arrays.copyOfRange(stack, sp, sp+op1));
				}
				Arrays.fill(stack, sp+1, sp+op1+2, null);
				break;
			}
			case INSTR_TABREFFINDINTERVALUP        : { //arg tabref -- result
				String tabname = stack[sp].stringValue().toUpperCase();
				Integer tabind = tn.get(tabname);
				if (tabind==null) {
					B.bf_error(V.getInstance("table '" + tabname + "' not found"));
				} else {
					stack[sp] = TciMachineTabaccess.findIntervalUp(asm.tables[tabind], new V[]{ stack[sp-1] });
				}
				stack[sp--] = null;
				break;
			}
			case INSTR_TABREFFINDINTERVALUPCOLUMN  : { //"nargs", OPTYPE_BYTE) //arg1 ... arg_nargs colname tabref -- result
				sp = sp - op1 - 2 + 1;
				String tabname = stack[sp+op1+1].stringValue().toUpperCase();
				Integer tabind = tn.get(tabname);
				if (tabind==null) {
					B.bf_error(V.getInstance("table '" + tabname + "' not found"));
				} else {
					stack[sp] = TciMachineTabaccess.findIntervalUpColumn(asm.tables[tabind], stack[sp+op1], Arrays.copyOfRange(stack, sp, sp+op1));
				}
				Arrays.fill(stack, sp+1, sp+op1+2, null);
				break;
			}
			case INSTR_TABREFFINDROWEXACT          : { //"nargs", OPTYPE_BYTE) //arg1 ... arg_nargs tabref -- result
				sp = sp - op1 - 1 + 1;
				String tabname = stack[sp+op1].stringValue().toUpperCase();
				Integer tabind = tn.get(tabname);
				if (tabind==null) {
					B.bf_error(V.getInstance("table '" + tabname + "' not found"));
				} else {
					stack[sp] = V.getInstance(TciMachineTabaccess.findRowExact(asm.tables[tabind], Arrays.copyOfRange(stack, sp, sp+op1)));
				}
				Arrays.fill(stack, sp+1, sp+op1+1, null);
				break;
			}
			case INSTR_TABROWS                     : //tabref -- n
				stack[sp] = V.getInstance(asm.tables[(int)stack[sp].longValue()].rows);
				break;
			case INSTR_TIMES_INCTOP: // --
				this.incTimesCounterTop();
				break;
			case INSTR_TIMES_POP: // --
				this.popTimesCounter();
				break;
			case INSTR_TIMES_PUSH: // timesid --
				this.pushTimesCounter((int) stack[sp].longValue());
				stack[sp--] = null;
				break;
			case INSTR_TREE_NODECALCFORMULA: { // nodeid calcid -- formulaid
				NodeCalc nodecalc = asm.nodes[(int) stack[sp-1].longValue()].nodecalcList[(int) stack[sp].longValue()];
				stack[sp-1] = nodecalc!=null ? V.getInstance(nodecalc.formula) : VNull.vnull;
				stack[sp--] = null;
				break;
			}
			case INSTR_TREE_NODECALCOWN: { // nodeid calcid -- bool
				Node node = asm.nodes[(int) stack[sp-1].longValue()];
				stack[sp-1] = node.nco.get((int) stack[sp].longValue()) ? VDouble.vdbl1 : VDouble.vdbl0;
				stack[sp--] = null;
				break;
			}
			case INSTR_TREE_NODECALCTOTAL: { // nodeid calcid -- bool
				Node node = asm.nodes[(int) stack[sp-1].longValue()];
				stack[sp-1] = node.nct.get((int) stack[sp].longValue()) ? VDouble.vdbl1 : VDouble.vdbl0;
				stack[sp--] = null;
				break;
			}
			case INSTR_TREE_NODEFORMULAINC: { // nodeid -- formulaid
				Integer formulaint = asm.nodes[(int) stack[sp].longValue()].formulaInclusion;
				stack[sp] = formulaint!=null ? V.getInstance(formulaint.intValue()) : VNull.vnull;
				break;
			}
			case INSTR_TREE_NODEFORMULATIMES: { // nodeid -- formulaid
				Integer formulaint = asm.nodes[(int) stack[sp].longValue()].formulaTimes;
				stack[sp] = formulaint!=null ? V.getInstance(formulaint.intValue()) : VNull.vnull;
				break;
			}
			case INSTR_TREE_NODETIMESID:      { // nodeid -- timesid   
				stack[sp] = V.getInstance(asm.nodes[(int) stack[sp].longValue()].counterId);
				break;
			}
			case INSTR_TREE_SUBNODES_COUNTER: { // nodeid -- counter
				int[] myedges = edges[(int) stack[sp].longValue()];
				stack[sp] = myedges!=null ? V.getInstance(myedges.length) : VDouble.vdbl0;
				break;
			}
			case INSTR_TREE_SUBNODES_GET: { // nodeid ind -- subnodeid
				int[] myedges = edges[(int) stack[sp-1].longValue()];
				stack[sp-1] = myedges!=null ? V.getInstance(myedges[(int) stack[sp].longValue()]) : VNull.vnull;
				stack[sp--] = null;
				break;
			}
			case INSTR_UNMINUS                     : // n -- (-n)
				stack[sp] = V.getInstance(-stack[sp].doubleValue());
				break;
			case INSTR_UNPLUS                      : // n -- (n+0)
				stack[sp] = V.getInstance(stack[sp].doubleValue());
				break;
			case INSTR_XOR                         : // b1 b2 -- b1 XOR b2 
				stack[sp-1] = stack[sp-1].booleanValue() ^ stack[sp].booleanValue() ? VDouble.vdbl1 : VDouble.vdbl0;
				stack[sp--] = null;
				break;
			default:
				throw new ExceptionCalculation("invalid instruction: " + instrid, null);
			} //end of dispatch switch

			if (call_formulaid>=0) {
				//xxx ProfilingFormula prof = profilingData.getProfilingFormula(call_formulaid);
				//xxx prof.incCounter();
				boolean memoactive = !asm.formulaSimple[call_formulaid];
				boolean done = false;
//				if (prof.counter>10 && (prof.memoactive || prof.counter<=50))  {
//				if (prof.memoactive)  {
				if (memoactive)  {
					//xxx prof.cacheLookup();
					Object key = getCacheKey(asm.formulaOffset[call_formulaid], call_args!=null ? call_args : Arrays.copyOfRange(stack, call_bp, call_bp + call_nargs));
					V tmp = readCache(key);
					if (tmp!=null) {
						//prof.cacheHit();
						if (TRACE) {
							indent();
							System.out.print("found result in cache: ");
							System.out.print(tmp);
							System.out.println();
						}
						sp = call_bp;
						stack[sp] = tmp;
						if (call_args==null && call_nargs>1) {
							Arrays.fill(stack, sp+1, sp+call_nargs, null);
						}
						done = true;
					} else {
						keystack[++ksp] = key;
						callstack[csp+3] = 1; //with caching
					}
				} else {
					callstack[csp+3] = 0; //no caching
					/* counter-based */
//					if (!prof.issimple && prof.counter>100) {
//						prof.memoactive = true;
//					}
				}
					
				if (!done) {
					callstack[csp] = pc;
					callstack[csp+1] = bp;
					callstack[csp+2] = call_formulaid;
					//xxx callstack[csp+4] = prof.startTimer(csp);
					csp += 5;
					bp = call_bp;
					if (call_args!=null && call_nargs>0) {
						System.arraycopy(call_args,  0, stack, bp, call_nargs); //copy arguments to stack
					}
					pc = asm.formulaOffset[call_formulaid];
					sp = bp + asm.formulaMaxvar[call_formulaid] - 1;
					indent++;
				}
			}
			if (pc<0) {
				break;
			}
			
			if (TRACE) {
				indent();
				System.out.print(pc + ": ");
				Instruction instr = TciAssembler.getInstructionById(instrid);
				System.out.print(instr.getName());
				for (int i=0; i<instr.getOpSize(); i++) {
					System.out.print(' ');
					System.out.print(instr.getOpname(i));
					System.out.print('=');
					switch(i) {
					case 0: System.out.print(op1); break;
					case 1: System.out.print(op2); break;
					case 2: System.out.print(op3); break;
					case 3: System.out.print(op4); break;
					}
				}
				System.out.print(", stack after : ");
				System.out.print(Arrays.toString(Arrays.copyOfRange(stack, bp, sp+1)));
				System.out.print(", callstack after : ");
				System.out.print(Arrays.toString(Arrays.copyOf(callstack, csp)));
				System.out.print(", timescounter after: ");
				for (int it=0; it<this.timesSize; it++) {
					long tv = this.timesStack[it];
					int counter = (int) ((tv >>32) & 0xFFFF);
					int timesid = (int) ( tv       & 0xFFFF);
					System.out.print(timesid + "=" + counter + " ");
				}
				System.out.print(", keystack after: ");
				System.out.print(Arrays.toString(Arrays.copyOf(keystack, ksp+1)));
				System.out.println();
			}
			/* decode operation */
			instrid = bytecode[pc++] & 0xFF;
			if (instrid > 0x7F) { //additional operands?
				instrid = instrid & 0x7F;
				int opdescr = bytecode[pc++] & 0xFF;
				int optype = opdescr & 0x3;
				// op<n>: 00 done, 01 byte, 11 int
				switch(optype) {
				case 1:	
					op1 = bytecode[pc++] & 0xFF; 
					break;
				case 2:
			        op1 = ((bytecode[pc++] & 0xFF)<< 8)
				        | ((bytecode[pc++] & 0xFF)    );
			        break;
				case 3:
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
						op2 = bytecode[pc++] & 0xFF; 
						break;
					case 2:
				        op2 = ((bytecode[pc++] & 0xFF)<< 8)
					        | ((bytecode[pc++] & 0xFF)    );
				        break;
					case 3:
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
							op3 = bytecode[pc++] & 0xFF; 
							break;
						case 2:
					        op3 = ((bytecode[pc++] & 0xFF)<< 8)
						        | ((bytecode[pc++] & 0xFF)    );
					        break;
						case 3:
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
								op4 = bytecode[pc++] & 0xFF; 
								break;
							case 2:
						        op4 = ((bytecode[pc++] & 0xFF)<< 8)
							        | ((bytecode[pc++] & 0xFF)    );
						        break;
							case 3:
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
			/* decoding done ... have instrid, op1, op2, op3, op4 */

		} //end of interpreter loop
		
		/* return top of stack as result */
		ret = stack[sp];
		if (TRACE) {
			indent(); 
			System.out.println("exit with value " + ret.stringValue()); 
		}
		/* clean up the stack */
		Arrays.fill(stack, 0, sp+1, null);
		return ret;
	}
	
	@Override
	public void trace(String msg, String result, Traceaction action) {
	}
}
