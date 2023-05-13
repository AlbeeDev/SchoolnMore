#include <stdio.h>
void sum(int poly1[11],int poly2[11],int poly3[11],int deg1,int deg2){
		int i,degmax;
		if(deg1>deg2)
		degmax=deg1;
		else
		degmax=deg2;
		for(i=0;i<11;i++){
		poly3[i]=poly1[i]+poly2[i];
	}
	printf("la somma dei due polinomi è: \n");
	for(i=0;i<11;i++){
		printf("%i ", poly3[i]);
		if(i==degmax)
		break;
	}
	}
	void diff(int poly1[11],int poly2[11],int poly3[11],int deg1,int deg2){
		int i,degmax;
		if(deg1>deg2)
		degmax=deg1;
		else
		degmax=deg2;
		for(i=0;i<11;i++){
		poly3[i]=poly1[i]-poly2[i];
	}
	printf("la differenza dei due polinomi è: \n");
	for(i=0;i<11;i++){
		printf("%i ", poly3[i]);
		if(i==degmax)
		break;
	}
	}
int main(){
	int poly1[11],poly2[11],poly3[11];
	int i,deg1,deg2;
	printf("grado del primo polinomio: ");
	scanf("%i", &deg1);
 	printf("inserisci primo polinomio: \n");
	for(i=0;i<11;i++){
		scanf("%i", &poly1[i]);
		if(i==deg1)
		break;
	}
	printf("grado del secondo polinomio: ");
	scanf("%i", &deg2);
	printf("inserisci secondo polinomio: \n");
	for(i=0;i<11;i++){
		scanf("%i", &poly2[i]);
		if(i==deg2)
		break;
	}
	sum(poly1,poly2,poly3,deg1,deg2);
	printf("\n");
	diff(poly1,poly2,poly3,deg1,deg2);
	return 0;
}
