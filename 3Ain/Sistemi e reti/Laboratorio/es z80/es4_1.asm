;albano alex 3ain
	org 0h
	jp main
main	ld hl,200h
	ld,c
	call ord
	halt
ord	ld b,(hl)
	inc hl
	ld c,(hl)
	ld hl,b
	ret
	
	