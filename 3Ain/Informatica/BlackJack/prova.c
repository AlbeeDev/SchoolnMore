#include<stdio.h>
#include<stdbool.h>
int main(){
	bool valid=false;
	char option;
	while(valid==false){
		printf("type 'h' to hit or 's' to stay: ");
		option=getch();
		if (kbhit()){
			option=getch();
		}
		switch(option)
		{
			case 'h':
				valid=true;
				break;
			default:
				valid=false;
				printf("not a valid option\n");
				break;
		}
	}
/*	char tasto='1';
	while (tasto!='0'){
	tasto = getch();
	if (kbhit()){
		printf("Special ",tasto); tasto=getch(); 
	}
	printf("%d\n",tasto); 
	}*/
}
