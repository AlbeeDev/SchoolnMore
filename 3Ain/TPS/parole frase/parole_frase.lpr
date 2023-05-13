program parole_frase;

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
 str1:str;
 count,i:integer;
begin
        count:=1;
	readln(str1);
	for i:=0 to length(str1) do
		if(ord(str1[i])=32) then
			count+=1;
	writeln(count);
	count:=0;
	for i:=0 to length(str1) do
                begin
		if(ord(str1[i])=32) then
			writeln('');
		if(ord(str1[i])<>32) then
			write(str1[i]);
	        end;
        readln();
end.

