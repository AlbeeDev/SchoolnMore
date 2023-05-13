/*

int fatt(int n){
	int result = 1;
	for(int i=1;i<n;i++)
		result=result*i;
	return result;	
}

int fatt(int n){
	if(n==0) return 1;
	return n*fatt(n-1);
}

*/



#include<stdlib.h>
#include <stdio.h>
#include<stdbool.h>

struct Lista {
	int data;
	struct Lista *next;
};
struct Lista *primoEL;

struct Lista* newList(int a, struct Lista* primoEL){
	struct Lista* el = malloc(sizeof(struct Lista));
	el->data = a;
	el->next = primoEL;
	return el;
}

void stampa(struct Lista *temp){
	while(temp!=NULL){//i<100
		printf("%d ",temp->data);//arr[i]
		temp = temp->next;//i = i + 1
	}	
	printf("\n");
}

void stampaR(struct Lista *temp){
	if(temp==NULL) return;
	printf("%d ", temp->data);
	stampaR(temp->next);
}

typedef struct Lista* lst; 

void crea2(int num, lst *lista){	
	if(num==0) return;
	
	primoEL = malloc(sizeof(struct Lista));
	primoEL->data = 10;//(*primoEL).data = 10
	primoEL->next = NULL;

	struct Lista *temp = primoEL;
	int i;
	for(i=0;i<num-1;i++){
		temp->next = malloc(sizeof(struct Lista));
		temp = temp->next;
		temp->data = i*10+20;
		temp->next = NULL;
	}
	
	*lista = primoEL;
}

struct Lista* creaR(int num, int cont){
	if(num==0) return NULL;
	return newList(cont, creaR(num-1, cont+10));
}

struct Lista* crea(int num){
	if(num==0) return NULL;
	
	primoEL = malloc(sizeof(struct Lista));
	primoEL->data = 10;//(*primoEL).data = 10
	primoEL->next = NULL;

	struct Lista *temp = primoEL;
	int i;
	for(i=0;i<num-1;i++){
		temp->next = malloc(sizeof(struct Lista));
		temp = temp->next;
		temp->data = i*10+20;
		temp->next = NULL;
	}
	return primoEL;
}



struct Lista* insInTesta(int a, struct Lista* primoEL){
	struct Lista* el = malloc(sizeof(struct Lista));
	el->data = a;
	el->next = primoEL;
	return el;
}

void insInTesta2(int a, struct Lista** primoEL){
	struct Lista* el = malloc(sizeof(struct Lista));
	el->data = a;
	el->next = *primoEL;
	*primoEL = el;
}

struct Lista* insInPos(int a, int pos, struct Lista* primoEL){
	struct Lista* el = malloc(sizeof(struct Lista));
	el->data = a;
	el->next = NULL;
	/*
	if(pos==0) {
		el->next = primoEL;
		return el;
	}
	*/
	struct Lista* t = primoEL;
	int i;
	for(i=0;i<pos-1 && t->next!=NULL;i++){
		t = t->next;
	}
	/*
	if(t->next==NULL){
		t->next = el;
		return primoEL;
	}
	*/
	el->next = t->next;
	t->next = el;
	
	return primoEL;
}

/*
	supponiamo che la lista in ingresso sià già 
	ordinata in maniera crescente
	10 20 30 40 50
*/

struct Lista* insOrdR(int a, struct Lista* primoEL){
	if(primoEL==NULL) return insInTesta(a, NULL);
	if(a<primoEL->data) return insInTesta(a, primoEL);
	return insInTesta(primoEL->data,insOrdR(a,primoEL->next));
}

struct Lista* insOrd(int a, struct Lista* primoEL){
	struct Lista* el = malloc(sizeof(struct Lista));
	el->data = a;
	el->next = NULL;
	
	if(a<primoEL->data){
		el->next = primoEL;
		return el;
	}

	struct Lista* t = primoEL;
	int i;
	for(i=0;t->next!=NULL && t->next->data<a;i++){
		t = t->next;
	}
	
	if(t->next==NULL){
		t->next = el;
		return primoEL;	
	}
	
	el->next = t->next;
	t->next = el;
	
	return primoEL;
}

int lunghezza(struct Lista *l){
	int i = 0;
	while(l!=NULL){
		i++;
		l = l->next;
	}
	return i;
}

int sommaValori(struct Lista *l){
	int i = 0, somma = 0;
	while(l!=NULL){
		somma=somma+l->data;
		l = l->next;
	}
	return somma;
}

struct Lista *cancella(int val, struct Lista *l){
	struct Lista *daCancellare;
	if(l->data==val){
		daCancellare = l;
		l = l->next;
		free(daCancellare);
		return l;
	}
	
	struct Lista *temp = l;
	while(temp->next!=NULL && temp->next->data!=val)
		temp = temp->next;
		
	if(temp->next==NULL) return l;
		
	daCancellare = temp->next;
	temp->next = temp->next->next;
	free(daCancellare);
	
	return l;
}


struct Lista *cancellaTutti(int val, struct Lista *l){
	if(l==NULL) return NULL;
	struct Lista *daCancellare;
	while(l->data==val){
		daCancellare = l;
		l = l->next;
		free(daCancellare);
	}
	if(l==NULL) return NULL;
	struct Lista *temp = l;
	while(temp->next!=NULL){
		if(temp->next->data==val){
			daCancellare = temp->next;
			temp->next = temp->next->next;
			free(daCancellare);
		}else
			temp = temp->next;
	}
			
	return l;
}

struct Lista *cancellaTuttiR(int val, struct Lista *l){
	if(l==NULL) return NULL;
	if(l->data==val) return cancellaTuttiR(val,l->next);
	return newList(l->data, cancellaTuttiR(val,l->next));
}

struct Lista* insInPosR(int a, int pos, struct Lista* l){
	if(l==NULL) return newList(a, NULL);
	if(pos==0) return newList(a, l);
	return newList(l->data, insInPosR(a, pos-1, l->next));
}

void stampaInversa1(struct Lista*l){
	/*
	int lung = lunghezza(l);
	int arr[lung];
	int i=lung-1;
	while(l!=NULL){
		arr[i]=l->data;
		l = l->next;
		i--;
	}
	*/
	/*
	struct Lista* inv = NULL;
	while(l!=NULL){
		inv = insInTesta(l->data,inv);
		l = l->next;
	}
	*/
	int lung = lunghezza(l);
	for(int j=0;j<lung;j++){
		struct Lista* temp = l;
		for(int i=0;i<lung-j;i++){
			temp = temp->next;
		}
		printf("%d", temp->data);
	}
}
void stampaInversaR(struct Lista*l){
	if(l==NULL) return;
	stampaInversaR(l->next);
	printf("%d", l->data);
}

int maxR(struct Lista*l){
	if(l==NULL) return INT_MIN;
	
	if(l->data>maxR(l->next)) return l->data;
	return maxR(l->next);
	/*
	int a = l->data;
	int b = maxR(l->next);
	if(a>b) return a;
	return b;
	*/
}

int maxR2(struct Lista*l, int maxTemp){
	if(l==NULL) return maxTemp;
	if(l->data>maxTemp) return 
		maxR2(l->next, l->data);
	return maxR2(l->next, maxTemp); 
}


struct splittata{
	struct Lista* l1;
	struct Lista* l2;
};

bool palindroma(char parola[], 
	int inizio, int fine){
	if(fine<=inizio) return true;
	if(parola[inizio]==' ') return palindroma(parola, inizio+1, fine);
	if(parola[fine-1]==' ') return palindroma(parola, inizio, fine-1);
	if(parola[inizio]!=parola[fine-1]) return false;
	return palindroma(parola, inizio+1, fine-1);
}

void sostituisci(char daSost, char conCh, char parola[], int lung){

}

struct Lista* sostperval(int val,int dasost,struct Lista *l){
	if(l==NULL) return l;
	if(l->data==dasost) l->data=val;
	return newList(l->data,sostperval(val,dasost,l->next));
}


int main(){
	//sostituisci('c','o', "ciao",4);
	
	
	//if(palindroma("i topi non avevano nipoti",0,strlen("i topi non avevano nipoti"))) printf("ok");
	//else printf("NO");
	
	/*
	FILE *fd = fopen("t.txt","r");
	int a;
	fscanf(fd, "%d", &a);
	printf("a:%d\n", a);
	int r = fseek(fd,1,SEEK_CUR);
	printf("rrr = %d\n",r);
	int k = fgetc(fd);
	printf("k:%d %c\n", k, k);
	/*
	fseek(fd,1,SEEK_CUR);
	int k = fgetc(fd);
	printf("k:%d %c\n", k, k);
	
	fscanf(fd, "%d", &a);
	printf("a:%d\n", a);
	fseek(fd,1,SEEK_CUR);
	k = fgetc(fd);
	printf("k:%d %c\n", k, k);
	
*/

	
	struct Lista *lista = NULL;
	
	crea2(10, &lista);
	lista = insOrdR(20,lista);
	lista = insOrdR(20,lista);
	lista = insOrdR(20,lista);
	stampa(lista);//stampa tutta la lista
	//lista = cancellaTuttiR(20,lista);
	lista = sostperval(2,20,lista);
	stampa(lista);//stampa tutta la lista
	
//	lista = crea(10);
//insInTesta(valore da inserire, dove lo devo inserire)
}
