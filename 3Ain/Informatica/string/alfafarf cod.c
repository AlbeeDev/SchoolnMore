#include<stdio.h>
#include<string.h>
int main(){
	char vowel[]="aeiou";
	char str[100];
	fgets(str,100,stdin);
	char str2[300];
	char ch='f';
	size_t k=0;
	for(size_t i=0;i<strlen(str);i++){
		for(size_t j=0;j<strlen(vowel);j++){
			if(str[i]==vowel[j]){
				str2[k]=str[i];
				printf("%c",str2[k]);
				str2[k+1]=ch;
				printf("%c",str2[k+1]);
				str2[k+2]=str[i];
				printf("%c",str2[k+2]);
				k+=2;
			}	
		}
		if(str[i]!=vowel[0] && str[i]!=vowel[1] && str[i]!=vowel[2] && str[i]!=vowel[3] && str[i]!=vowel[4]){
				str2[k]=str[i];
				printf("%c",str2[k]);
			}
		k++;
	}
}
