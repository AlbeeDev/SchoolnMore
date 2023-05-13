program decodifica_cesare;
 //albano alex 3ain
{$mode objfpc}{$H+}

uses
  {$IFDEF UNIX}{$IFDEF UseCThreads}
  cthreads,
  {$ENDIF}{$ENDIF}
  Classes
  { you can add units after this };
type
  stringa=string[127];
  vec=array[1..127] of integer;
var
  arr:vec;
  frase,frasedecod:stringa;
  i,key:integer;
begin
writeln('inserisci una frase codificata da decodificare');
readln(frase);
writeln('inserisci la chiave');
readln(key);
writeln('decodifica:');
for i:=1 to 20 do
begin
arr[i]:=ord(frase[i])-key;
if arr[i]<97 then
arr[i]:=arr[i]+26;
if ord(frase[i])=32 then
arr[i]:=32;
if ord(frase[i])<32 then
arr[i]:=32;
frasedecod[i]:=char(arr[i]);
writeln(frasedecod[i]);
end;
readln();
end.

