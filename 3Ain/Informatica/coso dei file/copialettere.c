#include<stdio.h>
#include<string.h>
int main(){
	char file[50];
	char let;
	printf("inserisci nome file: ");
	scanf("%s",file);
	strcat(file,".txt");
	FILE *file1;
	FILE *lettere;
	FILE *altcar;
	file1=fopen(file,"r");
	lettere=fopen("lettere.txt","w");
	altcar=fopen("altri_car.txt","w");
	while(feof(file1)==0){
		let=fgetc(file1);
		if(isalpha(let)){
			fputc(let,lettere);
		}
		else{
			fputc(let,altcar);
		}
	}
	fclose(file1);
	fclose(lettere);
	fclose(altcar);		
}
