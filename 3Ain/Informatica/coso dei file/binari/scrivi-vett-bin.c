#include <stdio.h>
#include <stdlib.h>
int main(){
	int n[5]={7,34,-12,2,-8};
	FILE *vett;
	if((vett=fopen("vett.bin","wb"))!=NULL){
		fseek(vett,0,SEEK_SET);
		for(size_t i=0;i<5;i++){
			fwrite(&n[i],sizeof(*n),1,vett);
		}
		fclose(vett);
	}
	else{
		fclose(vett);
	}
}
