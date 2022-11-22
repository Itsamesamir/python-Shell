grammar ShellGrammar;

/*
 * Parser Rules
*/

/*main pwd < "this should be arguement" arguement2 > thisatomarguement*/
start: command;
command : command SEQUENCE command
        | pipe
        | call
        ;
pipe : call PIPE call | pipe PIPE call;
call: (applications WHITESPACE* (QUOTED | NON_KEYWORD | UNQUOTED)*) | (applications WHITESPACE? (redirection | WHITESPACE)* argument (WHITESPACE | atom)* WHITESPACE?);
applications: com='pwd'  #pwd
            | com='cd'   #cd
            | com='echo' #echo
            | com='ls'   #ls
            | com='cat'  #cat
            | com='head' #head
            | com='tail' #tail
            | com='grep' #grep
            | com='exit' #exit
            ;

/*quoting*/

/*call */
atom : redirection | argument;
argument : (QUOTED | UNQUOTED);
redirection : INPUT WHITESPACE* argument | OUTPUT WHITESPACE* argument;


 /*
  * Lexer Rules
  */
INPUT: '<';
OUTPUT: '>';
PIPE: '|';
SEQUENCE: ';';
QUOTED : SINGLEQ | DOUBLEQ | BACKQ;
SINGLEQ :  '\'' (NON_SINGLE_QUOTE)'\'' ;
BACKQ : '`' (NON_BACK_QUOTE) '`';
DOUBLEQ : '"'(BACKQ | DOUBLE_QUOTE_CONTENT )* '"';
NEW_LINE :  ('\n'|'\r')->skip ;
WHITESPACE: (' ')->skip;
UNQUOTED: ~(' '|'\n'|'\r'|'"'|'\''|'`'|'|'|';'|'<'|'>')+;
NON_KEYWORD:~(' '|'\n'|'\r'|'"'|'\''|'`'|'|'|';')+;
NON_SINGLE_QUOTE :  (~ ('\'' |'\n' | '\r')).*? ;
NON_BACK_QUOTE :  (~('`' | '\n' | '\r')).*? ;
DOUBLE_QUOTE_CONTENT: (~('"' | '`' |'\n' | '\r')) ;