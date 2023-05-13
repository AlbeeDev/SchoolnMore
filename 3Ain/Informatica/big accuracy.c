#include<stdio.h>
int main(){
	float m,n;
	int k;
	scanf("%f %f %i",&m,&n,&k);
	printf("%.*lf",k,m/n);
}
