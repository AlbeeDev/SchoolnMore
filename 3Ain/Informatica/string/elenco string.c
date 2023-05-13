#include <stdio.h>
#include <string.h>
int main()
{
        const char* elenco[]={
                "rosa",
                "martello",
                "fitzgerald",
                "acqua",
                "vetrina",
        };
        size_t n=sizeof(elenco)/sizeof(elenco[0]);
        char str[20+1];
        fgets(str, sizeof(str), stdin);
        if(str[strlen(str)-1]=='\n')
                str[strlen(str)-1]='\0';
        int result=-1;
        for(size_t i=0;i<n;i++)
        {
                if(strcmp(str, elenco[i])==0)
                {
                        result = i;
                        break;
                }
        }
        printf("result: %d", result);
        return 0;
}
