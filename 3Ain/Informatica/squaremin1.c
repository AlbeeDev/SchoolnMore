#include<stdio.h>
int main(){
int n,x=0,limite=9,temp;
temp=limite;
limite=1;
while(limite<10){
	x=temp;
	for(n=1;n<=limite;n++){
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
