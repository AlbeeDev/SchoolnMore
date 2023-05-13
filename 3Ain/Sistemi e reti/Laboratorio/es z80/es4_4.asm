;albano alex 3ain
	org 0h
	jp main
main	org 100h
	ld hl,200h
	ld b,(hl)
	inc hl
	ld c,(hl)
	call molt
	halt
molt	add b,b
	dec c
	cp 1h
	jp nz,sub1
	ret
sub1	call molt
	ret
	