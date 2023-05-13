#include<stdio.h>
#include<stdbool.h>
int exp(int val,int ex){
	int n=ex-1,modval=val;
	while(n>0){
		modval*=val;
		n--;
	}
	return modval;
}
float combalg(int n,int s,int idx[],int dado[],float ctr,int set_i){
	int sum=0;
	for(size_t i=0;i<n;i++){
//		printf("- dado %i valore faccia %i\n",i+1,dado[idx[i]]);
		sum+=dado[idx[i]];
		if(i==n-1){
//			printf("- sum %i\n",sum);
		}	

	}
	if(sum==s){
		ctr+=1.0;
//		printf("- ctr +1 is %.0f\n",ctr);
	}
	sum=0;
	for(size_t i=set_i;i<n;i++){
		if(idx[i]<5){	
			idx[i]+=1;
			return combalg(n,s,idx,dado,ctr,set_i);
		}
		else{
			bool islast=true;
			for(size_t k=0;k<n;k++){
				if(idx[k]<5){
					islast=false;
				}
			}
			if(islast==true){
//				printf("- return ctr is %.0f\n",ctr);
				return ctr;
			}
			else{
				idx[i]=0;
			}
			for(size_t j=1;j<n-i;j++){
				if(idx[i+j]<5){
					idx[i+j]+=1;
					return combalg(n,s,idx,dado,ctr,set_i);
				}
				else{
					idx[i+j]=0;
				}
			}
		}
	}
}
int main(){
	int dadi,somma=0;
	float result,comb,totalcomb;
	printf("inserisci numero di dadi (>1 <6): ");
	do{
		scanf("%i",&dadi);
	}while(dadi<2 || dadi>5);
	totalcomb=exp(6,dadi);
//	printf("ci sono %.0f possibili combinazioni\n",totalcomb);
	printf("inserisci somma dadi: ");
	while(somma<dadi){
		scanf("%i",&somma);
	}
	int idx[11]={0};
	int s,set_i=0,sni=0;
	int counter=0;
	int dado[]={1,2,3,4,5,6};
	comb=combalg(dadi,somma,idx,dado,counter,set_i);
//	printf("possibili %.0f combinazioni che risultano somma %i\n",comb,somma);
	result=comb/totalcomb;
	printf("probabilita: %.2f%c",result*100,37);
}
