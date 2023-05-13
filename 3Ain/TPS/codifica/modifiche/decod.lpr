program decod;

{$mode objfpc}{$H+}

uses
  {$IFDEF UNIX}{$IFDEF UseCThreads}
  cthreads,
  {$ENDIF}{$ENDIF}
  Classes
  { you can add units after this };
type
  vchar26 = array[0..26] of char; vchar13 = array[0..13] of char;
  vint26 = array[0..26] of integer;
var
  i:integer; alfabeto:vint26; l,o:vchar26; chiave,codice:vchar13;
begin
alfabetoALF[26]:=(97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,);
l[26]:=('l','k','j','i','h','g','f','e','d','c','b','a','z','y','x','w','v','u','t','s','r','q','p','o','n','m',);
o[26]:=('o','n','m','l','k','j','i','h','g','f','e','d','c','b','a','z','y','x','w','v','u','t','s','r','q','p',);
chiave[13]:=('l','o','l','o','l','o','l','o','l','o','l','o','l',);
codiceCOD[13]:=('j','a','i','g','j','k','t','k','f','x','h','v','x',);
codiceDECOD[13];
codiceALF[13];
for i=0 to 13
    codiceALF[i]:=ord(codiceCOD[i]);
for i=0 to 13
begin
    if chiave[i]='l' then
    codiceDECOD[i]:=l[codiceALF[i]];
    if chiave[i]='o' then
    codiceDECOD[i]:=o[codiceALF[i]];
end;
for i=0 to 13
    writln('%c ', codiceDECOD);
readln( );
end.

