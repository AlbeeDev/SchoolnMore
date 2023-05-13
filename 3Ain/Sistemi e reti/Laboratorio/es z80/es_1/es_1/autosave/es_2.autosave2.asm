	org 0h
	jp main
main	;ld b,300h
	;ld a,200h
ciclo   ld hl,200h
	;inc a
	ld (hl),5
	ld hl,300h
	;inc b
	ld (hl),9
	cp 0h
	jp nz,ciclo
	halt