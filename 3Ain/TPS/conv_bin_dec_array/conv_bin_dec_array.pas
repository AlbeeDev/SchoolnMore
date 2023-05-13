program conv_bin_dec_array;

{$mode objfpc}{$H+}

uses
  {$IFDEF UNIX}{$IFDEF UseCThreads}
  cthreads,
  {$ENDIF}{$ENDIF}
  Classes
  { you can add units after this };
type
  vect = array[0..7] of integer;
var
  i,dec: integer; bin, pot:vect;
begin
dec:=0;
pot[0]:=1;
pot[1]:=2;
pot[2]:=4;
pot[3]:=8;
pot[4]:=16;
pot[5]:=32;
pot[6]:=64;
pot[7]:=128;
writeln('inserire un numero binario a 8 bit da destra verso sinistra: ');
for i:=0 to 7 do
begin
    readln(bin[i]);
    while (bin[i]<0) or (bin[i]>1) do
    begin
         writeln(' ', bin[i], ' non e una cifra binaria, ritenta: ');
         readln(bin[i]);
    end;
end;
for i:=0 to 7 do
if bin[i]=1 then
dec += pot[i];
for i:=0 to 7 do
writeln(' ', bin[i]);
writeln('=');
writeln(' ', dec);
readln();
end.

