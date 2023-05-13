#include<stdio.h>
#include<string.h>
#include<ctype.h>
void e1(char nome[15],char cognome[20]){
	nome[0]=toupper(nome[0]);
	cognome[0]=toupper(cognome[0]);
	char str[35];
	int k=0;
	for(size_t i=0;i<strlen(nome)-1;i++){
		str[k]=nome[i];
		k++;
	}
	for(size_t i=0;i<strlen(cognome)-1;i++){
		str[k]=cognome[i];
		k++;
	}
	printf("%s\n",str);
}
void e2(char str[50],char str2[50]){
	size_t len=strlen(str);
	int k=0;
	for(size_t i=0;i<len;i++){
		if(str[i]=='a' || str[i]=='e' || str[i]=='i' || str[i]=='o' || str[i]=='u'){
			str2[k]=str[i];
			k++;
		}
	}
	for(size_t i=0;i<len;i++){
		if(isalpha(str[i]) && str[i]!='a' && str[i]!='e' && str[i]!='i' && str[i]!='o' && str[i]!='u'){
			str2[k]=str[i];
			k++;
		}
	}
	printf("%s",str2);
}
int main(){
	char nome[15];
	char cognome[20];
	fgets(nome,15,stdin);
	fgets(cognome,20,stdin);
	e1(nome,cognome);
	
	char str[50];
	char str2[50];
	fgets(str,50,stdin);
	e2(str,str2);
}
