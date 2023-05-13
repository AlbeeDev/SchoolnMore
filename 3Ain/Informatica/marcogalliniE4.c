#include <stdio.h>
void funcname ( int mat[][10],size_t rows,size_t cols){
	for(size_t i=0;i<rows;i++){
		for(size_t j=0;j<cols;j++){
			if(i<j){
				int temp=mat[i][j];
				mat[i][j]=mat[j][i];
				mat[j][i]=temp;
			}
			printf("%i ", mat[i][j]);	
		}
		printf("\n");
	}
}
int main(){
int mat[][10]={
{12,46,22,32,24,21,47,20,30,17,},
{39,14,26,25,37,27,42,47,37,21,},
{49,40,49,32,48,46,46,28,48,15,},
{35,11,46,21,12,46,30,10,41,15,},
{21,19,32,10,17,34,13,47,19,33,},
{23,25,37,11,33,26,49,18,45,28,},
{40,43,27,25,25,11,10,21,48,14,},
{38,48,24,32,48,41,47,19,48,27,},
{20,49,12,42,32,32,33,43,27,24,},
{18,42,37,11,27,38,22,13,40,21,},
};
size_t rows=sizeof(mat)/sizeof(mat[0]);
size_t cols=sizeof(mat[0])/sizeof(mat[0][0]);
funcname(mat,rows,cols);
}
