;albano alex
	org 0h
	jp main
main
ciclo   ld hl,200h
	ld a,(hl)
	ld hl,300h
	ld (hl),a
	cp 0h
	jp nz,ciclo
	halt