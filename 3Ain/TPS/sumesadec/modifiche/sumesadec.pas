program sumesadec;
//albano alex 3ain
{$mode objfpc}{$H+}

uses
  {$IFDEF UNIX}{$IFDEF UseCThreads}
  cthreads,
  {$ENDIF}{$ENDIF}
  Classes
  { you can add units after this };
type
  str=array[0..100] of char;
  vec=array[0..100] of integer;
var
  esabase,esa1,esa2,esa3:str;
  val1,val2,val3:vec;
  i,riporto:integer;
begin
	esabase:='0123456789abcdef';
	readln(esa1);
	readln(esa2);
	for i:=length(esa1) downto 0 do
        begin
		if (ord(esa1[i])>=48) and (ord(esa1[i])<=57) then
			val1[length(esa1)-i]:=ord(esa1[i])-48;
		if (ord(esa1[i])>=97) and (ord(esa1[i])<=102) then
			val1[length(esa1)-i]:=ord(esa1[i])-87;
	end;
	for i:=length(esa2) downto 0 do
        begin
		if (ord(esa2[i])>=48) and (ord(esa2[i])<=57) then
			val2[length(esa2)-i]:=ord(esa2[i])-48;
		if (ord(esa2[i])>=97) and (ord(esa2[i])<=102) then
			val2[length(esa2)-i]:=ord(esa2[i])-87;
        end;
        riporto:=0;
	for i:=0 to length(esa1) do
        begin
		if val1[i]+val2[i]+riporto<16 then
                begin
			val3[i]:=val1[i]+val2[i]+riporto;
			if riporto>0 then
				riporto-=1;
		end;
		if val1[i]+val2[i]>15 then
                begin
			val3[i]:=val1[i]+val2[i]-16;
			riporto+=1;
		end;
	end;
	for i:=sizeof(val3)/sizeof(val3[0]) downto 0 do
        begin
                if (val3[i]>=0) and (val3[i]<=9) then
			esa3[sizeof(val3)/sizeof(val3[0])-i]:=chr(val3[i])+48;
                if (val3[i]>=10) and (val3[i]<=15) then
			esa3[sizeof(val3)/sizeof(val3[0])-i]:=chr(val3[i])+87;
	end;
        writeln(esa3);
        readln();
end.

