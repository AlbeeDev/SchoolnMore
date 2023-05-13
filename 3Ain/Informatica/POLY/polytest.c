#include <stdio.h>
int main(){
char* x[3];
FILE *fp;
fp= fopen("poly.txt","r");
while(!feof(fp)){
	fgets(*x,1,fp);
	puts(*x);
}
fclose(fp);
}
