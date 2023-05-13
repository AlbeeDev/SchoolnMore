#include<stdio.h>
#include<string.h>
int main(){
	char esabase[16]="0123456789abcdef";
	char esa1[50];
	fgets(esa1,50,stdin);
	char esa2[50];
	fgets(esa2,50,stdin);
	int val1[50],val2[50];
	for(size_t i=strlen(esa1)-1;i>=0;i--){
		if(esa1>=48 && esa1<=57){
			val1[strlen(esa1)-i-1]=esa1[i]-48;
		}
		if(esa1>=97 && esa1<=102){
			val1[strlen(esa1)-i-1]=esa1[i]-87;
		}
	}
	for(size_t i=strlen(esa2)-1;i>=0;i--){
		if(esa2>=48 && esa2<=57){
			val2[strlen(esa2)-i]=esa2[i]-48;
		}
		if(esa2>=97 && esa2<=102){
			val2[strlen(esa2)-i]=esa2[i]-87;
		}
	}
	int riporto=0;
	int val3[50];
	char esa3[50];
	for(size_t i=0;i<strlen(esa1);i++){
		if(val1[i]+val2[i]+riporto<16){
			val3[i]=val1[i]+val2[i]+riporto;
			if(riporto>0){
				riporto-=1;
			}
		}
		if(val1[i]+val2[i]>15){
			val3[i]=val1[i]+val2[i]-16;
			riporto+=1;
		}
	}
	for(size_t i=sizeof(val3)/sizeof(val3[0])-1;i>=0;i--){
		if(val3>=0 && val3<=9){
			esa3[sizeof(val3)/sizeof(val3[0])-i-1]=val3[i]+48;
		}
		if(val3>=10 && val3<=15){
			esa3[sizeof(val3)/sizeof(val3[0])-i-1]=val3[i]+87;
		}
		printf("%c",esa3);
	}
}
