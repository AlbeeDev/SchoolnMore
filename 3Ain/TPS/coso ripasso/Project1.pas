program Project1;

{$mode objfpc}{$H+}

uses
  {$IFDEF UNIX}{$IFDEF UseCThreads}
  cthreads,
  {$ENDIF}{$ENDIF}
  Classes
  { you can add units after this };
type
  arr=array[0..3] of real;
var
  a,b,i:integer;
  c,d,sum,media:real;
  arr1:arr;
begin
  a:=10;
  b:=4;
  c:=7.35;
  d:=0.65;
  sum:=a+b+c+d;
  media:=sum/4;
  writeln(sum:4:2,' ',media:4:2);
  arr1[0]:=a;
  arr1[1]:=b;
  arr1[2]:=c;
  arr1[3]:=d;
  for i:=0 to length(arr1)-1 do
  begin
       writeln(arr1[i]:4:2,' ',i);
  end;
  readln();
end.

