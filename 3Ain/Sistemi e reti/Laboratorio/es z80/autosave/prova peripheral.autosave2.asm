	org 0h
	jp main
	org 100h
main	ld C,01h
	ld D,01h
	out (C),D

loop	ld (HL),D
lp	inc D
	cp 81h
	jp z,reset
	dec (HL)
	jp nz,lp
	out (C),D
	jp z,loop

reset	ld D,1h
	jp loop
	halt