// $ANTLR 3.4 Tci.g 2012-05-02 17:46:58
package treecalc.vm.asm; 

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class TciParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "COMMENTLINE", "COMMENTML", "EscapeSequence", "ID", "LABEL", "NUMBER_DEC", "NUMBER_INT", "STRING", "WHITESPACE", "'.calc'", "'.calcdef'", "'.calcs'", "'.calctotal'", "'.edge'", "'.edges'", "'.formula'", "'.formuladone'", "'.formulas'", "'.func'", "'.funcs'", "'.input'", "'.inputautocounter'", "'.inputcalc'", "'.inputcalcid'", "'.inputcalcids'", "'.inputs'", "'.link'", "'.node'", "'.nodecalc'", "'.nodeformulas'", "'.nodes'", "'.table'", "'.tablecol'", "'.tablerow'", "'.tables'", "'.tablevalue'", "':'", "'='", "'args'", "'autocounters'", "'calc'", "'calc_rangeend'", "'calc_rangestart'", "'choiceable'", "'col'", "'cols'", "'computenode'", "'computestartnode'", "'counter'", "'directaccess'", "'directaccessoffset'", "'false'", "'formula'", "'from'", "'func'", "'icalc'", "'id'", "'inclusion'", "'ind'", "'input'", "'name'", "'nargs'", "'node'", "'numeric'", "'numericsuper'", "'numericunique'", "'oo'", "'row'", "'rows'", "'shuffled'", "'simple'", "'size'", "'table'", "'timesformula'", "'timesid'", "'to'", "'true'", "'value'"
    };

    public static final int EOF=-1;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__50=50;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__59=59;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__73=73;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int COMMENT=4;
    public static final int COMMENTLINE=5;
    public static final int COMMENTML=6;
    public static final int EscapeSequence=7;
    public static final int ID=8;
    public static final int LABEL=9;
    public static final int NUMBER_DEC=10;
    public static final int NUMBER_INT=11;
    public static final int STRING=12;
    public static final int WHITESPACE=13;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public TciParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public TciParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return TciParser.tokenNames; }
    public String getGrammarFileName() { return "Tci.g"; }


        private TciAssembler asm;
        public TciParser(TokenStream input, TciAssembler asm) {
            this(input);
            this.asm = asm;
        }



    // $ANTLR start "tci"
    // Tci.g:15:1: tci : ( onedef )+ ;
    public final void tci() throws RecognitionException {
        try {
            // Tci.g:15:4: ( ( onedef )+ )
            // Tci.g:15:6: ( onedef )+
            {
            // Tci.g:15:6: ( onedef )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= 14 && LA1_0 <= 20)||(LA1_0 >= 22 && LA1_0 <= 40)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Tci.g:15:6: onedef
            	    {
            	    pushFollow(FOLLOW_onedef_in_tci46);
            	    onedef();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


             asm.done(); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "tci"



    // $ANTLR start "onedef"
    // Tci.g:18:1: onedef : ( defcalcsize | defcalc | defnodesize | defnode | defnodeformulas | defnodecalc | defcalcdef | defcalctotal | defedgesize | defedge | deftablesize | deftable | deftablecol | deftablevalue | deftablerow | deffuncsize | deffunc | definputcalcidsize | definputcalcid | definputsize | definput | definputautocounter | definputcalc | defformulasize | defformula );
    public final void onedef() throws RecognitionException {
        try {
            // Tci.g:18:7: ( defcalcsize | defcalc | defnodesize | defnode | defnodeformulas | defnodecalc | defcalcdef | defcalctotal | defedgesize | defedge | deftablesize | deftable | deftablecol | deftablevalue | deftablerow | deffuncsize | deffunc | definputcalcidsize | definputcalcid | definputsize | definput | definputautocounter | definputcalc | defformulasize | defformula )
            int alt2=25;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt2=1;
                }
                break;
            case 14:
                {
                alt2=2;
                }
                break;
            case 35:
                {
                alt2=3;
                }
                break;
            case 32:
                {
                alt2=4;
                }
                break;
            case 34:
                {
                alt2=5;
                }
                break;
            case 33:
                {
                alt2=6;
                }
                break;
            case 15:
                {
                alt2=7;
                }
                break;
            case 17:
                {
                alt2=8;
                }
                break;
            case 19:
                {
                alt2=9;
                }
                break;
            case 18:
            case 31:
                {
                alt2=10;
                }
                break;
            case 39:
                {
                alt2=11;
                }
                break;
            case 36:
                {
                alt2=12;
                }
                break;
            case 37:
                {
                alt2=13;
                }
                break;
            case 40:
                {
                alt2=14;
                }
                break;
            case 38:
                {
                alt2=15;
                }
                break;
            case 24:
                {
                alt2=16;
                }
                break;
            case 23:
                {
                alt2=17;
                }
                break;
            case 29:
                {
                alt2=18;
                }
                break;
            case 28:
                {
                alt2=19;
                }
                break;
            case 30:
                {
                alt2=20;
                }
                break;
            case 25:
                {
                alt2=21;
                }
                break;
            case 26:
                {
                alt2=22;
                }
                break;
            case 27:
                {
                alt2=23;
                }
                break;
            case 22:
                {
                alt2=24;
                }
                break;
            case 20:
                {
                alt2=25;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }

            switch (alt2) {
                case 1 :
                    // Tci.g:19:5: defcalcsize
                    {
                    pushFollow(FOLLOW_defcalcsize_in_onedef97);
                    defcalcsize();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // Tci.g:19:19: defcalc
                    {
                    pushFollow(FOLLOW_defcalc_in_onedef101);
                    defcalc();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // Tci.g:20:5: defnodesize
                    {
                    pushFollow(FOLLOW_defnodesize_in_onedef108);
                    defnodesize();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // Tci.g:20:19: defnode
                    {
                    pushFollow(FOLLOW_defnode_in_onedef112);
                    defnode();

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // Tci.g:21:5: defnodeformulas
                    {
                    pushFollow(FOLLOW_defnodeformulas_in_onedef119);
                    defnodeformulas();

                    state._fsp--;


                    }
                    break;
                case 6 :
                    // Tci.g:22:5: defnodecalc
                    {
                    pushFollow(FOLLOW_defnodecalc_in_onedef126);
                    defnodecalc();

                    state._fsp--;


                    }
                    break;
                case 7 :
                    // Tci.g:22:19: defcalcdef
                    {
                    pushFollow(FOLLOW_defcalcdef_in_onedef130);
                    defcalcdef();

                    state._fsp--;


                    }
                    break;
                case 8 :
                    // Tci.g:23:5: defcalctotal
                    {
                    pushFollow(FOLLOW_defcalctotal_in_onedef137);
                    defcalctotal();

                    state._fsp--;


                    }
                    break;
                case 9 :
                    // Tci.g:24:5: defedgesize
                    {
                    pushFollow(FOLLOW_defedgesize_in_onedef144);
                    defedgesize();

                    state._fsp--;


                    }
                    break;
                case 10 :
                    // Tci.g:24:19: defedge
                    {
                    pushFollow(FOLLOW_defedge_in_onedef148);
                    defedge();

                    state._fsp--;


                    }
                    break;
                case 11 :
                    // Tci.g:25:5: deftablesize
                    {
                    pushFollow(FOLLOW_deftablesize_in_onedef155);
                    deftablesize();

                    state._fsp--;


                    }
                    break;
                case 12 :
                    // Tci.g:25:20: deftable
                    {
                    pushFollow(FOLLOW_deftable_in_onedef159);
                    deftable();

                    state._fsp--;


                    }
                    break;
                case 13 :
                    // Tci.g:25:31: deftablecol
                    {
                    pushFollow(FOLLOW_deftablecol_in_onedef163);
                    deftablecol();

                    state._fsp--;


                    }
                    break;
                case 14 :
                    // Tci.g:25:45: deftablevalue
                    {
                    pushFollow(FOLLOW_deftablevalue_in_onedef167);
                    deftablevalue();

                    state._fsp--;


                    }
                    break;
                case 15 :
                    // Tci.g:25:61: deftablerow
                    {
                    pushFollow(FOLLOW_deftablerow_in_onedef171);
                    deftablerow();

                    state._fsp--;


                    }
                    break;
                case 16 :
                    // Tci.g:26:5: deffuncsize
                    {
                    pushFollow(FOLLOW_deffuncsize_in_onedef177);
                    deffuncsize();

                    state._fsp--;


                    }
                    break;
                case 17 :
                    // Tci.g:26:19: deffunc
                    {
                    pushFollow(FOLLOW_deffunc_in_onedef181);
                    deffunc();

                    state._fsp--;


                    }
                    break;
                case 18 :
                    // Tci.g:27:5: definputcalcidsize
                    {
                    pushFollow(FOLLOW_definputcalcidsize_in_onedef187);
                    definputcalcidsize();

                    state._fsp--;


                    }
                    break;
                case 19 :
                    // Tci.g:27:26: definputcalcid
                    {
                    pushFollow(FOLLOW_definputcalcid_in_onedef191);
                    definputcalcid();

                    state._fsp--;


                    }
                    break;
                case 20 :
                    // Tci.g:28:5: definputsize
                    {
                    pushFollow(FOLLOW_definputsize_in_onedef197);
                    definputsize();

                    state._fsp--;


                    }
                    break;
                case 21 :
                    // Tci.g:28:20: definput
                    {
                    pushFollow(FOLLOW_definput_in_onedef201);
                    definput();

                    state._fsp--;


                    }
                    break;
                case 22 :
                    // Tci.g:28:31: definputautocounter
                    {
                    pushFollow(FOLLOW_definputautocounter_in_onedef205);
                    definputautocounter();

                    state._fsp--;


                    }
                    break;
                case 23 :
                    // Tci.g:28:53: definputcalc
                    {
                    pushFollow(FOLLOW_definputcalc_in_onedef209);
                    definputcalc();

                    state._fsp--;


                    }
                    break;
                case 24 :
                    // Tci.g:29:5: defformulasize
                    {
                    pushFollow(FOLLOW_defformulasize_in_onedef215);
                    defformulasize();

                    state._fsp--;


                    }
                    break;
                case 25 :
                    // Tci.g:29:22: defformula
                    {
                    pushFollow(FOLLOW_defformula_in_onedef219);
                    defformula();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "onedef"



    // $ANTLR start "defcalcsize"
    // Tci.g:32:1: defcalcsize : '.calcs' 'size' '=' NUMBER_INT ;
    public final void defcalcsize() throws RecognitionException {
        Token NUMBER_INT1=null;

        try {
            // Tci.g:32:12: ( '.calcs' 'size' '=' NUMBER_INT )
            // Tci.g:33:5: '.calcs' 'size' '=' NUMBER_INT
            {
            match(input,16,FOLLOW_16_in_defcalcsize240); 

            match(input,76,FOLLOW_76_in_defcalcsize247); 

            match(input,42,FOLLOW_42_in_defcalcsize249); 

            NUMBER_INT1=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_defcalcsize251); 

             asm.setCalcsize(NUMBER_INT1); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "defcalcsize"



    // $ANTLR start "defcalc"
    // Tci.g:37:1: defcalc : '.calc' 'calc' '=' calc= NUMBER_INT 'name' '=' name= ID 'nargs' '=' nargs= NUMBER_INT ( 'computenode' '=' node= NUMBER_INT | 'computestartnode' '=' node= NUMBER_INT ) ;
    public final void defcalc() throws RecognitionException {
        Token calc=null;
        Token name=null;
        Token nargs=null;
        Token node=null;

        try {
            // Tci.g:37:8: ( '.calc' 'calc' '=' calc= NUMBER_INT 'name' '=' name= ID 'nargs' '=' nargs= NUMBER_INT ( 'computenode' '=' node= NUMBER_INT | 'computestartnode' '=' node= NUMBER_INT ) )
            // Tci.g:38:5: '.calc' 'calc' '=' calc= NUMBER_INT 'name' '=' name= ID 'nargs' '=' nargs= NUMBER_INT ( 'computenode' '=' node= NUMBER_INT | 'computestartnode' '=' node= NUMBER_INT )
            {
            match(input,14,FOLLOW_14_in_defcalc301); 

            match(input,45,FOLLOW_45_in_defcalc308); 

            match(input,42,FOLLOW_42_in_defcalc310); 

            calc=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_defcalc315); 

            match(input,65,FOLLOW_65_in_defcalc321); 

            match(input,42,FOLLOW_42_in_defcalc323); 

            name=(Token)match(input,ID,FOLLOW_ID_in_defcalc328); 

            match(input,66,FOLLOW_66_in_defcalc335); 

            match(input,42,FOLLOW_42_in_defcalc337); 

            nargs=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_defcalc341); 

             asm.addCalc(calc, name, nargs); 

            // Tci.g:42:5: ( 'computenode' '=' node= NUMBER_INT | 'computestartnode' '=' node= NUMBER_INT )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==51) ) {
                alt3=1;
            }
            else if ( (LA3_0==52) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // Tci.g:42:9: 'computenode' '=' node= NUMBER_INT
                    {
                    match(input,51,FOLLOW_51_in_defcalc373); 

                    match(input,42,FOLLOW_42_in_defcalc380); 

                    node=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_defcalc384); 

                     asm.setCalcMainSingle(calc, node); 

                    }
                    break;
                case 2 :
                    // Tci.g:43:9: 'computestartnode' '=' node= NUMBER_INT
                    {
                    match(input,52,FOLLOW_52_in_defcalc402); 

                    match(input,42,FOLLOW_42_in_defcalc404); 

                    node=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_defcalc408); 

                     asm.setCalcMainSum   (calc, node); 

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "defcalc"



    // $ANTLR start "defnodesize"
    // Tci.g:47:1: defnodesize : '.nodes' 'size' '=' NUMBER_INT ;
    public final void defnodesize() throws RecognitionException {
        Token NUMBER_INT2=null;

        try {
            // Tci.g:47:12: ( '.nodes' 'size' '=' NUMBER_INT )
            // Tci.g:48:5: '.nodes' 'size' '=' NUMBER_INT
            {
            match(input,35,FOLLOW_35_in_defnodesize458); 

            match(input,76,FOLLOW_76_in_defnodesize464); 

            match(input,42,FOLLOW_42_in_defnodesize466); 

            NUMBER_INT2=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_defnodesize468); 

             asm.setNodesize(NUMBER_INT2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "defnodesize"



    // $ANTLR start "defnode"
    // Tci.g:52:1: defnode : '.node' 'node' '=' node= NUMBER_INT 'id' '=' id= ID ( 'name' '=' name= ( ID | STRING ) )? ;
    public final void defnode() throws RecognitionException {
        Token node=null;
        Token id=null;
        Token name=null;

        try {
            // Tci.g:52:8: ( '.node' 'node' '=' node= NUMBER_INT 'id' '=' id= ID ( 'name' '=' name= ( ID | STRING ) )? )
            // Tci.g:53:5: '.node' 'node' '=' node= NUMBER_INT 'id' '=' id= ID ( 'name' '=' name= ( ID | STRING ) )?
            {
            match(input,32,FOLLOW_32_in_defnode532); 

            match(input,67,FOLLOW_67_in_defnode539); 

            match(input,42,FOLLOW_42_in_defnode541); 

            node=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_defnode545); 

            match(input,61,FOLLOW_61_in_defnode579); 

            match(input,42,FOLLOW_42_in_defnode581); 

            id=(Token)match(input,ID,FOLLOW_ID_in_defnode587); 

            // Tci.g:56:5: ( 'name' '=' name= ( ID | STRING ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==65) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // Tci.g:56:6: 'name' '=' name= ( ID | STRING )
                    {
                    match(input,65,FOLLOW_65_in_defnode632); 

                    match(input,42,FOLLOW_42_in_defnode634); 

                    name=(Token)input.LT(1);

                    if ( input.LA(1)==ID||input.LA(1)==STRING ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    }
                    break;

            }


             asm.addNode(node, id, name); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "defnode"



    // $ANTLR start "defnodeformulas"
    // Tci.g:59:1: defnodeformulas : '.nodeformulas' 'node' '=' node= NUMBER_INT ( 'inclusion' '=' inclusion= NUMBER_INT )? ( 'timesformula' '=' times= NUMBER_INT 'timesid' '=' timesid= NUMBER_INT )? ;
    public final void defnodeformulas() throws RecognitionException {
        Token node=null;
        Token inclusion=null;
        Token times=null;
        Token timesid=null;

        try {
            // Tci.g:59:16: ( '.nodeformulas' 'node' '=' node= NUMBER_INT ( 'inclusion' '=' inclusion= NUMBER_INT )? ( 'timesformula' '=' times= NUMBER_INT 'timesid' '=' timesid= NUMBER_INT )? )
            // Tci.g:62:5: '.nodeformulas' 'node' '=' node= NUMBER_INT ( 'inclusion' '=' inclusion= NUMBER_INT )? ( 'timesformula' '=' times= NUMBER_INT 'timesid' '=' timesid= NUMBER_INT )?
            {
            match(input,34,FOLLOW_34_in_defnodeformulas723); 

            match(input,67,FOLLOW_67_in_defnodeformulas729); 

            match(input,42,FOLLOW_42_in_defnodeformulas731); 

            node=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_defnodeformulas735); 

            // Tci.g:64:5: ( 'inclusion' '=' inclusion= NUMBER_INT )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==62) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // Tci.g:64:6: 'inclusion' '=' inclusion= NUMBER_INT
                    {
                    match(input,62,FOLLOW_62_in_defnodeformulas742); 

                    match(input,42,FOLLOW_42_in_defnodeformulas744); 

                    inclusion=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_defnodeformulas748); 

                    }
                    break;

            }


            // Tci.g:65:5: ( 'timesformula' '=' times= NUMBER_INT 'timesid' '=' timesid= NUMBER_INT )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==78) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // Tci.g:65:6: 'timesformula' '=' times= NUMBER_INT 'timesid' '=' timesid= NUMBER_INT
                    {
                    match(input,78,FOLLOW_78_in_defnodeformulas757); 

                    match(input,42,FOLLOW_42_in_defnodeformulas759); 

                    times=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_defnodeformulas763); 

                    match(input,79,FOLLOW_79_in_defnodeformulas765); 

                    match(input,42,FOLLOW_42_in_defnodeformulas767); 

                    timesid=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_defnodeformulas771); 

                    }
                    break;

            }


             asm.addNodeFormula(node, inclusion, times, timesid); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "defnodeformulas"



    // $ANTLR start "defnodecalc"
    // Tci.g:69:1: defnodecalc : '.nodecalc' 'node' '=' node= NUMBER_INT 'calc' '=' calc= NUMBER_INT 'formula' '=' formula= NUMBER_INT ;
    public final void defnodecalc() throws RecognitionException {
        Token node=null;
        Token calc=null;
        Token formula=null;

        try {
            // Tci.g:69:12: ( '.nodecalc' 'node' '=' node= NUMBER_INT 'calc' '=' calc= NUMBER_INT 'formula' '=' formula= NUMBER_INT )
            // Tci.g:70:5: '.nodecalc' 'node' '=' node= NUMBER_INT 'calc' '=' calc= NUMBER_INT 'formula' '=' formula= NUMBER_INT
            {
            match(input,33,FOLLOW_33_in_defnodecalc844); 

            match(input,67,FOLLOW_67_in_defnodecalc851); 

            match(input,42,FOLLOW_42_in_defnodecalc853); 

            node=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_defnodecalc857); 

            match(input,45,FOLLOW_45_in_defnodecalc863); 

            match(input,42,FOLLOW_42_in_defnodecalc865); 

            calc=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_defnodecalc869); 

            match(input,57,FOLLOW_57_in_defnodecalc875); 

            match(input,42,FOLLOW_42_in_defnodecalc877); 

            formula=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_defnodecalc881); 

             asm.addNodeCalc(node, calc, formula); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "defnodecalc"



    // $ANTLR start "defcalcdef"
    // Tci.g:76:1: defcalcdef : '.calcdef' 'node' '=' node= NUMBER_INT ( 'calc' '=' calc= NUMBER_INT | 'calc_rangestart' '=' calcfrom= NUMBER_INT 'calc_rangeend' '=' calcto= NUMBER_INT ) ;
    public final void defcalcdef() throws RecognitionException {
        Token node=null;
        Token calc=null;
        Token calcfrom=null;
        Token calcto=null;

        try {
            // Tci.g:76:11: ( '.calcdef' 'node' '=' node= NUMBER_INT ( 'calc' '=' calc= NUMBER_INT | 'calc_rangestart' '=' calcfrom= NUMBER_INT 'calc_rangeend' '=' calcto= NUMBER_INT ) )
            // Tci.g:78:5: '.calcdef' 'node' '=' node= NUMBER_INT ( 'calc' '=' calc= NUMBER_INT | 'calc_rangestart' '=' calcfrom= NUMBER_INT 'calc_rangeend' '=' calcto= NUMBER_INT )
            {
            match(input,15,FOLLOW_15_in_defcalcdef928); 

            match(input,67,FOLLOW_67_in_defcalcdef935); 

            match(input,42,FOLLOW_42_in_defcalcdef937); 

            node=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_defcalcdef941); 

            // Tci.g:80:5: ( 'calc' '=' calc= NUMBER_INT | 'calc_rangestart' '=' calcfrom= NUMBER_INT 'calc_rangeend' '=' calcto= NUMBER_INT )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==45) ) {
                alt7=1;
            }
            else if ( (LA7_0==47) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }
            switch (alt7) {
                case 1 :
                    // Tci.g:80:8: 'calc' '=' calc= NUMBER_INT
                    {
                    match(input,45,FOLLOW_45_in_defcalcdef950); 

                    match(input,42,FOLLOW_42_in_defcalcdef952); 

                    calc=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_defcalcdef956); 

                     asm.addNodeCalcdef(node, calc); 

                    }
                    break;
                case 2 :
                    // Tci.g:81:8: 'calc_rangestart' '=' calcfrom= NUMBER_INT 'calc_rangeend' '=' calcto= NUMBER_INT
                    {
                    match(input,47,FOLLOW_47_in_defcalcdef985); 

                    match(input,42,FOLLOW_42_in_defcalcdef987); 

                    calcfrom=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_defcalcdef991); 

                    match(input,46,FOLLOW_46_in_defcalcdef993); 

                    match(input,42,FOLLOW_42_in_defcalcdef995); 

                    calcto=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_defcalcdef999); 

                     asm.addNodeCalcdef(node, calcfrom, calcto); 

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "defcalcdef"



    // $ANTLR start "defcalctotal"
    // Tci.g:86:1: defcalctotal : '.calctotal' 'node' '=' node= NUMBER_INT ( 'calc' '=' calc= NUMBER_INT | 'calc_rangestart' '=' calcfrom= NUMBER_INT 'calc_rangeend' '=' calcto= NUMBER_INT ) ;
    public final void defcalctotal() throws RecognitionException {
        Token node=null;
        Token calc=null;
        Token calcfrom=null;
        Token calcto=null;

        try {
            // Tci.g:86:13: ( '.calctotal' 'node' '=' node= NUMBER_INT ( 'calc' '=' calc= NUMBER_INT | 'calc_rangestart' '=' calcfrom= NUMBER_INT 'calc_rangeend' '=' calcto= NUMBER_INT ) )
            // Tci.g:87:5: '.calctotal' 'node' '=' node= NUMBER_INT ( 'calc' '=' calc= NUMBER_INT | 'calc_rangestart' '=' calcfrom= NUMBER_INT 'calc_rangeend' '=' calcto= NUMBER_INT )
            {
            match(input,17,FOLLOW_17_in_defcalctotal1076); 

            match(input,67,FOLLOW_67_in_defcalctotal1082); 

            match(input,42,FOLLOW_42_in_defcalctotal1084); 

            node=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_defcalctotal1088); 

            // Tci.g:89:5: ( 'calc' '=' calc= NUMBER_INT | 'calc_rangestart' '=' calcfrom= NUMBER_INT 'calc_rangeend' '=' calcto= NUMBER_INT )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==45) ) {
                alt8=1;
            }
            else if ( (LA8_0==47) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }
            switch (alt8) {
                case 1 :
                    // Tci.g:89:8: 'calc' '=' calc= NUMBER_INT
                    {
                    match(input,45,FOLLOW_45_in_defcalctotal1110); 

                    match(input,42,FOLLOW_42_in_defcalctotal1112); 

                    calc=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_defcalctotal1116); 

                     asm.addNodeCalctotal(node, calc); 

                    }
                    break;
                case 2 :
                    // Tci.g:90:8: 'calc_rangestart' '=' calcfrom= NUMBER_INT 'calc_rangeend' '=' calcto= NUMBER_INT
                    {
                    match(input,47,FOLLOW_47_in_defcalctotal1145); 

                    match(input,42,FOLLOW_42_in_defcalctotal1147); 

                    calcfrom=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_defcalctotal1151); 

                    match(input,46,FOLLOW_46_in_defcalctotal1153); 

                    match(input,42,FOLLOW_42_in_defcalctotal1155); 

                    calcto=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_defcalctotal1159); 

                     asm.addNodeCalctotal(node, calcfrom, calcto); 

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "defcalctotal"



    // $ANTLR start "defedgesize"
    // Tci.g:95:1: defedgesize : '.edges' 'from' '=' edge= NUMBER_INT 'size' '=' size= NUMBER_INT ;
    public final void defedgesize() throws RecognitionException {
        Token edge=null;
        Token size=null;

        try {
            // Tci.g:95:12: ( '.edges' 'from' '=' edge= NUMBER_INT 'size' '=' size= NUMBER_INT )
            // Tci.g:96:5: '.edges' 'from' '=' edge= NUMBER_INT 'size' '=' size= NUMBER_INT
            {
            match(input,19,FOLLOW_19_in_defedgesize1267); 

            match(input,58,FOLLOW_58_in_defedgesize1281); 

            match(input,42,FOLLOW_42_in_defedgesize1283); 

            edge=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_defedgesize1287); 

            match(input,76,FOLLOW_76_in_defedgesize1293); 

            match(input,42,FOLLOW_42_in_defedgesize1295); 

            size=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_defedgesize1299); 

             asm.setEdgesize(edge, size); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "defedgesize"



    // $ANTLR start "defedge"
    // Tci.g:101:1: defedge : what= ( '.edge' | '.link' ) 'ind' '=' ind= NUMBER_INT 'from' '=' from= NUMBER_INT 'to' '=' to= NUMBER_INT ;
    public final void defedge() throws RecognitionException {
        Token what=null;
        Token ind=null;
        Token from=null;
        Token to=null;

        try {
            // Tci.g:101:8: (what= ( '.edge' | '.link' ) 'ind' '=' ind= NUMBER_INT 'from' '=' from= NUMBER_INT 'to' '=' to= NUMBER_INT )
            // Tci.g:102:5: what= ( '.edge' | '.link' ) 'ind' '=' ind= NUMBER_INT 'from' '=' from= NUMBER_INT 'to' '=' to= NUMBER_INT
            {
            what=(Token)input.LT(1);

            if ( input.LA(1)==18||input.LA(1)==31 ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            match(input,63,FOLLOW_63_in_defedge1353); 

            match(input,42,FOLLOW_42_in_defedge1356); 

            ind=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_defedge1360); 

            match(input,58,FOLLOW_58_in_defedge1371); 

            match(input,42,FOLLOW_42_in_defedge1373); 

            from=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_defedge1377); 

            match(input,80,FOLLOW_80_in_defedge1383); 

            match(input,42,FOLLOW_42_in_defedge1385); 

            to=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_defedge1389); 

             asm.addEdge(ind, from, to, what); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "defedge"



    // $ANTLR start "deftablesize"
    // Tci.g:108:1: deftablesize : '.tables' 'size' '=' NUMBER_INT ;
    public final void deftablesize() throws RecognitionException {
        Token NUMBER_INT3=null;

        try {
            // Tci.g:108:13: ( '.tables' 'size' '=' NUMBER_INT )
            // Tci.g:109:5: '.tables' 'size' '=' NUMBER_INT
            {
            match(input,39,FOLLOW_39_in_deftablesize1433); 

            match(input,76,FOLLOW_76_in_deftablesize1452); 

            match(input,42,FOLLOW_42_in_deftablesize1454); 

            NUMBER_INT3=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_deftablesize1456); 

             asm.setTablesize(NUMBER_INT3); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "deftablesize"



    // $ANTLR start "deftable"
    // Tci.g:113:1: deftable : '.table' 'table' '=' table= NUMBER_INT 'name' '=' name= value 'rows' '=' rows= NUMBER_INT 'cols' '=' cols= NUMBER_INT 'shuffled' '=' shuffled= ( 'true' | 'false' ) 'directaccess' '=' directaccess= ( 'true' | 'false' ) ( 'directaccessoffset' '=' directaccessoffset= NUMBER_INT )? ;
    public final void deftable() throws RecognitionException {
        Token table=null;
        Token rows=null;
        Token cols=null;
        Token shuffled=null;
        Token directaccess=null;
        Token directaccessoffset=null;
        TciParser.value_return name =null;


        try {
            // Tci.g:113:9: ( '.table' 'table' '=' table= NUMBER_INT 'name' '=' name= value 'rows' '=' rows= NUMBER_INT 'cols' '=' cols= NUMBER_INT 'shuffled' '=' shuffled= ( 'true' | 'false' ) 'directaccess' '=' directaccess= ( 'true' | 'false' ) ( 'directaccessoffset' '=' directaccessoffset= NUMBER_INT )? )
            // Tci.g:115:5: '.table' 'table' '=' table= NUMBER_INT 'name' '=' name= value 'rows' '=' rows= NUMBER_INT 'cols' '=' cols= NUMBER_INT 'shuffled' '=' shuffled= ( 'true' | 'false' ) 'directaccess' '=' directaccess= ( 'true' | 'false' ) ( 'directaccessoffset' '=' directaccessoffset= NUMBER_INT )?
            {
            match(input,36,FOLLOW_36_in_deftable1512); 

            match(input,77,FOLLOW_77_in_deftable1518); 

            match(input,42,FOLLOW_42_in_deftable1520); 

            table=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_deftable1524); 

            match(input,65,FOLLOW_65_in_deftable1530); 

            match(input,42,FOLLOW_42_in_deftable1532); 

            pushFollow(FOLLOW_value_in_deftable1536);
            name=value();

            state._fsp--;


            match(input,73,FOLLOW_73_in_deftable1554); 

            match(input,42,FOLLOW_42_in_deftable1556); 

            rows=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_deftable1560); 

            match(input,50,FOLLOW_50_in_deftable1566); 

            match(input,42,FOLLOW_42_in_deftable1568); 

            cols=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_deftable1572); 

            match(input,74,FOLLOW_74_in_deftable1578); 

            match(input,42,FOLLOW_42_in_deftable1580); 

            shuffled=(Token)input.LT(1);

            if ( input.LA(1)==56||input.LA(1)==81 ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            match(input,54,FOLLOW_54_in_deftable1597); 

            match(input,42,FOLLOW_42_in_deftable1599); 

            directaccess=(Token)input.LT(1);

            if ( input.LA(1)==56||input.LA(1)==81 ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            // Tci.g:122:5: ( 'directaccessoffset' '=' directaccessoffset= NUMBER_INT )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==55) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // Tci.g:122:6: 'directaccessoffset' '=' directaccessoffset= NUMBER_INT
                    {
                    match(input,55,FOLLOW_55_in_deftable1616); 

                    match(input,42,FOLLOW_42_in_deftable1618); 

                    directaccessoffset=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_deftable1622); 

                    }
                    break;

            }


             asm.addTable(table, (name!=null?((Token)name.start):null), rows, cols, shuffled, directaccess, directaccessoffset); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "deftable"



    // $ANTLR start "deftablecol"
    // Tci.g:126:1: deftablecol : '.tablecol' 'table' '=' table= NUMBER_INT 'col' '=' colind= NUMBER_INT 'name' '=' name= value 'numeric' '=' numeric= ( 'true' | 'false' ) 'numericsuper' '=' numericsuper= ( 'true' | 'false' ) 'numericunique' '=' numericunique= ( 'true' | 'false' ) ;
    public final void deftablecol() throws RecognitionException {
        Token table=null;
        Token colind=null;
        Token numeric=null;
        Token numericsuper=null;
        Token numericunique=null;
        TciParser.value_return name =null;


        try {
            // Tci.g:126:12: ( '.tablecol' 'table' '=' table= NUMBER_INT 'col' '=' colind= NUMBER_INT 'name' '=' name= value 'numeric' '=' numeric= ( 'true' | 'false' ) 'numericsuper' '=' numericsuper= ( 'true' | 'false' ) 'numericunique' '=' numericunique= ( 'true' | 'false' ) )
            // Tci.g:127:5: '.tablecol' 'table' '=' table= NUMBER_INT 'col' '=' colind= NUMBER_INT 'name' '=' name= value 'numeric' '=' numeric= ( 'true' | 'false' ) 'numericsuper' '=' numericsuper= ( 'true' | 'false' ) 'numericunique' '=' numericunique= ( 'true' | 'false' )
            {
            match(input,37,FOLLOW_37_in_deftablecol1662); 

            match(input,77,FOLLOW_77_in_deftablecol1668); 

            match(input,42,FOLLOW_42_in_deftablecol1670); 

            table=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_deftablecol1674); 

            match(input,49,FOLLOW_49_in_deftablecol1680); 

            match(input,42,FOLLOW_42_in_deftablecol1682); 

            colind=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_deftablecol1686); 

            match(input,65,FOLLOW_65_in_deftablecol1692); 

            match(input,42,FOLLOW_42_in_deftablecol1694); 

            pushFollow(FOLLOW_value_in_deftablecol1698);
            name=value();

            state._fsp--;


            match(input,68,FOLLOW_68_in_deftablecol1704); 

            match(input,42,FOLLOW_42_in_deftablecol1706); 

            numeric=(Token)input.LT(1);

            if ( input.LA(1)==56||input.LA(1)==81 ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            match(input,69,FOLLOW_69_in_deftablecol1722); 

            match(input,42,FOLLOW_42_in_deftablecol1724); 

            numericsuper=(Token)input.LT(1);

            if ( input.LA(1)==56||input.LA(1)==81 ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            match(input,70,FOLLOW_70_in_deftablecol1740); 

            match(input,42,FOLLOW_42_in_deftablecol1742); 

            numericunique=(Token)input.LT(1);

            if ( input.LA(1)==56||input.LA(1)==81 ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


             asm.addTableColumn(table, colind, (name!=null?((Token)name.start):null), numeric, numericsuper, numericunique); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "deftablecol"



    // $ANTLR start "deftablevalue"
    // Tci.g:137:1: deftablevalue : '.tablevalue' 'table' '=' table= NUMBER_INT 'ind' '=' ind= NUMBER_INT 'row' '=' row= NUMBER_INT 'col' '=' col= NUMBER_INT 'value' '=' cellvalue= value ;
    public final void deftablevalue() throws RecognitionException {
        Token table=null;
        Token ind=null;
        Token row=null;
        Token col=null;
        TciParser.value_return cellvalue =null;


        try {
            // Tci.g:137:14: ( '.tablevalue' 'table' '=' table= NUMBER_INT 'ind' '=' ind= NUMBER_INT 'row' '=' row= NUMBER_INT 'col' '=' col= NUMBER_INT 'value' '=' cellvalue= value )
            // Tci.g:138:5: '.tablevalue' 'table' '=' table= NUMBER_INT 'ind' '=' ind= NUMBER_INT 'row' '=' row= NUMBER_INT 'col' '=' col= NUMBER_INT 'value' '=' cellvalue= value
            {
            match(input,40,FOLLOW_40_in_deftablevalue1827); 

            match(input,77,FOLLOW_77_in_deftablevalue1833); 

            match(input,42,FOLLOW_42_in_deftablevalue1835); 

            table=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_deftablevalue1839); 

            match(input,63,FOLLOW_63_in_deftablevalue1845); 

            match(input,42,FOLLOW_42_in_deftablevalue1847); 

            ind=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_deftablevalue1851); 

            match(input,72,FOLLOW_72_in_deftablevalue1857); 

            match(input,42,FOLLOW_42_in_deftablevalue1859); 

            row=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_deftablevalue1863); 

            match(input,49,FOLLOW_49_in_deftablevalue1869); 

            match(input,42,FOLLOW_42_in_deftablevalue1871); 

            col=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_deftablevalue1875); 

            match(input,82,FOLLOW_82_in_deftablevalue1881); 

            match(input,42,FOLLOW_42_in_deftablevalue1883); 

            pushFollow(FOLLOW_value_in_deftablevalue1887);
            cellvalue=value();

            state._fsp--;


             asm.addTableValue(table, ind, row, col, (cellvalue!=null?((Token)cellvalue.start):null)); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "deftablevalue"



    // $ANTLR start "deftablerow"
    // Tci.g:147:1: deftablerow : '.tablerow' 'table' '=' table= NUMBER_INT 'row' '=' rowind= NUMBER_INT 'oo' '=' oo= NUMBER_INT ;
    public final void deftablerow() throws RecognitionException {
        Token table=null;
        Token rowind=null;
        Token oo=null;

        try {
            // Tci.g:147:12: ( '.tablerow' 'table' '=' table= NUMBER_INT 'row' '=' rowind= NUMBER_INT 'oo' '=' oo= NUMBER_INT )
            // Tci.g:148:5: '.tablerow' 'table' '=' table= NUMBER_INT 'row' '=' rowind= NUMBER_INT 'oo' '=' oo= NUMBER_INT
            {
            match(input,38,FOLLOW_38_in_deftablerow1923); 

            match(input,77,FOLLOW_77_in_deftablerow1929); 

            match(input,42,FOLLOW_42_in_deftablerow1931); 

            table=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_deftablerow1935); 

            match(input,72,FOLLOW_72_in_deftablerow1941); 

            match(input,42,FOLLOW_42_in_deftablerow1943); 

            rowind=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_deftablerow1947); 

            match(input,71,FOLLOW_71_in_deftablerow1953); 

            match(input,42,FOLLOW_42_in_deftablerow1955); 

            oo=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_deftablerow1959); 

             asm.addTableRowInfo(table, rowind, oo); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "deftablerow"



    // $ANTLR start "deffuncsize"
    // Tci.g:155:1: deffuncsize : '.funcs' 'size' '=' NUMBER_INT ;
    public final void deffuncsize() throws RecognitionException {
        Token NUMBER_INT4=null;

        try {
            // Tci.g:155:12: ( '.funcs' 'size' '=' NUMBER_INT )
            // Tci.g:156:5: '.funcs' 'size' '=' NUMBER_INT
            {
            match(input,24,FOLLOW_24_in_deffuncsize2020); 

            match(input,76,FOLLOW_76_in_deffuncsize2026); 

            match(input,42,FOLLOW_42_in_deffuncsize2028); 

            NUMBER_INT4=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_deffuncsize2030); 

             asm.setFuncsize(NUMBER_INT4); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "deffuncsize"



    // $ANTLR start "deffunc"
    // Tci.g:161:1: deffunc : '.func' 'func' '=' func= NUMBER_INT 'name' '=' name= ID 'args' '=' nargs= NUMBER_INT 'formula' '=' formula= NUMBER_INT ;
    public final void deffunc() throws RecognitionException {
        Token func=null;
        Token name=null;
        Token nargs=null;
        Token formula=null;

        try {
            // Tci.g:161:8: ( '.func' 'func' '=' func= NUMBER_INT 'name' '=' name= ID 'args' '=' nargs= NUMBER_INT 'formula' '=' formula= NUMBER_INT )
            // Tci.g:162:5: '.func' 'func' '=' func= NUMBER_INT 'name' '=' name= ID 'args' '=' nargs= NUMBER_INT 'formula' '=' formula= NUMBER_INT
            {
            match(input,23,FOLLOW_23_in_deffunc2110); 

            match(input,59,FOLLOW_59_in_deffunc2116); 

            match(input,42,FOLLOW_42_in_deffunc2118); 

            func=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_deffunc2122); 

            match(input,65,FOLLOW_65_in_deffunc2128); 

            match(input,42,FOLLOW_42_in_deffunc2130); 

            name=(Token)match(input,ID,FOLLOW_ID_in_deffunc2134); 

            match(input,43,FOLLOW_43_in_deffunc2140); 

            match(input,42,FOLLOW_42_in_deffunc2142); 

            nargs=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_deffunc2146); 

            match(input,57,FOLLOW_57_in_deffunc2155); 

            match(input,42,FOLLOW_42_in_deffunc2157); 

            formula=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_deffunc2161); 

             asm.addFunc(func, name, nargs, formula); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "deffunc"



    // $ANTLR start "definputcalcidsize"
    // Tci.g:170:1: definputcalcidsize : '.inputcalcids' 'size' '=' NUMBER_INT ;
    public final void definputcalcidsize() throws RecognitionException {
        Token NUMBER_INT5=null;

        try {
            // Tci.g:170:19: ( '.inputcalcids' 'size' '=' NUMBER_INT )
            // Tci.g:171:5: '.inputcalcids' 'size' '=' NUMBER_INT
            {
            match(input,29,FOLLOW_29_in_definputcalcidsize2197); 

            match(input,76,FOLLOW_76_in_definputcalcidsize2204); 

            match(input,42,FOLLOW_42_in_definputcalcidsize2206); 

            NUMBER_INT5=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_definputcalcidsize2208); 

             asm.setInputcalcidSize(NUMBER_INT5); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "definputcalcidsize"



    // $ANTLR start "definputcalcid"
    // Tci.g:176:1: definputcalcid : '.inputcalcid' 'icalc' '=' inputcalc= NUMBER_INT 'name' '=' name= ID ;
    public final void definputcalcid() throws RecognitionException {
        Token inputcalc=null;
        Token name=null;

        try {
            // Tci.g:176:15: ( '.inputcalcid' 'icalc' '=' inputcalc= NUMBER_INT 'name' '=' name= ID )
            // Tci.g:177:5: '.inputcalcid' 'icalc' '=' inputcalc= NUMBER_INT 'name' '=' name= ID
            {
            match(input,28,FOLLOW_28_in_definputcalcid2248); 

            match(input,60,FOLLOW_60_in_definputcalcid2254); 

            match(input,42,FOLLOW_42_in_definputcalcid2256); 

            inputcalc=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_definputcalcid2260); 

            match(input,65,FOLLOW_65_in_definputcalcid2266); 

            match(input,42,FOLLOW_42_in_definputcalcid2268); 

            name=(Token)match(input,ID,FOLLOW_ID_in_definputcalcid2272); 

             asm.addInputcalcid(inputcalc, name); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "definputcalcid"



    // $ANTLR start "definputsize"
    // Tci.g:183:1: definputsize : '.inputs' 'size' '=' NUMBER_INT ;
    public final void definputsize() throws RecognitionException {
        Token NUMBER_INT6=null;

        try {
            // Tci.g:183:13: ( '.inputs' 'size' '=' NUMBER_INT )
            // Tci.g:184:5: '.inputs' 'size' '=' NUMBER_INT
            {
            match(input,30,FOLLOW_30_in_definputsize2349); 

            match(input,76,FOLLOW_76_in_definputsize2355); 

            match(input,42,FOLLOW_42_in_definputsize2357); 

            NUMBER_INT6=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_definputsize2359); 

             asm.setInputsize(NUMBER_INT6); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "definputsize"



    // $ANTLR start "definput"
    // Tci.g:189:1: definput : '.input' 'input' '=' inputid= NUMBER_INT 'name' '=' name= ID 'autocounters' '=' autocounters= NUMBER_INT 'choiceable' '=' choiceable= ( 'true' | 'false' ) ;
    public final void definput() throws RecognitionException {
        Token inputid=null;
        Token name=null;
        Token autocounters=null;
        Token choiceable=null;

        try {
            // Tci.g:189:9: ( '.input' 'input' '=' inputid= NUMBER_INT 'name' '=' name= ID 'autocounters' '=' autocounters= NUMBER_INT 'choiceable' '=' choiceable= ( 'true' | 'false' ) )
            // Tci.g:190:5: '.input' 'input' '=' inputid= NUMBER_INT 'name' '=' name= ID 'autocounters' '=' autocounters= NUMBER_INT 'choiceable' '=' choiceable= ( 'true' | 'false' )
            {
            match(input,25,FOLLOW_25_in_definput2395); 

            match(input,64,FOLLOW_64_in_definput2401); 

            match(input,42,FOLLOW_42_in_definput2403); 

            inputid=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_definput2407); 

            match(input,65,FOLLOW_65_in_definput2413); 

            match(input,42,FOLLOW_42_in_definput2415); 

            name=(Token)match(input,ID,FOLLOW_ID_in_definput2419); 

            match(input,44,FOLLOW_44_in_definput2425); 

            match(input,42,FOLLOW_42_in_definput2427); 

            autocounters=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_definput2431); 

            match(input,48,FOLLOW_48_in_definput2437); 

            match(input,42,FOLLOW_42_in_definput2439); 

            choiceable=(Token)input.LT(1);

            if ( input.LA(1)==56||input.LA(1)==81 ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


             asm.addInput(inputid, name, autocounters, choiceable); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "definput"



    // $ANTLR start "definputautocounter"
    // Tci.g:198:1: definputautocounter : '.inputautocounter' 'input' '=' inputid= NUMBER_INT 'ind' '=' ind= NUMBER_INT 'counter' '=' counterid= NUMBER_INT ;
    public final void definputautocounter() throws RecognitionException {
        Token inputid=null;
        Token ind=null;
        Token counterid=null;

        try {
            // Tci.g:198:20: ( '.inputautocounter' 'input' '=' inputid= NUMBER_INT 'ind' '=' ind= NUMBER_INT 'counter' '=' counterid= NUMBER_INT )
            // Tci.g:199:5: '.inputautocounter' 'input' '=' inputid= NUMBER_INT 'ind' '=' ind= NUMBER_INT 'counter' '=' counterid= NUMBER_INT
            {
            match(input,26,FOLLOW_26_in_definputautocounter2484); 

            match(input,64,FOLLOW_64_in_definputautocounter2490); 

            match(input,42,FOLLOW_42_in_definputautocounter2492); 

            inputid=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_definputautocounter2496); 

            match(input,63,FOLLOW_63_in_definputautocounter2502); 

            match(input,42,FOLLOW_42_in_definputautocounter2504); 

            ind=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_definputautocounter2508); 

            match(input,53,FOLLOW_53_in_definputautocounter2514); 

            match(input,42,FOLLOW_42_in_definputautocounter2516); 

            counterid=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_definputautocounter2520); 

             asm.addInputAutocounter(inputid, ind, counterid); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "definputautocounter"



    // $ANTLR start "definputcalc"
    // Tci.g:206:1: definputcalc : '.inputcalc' 'input' '=' inputid= NUMBER_INT 'icalc' '=' inputcalc= NUMBER_INT 'formula' '=' formula= NUMBER_INT ;
    public final void definputcalc() throws RecognitionException {
        Token inputid=null;
        Token inputcalc=null;
        Token formula=null;

        try {
            // Tci.g:206:13: ( '.inputcalc' 'input' '=' inputid= NUMBER_INT 'icalc' '=' inputcalc= NUMBER_INT 'formula' '=' formula= NUMBER_INT )
            // Tci.g:207:5: '.inputcalc' 'input' '=' inputid= NUMBER_INT 'icalc' '=' inputcalc= NUMBER_INT 'formula' '=' formula= NUMBER_INT
            {
            match(input,27,FOLLOW_27_in_definputcalc2555); 

            match(input,64,FOLLOW_64_in_definputcalc2561); 

            match(input,42,FOLLOW_42_in_definputcalc2563); 

            inputid=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_definputcalc2567); 

            match(input,60,FOLLOW_60_in_definputcalc2573); 

            match(input,42,FOLLOW_42_in_definputcalc2575); 

            inputcalc=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_definputcalc2579); 

            match(input,57,FOLLOW_57_in_definputcalc2585); 

            match(input,42,FOLLOW_42_in_definputcalc2587); 

            formula=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_definputcalc2591); 

             asm.addInputcalc(inputid, inputcalc, formula); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "definputcalc"



    // $ANTLR start "defformulasize"
    // Tci.g:214:1: defformulasize : '.formulas' 'size' '=' NUMBER_INT ;
    public final void defformulasize() throws RecognitionException {
        Token NUMBER_INT7=null;

        try {
            // Tci.g:214:15: ( '.formulas' 'size' '=' NUMBER_INT )
            // Tci.g:215:5: '.formulas' 'size' '=' NUMBER_INT
            {
            match(input,22,FOLLOW_22_in_defformulasize2626); 

            match(input,76,FOLLOW_76_in_defformulasize2632); 

            match(input,42,FOLLOW_42_in_defformulasize2634); 

            NUMBER_INT7=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_defformulasize2636); 

             asm.setFormulasize(NUMBER_INT7); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "defformulasize"



    // $ANTLR start "defformula"
    // Tci.g:220:1: defformula : '.formula' 'formula' '=' formula= NUMBER_INT 'simple' '=' simple= ( 'true' | 'false' ) formulacode '.formuladone' ;
    public final void defformula() throws RecognitionException {
        Token formula=null;
        Token simple=null;

        try {
            // Tci.g:220:11: ( '.formula' 'formula' '=' formula= NUMBER_INT 'simple' '=' simple= ( 'true' | 'false' ) formulacode '.formuladone' )
            // Tci.g:221:5: '.formula' 'formula' '=' formula= NUMBER_INT 'simple' '=' simple= ( 'true' | 'false' ) formulacode '.formuladone'
            {
            match(input,20,FOLLOW_20_in_defformula2675); 

            match(input,57,FOLLOW_57_in_defformula2681); 

            match(input,42,FOLLOW_42_in_defformula2683); 

            formula=(Token)match(input,NUMBER_INT,FOLLOW_NUMBER_INT_in_defformula2687); 

            match(input,75,FOLLOW_75_in_defformula2711); 

            match(input,42,FOLLOW_42_in_defformula2713); 

            simple=(Token)input.LT(1);

            if ( input.LA(1)==56||input.LA(1)==81 ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


             asm.defineFormula(formula, simple); 

            pushFollow(FOLLOW_formulacode_in_defformula2742);
            formulacode();

            state._fsp--;


            match(input,21,FOLLOW_21_in_defformula2787); 

             asm.finishFormula(formula); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "defformula"



    // $ANTLR start "formulacode"
    // Tci.g:228:1: formulacode : ( formulaline )+ ;
    public final void formulacode() throws RecognitionException {
        try {
            // Tci.g:228:12: ( ( formulaline )+ )
            // Tci.g:229:5: ( formulaline )+
            {
            // Tci.g:229:5: ( formulaline )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==LABEL||LA10_0==41) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // Tci.g:229:5: formulaline
            	    {
            	    pushFollow(FOLLOW_formulaline_in_formulacode2855);
            	    formulaline();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "formulacode"



    // $ANTLR start "formulaline"
    // Tci.g:232:1: formulaline : ( ':' op | LABEL ( op )? );
    public final void formulaline() throws RecognitionException {
        Token LABEL8=null;

        try {
            // Tci.g:232:12: ( ':' op | LABEL ( op )? )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==41) ) {
                alt12=1;
            }
            else if ( (LA12_0==LABEL) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;

            }
            switch (alt12) {
                case 1 :
                    // Tci.g:233:5: ':' op
                    {
                    match(input,41,FOLLOW_41_in_formulaline2877); 

                    pushFollow(FOLLOW_op_in_formulaline2879);
                    op();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // Tci.g:234:5: LABEL ( op )?
                    {
                    LABEL8=(Token)match(input,LABEL,FOLLOW_LABEL_in_formulaline2885); 

                     asm.defineLabel(LABEL8); 

                    // Tci.g:234:42: ( op )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==ID) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // Tci.g:234:42: op
                            {
                            pushFollow(FOLLOW_op_in_formulaline2891);
                            op();

                            state._fsp--;


                            }
                            break;

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "formulaline"



    // $ANTLR start "op"
    // Tci.g:237:1: op : ( ID | ID o1= operand | ID o1= operand o2= operand | ID o1= operand o2= operand o3= operand | ID o1= operand o2= operand o3= operand o4= operand );
    public final void op() throws RecognitionException {
        Token ID9=null;
        Token ID10=null;
        Token ID11=null;
        Token ID12=null;
        Token ID13=null;
        TciParser.operand_return o1 =null;

        TciParser.operand_return o2 =null;

        TciParser.operand_return o3 =null;

        TciParser.operand_return o4 =null;


        try {
            // Tci.g:237:3: ( ID | ID o1= operand | ID o1= operand o2= operand | ID o1= operand o2= operand o3= operand | ID o1= operand o2= operand o3= operand o4= operand )
            int alt13=5;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==ID) ) {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==LABEL||LA13_1==21||LA13_1==41) ) {
                    alt13=1;
                }
                else if ( (LA13_1==ID||(LA13_1 >= NUMBER_DEC && LA13_1 <= STRING)) ) {
                    int LA13_3 = input.LA(3);

                    if ( (LA13_3==LABEL||LA13_3==21||LA13_3==41) ) {
                        alt13=2;
                    }
                    else if ( (LA13_3==ID||(LA13_3 >= NUMBER_DEC && LA13_3 <= STRING)) ) {
                        int LA13_5 = input.LA(4);

                        if ( (LA13_5==LABEL||LA13_5==21||LA13_5==41) ) {
                            alt13=3;
                        }
                        else if ( (LA13_5==ID||(LA13_5 >= NUMBER_DEC && LA13_5 <= STRING)) ) {
                            int LA13_7 = input.LA(5);

                            if ( (LA13_7==LABEL||LA13_7==21||LA13_7==41) ) {
                                alt13=4;
                            }
                            else if ( (LA13_7==ID||(LA13_7 >= NUMBER_DEC && LA13_7 <= STRING)) ) {
                                alt13=5;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 13, 7, input);

                                throw nvae;

                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 13, 5, input);

                            throw nvae;

                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 13, 3, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;

            }
            switch (alt13) {
                case 1 :
                    // Tci.g:237:5: ID
                    {
                    ID9=(Token)match(input,ID,FOLLOW_ID_in_op2902); 

                     asm.gen(ID9); 

                    }
                    break;
                case 2 :
                    // Tci.g:238:5: ID o1= operand
                    {
                    ID10=(Token)match(input,ID,FOLLOW_ID_in_op2957); 

                    pushFollow(FOLLOW_operand_in_op2961);
                    o1=operand();

                    state._fsp--;


                     asm.gen(ID10, (o1!=null?((Token)o1.start):null)); 

                    }
                    break;
                case 3 :
                    // Tci.g:239:5: ID o1= operand o2= operand
                    {
                    ID11=(Token)match(input,ID,FOLLOW_ID_in_op3005); 

                    pushFollow(FOLLOW_operand_in_op3009);
                    o1=operand();

                    state._fsp--;


                    pushFollow(FOLLOW_operand_in_op3013);
                    o2=operand();

                    state._fsp--;


                     asm.gen(ID11, (o1!=null?((Token)o1.start):null), (o2!=null?((Token)o2.start):null)); 

                    }
                    break;
                case 4 :
                    // Tci.g:240:5: ID o1= operand o2= operand o3= operand
                    {
                    ID12=(Token)match(input,ID,FOLLOW_ID_in_op3046); 

                    pushFollow(FOLLOW_operand_in_op3050);
                    o1=operand();

                    state._fsp--;


                    pushFollow(FOLLOW_operand_in_op3054);
                    o2=operand();

                    state._fsp--;


                    pushFollow(FOLLOW_operand_in_op3058);
                    o3=operand();

                    state._fsp--;


                     asm.gen(ID12, (o1!=null?((Token)o1.start):null), (o2!=null?((Token)o2.start):null), (o3!=null?((Token)o3.start):null)); 

                    }
                    break;
                case 5 :
                    // Tci.g:241:5: ID o1= operand o2= operand o3= operand o4= operand
                    {
                    ID13=(Token)match(input,ID,FOLLOW_ID_in_op3080); 

                    pushFollow(FOLLOW_operand_in_op3084);
                    o1=operand();

                    state._fsp--;


                    pushFollow(FOLLOW_operand_in_op3088);
                    o2=operand();

                    state._fsp--;


                    pushFollow(FOLLOW_operand_in_op3092);
                    o3=operand();

                    state._fsp--;


                    pushFollow(FOLLOW_operand_in_op3096);
                    o4=operand();

                    state._fsp--;


                     asm.gen(ID13, (o1!=null?((Token)o1.start):null), (o2!=null?((Token)o2.start):null), (o3!=null?((Token)o3.start):null), (o4!=null?((Token)o4.start):null)); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "op"


    public static class operand_return extends ParserRuleReturnScope {
    };


    // $ANTLR start "operand"
    // Tci.g:244:1: operand : ( ID | NUMBER_INT | NUMBER_DEC | STRING );
    public final TciParser.operand_return operand() throws RecognitionException {
        TciParser.operand_return retval = new TciParser.operand_return();
        retval.start = input.LT(1);


        try {
            // Tci.g:244:8: ( ID | NUMBER_INT | NUMBER_DEC | STRING )
            // Tci.g:
            {
            if ( input.LA(1)==ID||(input.LA(1) >= NUMBER_DEC && input.LA(1) <= STRING) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "operand"


    public static class value_return extends ParserRuleReturnScope {
    };


    // $ANTLR start "value"
    // Tci.g:251:1: value : ( ID | NUMBER_INT | STRING );
    public final TciParser.value_return value() throws RecognitionException {
        TciParser.value_return retval = new TciParser.value_return();
        retval.start = input.LT(1);


        try {
            // Tci.g:251:6: ( ID | NUMBER_INT | STRING )
            // Tci.g:
            {
            if ( input.LA(1)==ID||(input.LA(1) >= NUMBER_INT && input.LA(1) <= STRING) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "value"

    // Delegated rules


 

    public static final BitSet FOLLOW_onedef_in_tci46 = new BitSet(new long[]{0x000001FFFFDFC002L});
    public static final BitSet FOLLOW_defcalcsize_in_onedef97 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_defcalc_in_onedef101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_defnodesize_in_onedef108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_defnode_in_onedef112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_defnodeformulas_in_onedef119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_defnodecalc_in_onedef126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_defcalcdef_in_onedef130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_defcalctotal_in_onedef137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_defedgesize_in_onedef144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_defedge_in_onedef148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deftablesize_in_onedef155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deftable_in_onedef159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deftablecol_in_onedef163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deftablevalue_in_onedef167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deftablerow_in_onedef171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deffuncsize_in_onedef177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deffunc_in_onedef181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_definputcalcidsize_in_onedef187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_definputcalcid_in_onedef191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_definputsize_in_onedef197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_definput_in_onedef201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_definputautocounter_in_onedef205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_definputcalc_in_onedef209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_defformulasize_in_onedef215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_defformula_in_onedef219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_defcalcsize240 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_defcalcsize247 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_defcalcsize249 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_defcalcsize251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_defcalc301 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_defcalc308 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_defcalc310 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_defcalc315 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_defcalc321 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_defcalc323 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ID_in_defcalc328 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_defcalc335 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_defcalc337 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_defcalc341 = new BitSet(new long[]{0x0018000000000000L});
    public static final BitSet FOLLOW_51_in_defcalc373 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_defcalc380 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_defcalc384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_defcalc402 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_defcalc404 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_defcalc408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_defnodesize458 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_defnodesize464 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_defnodesize466 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_defnodesize468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_defnode532 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_defnode539 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_defnode541 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_defnode545 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_defnode579 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_defnode581 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ID_in_defnode587 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_defnode632 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_defnode634 = new BitSet(new long[]{0x0000000000001100L});
    public static final BitSet FOLLOW_set_in_defnode638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_defnodeformulas723 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_defnodeformulas729 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_defnodeformulas731 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_defnodeformulas735 = new BitSet(new long[]{0x4000000000000002L,0x0000000000004000L});
    public static final BitSet FOLLOW_62_in_defnodeformulas742 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_defnodeformulas744 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_defnodeformulas748 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_defnodeformulas757 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_defnodeformulas759 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_defnodeformulas763 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_defnodeformulas765 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_defnodeformulas767 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_defnodeformulas771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_defnodecalc844 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_defnodecalc851 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_defnodecalc853 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_defnodecalc857 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_defnodecalc863 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_defnodecalc865 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_defnodecalc869 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_defnodecalc875 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_defnodecalc877 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_defnodecalc881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_defcalcdef928 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_defcalcdef935 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_defcalcdef937 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_defcalcdef941 = new BitSet(new long[]{0x0000A00000000000L});
    public static final BitSet FOLLOW_45_in_defcalcdef950 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_defcalcdef952 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_defcalcdef956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_defcalcdef985 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_defcalcdef987 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_defcalcdef991 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_defcalcdef993 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_defcalcdef995 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_defcalcdef999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_defcalctotal1076 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_defcalctotal1082 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_defcalctotal1084 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_defcalctotal1088 = new BitSet(new long[]{0x0000A00000000000L});
    public static final BitSet FOLLOW_45_in_defcalctotal1110 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_defcalctotal1112 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_defcalctotal1116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_defcalctotal1145 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_defcalctotal1147 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_defcalctotal1151 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_defcalctotal1153 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_defcalctotal1155 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_defcalctotal1159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_defedgesize1267 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_58_in_defedgesize1281 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_defedgesize1283 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_defedgesize1287 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_defedgesize1293 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_defedgesize1295 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_defedgesize1299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_defedge1341 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_defedge1353 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_defedge1356 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_defedge1360 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_58_in_defedge1371 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_defedge1373 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_defedge1377 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_defedge1383 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_defedge1385 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_defedge1389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_deftablesize1433 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_deftablesize1452 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_deftablesize1454 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_deftablesize1456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_deftable1512 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_deftable1518 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_deftable1520 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_deftable1524 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_deftable1530 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_deftable1532 = new BitSet(new long[]{0x0000000000001900L});
    public static final BitSet FOLLOW_value_in_deftable1536 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_deftable1554 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_deftable1556 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_deftable1560 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_deftable1566 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_deftable1568 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_deftable1572 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_deftable1578 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_deftable1580 = new BitSet(new long[]{0x0100000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_set_in_deftable1584 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_deftable1597 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_deftable1599 = new BitSet(new long[]{0x0100000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_set_in_deftable1603 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_55_in_deftable1616 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_deftable1618 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_deftable1622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_deftablecol1662 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_deftablecol1668 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_deftablecol1670 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_deftablecol1674 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_deftablecol1680 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_deftablecol1682 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_deftablecol1686 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_deftablecol1692 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_deftablecol1694 = new BitSet(new long[]{0x0000000000001900L});
    public static final BitSet FOLLOW_value_in_deftablecol1698 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_deftablecol1704 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_deftablecol1706 = new BitSet(new long[]{0x0100000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_set_in_deftablecol1710 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_deftablecol1722 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_deftablecol1724 = new BitSet(new long[]{0x0100000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_set_in_deftablecol1728 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_deftablecol1740 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_deftablecol1742 = new BitSet(new long[]{0x0100000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_set_in_deftablecol1746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_deftablevalue1827 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_deftablevalue1833 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_deftablevalue1835 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_deftablevalue1839 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_deftablevalue1845 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_deftablevalue1847 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_deftablevalue1851 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_deftablevalue1857 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_deftablevalue1859 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_deftablevalue1863 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_deftablevalue1869 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_deftablevalue1871 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_deftablevalue1875 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_deftablevalue1881 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_deftablevalue1883 = new BitSet(new long[]{0x0000000000001900L});
    public static final BitSet FOLLOW_value_in_deftablevalue1887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_deftablerow1923 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_deftablerow1929 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_deftablerow1931 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_deftablerow1935 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_deftablerow1941 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_deftablerow1943 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_deftablerow1947 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_deftablerow1953 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_deftablerow1955 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_deftablerow1959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_deffuncsize2020 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_deffuncsize2026 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_deffuncsize2028 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_deffuncsize2030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_deffunc2110 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_59_in_deffunc2116 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_deffunc2118 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_deffunc2122 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_deffunc2128 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_deffunc2130 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ID_in_deffunc2134 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_deffunc2140 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_deffunc2142 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_deffunc2146 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_deffunc2155 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_deffunc2157 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_deffunc2161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_definputcalcidsize2197 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_definputcalcidsize2204 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_definputcalcidsize2206 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_definputcalcidsize2208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_definputcalcid2248 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_60_in_definputcalcid2254 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_definputcalcid2256 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_definputcalcid2260 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_definputcalcid2266 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_definputcalcid2268 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ID_in_definputcalcid2272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_definputsize2349 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_definputsize2355 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_definputsize2357 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_definputsize2359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_definput2395 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_definput2401 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_definput2403 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_definput2407 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_definput2413 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_definput2415 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ID_in_definput2419 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_definput2425 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_definput2427 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_definput2431 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_definput2437 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_definput2439 = new BitSet(new long[]{0x0100000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_set_in_definput2443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_definputautocounter2484 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_definputautocounter2490 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_definputautocounter2492 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_definputautocounter2496 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_definputautocounter2502 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_definputautocounter2504 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_definputautocounter2508 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_definputautocounter2514 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_definputautocounter2516 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_definputautocounter2520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_definputcalc2555 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_definputcalc2561 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_definputcalc2563 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_definputcalc2567 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_60_in_definputcalc2573 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_definputcalc2575 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_definputcalc2579 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_definputcalc2585 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_definputcalc2587 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_definputcalc2591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_defformulasize2626 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_defformulasize2632 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_defformulasize2634 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_defformulasize2636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_defformula2675 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_defformula2681 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_defformula2683 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_INT_in_defformula2687 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_defformula2711 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_defformula2713 = new BitSet(new long[]{0x0100000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_set_in_defformula2718 = new BitSet(new long[]{0x0000020000000200L});
    public static final BitSet FOLLOW_formulacode_in_defformula2742 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_defformula2787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_formulaline_in_formulacode2855 = new BitSet(new long[]{0x0000020000000202L});
    public static final BitSet FOLLOW_41_in_formulaline2877 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_op_in_formulaline2879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LABEL_in_formulaline2885 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_op_in_formulaline2891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_op2902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_op2957 = new BitSet(new long[]{0x0000000000001D00L});
    public static final BitSet FOLLOW_operand_in_op2961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_op3005 = new BitSet(new long[]{0x0000000000001D00L});
    public static final BitSet FOLLOW_operand_in_op3009 = new BitSet(new long[]{0x0000000000001D00L});
    public static final BitSet FOLLOW_operand_in_op3013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_op3046 = new BitSet(new long[]{0x0000000000001D00L});
    public static final BitSet FOLLOW_operand_in_op3050 = new BitSet(new long[]{0x0000000000001D00L});
    public static final BitSet FOLLOW_operand_in_op3054 = new BitSet(new long[]{0x0000000000001D00L});
    public static final BitSet FOLLOW_operand_in_op3058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_op3080 = new BitSet(new long[]{0x0000000000001D00L});
    public static final BitSet FOLLOW_operand_in_op3084 = new BitSet(new long[]{0x0000000000001D00L});
    public static final BitSet FOLLOW_operand_in_op3088 = new BitSet(new long[]{0x0000000000001D00L});
    public static final BitSet FOLLOW_operand_in_op3092 = new BitSet(new long[]{0x0000000000001D00L});
    public static final BitSet FOLLOW_operand_in_op3096 = new BitSet(new long[]{0x0000000000000002L});

}