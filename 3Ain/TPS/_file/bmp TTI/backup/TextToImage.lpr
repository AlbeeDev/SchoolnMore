program TextToImage;
//alex albano 3ain
{$mode objfpc}{$H+}

uses
  {$IFDEF UNIX}{$IFDEF UseCThreads}
  cthreads,
  {$ENDIF}{$ENDIF}
  Classes
  { you can add units after this };
var
  txt:text;
  img,oldimg:file of byte;
  b,g,r,h: byte;
  i,count:integer;
  ch:char;
begin
     assign(txt,'testo.txt');
     reset(txt);
     assign(oldimg,'immagine.bmp');
     reset(oldimg);
     assign(img,'img.bmp');
     rewrite(img);
     for i:=1 to 54 do
     begin
          read(oldimg,h);
          write(img,h);
     end;
     count:=0;
     while not eof(txt) do
     begin
          read(txt,ch);
          b:=ord(ch);
          read(oldimg,h);
          read(txt,ch);
          g:=ord(ch);
          read(oldimg,h);
          read(txt,ch);
          r:=ord(ch);
          read(oldimg,h);
          write(img,b,g,r);
     end;
     close(txt);
     b:=255;
     g:=255;
     r:=255;
     while not eof(oldimg) do
     begin
          read(oldimg,h);
          b:=ord(h);
          write(img,b,b,b);
     end;
     close(img);
end.

