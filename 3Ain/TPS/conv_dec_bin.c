program conv_dec_bin;
{*albano alex*}
{$mode objfpc}{$H+}

uses
  {$IFDEF UNIX}{$IFDEF UseCThreads}
  cthreads,
  {$ENDIF}{$ENDIF}
  Classes
  { you can add units after this };
var
  xdec,xbin:integer;
begin
readln(xdec);
while xdec>0 do
begin
xbin := xdec mod 2;
writeln(' ', xbin);
xdec := xdec div 2;
end;
readln();
end. 
