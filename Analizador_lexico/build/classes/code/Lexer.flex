package code;
import static code.Tokens.*;
%%
%class Lexer
%type Tokens
%line
%column

L=[a-zA-Z]
guion="_"
D=[0-9]
blank =[ \t\r\n]



LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]

TraditionalComment   = "/*" [^*] ~"*/" | "/*" "*"+ "/"
EndOfLineComment     = "--" {InputCharacter}* {LineTerminator}?
DocumentationComment = "/**" {CommentContent} "*"+ "/"
CommentContent       = ( [^*] | \*+ [^/*] )*
 String_con_error    =  "'" [^'] ~ {LineTerminator} 
Comment = {TraditionalComment} | {EndOfLineComment} | {DocumentationComment}

%{
    public String lexeme;
     public int columna;
    public int linea;
%}
%%
ADD
|EXTERNAL
|PROCEDURE
|ALL
|FETCH
|PUBLIC
|ALTER
|FILE
|RAISERROR
|AND
|FILLFACTOR
|READ
|ANY
|FOR
|READTEXT
|AS
|FOREIGN
|RECONFIGURE
|ASC
|FREETEXT
|REFERENCES
|AUTHORIZATION
|FREETEXTTABLE
|REPLICATION
|BACKUP
|FROM
|RESTORE
|BEGIN
|FULL
|RESTRICT
|BETWEEN
|FUNCTION
|RETURN
|BREAK
|GOTO
|REVERT
|BROWSE
|GRANT
|REVOKE
|BULK
|GROUP
|RIGHT
|BY
|HAVING
|ROLLBACK
|CASCADE
|HOLDLOCK
|ROWCOUNT
|CASE
|IDENTITY
|ROWGUIDCOL
|CHECK
|IDENTITY_INSERT
|RULE
|CHECKPOINT
|IDENTITYCOL
|SAVE
|CLOSE
|IF
|SCHEMA
|CLUSTERED
|IN
|SECURITYAUDIT
|COALESCE
|INDEX
|SELECT
|COLLATE
|INNER
|SEMANTICKEYPHRASETABLE
|COLUMN
|INSERT
|SEMANTICSIMILARITYDETAILSTABLE
|COMMIT
|INTERSECT
|SEMANTICSIMILARITYTABLE
|COMPUTE
|INTO
|SESSION_USER
|CONSTRAINT
|IS
|SET
|CONTAINS
|JOIN
|SETUSER
|CONTAINSTABLE
|KEY
|SHUTDOWN
|CONTINUE
|KILL
|SOME
|CONVERT
|LEFT
|STATISTICS
|CREATE
|LIKE
|SYSTEM_USER
|CROSS
|LINENO
|TABLE
|CURRENT
|LOAD
|TABLESAMPLE
|CURRENT_DATE
|MERGE
|TEXTSIZE
|CURRENT_TIME
|NATIONAL
|THEN
|CURRENT_TIMESTAMP
|NOCHECK
|TO
|CURRENT_USER
|NONCLUSTERED
|TOP
|CURSOR
|NOT
|TRAN
|DATABASE
|NULL
|TRANSACTION
|DBCC
|NULLIF
|TRIGGER
|DEALLOCATE
|OF
|TRUNCATE
|DECLARE
|OFF
|TRY_CONVERT
|DEFAULT
|OFFSETS
|TSEQUAL
|DELETE
|ON
|UNION
|DENY
|OPEN
|UNIQUE
|DESC
|OPENDATASOURCE
|UNPIVOT
|DISK
|OPENQUERY
|UPDATE
|DISTINCT
|OPENROWSET
|UPDATETEXT
|DISTRIBUTED
|OPENXML
|USE
|DOUBLE
|OPTION
|USER
|DROP
|OR
|VALUES
|DUMP
|ORDER
|VARYING
|ELSE
|OUTER
|VIEW
|END
|OVER
|WAITFOR
|ERRLVL
|PERCENT
|WHEN
|ESCAPE
|PIVOT
|WHERE
|EXCEPT
|PLAN
|WHILE
|EXEC
|PRECISION
|WITH
|EXECUTE
|PRIMARY
|WITHIN GROUP
|EXISTS
|PRINT
|WRITETEXT
|EXIT
|PROC
|ABSOLUTE
|EXEC
|OVERLAPS
|ACTION
|EXECUTE
|PAD
|ADA
|EXISTS
|PARTIAL
|ADD
|EXTERNAL
|PASCAL
|ALL
|EXTRACT
|POSITION
|ALLOCATE
|FALSE
|PRECISION
|ALTER
|FETCH
|PREPARE
|AND
|FIRST
|PRESERVE
|ANY
|FLOAT
|PRIMARY
|ARE
|FOR
|PRIOR
|AS
|FOREIGN
|PRIVILEGES
|ASC
|FORTRAN
|PROCEDURE
|ASSERTION
|FOUND
|PUBLIC
|AT
|FROM
|READ
|AUTHORIZATION
|FULL
|REAL
|AVG
|GET
|REFERENCES
|BEGIN
|GLOBAL
|RELATIVE
|BETWEEN
|GO
|RESTRICT
|BIT
|GOTO
|REVOKE
|BIT_LENGTH
|GRANT
|RIGHT
|BOTH
|GROUP
|ROLLBACK
|BY
|HAVING
|ROWS
|CASCADE
|HOUR
|SCHEMA
|CASCADED
|IDENTITY
|SCROLL
|CASE
|IMMEDIATE
|SECOND
|CAST
|IN
|SECTION
|CATALOG
|INCLUDE
|SELECT
|CHAR
|INDEX
|SESSION
|CHAR_LENGTH
|INDICATOR
|SESSION_USER
|CHARACTER
|INITIALLY
|SET
|CHARACTER_LENGTH
|INNER
|SIZE
|CHECK
|INPUT
|SMALLINT
|CLOSE
|INSENSITIVE
|SOME
|COALESCE
|INSERT
|SPACE
|COLLATE
|INT
|SQL
|COLLATION
|INTEGER
|SQLCA
|COLUMN
|INTERSECT
|SQLCODE
|COMMIT
|INTERVAL
|SQLERROR
|CONNECT
|INTO
|SQLSTATE
|CONNECTION
|IS
|SQLWARNING
|CONSTRAINT
|ISOLATION
|SUBSTRING
|CONSTRAINTS
|JOIN
|SUM
|CONTINUE
|KEY
|SYSTEM_USER
|CONVERT
|LANGUAGE
|TABLE
|CORRESPONDING
|LAST
|TEMPORARY
|COUNT
|LEADING
|THEN
|CREATE
|LEFT
|TIME
|CROSS
|LEVEL
|TIMESTAMP
|CURRENT
|LIKE
|TIMEZONE_HOUR
|CURRENT_DATE
|LOCAL
|TIMEZONE_MINUTE
|CURRENT_TIME
|LOWER
|TO
|CURRENT_TIMESTAMP
|MATCH
|TRAILING
|CURRENT_USER
|MAX
|TRANSACTION
|CURSOR
|MIN
|TRANSLATE
|DATE
|MINUTE
|TRANSLATION
|DAY
|MODULE
|TRIM
|DEALLOCATE
|MONTH
|TRUE
|DEC
|NAMES
|UNION
|DECIMAL
|NATIONAL
|UNIQUE
|DECLARE
|NATURAL
|UNKNOWN
|DEFAULT
|NCHAR
|UPDATE
|DEFERRABLE
|NEXT
|UPPER
|DEFERRED
|NO
|USAGE
|DELETE
|NONE
|USER
|DESC
|NOT
|USING
|DESCRIBE
|NULL
|VALUE
|DESCRIPTOR
|NULLIF
|VALUES
|DIAGNOSTICS
|NUMERIC
|VARCHAR
|DISCONNECT
|OCTET_LENGTH
|VARYING
|DISTINCT
|OF
|VIEW
|DOMAIN
|ON
|WHEN
|DOUBLE
|ONLY
|WHENEVER
|DROP
|OPEN
|WHERE
|ELSE
|OPTION
|WITH
|END
|OR
|WORK
|END-EXEC
|ORDER
|WRITE
|ESCAPE
|OUTER
|YEAR
|EXCEPT
|OUTPUT
|ZONE
|EXCEPTION {lexeme=yytext(); columna=yycolumn; linea=yyline; return Reservadas;}

{blank} {/*Ignore*/}

{Comment}         {/*Ignore*/}

{L}({L}|{D}|{guion}){1,30} {lexeme=yytext();columna=yycolumn; linea=yyline; return Identificador;}

({L}({L}|{D}|{guion}){30}) ({L}({L}|{D}|{guion}))+ {lexeme=yytext(); columna=yycolumn; linea=yyline; return Error_de_Identificador;}

("(-"{D}+")")|{D}+ {lexeme=yytext(); columna=yycolumn; linea=yyline;  return Int;}

"0"|"1"|"NULL" {lexeme=yytext(); columna=yycolumn; linea=yyline; return Bool;}

(({D})+ (".") ({D})*)|(({D})+ (".") ({D})*("E+")({D})+ ) {lexeme=yytext(); columna=yycolumn; linea=yyline;  return Float;}

((".")({D})+)|((".")({D})*("E+")({D})+) {lexeme=yytext();columna=yycolumn;  linea=yyline; return Float_malo;}

("'")[^(LineTerminator)]~("'") {lexeme=yytext(); columna=yycolumn;  linea=yyline; return String;}
("+") {lexeme=yytext(); columna=yycolumn;  linea=yyline; return suma;}
("-") {lexeme=yytext(); columna=yycolumn; linea=yyline;  return resta;}
("*") {lexeme=yytext(); columna=yycolumn; linea=yyline;  return multiplicacion;}
("/") {lexeme=yytext(); columna=yycolumn;  linea=yyline; return division;}
("%") {lexeme=yytext(); columna=yycolumn; linea=yyline;  return modular;}
("<") {lexeme=yytext(); columna=yycolumn; linea=yyline;  return menor;}
("<=") {lexeme=yytext(); columna=yycolumn; linea=yyline;  return menor_igual;}
(">") {lexeme=yytext(); columna=yycolumn;  linea=yyline; return mayor;}
(">=") {lexeme=yytext(); columna=yycolumn; linea=yyline;  return mayor_igual;}
("=") {lexeme=yytext(); columna=yycolumn;  linea=yyline; return igual;}
("==") {lexeme=yytext(); columna=yycolumn; linea=yyline;  return comparar;}
("!=") {lexeme=yytext(); columna=yycolumn;  linea=yyline; return diferente;}
("&&") {lexeme=yytext(); columna=yycolumn;  linea=yyline; return and;}
("||") {lexeme=yytext(); columna=yycolumn;  linea=yyline; return or;}
("!") {lexeme=yytext(); columna=yycolumn;  linea=yyline; return exclamacion;}
(";") {lexeme=yytext(); columna=yycolumn;  linea=yyline; return punto_coma;}
(",") {lexeme=yytext(); columna=yycolumn; linea=yyline;  return coma;}
(".") {lexeme=yytext(); columna=yycolumn; linea=yyline;  return punto;}
("[") {lexeme=yytext(); columna=yycolumn;  linea=yyline; return corchete_derecho;}
("]") {lexeme=yytext(); columna=yycolumn;  linea=yyline; return corchete_izquierdo;}
("(") {lexeme=yytext(); columna=yycolumn;  linea=yyline; return parentesis_izquierdo;}
(")") {lexeme=yytext(); columna=yycolumn;  linea=yyline; return parentesis_derecho;}
("{") {lexeme=yytext(); columna=yycolumn; linea=yyline;  return llave_izquierda;}
("}") {lexeme=yytext(); columna=yycolumn; linea=yyline;  return llave_derecha;}
("[]") {lexeme=yytext(); columna=yycolumn;  linea=yyline;  return doble_corchete;}
("()") {lexeme=yytext(); columna=yycolumn; linea=yyline;  return doble_parentesis;}
("{}") {lexeme=yytext(); columna=yycolumn; linea=yyline;  return doble_llave;}
("@") {lexeme=yytext(); columna=yycolumn;  linea=yyline; return arroba;}
("#") {lexeme=yytext(); columna=yycolumn;  linea=yyline; return numeral;}
("##") {lexeme=yytext(); columna=yycolumn;  linea=yyline;  return doble_numeral;}



 . {lexeme=yytext(); columna=yycolumn;  linea=yyline;  return ERROR;}


