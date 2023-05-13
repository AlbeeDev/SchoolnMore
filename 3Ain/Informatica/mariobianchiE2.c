#include <stdio.h>
void funcname (int mat[][10] ,size_t rows,size_t cols){
	for(size_t i=0;i<rows;i++){
		for(size_t j=0;j<cols;j++){
			if(i==j){
			int temp=mat[i][j];
			mat[i][j]=mat[i][cols-j-1];
			mat[i][cols-j-1]=temp;
			}
			printf("%i ",mat[i][j]);
		}
		printf("\n");
	}
}
int main(){
int mat[][10]={
{43,46,48,38,20,11,28,48,12,48,},
{30,38,41,22,33,15,13,49,26,39,},
{23,12,25,16,20,30,33,22,22,43,},
{23,42,44,11,22,26,40,24,42,34,},
{35,19,47,40,19,10,48,43,20,29,},
{47,38,42,23,49,33,28,12,19,22,},
{32,35,46,16,31,18,24,17,11,45,},
{46,20,29,36,10,30,49,13,44,45,},
{31,33,43,35,33,19,14,45,47,45,},
{49,30,45,25,28,28,36,34,12,41,},
};
int rows=sizeof(mat)/sizeof(mat[0]);
int cols=sizeof(mat[0])/sizeof(mat[0][0]);
funcname(mat,rows,cols);
return 0;
}

