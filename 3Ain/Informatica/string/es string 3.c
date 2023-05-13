#include<stdio.h>
#include<string.h>
#include<stdbool.h>
bool hasvowelpair(const char * str){
	for(size_t i=0;i<strlen(str);i++){
		if(str[i]==str[i+1] && (str[i]==97 || str[i]==101 || str[i]==105 || str[i]==111 || str[i]==117)){
			return true;
		}
	}
	return false;
}
int hastriple(const char * str){
	for(size_t i=0;i<strlen(str);i++){
		if(str[i]==str[i+1] && str[i]==str[i+2]){
			return i;
		}
	}
	return 0;
}
char latestchar(const char * str){
	return str[strlen(str)-1];
}
bool isanagram(const char * str,const char * str2){
	char strs[50];
	if(strlen(str)!=strlen(str2)){
		return false;
	}
	for(size_t i=0;i<strlen(str);i++){
		bool ishere=false;
		for(size_t j=0;j<strlen(str2);j++){
			if(str[i]==str2[j]){
				ishere=true;
			}
		}
		if(ishere==false){
			return false;
		}	
	}
	return true;
}
bool ispangram(const char * str){
	char alpha[]="abcdefghilmnopqrstuvz";
	for(size_t i=0;i<strlen(str);i++){
		for(size_t j=0;j<strlen(alpha);j++){
			if(str[i]==alpha[j]){
				alpha[j]=32;
			}
		}
	}
	for(size_t i=0;i<strlen(alpha);i++){
		if(alpha[i]!=32){
			return false;
		}
	}
	return true;
}
bool isheteroliteral(const char * str){
	char alpha[]="abcdefghilmnopqrstuvz";
	for(size_t i=0;i<strlen(alpha);i++){
		int sumcheck=0;
		for(size_t j=0;j<strlen(str);j++){
			if(alpha[i]==str[j]){
				sumcheck+=1;
			}
		}
		if(sumcheck>1){
			return false;
		}
	}
	return true;
}
int main(){
	const char str[]="ciaoo";
	const char str2[]="valanga";
	printf("%i\n",hasvowelpair(str));
	printf("%i\n",hastriple(str));
	printf("%c\n",latestchar(str));
	printf("%i\n",isanagram(str,str2));
	printf("%i\n",ispangram(str));
	printf("%i\n",isheteroliteral(str));
}
