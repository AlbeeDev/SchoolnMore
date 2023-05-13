program verbi;
//albano alex 3ain
{$mode objfpc}{$H+}

uses
  {$IFDEF UNIX}{$IFDEF UseCThreads}
  cthreads,
  {$ENDIF}{$ENDIF}
  Classes
  { you can add units after this };
type
    str=array[1..50] of char;
var
    intransitivo,index:integer;
    intransitivi,verbo,presente,passatopr:str;
    n,i:SIZE_T;
begin
     intransitivo:=0;
     intransitivi:=('nuotare'),'camminare','andare','arrivare','avanzare','entrare','innamorare','capitare';
     n=sizeof(intransitivi)/sizeof(intransitivi[0]);
     readln(verbo);
     if (verbo[length(verbo)-4]<>'a') or (verbo[length(verbo)-3]<>'r') or (verbo[length(verbo)-2]<>'e') then
     writeln('verbo non è di prima coniugazione');
     else
        begin
	if verbo[length(verbo)-1]='\n');
           verbo[length(verbo)-1]:='\0';
	for i:=0 to n-1 do
            begin
	    if CompareStr(verbo,intransitivi[i])=0 then
               begin
	       intransitivo:=1;
	       index:=i;
	       end;
	    end;
	    if intransitivo=1 then
               begin
	       writeln('intransitivo');
	       if(index=0) or (index=1) then
                  begin
	          for i:=0 to length(verbo)-3 do
	              presente[i]:=verbo[i];
	          presente[length(verbo)-3]:='o';
	          writeln(presente);

	          passatopr[0]:='h';
	          passatopr[1]:='o';
	          passatopr[2]:=' ';
	          for i:=0 to length(verbo)-2 do
	              passatopr[i+3]:=verbo[i];
	          passatopr[length(verbo)+1]:='t';
	          passatopr[length(verbo)+2]:='o';
	          passatopr[length(verbo)+3]:='\n';
	          writeln(passatopr);
	          end;
	       if index=2 then
                  begin
	          presente[0]:='v';
	          presente[1]:='a';
	          presente[2]:='d';
	          presente[3]:='o';
	          writeln(presente);

	          passatopr[0]:='s';
	          passatopr[1]:='o';
	          passatopr[2]:='n';
	          passatopr[3]:='o';
	          passatopr[4]:=' ';
	          for i:=0 to length(verbo)-2 do
	              passatopr[i+5]:=verbo[i];
	          passatopr[length(verbo)+3]:='t';
	          passatopr[length(verbo)+4]:='o';
                  passatopr[length(verbo)+5]:='\n';
	          writeln(passatopr);
	          end;
	       if index>2 then
                  begin
	          for i:=0 to length(verbo)-3 do
	              presente[i]:=verbo[i];
	          presente[length(verbo)-3]:='o';
	          writeln(presente);

	          passatopr[0]:='s';
	          passatopr[1]:='o';
	          passatopr[2]:='n';
	          passatopr[3]:='o';
	          passatopr[4]:=' ';
	          for i=0 to length(verbo)-2 do
	              passatopr[i+5]:=verbo[i];
	          passatopr[length(verbo)+3]:='t';
	          passatopr[length(verbo)+4]:='o';
	          passatopr[length(verbo)+5]:='\n';
	          writeln(passatopr);
	          end;
	       end;
	    if intransitivo=0 then
               begin
	       writeln(transitivo);
	       for i:=0 to length(verbo)-3 do
	           presente[i]:=verbo[i];
	       presente[length(verbo)-3]:='o';
	       writeln(presente);

	       passatopr[0]:='h';
	       passatopr[1]:='o';
	       passatopr[2]:=' ';
	       for i:=0 to length(verbo)-2 do
	           passatopr[i+3]:=verbo[i];
	       passatopr[length(verbo)+1]:='t';
	       passatopr[length(verbo)+2]:='o';
	       passatopr[length(verbo)+3]:='\n';
	       writeln(passatopr);
	       end;
	end;
end.

