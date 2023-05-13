/*
Un provveditorato agli studi vuole avere una registrazione di tutte le scuole della provincia e del numero di alunni di ogni scuola,
in modo da poter ottenere, dato il nome di una scuola, il numero dei suoi alunni, oppure l'elenco delle scuole con un 
numero di alunni inferiore o superiore ad un valore assegnato.

scrivere un programma per creare il file (o i file) con i nomi delle scuole ed il numero di alunni corrispondenti;

scrivere un programma che dato il nome di una scuola visualizzi il numero dei suoi alunni;

scrivere un programma che dato il numero di alunni, scriva l'elenco delle scuole con un numero di alunni inferiore al valore dato;

scrivere un programma che dato il numero di alunni, scriva l'elenco delle scuole con un numero di alunni maggiore o uguale al valore dato;

scrivere un programma unico che permetta di scegliere una delle richieste del punto 2 ed avere il risultato corrispondente.
*/

#include <stdio.h>
#include <limits.h>
#include<stdbool.h>
#include<stdlib.h>
#include<windows.h>
#define TEXT
struct scuole {
	char nomescuola[30+1];
	int numeroalunni;
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
			default:
				break;
		}
	}
}
int menu(int nopz){
	int x=1;
	gotoxy(2,x);
	printf(">>");
	gotoxy(5,1);
	printf("visualizza numero degli alunni di una scuola");
	gotoxy(5,2);
	printf("cerca le scuole con un numero di alunni inferiore a N");
	gotoxy(5,3);
	printf("cerca le scuole con un numero di alunni maggiore o uguale a N");
	int ret;
	while(1){
		ret=optionf(x,nopz);
		if(ret==0){
			system("cls");
			return x;
		}
		if(ret==1){
			x--;
			gotoxy(2,x+1);
			printf("  ");
			gotoxy(2,x);
			printf(">>");	
		}
		if(ret==2){
			x++;
			gotoxy(2,x-1);
			printf("  ");
			gotoxy(2,x);
			printf(">>");	
		}
	}
}
void func1(struct scuole s);
void func2(struct scuole s);
void func3(struct scuole s);

int main()
{
	// genero un file binario casuale
	struct scuole s;
#ifdef TEXT
	FILE *fw = fopen("scuole.txt", "w+t");
#else
	FILE *fw = fopen("scuole.bin", "w+b");
#endif
	if(fw)
	{
		for(int i=0; i<100; i++)
		{
			for(size_t k=0; k<sizeof(s.nomescuola); k++)
				s.nomescuola[k]=rand()%26+'A';
			s.nomescuola[5+rand()%sizeof(s.nomescuola)]='\0';
			s.numeroalunni = 500+rand()%(1200-500+1);
#ifdef TEXT
			fprintf(fw, "%s %i\n", s.nomescuola, s.numeroalunni);
#else
			fwrite(&s, sizeof(s), 1, fw);
#endif
		}
		fclose(fw);
		int x=menu(3);
		if(x==1){
			func1(s);
		}
		if(x==2){
			func2(s);
		}
		if(x==3){
			func3(s);
		}
	}
	return 0;
}

void func1(struct scuole s){
#ifdef TEXT
	FILE *fr = fopen("scuole.txt", "r+t");
#else
	FILE *fr = fopen("scuole.bin", "r+b");
#endif
	if(fr)
	{
	// cerco il numero alunni dato il nome della scuola
		rewind(fr);
		int max = INT_MIN;
		char nomescuoladacercare[30+1];
		printf("nome scuola: ");
		fgets(nomescuoladacercare, sizeof(nomescuoladacercare), stdin);
		if(strlen(nomescuoladacercare)>0 && nomescuoladacercare[strlen(nomescuoladacercare)-1]=='\n')
			nomescuoladacercare[strlen(nomescuoladacercare)-1] = '\0';
#ifdef TEXT
		while(fscanf(fr, "%s %i", s.nomescuola, &s.numeroalunni)>0)
#else
		while(fread(&s, sizeof(s), 1, fw)>0)
#endif
		{
			if(strcmp(nomescuoladacercare, s.nomescuola)==0)
				printf("%s %i\n", s.nomescuola, s.numeroalunni);
		}
		fclose(fr);
	}
}
void func2(struct scuole s){
#ifdef TEXT
	FILE *fr = fopen("scuole.txt", "r+t");
#else
	FILE *fr = fopen("scuole.bin", "r+b");
#endif
	if(fr)
	{
	//cerco il nome delle scuole con un minor numero di alunni rispetto ad un dato numero di alunni
		rewind(fr);
		int nalunni;
		printf("N: ");
		scanf("%i",&nalunni);
#ifdef TEXT
		while(fscanf(fr, "%s %i", s.nomescuola, &s.numeroalunni)>0)
#else
		while(fread(&s, sizeof(s), 1, fr)>0)
#endif		
		{
			if(s.numeroalunni<nalunni)
				printf("%s\n",s.nomescuola);
		}
		fclose(fr);
	}
}
void func3(struct scuole s){
#ifdef TEXT
	FILE *fr = fopen("scuole.txt", "r+t");
#else
	FILE *fr = fopen("scuole.bin", "r+b");
#endif
	if(fr)
	{
	//cerco il nome delle scuole con un maggior o uguale numero di alunni rispetto ad un dato numero di alunni
		rewind(fr);
		int nalunni;
		printf("N: ");
		scanf("%i",&nalunni);
#ifdef TEXT
		while(fscanf(fr, "%s %i", s.nomescuola, &s.numeroalunni)>0)
#else
		while(fread(&s, sizeof(s), 1, fr)>0)
#endif		
		{
			if(s.numeroalunni>=nalunni)
				printf("%s\n",s.nomescuola);
		}
		fclose(fr);
	}
}
