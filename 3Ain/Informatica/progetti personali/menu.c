#include<stdio.h>
#include<stdbool.h>
#include<stdlib.h>
#include<windows.h>
void gotoxy(short c, short r) {
	if (c>0 && r>0) {
		COORD CursorPosition = { c-1, r-1 };
		HANDLE hOut = GetStdHandle(STD_OUTPUT_HANDLE);
		SetConsoleCursorPosition(hOut, CursorPosition);
	}
}
int optionf(int x,int maxopz){
	bool valid=false;
	char option;
	while(valid==false){
		option=getch();
		if (kbhit()){
			option=getch();
		}
		switch(option)
		{
			case 72:
				if(x!=1){
					valid=true;
					return 1;
				}
				break;
			case 80:
				if(x!=maxopz){
					valid=true;
	 				return 2;
				}
				break;
			case 13:
				return 0;
				break;	
			default:
				break;
		}
	}
}
void menu(int y,int nopz){
	int x=1;
	gotoxy(2,x);
	printf(">");
	int ret;
	while(1){
		for(int i=0;i<nopz;i++){
			gotoxy(4,i+1);
			printf("opzione");
		}
		
		ret=optionf(x,nopz);
		if(ret==0){
			system("cls");
			printf("opzione selezionata!");
			exit(0);
		}
		if(ret==1){
			x--;
			gotoxy(2,x+1);
			printf(" ");
			gotoxy(2,x);
			printf(">");	
		}
		if(ret==2){
			x++;
			gotoxy(2,x-1);
			printf(" ");
			gotoxy(2,x);
			printf(">");	
		}
	}
}
int main(){
	menu(2,5);
	
}
