#include<stdio.h>
#include<string.h>
#include<ctype.h>
int main(){
	char let;
	FILE *file1;
	FILE *file2;
	file1=fopen("test.txt","r");
	file2=fopen("test2.txt","w");
	while(feof(file1)==0){
		let=fgetc(file1);
		if(isalpha(let)){
			if(isupper(let)){
				let=tolower(let);
			}
			if(islower(let)){
				let=toupper(let);
			}
		}
		fputc(let,file2);	
	}
	fclose(file1);
	fclose(file2);		
}
