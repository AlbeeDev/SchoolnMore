#include <pthread.h>
#include <stdlib.h>
#include <stdio.h>

void *do_thread(void *arg){
    int ris,*ptr;
    //printf
    ris= - *((int*)arg);
    free(arg);

    ptr=(int*)malloc(sizeof(int));
    if(ptr==NULL){
        perror("malloc failed: ");
        pthread_exit(NULL);
    }
    else{
        *ptr=ris;
        pthread_exit((void*)ptr);
    }
}


int NUM_THREADS=10;
int main(){
    pthread_t vthreads[NUM_THREADS];
    int rc,t,*p;

    //printf
    for (t = 0; t < NUM_THREADS; t++){
        p=(int*)malloc(sizeof(int));
        if(p==NULL){
            perror("malloc failed: ");
            pthread_exit(NULL);
        }
        
        *p=t;

        rc = pthread_create(&vthreads[t],NULL,do_thread,(void*)p);
        if (rc)
        {
            //printf
            exit(-1);
        }
        else{
            //printf
        }
    }

    for (t = 0; t < NUM_THREADS; t++){
        int error;
        void* ptr;

        error=pthread_join(vthreads[t],(void**)&ptr);

        if (error){
            //printf
            exit(-1);
        }
        else{
            //printf
            free(ptr);
        }
    }
    pthread_exit(NULL);
    return 1;
}