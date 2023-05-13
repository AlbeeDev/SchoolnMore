#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/stat.h>
#include <sys/types.h>

#define PIPE1 "/tmp/pipe1"
#define PIPE2 "/tmp/pipe2"

typedef struct {
    int value;
} datastruct;

int main(){
    mkfifo(PIPE1, 0666);
    mkfifo(PIPE2, 0666);
    int status;
  
    int pidrosa = fork();
    if(pidrosa==0){
      printf("rosa: iniziato con PID %d, figlio di padre %d\n", getpid(),getppid());
      sleep(2);
      printf("rosa: Ho terminato con valore 11\n");
      exit(11);
    }
    waitpid(pidrosa, &status, 0);
    if (WIFEXITED(status)) {
      printf("padre: Rosa con PID %d è terminato con valore %d\n", pidrosa,WEXITSTATUS(status));
    }


  
    int piddalia = fork();
    if(piddalia==0){ // child process A
        printf("dalia: iniziato con PID %d, figlio di padre %d\n", getpid(),getppid());
        sleep(1);
        int pidViola = fork();
        if (pidViola == 0) {
          printf("viola: iniziato con PID %d, figlio di %d\n", getpid(),piddalia);
          sleep(2);
          printf("viola: Ho terminato con valore 7\n");
          exit(7);
        }
        waitpid(pidViola, &status, 0);
        if (WIFEXITED(status)) {
          printf("dalia: Il processo Viola con PID %d è terminato con valore %d\n",pidViola,WEXITSTATUS(status));
        }
        int result = 0;
        datastruct ds;
        FILE* read_pipe = fopen(PIPE1, "r");
        if(read_pipe != NULL){
            fread(&ds, sizeof(datastruct), 1, read_pipe);
            fclose(read_pipe);
        }
        printf("dalia riceve da padre %d\n",ds.value);
        result=ds.value*2;

        FILE* write_pipe = fopen(PIPE2, "w");
        if(write_pipe != NULL){
            printf("dalia invia a padre %d\n",result);
            fwrite(&result, sizeof(int), 1, write_pipe);
            fclose(write_pipe);
        }
        printf("dalia: Ho terminato con valore 5\n");
        exit(5);
    }

    // parent process
    datastruct ds;
    ds.value = 5;
    FILE* write_pipe = fopen(PIPE1, "w");
    if(write_pipe != NULL){
        printf("padre invia a dalia %d\n",ds.value);
        fwrite(&ds, sizeof(datastruct), 1, write_pipe);
        fclose(write_pipe);
    }

    int result = 0;
    FILE* read_pipe = fopen(PIPE2, "r");
    if(read_pipe != NULL){
        fread(&result, sizeof(int), 1, read_pipe);
        fclose(read_pipe);
    }

    printf("padre riceve da dalia %d\n", result);

    waitpid(piddalia, &status, 0);
    if (WIFEXITED(status)) {
      printf("padre: Il processo Dalia con PID %d è terminato con valore %d\n",piddalia, WEXITSTATUS(status));
    }
    unlink(PIPE1);
    unlink(PIPE2);
    printf("main: Il processo padre con PID %d è terminato",getpid());
    return 0;
}