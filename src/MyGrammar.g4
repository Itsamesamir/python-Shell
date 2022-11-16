grammar MyGrammar;
/* PARSER RULES */ 
expr: left=expr op=('*'|'/') right=expr        # InfixExpr
    | left=expr op=('+'|'-') right=expr        # InfixExpr
    | atom=INT                                 # NumberExpr
    | '(' expr ')'                             # ParenExpr 
    | atom=PWD                                 # PwdExpr
    | atom=EXIT                                # ExitExpr
    ;

/* LEXER RULES */ 
INT  : [0-9]+         ;
WS   : [ \t]+ -> skip ;
PWD  : ('pwd')        ;
EXIT : ('exit')       ;

LOWERCASE   : [a-z]   ;
UPPERCASE   : [A-Z]   ;

WORD        : (LOWERCASE | UPPERCASE | '_')+ ;