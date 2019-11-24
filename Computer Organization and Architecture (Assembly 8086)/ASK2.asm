TITLE ASK2
ASSUME CS:CODE, DS:DATA
CODE SEGMENT
    START:  
            MOV AX,DATA
            MOV DS,AX
            
            LEA DX,MES 
            MOV AH,09H
            INT 21H
            
    MAIN:   
            MOV AH,08H
            INT 21H
            
            CMP AL,48
            JB MAIN
            
            CMP AL,57
            JA MAIN
            
            MOV DL,AL
            MOV AH,02H
            INT 21H
            
            CMP AL,48
            JNE DOWN
            
            LEA DX,ZEROMS
            MOV AH,09H
            INT 21H
            INC N
            JMP NEXT
    DOWN:   
            MOV AH,0
            MOV BL,2
            DIV BL
            
            CMP AH,0
            JE EVEN
            
            LEA DX,ODDMS
            MOV AH,09H
            INT 21H
            INC N
            JMP NEXT
    EVEN:
            LEA DX,EVENMS
            MOV AH,09H
            INT 21H
            INC N
            JMP NEXT
    NEXT:
            CMP N,5
            JB MAIN            
            
            MOV AH,4CH
            INT 21H
CODE ENDS

DATA SEGMENT
    MES DB "TYPE A NUMBER(0-9): ",10,13,"$"
    ZEROMS DB " IS ZERO",10,13,"$"
    EVENMS DB " IS EVEN",10,13,"$"  
    ODDMS DB " IS ODD",10,13,"$"  
    N DB 0  
DATA ENDS

END START
           