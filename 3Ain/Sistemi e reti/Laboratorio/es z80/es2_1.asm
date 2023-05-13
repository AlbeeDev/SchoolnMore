;albano alex 3ain
	org 0h
	jp main
	org 100h
main	ld hl,0200h
ciclo	add hl,01h
	inc hl
	inc b
	cp 32h
	jp nz,ciclo
	halt