#include<stdio.h>
#include<string.h>
struct desc{
	char name[20];
	char gender[3];
	int age;
};

int main(){
	struct desc person[20];
	int n;
	for(size_t i=0;i<20;i++){
		printf("nome della %i persona: ",i+1);
		fgets(person[i].name,20,stdin);
		printf("%s",person[i].name);
		printf("sesso della %i persona: ",i+1);
		fgets(person[i].gender,3,stdin);
		printf("%s",person[i].gender);
	}
}
