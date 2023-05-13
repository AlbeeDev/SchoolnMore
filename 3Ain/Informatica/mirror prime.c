#include<stdio.h>
int main(){
	int vec[50];
	char ch;
	int x=1;
	for(size_t i=0;x==1;i ++){
		scanf("%c ", &ch);
		switch(ch){
			case('0'):
				vec[i]=0;
				break;
			case('1'):
				vec[i]=1;
				break;
			case('2'):
				vec[i]=2;
				break;
			case('3'):
				vec[i]=3;
				break;
			case('4'):
				vec[i]=4;
				break;
			case('5'):
				vec[i]=5;
				break;
			case('6'):
				vec[i]=6;
				break;
			case('7'):
				vec[i]=7;
				break;
			case('8'):
				vec[i]=8;
				break;
			case('9'):
				vec[i]=9;
				break;
			case('s'):
				x=0;
				break;
		}	
	}
	for(size_t j=0;j<10;j++){
		printf("%i",vec[j]);
	}
}
