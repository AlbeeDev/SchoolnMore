#include <stdio.h>
#include <stdlib.h>
int main(){
	int i,somm=0,diff=0,carry=0,borrow=0;
	int vec[15]= {1,0,0,1,1,1,0,1,0,0,1,0,0,0,1,};
	int vec2[15]= {0,1,1,0,1,1,1,0,0,0,1,0,1,0,1,};
	int vec3[15],vec4[15];  		
	
	for(i=0; i<15; i++){
    somm=vec[i]+vec2[i]+carry;
    vec3[i]=somm % 2;
    carry=somm-vec3[i];
    if(carry>1)
    carry=1;
    }
    for(i=0; i<15; i++){
    diff=vec[i]-vec2[i]-borrow;
    vec4[i]=diff % 2;
    borrow=diff-vec4[i];
    if (vec4[i]<0)
	vec4[i]=1;   
    }
    printf("array 1:    ");
    for(i=0;i<15;i++){
    	printf("%i ", vec[i]);
	}
	printf("\narray 2:    ");
	for(i=0;i<15;i++){
    	printf("%i ", vec2[i]);
	}
	printf("\nsomma:      ");
	for(i=0;i<15;i++){
    	printf("%i ", vec3[i]);
	}
	printf("\ndifferenza: ");
	for(i=0;i<15;i++){
    	printf("%i ", vec4[i]);
	}
	return 0;
}
