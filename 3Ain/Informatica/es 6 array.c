//es 6
//Dato il seguente vettore, calcolare la media geometrica dei valori di posizione dispari (si consideri la prima posizione pari)
//int vec[]= {8,35,23,26,45,19,20,18,42,29,44,};
//valori non modificabili, lunghezza non modificabile
#include <stdio.h>
#include <math.h>
int main(){
	int i, vuoto;
	float media_geometrica= 0.0, indice=0.0, radicando=1.0;
	int vec[]= {8,35,23,26,45,19,20,18,42,29,44,};
	for(i=0;i<11;i++){
		if(i==0 || i%2==0)
			vuoto=1;
		else{
			indice=indice+1;
			radicando= radicando * vec[i];
		}
	}
	
	media_geometrica= pow(radicando, 1./indice);
	printf("%.2f", media_geometrica);
	
	return 0;
}
