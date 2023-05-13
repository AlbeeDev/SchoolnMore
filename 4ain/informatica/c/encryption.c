#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <time.h>

char allowed_chars[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()_-+={}[]\\|;:'\",.<>/?`~";
char allowed_rand[] =  "p+WxsZiN7?u8jLr!z2Tmw}yM=-cqK}[|_,`%V$^(/oD@ht&aO;1J]6fQGk.#*:E>b39vI0^'U<~e5A\"R\\!B4YSg;F)";

bool password_meets_requirements(const char* password) {
    bool has_uppercase = false;
    bool has_number = false;
    bool has_symbol = false;
    
    for (int i = 0; i<15; i++) {
        if (isupper(password[i])) {
            has_uppercase = true;
        }
        else if (isdigit(password[i]) && strchr(allowed_chars, password[i]) != NULL) {
            has_number = true;
        }
        else if (strchr(allowed_chars, password[i]) != NULL) {
            has_symbol = true;
        }
    }
    
    return has_uppercase && has_number && has_symbol;
}

void resort_password(char *encrypted_password) {
    size_t password_len = strlen(encrypted_password);

    // Define a comparison function for the qsort function
    int cmpfunc(const void *a, const void *b) {
        char char_a = *(char *)a;
        char char_b = *(char *)b;
        char *index_a = strchr(allowed_chars, char_a);
        char *index_b = strchr(allowed_chars, char_b);
        return (int)(index_b - allowed_chars) - (int)(index_a - allowed_chars);
    }

    // Sort the encrypted password using qsort
    qsort(encrypted_password, password_len, sizeof(char), cmpfunc);
}

void sort_password(char *encrypted_password) {
    size_t password_len = strlen(encrypted_password);

    // Define a comparison function for the qsort function
    int cmpfunc(const void *a, const void *b) {
        char char_a = *(char *)a;
        char char_b = *(char *)b;
        char *index_a = strchr(allowed_chars, char_a);
        char *index_b = strchr(allowed_chars, char_b);
        return (int)(index_a - allowed_chars) - (int)(index_b - allowed_chars);
    }

    // Sort the encrypted password using qsort
    qsort(encrypted_password, password_len, sizeof(char), cmpfunc);
}

void encrypt_password(char *password) {
	int password_length = strlen(password);
	if(password_length<15){
		for(int i=password_length;i<15;i++){
			char catchar[2] = {allowed_chars[i], '\0'};
			strcat(password,catchar);
		}
	}
    password_length=strlen(password);
    int allowed_chars_length = strlen(allowed_rand);
    srand(time(NULL));
    for(int i=1;i < password_length;i++){
    	for (int j = 0; j < password_length; j++) {
        	int index = strchr(allowed_rand, password[j]) - allowed_rand;
        	int new_index = (index * i) % allowed_chars_length;
        	password[j] = allowed_chars[new_index];
    	}
    	printf("process %d: %s\n",i,password);
    	
		char subpassword[100];
		int factor=3;
		int k=0;
		for(int j=0;j<strlen(password);j++){
			if(j>factor && j<strlen(password)-factor){
				subpassword[k++]=password[j];
			}
		}
		subpassword[k] = '\0';
		printf("substring : %s\n", subpassword);
		resort_password(subpassword);
		printf("sorted sub: %s\n", subpassword);
		strcat(password,subpassword);
		printf("new process %d: %s\n",i,password);
		for (int i = 0; i < k; i++) {
    		subpassword[i] = '\0';
		}
		if(password_meets_requirements(password)){
    		break;
		}
		else{
			for(int cyc=0;cyc<6;cyc++){
				int len = strlen(password);
				for(int i=0; i<len-1; i++) {
		    		password[i] = password[i+1];
				}
				password[len-1] = '\0';	
			}
			
			
		}
	}
    
}





int main() {
	while(true){
		char password[100];
    printf("Enter password: ");
    scanf("%s", password);
    encrypt_password(password);
    //sort_password(password);
    char newpass[100];
    if(strlen(password)>15){
    	for(int i=0;i<strlen(password);i++){
    		if(i<15){
    			newpass[i]=password[i];
			}
		}
	}
    printf("Encrypted password: %s\n", newpass);
	}
}
