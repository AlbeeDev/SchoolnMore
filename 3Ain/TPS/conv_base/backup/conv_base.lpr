program conv_base;
(*Albano Alex 3Ain*)
{$mode objfpc}{$H+}

uses
  {$IFDEF UNIX}{$IFDEF UseCThreads}
  cthreads,
  {$ENDIF}{$ENDIF}
  Classes
  { you can add units after this };
var
num,x,y:integer; false:boolean;
begin
  writeln('inserire un numero in base 2: ');
  readln (num);
  x:=0;
  y:=0;
  if(num > 11111111) then writeln('input supera 8 bit')
  else
  while num>0 do
  begin
  if(num mod 10 <> 0) then x:=x+sqr(y);
  num:= num div 10;
  y:=y+1;
  end;
  writeln('Il numero in decimale vale: ', x);
  readln;
end.

