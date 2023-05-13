#include<stdio.h>
#include<string.h>
#include<stdbool.h>
#include<ctype.h>
bool monovocalica(char str[]){
	int m=0;
	size_t x;
	for(size_t i=0;i<strlen(str);i++){
		if(str[i]=='a' || str[i]=='e' || str[i]=='i' || str[i]=='o' || str[i]=='u'){
			m=1;
		}
		if(m==1){
			x=i;
			break;
		}
	}
	for(size_t j=x+1;j<strlen(str);j++){
		if(str[j]=='a' || str[j]=='e' || str[j]=='i' || str[j]=='o' || str[j]=='u'){
			return false;
		}
	}
	return true;
}
bool monoconsonantica(char str[]){
	int m=0;
	size_t x;
	for(size_t i=0;i<strlen(str);i++){
		if(isalpha(str[i]) && str[i]!='a' && str[i]!='e' && str[i]!='i' && str[i]!='o' && str[i]!='u'){
			m=1;
		}
		if(m==1){
			x=i;
			break;
		}
	}
	for(size_t j=x+1;j<strlen(str);j++){
		if(isalpha(str[j]) && str[j]!='a' && str[j]!='e' && str[j]!='i' && str[j]!='o' && str[j]!='u'){
			return false;
		}
	}
	return true;
}
bool eteroletterale(char str[]){
	char alf[26]={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',};
	size_t x=0;
	for(size_t i=0;i<strlen(str);i++){
		for(size_t j=0;j<26;j++){
			if(str[i]==alf[j]){
				alf[j]=' ';
				x++;
			}
		}
		if(i+1!=x){
			return false;
		}
	}
	return true;
}
bool eterovocalica(char str[]){
	char vow[5]={'a','e','i','o','u'};
	size_t x=0;
	for(size_t i=0;i<strlen(str);i++){
		if(str[i]!='a' && str[i]!='e' && str[i]!='i' && str[i]!='o' && str[i]!='u'){
				x++;
			}
		for(size_t j=0;j<5;j++){
			if(str[i]==vow[j]){
			vow[j]=' ';
			x++;
			}
		}
		if(i+1!=x){
			return false;
		}
	}
	return true;
}
bool parivocalica(char str[]){
	int count=0,cons=0;
	for(size_t i=0;i<strlen(str);i++){
		if(i%2==0){
			count+=1;
			if(str[i]!='a' && str[i]!='e' && str[i]!='i' && str[i]!='o' && str[i]!='u'){
				cons+=1;
			}
		}
	}
	if(count==cons){
		return true;
	}
	return false;
}
bool pariconsonantica(char str[]){
	int count=0,vow=0;
	for(size_t i=0;i<strlen(str);i++){
		if(i%2==0){
			count+=1;
			if(str[i]=='a' || str[i]=='e' || str[i]=='i' || str[i]=='o' || str[i]=='u'){
			vow+=1;
			}
		}	
	}
	if(count==vow){
		return true;
	}
	return false;
}
bool omovocalica(char str[],char str2[]){
	if(strlen(str)==strlen(str2)){
		for(size_t i=0;i<strlen(str);i++){
			if(str[i]=='a' || str[i]=='e' || str[i]=='i' || str[i]=='o' || str[i]=='u'){
				if(str[i]!=str2[i]){
					return false;
				}
			}
			if(str[i]!='a' && str[i]!='e' && str[i]!='i' && str[i]!='o' && str[i]!='u'){
				if(str2[i]!='a' && str2[i]!='e' && str2[i]!='i' && str2[i]!='o' && str2[i]!='u'){
					if(str[i]==str2[i]){
						return false;
					}
				}
			}
		}
		return true;	
	}
	else{
		return false;
	}	
}
bool omoconsonantica(char str[],char str2[]){
	if(strlen(str)==strlen(str2)){
		for(size_t i=0;i<strlen(str);i++){
			if(str[i]!='a' && str[i]!='e' && str[i]!='i' && str[i]!='o' && str[i]!='u'){
				if(str[i]!=str2[i]){
					return false;
				}
			}
			if(str[i]=='a' || str[i]=='e' || str[i]=='i' || str[i]=='o' || str[i]=='u'){
				if(str2[i]=='a' || str2[i]=='e' || str2[i]=='i' || str2[i]=='o' || str2[i]=='u'){
					if(str[i]==str2[i]){
						return false;
					}
				}
			}
		}
		return true;	
	}
	else{
		return false;
	}
}
//bool centrocrescente(char str[])

//abcba
//bool centrodecrescente(char str[])


//cbabc
bool bifronte(char str[],char str2[]){
	if(strlen(str)==strlen(str2)){
		for(size_t i=0;i<strlen(str);i++){
			if(str[strlen(str)-i-1]!=str2[i]){
				return false;
			}
		}
		return true;
		}
	else{
		return false;
	}
}
bool symvow(char str[]){
	size_t k=0;
	char arr[50];
	char arr2[50];
	for(size_t i=0;i<strlen(str);i++){
		if(str[i]=='a' || str[i]=='e' || str[i]=='i' || str[i]=='o' || str[i]=='u'){
			arr[k]=str[i];
			k++;
		}
	}
	k=0;
	for(size_t i=strlen(str);i>0;i--){
		if(str[i-1]=='a' || str[i-1]=='e' || str[i-1]=='i' || str[i-1]=='o' || str[i-1]=='u'){
			arr2[k]=str[i-1];
			k++;
		}
	}
	for(size_t i=0;i<strlen(arr);i++){
		if(arr[i]!=arr2[i]){
			return false;
		}
		return true;
	}
}
bool symcons(char str[]){
	size_t k=0;
	char arr[50]={0};
	char arr2[50]={0};
	for(size_t i=0;i<strlen(str);i++){
		if(str[i]!='a' && str[i]!='e' && str[i]!='i' && str[i]!='o' && str[i]!='u'){
			arr[k]=str[i];
			k++;
		}
	}	
	k=0;
	for(size_t i=strlen(str);i>0;i--){
		if(str[i-1]!='a' && str[i-1]!='e' && str[i-1]!='i' && str[i-1]!='o' && str[i-1]!='u'){
			arr2[k]=str[i-1];
			k++;
		}
	}
	for(size_t i=0;i<strlen(arr2);i++){
		if(arr[i]!=arr2[i]){
			return false;
		}
		return true;
	}
}
int main(){
	char str[]="ese";
	printf("monovocalica: %i\n",monovocalica(str));
	printf("monoconsonantica: %i\n",monoconsonantica(str));
	printf("eteroletterale: %i\n",eteroletterale(str));
	printf("eterovocalica: %i\n",eterovocalica(str));
	printf("parivocalica: %i\n",parivocalica(str));
	printf("pariconsonantica: %i\n",pariconsonantica(str));
	
	char str2[]="oleb";
	printf("omovocalica: %i\n",omovocalica(str,str2));
	printf("omoconsonantica: %i\n",omoconsonantica(str,str2));
//	printf("%i\n",centrocrescente(str));
//	printf("%i\n",centrodecrescente(str));
	printf("bifronte: %i\n",bifronte(str,str2));
	printf("symvow: %i\n",symvow(str));
	printf("symcons: %i\n",symcons(str));
}
