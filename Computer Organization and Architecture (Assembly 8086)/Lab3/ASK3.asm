TITLE ASK3
ASSUME CS:CODE, DS:DATA          
CODE SEGMENT
    START:  MOV AX,DATA
            MOV DS,AX
            
            MOV SI,0
            
            LEA DX,MSG
            MOV AH,09H
            INT 21H
    INPUT:
            MOV AH,01H
            INT 21H 
            
            CMP AL,13   ; enter
            JE CHECK
            
            CMP AL,32   ; space
            JE SAVE
            
            CMP AL,46   ; dot
            JE SAVE
            
            CMP AL,65   ; A
            JB INPUT
            
            CMP AL,90   ; Z
            JBE SAVE
            
            CMP AL,97   ; a
            JB INPUT
            
            CMP AL,122  ; z
            JA INPUT     
    SAVE:   
            MOV BUFFER[SI],AL
            INC SI
            CMP SI,40
            JB INPUT
    CHECK:
            MOV CX,SI
            JCXZ NOTHING
            MOV SI,0
            
            LEA DX,ENTER
            MOV AH,09H
            INT 21H
    REPEAT:
            MOV DL,BUFFER[SI]
            
            CMP DL,32
            JE PRINT
            
            CMP DL,46
            JE PRINT
            
            CMP DL,90
            JA LOWER
            
            ADD DL,32
            JMP PRINT
    LOWER:
            SUB DL,32
            JMP PRINT
    PRINT:
            MOV AH,02H
            INT 21H
            
            INC SI
            LOOP REPEAT
            
            JMP SKIP
    NOTHING:
            LEA DX,EMPTY
            MOV AH,09H
            INT 21H
    SKIP:             
            MOV AH,4CH
            INT 21H
CODE ENDS

DATA SEGMENT
    MSG DB "ENTER TEXT: ",10,13,"$"
    ENTER DB "TEXT AFTER INPUT: ",10,13,"$"
    EMPTY DB "NO TEXT ENTERED: ",10,13,"$"
    BUFFER DB 40 DUP(0)
    SI DB 40
DATA ENDS

END START