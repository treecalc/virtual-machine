grammar Tci;


@parser::header       {package treecalc.vm.asm; }
@lexer::header        {package treecalc.vm.asm; }

@members {
    private TciAssembler asm;
    public TciParser(TokenStream input, TciAssembler asm) {
        this(input);
        this.asm = asm;
    }
}

tci: onedef+                     { asm.done(); }
    ;       
    
onedef: 
    defcalcsize | defcalc 
  | defnodesize | defnode 
  | defnodeformulas 
  | defnodecalc | defcalcdef 
  | defcalctotal 
  | defedgesize | defedge 
  | deftablesize | deftable | deftablecol | deftablevalue | deftablerow
  | deffuncsize | deffunc
  | definputcalcidsize | definputcalcid
  | definputsize | definput | definputautocounter | definputcalc
  | defformulasize | defformula
    ;    

defcalcsize: //.calcs size=225 
    '.calcs' 
    'size' '=' NUMBER_INT                            { asm.setCalcsize($NUMBER_INT); }
    ;
    
defcalc: //.calc calc=0 name=LICENSENAME nargs=0 compute=n3
    '.calc' 
    'calc' '='  calc=NUMBER_INT
    'name' '='  name=ID 
    'nargs' '=' nargs=NUMBER_INT                     { asm.addCalc($calc, $name, $nargs); }
    (   'computenode'      '=' node=NUMBER_INT       { asm.setCalcMainSingle($calc, $node); }
      | 'computestartnode' '=' node=NUMBER_INT       { asm.setCalcMainSum   ($calc, $node); }
    )
    ; 
                  
defnodesize: //.nodes size=24
    '.nodes'
    'size' '=' NUMBER_INT                            { asm.setNodesize($NUMBER_INT); }
    ;
                  
defnode: //.node node=3 id=root name="" ;URO_LI_ENDOW.product.root
    '.node' 
    'node' '=' node=NUMBER_INT                            
    'id' '='   id=ID                                      
    ('name' '=' name=(ID|STRING))?                   { asm.addNode($node, $id, $name); }
    ;    

defnodeformulas: 
                  //.nodeformulas node=8 inclusion=91
                  //.nodeformulas node=16 times=307
    '.nodeformulas'
    'node' '=' node=NUMBER_INT
    ('inclusion' '=' inclusion=NUMBER_INT)?
    ('timesformula' '=' times=NUMBER_INT 'timesid' '=' timesid=NUMBER_INT)?
                                                    { asm.addNodeFormula($node, $inclusion, $times, $timesid); }
    ;

defnodecalc: //.nodecalc node=3 calc=0 formula=1
    '.nodecalc' 
    'node' '=' node=NUMBER_INT
    'calc' '=' calc=NUMBER_INT
    'formula' '=' formula=NUMBER_INT                { asm.addNodeCalc($node, $calc, $formula); }
    ;

defcalcdef: //.calcdef node=3 calc_rangestart=0 calc_rangeend=1
            //.calcdef node=4 calc=2
    '.calcdef' 
    'node' '=' node=NUMBER_INT
    (  'calc' '=' calc=NUMBER_INT                   { asm.addNodeCalcdef($node, $calc); }
     | 'calc_rangestart' '=' calcfrom=NUMBER_INT 'calc_rangeend' '=' calcto=NUMBER_INT
                                                    { asm.addNodeCalcdef($node, $calcfrom, $calcto); }
    )
    ;

defcalctotal: //.calctotal node=3 calc_rangestart=0 calc_rangeend=224
    '.calctotal'
    'node' '=' node=NUMBER_INT             
    (  'calc' '=' calc=NUMBER_INT                   { asm.addNodeCalctotal($node, $calc); }
     | 'calc_rangestart' '=' calcfrom=NUMBER_INT 'calc_rangeend' '=' calcto=NUMBER_INT                               
                                                    { asm.addNodeCalctotal($node, $calcfrom, $calcto); }
    )
    ;

defedgesize: //.edges from=0 size=11                           
    '.edges'        
    'from' '=' edge=NUMBER_INT
    'size' '=' size=NUMBER_INT                      { asm.setEdgesize($edge, $size); }
    ;

defedge: //.edge from=3 to=4
    what=('.edge' | '.link')
    'ind'  '=' ind=NUMBER_INT     
    'from' '=' from=NUMBER_INT
    'to' '=' to=NUMBER_INT                          { asm.addEdge($ind, $from, $to, $what); }
    ;

deftablesize: //.tables size=1
    '.tables'             
    'size' '=' NUMBER_INT                           { asm.setTablesize($NUMBER_INT); }
    ;

deftable: //.table table=2 name=T_PaymentFrequency rows=4 cols=2 shuffled=true directaccess=false 
          //.table table=3 name=T_Mortality rows=101 cols=3 shuffled=false directaccess=true directaccessoffset=1 
    '.table'
    'table' '=' table=NUMBER_INT
    'name' '=' name=value            
    'rows' '=' rows=NUMBER_INT
    'cols' '=' cols=NUMBER_INT
    'shuffled' '=' shuffled=('true' | 'false') 
    'directaccess' '=' directaccess=('true' | 'false')
    ('directaccessoffset' '=' directaccessoffset=NUMBER_INT)?
                   { asm.addTable($table, $name.start, $rows, $cols, $shuffled, $directaccess, $directaccessoffset); }
    ;

deftablecol: 
    '.tablecol'
    'table' '=' table=NUMBER_INT
    'col' '=' colind=NUMBER_INT
    'name' '=' name=value
    'numeric' '=' numeric=('true' | 'false')
    'numericsuper' '=' numericsuper=('true' | 'false')
    'numericunique' '=' numericunique=('true' | 'false')
                   { asm.addTableColumn($table, $colind, $name.start, $numeric, $numericsuper, $numericunique); }
    ;                                      

deftablevalue:
    '.tablevalue'
    'table' '=' table=NUMBER_INT
    'ind' '=' ind=NUMBER_INT
    'row' '=' row=NUMBER_INT
    'col' '=' col=NUMBER_INT
    'value' '=' cellvalue=value
                  { asm.addTableValue($table, $ind, $row, $col, $cellvalue.start); }
    ;

deftablerow:
    '.tablerow'
    'table' '=' table=NUMBER_INT
    'row' '=' rowind=NUMBER_INT
    'oo' '=' oo=NUMBER_INT
                  { asm.addTableRowInfo($table, $rowind, $oo); }
    ;
                         
deffuncsize:
    '.funcs'
    'size' '=' NUMBER_INT                                       
                  { asm.setFuncsize($NUMBER_INT); } 
    ;
    
deffunc:
    '.func'
    'func' '=' func=NUMBER_INT
    'name' '=' name=ID
    'args' '=' nargs=NUMBER_INT   
    'formula' '=' formula=NUMBER_INT
                  { asm.addFunc($func, $name, $nargs, $formula); }
    ;

definputcalcidsize:
    '.inputcalcids' 
    'size' '=' NUMBER_INT
                  { asm.setInputcalcidSize($NUMBER_INT); }
    ;
    
definputcalcid:
    '.inputcalcid'
    'icalc' '=' inputcalc=NUMBER_INT
    'name' '=' name=ID                                         
                  { asm.addInputcalcid($inputcalc, $name); }
    ;

definputsize:
    '.inputs'
    'size' '=' NUMBER_INT
                  { asm.setInputsize($NUMBER_INT); }
    ;

definput:
    '.input'
    'input' '=' inputid=NUMBER_INT
    'name' '=' name=ID
    'autocounters' '=' autocounters=NUMBER_INT
    'choiceable' '=' choiceable=('true' | 'false')
                 { asm.addInput($inputid, $name, $autocounters, $choiceable); }
    ;

definputautocounter:
    '.inputautocounter'
    'input' '=' inputid=NUMBER_INT
    'ind' '=' ind=NUMBER_INT
    'counter' '=' counterid=NUMBER_INT
                 { asm.addInputAutocounter($inputid, $ind, $counterid); }
    ;

definputcalc:
    '.inputcalc'
    'input' '=' inputid=NUMBER_INT
    'icalc' '=' inputcalc=NUMBER_INT
    'formula' '=' formula=NUMBER_INT
                 { asm.addInputcalc($inputid, $inputcalc, $formula); }
    ;

defformulasize:
    '.formulas'
    'size' '=' NUMBER_INT
                 { asm.setFormulasize($NUMBER_INT); }
    ;
    
defformula:
    '.formula'
    'formula' '=' formula=NUMBER_INT                  
    'simple' '='  simple=('true'|'false')             { asm.defineFormula($formula, $simple); }
    formulacode                                       
    '.formuladone'                                    { asm.finishFormula($formula); }
    ;
               
formulacode:
    formulaline+
    ;
    
formulaline: 
    ':' op
  | LABEL  { asm.defineLabel($LABEL); }  op?
  ;

op: ID                                                { asm.gen($ID); }
  | ID o1=operand                                     { asm.gen($ID, $o1.start); }
  | ID o1=operand o2=operand                          { asm.gen($ID, $o1.start, $o2.start); }
  | ID o1=operand o2=operand o3=operand               { asm.gen($ID, $o1.start, $o2.start, $o3.start); }
  | ID o1=operand o2=operand o3=operand o4=operand    { asm.gen($ID, $o1.start, $o2.start, $o3.start, $o4.start); }
  ;
         
operand: 
    ID
  | NUMBER_INT
  | NUMBER_DEC
  | STRING    
  ;
                                                  
value: 
   ID | NUMBER_INT | STRING
   ;

ID: ('a'..'z'|'A'..'Z'|'_'|'$')('a'..'z'|'A'..'Z'|'_'|'0'..'9')* ;

LABEL: (('0'..'9') | ID) ':'                                            { setText(getText().substring(0, getText().length()-1)); }
   ;

NUMBER_INT: '-'? '0'..'9'+ 
   ;          
   
NUMBER_DEC: '-'? '0'..'9'+ '.' '0'..'9'+ 
   ;   

STRING:  '"' ( EscapeSequence | ~( '\\' | '"' | '\r' | '\n' ) )*  '"'   { setText(getText().substring(1, getText().length()-1)); }
   |     '\'' (~('\''|'\r'|'\n'))* '\''                                 { setText(getText().substring(1, getText().length()-1)); }
   ;

fragment EscapeSequence: '\\' (
             |   't' 
             |   'r' 
             |   'n' 
             |   '\"' 
             )          
;     
COMMENT        : COMMENTML | COMMENTLINE                               { $channel = HIDDEN; };

fragment COMMENTML      : '/*' (options {greedy=false;} :.)* '*/';
fragment COMMENTLINE    : ('//'|'#'|';') ( ~('\r' | '\n') )* '\r'? '\n'?   ;

WHITESPACE     : ('\r'|'\n'|' '|'\f'|'\t')+                            { $channel = HIDDEN; };

