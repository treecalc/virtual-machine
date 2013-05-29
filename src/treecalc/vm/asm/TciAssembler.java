package treecalc.vm.asm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map.Entry;

import org.antlr.runtime.Token;

import static treecalc.vm.TciMachine.*;

/**
 * @author Stefan
 *
 */
public class TciAssembler {
    private byte[] bytecode = new byte[2 * 1024 * 1024];
    private int bytecodeOffset=0;
	private Formula currentformula;

    /* TODO: optimizations on TciVM-code
     * pushconst 0, pushconst 1, pushconst "" -> use pushconst0, pushconst1
     * jump locations: now always 4byte because of backpatching -> change to depend on actual size
     * superinstructions, e.g. pushconst0, cmpbig, iffalse -> ifsmleq; gleiches mit pushconst n
     *       pushconst0, eq, iffalse -> ifneq; gleiches mit pushconst n
     *       pushconst n, cmpsml, iffalse -> ifconstbigeq
     *       pushconst 1, add -> add1
     *       ...
     *       load i, load i+1, ..., load n -> loadrange i n
     *       load 0 -> load0, ...
     *       eq iftrue -> ifeq, ...
     * pushconst xx, pushconst xx -> pushconst xx, dup
     * pushconst0, add -> unplus 
     * goto xx, xx:return -> return
     */
    
	public static final int OPTYPE_NONE  = 0;
	public static final int OPTYPE_LABEL = 1;
	public static final int OPTYPE_BYTE  = 2;
	public static final int OPTYPE_SHORT = 3;
	public static final int OPTYPE_INT   = 4;
	public static final int OPTYPE_CONST = 5;

	public static final Instruction[] instructions = new Instruction[] {
		    new Instruction(INSTR_ADD                           , "add"                          , -1,  0) //a b -- a+b
  		  , new Instruction(INSTR_ADDNOTNULL                    , "addnotnull"                   , -1,  0) //a b -- a+b if none null; a or b if one of them if the other is null; null otherwise
		  , new Instruction(INSTR_AND                           , "and"                          , -1,  0) //a b -- a&&b
		  , new Instruction(INSTR_BIGEQ0                        , "bigeq0"                       ,  0,  0) //a -- a>=0
		  , new Instruction(INSTR_BUILTIN                       , "builtin"                      , +1, -2, "builtinid", OPTYPE_BYTE, "nargs", OPTYPE_INT) //arg1 ... arg_nargs -- result
  		  , new Instruction(INSTR_CALLDYNFUNC                   , "calldynfunc"                  ,  0, -1, "nargs", OPTYPE_BYTE) //arg1 ... arg_nargs funcref -- result 
     	  , new Instruction(INSTR_CALLFORMULA                   , "callformula"                  , +1, -2, "formulaid", OPTYPE_INT, "nargs", OPTYPE_BYTE) //arg1 ... arg_nargs -- result
     	  , new Instruction(INSTR_CALLFORMULADYN                , "callformuladyn"               , -2,  0) //formulaid nargs args_list -- result
   		  , new Instruction(INSTR_CALLFUNC                      , "callfunc"                     , +1, -2, "funcid", OPTYPE_INT, "nargs", OPTYPE_BYTE) //arg1 ... arg_nargs -- result
  		  , new Instruction(INSTR_CALLNODECALC                  , "callnodecalc"                 , +1, -3, "nodeid", OPTYPE_INT, "calcid", OPTYPE_INT, "nargs", OPTYPE_BYTE) // arg1 ... arg_nargs -- result
  		  , new Instruction(INSTR_CALLNODECALCLIST              , "callnodecalclist"             , +1, -3, "nodeid", OPTYPE_INT, "calcid", OPTYPE_INT, "nargs", OPTYPE_BYTE, "selfcall", OPTYPE_BYTE) // arg1 ... arg_nargs -- result
  		  , new Instruction(INSTR_CALLNODECALCSUM               , "callnodecalcsum"              , +1, -3, "nodeid", OPTYPE_INT, "calcid", OPTYPE_INT, "nargs", OPTYPE_BYTE, "selfcall", OPTYPE_BYTE) // arg1 ... arg_nargs -- result
   		  , new Instruction(INSTR_CMPBIG                        , "cmpbig"                       , -1,  0) // a b -- a> b (numerical)
   		  , new Instruction(INSTR_CMPBIGEQ                      , "cmpbigeq"                     , -1,  0) // a b -- a>=b (numerical)
   		  , new Instruction(INSTR_CMPNEQ                        , "cmpneq"                       , -1,  0) // a b -- a!=b (numerical)
   		  , new Instruction(INSTR_CMPSEQ                        , "cmpseq"                       , -1,  0) // a b -- a==b (string case-sensitive)
   		  , new Instruction(INSTR_CMPSEQI                       , "cmpseqi"                      , -1,  0) // a b -- a==b (string case-insensitive)
   		  , new Instruction(INSTR_CMPSG                         , "cmpsg"                        , -1,  0) // a b -- a> b (string case-sensitive)
   		  , new Instruction(INSTR_CMPSGEQ                       , "cmpsgeq"                      , -1,  0) // a b -- a>=b (string case-sensitive)
   		  , new Instruction(INSTR_CMPSGEQI                      , "cmpsgeqi"                     , -1,  0) // a b -- a>=b (string case-insensitive)
   		  , new Instruction(INSTR_CMPSGI                        , "cmpsgi"                       , -1,  0) // a b -- a> b (string case-insensitive)
   		  , new Instruction(INSTR_CMPSL                         , "cmpsl"                        , -1,  0) // a b -- a< b (string case-sensitive)
   		  , new Instruction(INSTR_CMPSLEQ                       , "cmpsleq"                      , -1,  0) // a b -- a<=b (string case-sensitive)
   		  , new Instruction(INSTR_CMPSLEQI                      , "cmpsleqi"                     , -1,  0) // a b -- a<=b (string case-insensitive)
   		  , new Instruction(INSTR_CMPSLI                        , "cmpsli"                       , -1,  0) // a b -- a< b (string case-insensitive)
   		  , new Instruction(INSTR_CMPSML                        , "cmpsml"                       , -1,  0) // a b -- a< b (numerical)
   		  , new Instruction(INSTR_CMPSMLEQ                      , "cmpsmleq"                     , -1,  0) // a b -- a<=b (numerical)
  		  , new Instruction(INSTR_CMPSNEQ                       , "cmpsneq"                      , -1,  0) // a b -- a!=b (string case-sensitive)   
   		  , new Instruction(INSTR_CMPSNEQI                      , "cmpsneqi"                     , -1,  0) // a b -- a!=b (string case-insensitive)
  		  , new Instruction(INSTR_CREATELIST0                   , "createlist0"                  , +1,  0) // -- empty list
  		  , new Instruction(INSTR_CREATELIST1                   , "createlist1"                  ,  0,  0) // a -- list(a)
    	  , new Instruction(INSTR_CREATELISTN                   , "createlistn"                  ,  0,  0) // n -- list with max capacity n
   		  , new Instruction(INSTR_DIV                           , "div"                          , -1,  0) // d1 d2 -- d1/d2
   		  , new Instruction(INSTR_DIVINT                        , "divint"                       , -1,  0) // d1 d2 -- d1 DIV d2
  		  , new Instruction(INSTR_DUP                           , "dup"                          , +1,  0) // a -- a a
   		  , new Instruction(INSTR_DYNCOMPUTE                    , "dyncompute"                   , -1,  0) // modelname calculatestring -- result 
   		  , new Instruction(INSTR_ERROR                         , "error"                        , -1,  0) // msg --  
   		  , new Instruction(INSTR_EQ                            , "eq"                           , -1,  0) // n1 n2 -- n1==n2 (numerical) 
  		  , new Instruction(INSTR_GETFUNCREF                    , "getfuncref"                   ,  0,  0) // funcname -- funcref
  		  , new Instruction(INSTR_GETINPUT                      , "getinput"                     , +1, -2, "inputid", OPTYPE_INT, "nargs", OPTYPE_BYTE) //arg1 ... arg_nargs -- result 
  		  , new Instruction(INSTR_GETINPUT0                     , "getinput0"                    , +1,  0, "inputid", OPTYPE_INT) // -- result 
  		  , new Instruction(INSTR_GETINPUTCALC                  , "getinputcalc"                 , +1, -2, "inputid", OPTYPE_INT, "inputcalcid", OPTYPE_INT, "nargs", OPTYPE_BYTE) // -- result
  		  , new Instruction(INSTR_GETINPUTCALC0                 , "getinputcalc0"                , +1,  0, "inputid", OPTYPE_INT, "inputcalcid", OPTYPE_INT) // -- result
  		  , new Instruction(INSTR_GETINPUTRAW                   , "getinputraw"                  , +1, -2, "inputid", OPTYPE_INT, "nargs", OPTYPE_BYTE) // arg1 ... arg_nargs -- result 
  		  , new Instruction(INSTR_GETINPUTRAW0                  , "getinputraw0"                 , +1,  0, "inputid", OPTYPE_INT) // -- result 
  		  , new Instruction(INSTR_GETINPUTRAWSELF               , "getinputrawself"              ,  0,  0, "inputid", OPTYPE_INT) // index -- result 
  		  , new Instruction(INSTR_GOTO                          , "goto"                         ,  0,  0, "label", OPTYPE_LABEL) // --  ; pc set 
  		  , new Instruction(INSTR_IFBIG                         , "ifbig"                        , -2,  0, "label", OPTYPE_LABEL) // a b --   ; pc set if a>b 
  		  , new Instruction(INSTR_IFBIGEQ                       , "ifbigeq"                      , -2,  0, "label", OPTYPE_LABEL) // a b --   ; pc set if a>=b
  		  , new Instruction(INSTR_IFFALSE                       , "iffalse"                      , -1,  0, "label", OPTYPE_LABEL) // a --     ; pc set if a==false(0)
   		  , new Instruction(INSTR_IFNOTNULL                     , "ifnotnull"                    , -2,  0, "label", OPTYPE_LABEL) // a --     ; pc set if a is not null  
   		  , new Instruction(INSTR_IFNULL                        , "ifnull"                       , -2,  0, "label", OPTYPE_LABEL) // a --     ; pc set if a is null 
   		  , new Instruction(INSTR_IFNUMEQUAL                    , "ifnumequal"                   , -2,  0, "label", OPTYPE_LABEL) // a b --   ; pc set if a==b (numerical) 
  		  , new Instruction(INSTR_IFSEQI                        , "ifseqi"                       , -2,  0, "label", OPTYPE_LABEL) // a b --   ; pc set if a==b (string case-insensitive)
  		  , new Instruction(INSTR_IFSML                         , "ifsml"                        , -2,  0, "label", OPTYPE_LABEL) // a b --   ; pc set if a<b
  		  , new Instruction(INSTR_IFSMLEQ                       , "ifsmleq"                      , -2,  0, "label", OPTYPE_LABEL) // a b --   ; pc set if a<=b
  		  , new Instruction(INSTR_IFTRUE                        , "iftrue"                       , -1,  0, "label", OPTYPE_LABEL) // a   --   ; pc set if a==true(1)
  		  , new Instruction(INSTR_IFZERO                        , "ifzero"                       , -1,  0, "label", OPTYPE_LABEL) // a   --   ; pc set if a==0
  		  , new Instruction(INSTR_INPUTTESTNULL                 , "inputtestnull"                ,  0,  0) // inputdescr -- b
  		  , new Instruction(INSTR_LISTAPPENDELEM1               , "listappendelem1"              , -1,  0) // list a -- list(..., a)  ; existing list is changed!  
  		  , new Instruction(INSTR_LISTELEM1                     , "listelem1"                    , -1,  0) // n list -- a    ;list[n]
  		  , new Instruction(INSTR_LOAD                          , "load"                         , +1,  0, "varid", OPTYPE_BYTE) // -- a      ; local var [varid] 
   		  , new Instruction(INSTR_MODINT                        , "modint"                       , -1,  0) // d1 d2 -- d1 % d2  
    	  , new Instruction(INSTR_MULT                          , "mult"                         , -1,  0) // d1 d2 -- d1*d2
    	  , new Instruction(INSTR_NOP                           , "nop"                          ,  0,  0) // --
  		  , new Instruction(INSTR_OVER                          , "over"                         , +1,  0) // a b -- a b a
   		  , new Instruction(INSTR_POP                           , "pop"                          , -1,  0) // a -- 
   		  , new Instruction(INSTR_POWER                         , "power"                        , -1,  0) // n1 n2 -- n1^n2
  		  , new Instruction(INSTR_PUSHCONST                     , "pushconst"                    , +1,  0, "constantid", OPTYPE_CONST) // -- a   ; taken from constant pool 
  		  , new Instruction(INSTR_PUSHCONST0                    , "pushconst0"                   ,  0,  0) // -- 0
  		  , new Instruction(INSTR_PUSHCONST1                    , "pushconst1"                   , +1,  0) // -- 1
   		  , new Instruction(INSTR_PUSHNULL                      , "pushnull"                     , +1,  0) // -- null
  		  , new Instruction(INSTR_PUSHTIMESCOUNTER              , "pushtimescounter"             , +1,  0, "counterid", OPTYPE_BYTE) // -- n  ; current value of times-counter with id==n1
    	  , new Instruction(INSTR_RETURN                        , "return"                       , -1,  0) // a --      ; pc set, stack frame removed etc.
    	  , new Instruction(INSTR_SAPPEND                       , "sappend"                      , -1,  0) // s1 s2 -- s3   ; s3==s1 & s2
  		  , new Instruction(INSTR_STORE                         , "store"                        , -1,  0, "varid", OPTYPE_BYTE) // a --      ; local var [varid] set to a
    	  , new Instruction(INSTR_SUB                           , "sub"                          , -1,  0) // n1 n2 -- (n1-n2)
       	  , new Instruction(INSTR_TABCELL                       , "tabcell"                      , -1,  0, "tableid", OPTYPE_INT) //rownr colnr -- result  
       	  , new Instruction(INSTR_TABCELL_CN                    , "tabcell_cn"                   , -1,  0, "tableid", OPTYPE_INT) //rownr colname -- result  
          , new Instruction(INSTR_TABCELLS                      , "tabcells"                     , -3,  0, "tableid", OPTYPE_INT) //rownrfrom rownrto colnrfrom colnrto -- result  
          , new Instruction(INSTR_TABCELLS_CN                   , "tabcells_cn"                  , -3,  0, "tableid", OPTYPE_INT) //rownrfrom rownrto colnamefrom colnameto -- result  
          , new Instruction(INSTR_TABCELLSCOL                   , "tabcellscol"                  , -2,  0, "tableid", OPTYPE_INT) //rownrfrom rownrto colnr -- result  
          , new Instruction(INSTR_TABCELLSCOL_CN                , "tabcellscol_cn"               , -2,  0, "tableid", OPTYPE_INT) //rownrfrom rownrto colname -- result  
       	  , new Instruction(INSTR_TABCELLSROW                   , "tabcellsrow"                  , -2,  0, "tableid", OPTYPE_INT) //rownr colnrfrom colnrto -- result  
       	  , new Instruction(INSTR_TABCELLSROW_CN                , "tabcellsrow_cn"               , -2,  0, "tableid", OPTYPE_INT) //rownr colnamefrom colnameto -- result  
   		  , new Instruction(INSTR_TABCOLS                       , "tabcols"                      ,  0,  0) //tabref -- n  
  		  , new Instruction(INSTR_TABFINDEXACT                  , "tabfindexact"                 ,  1, -2, "tableid", OPTYPE_INT, "nargs", OPTYPE_BYTE) //arg1 ... arg_nargs -- result
  		  , new Instruction(INSTR_TABFINDEXACTCOLUMN            , "tabfindexactcolumn"           ,  1, -2, "tableid", OPTYPE_INT, "nargs", OPTYPE_BYTE, "colind", OPTYPE_INT) // arg1 ... arg_nargs -- result
  		  , new Instruction(INSTR_TABFINDEXACTCOLUMNBYNAME      , "tabfindexactcolumnbyname"     ,  0, -2, "tableid", OPTYPE_INT, "nargs", OPTYPE_BYTE) //arg1 ... arg_nargs colname -- result
  		  , new Instruction(INSTR_TABFINDINTERVALDOWNCOLUMN     , "tabfindintervaldowncolumn"    ,  0, -2, "tableid", OPTYPE_INT, "nargs", OPTYPE_BYTE) //arg1 ... arg_nargs colname -- result
  		  , new Instruction(INSTR_TABFINDINTERVALUP             , "tabfindintervalup"            ,  0,  0, "tableid", OPTYPE_INT) //arg -- result
  		  , new Instruction(INSTR_TABFINDINTERVALUPCOLUMN       , "tabfindintervalupcolumn"      ,  0, -2, "tableid", OPTYPE_INT, "nargs", OPTYPE_BYTE) //arg1 ... arg_nargs colname -- result
  		  , new Instruction(INSTR_TABFINDROWEXACT               , "tabfindrowexact"              ,  1, -2, "tableid", OPTYPE_INT, "nargs", OPTYPE_BYTE) //arg1 ... arg_nargs -- result
       	  , new Instruction(INSTR_TABREFCELL                    , "tabrefcell"                   , -2,  0) //rownr colnr tabref -- result  
          , new Instruction(INSTR_TABREFCELLS                   , "tabrefcells"                  , -4,  0) //rownrfrom rownrto colnrfrom colnrto tabref -- result  
          , new Instruction(INSTR_TABREFCELLSCOL                , "tabrefcellscol"               , -3,  0) //rownrfrom rownrto colnr tabref -- result  
      	  , new Instruction(INSTR_TABREFCELLSROW                , "tabrefcellsrow"               , -3,  0) //rownr colnrfrom colnrto tabref -- result  
       	  , new Instruction(INSTR_TABREFCELL_CN                 , "tabrefcell_cn"                , -2,  0) //rownr colname tabref -- result  
          , new Instruction(INSTR_TABREFCELLS_CN                , "tabrefcells_cn"               , -4,  0) //rownrfrom rownrto colnamefrom colnameto tabref -- result  
          , new Instruction(INSTR_TABREFCELLSCOL_CN             , "tabrefcellscol_cn"            , -3,  0) //rownrfrom rownrto colname tabref -- result  
       	  , new Instruction(INSTR_TABREFCELLSROW_CN             , "tabrefcellsrow_cn"            , -3,  0) //rownr colnamefrom colnameto tabref -- result  
  		  , new Instruction(INSTR_TABREFFINDEXACT               , "tabreffindexact"              ,  0, -1, "nargs", OPTYPE_BYTE) //arg1 ... arg_nargs tabref -- result
  		  , new Instruction(INSTR_TABREFFINDEXACTCOLUMN         , "tabreffindexactcolumn"        , -1, -1, "nargs", OPTYPE_BYTE) //arg1 ... arg_nargs colname tabref -- result 
  		  , new Instruction(INSTR_TABREFFINDINTERVALDOWNCOLUMN  , "tabreffindintervaldowncolumn" , -1, -1, "nargs", OPTYPE_BYTE) //arg1 ... arg_nargs colname tabref -- result
  		  , new Instruction(INSTR_TABREFFINDINTERVALUP          , "tabreffindintervalup"         , -1,  0) //arg tabref -- result
  		  , new Instruction(INSTR_TABREFFINDINTERVALUPCOLUMN    , "tabreffindintervalupcolumn"   , -1, -1, "nargs", OPTYPE_BYTE) //arg1 ... arg_nargs colname tabref -- result
  		  , new Instruction(INSTR_TABREFFINDROWEXACT            , "tabreffindrowexact"           ,  0, -1, "nargs", OPTYPE_BYTE) //arg1 ... arg_nargs  tabref -- result
  		  , new Instruction(INSTR_TABROWS                       , "tabrows"                      ,  0,  0) //tabref -- n
	      , new Instruction(INSTR_TIMES_INCTOP                  , "times_inctop"                 ,  0,  0) // -- ; increments top times counter by 1
	      , new Instruction(INSTR_TIMES_POP                     , "times_pop"                    ,  0,  0) // -- ; pops top times counter
	      , new Instruction(INSTR_TIMES_PUSH                    , "times_push"                   , -1,  0) // timesid -- ; push times counter with value of 0
    	  , new Instruction(INSTR_TREE_NODECALCFORMULA          , "tree_nodecalcformula"         , -1,  0) // nodeid calcid -- formulaid
      	  , new Instruction(INSTR_TREE_NODECALCOWN              , "tree_nodecalcown"             , -1,  0) // nodeid calcid -- bool          
      	  , new Instruction(INSTR_TREE_NODECALCTOTAL            , "tree_nodecalctotal"           , -1,  0) // nodeid calcid -- bool
  		  , new Instruction(INSTR_TREE_NODEFORMULAINC           , "tree_nodeformulainc"          ,  0,  0) // nodeid -- formulaid          
  		  , new Instruction(INSTR_TREE_NODEFORMULATIMES         , "tree_nodeformulatimes"        ,  0,  0) // nodeid -- formulaid          
  		  , new Instruction(INSTR_TREE_NODETIMESID              , "tree_nodetimesid"             ,  0,  0) // nodeid -- timesid          
  		  , new Instruction(INSTR_TREE_SUBNODES_COUNTER         , "tree_subnodes_counter"        ,  0,  0) // nodeid -- counter          
  		  , new Instruction(INSTR_TREE_SUBNODES_GET             , "tree_subnodes_get"            , -1,  0) // nodeid index -- subnodeid          
  		  , new Instruction(INSTR_UNMINUS                       , "unminus"                      ,  0,  0) // n -- (-n)          
   		  , new Instruction(INSTR_UNPLUS                        , "unplus"                       ,  0,  0) // n -- (n+0)     
   		  , new Instruction(INSTR_XOR                           , "xor"                          , -1,  0) // b1 b2 -- b1 XOR b2 
	};
	private static HashMap<String, Instruction> instructionMap = new HashMap<String, Instruction>();
	private static Instruction[] instructionarr;
	static {
		int instridmax=0;
		for (Instruction instruction : instructions) {
			if (instruction.id > instridmax) {
				instridmax = instruction.id;
			}
			instructionMap.put(instruction.getName(), instruction);
		}
		instructionarr = new Instruction[instridmax+1];
		for (Instruction instruction : instructions) {
			instructionarr[instruction.id]= instruction; 
		}
	}
	
	public static Instruction getInstructionById(int instrid) {
		return instructionarr[instrid];
	}
	
	public static class Instruction {
        private final String name; // E.g., "add", "return"
        private final int id;
        private final int stackeffect; //e.g. 1 -> one more stack element than before call. -1 -> one stack element less (e.g. store)
        private final int stackeffectOp; //e.g. -2 -> number of elements popped is value of 2nd operand
        private final int[] optypes;
        private final String[] opnames;
        public Instruction(int id, String name, int stackeffect, int stackeffectOp) {
        	this.id = id;
        	this.name = name;
        	this.stackeffect = stackeffect;
        	this.stackeffectOp = stackeffectOp;
        	optypes = new int[0];
        	opnames = new String[0];
        }
        public Instruction(int id, String name, int stackeffect, int stackeffectOp, String opname1, int optype1) {
        	this.id = id;
        	this.name = name;
        	this.stackeffect = stackeffect;
        	this.stackeffectOp = stackeffectOp;
        	optypes = new int[1];
        	optypes[0] = optype1;
        	opnames = new String[1];
        	opnames[0] = opname1;
        }
        public Instruction(int id, String name, int stackeffect, int stackeffectOp, String opname1, int optype1, String opname2, int optype2) { 
        	this.id = id;
        	this.name = name;
        	this.stackeffect = stackeffect;
        	this.stackeffectOp = stackeffectOp;
        	optypes = new int[2];
        	optypes[0] = optype1;
        	optypes[1] = optype2;
        	opnames = new String[2];
        	opnames[0] = opname1;
        	opnames[1] = opname2;
        }
        public Instruction(int id, String name, int stackeffect, int stackeffectOp, String opname1, int optype1, String opname2, int optype2, String opname3, int optype3) {
        	this.id = id;
            this.name = name;
        	this.stackeffect = stackeffect;
        	this.stackeffectOp = stackeffectOp;
        	optypes = new int[3];
        	optypes[0] = optype1;
        	optypes[1] = optype2;
        	optypes[2] = optype3;
        	opnames = new String[3];
        	opnames[0] = opname1;
        	opnames[1] = opname2;
        	opnames[2] = opname3;
        }
        public Instruction(int id, String name, int stackeffect, int stackeffectOp, String opname1, int optype1, String opname2, int optype2, String opname3, int optype3, String opname4, int optype4) {
        	this.id = id;
            this.name = name;
        	this.stackeffect = stackeffect;
        	this.stackeffectOp = stackeffectOp;
        	optypes = new int[4];
        	optypes[0] = optype1;
        	optypes[1] = optype2;
        	optypes[2] = optype3;
        	optypes[3] = optype4;
        	opnames = new String[4];
        	opnames[0] = opname1;
        	opnames[1] = opname2;
        	opnames[2] = opname3;
        	opnames[3] = opname4;
        }
        public int getId() {
        	return id;
        }
        public String getName() {
        	return this.name;
        }
        public int getStackeffect() {
        	return this.stackeffect;
        }
        public int getStackeffectOp() {
        	return this.stackeffectOp;
        }
        public int getOpSize() {
        	return optypes.length;
        }
        public int getOptype(int index) {
        	return index<optypes.length ? optypes[index] : OPTYPE_NONE;
        }
        public String getOpname(int index) {
        	return index<opnames.length ? opnames[index] : "";
        }
    }
	
    public void gen(Token op) { gen(op, new Token[0]); }
    public void gen(Token op, Token operand1) { 
    	gen(op, new Token[] { operand1 } );
    }
    public void gen(Token op, Token operand1, Token operand2) {
    	gen(op, new Token[] { operand1, operand2 } );
    }
    public void gen(Token op, Token operand1, Token operand2, Token operand3) {
    	gen(op, new Token[] { operand1, operand2, operand3 } );
    }
    public void gen(Token op, Token operand1, Token operand2, Token operand3, Token operand4) {
    	gen(op, new Token[] { operand1, operand2, operand3, operand4 } );
    }
    
    private void bytecodeWriteByte(int bytevalue, int offset) {
    	bytecodeEnsureSize(offset);
    	bytecode[offset] = (byte) bytevalue ;
    }
    private void bytecodeWriteByte(int bytevalue) {
    	bytecodeEnsureSize(bytecodeOffset+1);
    	bytecode[bytecodeOffset] = (byte) bytevalue ;
    	bytecodeOffset++;
    }
    private void bytecodeWriteShort(int bytevalue) {
    	bytecodeEnsureSize(bytecodeOffset+2);
    	bytecode[bytecodeOffset  ] = (byte)((bytevalue>> 8) & 0xFF);
    	bytecode[bytecodeOffset+1] = (byte)( bytevalue      & 0xFF);
		bytecodeOffset+=2;
    }
    private void bytecodeWriteInt(int bytevalue) {
    	bytecodeEnsureSize(bytecodeOffset+4);
    	bytecode[bytecodeOffset  ] = (byte)((bytevalue>>24) & 0xFF);
    	bytecode[bytecodeOffset+1] = (byte)((bytevalue>>16) & 0xFF);
    	bytecode[bytecodeOffset+2] = (byte)((bytevalue>> 8) & 0xFF);
    	bytecode[bytecodeOffset+3] = (byte)( bytevalue      & 0xFF);
		bytecodeOffset+=4;
    }
    private void bytecodeEnsureSize(int size) {
    	if (bytecode.length<size) {
    		int newsize = bytecode.length + 1 * 1024 * 1024;
    		bytecode = Arrays.copyOf(bytecode, newsize);
    	}
    }
    private void gen(Token op, Token...operands) {
    	String opName = op.getText();
    	Instruction instr = instructionMap.get(opName);
    	if (instr==null) {
    		throw new RuntimeException("unknown tc-assembler instruction: " + opName);
    	}
    	boolean loadstore = instr.id == INSTR_LOAD || instr.id == INSTR_STORE;
    	int opsize = instr.getOpSize();
    	if (opsize != operands.length) {
    		throw new RuntimeException("line " + op.getLine() + ": got operation " + opName + " with " + operands.length + " operands, but need " + opsize + ". " + Arrays.toString(operands));
    	}
    	//1st byte: highest bit 0 if no additional operands, 1 if there is at least one
    	int bytevalue = instr.getId();
    	if (opsize>0) {
    		bytevalue |= 0x80;
    	}
    	bytecodeWriteByte( bytevalue );
    	
    	/* if more than operand: 2nd byte with 2 bits per operand
    	 * b7 b6 b5 b4 b3 b2 b1 b0
    	 * [b1 b0]: description of first operand 
    	 *   00 ... not possible because then highest bit of 1st byte would be 0 
    	 *   01 ... byte value
    	 *   11 ... int value
    	 * [b3 b2]: second operand
    	 *   00 ... only one operand 
    	 *   01 ... byte value
    	 *   11 ... int value
    	 * [b5 b4]: third operand
    	 *   00 ... only one operand 
    	 *   01 ... byte value
    	 *   11 ... int value
    	 * [b7 b6]: fourth operand
    	 *   00 ... only one operand 
    	 *   01 ... byte value
    	 *   11 ... int value
    	 */
    	if (opsize>0) {
    		int optypePosition = bytecodeOffset;
    		int optypeValue = 0;
    		bytecodeWriteByte(0); // placeholder
	    	bytevalue = 0;
	    	// op4 op3 op2 op1
	    	// op<n>: 00 done, 01 byte, 11 int
	    	for (int i=0; i<operands.length; i++) {
	    		int opType = instr.getOptype(i);
	    		
	    		/* check how much space is needed for operand ... byte/short/int */
	    		Token token = operands[i];
	    		String tokenstr = operands[i].getText();
	    		switch(opType) {
	    		case OPTYPE_BYTE :
	    			bytevalue = Integer.parseInt(tokenstr);
	    			if (bytevalue>0xFF) {
	    				throw new RuntimeException("value for operand too high... is limited to 255, but got " + bytevalue + ", line " + operands[i].getLine());
	    			}
	    			bytecodeWriteByte( bytevalue );
	    			opType = OPTYPE_BYTE;
	    			break;
	    			
	    		case OPTYPE_INT  : 
	    			bytevalue = Integer.parseInt(tokenstr);
	    			if (bytevalue <= 0xFF) {
	    				opType = OPTYPE_BYTE;
		    			bytecodeWriteByte( bytevalue );
	    			} else if (bytevalue <= 0xFFFF) {
	    				opType = OPTYPE_SHORT;
		    			bytecodeWriteShort( bytevalue );
	    			} else {
	    				opType = OPTYPE_INT;
		    			bytecodeWriteInt( bytevalue );
	    			}
	    			break;
	    			
	    		case OPTYPE_CONST:
	    			bytevalue = defineConstantId(token);
	    			if (bytevalue <= 0xFF) {
	    				opType = OPTYPE_BYTE;
		    			bytecodeWriteByte( bytevalue );
	    			} else if (bytevalue <= 0xFFFF) {
	    				opType = OPTYPE_SHORT;
		    			bytecodeWriteShort( bytevalue );
	    			} else {
	    				opType = OPTYPE_INT;
		    			bytecodeWriteInt( bytevalue );
	    			}
	    	        break;
	    			
	    		case OPTYPE_LABEL:
	    			bytevalue = getLabel(tokenstr); //will be 0 when not defined yet --> need worst case (4 bytes)
	    			opType = OPTYPE_INT;
	    			bytecodeWriteInt( bytevalue );
	    	        break;
	    		default:
	    			throw new RuntimeException("invalid operand type: " + opType);
	    		}
                int bitsType = 0;
	    		switch(opType) {
	    		case OPTYPE_BYTE :
	    			bitsType = (byte) 0x1;
	    			break;
	    		case OPTYPE_SHORT :
	    			bitsType = (byte) 0x2;
	    			break;
	    		case OPTYPE_INT  : 
	    			bitsType = (byte) 0x3;
	    			break;
	    		default:
	    			throw new RuntimeException("invalid operand type: " + opType + " for instruction " + opName+ ", line " + op.getLine());
	    		}
	    		optypeValue |= bitsType << (i*2); //2 bits per operand from right to left
	    		if (loadstore) { //has one operand, and that is the index 
	    			if ((bytevalue+1) > currentformula.maxvar) {
	    				currentformula.maxvar = (bytevalue)+1;
	    			}
	    		}
	    	} //end of loop over operands
	    	bytecodeWriteByte( optypeValue, optypePosition );
    	}
    } //end of gen(...)

    /* formulas */
    public void defineFormula(Token tokenFormulaid, Token tokenSimple) {
    	resetLabels();
    	int formulaid = intValue(tokenFormulaid);
    	boolean simple = booleanValue(tokenSimple);
    	int offset = bytecodeOffset;
    	if(formulaarr==null || formulaid>=formulaarr.length) {
    		throw new RuntimeException("invalid formulaid " + formulaid + ", line " + tokenFormulaid.getLine());
    	}
    	Formula formula = new Formula();
    	formula.formulaid = formulaid;
    	formula.simple = simple;
    	formula.offset = offset;
    	formulaarr[formulaid] = formula;
    	currentformula = formulaarr[formulaid];
    }
    public void finishFormula(Token tokenFormulaid) {
    	int formulaid = intValue(tokenFormulaid);
    	backpatchLabels();
    	resetLabels();
    	if(formulaarr==null || formulaid>=formulaarr.length) {
    		throw new RuntimeException("invalid formulaid " + formulaid + ", line " + tokenFormulaid.getLine());
    	}
    	Formula formula = formulaarr[formulaid];
    	formula.size = bytecodeOffset - formula.offset;
    }
    
    /* constants */
    private HashMap<String, Integer> constantsString = new HashMap<String, Integer>();
    private HashMap<Integer, Integer> constantsInteger = new HashMap<Integer, Integer>();
    private HashMap<Double, Integer> constantsDouble = new HashMap<Double, Integer>();
    /**
     * value: String / Integer / Double
     */
    private ArrayList<Object> constants = new ArrayList<Object>();
    private int defineConstantId(Token constant) {
    	String valuestr = constant.getText();
    	Integer id = null;
    	switch(constant.getType()) {
    	case TciParser.NUMBER_INT:
    		Integer valueint = Integer.parseInt(valuestr);
    		id = constantsInteger.get(valueint);
    		if (id==null) {
    			id = getConstantsSize();
    			constantsInteger.put(valueint, id);
    			constants.add(valueint);
    		}
    		break;
    	case TciParser. NUMBER_DEC:
    		Double valuedec = Double.parseDouble(valuestr);
    		id = constantsDouble.get(valuedec);
    		if (id==null) {
    			id = getConstantsSize();
    			constantsDouble.put(valuedec, id);
    			constants.add(id, valuedec);
    		}
    		break;
    	case TciParser.STRING:
    		id = constantsString.get(valuestr);
    		if (id==null) {
    			id = getConstantsSize();
    			constantsString.put(valuestr, id);
    			constants.add(valuestr);
    		}
    		break;
    	default: 
    		throw new RuntimeException("line " + constant.getLine() + " invalid tokentype for constant: " + constant.getType());
    	}
    	return id;
    }
    private int getConstantsSize() {
    	return constants.size();
    }

    /* labels */
    /**
     * remember labels with bytecode-offsets for a formula.
     * Bytecode-offsets are absolute
     */
    private HashMap<String, Integer> labels;
    /**
     * Holds the labels for a formula that could not be resolved.
     * Key: label name (unique within a formula)
     * Value: list of absolute bytecode-offsets where the address of the label is needed
     */
    private HashMap<String, ArrayList<Integer>> labelsUnresolved;

    /**
     * Define a unique label within a formula.
     * The absolute bytecode offset is put into Map labels for later usage.
     * @param tokenLabel Label name (unique in formula)
     */
    public void defineLabel(Token tokenLabel) {
    	/* remember token and position in bytecode */
    	int offset = bytecodeOffset;
    	labels.put(tokenLabel.getText(), offset);
    }
    /**
     * Resolve reference to label or register for backpatching
     * @param label
     * @return offset if label was defined already, 0 if need to be backpatches -> use backpatchLabels() for that
     */
    public int getLabel(String label) {
    	Integer offset = labels.get(label);
    	if (offset!=null) {
    		return offset;
    	}
    	/* remember for backpatching */
    	ArrayList<Integer> listUnresolved = labelsUnresolved.get(label);
    	if (listUnresolved==null) {
    		listUnresolved = new ArrayList<Integer>();
    		labelsUnresolved.put(label, listUnresolved);
    	}
    	listUnresolved.add(bytecodeOffset);
    	return 0;
    }
    
    /**
     * Backpatch labels for a formula ... lives by calls to previous getLabel(..) throughout the parsing.
     * Make sure to call resetLabels at the start/end of a formula
     */
    public void backpatchLabels() {
    	for (Entry<String, ArrayList<Integer>> list : labelsUnresolved.entrySet()) {
    		String label = list.getKey();
    		Integer offsetLabel = labels.get(label);
    		if (offsetLabel==null) {
    			throw new RuntimeException("formula " + currentformula.formulaid + ": label " + label + " not defined!");
    		}
    		int bytevalue = offsetLabel;
    		ArrayList<Integer> listOffset = list.getValue();
    		for (Integer offset : listOffset) {
    	        bytecode[offset+0] = (byte)((bytevalue>>24) & 0xFF);
    	        bytecode[offset+1] = (byte)((bytevalue>>16) & 0xFF);
    	        bytecode[offset+2] = (byte)((bytevalue>> 8) & 0xFF);
    	        bytecode[offset+3] = (byte)( bytevalue      & 0xFF);
    		}
    	}
    }
    private void resetLabels() {
    	labels = new HashMap<String, Integer>();
        labelsUnresolved = new HashMap<String, ArrayList<Integer>>();
    }

    private Asm asm;
    /**
     * parsing of all formulas has finished
     */
    public void done() {
    	/* strip down bytecode */
    	bytecode = Arrays.copyOf(bytecode, bytecodeOffset);
    	asm = new Asm();
    	asm.bytecode = bytecode;
        int[] formulaOffset = new int[formulaarr.length]; //dropped: formulaSize
        int[] formulaMaxvar = new int[formulaarr.length];
        boolean[] formulaSimple = new boolean[formulaarr.length];
        for (int i=0; i<formulaarr.length; i++) {
        	formulaOffset[i] = formulaarr[i].offset;  
        	formulaSimple[i] = formulaarr[i].simple;
        	formulaMaxvar[i]  = formulaarr[i].maxvar;
        }
        asm.formulaOffset = formulaOffset;
        asm.formulaSimple = formulaSimple;
        asm.formulaMaxvar = formulaMaxvar;
        asm.constants = constants.toArray();
        asm.calcs = calcarr;
        asm.nodes = nodearr;
        asm.edges = edges; //dropped: child/link
        asm.tables = tablearr;
        asm.funcs = funcarr;
        asm.inputcalcnames = inputcalcnamearr;
        asm.inputs = inputarr;
    }

    public static class Calc implements Serializable {
		private static final long serialVersionUID = -3100160306655740117L;
		public int id;
    	public String name;
    	public int nargs;
    	public int rootaccessNode;
    	/**
    	 * true if sum of calc starting at rootaccessNode has to be computed.
    	 * false if it's enough to just compute the one and only calc from rootaccessNode
    	 */
    	public boolean rootaccessSum;
    }
    private int intValue(Token token) {
    	try {
    		return Integer.parseInt(token.getText());
    	} catch (NumberFormatException e) {
    		throw new RuntimeException("expected integer, but got " + token.getText() + ", line " + token.getLine());
    	}
    }
//    /**
//     * @param token
//     * @return -1 if false, number otherwise
//     */
//    private int booleanIntValue(Token token) {
//    	if (token==null) {
//    		return -1;
//    	}
//    	String tokenStr = token.getText();
//    	if ("false".equals(tokenStr)) {
//    		return -1;
//    	} else {
//    		try {
//    			int i=Integer.parseInt(tokenStr);
//    			return i;
//    		} catch (NumberFormatException e) {
//    			throw new RuntimeException("false or number expected, but got " + token.getText() + ", line " + token.getLine());
//    		}
//    	} 
//    }
    private boolean booleanValue(Token token) {
    	if (token==null) {
    		return false;
    	}
    	String tokenStr = token.getText();
    	if ("true".equals(tokenStr)) {
    		return true;
    	} else if ("false".equals(tokenStr)) {
    		return false;
    	} else {
    		throw new RuntimeException("boolean ('false' or 'true') expected, but got " + token.getText() + ", line " + token.getLine());
    	}
    }
    private String stringValue(Token token) {
    	if (token==null) {
    		return null;
    	}
    	return token.getText();
    }
    private Calc[] calcarr;
    public void setCalcsize(Token tokenSize) {
    	int calcsize = intValue(tokenSize);
    	calcarr = new Calc[calcsize];
    }
    public void addCalc(Token tokenCalc, Token tokenName, Token tokenNargs) {
    	Calc calc = new Calc();
    	calc.name = stringValue(tokenName);
    	calc.id = intValue(tokenCalc);
    	calc.nargs = intValue(tokenNargs);
   		calcarr[calc.id] = calc;
    }
    public void setCalcMainAccess(Token tokenCalc, Token tokenNode, boolean sum) {
    	int calcid = intValue(tokenCalc);
    	Calc c = calcarr[calcid];
    	if (c==null) {
    		throw new RuntimeException("invalid calcid " + calcid + ", line " + tokenCalc.getLine());
    	}
    	c.rootaccessSum = sum;
    	c.rootaccessNode = intValue(tokenNode);
    }
    
    public void setCalcMainSingle(Token tokenCalc, Token tokenNode) {
    	setCalcMainAccess(tokenCalc, tokenNode, false);
    }
    public void setCalcMainSum(Token tokenCalc, Token tokenNode) {
    	setCalcMainAccess(tokenCalc, tokenNode, true);
    }

    public static class Node implements Serializable {
		private static final long serialVersionUID = 5395587957619215525L;
		public int id;
    	public String nameid;
    	public String name;
    	public Integer formulaInclusion;
    	public Integer formulaTimes;
    	public Integer counterId;
    	public NodeCalc[] nodecalcList;
    	public BitSet nco;
    	public BitSet nct;
    }
    public static class NodeCalc implements Serializable {
		private static final long serialVersionUID = 1L;
		public int calcid;
    	public int formula;
    }
    private Node[] nodearr;
    private int[][] edges;
    public void setNodesize(Token tokenSize) {
    	int nodes = intValue(tokenSize);
    	nodearr = new Node[nodes];
    	edges = new int[nodes][];
    }
    
    public void setEdgesize(Token tokenEdge, Token tokenSize) {
    	edges[intValue(tokenEdge)] = new int[intValue(tokenSize)];
    }
    public void addEdge(Token tokenInd, Token tokenFrom, Token tokenTo, Token tokenWhat) {
    	int nodefrom = intValue(tokenFrom);
    	int nodeto   = intValue(tokenTo);
    	int[] edgesNodeFrom = edges[nodefrom];
    	int ind = intValue(tokenInd);
    	edgesNodeFrom[ind] = nodeto;
    	String nodeorlink = tokenWhat.getText();
    	if (".edge".equals(nodeorlink)) {
    	} else if (".link".equals(nodeorlink)) {
    	} else {
    		throw new RuntimeException("invalid edge definition with " + tokenWhat.getText() + ", line " + tokenWhat.getLine());
    	}
    }
    public void addNode(Token tokenNode, Token tokenId, Token tokenName) {
    	int nodeid = intValue(tokenNode);
    	Node node = new Node();
    	node.nco = new BitSet(calcarr.length);
    	node.nct = new BitSet(calcarr.length);
    	node.id = intValue(tokenNode);
    	node.nameid = stringValue(tokenId);
    	node.name = stringValue(tokenName);
    	node.nodecalcList = new NodeCalc[calcarr.length];
   		nodearr[nodeid] = node;
    }
    public void addNodeFormula(Token tokenNode, Token tokenInclusion, Token tokenTimes, Token tokenTimesid) {
    	int nodeid = intValue(tokenNode);
    	Node node = nodearr[nodeid];
    	node.formulaInclusion = tokenInclusion!=null ? intValue(tokenInclusion) : null;
    	node.formulaTimes = tokenTimes!=null ? intValue(tokenTimes) : null;
    	node.counterId = tokenTimesid!=null ? intValue(tokenTimesid) : null;
    }
    public void addNodeCalc(Token tokenNode, Token tokenCalc, Token tokenFormula) {
    	int nodeid = intValue(tokenNode);
    	int calcid = intValue(tokenCalc);
    	int formula = intValue(tokenFormula);
    	if (nodearr==null || nodeid>=nodearr.length) {
    		throw new RuntimeException("invalid nodeid " + nodeid + ", line " + tokenNode.getLine());
    	}
    	Node node = nodearr[nodeid];
    	if (node==null) {
    		throw new RuntimeException("Node not found for nodeid " + nodeid + ", line " + tokenNode.getLine());
    	}
    	NodeCalc nodecalc = new NodeCalc();
    	
    	nodecalc.calcid = calcid;
    	nodecalc.formula = formula;
    	node.nodecalcList[calcid] = nodecalc;
    }
    public void addNodeCalcdef(Token tokenNode, Token tokenCalc) {
    	int nodeid = intValue(tokenNode);
    	int calcid = intValue(tokenCalc);
    	if (nodearr==null || nodeid>=nodearr.length) {
    		throw new RuntimeException("invalid nodeid " + nodeid + ", line " + tokenNode.getLine());
    	}
    	Node node = nodearr[nodeid];
    	if (node==null) {
    		throw new RuntimeException("Node not found for nodeid " + nodeid + ", line " + tokenNode.getLine());
    	}
    	node.nco.set(calcid);
    }
    public void addNodeCalcdef(Token tokenNode, Token tokenCalcfrom, Token tokenCalcto) {
    	int nodeid = intValue(tokenNode);
    	int calcidFrom = intValue(tokenCalcfrom);
    	int calcidTo   = intValue(tokenCalcto);
    	if (nodearr==null || nodeid>=nodearr.length) {
    		throw new RuntimeException("invalid nodeid " + nodeid + ", line " + tokenNode.getLine());
    	}
    	Node node = nodearr[nodeid];
    	if (node==null) {
    		throw new RuntimeException("Node not found for nodeid " + nodeid + ", line " + tokenNode.getLine());
    	}
    	node.nco.set(calcidFrom, calcidTo+1);
    }
    public void addNodeCalctotal(Token tokenNode, Token tokenCalc) {
    	int nodeid = intValue(tokenNode);
    	int calcid = intValue(tokenCalc);
    	if (nodearr==null || nodeid>=nodearr.length) {
    		throw new RuntimeException("invalid nodeid " + nodeid + ", line " + tokenNode.getLine());
    	}
    	Node node = nodearr[nodeid];
    	if (node==null) {
    		throw new RuntimeException("Node not found for nodeid " + nodeid + ", line " + tokenNode.getLine());
    	}
    	node.nct.set(calcid);
    }
    public void addNodeCalctotal(Token tokenNode, Token tokenCalcfrom, Token tokenCalcto) {
    	int nodeid = intValue(tokenNode);
    	int calcidFrom = intValue(tokenCalcfrom);
    	int calcidTo   = intValue(tokenCalcto);
    	if (nodearr==null || nodeid>=nodearr.length) {
    		throw new RuntimeException("invalid nodeid " + nodeid + ", line " + tokenNode.getLine());
    	}
    	Node node = nodearr[nodeid];
    	if (node==null) {
    		throw new RuntimeException("Node not found for nodeid " + nodeid + ", line " + tokenNode.getLine());
    	}
    	node.nct.set(calcidFrom, calcidTo+1);
    }
    
    public static class Table implements Serializable {
		private static final long serialVersionUID = -4726640028381920222L;
		public int id;
    	public String name;
    	public int rows;
    	public int cols;
    	public boolean shuffled;
    	public boolean directaccess;
    	public int directaccessoffset;
    	public TableColumn[] tablecolumnarr;
    	public String[] data;
    	public int[] oo;
    }
    public static class TableColumn implements Serializable {
		private static final long serialVersionUID = -3606362678946774044L;
		public int colind;
    	public String name;
    	public boolean numeric;
    	public boolean numericsuper;
    	public boolean numericunique;
    }
    private Table[] tablearr;
    
    public void setTablesize(Token tokenSize) {
    	tablearr = new Table[intValue(tokenSize)];
    }
    public void addTable(Token tokenTable, Token tokenName, Token tokenRows, Token tokenCols, 
    		Token tokenShuffled, Token tokenDirectaccess, Token tokenDirectaccessoffset) {
    	Table table = new Table();
    	table.id = intValue(tokenTable);
    	table.name = stringValue(tokenName);
    	table.rows = intValue(tokenRows);
    	table.cols = intValue(tokenCols);
    	table.shuffled = booleanValue(tokenShuffled);
    	table.directaccess = booleanValue(tokenDirectaccess);
    	if (table.directaccess) {
    		table.directaccessoffset = intValue(tokenDirectaccessoffset);
    	} 
    	table.tablecolumnarr = new TableColumn[table.cols];
    	table.data = new String[table.rows * table.cols];
    	if (table.shuffled) {
    		table.oo = new int[table.rows];
    	}
    	tablearr[table.id]= table; 
    }
    public void addTableColumn(Token tokenTable, Token tokenColind, Token tokenName, 
    		Token tokenNumeric, Token tokenNumericsuper, Token tokenNumericunique) {
    	int tableid = intValue(tokenTable);
    	int colind = intValue(tokenColind);
    	String colname = stringValue(tokenName);
    	boolean numeric = booleanValue(tokenNumeric);
    	boolean numericsuper = booleanValue(tokenNumericsuper);
    	boolean numericunique = booleanValue(tokenNumericunique);
    	if (tablearr==null || tableid>=tablearr.length) {
    		throw new RuntimeException("invalid tableid " + tableid + ", line " + tokenTable.getLine());
    	}
    	Table table = tablearr[tableid];
    	if (table==null) {
    		throw new RuntimeException("table with table " + tableid + " not defined, but table column definition encountered at line " + tokenColind.getLine());
    	}
    	TableColumn[] tablecolumnarr = table.tablecolumnarr;
    	if (tablecolumnarr==null || colind>=tablecolumnarr.length) {
    		throw new RuntimeException("table " + tableid + ": column definition for colind=" + colind + " invalid, line " + tokenColind.getLine());
    	}
    	TableColumn tabcol = new TableColumn();
    	tabcol.colind = colind;
    	tabcol.name = colname;
    	tabcol.numeric = numeric;
    	tabcol.numericsuper = numericsuper;
    	tabcol.numericunique = numericunique;
    	tablecolumnarr[colind] = tabcol;
    }
    public void addTableValue(Token tokenTable, Token tokenInd, Token tokenRow, Token tokenCol, Token tokenValue) {
    	int tableid = intValue(tokenTable);
    	if (tablearr==null || tableid>=tablearr.length) {
    		throw new RuntimeException("invalid tableid " + tableid + ", line " + tokenTable.getLine());
    	}
    	Table table = tablearr[tableid];
    	if (table==null) {
    		throw new RuntimeException("table with table " + tableid + " not defined, but table data definition encountered at line " + tokenTable.getLine());
    	}
    	table.data[intValue(tokenInd)] = stringValue(tokenValue);
    }
    public void addTableRowInfo(Token tokenTable, Token tokenRowind, Token tokenOo) {
    	int tableid = intValue(tokenTable);
    	if (tablearr==null || tableid>=tablearr.length) {
    		throw new RuntimeException("invalid tableid " + tableid + ", line " + tokenTable.getLine());
    	}
    	Table table = tablearr[tableid];
    	if (table==null) {
    		throw new RuntimeException("table with table " + tableid + " not defined, but table data definition encountered at line " + tokenTable.getLine());
    	}
    	if (!table.shuffled) {
    		return;
    	}
    	table.oo[intValue(tokenRowind)] = intValue(tokenOo);
    }
    
    public static class Func implements Serializable {
		private static final long serialVersionUID = -4291712262982571880L;
		public int funcid;
    	public String name;
    	public int nargs;
    	public int formula;
    }
    private Func[] funcarr;
    public void setFuncsize(Token tokenSize) {
    	funcarr = new Func[intValue(tokenSize)];
    }
    public void addFunc(Token tokenFunc, Token tokenName, Token tokenNargs, Token tokenFormula) {
    	int funcid = intValue(tokenFunc);
    	if (funcarr==null || funcid>=funcarr.length) {
    		throw new RuntimeException("function-arr not yet defined but tried to define function " + funcid + ", line " + tokenFunc.getLine());
    	}
    	Func func = new Func();
    	func.funcid = funcid;
    	func.name = stringValue(tokenName);
    	func.nargs = intValue(tokenNargs);
    	func.formula = intValue(tokenFormula);
    	funcarr[funcid] = func;
    }
    private String[] inputcalcnamearr;
    public void setInputcalcidSize(Token tokenSize) {
    	inputcalcnamearr = new String[intValue(tokenSize)];
    }
    public void addInputcalcid(Token tokenInputcalc, Token tokenName) {
    	int id = intValue(tokenInputcalc);
    	if (inputcalcnamearr==null || id>=inputcalcnamearr.length) {
    		throw new RuntimeException("inputcalcid size not yet defined, but tried to define inputcalcid " + id + ", line " + tokenInputcalc.getLine());
    	}
    	String name = stringValue(tokenName).toUpperCase();
    	inputcalcnamearr[id] = name; 
    }
    
    public static class Input implements Serializable {
		private static final long serialVersionUID = -9201379125395392285L;
		public int inputid;
    	public String name;
    	public int formulaCheck = -1;
    	public int numautocounters = -1;
    	public int[] autocounters;
    	public boolean isChoiceable = false;
    	public int formulaDefault = -1;
    	public int formulaVector = -1;
    	public int formulaReference = -1;
    	public int formulaTable = -1;
    	public int formulaFilter = -1;
    	public int formulaDisplay = -1;
    	public int formulaDisplaytext = -1;
    	public int[]   inputcalcFormulas;
    }
    private Input[] inputarr;
    public void setInputsize(Token tokenSize) {
    	inputarr = new Input[intValue(tokenSize)];
    }
    public void addInput(Token tokenInput, Token tokenName, Token tokenAutocounters, Token tokenChoiceable) {
    	int inputid = intValue(tokenInput);
    	if (inputarr==null || inputid>=inputarr.length) {
    		throw new RuntimeException("invalid input " + inputid + ", line " + tokenInput.getLine());
    	}
    	Input input = new Input();
    	input.inputid = inputid;
    	input.name = stringValue(tokenName);
    	input.numautocounters = intValue(tokenAutocounters);
    	input.autocounters = new int[input.numautocounters];
    	input.isChoiceable = booleanValue(tokenChoiceable);
    	input.inputcalcFormulas = new int[inputcalcnamearr.length];
    	inputarr[inputid] = input;
    }
    public void addInputAutocounter(Token tokenInput, Token tokenInd, Token tokenCounterid) {
    	int inputid = intValue(tokenInput);
    	if (inputarr==null || inputid>=inputarr.length) {
    		throw new RuntimeException("invalid input " + inputid + ", line " + tokenInput.getLine());
    	}
    	Input input = inputarr[inputid];
    	if (input==null) {
    		throw new RuntimeException("input " + inputid + " not yet defined, but used for autocounter definition, line " + tokenInput.getLine());
    	}
    	int ind = intValue(tokenInd);
    	int[] ac = input.autocounters;
    	if (ac==null || ind>=ac.length) {
    		throw new RuntimeException("autocounters null/too short for input " + inputid + ", line " + tokenInput.getLine());
    	}
    	ac[ind] = intValue(tokenCounterid);
    }
    public void addInputcalc(Token tokenInput, Token tokenInputcalc, Token tokenFormula) {
    	int inputid = intValue(tokenInput);
    	if (inputarr==null || inputid>=inputarr.length) {
    		throw new RuntimeException("invalid input " + inputid + ", line " + tokenInput.getLine());
    	}
    	Input input = inputarr[inputid];
    	if (input==null) {
    		throw new RuntimeException("input " + inputid + " not yet defined, but used for autocounter definition, line " + tokenInput.getLine());
    	}
    	int icalcid = intValue(tokenInputcalc);
    	int[] icarr = input.inputcalcFormulas;
    	if (icarr==null || icalcid>=icarr.length) {
    		throw new RuntimeException("inputcalc " + icalcid + " for input " + inputid + " not valid, line " + tokenInput.getLine());
    	}
    	int formula = intValue(tokenFormula);
    	icarr[icalcid] = formula;
    	if (inputcalcnamearr==null || icalcid>=inputcalcnamearr.length) {
    		throw new RuntimeException("inputcalc with id " + icalcid + " not yet defined, line " + tokenInputcalc.getLine());
    	}
    	String inputcalcname = inputcalcnamearr[icalcid];
    	if ("check".equalsIgnoreCase(inputcalcname)) {
    		input.formulaCheck = formula; 
    	} else if ("default".equalsIgnoreCase(inputcalcname)) {
    		input.formulaDefault = formula; 
    	} else if ("display".equalsIgnoreCase(inputcalcname)) {
    		input.formulaDisplay = formula; 
    	} else if ("displaytext".equalsIgnoreCase(inputcalcname)) {
    		input.formulaDisplaytext = formula; 
    	} else if ("filter".equalsIgnoreCase(inputcalcname)) {
    		input.formulaFilter = formula; 
    	} else if ("reference".equalsIgnoreCase(inputcalcname)) {
    		input.formulaReference = formula; 
    	} else if ("table".equalsIgnoreCase(inputcalcname)) {
    		input.formulaTable = formula; 
    	} else if ("vector".equalsIgnoreCase(inputcalcname)) {
    		input.formulaVector = formula; 
    	} 
    }
    
    static class Formula {
    	int formulaid;
    	int nargs; /* not used yet */
    	boolean simple;
    	/* filled from assembler */
    	int maxvar; //maximum of used local var / argument (e.g. ind 0 -> maxvar=1)
    	int offset; //start of bytecode
    	int size; //bytecode size
    }
    private Formula[] formulaarr;
    public void setFormulasize(Token tokenSize) {
    	formulaarr = new Formula[intValue(tokenSize)];
    }
    public static class Asm implements Serializable {
		private static final long serialVersionUID = -638888750504643763L;
		public byte[] bytecode;
        public int[] formulaOffset; //dropped: formulaSize
        public boolean[] formulaSimple;
        public int[] formulaMaxvar;
        public Object[] constants; //String, Integer, Double
        public Calc[] calcs;
        public Node[] nodes;
        public int[][] edges; //dropped: child/link
        public Table[] tables;
        public Func[] funcs;
        public String[] inputcalcnames;
        public Input[] inputs;
    }
    public Asm getAsm() {
    	return this.asm;
    }
}
