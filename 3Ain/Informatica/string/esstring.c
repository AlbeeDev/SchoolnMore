#include<stdio.h>
#include<string.h>
#include<ctype.h>
int main(){
	char str[50];
	fgets(str,50,stdin);
	for(size_t i=0;i<strlen(str)-1;i++){
		if(str[i]==97 || str[i]==101 || str[i]==105 || str[i]==111 || str[i]==117){
			str[i]=46;
		}
		else
		{
			if(isspace(str[i])==8){
				str[i]=42;
			}
			else{
				str[i]=45;
			}
		}
	}
	printf("%s\n ", str);
}
