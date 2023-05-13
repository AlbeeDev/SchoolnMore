program temp_mese2;

{$mode objfpc}{$H+}

uses
  {$IFDEF UNIX}{$IFDEF UseCThreads}
  cthreads,
  {$ENDIF}{$ENDIF}
  Classes
  { you can add units after this };
function tempday(temp:real):integer;
var
  miofile:file of real;
  ftemp:real;
begin
     assign(miofile,'temperature.txt');
     reset(miofile);
     while not eof(miofile) do
     begin
          read(miofile,ftemp);
          if temp=ftemp then
             exit(filepos(miofile));
     end;
     exit(-1);
end;

procedure set_temp(newtemp:real);
var
  miofile:file of real;
  i:integer;
begin
     assign(miofile,'temperature_new.txt');
     rewrite(miofile);
     for i:=1 to 31 do
         writeln(miofile,newtemp);
end;

var
  temp:real;
begin
readln(temp);
writeln('giorno ',tempday(temp));
readln(temp);
set_temp(temp);
readln();
end.

