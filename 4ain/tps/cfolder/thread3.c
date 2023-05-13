/* banale_giusto.c  */
#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <pthread.h>

#define NUM_THREADS 5

void* codiceThread(void* arg) // ricevo arg come ptore a void (ultimo parametro della create)
{
	sleep(4);
	printf("\n index %d\n", *( (int*)arg ) ); //casto p a int*  poi lo dereferenzio
	free(arg); // libero la mem che è stata usata per passarmi il dato
	pthread_exit (NULL);
}

int main()
{
	pthread_t tid;
	int rc, t, *p;                    
	for(t=0;t < NUM_THREADS;t++){
  	p=(int*)malloc(sizeof(int));       /* alloco memoria sullo heap in cui mettere i parametri per i pthread */
		if(p==NULL) {
			perror("malloc failed: ");
			pthread_exit (NULL);
		}
		*p= t; //assegno il valore t all'area di mem puntata da p DATO DA PASSARE
		printf("Creating thread %d\n", t);
		rc = pthread_create (&tid, NULL, codiceThread, (void*)p );  /* NOTARE l'ultimo parametro */
		if (rc){
			printf("ERROR; return code from pthread_create() is %d\n",rc);
			exit(-1);
		}
	}

  sleep(1); //altrimenti potrebbero non avere il tempo di partire
  
  for(t=0;t < NUM_THREADS;t++){
    pthread_join(tid, NULL);
  }
	printf("fine main\n"); 
  fflush(stdout);
	return(0);
}
