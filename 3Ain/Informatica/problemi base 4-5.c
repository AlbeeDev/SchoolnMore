#include<stdio.h>
#include<math.h>
int main () {
	int d=0,b,i=0;
	
	printf("Inserisci il numero binario da convertire: ");
	scanf("%i", &b);	
	
	while(b>0){
		if(b%10!=0) {
			d=d+pow(2,i);
		}
		b=b/10;
		i++;			
	}
	
	printf("Il numero in decimale vale: %i", d);
	
	return 0;
}
