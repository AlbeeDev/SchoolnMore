#include <stdio.h>
int main()
{
int r, c, n=10;

	for(r=0; r<n; r++)
	{
		for(c=0; c<2*n; c++)
			if(2*r==c || r==c || (r==n-1 && c>n-2 && c<2*n-2))
			printf("*");
			else
			printf(" ");
		printf("\n");
	}
	return 0;
}
