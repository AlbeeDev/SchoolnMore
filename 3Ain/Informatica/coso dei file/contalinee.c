#include<stdio.h>
#include<string.h>
int contalinee(FILE file[],char str[]){
	char str1[100];
	unsigned count=0;
	while(fgets(str1,100,file)!=NULL){
			
		if(strstr(str1,str)!=NULL){
			count++;
		}
	}
	if(file==NULL){
		return -1;
	}
	if(ferror(file)){
		return -1;
	}
	return count;
}
int main(){
	char str[]="BIANCO";
	FILE *file1;
	file1=fopen("test.txt","r");
	printf("%i",contalinee(file1,str));
	fclose(file1);
}
