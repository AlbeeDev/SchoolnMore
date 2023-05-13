#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>  //Header file for sleep(). man 3 sleep for details.
#include <pthread.h>
  
// A normal C function that is executed as a thread 
// when its name is specified in pthread_create()
void *myThreadFun(int rep)
{
	for(int i=0;i<100;i++){
		Sleep(17);
		rep+=2;
    	printf("Printing GeeksQuiz from Thread \n");
	}
	return rep;
}
   
int main()
{
	int rep=0;
    pthread_t thread_id;
    printf("Before Thread\n");
    pthread_create(&thread_id, NULL, myThreadFun, NULL);
    printf("first thread asks for a char:\n");
    sleep(1);
    printf("all set. waiting for thread 2 to terminate\n");
    //pthread_exit(rep);
    pthread_join(thread_id, rep);
    printf("2nd Thread terminated value: %i\n",rep);
    exit(0);
}
