;albano alex 3ain
	org 0h
	jp main
main	org 100h
	ld hl,200h
	ld c,(hl)
	call min
	ld hl,300h
	ld (hl),c
	halt
min	ld b,(hl)
	cp c
	jp z,sub1
	ld c,b
sub1	inc hl
	ret