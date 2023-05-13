#include<stdio.h>
int main(){
int n,x=0,limite=1,temp;
temp=limite;
while(limite<10){
	x=temp;
	while(x<limite){
	    printf("%i", limite);
	    x++;
    }
    for(n=limite;n<10;n++){
	    printf("%i", n);
    }
    printf("\n");
    limite++;
}

return 0;
}
