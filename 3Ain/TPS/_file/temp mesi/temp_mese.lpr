program temp_mese;
//albano alex 3ain
{$mode objfpc}{$H+}

uses
  {$IFDEF UNIX}{$IFDEF UseCThreads}
  cthreads,
  {$ENDIF}{$ENDIF}
  Classes
  { you can add units after this };
type
  arreal=array[1..31] of real;
var
  i:integer;
  num,den,numtot,media:real;
  vec:arreal;
  miofile:file of real;
begin
  assign(miofile,'temperature.txt');
  rewrite(miofile);
  for i:= 0 to 31 do
      begin
        write(miofile,random(8)+18);
      end;
  close(miofile);
  reset(miofile);
  numtot:=0;
  den:=0;
  i:=0;
  while not eof(miofile) do
        begin
          read(miofile,num);
          numtot+=num;
          den+=1;
          vec[i]:=num;
          i+=1;
        end;
  media:=numtot/den;
  writeln(media);
  for i:=1 to 31 do
      begin
        if vec[i]>media then
           writeln(i);
      end;
  readln();
end.

