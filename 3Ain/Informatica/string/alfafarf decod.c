#include<stdio.h>
#include<string.h>
int main(){
	char vowel[]="afaefeifiofoufu";
	char str[100];
	fgets(str,100,stdin);
	char str2[300];
	size_t k=0,i=0;
	for(i=0;i<strlen(str);i++){
		for(size_t j=0;j<strlen(vowel);j+=3){
			if(str[i]==vowel[j] && str[i+1]==vowel[j+1] && str[i+2]==vowel[j+2]){
				str2[k]=str[i];
				printf("%c",str2[k]);
				i+=2;
			}	
		}
		if(str[i]!=vowel[0] && str[i]!=vowel[3] && str[i]!=vowel[6] && str[i]!=vowel[9] && str[i]!=vowel[12]){
				str2[k]=str[i];
				printf("%c",str2[k]);
			}
		k++;
	}
}
