#include<stdio.h>
#include<stdlib.h>
typedef struct lista{
	int data;
	struct lista *next;
} lista;

void crea(int x,lista **list){
	lista *primoel=malloc(sizeof(lista));
	primoel->data=10;
	primoel->next=NULL;
	lista *temp=primoel;
	for(int i=0;i<x;i++){
		temp->next=malloc(sizeof(lista));
		temp=temp->next;
		temp->data=i*10+20;
		temp->next=NULL;
	}
	
	*list=primoel;
}
int lunghezzals(lista *list){
	int num=1;
	while(list->next!=NULL){
		list=list->next;
		num++;
	}
	return num;
}
int sommals(lista *list){
	int sum=list->data;
	while(list->next!=NULL){
		list=list->next;
		sum+=list->data;
	}
	return sum;
}
void insinpos(int val,int pos,lista **list){
	lista *elemento=malloc(sizeof(lista));
	elemento->data=val;
	lista *elprimero;
	lista *temp=*list;
	for(int i=0;i<pos;i++){
		if(i==pos-1){
			elprimero=temp;
			temp=temp->next;
		}
		else{
			temp=temp->next;
		}
		
	}
	elprimero->next=elemento;
	elemento->next=temp;
	
}
void insinord(int val,lista **list){
	lista *elemento=malloc(sizeof(lista));
	elemento->data=val;
	lista *elprima;
	lista *temp=*list;
	if(val<temp->data){
		*list=elemento;
		elemento->next=temp;
		return;
	}
	while(1){
		if(temp->next==NULL){
			temp->next=elemento;
			elemento->next=NULL;
			return;
		}
		if(val<temp->next->data){
			elprima=temp;
			temp=temp->next;
			break;	
		}
		temp=temp->next;
	}
	
	elprima->next=elemento;
	elemento->next=temp;
}
void cancellals(int val,lista **list){
	lista *temp=*list;
	while(temp->next!=NULL){
		if(val==temp->data){
			*list=temp->next;
			free(temp);
			temp=*list;
		}
		else break;
	}
	lista *canc;
	while(temp->next!=NULL){
		if(val==temp->next->data){
			canc=temp->next;
			temp->next=temp->next->next;
			free(canc);
			return;
		}
		else{
			temp=temp->next;
		}
	}
	if(val==temp->data){
		*list=NULL;
	}
}
void stampa(lista *temp){
	while(temp!=NULL){
		printf("%d\n",temp->data);
		temp=temp->next;
	}
}

int main(){
	
	lista *list=NULL;
	crea(10,&list);
	//insinpos(69,3,&list);
	//insinord(40,&list);
	//cancellals(10,&list);
	stampa(list);
	printf("lunghezza: %i\n", lunghezzals(list));
	printf("somma: %i\n", sommals(list));
}
