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
  try
    Bitmap.LoadFromFile('Immagine.bmp');
    ReplaceColor(Bitmap,clred);
    Image1.Picture.Assign(Bitmap);
  finally
    Bitmap.Free;
  end;
end;

