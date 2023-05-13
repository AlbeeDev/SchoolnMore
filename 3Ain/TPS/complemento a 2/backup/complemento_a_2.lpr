program complemento_a_2;

{$mode objfpc}{$H+}

uses
  {$IFDEF UNIX}{$IFDEF UseCThreads}
  cthreads,
  {$ENDIF}{$ENDIF}
  Classes
  { you can add units after this };
type
  vect = array [0..7] of integer;
var
  i,val, s, imp:integer; vec,vec2,vec3: vect;
begin
s:=0;
imp:=0;
vec2[0]:=1;
vec2[1]:=0;
vec2[2]:=0;
vec2[3]:=0;
vec2[4]:=0;
vec2[5]:=0;
vec2[6]:=0;
vec2[7]:=0;
writeln('inserire un numero binario a 8 bit da destra verso sinistra: ');
for i:=0 to 7 do
    begin
         readln(val);
         if(val=0) then
         vec[i]:=1;
         if(val=1) then
         vec[i]:=0;
    end;
for i:=0 to 7 do
    begin
         s:=vec[i]+vec2[i]+imp;
         vec3[i]:=s mod 2;
         imp:=s-vec3[i];
         if(imp>1) then
                  imp:=1;
    end;
if(imp=1) then
         writeln('complemento maggiore do 8 bit');
if(imp=0) then
begin
     for i:=0 to 7 do
         begin
  	      writeln(' ', vec3[i]);
	 end;
end;
readln();
end.

