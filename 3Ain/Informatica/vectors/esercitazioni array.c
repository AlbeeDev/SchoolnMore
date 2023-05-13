#include<stdio.h>
#include<stdlib.h>
void gen_mat_emisimmetrica(int mat[][10], size_t n){
	for(size_t i=0;i<n;i++){
		for(size_t j=0;j<n;j++){
			if(i==j){
				mat[i][j]=0;
			}
			if(i>j){
				mat[i][j]=rand()%9;
			}
		}	
	}
	for(size_t i=0;i<n;i++){
		for(size_t j=0;j<n;j++){
			if(i<j){
				mat[i][j]=mat[j][i]-2*mat[j][i];
			}
		}	
	}
}

void conv2Celsius(int v[], size_t n){
	for(size_t i=0;i<n;i++){
		v[i]=v[i]-273;
	}
	
}
void removeValues(int v1[], size_t *n1,  int v2[], size_t n2){
	size_t x=0;
		for(size_t i=0;i<n1;i++){
	  		for(size_t j=0;j<n2;j++){
	  			if(v1[i]==v2[j]){
	  				x++;
				}
			}
		}
	n1-=x;
	
}
int main(){
	int mat[10][10];
	size_t n=sizeof(mat)/sizeof(mat[0]);
	gen_mat_emisimmetrica(mat,n);
	for(size_t i=0;i<n;i++){
		for(size_t j=0;j<n;j++){
			printf("%i ",mat[i][j]);	
		}
		printf("\n");
	}
	
	size_t k;
	int v1[100];
	scanf("%zu",&k);
	for(size_t i=0;i<k;i++){
		v1[i]=rand()%100+200;
	}
	conv2Celsius(v1,k);
	for(size_t i=0;i<k;i++){
		printf("%i ",v1[i]);
	}
	printf("\n");
	
	int v2[]={0,1,2,3,4,5,6,7,8,9,10};
	int v3[]={35,9,12,65,4,7,81};
	size_t n2=sizeof(v2)/sizeof(v2[0]);
	size_t n3=sizeof(v3)/sizeof(v3[0]);
	removeValues(v2,n2,v3,n3);
	printf("%zu",n2);
	
	
	
	
	
	
}
