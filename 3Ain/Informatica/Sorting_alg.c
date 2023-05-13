#include <stdio.h>
#include <stdbool.h>
#define min 2
#define max 4
void swap(int *x,int *y){
	int temp = *x;
	*x=*y;
	*y= temp;
}
bool xxx(int arr[],int n){
	for(int i=0;i<n-1;i++){
		int j= i+1;
		if(arr[i]<arr[j])
		return true;
		
	}
return false;
}
void selectionsort(int arr[],size_t n){
	for(size_t i=0;i<n;i++){
		int min_idx=i;
		for(size_t j=i+1;j<n;j++)
			if(arr[j]<arr[min_idx])
			min_idx=j;
		swap(&arr[min_idx],&arr[i]);
	}
}
void insertionsort(int arr[], int n){
	for(int i=0;i<n;i++){
		int key=arr[i];
		int j=i-1;
		while(j>=0 && arr[j]>key){
			arr[j+1]=arr[j];
			j--;
		}
		arr[j+1]=key;
	}
}
void bubblesort(int arr[],int n){
	for(int i=0;i<n-1;i++)
		for(int j=0;j<n-i-1;j++)
			if(arr[j]>arr[j+1])
				swap(&arr[j],&arr[j+1]);
}
void printarray(int arr[], int size){
	for (int i=0;i< size;i++){
		printf("%i ", arr[i]);
	}
}
int main(){
	int arr[]={34,27,13,98,56,87,10,};
	unsigned n=sizeof(arr)/sizeof(arr[0]);
	selectionsort(arr,n);
	printarray(arr,n);
	printf("\n");
	insertionsort(arr,n);
	printarray(arr,n);
	printf("\n");
	bubblesort(arr,n);
	printarray(arr,n);
	printf("\n");
	int x=rand()%(max-min)+min;
	printf("%i", x);
	return 0;
}
