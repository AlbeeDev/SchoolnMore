#include <stdio.h>
int main() {
	int x, limite=1, spazio=8;
	for(x=1;x<=limite;x++){
	    if(x==1){
		    printf(" %*i",spazio, x);
	    }
	    else{
	        printf(" %i", x);
        }
	    if(x==limite){
		    limite++;
		    x=x-x;
		    spazio--;
		    printf("\n");
	    }
	    if(x==7){
	        printf(" %i", x+1) ;
		    printf("\n");
            limite--;
            spazio=2;
	        for(x=1;x<=limite;x++){
		        if(x==1){
		            printf(" %*i",spazio, x);
	            }
	            else{
	                printf(" %i", x);
                }
	            if(x==limite){
		            limite--;
		            x=x-x;
		            spazio++;
		            printf("\n");
	            }
	        }
	    }
    }
return 0;
}
