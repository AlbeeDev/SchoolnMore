program battaglianavale;
//albano alex 3ain
{$mode objfpc}{$H+}

uses
  {$IFDEF UNIX}{$IFDEF UseCThreads}
  cthreads,
  {$ENDIF}{$ENDIF}
  Classes
  { you can add units after this };
type
   mat=array[0..10,0..10] of integer;
var
   campo1,campo2:mat;
   i,j,x,y,mode,k:integer;
begin
        //campo 1
        writeln('primo campo:');
        for i:=0 to 9 do
            for j:=0 to 9 do
                campo1[i,j]:=0;

	for i:=0 to 2 do
        begin
		mode:=0;
                k:=0;
		while (mode<>1) and (mode<>2) do
                begin
			writeln('modalita di posizione: (1:verticale,2:orizzontale)');
			readln(mode);
			if(mode<>1) and (mode<>2) then
				writeln('modalita non disponibile.');
		end;
		writeln('coordinate cacciatorpediniere ',i+1,': ([x,y][-])');
		while k=0 do
                begin
			write('x: ');
			readln(x);
			write('y: ');
			readln(y);
			if mode=1 then
                        begin
				if(x>=0) and (x<9)then
                                begin
					if(campo1[x,y]<>1) and (campo1[x+1,y]<>1) then
						k:=1
					else
						writeln('coordinate gia occupate da un altra nave.');
				end;
				if(x<0) or (x>8) then
					writeln('la nave è fuori dal range.');
			end;
			if mode=2 then
                        begin
				if(y>=0) and (y<9) then
                                begin
					if(campo1[x,y]<>1) and (campo1[x,y+1]<>1) then
						k:=1
					else
						writeln('coordinate gia occupate da un altra nave.');
				end;
				if(y<0) or (y>8) then
					writeln('la nave è fuori dal range.');
			end;
		end;
		if mode=1 then
                begin
			campo1[x,y]:=1;
			campo1[x+1,y]:=1;
		end;
		if mode=2 then
                begin
			campo1[x,y]:=1;
			campo1[x,y+1]:=1;
		end;
	end;

	for i:=0 to 1 do
        begin
		mode:=0;
                k:=0;
		while (mode<>1) and (mode<>2) do
                begin
			writeln('modalita di posizione: (1:verticale,2:orizzontale)');
			readln(mode);
			if(mode<>1) and (mode<>2) then
				writeln('modalita non disponibile.');
		end;
		writeln('coordinate incrociatore ',i+1,': ([-][x,y][-])');
		while k=0 do
                begin
			write('x: ');
			readln(x);
			write('y: ');
			readln(y);
			if mode=1 then
                        begin
				if(x>0) and (x<9) then
                                begin
					if(campo1[x,y]<>1) and (campo1[x+1,y]<>1) and (campo1[x-1,y]<>1) then
						k:=1
					else
						writeln('coordinate gia occupate da un altra nave.');
				end;
				if(x<1) or (x>8) then
					writeln('la nave è fuori dal range.');
			end;
			if mode=2 then
                        begin
				if(y>0) and (y<9) then
                                begin
					if(campo1[x,y]<>1) and (campo1[x,y+1]<>1) and (campo1[x,y-1]<>1) then
						k:=1
					else
						writeln('coordinate gia occupate da un altra nave.');
				end;
				if(y<1) or (y>8) then
					writeln('la nave è fuori dal range.');
			end;
		end;
		if mode=1 then
                begin
			campo1[x-1,y]:=1;
			campo1[x,y]:=1;
			campo1[x+1,y]:=1;
		end;
		if mode=2 then
                begin
			campo1[x,y-1]:=1;
			campo1[x,y]:=1;
			campo1[x,y+1]:=1;
		end;
	end;

	mode:=0;
        k:=0;
	while (mode<>1) and (mode<>2) do
        begin
	        writeln('modalita di posizione: (1:verticale,2:orizzontale)');
		readln(mode);
		if(mode<>1) and (mode<>2) then
		        writeln('modalita non disponibile.');
        end;
	writeln('coordinate corazzato: ([-][x,y][-][-])');
	while k=0 do
        begin
	        write('x: ');
		readln(x);
		write('y: ');
		readln(y);
		if mode=1 then
                begin
		        if(x>0) and (x<8)then
                        begin
			        if(campo1[x,y]<>1) and (campo1[x+1,y]<>1) and (campo1[x-1,y]<>1) and (campo1[x+2,y]<>1) then
				       k:=1
				else
				       writeln('coordinate gia occupate da un altra nave.');
			end;
			if(x<1) or (x>7) then
			        writeln('la nave è fuori dal range.');
		end;
		if mode=2 then
                begin
		        if(y>0) and (y<8) then
                        begin
			        if(campo1[x,y]<>1) and (campo1[x,y+1]<>1) and (campo1[x,y-1]<>1) and (campo1[x,y+2]<>1) then
				       k:=1
				else
				       writeln('coordinate gia occupate da un altra nave.');
			end;
			if(x<1) or (x>7) then
			        writeln('la nave è fuori dal range.');
		end;
	end;
	if mode=1 then
        begin
	        campo1[x-1,y]:=1;
		campo1[x,y]:=1;
		campo1[x+1,y]:=1;
		campo1[x+2,y]:=1;
	end;
	if mode=2 then
        begin
                campo1[x,y-1]:=1;
		campo1[x,y]:=1;
		campo1[x,y+1]:=1;
		campo1[x,y+2]:=1;
	end;
        //campo 2
        writeln('secondo campo:');
        for i:=0 to 9 do
            for j:=0 to 9 do
                campo2[i,j]:=0;

	for i:=0 to 2 do
        begin
		mode:=0;
                k:=0;
		while (mode<>1) and (mode<>2) do
                begin
			writeln('modalita di posizione: (1:verticale,2:orizzontale)');
			readln(mode);
			if(mode<>1) and (mode<>2) then
				writeln('modalita non disponibile.');
		end;
		writeln('coordinate cacciatorpediniere ',i+1,': ([x,y][-])');
		while k=0 do
                begin
			write('x: ');
			readln(x);
			write('y: ');
			readln(y);
			if mode=1 then
                        begin
				if(x>=0) and (x<9)then
                                begin
					if(campo2[x,y]<>1) and (campo2[x+1,y]<>1) then
						k:=1
					else
						writeln('coordinate gia occupate da un altra nave.');
				end;
				if(x<0) or (x>8) then
					writeln('la nave è fuori dal range.');
			end;
			if mode=2 then
                        begin
				if(y>=0) and (y<9) then
                                begin
					if(campo2[x,y]<>1) and (campo2[x,y+1]<>1) then
						k:=1
					else
						writeln('coordinate gia occupate da un altra nave.');
				end;
				if(y<0) or (y>8) then
					writeln('la nave è fuori dal range.');
			end;
		end;
		if mode=1 then
                begin
			campo2[x,y]:=1;
			campo2[x+1,y]:=1;
		end;
		if mode=2 then
                begin
			campo2[x,y]:=1;
			campo2[x,y+1]:=1;
		end;
	end;

	for i:=0 to 1 do
        begin
		mode:=0;
                k:=0;
		while (mode<>1) and (mode<>2) do
                begin
			writeln('modalita di posizione: (1:verticale,2:orizzontale)');
			readln(mode);
			if(mode<>1) and (mode<>2) then
				writeln('modalita non disponibile.');
		end;
		writeln('coordinate incrociatore ',i+1,': ([-][x,y][-])');
		while k=0 do
                begin
			write('x: ');
			readln(x);
			write('y: ');
			readln(y);
			if mode=1 then
                        begin
				if(x>0) and (x<9) then
                                begin
					if(campo2[x,y]<>1) and (campo2[x+1,y]<>1) and (campo2[x-1,y]<>1) then
						k:=1
					else
						writeln('coordinate gia occupate da un altra nave.');
				end;
				if(x<1) or (x>8) then
					writeln('la nave è fuori dal range.');
			end;
			if mode=2 then
                        begin
				if(y>0) and (y<9) then
                                begin
					if(campo2[x,y]<>1) and (campo2[x,y+1]<>1) and (campo2[x,y-1]<>1) then
						k:=1
					else
						writeln('coordinate gia occupate da un altra nave.');
				end;
				if(y<1) or (y>8) then
					writeln('la nave è fuori dal range.');
			end;
		end;
		if mode=1 then
                begin
			campo2[x-1,y]:=1;
			campo2[x,y]:=1;
			campo2[x+1,y]:=1;
		end;
		if mode=2 then
                begin
			campo2[x,y-1]:=1;
			campo2[x,y]:=1;
			campo2[x,y+1]:=1;
		end;
	end;

	mode:=0;
        k:=0;
	while (mode<>1) and (mode<>2) do
        begin
	        writeln('modalita di posizione: (1:verticale,2:orizzontale)');
		readln(mode);
		if(mode<>1) and (mode<>2) then
		        writeln('modalita non disponibile.');
        end;
	writeln('coordinate corazzato: ([-][x,y][-][-])');
	while k=0 do
        begin
	        write('x: ');
		readln(x);
		write('y: ');
		readln(y);
		if mode=1 then
                begin
		        if(x>0) and (x<8)then
                        begin
			        if(campo2[x,y]<>1) and (campo2[x+1,y]<>1) and (campo2[x-1,y]<>1) and (campo2[x+2,y]<>1) then
				       k:=1
				else
				       writeln('coordinate gia occupate da un altra nave.');
			end;
			if(x<1) or (x>7) then
			        writeln('la nave è fuori dal range.');
		end;
		if mode=2 then
                begin
		        if(y>0) and (y<8) then
                        begin
			        if(campo2[x,y]<>1) and (campo2[x,y+1]<>1) and (campo2[x,y-1]<>1) and (campo2[x,y+2]<>1) then
				       k:=1
				else
				       writeln('coordinate gia occupate da un altra nave.');
			end;
			if(x<1) or (x>7) then
			        writeln('la nave è fuori dal range.');
		end;
	end;
	if mode=1 then
        begin
	        campo2[x-1,y]:=1;
		campo2[x,y]:=1;
		campo2[x+1,y]:=1;
		campo2[x+2,y]:=1;
	end;
	if mode=2 then
        begin
                campo2[x,y-1]:=1;
		campo2[x,y]:=1;
		campo2[x,y+1]:=1;
		campo2[x,y+2]:=1;
	end;

        //stampa dei campi
	write('  y ');
	for i:=0 to 9 do
		write(' ',i,' ');
	writeln(' ');
	writeln('x');
	for i:=0 to 9 do
        begin
		write(i,'   ');
		for j:=0 to 9 do
			write('[',campo1[i,j],']');
		writeln(' ');
	end;

        write('  y ');
	for i:=0 to 9 do
		write(' ',i,' ');
	writeln(' ');
	writeln('x');
	for i:=0 to 9 do
        begin
		write(i,'   ');
		for j:=0 to 9 do
			write('[',campo2[i,j],']');
		writeln(' ');
	end;
        readln();
end.

