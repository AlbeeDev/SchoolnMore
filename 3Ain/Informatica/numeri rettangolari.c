#include <stdio.h>
int main()
{
int x=1,y=2,i,limite,num;
printf("limite: ");
scanf("%i", &limite);
for(i=0;i<limite;i++){
	num=x*y;
	printf("%i ", num);
	x++;
	y++;
}
printf("\n");
int a=1,b=2,numero, vero=0;
printf("numero minore di 10000: ");
scanf("%i", &numero);
while(vero==0){
	if(a*b==numero){
		printf("numero rettangolare");
		vero=1;
	}
	if(a>10000){
		printf("numero non rettangolare");
		break;
	}
	a++;
	b++;
}
	return 0;
}
