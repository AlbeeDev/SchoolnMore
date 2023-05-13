program scacchiera;
//albano alex 3ain
{$mode objfpc}{$H+}

uses
  {$IFDEF UNIX}{$IFDEF UseCThreads}
  cthreads,
  {$ENDIF}{$ENDIF}
  Classes
  { you can add units after this };

var
  img1,newimg1,img2,newimg2: file of byte;
  r1,g1,b1,r2,g2,b2,h: byte;
  i,px,lastcolor,written,row:integer;
begin
  assign(img1,'strvert.bmp');
  assign(img2,'stroriz.bmp');
  assign(newimg1,'scacchiera1.bmp');
  assign(newimg2,'scacchiera2.bmp');
  reset(img1);
  reset(img2);
  rewrite(newimg1);
  rewrite(newimg2);
  for i:=1 to 54 do
  begin
       read(img1,h);
       write(newimg1,h);
       read(img2,h);
       write(newimg2,h);
  end;
  px:=1;
  lastcolor:=1;
  written:=0;
  row:=1;
  while not eof(img1) do
  begin
       read(img1,b1,g1,r1);
       read(img2,b2,g2,r2);
       if (b1=255) and (g1=255) and (r1=255) and (b2=255) and (g2=255) and (r2=255) then
       begin
          if lastcolor=0 then
          begin
               write(newimg1,255,255,255);
               write(newimg2,0,0,0);
          end;
          if lastcolor=1 then
          begin
               write(newimg2,255,255,255);
               write(newimg1,0,0,0);
          end;
          written:=1;
       end;
       if (b1<>255) or (g1<>255) or (r1<>255) then
       begin
          if (b2<>255) or (g2<>255) or (r2<>255) then
          begin
               write(newimg2,b1,g1,r1);
               write(newimg1,b2,g2,r2);
               written:=1;
          end;
          if written=0 then
          begin
               write(newimg1,b1,g1,r1);
               write(newimg2,b1,g1,r1);
               written:=1;
               if lastcolor=0 then
                  lastcolor:=1
               else
                  lastcolor:=0;
          end;
       end;
       if written=0 then
       begin
            write(newimg1,b2,g2,r2);
            write(newimg2,b2,g2,r2);
       end;
       if ((row mod 20)=0) and (px=200) then
       begin
            if lastcolor=0 then
                  lastcolor:=1
            else
                  lastcolor:=0;
       end;
       if px=200 then
       begin
            row+=1;
            px:=0;
       end;
       px+=1;
       written:=0;
  end;
  writeln('fine');
  close(img1);
  close(img2);
  close(newimg1);
  close(newimg2);
  readln();
end.

