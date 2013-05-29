package treecalc.vm;

import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

import treecalc.rt.S;
import treecalc.vm.asm.TciAssembler;
import treecalc.vm.asm.TciDisassembler;
import treecalc.vm.asm.TciLexer;
import treecalc.vm.asm.TciParser;
import treecalc.vm.asm.TciAssembler.Asm;

public class TciAction {
	static S vm;

	static String[] calculate(String[] what, int times) {
		long time = -System.currentTimeMillis();
		int size = what.length;
		String[] results = new String[size];
		for (int i=times; --i>=0; ) {
			for (int j=0; j<size; j++) {
				String what1 = what[j];
				results[j] = vm.calculate(what1);
			}
		}
		for (int j=0; j<size; j++) {
			System.out.println(what[j] + " = " + results[j]);
		}
		time+= System.currentTimeMillis();
		System.out.println(times + " * " + size + " calculations done in " + time + " ms");
		return results;
	}
	
	static String calculate(String what) {
		System.out.println("start calculate " + what);
		String result = vm.calculate(what);
		System.out.println(what + " = " + result);
		return result;
	}

	/**
	 * @param args
	 * @throws IOException 
	 * @throws RecognitionException 
	 */
	public static void main(String[] args) throws IOException, RecognitionException {
		TciAssembler assembler = new TciAssembler();
		
//		ANTLRFileStream fs = new ANTLRFileStream("c:/ws-tc/tcjava/src/main/java/gen/li/gen.li.tci"); 
		ANTLRFileStream fs = new ANTLRFileStream("C:/ws-tc/hackhofer-tc-gen2-lib/src/test/java/gen/aqxxx/gen.aqxxx.tci"); 
		TciLexer lexer = new TciLexer(fs);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TciParser parser = new TciParser(tokens, assembler);
		parser.tci();
		System.out.println(TciAction.class.getName() + ": done.");
		Asm asm = assembler.getAsm();
		TciDisassembler.print(asm, System.out, false);
//		TciAsmReaderWriter.write(asm, "C:/ws-tc/tcjava/src/main/java/gen/uro_li_endow/gen.uro_li_endow.tcx");
//		asm = TciAsmReaderWriter.read("C:/ws-tc/tcjava/src/main/java/gen/uro_li_endow/gen.uro_li_endow.tcx");
		
		vm = new TciMachine(asm);
//		long id = vm.getCalculateId("F_Test(1;2)");
//		long idfact = vm.getCalculateId("F_Fact(1)");
//		String result=null;
//		String result2=null;
//		for (int i=0; i<100000; i++) {
//			result = vm.calculate(id, "1", "2");
//			result2 = vm.calculate(idfact, 50);
//		}
//		time+= System.currentTimeMillis();
//		System.out.println("F_Test(1;2)=" + result + ", F_Fact(30)=" + result2 + " done in " + time + " ms");
		

		vm.setInput("I1", "1");
		vm.setInput("I1[1]", "2");
		String[] calc = new String[] {
//				"F_LI_qx(40, 1, 0)"
//				,"F_LI_vn(0.035; 5)"
//				,"F_LI_Lx(50, 1, 0)"
//				,"F_LI_Dx(50; 1; 0.035; 0)"
//				,"F_LI_Nx(50; 1; 0.035; 0)"
//				,"F_LI_Mx(50; 1; 0.035; 0)"
//				,"F_LI_Rx(50; 1; 0.035; 0)"
//				,"F_LI_nAx(50;1; 0.035; 0; 20)"
//				,"F_LI_nEx(50;1; 0.035; 0; 20)"
//				,"F_LI_aexn(50;1; 0.035; 0; 20)"
//				,"F_LI_aexn_k(50;1; 0.035; 0; 20; 5)"
//				,"F_LI_alpha(1, 1, 201109)"
//				,"PX_Testtop"
//				,"PX_Test1"
//				,"PX_Test2"
//				,"PX_Test3"
//				 "PX_Test"
//				 "PX_Testx"
//			     "PX_I1"
  				  "PX_I1_AC"
				 ,"PX_I1_0"
				 ,"PX_I1_1"
				 ,"PX_I1_unchecked"
				 ,"PX_I1_unchecked1"
//				, "I1[0]"
//				, "I1[1]"
//				, "PX_I2"
				};
		calculate(calc, 1);
	}
}