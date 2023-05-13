#include<stdio.h>
#include<stdbool.h>
#define n 20
int graphic(){
	int grafico[n*2][n*2];
	for(int y=n;y>-n;y--){
		for(int x=-n;x<n;x++){
			bool printed=false;
			if(pow(x,2)+pow(y,2)-(2*x)-3==0){
				printed=true;
				grafico[y+n][x+n]=1;
				printf("%i ",grafico[y+n][x+n]);
			}
			else{
				grafico[y][x]=2;
				printf("  ");
			}
			if(x==0 || y==0){
				grafico[y+n][x+n]=0;
				if(printed==false){
					printf("%i ",grafico[y+n][x+n]);
				}
				else{
					printf("  ");
				}
			}
		}
		printf("\n");
	}
}
int getm(){
	float xp1,yp1,xp2,yp2;
	float m,q;
	printf("xp1:\n");
	scanf("%f",&xp1);
	printf("yp1: \n");
	scanf("%f",&yp1);
	printf("xp2: \n");
	scanf("%f",&xp2);
	printf("yp2: \n");
	scanf("%f",&yp2);
	m=(yp2-yp1)/(xp2-xp1);
	printf("\nm=%.1f\n",m);
	q=m*(-xp1)+yp1;
	printf("y=%.1fx+%.1f",m,q);
}
int main(){
	char* form_circ,form_rett;
	

	
}
