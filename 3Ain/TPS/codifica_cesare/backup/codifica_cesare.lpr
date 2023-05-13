program codifica_cesare;

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
  frase,frasecod:stringa;
  i,key:integer;
begin
writeln('inserisci una frase con meno di 20 caratteri da codificare in lettere minuscole');
readln(frase);
writeln('inserisci la chiave');
readln(key);
writeln('codifica:');
for i:=1 to 20 do
begin
arr[i]:=ord(frase[i])+key;
if arr[i]>122 then
arr[i]:=arr[i]-26;
if ord(frase[i])=32 then
arr[i]:=32;
if ord(frase[i])<32 then
arr[i]:=32;
frasecod[i]:=char(arr[i]);
writeln(frasecod[i]);
end;
readln();
end.

