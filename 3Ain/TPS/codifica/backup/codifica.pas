program codifica;

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

l[26]:=('l','k','j','i','h','g','f','e','d','c','b','a','z','y','x','w','v','u','t','s','r','q','p','o','n','m',);
o[26]:=('o','n','m','l','k','j','i','h','g','f','e','d','c','b','a','z','y','x','w','v','u','t','s','r','q','p',);
chiave[13]:=('l','o','l','o','l','o','l','o','l','o','l','o','l',);
codice[13]:=('c','o','d','i','c','e','s','e','g','r','e','t','o',);
codiceCOD[13];
codiceALF[13];
for i=0 to 13
    codiceALF[i]:=ord(codice[i]);
for i=0 to 13
    if chiave[i]='l' then
    codiceCOD[i]:=l[codiceALF[i]];
for i=0 to 13
    writln('%c ', codiceCOD);
readln( );
end.

