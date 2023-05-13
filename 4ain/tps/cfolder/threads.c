#include <pthread.h>
#include <stdio.h>
#include <time.h>
#include <stdlib.h>


pthread_mutex_t mutex;
int value=0;

void* inc (void* arg){
    pthread_mutex_lock(&mutex);
    value+=1;
    
    printf("inc to %d %d\n",value,pthread_self());
    pthread_mutex_unlock(&mutex);
}

void* dec (void* arg){
    pthread_mutex_lock(&mutex);
    value-=1;
    printf("dec to %d %d\n",value, pthread_self());
    pthread_mutex_unlock(&mutex);
}

int main(){
    srand(time(NULL)); 
    printf("inizio con valore %d \n",value);
    int rinc = rand() % 20 +20;
    int rdec = rand() % 20 +20;
    printf("incrementa %d e decrementa %d \n",rinc,rdec);
    pthread_t t1[rinc],t2[rdec];
    pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;
    for(int i=0;i<rinc;i++) pthread_create(&t1[i],NULL,inc,NULL);
    for(int i=0;i<rdec;i++) pthread_create(&t2[i],NULL,dec,NULL);
    for(int i=0;i<rinc;i++) pthread_join(t1[i],NULL);
    for(int i=0;i<rinc;i++) pthread_join(t2[i],NULL);
    printf("fine con valore %d \n",value);
}