#include <stdio.h>
#include <string.h>
int main(){
	char str1[50],str2[50];
	fgets(str1,50,stdin);
	fgets(str2,50,stdin);
	printf("%s\n",strcat(str1,str2));
	
	char* s[]={"casa","palla","cose","altre cose"};
	size_t n=sizeof(s)/sizeof(s[0]);
	char t[50];
	fgets(t,50,stdin);
	
	if(t[strlen(t)-1]=='\n')
        t[strlen(t)-1]='\0';
    
	    char result=42;
        for(size_t i=0;i<n;i++)
        {
            if(strcmp(t, s[i])==0){
                result = 49;
                break;
            }
        }
        printf("result: %c", result);
        return 0;
}
