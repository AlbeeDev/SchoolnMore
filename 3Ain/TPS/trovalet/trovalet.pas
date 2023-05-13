program trovalet;
//Albano ALex 3ain
{$mode objfpc}{$H+}

uses
  {$IFDEF UNIX}{$IFDEF UseCThreads}
  cthreads,
  {$ENDIF}{$ENDIF}
  Classes
  { you can add units after this };
type
  stringa=string[127];
var
  frase:stringa;
  carattere:char;
  i,j,keylet,keyfras,conta,total,ispal:integer;
begin
   //dichiarazione delle variabili
   writeln('inserisci la frase: ');
   readln(frase);
   writeln('inserisci il carattere: ');
   readln(carattere);
   keylet:=ord(carattere);
   conta:=0;
   total:=0;
   ispal:=1;
   //primo ciclo con il for per stabilire quante volte la lettera è stata
   //trovata nella frase
   for i:=1 to 126 do
       begin
       keyfras:=ord(frase[i]) ;
   //se il numero in codifica ascii della lettera della frase è uguale alla
   //lettera inserita si aggiunge un 1 alla conta
       if keyfras=keylet then conta+=1;
   //si verifica quanti caratteri sono presenti nella frase
       if keyfras<>0 then total+=1;
       end;
   //secondo ciclo for per verificare se la frase è palindroma
   for i:=1 to total do
       for j:=total+1-i downto 1 do
           begin
   //usando 0 come falso e 1 come vero, si assegna un valore
   //a ispal(precedentemente dicharato come vero)
           if ord(frase[i])<>ord(frase[j]) then
              ispal:=0;
           if ord(frase[i])=ord(frase[j]) then
              break;
           end;
   //stampa il programma
   writeln('il carattere ', carattere,' e stato trovato ', conta, ' volte');
   if ispal=1 then writeln('la frase e palindroma');
   if ispal=0 then writeln('la frase non e palindroma');
   readln();
end.

