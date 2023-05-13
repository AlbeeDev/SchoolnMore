	org 0h
	jp main
mai	ld b,300h
	ld a,200h
ciclo   ld hl,a
	inc a
	ld x,(hl)
	ld hl,b
	inc b
	ld (hl),x
	cp 0h
	jp nz,ciclo
	halt