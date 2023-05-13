	org 0h
	jp main
	org 100h
main	ld a,ffh
	ld hl,0300h
ciclo	ld (hl),a
	dec a
	inc hl
	cp 0h
	jp nz,ciclo
	halt