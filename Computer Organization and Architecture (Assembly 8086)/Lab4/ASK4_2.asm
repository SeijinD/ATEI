TITLE ASK4
ASSUME CS:CODE,DS:DATA
CODE SEGMENT
START:
    MOV AX,DATA
    MOV DS,AX
            
    JMP SKIP_SUBROUTINES
            
    SUBROUTINE PROC NEAR
        LEA DX,LETTER_INPUT_MESSAGE
        MOV AH,09H
        INT 21H
        
        MOV AH,01H
        INT 21H
        
        MOV SI,0
        MOV BL,0
    SEARCH_LOOP:
        CMP AL,INPUT_BUFFER[SI]
        
        JNE SKIP_INC
        
        INC BL
    SKIP_INC:
        INC SI
        CMP SI,80
        JB SEARCH_LOOP
        
        LEA DX, COUNT_LETTER_MESSAGE
        MOV AH,09H
        INT 21H
        
        CMP BL,0
        JE NOT_FOUND
        
        CMP BL,10
        JAE DIV_PRINT
        
        MOV DL,BL
        ADD DL,"0"
        MOV AH,02H
        INT 21H
        
        RET
    DIV_PRINT:
        MOV AL,BL
        MOV AH,0
        MOV BH,10
        DIV BH
        
        MOV DL, AL
        ADD DL,"0"
        
        MOV BL,AH
        
        MOV AH,02H
        INT 21H
        
        MOV DL,BL
        ADD DL,"0"
        
        MOV AH,02H
        INT 21H
        
        RET
    NOT_FOUND:
        LEA DX,NOT_FOUND_MESSAGE
        MOV AH,09H
        INT 21H
        
        RET            
                
    SUBROUTINE ENDP
        
SKIP_SUBROUTINES:
    LEA DX,TEXT_INPUT_MESSAGE
    MOV AH,09H
    INT 21H
    
    MOV SI,0
    
INPUT_LOOP:
    MOV AH,01H
    INT 21H
    
    CMP AL,"#"
    JE EXIT_INPUT_LOOP
    
    MOV INPUT_BUFFER[SI],AL
    
    INC SI
    CMP SI,80
    JB INPUT_LOOP
EXIT_INPUT_LOOP:
    CALL SUBROUTINE    
                
    MOV AH,4CH
    INT 21H       
CODE ENDS
DATA SEGMENT
    TEXT_INPUT_MESSAGE db "Type a text (#-to exit): ",10,13,"$"
    LETTER_INPUT_MESSAGE db 10,13,"Search for a letter: ",10,13,"$"
    COUNT_LETTER_MESSAGE db 10,13,"The letter counter: $"
    NOT_FOUND_MESSAGE db 10,13,"Letter not found$"
    INPUT_BUFFER db 80 DUP(0)    
DATA ENDS
END START