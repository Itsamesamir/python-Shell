grammar idk;

/*
 * Parser Rules
 */

/*main */
command : pipe | command ';' command | call;
pipe : call '|' call | pipe '|' call;
call :(applications)
     |(applications (WHITESPACE) (non_keyword | QUOTED)  (WHITESPACE) (redirection WHITESPACE)* argument (WHITESPACE atom)* WHITESPACE);
applications: com='pwd' #pwd
            | com='cd'   #cd
            | com='echo' #echo
            | com='ls'   #ls
            | com='cat'  #cat
            | com='head' #head
            | com='tail' #tail
            | com='grep' #grep
            ;

/*quoting */

/*call */
atom : redirection | argument;
argument : (QUOTED | unquoted)+;
redirection : '<' WHITESPACE? argument | '>' WHITESPACE? argument;

non_keyword : ~(NEW_LINE | SINGLEQ | DOUBLEQ | BACKQ | ';' | '|')+;

unquoted: ~(WHITESPACE | NEW_LINE | QUOTES|'|'|';'|'<'|'>')+;


 /*
  * Lexer Rules
  */
//add other applications
APPLICATIONS: ('pwd' | 'cd' | 'echo' | 'ls' | 'cat' | 'head' | 'tail' | 'grep') ;
NEW_LINE :  ('\n' | '\r') +;
QUOTES : ('"'|'\''|'`');
NON_NEWLINE : ~('\n' | '\r')+;
NON_SINGLE_QUOTE : ~ ('\'' | '\n' | '\r') + ;
NON_BACK_QUOTE : ~ ('`' | '\n') +;
DOUBLE_QUOTE_CONTENT: ~ ('"' | '`' | '\n') +  ;
WHITESPACE: (' ' | '\t')+ ;
QUOTED : SINGLEQ | DOUBLEQ | BACKQ;
SINGLEQ :  '\''(NON_SINGLE_QUOTE)'\'' ;
BACKQ : '`' (NON_BACK_QUOTE) '`';
DOUBLEQ : '"'(BACKQ | DOUBLE_QUOTE_CONTENT )* '"';