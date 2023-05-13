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
     intransitivi:='nuotare','camminare','andare','arrivare','avanzare','entrare','innamorare','capitare';
     n:=sizeof(intransitivi)/sizeof(intransitivi[1]);
     readln(verbo);
     if (verbo[length(verbo)-2]<>'a') or (verbo[length(verbo)-1]<>'r') or (verbo[length(verbo)]<>'e') then
     writeln('verbo non è di prima coniugazione');
     else
        begin
	for i:=1 to n do
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
	       if(index=1) or (index=2) then
                  begin
	          for i:=1 to length(verbo)-1 do
	              presente[i]:=verbo[i];
	          presente[length(verbo)-2]:='o';
	          writeln(presente);

	          passatopr[1]:='h';
	          passatopr[2]:='o';
	          passatopr[3]:=' ';
	          for i:=1 to length(verbo)-2 do
	              passatopr[i+3]:=verbo[i];
	          passatopr[length(verbo)+2]:='t';
	          passatopr[length(verbo)+3]:='o';
	          writeln(passatopr);
	          end;
	       if index=3 then
                  begin
	          presente[1]:='v';
	          presente[2]:='a';
	          presente[3]:='d';
	          presente[4]:='o';
	          writeln(presente);

	          passatopr[1]:='s';
	          passatopr[2]:='o';
	          passatopr[3]:='n';
	          passatopr[4]:='o';
	          passatopr[5]:=' ';
	          for i:=1 to length(verbo)-2 do
	              passatopr[i+5]:=verbo[i];
	          passatopr[length(verbo)+2]:='t';
	          passatopr[length(verbo)+3]:='o';
	          writeln(passatopr);
	          end;
	       if index>3 then
                  begin
	          for i:=1 to length(verbo)-2 do
	              presente[i]:=verbo[i];
	          presente[length(verbo)-2]:='o';
	          writeln(presente);

	          passatopr[1]:='s';
	          passatopr[2]:='o';
	          passatopr[3]:='n';
	          passatopr[4]:='o';
	          passatopr[5]:=' ';
	          for i:=1 to length(verbo)-2 do
	              passatopr[i+5]:=verbo[i];
	          passatopr[length(verbo)+2]:='t';
	          passatopr[length(verbo)+3]:='o';
	          writeln(passatopr);
	          end;
	       end;
	    if intransitivo=0 then
               begin
	       writeln(transitivo);
	       for i:=1 to length(verbo)-2 do
	           presente[i]:=verbo[i];
	       presente[length(verbo)-2]:='o';
	       writeln(presente);

	       passatopr[1]:='h';
	       passatopr[2]:='o';
	       passatopr[3]:=' ';
	       for i:=1 to length(verbo)-1 do
	           passatopr[i+3]:=verbo[i];
	       passatopr[length(verbo)]:='t';
	       passatopr[length(verbo)+1]:='o';
	       writeln(passatopr);
	       end;
	end;
end.

