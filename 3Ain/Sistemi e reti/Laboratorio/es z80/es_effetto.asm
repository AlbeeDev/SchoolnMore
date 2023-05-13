;albano alex 3ain
	org 0h
	jp main
	org 100h
main	ld C,01h
	ld D,01h
rp	out (C),D

loop	ld (HL),D
	inc (HL)
	dec (HL)
	jp z,reset
lp	inc D
	dec (HL)
	jp nz,lp
	out (C),D
	jp z,loop

reset	ld D,1h
	jp rp
	halt