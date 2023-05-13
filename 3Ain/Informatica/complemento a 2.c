#include <stdio.h>


int main(){
  	int i,val,s=0, imp=0;
	int vec[8];
	int vec2[8]= {1,0,0,0,0,0,0,0,};
	int vec3[8];
	
	printf("inserire un numero binario a 8 bit da destra verso sinistra: \n");
	
	for(i=0;i<8;i++){
 		scanf("%i", &val);
 		if (val==0)
  		vec[i]=1;
 		if (val==1)
 		vec[i]=0;
 		if (val>1){
 		printf("%i non e una cifra binaria, ritenta: \n", val);
 		i--;
 		}
	}
	
	for(i=0; i<8; i++){
    s=vec[i]+vec2[i]+imp;
    vec3[i]=s % 2;
    imp=s-vec3[i];
    if(imp>1)
    imp=1;
 }
 printf("\n");
 if(imp==1)
 printf("complemento maggiore di 8 bit");
 else{
  	for(i=0;i<8;i++){
  		printf("%i ", vec3[i]);	
	}
 }
	return 0;
}
