;albano alex 3ain
	org 0h
	jp main
	org 100h
main	ld hl,0200h
	ld ix,0300h
	ld b,0h
	dec hl
ciclo	inc hl
	inc b
	ld a,(hl)
	cp 0h
	jp z,ciclo
	ld (ix),a
	inc ix
	inc b
	dec b
	cp 32h
	jp nz,ciclo
	halt
