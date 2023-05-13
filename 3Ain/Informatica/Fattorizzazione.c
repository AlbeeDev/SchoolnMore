#include <stdio.h>
int main(){
	int n, div=2;
	printf("inserisci numero: ");
	scanf("%i", &n);
	while (n>1){
		if(n%div==0){
		printf("%i ", div);
		n /= div;
		}
		else
		div++;
	}
	return 0;
}
