// $ANTLR 3.4 Tci.g 2012-05-02 17:46:58
package treecalc.vm.asm; 

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class TciLexer extends Lexer {
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
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public TciLexer() {} 
    public TciLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public TciLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "Tci.g"; }

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:4:7: ( '.calc' )
            // Tci.g:4:9: '.calc'
            {
            match(".calc"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:5:7: ( '.calcdef' )
            // Tci.g:5:9: '.calcdef'
            {
            match(".calcdef"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:6:7: ( '.calcs' )
            // Tci.g:6:9: '.calcs'
            {
            match(".calcs"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:7:7: ( '.calctotal' )
            // Tci.g:7:9: '.calctotal'
            {
            match(".calctotal"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:8:7: ( '.edge' )
            // Tci.g:8:9: '.edge'
            {
            match(".edge"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:9:7: ( '.edges' )
            // Tci.g:9:9: '.edges'
            {
            match(".edges"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:10:7: ( '.formula' )
            // Tci.g:10:9: '.formula'
            {
            match(".formula"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:11:7: ( '.formuladone' )
            // Tci.g:11:9: '.formuladone'
            {
            match(".formuladone"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:12:7: ( '.formulas' )
            // Tci.g:12:9: '.formulas'
            {
            match(".formulas"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:13:7: ( '.func' )
            // Tci.g:13:9: '.func'
            {
            match(".func"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:14:7: ( '.funcs' )
            // Tci.g:14:9: '.funcs'
            {
            match(".funcs"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:15:7: ( '.input' )
            // Tci.g:15:9: '.input'
            {
            match(".input"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:16:7: ( '.inputautocounter' )
            // Tci.g:16:9: '.inputautocounter'
            {
            match(".inputautocounter"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:17:7: ( '.inputcalc' )
            // Tci.g:17:9: '.inputcalc'
            {
            match(".inputcalc"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:18:7: ( '.inputcalcid' )
            // Tci.g:18:9: '.inputcalcid'
            {
            match(".inputcalcid"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:19:7: ( '.inputcalcids' )
            // Tci.g:19:9: '.inputcalcids'
            {
            match(".inputcalcids"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:20:7: ( '.inputs' )
            // Tci.g:20:9: '.inputs'
            {
            match(".inputs"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:21:7: ( '.link' )
            // Tci.g:21:9: '.link'
            {
            match(".link"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:22:7: ( '.node' )
            // Tci.g:22:9: '.node'
            {
            match(".node"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:23:7: ( '.nodecalc' )
            // Tci.g:23:9: '.nodecalc'
            {
            match(".nodecalc"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:24:7: ( '.nodeformulas' )
            // Tci.g:24:9: '.nodeformulas'
            {
            match(".nodeformulas"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:25:7: ( '.nodes' )
            // Tci.g:25:9: '.nodes'
            {
            match(".nodes"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:26:7: ( '.table' )
            // Tci.g:26:9: '.table'
            {
            match(".table"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:27:7: ( '.tablecol' )
            // Tci.g:27:9: '.tablecol'
            {
            match(".tablecol"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:28:7: ( '.tablerow' )
            // Tci.g:28:9: '.tablerow'
            {
            match(".tablerow"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:29:7: ( '.tables' )
            // Tci.g:29:9: '.tables'
            {
            match(".tables"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:30:7: ( '.tablevalue' )
            // Tci.g:30:9: '.tablevalue'
            {
            match(".tablevalue"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:31:7: ( ':' )
            // Tci.g:31:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:32:7: ( '=' )
            // Tci.g:32:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:33:7: ( 'args' )
            // Tci.g:33:9: 'args'
            {
            match("args"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:34:7: ( 'autocounters' )
            // Tci.g:34:9: 'autocounters'
            {
            match("autocounters"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:35:7: ( 'calc' )
            // Tci.g:35:9: 'calc'
            {
            match("calc"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:36:7: ( 'calc_rangeend' )
            // Tci.g:36:9: 'calc_rangeend'
            {
            match("calc_rangeend"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:37:7: ( 'calc_rangestart' )
            // Tci.g:37:9: 'calc_rangestart'
            {
            match("calc_rangestart"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:38:7: ( 'choiceable' )
            // Tci.g:38:9: 'choiceable'
            {
            match("choiceable"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:39:7: ( 'col' )
            // Tci.g:39:9: 'col'
            {
            match("col"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:40:7: ( 'cols' )
            // Tci.g:40:9: 'cols'
            {
            match("cols"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:41:7: ( 'computenode' )
            // Tci.g:41:9: 'computenode'
            {
            match("computenode"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:42:7: ( 'computestartnode' )
            // Tci.g:42:9: 'computestartnode'
            {
            match("computestartnode"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:43:7: ( 'counter' )
            // Tci.g:43:9: 'counter'
            {
            match("counter"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:44:7: ( 'directaccess' )
            // Tci.g:44:9: 'directaccess'
            {
            match("directaccess"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:45:7: ( 'directaccessoffset' )
            // Tci.g:45:9: 'directaccessoffset'
            {
            match("directaccessoffset"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:46:7: ( 'false' )
            // Tci.g:46:9: 'false'
            {
            match("false"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:47:7: ( 'formula' )
            // Tci.g:47:9: 'formula'
            {
            match("formula"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:48:7: ( 'from' )
            // Tci.g:48:9: 'from'
            {
            match("from"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:49:7: ( 'func' )
            // Tci.g:49:9: 'func'
            {
            match("func"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:50:7: ( 'icalc' )
            // Tci.g:50:9: 'icalc'
            {
            match("icalc"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:51:7: ( 'id' )
            // Tci.g:51:9: 'id'
            {
            match("id"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:52:7: ( 'inclusion' )
            // Tci.g:52:9: 'inclusion'
            {
            match("inclusion"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:53:7: ( 'ind' )
            // Tci.g:53:9: 'ind'
            {
            match("ind"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:54:7: ( 'input' )
            // Tci.g:54:9: 'input'
            {
            match("input"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:55:7: ( 'name' )
            // Tci.g:55:9: 'name'
            {
            match("name"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:56:7: ( 'nargs' )
            // Tci.g:56:9: 'nargs'
            {
            match("nargs"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:57:7: ( 'node' )
            // Tci.g:57:9: 'node'
            {
            match("node"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:58:7: ( 'numeric' )
            // Tci.g:58:9: 'numeric'
            {
            match("numeric"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:59:7: ( 'numericsuper' )
            // Tci.g:59:9: 'numericsuper'
            {
            match("numericsuper"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:60:7: ( 'numericunique' )
            // Tci.g:60:9: 'numericunique'
            {
            match("numericunique"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:61:7: ( 'oo' )
            // Tci.g:61:9: 'oo'
            {
            match("oo"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__71"

    // $ANTLR start "T__72"
    public final void mT__72() throws RecognitionException {
        try {
            int _type = T__72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:62:7: ( 'row' )
            // Tci.g:62:9: 'row'
            {
            match("row"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__72"

    // $ANTLR start "T__73"
    public final void mT__73() throws RecognitionException {
        try {
            int _type = T__73;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:63:7: ( 'rows' )
            // Tci.g:63:9: 'rows'
            {
            match("rows"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__73"

    // $ANTLR start "T__74"
    public final void mT__74() throws RecognitionException {
        try {
            int _type = T__74;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:64:7: ( 'shuffled' )
            // Tci.g:64:9: 'shuffled'
            {
            match("shuffled"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__74"

    // $ANTLR start "T__75"
    public final void mT__75() throws RecognitionException {
        try {
            int _type = T__75;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:65:7: ( 'simple' )
            // Tci.g:65:9: 'simple'
            {
            match("simple"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__75"

    // $ANTLR start "T__76"
    public final void mT__76() throws RecognitionException {
        try {
            int _type = T__76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:66:7: ( 'size' )
            // Tci.g:66:9: 'size'
            {
            match("size"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__76"

    // $ANTLR start "T__77"
    public final void mT__77() throws RecognitionException {
        try {
            int _type = T__77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:67:7: ( 'table' )
            // Tci.g:67:9: 'table'
            {
            match("table"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__77"

    // $ANTLR start "T__78"
    public final void mT__78() throws RecognitionException {
        try {
            int _type = T__78;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:68:7: ( 'timesformula' )
            // Tci.g:68:9: 'timesformula'
            {
            match("timesformula"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__78"

    // $ANTLR start "T__79"
    public final void mT__79() throws RecognitionException {
        try {
            int _type = T__79;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:69:7: ( 'timesid' )
            // Tci.g:69:9: 'timesid'
            {
            match("timesid"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__79"

    // $ANTLR start "T__80"
    public final void mT__80() throws RecognitionException {
        try {
            int _type = T__80;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:70:7: ( 'to' )
            // Tci.g:70:9: 'to'
            {
            match("to"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__80"

    // $ANTLR start "T__81"
    public final void mT__81() throws RecognitionException {
        try {
            int _type = T__81;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:71:7: ( 'true' )
            // Tci.g:71:9: 'true'
            {
            match("true"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__81"

    // $ANTLR start "T__82"
    public final void mT__82() throws RecognitionException {
        try {
            int _type = T__82;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:72:7: ( 'value' )
            // Tci.g:72:9: 'value'
            {
            match("value"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__82"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:255:3: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '$' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // Tci.g:255:5: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '$' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            if ( input.LA(1)=='$'||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // Tci.g:255:32: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Tci.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "LABEL"
    public final void mLABEL() throws RecognitionException {
        try {
            int _type = LABEL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:257:6: ( ( ( '0' .. '9' ) | ID ) ':' )
            // Tci.g:257:8: ( ( '0' .. '9' ) | ID ) ':'
            {
            // Tci.g:257:8: ( ( '0' .. '9' ) | ID )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
                alt2=1;
            }
            else if ( (LA2_0=='$'||(LA2_0 >= 'A' && LA2_0 <= 'Z')||LA2_0=='_'||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // Tci.g:257:9: ( '0' .. '9' )
                    {
                    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 2 :
                    // Tci.g:257:22: ID
                    {
                    mID(); 


                    }
                    break;

            }


            match(':'); 

             setText(getText().substring(0, getText().length()-1)); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LABEL"

    // $ANTLR start "NUMBER_INT"
    public final void mNUMBER_INT() throws RecognitionException {
        try {
            int _type = NUMBER_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:260:11: ( ( '-' )? ( '0' .. '9' )+ )
            // Tci.g:260:13: ( '-' )? ( '0' .. '9' )+
            {
            // Tci.g:260:13: ( '-' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='-') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // Tci.g:260:13: '-'
                    {
                    match('-'); 

                    }
                    break;

            }


            // Tci.g:260:18: ( '0' .. '9' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // Tci.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NUMBER_INT"

    // $ANTLR start "NUMBER_DEC"
    public final void mNUMBER_DEC() throws RecognitionException {
        try {
            int _type = NUMBER_DEC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:263:11: ( ( '-' )? ( '0' .. '9' )+ '.' ( '0' .. '9' )+ )
            // Tci.g:263:13: ( '-' )? ( '0' .. '9' )+ '.' ( '0' .. '9' )+
            {
            // Tci.g:263:13: ( '-' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='-') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // Tci.g:263:13: '-'
                    {
                    match('-'); 

                    }
                    break;

            }


            // Tci.g:263:18: ( '0' .. '9' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0 >= '0' && LA6_0 <= '9')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // Tci.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            match('.'); 

            // Tci.g:263:32: ( '0' .. '9' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0 >= '0' && LA7_0 <= '9')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // Tci.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NUMBER_DEC"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:266:7: ( '\"' ( EscapeSequence |~ ( '\\\\' | '\"' | '\\r' | '\\n' ) )* '\"' | '\\'' (~ ( '\\'' | '\\r' | '\\n' ) )* '\\'' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\"') ) {
                alt10=1;
            }
            else if ( (LA10_0=='\'') ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;

            }
            switch (alt10) {
                case 1 :
                    // Tci.g:266:10: '\"' ( EscapeSequence |~ ( '\\\\' | '\"' | '\\r' | '\\n' ) )* '\"'
                    {
                    match('\"'); 

                    // Tci.g:266:14: ( EscapeSequence |~ ( '\\\\' | '\"' | '\\r' | '\\n' ) )*
                    loop8:
                    do {
                        int alt8=3;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0=='\\') ) {
                            alt8=1;
                        }
                        else if ( ((LA8_0 >= '\u0000' && LA8_0 <= '\t')||(LA8_0 >= '\u000B' && LA8_0 <= '\f')||(LA8_0 >= '\u000E' && LA8_0 <= '!')||(LA8_0 >= '#' && LA8_0 <= '[')||(LA8_0 >= ']' && LA8_0 <= '\uFFFF')) ) {
                            alt8=2;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // Tci.g:266:16: EscapeSequence
                    	    {
                    	    mEscapeSequence(); 


                    	    }
                    	    break;
                    	case 2 :
                    	    // Tci.g:266:33: ~ ( '\\\\' | '\"' | '\\r' | '\\n' )
                    	    {
                    	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    match('\"'); 

                     setText(getText().substring(1, getText().length()-1)); 

                    }
                    break;
                case 2 :
                    // Tci.g:267:10: '\\'' (~ ( '\\'' | '\\r' | '\\n' ) )* '\\''
                    {
                    match('\''); 

                    // Tci.g:267:15: (~ ( '\\'' | '\\r' | '\\n' ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( ((LA9_0 >= '\u0000' && LA9_0 <= '\t')||(LA9_0 >= '\u000B' && LA9_0 <= '\f')||(LA9_0 >= '\u000E' && LA9_0 <= '&')||(LA9_0 >= '(' && LA9_0 <= '\uFFFF')) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // Tci.g:
                    	    {
                    	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '\uFFFF') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


                    match('\''); 

                     setText(getText().substring(1, getText().length()-1)); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "EscapeSequence"
    public final void mEscapeSequence() throws RecognitionException {
        try {
            // Tci.g:270:24: ( '\\\\' (| 't' | 'r' | 'n' | '\\\"' ) )
            // Tci.g:270:26: '\\\\' (| 't' | 'r' | 'n' | '\\\"' )
            {
            match('\\'); 

            // Tci.g:270:31: (| 't' | 'r' | 'n' | '\\\"' )
            int alt11=5;
            switch ( input.LA(1) ) {
            case 't':
                {
                alt11=2;
                }
                break;
            case 'r':
                {
                alt11=3;
                }
                break;
            case 'n':
                {
                alt11=4;
                }
                break;
            case '\"':
                {
                alt11=5;
                }
                break;
            default:
                alt11=1;
            }

            switch (alt11) {
                case 1 :
                    // Tci.g:271:14: 
                    {
                    }
                    break;
                case 2 :
                    // Tci.g:271:18: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 3 :
                    // Tci.g:272:18: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 4 :
                    // Tci.g:273:18: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 5 :
                    // Tci.g:274:18: '\\\"'
                    {
                    match('\"'); 

                    }
                    break;

            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EscapeSequence"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:277:16: ( COMMENTML | COMMENTLINE )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='/') ) {
                int LA12_1 = input.LA(2);

                if ( (LA12_1=='*') ) {
                    alt12=1;
                }
                else if ( (LA12_1=='/') ) {
                    alt12=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA12_0=='#'||LA12_0==';') ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;

            }
            switch (alt12) {
                case 1 :
                    // Tci.g:277:18: COMMENTML
                    {
                    mCOMMENTML(); 


                    }
                    break;
                case 2 :
                    // Tci.g:277:30: COMMENTLINE
                    {
                    mCOMMENTLINE(); 


                     _channel = HIDDEN; 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "COMMENTML"
    public final void mCOMMENTML() throws RecognitionException {
        try {
            // Tci.g:279:25: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // Tci.g:279:27: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 



            // Tci.g:279:32: ( options {greedy=false; } : . )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0=='*') ) {
                    int LA13_1 = input.LA(2);

                    if ( (LA13_1=='/') ) {
                        alt13=2;
                    }
                    else if ( ((LA13_1 >= '\u0000' && LA13_1 <= '.')||(LA13_1 >= '0' && LA13_1 <= '\uFFFF')) ) {
                        alt13=1;
                    }


                }
                else if ( ((LA13_0 >= '\u0000' && LA13_0 <= ')')||(LA13_0 >= '+' && LA13_0 <= '\uFFFF')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // Tci.g:279:58: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            match("*/"); 



            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENTML"

    // $ANTLR start "COMMENTLINE"
    public final void mCOMMENTLINE() throws RecognitionException {
        try {
            // Tci.g:280:25: ( ( '//' | '#' | ';' ) (~ ( '\\r' | '\\n' ) )* ( '\\r' )? ( '\\n' )? )
            // Tci.g:280:27: ( '//' | '#' | ';' ) (~ ( '\\r' | '\\n' ) )* ( '\\r' )? ( '\\n' )?
            {
            // Tci.g:280:27: ( '//' | '#' | ';' )
            int alt14=3;
            switch ( input.LA(1) ) {
            case '/':
                {
                alt14=1;
                }
                break;
            case '#':
                {
                alt14=2;
                }
                break;
            case ';':
                {
                alt14=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;

            }

            switch (alt14) {
                case 1 :
                    // Tci.g:280:28: '//'
                    {
                    match("//"); 



                    }
                    break;
                case 2 :
                    // Tci.g:280:33: '#'
                    {
                    match('#'); 

                    }
                    break;
                case 3 :
                    // Tci.g:280:37: ';'
                    {
                    match(';'); 

                    }
                    break;

            }


            // Tci.g:280:42: (~ ( '\\r' | '\\n' ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0 >= '\u0000' && LA15_0 <= '\t')||(LA15_0 >= '\u000B' && LA15_0 <= '\f')||(LA15_0 >= '\u000E' && LA15_0 <= '\uFFFF')) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // Tci.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            // Tci.g:280:62: ( '\\r' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0=='\r') ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // Tci.g:280:62: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }


            // Tci.g:280:68: ( '\\n' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='\n') ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // Tci.g:280:68: '\\n'
                    {
                    match('\n'); 

                    }
                    break;

            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENTLINE"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Tci.g:282:16: ( ( '\\r' | '\\n' | ' ' | '\\f' | '\\t' )+ )
            // Tci.g:282:18: ( '\\r' | '\\n' | ' ' | '\\f' | '\\t' )+
            {
            // Tci.g:282:18: ( '\\r' | '\\n' | ' ' | '\\f' | '\\t' )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0 >= '\t' && LA18_0 <= '\n')||(LA18_0 >= '\f' && LA18_0 <= '\r')||LA18_0==' ') ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // Tci.g:
            	    {
            	    if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt18 >= 1 ) break loop18;
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
            } while (true);


             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WHITESPACE"

    public void mTokens() throws RecognitionException {
        // Tci.g:1:8: ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | ID | LABEL | NUMBER_INT | NUMBER_DEC | STRING | COMMENT | WHITESPACE )
        int alt19=76;
        alt19 = dfa19.predict(input);
        switch (alt19) {
            case 1 :
                // Tci.g:1:10: T__14
                {
                mT__14(); 


                }
                break;
            case 2 :
                // Tci.g:1:16: T__15
                {
                mT__15(); 


                }
                break;
            case 3 :
                // Tci.g:1:22: T__16
                {
                mT__16(); 


                }
                break;
            case 4 :
                // Tci.g:1:28: T__17
                {
                mT__17(); 


                }
                break;
            case 5 :
                // Tci.g:1:34: T__18
                {
                mT__18(); 


                }
                break;
            case 6 :
                // Tci.g:1:40: T__19
                {
                mT__19(); 


                }
                break;
            case 7 :
                // Tci.g:1:46: T__20
                {
                mT__20(); 


                }
                break;
            case 8 :
                // Tci.g:1:52: T__21
                {
                mT__21(); 


                }
                break;
            case 9 :
                // Tci.g:1:58: T__22
                {
                mT__22(); 


                }
                break;
            case 10 :
                // Tci.g:1:64: T__23
                {
                mT__23(); 


                }
                break;
            case 11 :
                // Tci.g:1:70: T__24
                {
                mT__24(); 


                }
                break;
            case 12 :
                // Tci.g:1:76: T__25
                {
                mT__25(); 


                }
                break;
            case 13 :
                // Tci.g:1:82: T__26
                {
                mT__26(); 


                }
                break;
            case 14 :
                // Tci.g:1:88: T__27
                {
                mT__27(); 


                }
                break;
            case 15 :
                // Tci.g:1:94: T__28
                {
                mT__28(); 


                }
                break;
            case 16 :
                // Tci.g:1:100: T__29
                {
                mT__29(); 


                }
                break;
            case 17 :
                // Tci.g:1:106: T__30
                {
                mT__30(); 


                }
                break;
            case 18 :
                // Tci.g:1:112: T__31
                {
                mT__31(); 


                }
                break;
            case 19 :
                // Tci.g:1:118: T__32
                {
                mT__32(); 


                }
                break;
            case 20 :
                // Tci.g:1:124: T__33
                {
                mT__33(); 


                }
                break;
            case 21 :
                // Tci.g:1:130: T__34
                {
                mT__34(); 


                }
                break;
            case 22 :
                // Tci.g:1:136: T__35
                {
                mT__35(); 


                }
                break;
            case 23 :
                // Tci.g:1:142: T__36
                {
                mT__36(); 


                }
                break;
            case 24 :
                // Tci.g:1:148: T__37
                {
                mT__37(); 


                }
                break;
            case 25 :
                // Tci.g:1:154: T__38
                {
                mT__38(); 


                }
                break;
            case 26 :
                // Tci.g:1:160: T__39
                {
                mT__39(); 


                }
                break;
            case 27 :
                // Tci.g:1:166: T__40
                {
                mT__40(); 


                }
                break;
            case 28 :
                // Tci.g:1:172: T__41
                {
                mT__41(); 


                }
                break;
            case 29 :
                // Tci.g:1:178: T__42
                {
                mT__42(); 


                }
                break;
            case 30 :
                // Tci.g:1:184: T__43
                {
                mT__43(); 


                }
                break;
            case 31 :
                // Tci.g:1:190: T__44
                {
                mT__44(); 


                }
                break;
            case 32 :
                // Tci.g:1:196: T__45
                {
                mT__45(); 


                }
                break;
            case 33 :
                // Tci.g:1:202: T__46
                {
                mT__46(); 


                }
                break;
            case 34 :
                // Tci.g:1:208: T__47
                {
                mT__47(); 


                }
                break;
            case 35 :
                // Tci.g:1:214: T__48
                {
                mT__48(); 


                }
                break;
            case 36 :
                // Tci.g:1:220: T__49
                {
                mT__49(); 


                }
                break;
            case 37 :
                // Tci.g:1:226: T__50
                {
                mT__50(); 


                }
                break;
            case 38 :
                // Tci.g:1:232: T__51
                {
                mT__51(); 


                }
                break;
            case 39 :
                // Tci.g:1:238: T__52
                {
                mT__52(); 


                }
                break;
            case 40 :
                // Tci.g:1:244: T__53
                {
                mT__53(); 


                }
                break;
            case 41 :
                // Tci.g:1:250: T__54
                {
                mT__54(); 


                }
                break;
            case 42 :
                // Tci.g:1:256: T__55
                {
                mT__55(); 


                }
                break;
            case 43 :
                // Tci.g:1:262: T__56
                {
                mT__56(); 


                }
                break;
            case 44 :
                // Tci.g:1:268: T__57
                {
                mT__57(); 


                }
                break;
            case 45 :
                // Tci.g:1:274: T__58
                {
                mT__58(); 


                }
                break;
            case 46 :
                // Tci.g:1:280: T__59
                {
                mT__59(); 


                }
                break;
            case 47 :
                // Tci.g:1:286: T__60
                {
                mT__60(); 


                }
                break;
            case 48 :
                // Tci.g:1:292: T__61
                {
                mT__61(); 


                }
                break;
            case 49 :
                // Tci.g:1:298: T__62
                {
                mT__62(); 


                }
                break;
            case 50 :
                // Tci.g:1:304: T__63
                {
                mT__63(); 


                }
                break;
            case 51 :
                // Tci.g:1:310: T__64
                {
                mT__64(); 


                }
                break;
            case 52 :
                // Tci.g:1:316: T__65
                {
                mT__65(); 


                }
                break;
            case 53 :
                // Tci.g:1:322: T__66
                {
                mT__66(); 


                }
                break;
            case 54 :
                // Tci.g:1:328: T__67
                {
                mT__67(); 


                }
                break;
            case 55 :
                // Tci.g:1:334: T__68
                {
                mT__68(); 


                }
                break;
            case 56 :
                // Tci.g:1:340: T__69
                {
                mT__69(); 


                }
                break;
            case 57 :
                // Tci.g:1:346: T__70
                {
                mT__70(); 


                }
                break;
            case 58 :
                // Tci.g:1:352: T__71
                {
                mT__71(); 


                }
                break;
            case 59 :
                // Tci.g:1:358: T__72
                {
                mT__72(); 


                }
                break;
            case 60 :
                // Tci.g:1:364: T__73
                {
                mT__73(); 


                }
                break;
            case 61 :
                // Tci.g:1:370: T__74
                {
                mT__74(); 


                }
                break;
            case 62 :
                // Tci.g:1:376: T__75
                {
                mT__75(); 


                }
                break;
            case 63 :
                // Tci.g:1:382: T__76
                {
                mT__76(); 


                }
                break;
            case 64 :
                // Tci.g:1:388: T__77
                {
                mT__77(); 


                }
                break;
            case 65 :
                // Tci.g:1:394: T__78
                {
                mT__78(); 


                }
                break;
            case 66 :
                // Tci.g:1:400: T__79
                {
                mT__79(); 


                }
                break;
            case 67 :
                // Tci.g:1:406: T__80
                {
                mT__80(); 


                }
                break;
            case 68 :
                // Tci.g:1:412: T__81
                {
                mT__81(); 


                }
                break;
            case 69 :
                // Tci.g:1:418: T__82
                {
                mT__82(); 


                }
                break;
            case 70 :
                // Tci.g:1:424: ID
                {
                mID(); 


                }
                break;
            case 71 :
                // Tci.g:1:427: LABEL
                {
                mLABEL(); 


                }
                break;
            case 72 :
                // Tci.g:1:433: NUMBER_INT
                {
                mNUMBER_INT(); 


                }
                break;
            case 73 :
                // Tci.g:1:444: NUMBER_DEC
                {
                mNUMBER_DEC(); 


                }
                break;
            case 74 :
                // Tci.g:1:455: STRING
                {
                mSTRING(); 


                }
                break;
            case 75 :
                // Tci.g:1:462: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 76 :
                // Tci.g:1:470: WHITESPACE
                {
                mWHITESPACE(); 


                }
                break;

        }

    }


    protected DFA19 dfa19 = new DFA19(this);
    static final String DFA19_eotS =
        "\4\uffff\14\37\1\70\13\uffff\3\37\2\uffff\11\37\1\117\4\37\1\127"+
        "\5\37\1\136\2\37\1\uffff\1\70\10\uffff\4\37\1\155\10\37\1\uffff"+
        "\1\37\1\167\5\37\1\uffff\1\176\5\37\1\uffff\2\37\7\uffff\1\u008d"+
        "\1\37\1\u0090\1\37\1\u0092\1\uffff\5\37\1\u0098\1\u0099\2\37\1\uffff"+
        "\1\37\1\u009d\1\37\1\u009f\1\37\1\u00a1\1\uffff\2\37\1\u00a4\2\37"+
        "\1\u00a7\1\37\1\u00ac\1\u00ae\1\uffff\1\u00b1\1\uffff\1\u00b6\2"+
        "\uffff\2\37\1\uffff\1\37\1\uffff\3\37\1\u00be\1\37\2\uffff\1\u00c0"+
        "\1\37\1\u00c2\1\uffff\1\u00c3\1\uffff\1\37\1\uffff\2\37\1\uffff"+
        "\1\u00c7\1\37\1\uffff\1\u00ca\11\uffff\1\u00cf\4\uffff\1\u00d4\6"+
        "\37\1\uffff\1\37\1\uffff\1\37\2\uffff\2\37\1\u00df\1\uffff\2\37"+
        "\13\uffff\4\37\1\u00e9\1\37\1\u00eb\1\37\1\u00ef\1\37\1\uffff\1"+
        "\37\1\u00f2\1\u00f5\1\uffff\5\37\1\uffff\1\37\1\uffff\3\37\1\uffff"+
        "\1\u0100\1\37\5\uffff\6\37\1\u0109\2\37\1\uffff\1\37\1\u010e\2\37"+
        "\1\u0112\3\37\1\uffff\3\37\2\uffff\3\37\1\uffff\1\u011d\5\37\1\u0124"+
        "\1\u0125\2\37\1\uffff\1\37\1\u012a\1\u012b\1\37\1\u012d\3\uffff"+
        "\1\u012e\3\37\2\uffff\1\u0132\2\uffff\3\37\1\uffff\1\u0136\2\37"+
        "\1\uffff\1\u0139\1\37\1\uffff\1\37\1\u013c\1\uffff";
    static final String DFA19_eofS =
        "\u013d\uffff";
    static final String DFA19_minS =
        "\1\11\1\143\2\uffff\14\60\1\56\1\60\3\uffff\1\141\1\144\1\157\1"+
        "\156\1\uffff\1\157\1\141\3\60\2\uffff\27\60\1\uffff\1\56\1\uffff"+
        "\1\154\1\147\1\162\1\156\1\160\1\144\1\142\15\60\1\uffff\7\60\1"+
        "\uffff\6\60\1\uffff\2\60\1\143\1\145\1\155\1\143\1\165\1\145\1\154"+
        "\5\60\1\uffff\11\60\1\uffff\6\60\1\uffff\7\60\1\144\1\163\1\165"+
        "\1\163\1\164\1\143\1\145\1\uffff\2\60\1\uffff\1\60\1\uffff\5\60"+
        "\2\uffff\3\60\1\uffff\1\60\1\uffff\1\60\1\uffff\2\60\1\uffff\2\60"+
        "\1\uffff\1\60\6\uffff\1\154\2\uffff\1\141\4\uffff\1\143\6\60\1\uffff"+
        "\1\60\1\uffff\1\60\2\uffff\3\60\1\uffff\2\60\1\uffff\1\141\1\uffff"+
        "\1\141\7\uffff\12\60\1\uffff\2\60\1\144\1\154\5\60\1\uffff\1\60"+
        "\1\uffff\3\60\1\uffff\2\60\4\uffff\1\143\11\60\1\uffff\1\60\1\151"+
        "\6\60\1\uffff\3\60\1\144\1\uffff\3\60\1\uffff\6\60\1\163\3\60\1"+
        "\uffff\5\60\3\uffff\4\60\2\uffff\1\60\2\uffff\3\60\1\uffff\3\60"+
        "\1\uffff\2\60\1\uffff\2\60\1\uffff";
    static final String DFA19_maxS =
        "\1\172\1\164\2\uffff\14\172\1\72\1\71\3\uffff\1\141\1\144\1\165"+
        "\1\156\1\uffff\1\157\1\141\3\172\2\uffff\27\172\1\uffff\1\71\1\uffff"+
        "\1\154\1\147\1\162\1\156\1\160\1\144\1\142\15\172\1\uffff\7\172"+
        "\1\uffff\6\172\1\uffff\2\172\1\143\1\145\1\155\1\143\1\165\1\145"+
        "\1\154\5\172\1\uffff\11\172\1\uffff\6\172\1\uffff\7\172\1\164\1"+
        "\163\1\165\1\163\1\164\1\163\1\145\1\uffff\2\172\1\uffff\1\172\1"+
        "\uffff\5\172\2\uffff\3\172\1\uffff\1\172\1\uffff\1\172\1\uffff\2"+
        "\172\1\uffff\2\172\1\uffff\1\172\6\uffff\1\154\2\uffff\1\163\4\uffff"+
        "\1\166\6\172\1\uffff\1\172\1\uffff\1\172\2\uffff\3\172\1\uffff\2"+
        "\172\1\uffff\1\141\1\uffff\1\141\7\uffff\12\172\1\uffff\2\172\1"+
        "\163\1\154\5\172\1\uffff\1\172\1\uffff\3\172\1\uffff\2\172\4\uffff"+
        "\1\143\11\172\1\uffff\1\172\1\151\6\172\1\uffff\3\172\1\144\1\uffff"+
        "\3\172\1\uffff\6\172\1\163\3\172\1\uffff\5\172\3\uffff\4\172\2\uffff"+
        "\1\172\2\uffff\3\172\1\uffff\3\172\1\uffff\2\172\1\uffff\2\172\1"+
        "\uffff";
    static final String DFA19_acceptS =
        "\2\uffff\1\34\1\35\16\uffff\1\112\1\113\1\114\4\uffff\1\22\5\uffff"+
        "\1\106\1\107\27\uffff\1\110\1\uffff\1\111\24\uffff\1\60\7\uffff"+
        "\1\72\6\uffff\1\103\16\uffff\1\44\11\uffff\1\62\6\uffff\1\73\16"+
        "\uffff\1\36\2\uffff\1\40\1\uffff\1\45\5\uffff\1\55\1\56\3\uffff"+
        "\1\64\1\uffff\1\66\1\uffff\1\74\2\uffff\1\77\2\uffff\1\104\1\uffff"+
        "\1\2\1\3\1\4\1\1\1\6\1\5\1\uffff\1\13\1\12\1\uffff\1\24\1\25\1\26"+
        "\1\23\7\uffff\1\53\1\uffff\1\57\1\uffff\1\63\1\65\3\uffff\1\100"+
        "\2\uffff\1\105\1\uffff\1\15\1\uffff\1\21\1\14\1\30\1\31\1\32\1\33"+
        "\1\27\12\uffff\1\76\11\uffff\1\50\1\uffff\1\54\3\uffff\1\67\2\uffff"+
        "\1\102\1\10\1\11\1\7\12\uffff\1\75\10\uffff\1\61\4\uffff\1\16\3"+
        "\uffff\1\43\12\uffff\1\46\5\uffff\1\20\1\17\1\37\4\uffff\1\51\1"+
        "\70\1\uffff\1\101\1\41\3\uffff\1\71\3\uffff\1\42\2\uffff\1\47\2"+
        "\uffff\1\52";
    static final String DFA19_specialS =
        "\u013d\uffff}>";
    static final String[] DFA19_transitionS = {
            "\2\24\1\uffff\2\24\22\uffff\1\24\1\uffff\1\22\1\23\1\17\2\uffff"+
            "\1\22\5\uffff\1\21\1\1\1\23\12\20\1\2\1\23\1\uffff\1\3\3\uffff"+
            "\32\17\4\uffff\1\17\1\uffff\1\4\1\17\1\5\1\6\1\17\1\7\2\17\1"+
            "\10\4\17\1\11\1\12\2\17\1\13\1\14\1\15\1\17\1\16\4\17",
            "\1\25\1\uffff\1\26\1\27\2\uffff\1\30\2\uffff\1\31\1\uffff\1"+
            "\32\5\uffff\1\33",
            "",
            "",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\21\36\1\34\2"+
            "\36\1\35\5\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\1\41\6\36\1"+
            "\42\6\36\1\43\13\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\10\36\1\44\21"+
            "\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\1\45\15\36\1"+
            "\46\2\36\1\47\2\36\1\50\5\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\2\36\1\51\1"+
            "\52\11\36\1\53\14\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\1\54\15\36\1"+
            "\55\5\36\1\56\5\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\16\36\1\57\13"+
            "\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\16\36\1\60\13"+
            "\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\7\36\1\61\1"+
            "\62\21\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\1\63\7\36\1"+
            "\64\5\36\1\65\2\36\1\66\10\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\1\67\31\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\72\1\uffff\12\71\1\40",
            "\12\71",
            "",
            "",
            "",
            "\1\73",
            "\1\74",
            "\1\75\5\uffff\1\76",
            "\1\77",
            "",
            "\1\100",
            "\1\101",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\6\36\1\102\23"+
            "\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\23\36\1\103"+
            "\6\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "",
            "",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\13\36\1\104"+
            "\16\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\16\36\1\105"+
            "\13\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\13\36\1\106"+
            "\1\107\7\36\1\110\5\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\21\36\1\111"+
            "\10\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\13\36\1\112"+
            "\16\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\21\36\1\113"+
            "\10\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\16\36\1\114"+
            "\13\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\15\36\1\115"+
            "\14\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\1\116\31\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\2\36\1\120\1"+
            "\121\13\36\1\122\12\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\14\36\1\123"+
            "\4\36\1\124\10\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\3\36\1\125\26"+
            "\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\14\36\1\126"+
            "\15\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\26\36\1\130"+
            "\3\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\24\36\1\131"+
            "\5\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\14\36\1\132"+
            "\14\36\1\133",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\1\36\1\134\30"+
            "\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\14\36\1\135"+
            "\15\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\24\36\1\137"+
            "\5\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\13\36\1\140"+
            "\16\36",
            "",
            "\1\72\1\uffff\12\71",
            "",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\144",
            "\1\145",
            "\1\146",
            "\1\147",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\22\36\1\150"+
            "\7\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\16\36\1\151"+
            "\13\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\2\36\1\152\27"+
            "\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\10\36\1\153"+
            "\21\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\22\36\1\154"+
            "\7\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\17\36\1\156"+
            "\12\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\15\36\1\157"+
            "\14\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\4\36\1\160\25"+
            "\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\22\36\1\161"+
            "\7\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\14\36\1\162"+
            "\15\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\14\36\1\163"+
            "\15\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\2\36\1\164\27"+
            "\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\13\36\1\165"+
            "\16\36",
            "",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\13\36\1\166"+
            "\16\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\24\36\1\170"+
            "\5\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\4\36\1\171\25"+
            "\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\6\36\1\172\23"+
            "\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\4\36\1\173\25"+
            "\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\4\36\1\174\25"+
            "\36",
            "",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\22\36\1\175"+
            "\7\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\5\36\1\177\24"+
            "\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\17\36\1\u0080"+
            "\12\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\4\36\1\u0081"+
            "\25\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\13\36\1\u0082"+
            "\16\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\4\36\1\u0083"+
            "\25\36",
            "",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\4\36\1\u0084"+
            "\25\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\24\36\1\u0085"+
            "\5\36",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\2\36\1\u008e"+
            "\27\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\u008f\1\uffff\32\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\2\36\1\u0091"+
            "\27\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\24\36\1\u0093"+
            "\5\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\23\36\1\u0094"+
            "\6\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\2\36\1\u0095"+
            "\27\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\4\36\1\u0096"+
            "\25\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\24\36\1\u0097"+
            "\5\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\2\36\1\u009a"+
            "\27\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\24\36\1\u009b"+
            "\5\36",
            "",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\23\36\1\u009c"+
            "\6\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\22\36\1\u009e"+
            "\7\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\21\36\1\u00a0"+
            "\10\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\5\36\1\u00a2"+
            "\24\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\13\36\1\u00a3"+
            "\16\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\4\36\1\u00a5"+
            "\25\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\22\36\1\u00a6"+
            "\7\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\4\36\1\u00a8"+
            "\25\36",
            "\1\u00a9\16\uffff\1\u00aa\1\u00ab",
            "\1\u00ad",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b2",
            "\1\u00b3\2\uffff\1\u00b4\14\uffff\1\u00b5",
            "\1\u00b7",
            "",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\16\36\1\u00b8"+
            "\13\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\21\36\1\u00b9"+
            "\10\36",
            "",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\4\36\1\u00ba"+
            "\25\36",
            "",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\23\36\1\u00bb"+
            "\6\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\4\36\1\u00bc"+
            "\25\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\23\36\1\u00bd"+
            "\6\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\13\36\1\u00bf"+
            "\16\36",
            "",
            "",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\22\36\1\u00c1"+
            "\7\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\10\36\1\u00c4"+
            "\21\36",
            "",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\13\36\1\u00c5"+
            "\16\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\4\36\1\u00c6"+
            "\25\36",
            "",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\5\36\1\u00c8"+
            "\2\36\1\u00c9\21\36",
            "",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00cb",
            "",
            "",
            "\1\u00cc\1\uffff\1\u00cd\17\uffff\1\u00ce",
            "",
            "",
            "",
            "",
            "\1\u00d0\16\uffff\1\u00d1\1\u00d2\2\uffff\1\u00d3",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\24\36\1\u00d5"+
            "\5\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\1\u00d6\31\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\1\u00d7\31\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\4\36\1\u00d8"+
            "\25\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\21\36\1\u00d9"+
            "\10\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\1\u00da\31\36",
            "",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\1\u00db\31\36",
            "",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\10\36\1\u00dc"+
            "\21\36",
            "",
            "",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\2\36\1\u00dd"+
            "\27\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\4\36\1\u00de"+
            "\25\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\16\36\1\u00e0"+
            "\13\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\3\36\1\u00e1"+
            "\26\36",
            "",
            "\1\u00e2",
            "",
            "\1\u00e3",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\15\36\1\u00e4"+
            "\14\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\15\36\1\u00e5"+
            "\14\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\1\36\1\u00e6"+
            "\30\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\15\36\1\u00e7"+
            "\4\36\1\u00e8\7\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\2\36\1\u00ea"+
            "\27\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\16\36\1\u00ec"+
            "\13\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\22\36\1\u00ed"+
            "\1\36\1\u00ee\5\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\3\36\1\u00f0"+
            "\26\36",
            "",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\21\36\1\u00f1"+
            "\10\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\u00f3\16\uffff\1\u00f4",
            "\1\u00f6",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\23\36\1\u00f7"+
            "\6\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\6\36\1\u00f8"+
            "\23\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\13\36\1\u00f9"+
            "\16\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\16\36\1\u00fa"+
            "\13\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\23\36\1\u00fb"+
            "\6\36",
            "",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\2\36\1\u00fc"+
            "\27\36",
            "",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\15\36\1\u00fd"+
            "\14\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\24\36\1\u00fe"+
            "\5\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\15\36\1\u00ff"+
            "\14\36",
            "",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\14\36\1\u0101"+
            "\15\36",
            "",
            "",
            "",
            "",
            "\1\u0102",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\4\36\1\u0103"+
            "\25\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\4\36\1\u0104"+
            "\25\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\4\36\1\u0105"+
            "\25\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\3\36\1\u0106"+
            "\26\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\1\u0107\31\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\4\36\1\u0108"+
            "\25\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\17\36\1\u010a"+
            "\12\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\10\36\1\u010b"+
            "\21\36",
            "",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\24\36\1\u010c"+
            "\5\36",
            "\1\u010d",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\21\36\1\u010f"+
            "\10\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\4\36\1\u0110"+
            "\15\36\1\u0111\7\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\4\36\1\u0113"+
            "\25\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\21\36\1\u0114"+
            "\10\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\22\36\1\u0115"+
            "\7\36",
            "",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\4\36\1\u0116"+
            "\25\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\20\36\1\u0117"+
            "\11\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\13\36\1\u0118"+
            "\16\36",
            "\1\u0119",
            "",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\22\36\1\u011a"+
            "\7\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\15\36\1\u011b"+
            "\14\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\23\36\1\u011c"+
            "\6\36",
            "",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\23\36\1\u011e"+
            "\6\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\22\36\1\u011f"+
            "\7\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\21\36\1\u0120"+
            "\10\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\24\36\1\u0121"+
            "\5\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\1\u0122\31\36",
            "\1\u0123",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\3\36\1\u0126"+
            "\26\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\1\u0127\31\36",
            "",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\15\36\1\u0128"+
            "\14\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\16\36\1\u0129"+
            "\13\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\4\36\1\u012c"+
            "\25\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "",
            "",
            "",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\21\36\1\u012f"+
            "\10\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\16\36\1\u0130"+
            "\13\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\5\36\1\u0131"+
            "\24\36",
            "",
            "",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "",
            "",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\23\36\1\u0133"+
            "\6\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\3\36\1\u0134"+
            "\26\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\5\36\1\u0135"+
            "\24\36",
            "",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\4\36\1\u0137"+
            "\25\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\22\36\1\u0138"+
            "\7\36",
            "",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\4\36\1\u013a"+
            "\25\36",
            "",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\23\36\1\u013b"+
            "\6\36",
            "\12\36\1\40\6\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            ""
    };

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | ID | LABEL | NUMBER_INT | NUMBER_DEC | STRING | COMMENT | WHITESPACE );";
        }
    }
 

}