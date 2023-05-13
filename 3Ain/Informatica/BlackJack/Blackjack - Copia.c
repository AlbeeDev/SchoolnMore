#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
#include<conio.h>
#include<time.h>
float betsize(float balance){
	bool valid=false;
	char option;
	while(valid==false){
		printf("bet size: press 1 to play at $1/bet or 2 to play at $10/bet or 3 to play at $100/bet or 4 to play $1k/bet or 5 to play at $10k/bet: ");
		option=getch();
		if (kbhit()){
			option=getch();
		}
		switch(option)
		{
			case 49:
				if(balance>=1.0){
					valid=true;
					return 1.0;
				}
				valid=false;
				printf("Invalid option: low balance!\n");
				break;
			case 50:
				if(balance>=10.0){
					valid=true;
					return 10.0;
				}
				valid=false;
				printf("Invalid option: low balance!\n");
				break;
			case 51:
				if(balance>=100.0){
					valid=true;
					return 100.0;
				}
				valid=false;
				printf("Invalid option: low balance!\n");
				break;
			case 52:
				if(balance>=1000.0){
					valid=true;
					return 1000.0;
				}
				valid=false;
				printf("Invalid option: low balance!\n");
				break;
			case 53:
				if(balance>=10000.0){
					valid=true;
					return 10000.0;
				}
				valid=false;
				printf("Invalid option: low balance!\n");
				break;
			default:
				valid=false;
				printf("not a valit option!\n");
				break;
		}
	}
}
//creazione del mazzo
void cardalg(int cards[52]){
	int x=1;
	for(size_t i=0;i<49;i+=4){
		cards[i]=x;
		cards[i+1]=x;
		cards[i+2]=x;
		cards[i+3]=x;
		if(x<10){
			x++;
		}
	}
}
//mischia le carte
void shuffle(int deck[52],int cards[52]){
	for(size_t i=0;i<52;i++){
		deck[i]=cards[i];
	}
	for(int i=0;i<rand()%1000+2000;i++){
		size_t j=rand()%52;
		size_t k=rand()%52;
		int temp=deck[j];
		deck[j]=deck[k];
		deck[k]=temp;
	}
}
//distribuzione di una carta
void distribute(int deck[52],size_t deck_idx,int x[11],size_t x_idx){
	x[x_idx]=deck[deck_idx];
}
//stampa del gioo a video
void game_print(int dealer[11],size_t dealer_idx,int player[11],size_t player_idx,int dvalue1,int dvalue2,int pvalue1,int pvalue2,size_t var){
	if(dvalue1==dvalue2){
		printf("\ndealer: ");
		for(size_t i=0;i<dealer_idx-var;i++){
			printf("%i ",dealer[i]);
		}
		if(var==1){
			printf("\ndealer value: %i+?\n",dvalue1);
		}
		if(var==0){
			printf("\ndealer value: %i\n",dvalue1);
		}	
	}
	else{
		printf("\ndealer: ");
		for(size_t i=0;i<dealer_idx-var;i++){
			printf("%i ",dealer[i]);
		}
		if(var==1){
			printf("\ndealer value: %i+?/%i+?\n",dvalue1,dvalue2);
		}
		if(var==0){
			printf("\ndealer value: %i/%i\n",dvalue1,dvalue2);
		}
	}
	if(pvalue1==pvalue2){
		printf("\nplayer: ");
		for(size_t i=0;i<player_idx;i++){
			printf("%i ",player[i]);
		}
		printf("\nplayer value: %i\n",pvalue1);
	}
	else{
		printf("\nplayer: ");
		for(size_t i=0;i<player_idx;i++){
			printf("%i ",player[i]);
		}
		printf("\nplayer value: %i/%i\n",pvalue1,pvalue2);
	}
	printf("---------------------");
}
//controllo di primo caso di vittoria 
bool check_win_21(int value1,int value2){
	if(value1==21 || value2==21){
		return true;
	}
	return false;
}
//controllo di secondo caso di vittoria
int check_win(int pvalue1,int dvalue1,int dvalue2){
	if((dvalue2>=17 && dvalue2<=21) || (dvalue1>=17 && dvalue1<=21)){
		if(dvalue1==pvalue1 || dvalue2==pvalue1){
			return 3;
		}
		if(dvalue1>pvalue1 && dvalue2>pvalue1){
			return 1;
		}
		if(dvalue1<pvalue1 || dvalue2<pvalue1){
			return 2;	
		}
	}
	return 0;
}

int optionf(void){
	bool valid=false;
	char option;
	while(valid==false){
		printf("\npress 'h' to hit or 's' to stay: ");
		option=getch();
		if (kbhit()){
			option=getch();
		}
		switch(option)
		{
			case 'h':
				valid=true;
				return 1;
				break;
			case 's':
				valid=true;
				return 3;
				break;
			default:
				printf("not a valid option!\n");
				break;
		}
	}
} 
//gioco
int game(int cards[52],int wins,int draws,int losses,int space,char s){
	int deck[52];
	size_t deck_idx=0;
	size_t dealer_idx=0;
	size_t player_idx=0;
	shuffle(deck,cards);
	int dealer[11]={0};
	int player[11]={0};
	for(int i=0;i<2;i++){
		distribute(deck,deck_idx,player,player_idx);
		player_idx++;
		deck_idx++;
	}
	for(int i=0;i<2;i++){
		distribute(deck,deck_idx,dealer,dealer_idx);
		dealer_idx++;
		deck_idx++;
	}
	
	int pvalue1=0;
	int pvalue2=0;
	pvalue1=player[0]+player[1];
	pvalue2=pvalue1;
	if(player[0]==1 || player[1]==1){
		pvalue2+=10;
	}
	int dvalue1=0;
	int dvalue2=0;
	dvalue1=dealer[0];
	dvalue2=dvalue1;
	if(dealer[0]==1){
		dvalue2+=10;
	}
	size_t var=1;
	game_print(dealer,dealer_idx,player,player_idx,dvalue1,dvalue2,pvalue1,pvalue2,var);
	
	if(check_win_21(pvalue1,pvalue2)==true){
		printf("\nPlayer wins!\n");
		return 3;
	}
	while((pvalue1<=21 || pvalue2<=21) && optionf()==1){
		distribute(deck,deck_idx,player,player_idx);
		player_idx++;
		deck_idx++;
		pvalue1+=player[player_idx-1];
		pvalue2+=player[player_idx-1];
		bool x=false;
		if(player[player_idx-1]==1){
			for(size_t i=0;i<player_idx-1;i++){
				if(player[i]==1){
					x=true;
				}
			}
			if(x==false){
				pvalue2+=10;
			}
		}
		printf("\n\nPlayer's Card: %i\n",player[player_idx-1]);
		game_print(dealer,dealer_idx,player,player_idx,dvalue1,dvalue2,pvalue1,pvalue2,var);
		if(check_win_21(pvalue1,pvalue2)==true){
			printf("\nPlayer wins!\n");
			return 1;
		}
	}
	if(pvalue1>21 && pvalue2>21){
		printf("\nPlayer Busts! Dealer wins!\n");
		return 0;
	}
	
	if(pvalue2<21){
		pvalue1=pvalue2;
	}
	printf("\nPlayer stays! Dealer's turn:\n");
	printf("\nHidden card was %i",dealer[1]);
	dvalue1+=dealer[1];
	dvalue2+=dealer[1];
	bool x=false;
	if(dealer[dealer_idx-1]==1){
			for(size_t i=0;i<dealer_idx-1;i++){
				if(dealer[i]==1){
					x=true;
				}
			}
			if(x==false){
				dvalue2+=10;
			}
		}
	var=0;
	game_print(dealer,dealer_idx,player,player_idx,dvalue1,dvalue2,pvalue1,pvalue2,var);
	if(check_win_21(dvalue1,dvalue2)==true || check_win(pvalue1,dvalue1,dvalue2)==1){
			printf("\nDealer wins!\n");
			return 0;
		}
		if(check_win(pvalue1,dvalue1,dvalue2)==2){
			printf("\nPlayer wins!\n");
			return 1;
		}
	while(dvalue1<=21 || dvalue2<=21){
		distribute(deck,deck_idx,dealer,dealer_idx);
		dealer_idx++;
		deck_idx++;
		dvalue1+=dealer[dealer_idx-1];
		dvalue2+=dealer[dealer_idx-1];
		bool x=false;
		if(dealer[dealer_idx-1]==1){
			for(size_t i=0;i<dealer_idx-1;i++){
				if(dealer[i]==1){
					x=true;
				}
			}
			if(x==false){
				dvalue2+=10;
			}
		}
		printf("\n\nDealer's Card: %i\n",dealer[dealer_idx-1]);
		game_print(dealer,dealer_idx,player,player_idx,dvalue1,dvalue2,pvalue1,pvalue2,var);
		if(check_win_21(dvalue1,dvalue2)==true || check_win(pvalue1,dvalue1,dvalue2)==1){
			printf("\nDealer wins!\n");
			return 0;
		}
		if(check_win(pvalue1,dvalue1,dvalue2)==2){
			printf("\nPlayer wins!\n");
			return 1;
		}
		if(check_win(pvalue1,dvalue1,dvalue2)==3){
			printf("\nIts a Draw!\n");
			return 2;
		}
		if(dvalue1>21 && dvalue2>21){
			printf("\nDealer Busts! Player wins!\n");
			return 1;
		}
	}
	return 0;
}
//gioca ancora
bool playagain(void){
	bool valid=false;
	char option;
	while(valid==false){
		printf("\npress enter to play again or any other to leave: \n");
		option=getch();
		if (kbhit()){
			option=getch();
		}
		switch(option)
		{
			case 13:
				valid=true;
				return true;
				break;
			default:
				return false;
				break;
		}
	}
}
int main(){
	srand(time(NULL));
	int cards[52];
	cardalg(cards);
	int wins=0,draws=0,losses=0;
	float balance;
	float bet;
	printf("how much money do you want to start with? (max balance 1m$)\n");
	bool isbal=false;
	while(isbal==false){
		scanf("%f",&balance);
		if(balance>0 && balance<1000000){
			bet=betsize(balance);
			isbal=true;
		}
		else{
			printf("Invalid ammount!\n");
		}
	}
	
	bool x=true;
	while(x==true){
		system("cls");
		int space=50;
		char s=' ';
		printf("Balance: %.2f$ at %.0f$/bet %*c Wins: %i - Draws: %i - Losses: %i\n",balance,bet,space,s,wins,draws,losses);
		
		int y=0;
		y=game(cards,wins,draws,losses,space,s);
		if(y==0){
			losses+=1;
			balance-=bet;
		}
		if(y==1){
			wins+=1;
			balance+=bet;
		}
		if(y==2){
			draws+=1;
		}
		if(y==3){
			wins+=1;
			balance+=3*(bet/2.0);	
		}
		x=playagain();
	}
}
