#include <stdio.h>
void funcname (int mat[][10],size_t rows,size_t cols){
	int x=0;
	for(size_t i=0;i<rows;i++)
	for(size_t j=0;j<cols;j++)
	if(mat[i][j]==0)
	x=1;
	if(x==1)
	printf("vero");
	else
	printf("falso");
	
}
int main(){
int mat[][10]={
{24,44,34,48,39,39,46,41,37,22,},
{33,49,33,23,22,12,11,17,26,19,},
{26,29,49,26,16,12,46,11,29,18,},
{25,34,31,35,35,11,15,28,10,27,},
{45,27,22,25,39,31,10,45,22,26,},
{13,36,22,23,11,31,18,32,39,46,},
{26,31,39,46,40,16,17,26,45,38,},
{24,29,47,35,21,13,10,39,22,40,},
{37,38,20,31,15,49,21,15,30,39,},
{49,10,29,24,48,36,30,42,26,24,},
};
int rows=sizeof(mat)/sizeof(mat[0]);
int cols=sizeof(mat[0])/sizeof(mat[0][0]);
funcname(mat,rows,cols);
}
