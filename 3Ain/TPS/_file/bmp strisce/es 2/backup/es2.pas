program es2;

{$mode objfpc}{$H+}

uses
  {$IFDEF UNIX}{$IFDEF UseCThreads}
  cthreads,
  {$ENDIF}{$ENDIF}
  Classes
  { you can add units after this };
var
  image,newimg: file of byte;
  r,g,b,h: byte;
  i,px,row:integer;
begin
  assign(image,'originale.bmp');
  assign(newimg,'stroriz.bmp');
  reset(image);
  rewrite(newimg);
  for i:=1 to 54 do
  begin
       read(image,h);
       write(newimg,h);
  end;
  px:=1;
  row:=1;
  while not eof(image) do
  begin
       read(image,b,g,r);
       if (row mod 20)=0 then
            write(newimg,230,255,120)
       else
           write(newimg,b,g,r);
       if px=200 then
       begin
            row+=1;
            px:=0;
       end;
       px+=1;
  end;
  writeln('fine');
  readln();
end.

