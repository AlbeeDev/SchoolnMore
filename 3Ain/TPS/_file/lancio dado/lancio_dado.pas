program lancio_dado;
//albano alex 3ain
{$mode objfpc}{$H+}

uses
  {$IFDEF UNIX}{$IFDEF UseCThreads}
  cthreads,
  {$ENDIF}{$ENDIF}
  Classes
  { you can add units after this };
var
  i,num,count,specnum:integer;
  numcount:real;
  miofile:file of integer;
begin
assign(miofile,'risultati.txt');
rewrite(miofile);
count:=0;
for i:=1 to 1000 do
    begin
      write(miofile,(random(6)+1));
      count+=1;
    end;
close(miofile);
reset(miofile);
readln(specnum);
numcount:=0;
while not eof(miofile) do
    begin
      read(miofile,num);
      if num=specnum then
         numcount+=1;
    end;
writeln(numcount/count);
readln();
end.

