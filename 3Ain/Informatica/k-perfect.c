#include <stdio.h>
int main()
{
	int n, x=0;
	scanf("%d", &n);
	{
		int sd = 0, isd;
		for(isd=1; isd<=n; isd++)
		{
			if(n%isd==0){
				sd += isd;
				printf("%i ", isd);
				x=x+1;
			}
		}
		if(sd%n==0){
			printf("%i is %i-perfect", n, x);
		}
		else
		printf("%i is not perfect", n);
	}
	return 0;
}
