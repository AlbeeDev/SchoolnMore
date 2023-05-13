#include <stdio.h>
void funcname ( int mat[][10],size_t rows,size_t cols){
	int molt=1;
	for(size_t i=0;i<rows;i++){
		for(size_t j=0;j<cols;j++){
			if(i<j){
				molt=molt*mat[i][j];
			}
		}
	}
	//il risultato è 0 perche il numero è troppo grande, questo si puo vedere usando funcname2
	printf("%i", molt);
}
void funcname2 ( int mat[][10],size_t rows,size_t cols){
	int molt=1;
	for(size_t i=0;i<rows;i++){
		for(size_t j=0;j<cols;j++){
			if(i<j){
				molt=molt*mat[i][j];
				printf("%i ",molt);
			}
		}
	}
	
}
int main(){
int mat[][10]={
{35,27,12,48,17,22,28,17,12,16,},
{40,49,12,16,29,31,33,27,21,14,},
{33,32,34,31,47,36,30,40,11,37,},
{45,10,24,45,39,21,14,22,15,18,},
{23,12,24,34,42,37,28,41,20,39,},
{30,27,19,35,27,18,43,41,27,22,},
{17,33,15,14,40,24,26,44,47,36,},
{13,13,18,48,42,47,31,12,18,35,},
{37,26,44,19,16,30,28,40,28,48,},
{17,49,37,17,21,31,48,14,37,37,},
};
size_t rows=sizeof(mat)/sizeof(mat[0]);
size_t cols=sizeof(mat[0])/sizeof(mat[0][0]);
funcname(mat,rows,cols);
printf("\n");
funcname2(mat,rows,cols);
}
