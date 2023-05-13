#include <stdio.h>
int main(){
	int x, cont=1, y=1;
	for(x=1;x<=cont;x++){
		printf(" %i", x);
		if(x==cont){
		    y=y+1;
		    cont=cont+y;
		    printf("\n");
		}
		if(x==36){
		    break;
		}
	}
return 0;
}
