#include<stdio.h>
#include<stdbool.h>
#include<stdlib.h>
#include<math.h>
#include<time.h>
//1a
void matPrint(size_t n,int mat[][n]){
	for(size_t i=0;i<n;i++){
		for(size_t j=0;j<n;j++)
			printf("%i ",mat[i][j]);
		printf("\n");
	}
}
void matIdent(size_t n, int mat[][n]){
	for(size_t i=0;i<n;i++){
		for(size_t j=0;j<n;j++)
			if(i==j)
				mat[i][j]=1;
	}
}
//1b
bool isMatIdent(size_t n,int mat[][n]){
	bool id=true;
	for(size_t i=0;i<n;i++){
		for(size_t j=0;j<n;j++){
			if((i==j && mat[i][j]!=1) || (i!=j && mat[i][j]!=0))
				id=false;
		}
	}
	return id;
}
//2a
void matSymmetric(size_t n, int mat[][n]){
	for(size_t i=0;i<n;i++){
		for(size_t j=0;j<n;j++){
			if(i<j){
				mat[i][j]=rand()%19-9;
				mat[j][i]=mat[i][j];
			}
			if(i==j)
				mat[i][j]=rand()%19-9;
		}
	}
}
//2b
bool isMatSymmetric(size_t n,int mat[][n]){
	bool symm=true;
	for(size_t i=0;i<n;i++){
		for(size_t j=0;j<n;j++){
			if(i>j && mat[i][j]!=mat[j][i])
				symm=false;
		}
	}
	return symm;
}
//3a
void matHessenberg(size_t n, int mat[][n]){
	for(size_t i=0;i<n;i++){
		for(size_t j=0;j<n;j++){
			if(i>j+1)
				mat[i][j]=0;
			else{
				mat[i][j]=rand()%19-9;
				while(mat[i][j]==0)
					mat[i][j]=rand()%19-9;
			}
		}
	}
}
//3b
bool isMatHessenberg(size_t n,int mat[][n]){
	bool hessen=true;
	for(size_t i=0;i<n;i++){
		for(size_t j=0;j<n;j++){
			if((i>j+1 && mat[i][j]!=0) || (i<j+2 && mat[i][j]==0))
				hessen=false;
		}
	}
	return hessen;
}
//4a
bool isMatBinary(size_t n,int mat[][n]){
	bool bin=true;
	for(size_t i=0;i<n;i++){
		for(size_t j=0;j<n;j++){
			if(mat[i][j]<0 || mat[i][j]>1)
				bin=false;
		}
	}
	return bin;
}
//4b
unsigned getMatPrime(size_t n,int mat[][n]){
	bool prime=true;
	int x=0;
	for(size_t i=0;i<n;i++){
		for(size_t j=0;j<n;j++){
			if(abs(mat[i][j])<=1)
			prime=false;
			for(int div=2;div<mat[i][j];div++){
				if(abs(mat[i][j])%div==0)
					prime=false;
			}
			if(prime==true)
			x+=1;
			prime=true;
		}
	}
	return x;
}

int main() {
	srand(time(NULL));
    int mat[100][100];
    unsigned n;
    printf("ordine della matrice: \n");
    scanf("%u", &n);

	matIdent(n,mat);
    matPrint(n, mat);
    printf("ident: %i\n", isMatIdent(n, mat));
    printf("symmetric: %i\n", isMatSymmetric(n, mat));
    printf("hessenberg: %i\n", isMatHessenberg(n, mat));
    printf("binary: %i\n", isMatBinary(n, mat));
    printf("prime: %i\n", getMatPrime(n, mat));
    printf("\n");
    
    matSymmetric(n,mat);
    matPrint(n, mat);
    printf("ident: %i\n", isMatIdent(n, mat));
    printf("symmetric: %i\n", isMatSymmetric(n, mat));
    printf("hessenberg: %i\n", isMatHessenberg(n, mat));
    printf("binary: %i\n", isMatBinary(n, mat));
    printf("prime: %i\n", getMatPrime(n, mat));
    printf("\n");
    
    matHessenberg(n,mat);
    matPrint(n, mat);
    printf("ident: %i\n", isMatIdent(n, mat));
    printf("symmetric: %i\n", isMatSymmetric(n, mat));
    printf("hessenberg: %i\n", isMatHessenberg(n, mat));
    printf("binary: %i\n", isMatBinary(n, mat));
    printf("prime: %i\n", getMatPrime(n, mat));
    printf("\n");
    return 0;
}
