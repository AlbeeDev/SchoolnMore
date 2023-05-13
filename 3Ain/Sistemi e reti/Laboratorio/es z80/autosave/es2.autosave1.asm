;albano alex
	org 0h
	jp main
	org 100h
main	ld a,02h
	ld hl,0200h
ciclo	ld (hl),a
	inc hl
	inc a
	inc a
	cp 22h
	jp nz,ciclo
	halt