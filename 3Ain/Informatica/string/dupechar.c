#include <stdio.h>
#include <string.h>
#include <ctype.h>
int main(){
	char input[50];
	char str[50];
	fgets(input,50,stdin);
	int x=0;
	while(x==0){
		int y=0;
		for(size_t i=0;i<strlen(input);i++){
			if(input[i]==input[i+1]){
				input[i]=' ';
				input[i+1]=' ';
			}
		}
		for(size_t j=0;j<strlen(input);j++){
			if(input[j]==' ' && input[j+1]==' '){
			y+=2;	
			}
			if(isalpha(input[j+y])){
				str[j]=input[j+y];	
			}
			else{
				break;
			}	
		}
		for(size_t j=0;j<strlen(str)-y+1;j++){
			input[j]=str[j];
		}
		
		for(size_t k=0;k<strlen(input);k++){
			x=1;
			if(input[k]==input[k+1]){
				x=0;
			}
		}
	}
	for(size_t i=0;i<strlen(str);i++){
		printf("%c",input[i]);
	}
}
