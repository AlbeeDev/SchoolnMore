#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#define lung 100
int main(){
unsigned char buffer[10]="ciao fra";

FILE *ptr;

//ptr = fopen("test.bin","rb");
//fread(buffer,sizeof(buffer),1,ptr);
for(int i = 0; i<10; i++)
    printf("%u ", buffer[i]);
    printf("\n");
FILE *write_ptr;
write_ptr = fopen("test.bin","wb"); 

fwrite(buffer,sizeof(buffer),1,write_ptr);
ptr = fopen("test.bin","rb");
fread(buffer,sizeof(buffer),1,ptr);
for(int i = 0; i<10; i++)
    printf("%u ", buffer[i]);
}

