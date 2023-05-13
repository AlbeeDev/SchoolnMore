;albano alex 3ain
; Incrementare di 1 tutti i valori contenuti nella memoria dagli indirizzi 200h a 21fh
	org 0h
	jp main
	org 100h
main	ld a,1h
	ld hl,0200h
ciclo	add a,(hl)
	inc hl
	inc b
	cp 32h
	jp nz,ciclo
	halt