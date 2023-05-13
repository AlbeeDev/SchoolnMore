;albano alex 3ain
	org 0h
	jp main
	org 100h
main	ld ix,0200h
	ld b,10h
	call subval
	halt
subval	ld c,(ix)
	sub ffh,c
	ld (ix),c
	inc ix
	dec b
	cp 0h
	jp nz,subval
	ret
