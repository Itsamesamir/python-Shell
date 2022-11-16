grammar MyGrammar;
/* PARSER RULES */ 
commandline : left=COMMAND right=INPUT #default
            | atom=PWD  #pwd
            | atom=CD   #cd
            | atom=ECHO #echo
            | atom=LS   #ls
            | atom=CAT  #cat
            | atom=HEAD #head
            | atom=TAIL #tail
            | atom=GREP #grep
            ;

PWD     : ('pwd')        ;
CD      : ('cd')     ;
ECHO    : ('echo')  ;
LS      : ('ls')         ;
CAT     : ('cat')       ;
HEAD    : ('head')      ;
TAIL    : ('tail')       ;
GREP    : ('grep')       ;



/* LEXER RULES */ 
TEXTSQ : '\'' ~'\''* '\'';
TEXTDQ : '"' ~'"'* '"';
COMMAND   : (LOWERCASE)+ [\t]*;
INPUT : (TEXTSQ | TEXTDQ | (~'\t'+));

INT  : [0-9]+         ;
fragment LOWERCASE   : [a-z]   ;
fragment UPPERCASE   : [A-Z]   ;
WS   : [\t]+ -> skip ;
ANYCHAR : .;