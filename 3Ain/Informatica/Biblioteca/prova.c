#include<stdio.h>
#include<string.h>
typedef struct coso{
	char citta[10+1];
	int num;
};
int main(){
	FILE *fr = fopen("prova.txt","rb");
	if(fr!=NULL){
		FILE *fw=fopen("prova2.txt","wb");
		if(fw!=NULL){
			struct coso r;
			struct coso o[3];
			char str[10+1],buffer[5+1];
			int n,i=0;
			while(i<3){
				fread(buffer,sizeof(char),sizeof(buffer),fr);
				fread(&r.num,sizeof(int),1,fr);
				strcpy(r.citta,buffer);
				fwrite(r.citta,sizeof(char),strlen(r.citta),fw);
				fwrite(&r.num,sizeof(int),1,fw);
				i++;
			}
			fclose(fw);
		}
		else{
			fclose(fw);
		}
		fclose(fr);
	}
	else{
		printf("file didnt open");
		fclose(fr);
	}
}
