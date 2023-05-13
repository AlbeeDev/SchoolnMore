#include <stdio.h>
#include <stdlib.h>
int main(){
	int n1,n2,sum=0;
	scanf("%i",&n1);
	scanf("%i",&n2);
	sum=n1+n2;
	FILE *num;
	if((num=fopen("numeri.bin","wb"))!=NULL){
		fseek(num,0,SEEK_SET);
		fwrite(&n1,sizeof(n1),1,num);
		fwrite(&n2,sizeof(n2),1,num);
		fwrite(&sum,sizeof(sum),1,num);
		fclose(num);
	}
	else{
		fclose(num);
	}
}
