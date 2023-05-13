#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/stat.h>
#include <sys/types.h>

#define PIPE1 "/tmp/pipe1"
#define PIPE2 "/tmp/pipe2"

typedef struct {
    int coefficients[10];
    int x_value;
} Polynomial;

Polynomial newPolynomial(){
    Polynomial poly;
    for(size_t i = 0; i<10; ++i)
        poly.coefficients[i] = 0;
    poly.x_value = 0;
    return poly;
}

int intPow(int base, int exponent){
    int result=1;
    for(size_t i = 0; i < exponent; ++i)
        result *= base;
    return result;
}

int main(){
    mkfifo(PIPE1, 0666);
    mkfifo(PIPE2, 0666);

    int process_id = fork();

    if(!process_id){ // child process A
        int result = 0;
        Polynomial poly = newPolynomial();
        FILE* read_pipe = fopen(PIPE1, "r");
        if(read_pipe != NULL){
            fread(&poly, sizeof(Polynomial), 1, read_pipe);
            fclose(read_pipe);
        }

        for(size_t i = 0; i < 10; ++i)
            result += poly.coefficients[i] * intPow(poly.x_value, i);

        FILE* write_pipe = fopen(PIPE2, "w");
        if(write_pipe != NULL){
            fwrite(&result, sizeof(int), 1, write_pipe);
            fclose(write_pipe);
        }

        exit('a');
    }

    // parent process
    Polynomial poly = newPolynomial();

    poly.coefficients[0] = 5;
    poly.coefficients[1] = 2;
    poly.coefficients[2] = 1;

    poly.x_value = 2;

    FILE* write_pipe = fopen(PIPE1, "w");
    if(write_pipe != NULL){
        fwrite(&poly, sizeof(Polynomial), 1, write_pipe);
        fclose(write_pipe);
    }

    int result = 0;
    FILE* read_pipe = fopen(PIPE2, "r");
    if(read_pipe != NULL){
        fread(&result, sizeof(int), 1, read_pipe);
        fclose(read_pipe);
    }

    printf("%d\n", result);

    unlink(PIPE1);
    unlink(PIPE2);

    return 0;
}