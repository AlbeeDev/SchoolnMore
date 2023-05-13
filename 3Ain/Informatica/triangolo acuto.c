#include <stdio.h>
int main()
{
int r, c, n=10;

	for(r=0; r<n; r++)
	{
		for(c=0; c<2*n; c++)
			if(r==n-c-1 || r+n-1==c || (r==n-1 && c<2*n-1))
			printf("*");
			else
			printf(" ");
		printf("\n");
	}
	return 0;
}
