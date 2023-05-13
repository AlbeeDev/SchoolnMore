#include<stdio.h>
int main(){
int n,x=0,limite=5,temp;
temp=limite;
while(limite>0){
	x=temp;
	while(x>limite){
	    printf("%i", limite);
	    x--;
    }
    for(n=limite;n>0;n--){
	    printf("%i", n);
    }
    for(n=2;n<=limite;n++){
	    printf("%i", n);
    }
    x=temp;
    while(x>limite){
	    printf("%i", limite);
	    x--;
    }
    printf("\n");
    limite--;
}
limite=2;
while(limite<6){
	x=temp;
	while(x>limite){
	    printf("%i", limite);
	    x--;
    }
    for(n=limite;n>0;n--){
	    printf("%i", n);
    }
    for(n=2;n<=limite;n++){
	    printf("%i", n);
    }
    x=temp;
    while(x>limite){
	    printf("%i", limite);
	    x--;
    }
    printf("\n");
    limite++;
}
return 0;
}
