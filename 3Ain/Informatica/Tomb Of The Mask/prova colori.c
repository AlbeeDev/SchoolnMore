#include<stdio.h>
int main() {
	char tasto='1';
	while (tasto!='0') {
	tasto = getch();
	if (kbhit()) { printf("Special ",tasto); tasto=getch(); }
	printf("%d\n",tasto); 
	}
}
