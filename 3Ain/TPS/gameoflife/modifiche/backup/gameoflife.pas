program gameoflife;

{$mode objfpc}{$H+}

uses
  {$IFDEF UNIX}{$IFDEF UseCThreads}
  cthreads,
  {$ENDIF}{$ENDIF}
  Classes
  { you can add units after this };
type
  matrix= array[1..30, 1..30] of integer;
var
  mat1,mat2 : matrix;
  i,j,h,k,l,x:integer;
procedure game(mat1: matrix; i,j,h,k,l,x:integer; mat2: matrix);
        begin
        for i:=0 to 29 do
        for j:=0 to 29 do begin
        mat2[i,j]:=0;
        end;
  	for h:=0 to 9 do
                begin
  		for i:=0 to 29 do
                        begin
  			for j:=0 to 29 do
                                begin
  				x:=0;
  				for k:=-1 to 1 do
  					for l:=-1 to 1 do
  						if mat1[i+k,j+l]=1 then
  							x+=1;
  				if mat1[i,j]=0 then
                                        begin
  					if x=3 then
  						mat2[i,j]:=1;
  					if x<>3 then
  						mat2[i,j]:=0;
  				        end;
  				if mat1[i,j]=1 then
                                        begin
  					if (x<3) or (x>4) then
  						mat2[i,j]:=0;
  					if (x=3) or (x=4) then
  						mat2[i,j]:=1;
  				        end;
  				write(mat2[i][j],' ');
  			        end;
                        writeln;
  		        end;
                writeln;
  		for i:=0 to 29 do
  		        for j:=0 to 29 do
  		                mat1[i,j]:=mat2[i,j];
  	        end;
        end;
procedure startpos(mat1: matrix; i,j:integer);
begin
     for i:=0 to 29 do
                for j:=0 to 29 do
                           begin
                           mat1[i,j]:=0;
			   if ((i=1) and (j=1)) or ((i=1) and (j=2)) or ((i=2) and (j=1)) or ((i=3) and (j=4)) or ((i=4) and (j=4)) or ((i=4) and (j=3)) then
			            mat1[i,j]:=1;
		           end;
end;
//programma
begin
     i:=0;j:=0;h:=0;k:=0;l:=0;x:=0;
     startpos(mat1,i,j);
     game(mat1,i,j,h,k,l,x,mat2);
     readln();
end.

