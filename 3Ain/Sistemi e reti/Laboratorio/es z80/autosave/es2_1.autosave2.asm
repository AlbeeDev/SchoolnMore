;albano alex 3ain
	org 0h
	jp main
	org 100h
main	ld a,01h
	ld hl,0200h
ciclo	inc (hl)
	inc hl
	inc b
	cp 32h
	jp nz,ciclo
	halt