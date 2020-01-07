TITLE ASK3
ASSUME CS:CODE,DS:DATA
CODE SEGMENT
    START:
        MOV AX,DATA
        MOV DS,AX
        
        LEA DX,MSG
        MOV AH,09H
        INT 21H
        
        MOV SI,0
    MAIN:
        MOV AH,01H
        INT 21H
        
        CMP AL,13
        JE SKIP
        
        CMP AL," "
        JE INPUT
        
        CMP AL,"."
        JE INPUT
        
        CMP AL,"A"
        JB MAIN
        
        CMP AL,"Z"
        JBE INPUT_CHANGE
        
        CMP AL,"a"
        JB MAIN
        
        CMP AL,"z"
        JBE INPUT_CHANGE2
        
        JMP MAIN
    INPUT_CHANGE:
          ADD AL,32
          JMP INPUT
    INPUT_CHANGE2:
          SUB AL,32
          JMP INPUT
    INPUT:
        MOV BUFFER[SI],AL           
        INC SI
        CMP SI,39
        JBE MAIN
    SKIP:
        MOV SI,0
   PRINT:
        MOV DL,BUFFER[SI]
        MOV AH,02H
        INT 21H
        INC SI
        CMP SI,39
        JBE PRINT
        
        MOV AH,4CH
        INT 21H
CODE ENDS

DATA SEGMENT
    MSG DB " GIVE A TEXT: ",10,13,"$"
    BUFFER DB 40 DUP(0)
DATA ENDS

    END START