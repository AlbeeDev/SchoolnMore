program bmp;

{$mode objfpc}{$H+}

uses
  {$IFDEF UNIX}{$IFDEF UseCThreads}
  cthreads,
  {$ENDIF}{$ENDIF}
  Classes, unit1
  { you can add units after this };
var
  Bitmap: TBitmap;
begin
  Bitmap := TBitmap.Create;
  Bitmap.LoadFromFile('Immagine.bmp');
  for Y := 0 to Bitmap1.Height - 1 do
  begin
    for X := 0 to Bitmap1.width  * size - 1 do
        BitMap1.Canvas.Pixels[X,Y] := 0;
    end;
  end;
  Image1.Picture.Assign(Bitmap);
  end;
end;

