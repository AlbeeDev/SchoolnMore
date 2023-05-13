#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#include<stdbool.h>
int fmagiconst(size_t rows,size_t cols){
	int magiconst=(rows*(cols*cols+1))/2;
	return magiconst;
}
bool magicubepari(int mat[4][4],size_t rows,size_t cols){
	int magiconst=fmagiconst(rows,cols);
	int sumang=0,sumcentral=0;
	bool isangeq=true,iscentraleq=true;
	for(size_t i=0;i<rows;i++){
		for(size_t j=0;j<cols;j++){
			if((i==0 && j==0) || (i==0 && j==cols-1) || (i==rows-1 && j==0) || (i==rows-1 && j==cols-1))
			sumang+=mat[i][j];
		}
	}
	if(sumang!=magiconst){
		isangeq=false;
		return false;
	}
	for(size_t i=0;i<rows;i++){
		for(size_t j=0;j<cols;j++){
			if((i==1 && j==1) || (i==1 && j==cols-2) || (i==rows-2 && j==1) || (i==rows-2 && j==cols-2))
			sumcentral+=mat[i][j];
		}
	}
	if(sumcentral!=magiconst){
		iscentraleq=false;
		return false;
	}
	return true;
}
void magicubedispari(){
	int mat[3][3];
	int rows=sizeof(mat)/sizeof(mat[0]);
	int cols=sizeof(mat[0])/sizeof(mat[0][0]);
	int x=0,magiconst=fmagiconst(rows,cols);
	printf("constante magica 3x3: %i\n",fmagiconst(rows,cols));
	while(x==0){
		int vec[9]={1,2,3,4,5,6,7,8,9};
		size_t n=sizeof(vec)/sizeof(vec[0]);
		bool isroweq=true,iscoleq=true,isdiageq=true;
		//generazione di una matrice casuale 3x3
		for(size_t i=0;i<rows;i++){
			for(size_t j=0;j<cols;j++){
				bool isdup=true;
				while(isdup==true){
					int num=rand()%9+1;
					for(size_t k=0;k<n;k++){
						if(num==vec[k]){
							vec[k]=0;
							mat[i][j]=num;
							isdup=false;
						}
					}
				}
			}
		}
		//controllo se le somma sono uguali
		for(size_t k=0;k<cols;k++){
			int sumcol=0;
			for(size_t i=0;i<rows;i++){
				for(size_t j=k;j<k+1;j++){
					sumcol+=mat[i][j];
				}
			}
			if(sumcol!=magiconst){
				iscoleq=false;
				break;
			}
		}
		for(size_t k=0;k<rows;k++){
			int sumrow=0;
			for(size_t i=k;i<k+1;i++){
				for(size_t j=0;j<cols;j++){
					sumrow+=mat[i][j];
				}
			}
			if(sumrow!=magiconst){
				isroweq=false;
				break;
			}
		}
		int sumdiag1=0,sumdiag2=0;
		for(size_t i=0;i<rows;i++){
			for(size_t j=0;j<cols;j++){
				if(i==j){
					sumdiag1+=mat[i][j];
				}
				if(i==cols-j-1){
					sumdiag2+=mat[i][j];
				}
			}
		}
		if(sumdiag1!=sumdiag2){
			isdiageq=false;
		}
		sumdiag1=0;
		if(isroweq==true && iscoleq==true && isdiageq==true)
			x=1;
	}
	for(size_t i=0;i<rows;i++){
		for(size_t j=0;j<cols;j++){
			printf("%i ", mat[i][j]);
		}
		printf("\n");
	}
}
int main(){
	srand(time(NULL));
	int mat[4][4]={
	{4,14,15,1},
	{9,7,6,12},
	{5,11,10,8},
	{16,2,3,13},
	};
	int rows=sizeof(mat)/sizeof(mat[0]);
	int cols=sizeof(mat[0])/sizeof(mat[0][0]);
	printf("constante magica 4x4: %i\n",fmagiconst(rows,cols));
	if(magicubepari(mat,rows,cols)==true){
		magicubedispari();
	}
}
