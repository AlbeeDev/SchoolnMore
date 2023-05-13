#include<stdio.h>
#include<stdbool.h>
#include<windows.h>
struct reg{
	char username[50];
	char password[50];
};
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
			case 8:
				return 3;
				break;
			case 27:
				return -1;
				break;
			default:
				break;
		}
	}
}
int menu(void){
	system("cls");
	int x=1;
	int maxopz=3;
	while(1){
		gotoxy(1,x);
		printf(">>");
		gotoxy(5,1);
		printf("Login");
		gotoxy(5,2);
		printf("Register");
		gotoxy(5,3);
		printf("User list");
		int opt=optionf(x,maxopz);
		if(opt==-1){
			exit(0);
		}
		if(opt==1){
			gotoxy(1,x);
			printf("  ");
			x-=1;
		}
		if(opt==2){
			gotoxy(1,x);
			printf("  ");
			x+=1;
		}
		if(opt==0){
			return x;
		}
	}
	return 0;
}
struct reg login(bool acess){
	system("cls");
	struct reg user,users[100];
	printf("user: \n");
	fgets(user.username,50,stdin);
	printf("password: \n");
	fgets(user.password,50,stdin);
	FILE *list=fopen("lista.bin","r");
	for(size_t i=0;i<sizeof(users);i++){
		if(!feof(list)){
			fread(&users[i],sizeof(users[i]),1,list);
			if(!strcmp(user.username,users[i].username) && !strcmp(user.password,users[i].password)){
				acess=true;
				printf("hai eseguito l acesso");
				getch();
				fclose(list);
				return;
			}
		}
	}
	acess=false;
	printf("user o password errati");
	getch();
	fclose(list);
	return;
	int r=optionf(1,1);
	if(r==-1){
		exit(0);
	}
	if(r==3){
		return;
	}
}
struct reg registr(){
	system("cls");
	struct reg user;
	printf("registra user: \n");
	fgets(user.username,50,stdin);
	printf("registra password: \n");
	fgets(user.password,50,stdin);
	printf("registrazione eseguita");
	FILE *list=fopen("lista.bin","a");
	fwrite(&user,sizeof(user),1,list);
	fclose(list);
	int r=optionf(1,1);
	if(r==-1){
		exit(0);
	}
	if(r==3){
		return;
	}
}
struct reg listusers(){
	system("cls");
	struct reg users[100];
	FILE *list=fopen("lista.bin","r");
	for(size_t i=0;i<sizeof(users);i++){
		if(fread(&users[i],sizeof(users[i]),1,list)){
			printf("%s",users[i].username);
		}
	}
	fclose(list);
	int r=optionf(1,1);
	if(r==-1){
		exit(0);
	}
	if(r==3){
		return;
	}
}
int main(){
	bool acess=false;
	while(!acess){
		int r=menu();
		if(r==1){
			login(acess);
		}
		if(r==2){
			registr();
		}
		if(r==3){
			listusers();
		}
	}		
}
