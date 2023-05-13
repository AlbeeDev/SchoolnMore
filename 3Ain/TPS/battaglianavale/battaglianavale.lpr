program battaglianavale;

{$mode objfpc}{$H+}

uses
  {$IFDEF UNIX}{$IFDEF UseCThreads}
  cthreads,
  {$ENDIF}{$ENDIF}
  Classes
  { you can add units after this };
type
   mat=array[0..10,0..10] of integer;
var
   campo1,campo2:mat;
   i,j,x,y,mode,k:integer;
begin
        for i:=0 to 10 do
            for j:=0 to 10 do
                campo1[i,j]:=0;

	for i:=0 to 3 do
        begin
		mode:=0;
                k:=0;
		while (mode<>1) and (mode<>2) do
                begin
			writeln('modalita di posizione: (1:verticale,2:orizzontale)');
			readln(mode);
			if(mode<>1) and (mode<>2) then
				writeln('modalita non disponibile.');
		end;
		writeln('coordinate cacciatorpediniere ',i+1,': ([x,y][-])');
		while k=0 do
                begin
			write('x: ');
			scanf("%i",&x);
			printf("y: ");
			scanf("%i",&y);
			if(mode==1)
                        begin
				if(x>=0 && x<9)
                                begin
					if(campo1[x][y]!=1 && campo1[x+1][y]!=1)
						k=1;//togli il ; se necessario
					else
						printf("coordinate gia occupate da un altra nave.\n");
				end;
				else
					printf("la nave è fuori dal range.\n");
			end;
			if(mode==2)
                        begin
				if(y>=0 && y<9)
                                begin
					if(campo1[x][y]!=1 && campo1[x][y+1]!=1)
						k=1;
					else
						printf("coordinate gia occupate da un altra nave.\n");
				end;
				else
					printf("la nave è fuori dal range.\n");
			end;
		end;
		if(mode==1)
                begin
			campo1[x][y]=1;
			campo1[x+1][y]=1;
		end;
		if(mode==2)
                begin
			campo1[x][y]=1;
			campo1[x][y+1]=1;
		end;
	end;

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
end.

