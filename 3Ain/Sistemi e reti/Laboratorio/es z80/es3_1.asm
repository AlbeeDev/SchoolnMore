;albano alex 3ain
	org 0h
	jp main
	org 100h
main	ld ix,0200h
	ld iy,0300h
	ld b,10h
	ld c,(ix)
	call findmin
	halt
findmin	ld a,(ix)
	inc a
	dec a
	cp c
	ld c,a
	inc ix
	dec b
	cp 0h
	jp nz,findmin
	ld (iy),c
	ret