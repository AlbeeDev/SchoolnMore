#include<stdio.h>
#include<string.h>
int main(){
	int intransitivo=0,index;
	char * intransitivi[]={"nuotare","camminare","andare","arrivare","avanzare","entrare","innamorare","capitare"};
	size_t n=sizeof(intransitivi)/sizeof(intransitivi[0]);
	char verbo[20],presente[20],passatopr[20];
	fgets(verbo,20,stdin);
	if(verbo[strlen(verbo)-4]!='a' || verbo[strlen(verbo)-3]!='r' || verbo[strlen(verbo)-2]!='e'){
		printf("verbo non è di prima coniugazione");
	}
	else{
		if(verbo[strlen(verbo)-1]=='\n')
                verbo[strlen(verbo)-1]='\0';
		for(size_t i=0;i<n-1;i++){
			if(strcmp(verbo,intransitivi[i])==0){
				intransitivo=1;
				index=i;
			}
		}
		if(intransitivo==1){
			printf("intransitivo\n");
			if(index==0 || index==1){
				for(size_t i=0;i<strlen(verbo)-3;i++){
				presente[i]=verbo[i];
				}
				presente[strlen(verbo)-3]='o';
				printf("%s\n",presente);
			
				passatopr[0]='h';
				passatopr[1]='o';
				passatopr[2]=' ';
				for(size_t i=0;i<strlen(verbo)-2;i++){
					passatopr[i+3]=verbo[i];
				}
				passatopr[strlen(verbo)+1]='t';
				passatopr[strlen(verbo)+2]='o';
				passatopr[strlen(verbo)+3]='\n';
				printf("%s\n",passatopr);
			}
			if(index==2){
				presente[0]='v';
				presente[1]='a';
				presente[2]='d';
				presente[3]='o';
				printf("%s\n",presente);
			
				passatopr[0]='s';
				passatopr[1]='o';
				passatopr[2]='n';
				passatopr[3]='o';
				passatopr[4]=' ';
				for(size_t i=0;i<strlen(verbo)-2;i++){
					passatopr[i+5]=verbo[i];
				}
				passatopr[strlen(verbo)+3]='t';
				passatopr[strlen(verbo)+4]='o';
				passatopr[strlen(verbo)+5]='\n';
				printf("%s\n",passatopr);
			}
			if(index>2){
				for(size_t i=0;i<strlen(verbo)-3;i++){
				presente[i]=verbo[i];
				}	
				presente[strlen(verbo)-3]='o';
				printf("%s\n",presente);
			
				passatopr[0]='s';
				passatopr[1]='o';
				passatopr[2]='n';
				passatopr[3]='o';
				passatopr[4]=' ';
				for(size_t i=0;i<strlen(verbo)-2;i++){
					passatopr[i+5]=verbo[i];
				}
				passatopr[strlen(verbo)+3]='t';
				passatopr[strlen(verbo)+4]='o';
				passatopr[strlen(verbo)+5]='\n';
				printf("%s\n",passatopr);
			}	
		}
		if(intransitivo==0){
			printf("transitivo\n");
			for(size_t i=0;i<strlen(verbo)-3;i++){
				presente[i]=verbo[i];
			}
			presente[strlen(verbo)-3]='o';
			printf("%s\n",presente);
			
			passatopr[0]='h';
			passatopr[1]='o';
			passatopr[2]=' ';
			for(size_t i=0;i<strlen(verbo)-2;i++){
				passatopr[i+3]=verbo[i];
			}
			passatopr[strlen(verbo)+1]='t';
			passatopr[strlen(verbo)+2]='o';
			passatopr[strlen(verbo)+3]='\n';
			printf("%s\n",passatopr);
		}
	}
}
