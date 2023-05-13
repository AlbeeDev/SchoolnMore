	org 0h
	jp main
main 	ld hl, 200h
ciclo	inc a
	inc hl   
	cp ffh
	
	jp nz,ciclo
	halt