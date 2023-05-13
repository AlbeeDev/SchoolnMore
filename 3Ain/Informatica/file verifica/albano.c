#include<stdio.h>
void es1(void){
	char parola1[100];
	char parola2[100];
	int pcount=0;
	printf("inserisci parola da cercare: \n");
	scanf("%s",&parola1);
	FILE *ricerca;
	ricerca=fopen("ricerca.txt","r");
	if(ricerca!=NULL){
		while(fscanf(ricerca,"%s",&parola2)==1){
			if(!strcmp(parola1,parola2)){
				pcount++;
			}	
		}
	}
	fclose(ricerca);
	printf("%i",pcount);
}
void es2(void){
	float temp;
	char citta[100];
	char tipotemp;
	FILE *tempfile,*tempmod;
	
	tempmod=fopen("temperaturemod.txt","w");
	tempfile=fopen("temperature.txt","r");
	if(tempfile!=NULL && tempmod!=NULL){
		while(fscanf(tempfile,"%s &f &c",&citta,&temp,&tipotemp)==3){
			if(tipotemp=='c'){
				fprintf(tempmod,"%s &.1f &c\n",citta,temp,tipotemp);
			}
			else{
				tipotemp='c';
				temp=(temp-32)*5.0/9.0;
				fprintf(tempmod,"%s &.1f &c\n",citta,temp,tipotemp);
			}
		}
	}
	fclose(tempmod);
	fclose(tempfile);
}
void es3(void){
	unsigned char hex;
	int count=0;
	FILE *faudio,*faudiomod;
	faudiomod=fopen("faudiomod.txt","w");
	faudio=fopen("U220ORIG.MID","r");
	if(faudio!=NULL){
		while(fscanf(faudio,"%c",&hex)){
			fprintf(faudiomod,"%c",hex);
			count++;
			if(count==16){
				fprintf(faudiomod,"\n");
				count=0;
			}
		}
	}
}
int main(){
	es1();
	es2();
	es3();
}
