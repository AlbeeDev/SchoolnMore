#include<stdio.h>
#include<windows.h>
#include<conio.h>
void gotoxy(short c, short r) {
	if (c>0 && r>0) {
		COORD CursorPosition = { c-1, r-1 };
		HANDLE hOut = GetStdHandle(STD_OUTPUT_HANDLE);
		SetConsoleCursorPosition(hOut, CursorPosition);
	}
}
int main(){
	int row=1;
	while(1){
		gotoxy(2,row);
		printf("riga %i",row);
		row+=2;
	}
	
}
