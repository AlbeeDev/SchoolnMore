#include <stdio.h>
#include <pthread.h>

void* createthread(void *arg){
    printf("helo %d",pthread_self);
}

int main(){
    pthread_t tid;
    int var = 5;
    pthread_create(&tid,NULL,createthread,NULL);
    pthread_join(tid,NULL);
}