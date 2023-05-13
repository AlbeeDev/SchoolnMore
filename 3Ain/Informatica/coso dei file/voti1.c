#include<stdio.h>
#include<string.h>
#define lung 50
struct studenti{
	char cognome[lung];
	char nome[lung];
	size_t N;
};
int main(){
	FILE *voti,*medie,*esiti;
	struct studenti studente[lung];
	size_t n=0;
	char str1[]="debito";
	char str2[]="promosso";
	voti=fopen("voti.txt","r");
	medie=fopen("medie.txt","w");
	esiti=fopen("esiti.txt","w");
	while(fscanf(voti,"%s %s %zu ",studente[n].cognome,studente[n].nome,&studente[n].N)==3){
		float media;
		float sum=0;
		float den=0;
		fprintf(medie,"%s %s ",studente[n].cognome,studente[n].nome);
		fprintf(esiti,"%s %s ",studente[n].cognome,studente[n].nome);
		for(size_t i=0;i<studente[n].N;i++){
			float voto;
			fscanf(voti,"%f ",&voto);
			den+=1.0;
			sum+=voto;
		}
		media=sum/den;
		fprintf(medie,"%.2f\n",media);
		if(media<6){
			fprintf(esiti,"%s\n",str1);
		}
		else{
			fprintf(esiti,"%s\n",str2);
		}
		n++;
	}
	fclose(voti);
	fclose(medie);
	fclose(esiti);
}
