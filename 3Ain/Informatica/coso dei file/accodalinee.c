#include<stdio.h>
#include<string.h>
int main(){
	char file[50];
	char strw[]="--LINEA TROPPO LUNGA--\n";
	char str1[100];
	printf("inserisci nome file: ");
	scanf("%s",file);
	strcat(file,".txt");
	FILE *file1;
	FILE *risultato;
	file1=fopen(file,"r");
	risultato=fopen("risultato.txt","w");
	while(fgets(str1,100,file1)!=NULL){
		if(strlen(str1)>20){
			strcpy(str1,strw);
		}
		fputs(str1,risultato);
	}
	fclose(file1);
	fclose(risultato);
}
