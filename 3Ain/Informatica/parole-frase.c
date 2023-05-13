#include<stdio.h>
#include<string.h>
#include<ctype.h>
int main(){
	int count=1;
	char string[]="ciao mondo";
	for(size_t i=0;i<strlen(string);i++){
		if(string[i]==32){
			count+=1;
		}
	}
	printf("%i\n",count);
	count=0;
	for(size_t i=0;i<strlen(string);i++){
		if(string[i]==32){
			printf("\n");
		}
		else{
			printf("%c",string[i]);
		}
	}
}
