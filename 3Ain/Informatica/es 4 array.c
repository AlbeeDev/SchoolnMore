//es 4
//Dato il seguente vettore, eseguire uno shift verso destra degli elementi della prima metà dell’array
//int vec[]= {8,35,23,26,45,19,20,18,42,29,44,};
//valori modificabili, lunghezza non modificabile
#include <stdio.h>
int main(){
	int i, temp=0;
	
	int vec[12];
	
	printf("inserire 11 numeri: \n");
	
	for(i=0;i<11;i++){
		scanf("%i", &vec[i]);
	}
	vec[11]=0;
	
	temp= vec[4];
	for(i=11;i>0;i--){
		vec[i]=vec[i-1];		
	}
	vec[0]=temp;
	
	for(i=0;i<12;i++){
		printf("%i ", vec[i]);
	}
	
	return 0;
}
