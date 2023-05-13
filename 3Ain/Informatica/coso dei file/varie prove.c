#include <stdio.h>
#include <string.h>
#define lung 100
struct squadra{
	char nome[lung];
	unsigned score;
};
int ordsquadra(const void *x,const void *y){
	return strcmp(((struct squadra*)x)->nome,((struct squadra*)y)->nome);
}
int main(){
	struct squadra squadre[]={"giorno","bello","kiilo"};
	size_t n=sizeof(squadre)/sizeof(squadre[0]);
	printf("%zu\n",n);
	qsort(squadre,n,sizeof(struct squadra),ordsquadra);
	for(size_t i=0;i<n;i++){
		printf("%s\n",squadre[i]);
	}
}
