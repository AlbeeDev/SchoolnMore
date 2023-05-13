#include<stdio.h>
int main(){
int n,x=0,limite=9,temp,y,z;
temp=limite;
limite=1;
while(limite<6){
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
limite=1;
temp=limite;
y=4;
while(limite<5){
    x=temp;
    while(x<6){
	    printf("%i", x);
	    x++;
    }
    for(n=4;n>=y;n--){
	    printf("%i", n);
	    z=y;
	    while(z>1){
	    printf("%i", n);
	    z--;
    }
    }
    
    printf("\n");
    limite++;
    y--;
    z--;
}
return 0;
}
