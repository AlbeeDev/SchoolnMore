#include<stdio.h>
#include<string.h>
#include<stdbool.h>
bool istautogram(const char * str1[],size_t n){
	for(size_t i=0;i<n-1;i++){
		if(str1[i][0]!=str1[i+1][0]){
			return false;
		}
	}
	return true;
}
/*void HashtagYoda(char str1[]){
	char * ch=" ";
	char str2[100]=" ";
	
	char* token=strtok(str1,ch);
	while(token!=NULL){
		strcat(str2,token);
		token=strtok(NULL,ch);
	}
	strcpy(str1,str2);
}*/
//size_t wordmaxlength(const char * str)
int main(){
	
//	const char * str1[]={"vidi","veni","vici"};
	const char str1[]="vidi veni vici";
	size_t n=sizeof(str1)/sizeof(str1[0]);
	printf("%i\n",istautogram(str1,n));
	
/*	char str2[100];
	fgets(str2,100,stdin);
	HashtagYoda(str2);
	printf("%s",str2);
*/
//	const char * str3[]="nel mezzo di cammin di nostra vita";
}
