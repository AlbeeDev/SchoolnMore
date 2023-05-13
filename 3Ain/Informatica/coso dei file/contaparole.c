#include<stdio.h>
#include<string.h>
int main(){
	char file[50];
	unsigned count;
	printf("inserisci nome file: ");
	scanf("%s",file);
	strcat(file,".txt");
	FILE *file1;
	file1=fopen(file,"r");
	count=0;
	while(feof(file1)==0){
		if(fgetc(file1)==32){
			count++;	
		}
	}		
	printf("numero di parole: %i",count+1);
	fclose(file1);
}
