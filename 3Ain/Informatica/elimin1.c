#include<stdio.h>
#include<math.h>
int main(){
	int i;
	// quali sono i numeri rettangolari?
	for(i=0; i<20; i++)
	{
		printf("%5d", i*(i+1));
	}
	printf("\n");

	// i è rettangolare?
	for(i=0; i<500; i++)
	{
		int j = sqrt(i);
		if(j*(j+1)==i)
			printf("%5d", i);
	}

	return 0;
}
