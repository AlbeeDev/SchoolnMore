;albano alex 3ain
	org 0h
	jp main
	org 100h
main	ld ix,0200h
	ld b,10h
	ld c,(ix)
	call subval
	halt
subval	sub c
	dec b
	cp 0h
	jp nz,subval
	ret
