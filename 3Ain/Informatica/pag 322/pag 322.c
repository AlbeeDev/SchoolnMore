#include <stdio.h>
//14b
void traslamat(int mat[][8] ,size_t rows,size_t cols){
	int y=1;
	for(size_t i=0;i<rows;i++){
		int x=y;
		for(size_t j=0;j<cols;j++){
			mat[i][j]=x;
			printf("%i ",mat[i][j]);
			x+=1;
		}
		y+=1;
		printf("\n");
	}
}
//15a
void diagomat(int mat[][8] ,size_t rows,size_t cols){
	for(size_t i=0;i<rows;i++){
		int x=1;
		for(size_t j=0;j<cols;j++){
			if(i==j){
				mat[i][j]=x;
				printf("%i ",mat[i][j]);
			}
			if(i<j){
				x+=1;
				mat[i][j]=x;
				mat[j][i]=mat[i][j];
				printf("%i ", mat[i][j]);
			}
			if(i>j){
				printf("%i ", mat[i][j]);
			}
		}
		printf("\n");
	}
}
//15b
void zigzamat(int mat[][8] ,size_t rows,size_t cols){
	int x=0;
	for(size_t i=0;i<rows;i++){
		for(size_t j=0;j<cols;j++){
			if(i%2==0){
				x+=1;
				mat[i][j]=x;
				printf("%i ", mat[i][j]);
			}
			else{
				mat[i][j]=x;
				x-=1;
				printf("%i ", mat[i][j]);
			}
		}
		x+=cols;
		printf("\n");
	}
}
int main(){
int mat[8][8];
int rows=sizeof(mat)/sizeof(mat[0]);
int cols=sizeof(mat[0])/sizeof(mat[0][0]);
traslamat(mat,rows,cols);
printf("\n");
diagomat(mat,rows,cols);
printf("\n");
zigzamat(mat,rows,cols);
printf("\n");
}
