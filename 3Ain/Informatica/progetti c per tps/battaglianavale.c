#include<stdio.h>
#include<string.h>
int main(){
	//aggiungi campo2 dopo traduzione in pascal
	int campo1[10][10]={0};
	int campo2[10][10]={0};
	size_t rows=sizeof(campo1)/sizeof(campo1[0]);
	size_t cols=sizeof(campo1[0])/sizeof(campo1[0][0]);
	int x,y;
	int hasplayerwon=0;
	//campo 1
	for(size_t i=0;i<3;i++){
		int mode=0,k=0;
		while(mode!=1 && mode!=2){
			printf("modalita di posizione: (1:verticale,2:orizzontale)\n");
			scanf("%i",&mode);
			if(mode!=1 && mode!=2){
				printf("modalita non disponibile.\n");
			}
		}
		printf("coordinate cacciatorpediniere %i: ([x,y][-])\n",i+1);
		while(k==0){
			printf("x: ");
			scanf("%i",&x);
			printf("y: ");
			scanf("%i",&y);
			if(mode==1){
				if(x>=0 && x<9){
					if(campo1[x][y]!=1 && campo1[x+1][y]!=1){
						k=1;
					}
					else{
						printf("coordinate gia occupate da un altra nave.\n");
					}	
				}
				else{
					printf("la nave è fuori dal range.\n");
				}
			}
			if(mode==2){
				if(y>=0 && y<9){
					if(campo1[x][y]!=1 && campo1[x][y+1]!=1){
						k=1;
					}
					else{
						printf("coordinate gia occupate da un altra nave.\n");
					}	
				}
				else{
					printf("la nave è fuori dal range.\n");
				}
			}
		}
		if(mode==1){
			campo1[x][y]=1;
			campo1[x+1][y]=1;
		}
		if(mode==2){
			campo1[x][y]=1;
			campo1[x][y+1]=1;
		}	
	}
	
	for(size_t i=0;i<2;i++){
		int mode=0,k=0;
		while(mode!=1 && mode!=2){
			printf("modalita di posizione: (1:verticale,2:orizzontale)\n");
			scanf("%i",&mode);
			if(mode!=1 && mode!=2){
				printf("modalita non disponibile.\n");
			}
		}
		printf("coordinate incrociatore %i: ([-][x,y][-])\n",i+1);
		while(k==0){
			printf("x: ");
			scanf("%i",&x);
			printf("y: ");
			scanf("%i",&y);
			if(mode==1){
				if(x>0 && x<9){
					if(campo1[x][y]!=1 && campo1[x+1][y]!=1 && campo1[x-1][y]!=1){
						k=1;
					}
					else{
						printf("coordinate gia occupate da un altra nave.\n");
					}	
				}
				else{
					printf("la nave è fuori dal range.\n");
				}
			}
			if(mode==2){
				if(y>0 && y<9){
					if(campo1[x][y]!=1 && campo1[x][y+1]!=1 && campo1[x][y-1]!=1){
						k=1;
					}
					else{
						printf("coordinate gia occupate da un altra nave.\n");
					}		
				}
				else{
					printf("la nave è fuori dal range.\n");
				}
			}
		}
		if(mode==1){
			campo1[x-1][y]=1;
			campo1[x][y]=1;
			campo1[x+1][y]=1;
		}
		if(mode==2){
			campo1[x][y-1]=1;
			campo1[x][y]=1;
			campo1[x][y+1]=1;
		}
	}
	for(size_t i=0;i<1;i++){
		int mode=0,k=0;
		while(mode!=1 && mode!=2){
			printf("modalita di posizione: (1:verticale,2:orizzontale)\n");
			scanf("%i",&mode);
			if(mode!=1 && mode!=2){
				printf("modalita non disponibile.\n");
			}
		}
		printf("coordinate corazzato: ([-][x,y][-][-])\n");
		while(k==0){
			printf("x: ");
			scanf("%i",&x);
			printf("y: ");
			scanf("%i",&y);
			if(mode==1){	
				if(x>0 && x<8){
					if(campo1[x][y]!=1 && campo1[x+1][y]!=1 && campo1[x-1][y]!=1 && campo1[x+2][y]!=1){
						k=1;
					}
					else{
						printf("coordinate gia occupate da un altra nave.\n");
					}	
				}
				else{
					printf("la nave è fuori dal range.\n");
				}
			}
			if(mode==2){	
				if(y>0 && y<8){
					if(campo1[x][y]!=1 && campo1[x][y+1]!=1 && campo1[x][y-1]!=1 && campo1[x][y+2]!=1){
						k=1;
					}
					else{
						printf("coordinate gia occupate da un altra nave.\n");
					}	
				}
				else{
					printf("la nave è fuori dal range.\n");
				}
			}
		}
		if(mode==1){
			campo1[x-1][y]=1;
			campo1[x][y]=1;
			campo1[x+1][y]=1;
			campo1[x+2][y]=1;
		}
		if(mode==2){
			campo1[x][y-1]=1;
			campo1[x][y]=1;
			campo1[x][y+1]=1;
			campo1[x][y+2]=1;
		}
	}
	printf("  y ");
	for(size_t i=0;i<cols;i++){
		printf(" %i ",i);
	}
	printf("\n");
	printf("x\n");
	for(size_t i=0;i<rows;i++){
		printf("%i   ",i);
		for(size_t j=0;j<cols;j++){
			printf("[%i]",campo1[i][j]);	
		}
		printf("\n");
	}
	//gioco
	while(hasplayerwon==0){
		int hasplayerwon=0;
		printf("giocatore 1 colpisce: \n");
		printf("x: ");
		scanf("%i",&x);
		printf("y: ");
		scanf("%i",&y);
		if(campo2[x][y]==1){
			printf("hai colpito una nave\n");
			campo2[x][y]==0;
		}
		else{
			printf("hai mancato\n");
		}
		for(size_t i=0;i<rows;i++){
			for(size_t j=0;j<cols;j++){
				if(campo2[i][j]==1){
					hasplayer1won=0;
				}
			}
		}
		if(hasplayerwon==1){
			printf("giocatore 1 vince!");
		}
		else{
			
		}
	}
}
