//es 5
//Dato il seguente vettore, calcolare la media armonica dei valori che hanno 8 come ultima cifra
//int vec[]= {8,35,23,26,45,19,20,18,42,29,44,};
//valori non modificabili, lunghezza non modificabile
#include <stdio.h>
int main(){
	int i;
	float num=0.0, denum=0.0, media_armonica;
	int vec[]= {8,35,23,26,45,19,20,18,42,29,44,};
	
	for(i=0;i<11;i++){
		if (vec[i]-8==0 || (vec[i]-8)%10==0){
			num++;
			denum=denum+ (1./vec[i]);
		}
	}
	
	media_armonica= num/denum;
	printf("%.2f", media_armonica);
	
	return 0;
}
