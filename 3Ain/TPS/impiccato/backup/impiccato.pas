program impiccato;

{$mode objfpc}{$H+}

uses
  {$IFDEF UNIX}{$IFDEF UseCThreads}
  cthreads,
  {$ENDIF}{$ENDIF}
  Classes
  { you can add units after this };
type
    str=array[0..100] of char;
var
    i,sum,x:integer;
    let:char;
    piumeno,parola:str;
procedure translate(parola,piumeno:str);
        begin
	for i:=0 to length(parola) do
                begin
		if (ord(parola[i])=97) or (ord(parola[i])=101) or (ord(parola[i])=105) or (ord(parola[i])=111) or (ord(parola[i])=117) then
			ord(piumeno[i]):=43;
                if (ord(parola[i])<>97) or (ord(parola[i])<>101) or (ord(parola[i])<>105) or (ord(parola[i])<>111) or (ord(parola[i])<>117) then
			ord(piumeno[i]):=45;
	        end;
        end;
procedure cmp(parola,piumeno:str; let:char);
        begin
	for i:=0 to length(parola) do
		if parola[i]=let then
			piumeno[i]:=let;
        end;
procedure checkwin(parola,piumeno:str; x,sum:integer);
        begin
        sum:=0;
	for i:=0 to length(piumeno) do
		if parola[i]=piumeno[i] then
			sum+=1;
	if sum=length(parola) then
		x:=0;
	if sum<>length(parola) then
		x:=1;
        end;
begin
	parola:='segreto';
	translate(parola,piumeno);
	writeln(piumeno);
        sum:=0;
	x:=1;
	while(x=1) do
        begin
	readln(let);
	cmp(parola,piumeno,let);
	writeln(piumeno);
	checkwin(parola,piumeno,x,sum);
	end;
        readln();
end.

