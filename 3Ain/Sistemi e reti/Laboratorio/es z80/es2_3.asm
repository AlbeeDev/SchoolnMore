;albano alex 3ain
	org 0h
	jp main
	org 100h
main	ld hl,0200h
	ld ix,0300h
	ld c,00h
ciclo1	inc hl
	inc b
	ld a,(hl)
	cp 10h
	jp nc,ciclo2
	inc c
ciclo2	inc hl
	inc b
	cp 32h
	jp nz,ciclo1

	halt