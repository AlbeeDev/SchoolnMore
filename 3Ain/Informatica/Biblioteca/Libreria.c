#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
#include<conio.h>
#include<time.h>
#include<windows.h>
void gotoxy(short c, short r) {
	if (c>0 && r>0) {
		COORD CursorPosition = { c-1, r-1 };
		HANDLE hOut = GetStdHandle(STD_OUTPUT_HANDLE);
		SetConsoleCursorPosition(hOut, CursorPosition);
	}
}
void errorf(void){
	system("cls");
	printf("this function doesnt work");
	exit(0);
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

int searchcopy(void){
	system("cls");
	int dispcount=0,bcount=1;
	char str[200],buffer1[200],buffer2[200],buffer3[200],buffer4[200];
	printf("Cerca una copia per titolo: \n");
	fgets(str,200,stdin);
	for(size_t i=0;i<strlen(str);i++){
		if(str[i]==' '){
			str[i]='_';
		}
	}
	FILE *fcopie;
	fcopie= fopen("copie.txt","r");
	if(fcopie!=NULL){
		int x=3;
		while(!feof(fcopie)){
			fgets(buffer1,200,fcopie);
			fgets(buffer2,200,fcopie);
			fgets(buffer3,200,fcopie);
			fgets(buffer4,200,fcopie);
			if(!strcmp(buffer4,str)){
				gotoxy(1,x);
				for(size_t i=0;i<strlen(buffer1);i++){
					if(buffer1[i]=='_'){
						buffer1[i]=' ';
					}
				}
				printf("%s",buffer1);
				gotoxy(20,x);
				for(size_t i=0;i<strlen(buffer2);i++){
					if(buffer2[i]=='_'){
						buffer2[i]=' ';
					}
				}
				printf("%s",buffer2);
				gotoxy(40,x);
				for(size_t i=0;i<strlen(buffer3);i++){
					if(buffer3[i]=='_'){
						buffer3[i]=' ';
					}
				}
				printf("%s",buffer3);
				gotoxy(80,x);
				for(size_t i=0;i<strlen(buffer4);i++){
					if(buffer4[i]=='_'){
						buffer4[i]=' ';
					}
				}
				printf("%s",buffer4);
				dispcount++;
				x++;
			}
		}
		if(!dispcount){
			printf("nessuna copia trovata con titolo - %s",str);
		}
		while(1){
			int r=optionf(0,0);
			if(r==-1){
				exit(0);
			}
			if(r==3){
				return 1;
			}
		}
		fclose(fcopie);
	}
	return 0;
}
void loadcopypage(int page){
	system("cls");
	int startpos=(20*(page-1))+1;
	int endpos=startpos+20;
	FILE *fcopie;
	fcopie= fopen("copie.txt","r");
	if(fcopie!=NULL){
		int count=0,lwc=1,rwc=0,rx=1;
		bool print=false;
		while(!feof(fcopie)){
			char buffer[200];
			fgets(buffer,200,fcopie);
			buffer[strlen(buffer)-1]=0;
			if(lwc==5){
				lwc=1;
			}
			if((lwc+3)%4==0){
				rwc++;
			}
			if(rwc==startpos){
				print=true;
			}
			if(rwc==endpos){
				print=false;
			}
			if(print){
				if(count>2){
					gotoxy((count*20)+20,rx);
				}
				else{
					gotoxy(count*20,rx);
				}
				
				for(size_t i=0;i<sizeof(buffer);i++){
					if(buffer[i]=='_'){
						buffer[i]=' ';
					}
				}
				printf("%s ",buffer);
				
				if(count==3){
					printf("\n");
					count=0;
					rx++;
				}
				else{
					count++;
				}
			}
			lwc++;
		}
		fclose(fcopie);
	}
	else{
		fclose(fcopie);
	}
}
int viewcopy(void){
	system("cls");
	FILE *fcopie;
	fcopie= fopen("copie.txt","r");
	if(fcopie!=NULL){
		int count=0,rx=1;
		while(!feof(fcopie)){
			char buffer[200];
			fgets(buffer,200,fcopie);
			buffer[strlen(buffer)-1]=0;
			if(!strcmp(buffer,"21")){
				break;
			}
			if(count>2){
				gotoxy((count*20)+20,rx);
			}
			else{
				gotoxy(count*20,rx);
			}
			for(size_t i=0;i<sizeof(buffer);i++){
				if(buffer[i]=='_'){
					buffer[i]=' ';
				}
			}
			printf("%s ",buffer);
			if(count==3){
				printf("\n");
				count=0;
				rx++;
			}
			else{
				count++;
			}
		}
		fclose(fcopie);
	}
	else{
		fclose(fcopie);
	}
	int page=1;
	while(1){
		int r=optionf(page,6);
		if(r==-1){
			exit(0);
		}
		if(r==3){
			system("cls");
			return 1;
		}
		if(r==0){
			searchcopy();
		}
		if(r==1){
			page-=1;
		}
		if(r==2){
			page+=1;
		}
		loadcopypage(page);
	}
	return 0;
}
int viewstudent(void){
	system("cls");
	FILE *fstud;
	fstud=fopen("studenti.txt","r");
	if(fstud!=NULL){
		int count=0,rx=1;
		while(!feof(fstud)){
			char buffer[50];
			fgets(buffer,50,fstud);
			if(buffer[0]=='/'){
				strcpy(buffer,"N/D\n");
			}
			gotoxy(count*15,rx);
			printf("%s",buffer);
			if(count==5){
				count=0;
				rx++;
			}
			else{
				count++;
			}
		}
		fclose(fstud);
	}
	else{
		fclose(fstud);
	}
	while(1){
		int r=optionf(0,0);
		if(r==-1){
			exit(0);
		}
		if(r==3){
			system("cls");
			return 1;
		}
	}
	return 0;
}
struct Date {
	int year;
	int month;
	int day;
};
struct Date makeDate(int year, int month, int day) {
	struct Date date = { .year=year, .month=month, .day=day, };
	return date;
}
int getYear(struct Date date) {
	return date.year;
}
int getMonth(struct Date date) {
	return date.month;
}
int getDay(struct Date date) {
	return date.day;
}
int getMonthsNumber(struct Date d1, struct Date d2)
{
	return (d2.year-d1.year)*12 + (d2.month-d1.month) - (d1.day>d2.day);
}
void printDate(struct Date date) {
	printf("%04u/%02u/%02u", date.year, date.month, date.day);
}
struct Date getToday()
{
	time_t currentTime;
	time(&currentTime);
	struct tm *localTime = localtime(&currentTime);
	char str[11];
	strftime(str, sizeof(str), "%Y/%m/%d", localTime);
	int year, month, day;
	sscanf(str, "%i/%i/%i", &year, &month, &day);
	return makeDate(year, month, day);
}
struct Date borrowcopy(){
	system("cls");
	struct Date d1,d2;
	char studente[50],cognome[50],nome[50],buffer[200],copia[200],signb[5],sign[5];
	char *year,*month,*day;
	unsigned valid=1,y1,m1,da1;
	int pos;
	while(valid!=0){
		gotoxy(1,1);
		printf("inserisci il nome della copia: \n");
		printf("                                 ");
		gotoxy(1,2);
		fgets(copia,200,stdin);
		copia[strlen(copia)-1]='\0';
		for(size_t i=0;i<strlen(copia);i++){
			if(copia[i]==' '){
				copia[i]='_';
			}
		}
		FILE *fcopie=fopen("copie.txt","r");
		while(!feof(fcopie)){
			fgets(signb,5,fcopie);
			for(int i=0;i<3;i++){
				fgets(buffer,200,fcopie);
			}
			buffer[strlen(buffer)-1]='\0';
			if(!strcmp(buffer,copia)){
				valid=0;
				sprintf(sign,"%s",signb);
			}
		}
		fclose(fcopie);
		if(valid==1){
			printf("copia non presente nella libreria");
		}
		if(valid==0){
			printf("                                 ");
		}
	}
	
	valid=1;
	while(valid!=0){
		gotoxy(1,4);
		printf("Nome e cognome dello studente: \n");
		printf("                                 ");
		gotoxy(1,5);
		fgets(studente,50,stdin);
		sscanf(studente,"%s %s",nome,cognome);
		FILE *fs=fopen("studenti.txt","r");
		fseek(fs,0,SEEK_SET);
		while(!feof(fs)){
			fgets(buffer,200,fs);
			buffer[strlen(buffer)-1]='\0';
			if(!strcmp(buffer,nome)){
				fgets(buffer,200,fs);
				buffer[strlen(buffer)-1]='\0';
				if(!strcmp(buffer,cognome)){
					fgets(buffer,200,fs);
					buffer[strlen(buffer)-1]='\0';
					if(strcmp(buffer,"/")!=0){
						year=strtok(buffer,"-");
						month=strtok(NULL,"-");
						day=strtok(NULL,"-");
						d1=makeDate(atoi(year),atoi(month),atoi(day));
						d2=getToday();
						if(d1.year<d2.year){
							valid=0;
						}
						if(d1.year==d2.year){
							if(d1.month<d2.month){
								valid=0;
							}
							if(d1.month==d2.month){
								if(d1.day>d1.day){
									valid=1;
								}
								else{
									valid=0;
								}
							}
							else{
								valid=1;
							}
						}
					}
					if(!strcmp(buffer,"/") || valid==0){
						pos=ftell(fs);
						fgets(buffer,200,fs);
						buffer[strlen(buffer)-1]='\0';
						if(!strcmp(buffer,"/")){
							fgets(buffer,200,fs);
							valid=0;	
						}
						else{
							valid=3;
						}
					}
					else{
						valid=2;
					}
				}
			}
		}
		if(valid==1){
			printf("studente non registrato                   ");
		}
		if(valid==2){
			printf("studente non puo prendere libri al momento");
		}
		if(valid==3){
			printf("studente ha gia un libro in prestito      ");
		}
		if(valid==0){
			fclose(fs);
			fs=fopen("studenti.txt","a");
			rewind(fs);
			fseek(fs,0,SEEK_SET);
			fprintf(fs,"%i-%i-%i\n",d2.year,d2.month,d2.day);
			fprintf(fs,"%s",sign);
			printf("prestito eseguito                         ");
		}
		fclose(fs);
	}
	while(1){
		int r=optionf(0,0);
		if(r==-1){
			exit(0);
		}
		if(r==3){
			system("cls");
			return;
		}
	}
}
void addcopy(void){
	system("cls");
	char titolo[200],autore[50],isbm[15],buffer[200];
	int sign=0;
	FILE* fcopie;
	fcopie=fopen("copie.txt","r");
	int rf=1;
	while(!feof(fcopie)){
		fgets(buffer,200,fcopie);
		if(rf==1){
			if(atoi(buffer)>=1){
				sign=atoi(buffer)+1;
			}
		}
		rf++;		
		if(rf==5){
			rf=1;
		}
	}
	fclose(fcopie);
	gotoxy(0,1);
	printf("%i",sign);
	gotoxy(1,5);
	printf("inserisci isbm:   ");
	fgets(isbm,15,stdin);
	if(isbm[strlen(isbm)-1]=='\n'){
		isbm[strlen(isbm)-1]='\0';
	}
	gotoxy(20,1);
	printf("%s",isbm);
	gotoxy(1,8);
	printf("inserisci autore: ");
	fgets(autore,50,stdin);
	for(size_t i=0;i<strlen(autore);i++){
		if(autore[i]==' '){
			autore[i]='_';
		}
	}
	if(autore[strlen(autore)-1]=='\n'){
		autore[strlen(autore)-1]='\0';
	}
	gotoxy(40,1);
	printf("%s",autore);
	gotoxy(1,11);
	printf("inserisci titolo: ");
	fgets(titolo,200,stdin);
	for(size_t i=0;i<strlen(titolo);i++){
		if(titolo[i]==' '){
			titolo[i]='_';
		}
	}
	if(titolo[strlen(titolo)-1]=='\n'){
		titolo[strlen(titolo)-1]='\0';
	}
	gotoxy(80,1);
	printf("%s",titolo);
	fcopie=fopen("copie.txt","a");
	fprintf(fcopie,"\n%i\n%s\n%s\n%s",sign,isbm,autore,titolo);
	fclose(fcopie);
	system("cls");
}
int menu(void){
	int x=1;
	int maxopz=5;
	while(1){
		gotoxy(1,x);
		printf(">>");
		gotoxy(5,1);
		printf("Visualizza copie");
		gotoxy(5,2);
		printf("Elenco studenti");
		gotoxy(5,3);
		printf("Prestito di una copia");
		gotoxy(5,4);
		printf("Aggiungi una copia");
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
			if(x==1){
				viewcopy();
			}
			if(x==2){
				viewstudent();	
			}
			if(x==3){
				borrowcopy();	
			}
			if(x==4){
				addcopy();	
			}
		}
	}
	return 0;
}
int main(){
	menu();
}
