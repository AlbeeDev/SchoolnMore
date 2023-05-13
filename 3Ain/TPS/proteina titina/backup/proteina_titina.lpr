program proteina_titina;

{$mode objfpc}{$H+}

uses
  {$IFDEF UNIX}{$IFDEF UseCThreads}
  cthreads,
  {$ENDIF}{$ENDIF}
  Classes
  { you can add units after this };
type
    str=array[0..7] of char;
var
  miofile:text;
  i,k,len,count,vow,cons,let,max,min,strcount1,strcount2:integer;
  maxlet,minlet:char;
  str1,str2:str;
  parola:string;
begin
  assign(miofile,'Titina.txt');
  reset(miofile);
  while not eof(miofile) do
        begin
          readln(miofile,parola);
        end;
  len:=length(parola);
  writeln('lunghezza parola: ',len);
  vow:=0;
  cons:=0;
  for i:=0 to length(parola) do
  begin
       if (parola[i]='a') or (parola[i]='e') or (parola[i]='i') or (parola[i]='o') or (parola[i]='u') then
          begin
          vow+=1;
          end
       else
       begin
            cons+=1;
       end;
  end;
  writeln('numero vocali: ',vow);
  writeln('numero consonanti: ',cons);
  let:=97;
  min:=100000 ;
  max:=0;
  while let<123 do
        begin
             count:=0;
             for i:=0 to length(parola) do
             begin
                  if (parola[i]=chr(let)) or (parola[i]=chr(let-32)) then
                     count+=1;
             end;
             if count>0 then
                writeln('numero di ',chr(let),': ',count);
             if count>max then
                begin
                max:=count;
                maxlet:=chr(let);
                end;
             if (count<min) and (count>0) then
                begin
                min:=count;
                minlet:=chr(let);
                end;
             let+=1;
        end;
  writeln('lettera piu frequente: ',maxlet);
  writeln('lettera meno frequente: ',minlet);
  count:=0;
  for i:=0 to len-1 do
  begin
       if parola[i]=parola[i+1] then
          count+=1;
  end;
  writeln('numero di ripetizioni: ',count);
  k:=0;
  strcount1:=0;
  strcount2:=0;
  str1:='glutamy';
  str2:='soleucy';
  for i:=0 to len-7 do
  begin
       if(parola[i]=str1[k]) and (parola[i+1]=str1[k+1]) and (parola[i+2]=str1[k+2]) and (parola[i+3]=str1[k+3]) and (parola[i+4]=str1[k+4]) and (parola[i+5]=str1[k+5]) and (parola[i+6]=str1[k+6]) then
       begin
            strcount1+=1;
       end;
       if(parola[i]=str2[k]) and (parola[i+1]=str2[k+1]) and (parola[i+2]=str2[k+2]) and (parola[i+3]=str2[k+3]) and (parola[i+4]=str2[k+4]) and (parola[i+5]=str2[k+5]) and (parola[i+6]=str2[k+6]) then
       begin
            strcount2+=1;
       end;
  end;
  readln();
end.

