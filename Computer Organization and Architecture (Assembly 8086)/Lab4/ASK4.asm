TITLE ASK4
ASSUME CS:CODE, DS:DATA
MAIN PROC NEAR
        MOV AX, DATA
        MOV DS, AX    
        
        MOV SI, 0
        
        LEA DX, MSG
        MOV AH, 09H
        INT 21H
    INPUT:
        MOV AH, 01H
        INT 21H
        
        CMP AL, 35 ; ASCII 35(#)
        JE CHECK
        
        CMP AL, 32 ; ASCII 32(SPACE)
        JB INPUT
        
        CMP AL, 127 ; ASCII 127(^)
        JA INPUT
    SAVE:
        MOV BUFFER[SI], AL
        INC SI
        CMP SI, 80
        JB INPUT
    CHECK:
        MOV CX, SI
        JCXZ NOTHING
        MOV SI, 0
        
        CALL SEARCH-METHOD
        
        JMP SKIP
    NOTHING:        
        LEA DX, EMPTY
        MOV AH, 09H
        INT 21H
    SKIP:
        MOV AH, 4CH
        INT 21H
MAIN ENDP
SEARCH-METHOD PROC NEAR
        MOV DL, 10
        MOV AH, 02H        
        INT 21H
        MOV DL, 13
        INT 21H 
        
        LEA DX, ENTER
        MOV AH, 09H
        INT 21H     
    INPUT1:
        MOV AH, 01H
        INT 21H
                 
        CMP AL, 32
        JB INPUT1
        
        CMP AL, 127
        JA INPUT1
        
        MOV BL, AL
        
        MOV DL, 10
        MOV AH, 02H        
        INT 21H
        MOV DL, 13
        INT 21H  
        
        MOV AL, 0
        MOV AL, BL
    REPEAT:
        CMP BUFFER[SI], AL
        JE INCREASE
        
        JMP CHECK1
    INCREASE:
        INC COUNTER2
    CHECK1:
        INC SI
        LOOP REPEAT
        
        CMP COUNTER2, 48
        JE JUMP NOTHING1
        
        MOV DL, COUNTER2
        ADD DL, 48
        
        MOV AH, 02H
        INT 21H

        RET
    NOTHING1:   
        LEA DX, NOTFOUND
        MOV AH, 09H
        INT 21H
        
        RET
SEARCH-METHOD ENDP
DATA SEGMENT
    MSG DB "ENTER TEXT: ", 10, 13, "$"
    ENTER DB "ENTER A CHAR TO SEARCH: ", 10, 13, "$"
	EMPTY DB "NO TEXT ENTERED: ", 10, 13, "$"
	NOTFOUND DB "NOT FOUND IN BUFFER: ", 10, 13, "$"
	BUFFER DB 80 DUP(0)
	SI DB 80
	COUNTER2 DB 0    
DATA ENDS

END MAIN