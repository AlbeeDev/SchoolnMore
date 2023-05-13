;albano alex
	org 0h
	jp main
main 	ld hl, 200h
ciclo   ld (hl),ffh
	ld a,(hl)
	inc hl
	ld a,(hl)
	cp 11h
	jp nz,ciclo
	halt