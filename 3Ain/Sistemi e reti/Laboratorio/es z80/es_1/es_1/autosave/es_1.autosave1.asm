;ancarani giacomo
;Realizzare un programma Z80 che riempie con il valore FFh le celle di memoria a partire da 200h fino ad arrivare alla cella contenete 11h

	org 0h
	jp main
main 	ld hl, 200h
	ld (hl),a
ciclo	inc hl
	
	cp 11h
	ld (hl),ff
	jr nz,ciclo