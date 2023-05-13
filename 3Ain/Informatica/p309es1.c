#include <stdio.h>
#include <stdlib.h>
#include <math.h>
int main() {
	srand(time(NULL));
	int x[10];
	int i;
	for(i=0;i<10;i++){
	    x[i]=rand()%100;
	    printf("numero: %i elevato al quadrato: %.0f ",x[i] ,pow(x[i],2));
	    printf("\n");
	}
	return 0;
}
