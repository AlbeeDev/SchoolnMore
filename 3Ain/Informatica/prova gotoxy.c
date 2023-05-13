#include<stdio.h>
#include<conio.h>
#include<string.h>
int main(){
	char str[50]= "cancella questo testo se premi c";
	printf("%s ",str);
	char let= getch();
	printf("%zu ",strlen(str));
	if(let==99){
		printf("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
	}
	printf("cancella questo testo se permi b");
}
