;albano alex 3ain
	org 0h
	jp main
main	org 100h
	ld ix,200h
	call bin
	halt
bin	ld b,(hl)
	ld c,b
	sub b,c
	sub b,c
	ret