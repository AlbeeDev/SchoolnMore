#include<stdio.h>
int main(){
int d, n;
scanf("%i", &n);
for(d=1;d<=n;d++)
if(n%d==0) {
	printf("%i\n", d);
}
return 0;
}
