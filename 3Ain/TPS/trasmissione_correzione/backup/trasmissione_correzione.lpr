program trasmissione_correzione;

{$mode objfpc}{$H+}

uses
  {$IFDEF UNIX}{$IFDEF UseCThreads}
  cthreads,
  {$ENDIF}{$ENDIF}
  Classes
  { you can add units after this };

type
  mat=array[1..500,0..8] of integer;
var
  miofile:text;
  i,bit,k,ismin,ismincounter,sum,j,num,bitcount,fcount,sumrow:integer;
  codbit,decodbit:mat;
  stringa,bitchar:string;
begin


  ismin:=0;
  while ismin=0 do
        begin
        write('inserire parola o frase: ');
        readln(stringa);
        ismincounter:=0;
        for i:=1 to length(stringa) do
            begin
            if ord(stringa[i])>127 then
            ismincounter+=1;
            end;
        if ismincounter=0 then
        ismin:=1;
        end;

  assign(miofile,'codifica.txt');
  rewrite(miofile);

  for i:=1 to length(stringa) do
      begin
      bit:=ord(stringa[i]);
      k:=1;
      sum:=0;
      while k<8 do
            begin
            codbit[i,k]:= bit mod 2;
            bit-=codbit[i,k];
            sum+=codbit[i,k];
            k+=1;
            bit:= bit div 2;
            end;
      if (sum mod 2)=0 then
         codbit[i,8]:=0
      else
          codbit[i,8]:=1;

      for j:=1 to 8 do
          write(miofile,codbit[i,j]);
      end;
  for j:=1 to 7 do
      begin
      sumrow:=0;
      for i:=1 to length(stringa) do
          begin
          sumrow+=codbit[i,j];
          end;
      if (sumrow mod 2)=0 then
         codbit[length(stringa)+1,j]:=0
      else
          codbit[length(stringa)+1,j]:=1;
      write(miofile,codbit[length(stringa)+1,j]);
      end;
  close(miofile);
  write('codifica eseguita! premere per continuare');
  readln();
  reset(miofile);
  num:=0;
  while not eof(miofile) do
        readln(miofile,bitchar);

  bitcount:=0;
  fcount:=8;
  while bitcount<(length(bitchar)-7) do
        begin
        sum:=0;
        num+=1;
        for i:=fcount-7 to fcount do
            begin
            bitcount+=1;
            decodbit[num,i]:=ord(bitchar[bitcount])-48;
            sum+=decodbit[num,i];
            end;
        fcount+=8;
        if (sum mod 2)<>0 then
           writeln('si è verificato un errore nella comunicazione del ',num,' carattere');
        end;
  sumrow:=0;
  while bitcount<(length(bitchar)) do
      begin
      for j:=1 to 7 do
            begin
            bitcount+=1;
            decodbit[length(stringa),j]:=ord(bitchar[bitcount])-48;
            end;
      end;
  for j:=1 to 7 do
      begin
      sumrow:=0;
      for i:=1 to length(stringa) do
          begin
          sumrow:=decodbit[i,j];
          end;
      if (sumrow mod 2)<>decodbit[length(stringa),j] then
           writeln('si è verificato un errore nella comunicazione di un carattere');
      end;
  for i:=1 to length(stringa)+1 do
      begin
      for j:=1 to 8 do
          write(decodbit[i,j]);
      writeln();
      end;
  readln();
end.

