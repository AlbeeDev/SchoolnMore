program bit_parita;
//albano alex 3ain
{$mode objfpc}{$H+}

uses
  {$IFDEF UNIX}{$IFDEF UseCThreads}
  cthreads,
  {$ENDIF}{$ENDIF}
  Classes
  { you can add units after this };
type
  arr=array[1..500] of integer;
var
  miofile:text;
  i,bit,k,ismin,ismincounter,sum,j,num,bitcount,fcount:integer;
  codbit:arr;
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
            codbit[k]:= bit mod 2;
            bit-=codbit[k];
            sum+=codbit[k];
            k+=1;
            bit:= bit div 2;
            end;
      if (sum mod 2)=0 then
         codbit[8]:=0
      else
          codbit[8]:=1;

      for j:=1 to 8 do
          write(miofile,codbit[j]);
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
  while bitcount<(length(bitchar)) do
        begin
        sum:=0;
        num+=1;
        for i:=fcount-7 to fcount do
            begin
            bitcount+=1;
            codbit[bitcount]:=ord(bitchar[i])-48;
            sum+=codbit[i];
            end;
        fcount+=8;
        if (sum mod 2)<>0 then
           writeln('si è verificato un errore nella comunicazione del ',num,' carattere');
        end;
  for i:=1 to bitcount do
      write(codbit[i]);
  readln();
end.

