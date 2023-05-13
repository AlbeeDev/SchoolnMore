program cod_hamming;

{$mode objfpc}{$H+}

uses
  {$IFDEF UNIX}{$IFDEF UseCThreads}
  cthreads,
  {$ENDIF}{$ENDIF}
  Classes
  { you can add units after this };
type
  arr=array[0..7] of integer;
  arrham=array[0..11] of integer;
  miofile=file of integer;
var
  let:char;
  i,bit,ordin,ptidx,cntidx,sum,j:integer;
  codlet:arr;
  hamlet,hln:arrham;
  f:miofile;
begin
  writeln('inserisci una lettera');
  readln(let);
  i:=7;
  ordin:=ord(let);
  while i>=0 do
  begin
    bit:=ordin mod 2;
    ordin := ordin div 2;
    codlet[i]:=bit;
    i-=1;
  end;
  ptidx:=0;
  for i:=0 to 11 do
  begin
       if (i=1) or (i=2) or (i=4) or (i=8) then
          hamlet[i]:=0
       else
           begin
                hamlet[i]:=codlet[ptidx];
                ptidx+=1;
           end;



  end;

  ptidx:=0;
  cntidx:=0;
  sum:=0;
  i:=0;
  while i<12 do
  begin
    if (i=2) or (i=4) or (i=5) or (i=6) or (i=8) or (i=9) or (i=10) or (i=11) then
    begin
         hln[i]:=hamlet[i];
         i+=1;
    end;
    if i=0 then
    begin
         for j:=0 to 11 do
         begin
              if j=cntidx then
              begin
                   sum+=hamlet[cntidx];
                   cntidx+=2;
              end;
         end;
         hln[i]:=(sum mod 2);
         i+=1;
    end;
    sum:=0;
    cntidx:=1;
    if i=1 then
    begin
         for j:=0 to 11 do
         begin
              if j=cntidx then
              begin
                   sum+=hamlet[cntidx];
                   if (cntidx=2) or (cntidx=6) or (cntidx =10) then
                      cntidx+=2;
                   cntidx+=1;
              end;
         end;
         hln[i]:=(sum mod 2);
         i+=1;
    end;
    sum:=0;
    cntidx:=3;
    if i=3 then
    begin
         for j:=0 to 11 do
         begin
              if j=cntidx then
              begin
                   sum+=hamlet[cntidx];
                   if cntidx=6 then
                      cntidx+=4;
                   cntidx+=1;
              end;
         end;
         hln[i]:=(sum mod 2);
         i+=1;
    end;
    sum:=0;
    cntidx:=7;
    if i=7 then
    begin
         for j:=0 to 11 do
         begin
              if j=cntidx then
              begin
                   sum+=hamlet[cntidx];
                   cntidx+=1;
              end;
         end;
         hln[i]:=(sum mod 2);
         i+=1;
    end;
  end;

  assign(f,'hamming.txt');
  rewrite(f);
  for i:=0 to 11 do
  begin
    write(f,hln[i]);
  end;
  close(f);


  readln();
end.

