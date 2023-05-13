#include<stdio.h>
int main(){
int riga, colonna, nRighe, num, spazio, x;
printf("inserire numero righe: ");
scanf("%i", &nRighe);
printf("\n");
x=nRighe;
for (riga = 1; riga <= nRighe; riga++)
{
	num = 1;
	for(spazio=1;spazio<=x;spazio++){
		printf(" ");
	}
	for (colonna = 1; colonna <= riga; colonna++){
	    printf("%d ", num);
	    num = num * (riga - colonna) / colonna;
	}
	x = x-1;
	printf("\n");
}
return 0;
}


