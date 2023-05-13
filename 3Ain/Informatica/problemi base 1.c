#include<stdio.h>
int main() {
	int x, cifra=0;
	printf("inserire numero: ");
	scanf("%i", &x);
	while (x > 0) {
        cifra = x - ((x / 10) * 10);
        x = x / 10;
        printf("%i, ", cifra);
    }
	return 0;
}
