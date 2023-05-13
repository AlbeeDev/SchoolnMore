#include<stdio.h>
#include<ctype.h>
#include<string.h>
void ES2(char name[50],char surname[50]){
	gets(name);
	gets(surname);
	for(size_t i=0;i<strlen(name);i++){
		if(islower(name[i])==2 && i==0){
			printf("%c", toupper(name[i]));
		}
		else{
			printf("%c", name[i]);
		}
	}
	for(size_t i=0;i<strlen(surname);i++){
		if(islower(surname[i])==2 && i==0){
			printf(" %c", toupper(surname[i]));
		}
		else{
			printf("%c", surname[i]);
		}
	}
}
void ES3(char str[50]){
	gets(str);
	printf("%s \n",strrev(str));
}
int main(){
	char str1[50]={0};
	char str2[50]={0};
	ES2(str1,str2);
	printf("\n");
	char str3[50]={0};
	ES3(str3);
}
