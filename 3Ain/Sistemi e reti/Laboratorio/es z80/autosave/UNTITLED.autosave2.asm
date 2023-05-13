;albano alex 3ain
	org 0h
	jp main
	org 100h
main	ld ix,0200h
	ld iy,0300h
	ld b,10h
	call findmin
	halt
findmin	ld (c),(ix)
	
	dec b
	cp 0h
	jp nz,findmin
	ld (iy),(c)
	ret 