#include <stdio.h>
#include <windows.h>
void gotoxy(short c, short r) {
	if (c>0 && r>0) {
		COORD CursorPosition = { c-1, r-1 };
		HANDLE hOut = GetStdHandle(STD_OUTPUT_HANDLE);
		SetConsoleCursorPosition(hOut, CursorPosition);
	}
}
int main() {
 int tasto, x;
 tasto= getch();
 x=1;
 while (x)
	switch (tasto){
		case 72:
			printf("ciao");
			
		case 80:
			printf("no");
		case 13:
			x=0;
	}

return 0;
}
