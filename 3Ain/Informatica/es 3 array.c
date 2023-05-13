//es 3
//dato il seguente vettore, eseguire una rotazione verso destra degli elementi della prima meta dell' array
//int vec[]= {8,35,23,26,45,19,20,18,42,29,44,};
//valori modificabili, lunghezza non modificabile
#include <stdio.h>
int main(){
	int i, temp=0;
	int vec[11];
	
	printf("inserire 11 valori: \n");
	
	for(i=0;i<=10;i++){
		scanf("%i", &vec[i]);
	}
	
	temp= vec[4];
	for(i=4;i>0;i--){
		vec[i]=vec[i-1];		
	}
	vec[0]=temp;
	
	for(i=0;i<=10;i++){
		printf("%i ", vec[i]);
	}
	
	return 0;	
}
