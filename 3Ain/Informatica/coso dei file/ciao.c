#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#define lung 100
//v=3 p=1 s=0
struct squadra{
	char nome[lung];
	unsigned score;
};
int ordsquadra(const void *x,const void *y){
	return strcmp(((struct squadra*)x)->nome,((struct squadra*)y)->nome);
}
int ordpunteggio(const void *x,const void *y){
	struct squadra*px =(struct squadra*)x; 
	struct squadra*py =(struct squadra*)y;
	if(px->score>py->score){
		return -1;
	}
	else if(px->score<py->score){
		return 1;
	}else{
		return strcmp(px->nome,py->nome);
	}
}
int main(){
	FILE *partite,*classifica;
	struct squadra squadre[lung];
	size_t n=0;
	char team1[lung],team2[lung];
	unsigned scoreteam1,scoreteam2,punteggiot1,punteggiot2;
	size_t lungteam1,lungteam2;
	classifica=fopen("classifica.txt","r");
	if(classifica!=NULL){
		while(fscanf(classifica,"%s %u",squadre[n].nome,&squadre[n].score)==2){
			printf("%s %u\n",squadre[n].nome,squadre[n].score);
			n++;
		}
		fclose(classifica);
	}
	printf("\n");
	qsort(squadre,n,sizeof(struct squadra),ordsquadra);
	for(size_t j=0;j<n;j++){
		printf("%s %u\n",squadre[j].nome,squadre[j].score);	
	}
	partite=fopen("partite.txt","r");
	if(partite!=NULL){
		while(fscanf(partite,"%s %s %u-%u",team1,team2,&scoreteam1,&scoreteam2)==4){
			printf("%s %s: %u-%u\n",team1,team2,scoreteam1,scoreteam2);
			if(scoreteam1>scoreteam2){
				punteggiot1=3;
				punteggiot2=0;
			}else if(scoreteam2>scoreteam1){
				punteggiot1=0;
				punteggiot2=3;
			}
			else{
				punteggiot1=1;
				punteggiot2=1;
			}
			struct squadra*x=bsearch(team1,squadre,n,sizeof(struct squadra),ordsquadra);
			if(x!=NULL){
				x->score+=punteggiot1;
			}
			x=bsearch(team2,squadre,n,sizeof(struct squadra),ordsquadra);
			if(x!=NULL){
				x->score+=punteggiot2;
			}
			printf("%s:%u\n%s:%u\n",team1,punteggiot1,team2,punteggiot2);
		}	
		printf("\n");
		for(size_t j=0;j<n;j++){
		printf("%s %u\n",squadre[j].nome,squadre[j].score);	
		}
		qsort(squadre,n,sizeof(struct squadra),ordpunteggio);
		printf("\n");
		for(size_t j=0;j<n;j++){
		printf("%s %u\n",squadre[j].nome,squadre[j].score);	
		}	
		fclose(partite);
	}
	classifica=fopen("classifica.txt","w");
	if(classifica!=NULL){
		for(size_t j=0;j<n;j++){
			fprintf(classifica,"%-10s %3u\n",squadre[j].nome,squadre[j].score);	
		}
		fclose(classifica);
	}
	return 0;
	
}
