	org 0h
	jp main
	org 100h
main 	ld HL, 200h
	ld SP, ffffh
	ld B, fh
	call min
	ld sp, 302h
	push DE ;ld (300h), DE
	halt

min 	push BC
	push HL
	ld A, (HL)
	push HL ; ld DE, HL
	pop DE
loop 	dec B
	jr z, endFun
	inc HL
	ld C, (HL)
	cp C
	jr c, else ; http://jgmalcolm.com/z80/beginner/flag
	ld A, C
	push HL ; ld DE, HL
	pop DE
else 	jr loop
endFun 	pop HL
	pop BC
	ret