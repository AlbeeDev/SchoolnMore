	org 0h
	jp main
main 	ld hl, 200h
	ld a,0h
ciclo1	inc a
ciclo2	inc hl
	cp ffh
	jp nz,ciclo1
	jp ciclo2
	halt