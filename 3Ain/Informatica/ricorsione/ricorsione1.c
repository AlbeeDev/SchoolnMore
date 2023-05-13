#include<stdio.h>
#include<string.h>
#include<stdbool.h>
//1a
int max(int arr[],size_t n){
	if(n==1){
		return arr[n-1];
	}
	if(arr[n-2]>arr[n-1]){
		return max(arr,n-1);
	}
	arr[n-2]=arr[n-1];
	return max(arr,n-1);
}
//1b
bool search(int arr[], size_t n, int value){
	if(n==0){
		return false;
	}
	if(arr[n-1]==value){
		return true;
	}
	
	return search(arr,n-1,value);
}
int main(){
	//1
	int arr1[]={0,1,2,3,4,9,6,7,8,5};
	size_t n1=sizeof(arr1)/sizeof(arr1[0]);
	printf("%i\n",max(arr1,n1));
	
	int value=6;
	int arr2[]={0,1,2,3,4,9,6,7,8,5};
	size_t n2=sizeof(arr2)/sizeof(arr2[0]);
	printf("%i\n",search(arr2,n2,value));
	
	
	
	
	
	
	 
}
