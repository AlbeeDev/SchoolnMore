#include<stdio.h>
#include<string.h>
#include<stdbool.h>
bool OUT(char ch){
	if(ch==' ' || ch=='\n' || ch=='\t'){
		return true;
	}
	return false;
}
bool IN(char ch){
	if(ch!=' ' || ch!='\n' || ch!='\t'){
		return true;
	}
	return false;
}
int main(){
	int count=1;
	char str[100];
	fgets(str,100,stdin);
	for(size_t i=0;i<strlen(str)-1;i++){
		if(OUT(str[i]) && IN(str[i+1]) && !OUT(str[i+1])){
			count+=1;
		}
	}
	printf("%i", count);
}
