#include<stdio.h>
#include<string.h>
#include<ctype.h>
#include<conio.h>
void translate(char parola[50],char piumeno[50]){
	for(size_t i=0;i<strlen(parola);i++){
		if(parola[i]==97 || parola[i]==101 || parola[i]==105 || parola[i]==111 || parola[i]==117){
			piumeno[i]=43;
		}
		else{
			piumeno[i]=45;
		}
	}
}
void cmp(char parola[50],char piumeno[50],char let){
	for(size_t i=0;i<strlen(parola);i++){
		if(parola[i]==let){
			piumeno[i]=let;
		}
	}
}
int checkwin(char parola[50],char piumeno[50],int x){
	int sum=0;
	for(size_t i=0;i<strlen(piumeno);i++){
		if(parola[i]==piumeno[i]){
			sum+=1;
		}
	}
	if(sum==strlen(parola)){
		return 0;
	}
	else{
		return 1;	
	}
}
int main(){
	char parola[]="segreto";
	char piumeno[strlen(parola)];
	translate(parola,piumeno);
	printf("%s\n",piumeno);
	int j,x=1;
	while(x==1){
	char let;
	scanf("%c",&let);
	cmp(parola,piumeno,let);
	printf("%s\n",piumeno);
	checkwin(parola,piumeno,x);
	}
}
