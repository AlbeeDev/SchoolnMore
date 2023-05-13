#include <stdio.h>

void carica(char *filename, size_t *listalen, int *lista)
{
    FILE *fp = fopen(filename, "r");
    if (fp!=NULL)
    {
        while (fscanf(fp, "%d, ", &lista[*listalen])==1)
        {
            (*listalen)++;
        }
        fclose(fp);
    }
}

void swap(int *xp, int *yp){
    int temp = *xp;
    *xp = *yp;
    *yp = temp;
}
  
void selectionsort(int arr[], int n){
    int i, j, min_idx;
    for (i = 0; i < n-1; i++){
        min_idx = i;
        for (j = i+1; j < n; j++)
          if (arr[j] < arr[min_idx])
            min_idx = j;
        swap(&arr[min_idx], &arr[i]);
    }
}
int main() {
    size_t lista1len = 0;
    int lista1[100];
    size_t lista2len = 0;
    int lista2[100];

    carica("file1.txt", &lista1len, lista1);
    carica("file2.txt", &lista2len, lista2);
    
	size_t listadestlen=lista1len+lista2len;
	int listadest[100];
	size_t i=0;
    for(i=0;i<lista1len;i++){
    	listadest[i]=lista1[i];
	}
	for(i=lista1len;i<listadestlen;i++){
		listadest[i]=lista2[i-lista1len];
	}
	
	selectionsort(listadest,listadestlen);
	
	for(i=0;i<listadestlen-1;i++){
		if(listadest[i]==listadest[i+1]){
			for(size_t j=i;j<listadestlen-1;j++){
				listadest[j]=listadest[j+1];
			}
			listadestlen--;
			i--;
		}
	}
	
	FILE *fp = fopen("destinazione.txt", "w");
	if(fp!=NULL){
		for(i=0;i<listadestlen;i++){
			fprintf(fp,"%i ",listadest[i]);
		}
		fclose(fp);
	}
    return 0;
}
