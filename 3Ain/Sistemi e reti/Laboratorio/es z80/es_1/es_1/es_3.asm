;albano alex
	org 0h
	jp main
main 	ld hl, 200h
	ld a,0h
ciclo1	inc a
ciclo2	inc hl
	cp 1h
	jp nz,ciclo3
	cp ffh
	jp nz,ciclo1
	jp ciclo2
ciclo3	ld hl,300h
	ld (hl),a
	halt