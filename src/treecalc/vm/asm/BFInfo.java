package treecalc.vm.asm;

import java.util.Collection;
import java.util.LinkedHashMap;

/* TODO: split into source/execution-part */

public class BFInfo {
	private int id;
	private final String javaname;
	/**
	 * minimum number of arguments
	 */
	final int minargs;
	/**
	 * maximum number of arguments or -1 if variable number of arguments without limit
	 */
	final int maxargs;
	final boolean instancemethod;
	BFInfo(int id, String javaname, int minargs, int maxargs, boolean instancemethod) {
		this.id = id;
		this.javaname = javaname;
		this.minargs = minargs;
		this.maxargs = maxargs;
		this.instancemethod = instancemethod;
	}
	public int getId() {return id; }
	public String getJavaname() {return javaname;}
	public int getMinargs() {return minargs;}
	public int getMaxargs() {return maxargs;}
	public boolean isInstancemethod() {	return instancemethod;}
	
	public static BFInfo getBySourceName(String name) {
		return bf.get(name.toUpperCase());
	}
	public static Collection<BFInfo> getBasisfunctions() {
		return bf.values();
	}
	private static LinkedHashMap<String, BFInfo> bf = new LinkedHashMap<String, BFInfo>();
	static {
		// special void
		bf.put("FALSE"                         ,new BFInfo(0, "bf_false", 0, 0, false));
		bf.put("NOT"                           ,new BFInfo(1, "bf_not", 1, 1, true));
		bf.put("TRUE"                          ,new BFInfo(2, "bf_true", 0, 0, false));
		/* table functions */
		// special bf.put("cell"                          ,"cell"                            );
		// special bf.put("cellx"                         ,"cellx"                           );
		// special bf.put("exists"                        ,"exists"                          );
		// special bf.put("interpol"                      ,"interpol"                        );
		// special bf.put("lookup"                        ,"lookup"                          );
		// special bf.put("lookupx"                       ,"lookupx"                         );
		// special bf.put("lookdownx"                     ,"lookdownx"                       );
		// special bf.put("search"                        ,"search"                          );
		// special bf.put("tabcols"                       ,"tabcols"                         );
		// special bf.put("tabrows"                       ,"tabrows"                         );
		/* odbc access */
		bf.put("SELECT"                        ,new BFInfo(3, "bf_select", 3, -1, false));
		bf.put("SELECTX"                       ,new BFInfo(4, "bf_selectx", 4, -1, false));
		bf.put("V_SELECT"                      ,new BFInfo(5, "bf_v_select", 3, -1, false));
		bf.put("V_SELECTX"                     ,new BFInfo(6, "bf_v_selectx", 4, -1, false));
		/* string functions */
		bf.put("FORMAT"                        ,new BFInfo(7, "bf_format", 2, 2, true));
		bf.put("INSTR"                         ,new BFInfo(8, "bf_instr", 2, 2, true));
		bf.put("LEFT"                          ,new BFInfo(9, "bf_left", 2, 2, true));
		bf.put("LENGTH"                        ,new BFInfo(10, "bf_length", 1, 1, true));
		bf.put("MID"                           ,new BFInfo(11, "bf_mid", 2, 3, true));
		bf.put("RIGHT"                         ,new BFInfo(12, "bf_right", 2, 2, true));
		bf.put("STRCMP"                        ,new BFInfo(13, "bf_strcmp", 2, 2, true));
		bf.put("STRICMP"                       ,new BFInfo(14, "bf_stricmp", 2, 2, true));
		bf.put("SUBST"                         ,new BFInfo(15, "bf_subst", 3, 3, true));
		bf.put("TOLOWER"                       ,new BFInfo(16, "bf_tolower", 1, 1, true));
		bf.put("TOUPPER"                       ,new BFInfo(17, "bf_toupper", 1, 1, true));
		bf.put("TRIM"                          ,new BFInfo(18, "bf_trim", 1, 1, true));
		bf.put("CHR"                           ,new BFInfo(19, "bf_chr", 1, 1, true));
		bf.put("ANSI"                          ,new BFInfo(20, "bf_ansi", 1, 1, true));
		bf.put("OEM"                           ,new BFInfo(21, "bf_oem", 1, 1, true));
		/* math functions */
		bf.put("ROUND"                         ,new BFInfo(22, "bf_round", 1, 2, true));
		bf.put("CEIL"                          ,new BFInfo(23, "bf_ceil", 1, 1, true));
		bf.put("FLOOR"                         ,new BFInfo(24, "bf_floor", 1, 1, true));
		bf.put("MIN"                           ,new BFInfo(25, "bf_min", 2, -1, false));
		bf.put("MAX"                           ,new BFInfo(26, "bf_max", 2, -1, false));
		bf.put("SQRT"                          ,new BFInfo(27, "bf_sqrt", 1, 1, true));
		bf.put("EXP"                           ,new BFInfo(28, "bf_exp", 1, 1, true));
		bf.put("FMOD"                          ,new BFInfo(29, "bf_fmod", 2, 2, true));
		bf.put("ABS"                           ,new BFInfo(30, "bf_abs", 1, 1, true));
		/* unimportant math functions */
		bf.put("ACOS"                          ,new BFInfo(31, "bf_acos", 1, 1, false));
		bf.put("ASIN"                          ,new BFInfo(32, "bf_asin", 1, 1, false));
		bf.put("ATAN"                          ,new BFInfo(33, "bf_atan", 1, 1, false));
		bf.put("ATAN2"                         ,new BFInfo(34, "bf_atan2", 2, 2, false));
		bf.put("COS"                           ,new BFInfo(35, "bf_cos", 1, 1, false));
		bf.put("COSH"                          ,new BFInfo(36, "bf_cosh", 1, 1, false));
		bf.put("SIN"                           ,new BFInfo(37, "bf_sin", 1, 1, false));
		bf.put("SINH"                          ,new BFInfo(38, "bf_sinh", 1, 1, false));
		bf.put("TAN"                           ,new BFInfo(39, "bf_tan", 1, 1, false));
		bf.put("TANH"                          ,new BFInfo(40, "bf_tanh", 1, 1, false));
		bf.put("LOG"                           ,new BFInfo(41, "bf_log", 1, 1, false));
		bf.put("LOG10"                         ,new BFInfo(42, "bf_log10", 1, 1, false));
		/* date functions */
		bf.put("DATE"                          ,new BFInfo(43, "bf_date", 4, 5, false));
		bf.put("DATEDAY"                       ,new BFInfo(44, "bf_dateday", 1, 1, true));
		bf.put("DAY"                           ,new BFInfo(45, "bf_day", 1, 1, true));
		bf.put("DAYDATE"                       ,new BFInfo(46, "bf_daydate", 2, 2, true));
		bf.put("DAYS"                          ,new BFInfo(47, "bf_days", 1, 1, true));
		bf.put("MONTH"                         ,new BFInfo(48, "bf_month", 1, 1, true));
		bf.put("MONTHS"                        ,new BFInfo(49, "bf_months", 1, 1, true));
		bf.put("NOW"                           ,new BFInfo(50, "bf_now", 1, 1, false));
		bf.put("TODAY"                         ,bf.get("NOW"));
		bf.put("YEAR"                          ,new BFInfo(51, "bf_year", 1, 1, true));
		bf.put("YEARS"                         ,new BFInfo(52, "bf_years", 1, 1, true));
		/* list */
		bf.put("V_"                            ,new BFInfo(53, "bf_list", 0, -1, false));
		bf.put("LIST"                          ,bf.get("V_"));
		bf.put("V_CONCAT"                      ,new BFInfo(54, "bf_v_concat", 2, 2, true));                        
		bf.put("V_CONSTRUCT"                   ,new BFInfo(55, "bf_v_construct", 1, 1, true));
		bf.put("V_DELETE"                      ,new BFInfo(56, "bf_v_delete", 2, 2, true));
		bf.put("V_ELEMENT"                     ,new BFInfo(57, "bf_v_element", 2, -1, true));
		bf.put("E_"                            ,bf.get("V_ELEMENT"));
		bf.put("V_ELEMENTS"                    ,new BFInfo(58, "bf_v_elements", 3, 3, true));
		bf.put("V_FIRST"                       ,new BFInfo(59, "bf_v_first", 1, 1, true));
		bf.put("V_FRONT"                       ,new BFInfo(60, "bf_v_front", 1, 1, true));
		bf.put("V_INSERT"                      ,new BFInfo(61, "bf_v_insert", 3, 3, true));
		bf.put("V_LAST"                        ,new BFInfo(62, "bf_v_last", 1, 1, true));
		bf.put("V_LENGTH"                      ,new BFInfo(63, "bf_v_length", 1, 1, true));
		bf.put("V_MAX"                         ,new BFInfo(64, "bf_v_max", 1, 1, true));
		bf.put("V_MIN"                         ,new BFInfo(65, "bf_v_min", 1, 1, true));
		bf.put("V_NUMSORT"                     ,new BFInfo(66, "bf_v_numsort", 1, 1, true));
		bf.put("V_REPLACE"                     ,new BFInfo(67, "bf_v_replace", 3, 3, true));
		bf.put("V_REST"                        ,new BFInfo(68, "bf_v_rest", 1, 1, true));
		bf.put("V_SORT"                        ,new BFInfo(69, "bf_v_sort", 1, 1, true));
		bf.put("V_STRING"                      ,new BFInfo(70, "bf_v_string", 2, 2, true));
		bf.put("V_STRINGX"                     ,new BFInfo(71, "bf_v_stringx", 1, 1, true));
		bf.put("v_trans"                       ,new BFInfo(72, "bf_v_trans", 1, 1, true));
		/* information */
		bf.put("ISBOOL"                        ,new BFInfo(73, "bf_isbool", 1, 1, true));
		bf.put("ISDATE"                        ,new BFInfo(74, "bf_isdate", 1, 1, true));
		bf.put("ISINTEGER"                     ,new BFInfo(75, "bf_isinteger", 1, 1, true));
		bf.put("ISNUMBER"                      ,new BFInfo(76, "bf_isnumber", 1, 1, true));
		bf.put("ISTIME"                        ,new BFInfo(77, "bf_istime", 1, 1, true));
		//bf.put("UNDEFINED"                     ,new BFInfo("bf_undefined", 1, 1, false));
		/* loops */
		//special bf.put("sumx"                          ,"sumx"                            );
		//special bf.put("prodx"                          ,"prodx"                            );
		//special bf.put("vectorx"                       ,"vectorx"                         );
		/* function reference */
		//special bf.put("funcref"                       ,"funcref"                         );
		//special bf.put("docall"                        ,"docall"                          );
		/* dynamic call */
//		bf.put("VPMCOMPUTE"                    ,new BFInfo(  , "bf_vpmcompute", 2, -1, false));
		bf.put("VPMTRY"                        ,new BFInfo(78, "bf_vpmtry", 2, -1, false));
		bf.put("VPMEXIST"                      ,new BFInfo(79, "bf_vpmexist", 1, 3, false));
		/* error handling */
		bf.put("ERROR"                         ,new BFInfo(80, "bf_error", 1, 2, false));
//special		"message"
		/* get something from config file */
		bf.put("CONST"                         ,new BFInfo(81, "bf_const", 1, 1, false));
		bf.put("GETPRIVATEPROFILESTRING"       ,new BFInfo(82, "bf_getprivateprofilestring", 4, 4, false));
	}
	
}
