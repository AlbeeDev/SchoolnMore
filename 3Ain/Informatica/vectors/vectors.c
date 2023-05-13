#include<stdio.h>
int main(){
	int va[3],vb[3],vc[3];
	int s;
	freopen("vectorfile.txt","r",stdin);
	for(int i=0;i<3;i++){
		scanf("%i %i %i",&va[i],&vb[i],&vc[i]);
	}
	scanf("%i",&s);
	
	int vsomma[3];
	for(int i=0;i<3;i++){
		vsomma[i]=va[i]+vb[i]+vc[i];
		printf("%i ",vsomma[i]);
	}
	printf("\n");
	
	int vdiff[3];
	for(int i=0;i<3;i++){
		vdiff[i]=va[i]-vb[i]-vc[i];
		printf("%i ",vdiff[i]);
	}
	printf("\n");
	
	int vscal[3];
	for(int i=0;i<3;i++){
		vscal[i]=va[i]*vb[i]*vc[i];
		printf("%i ",vscal[i]);
	}
	printf("\n");
	
	int vapscal[3];
	for(int i=0;i<3;i++){
		vapscal[i]=va[i]*s;
		printf("%i ",vapscal[i]);
	}
	printf("\n");
	int vbpscal[3];
	for(int i=0;i<3;i++){
		vbpscal[i]=vb[i]*s;
		printf("%i ",vbpscal[i]);
	}
	printf("\n");
	int vcpscal[3];
	for(int i=0;i<3;i++){
		vcpscal[i]=vc[i]*s;
		printf("%i ",vcpscal[i]);
	}
	printf("\n");
}
