program conv_esa_dec;
{*albano alex*}
{$mode objfpc}{$H+}

uses
  {$IFDEF UNIX}{$IFDEF UseCThreads}
  cthreads,
  {$ENDIF}{$ENDIF}
  Classes
  { you can add units after this };

Function Esadecimale_To_Decimale(Valore : String) : Integer;
Const
  Digit : String = '0123456789ABCDEF'; 
Var
  Moltiplicatore : Integer;
  Risultato      : Integer;
  S              : String;
Begin
  
  Moltiplicatore := 1;
  Risultato      := 0;

  While (Valore <> '') Do
        Begin
          
          S := Copy(Valore, Length(Valore), 1);

          
          Risultato := Risultato + Pos(S, Digit)*Moltiplicatore;

          
          Delete(Valore, Length(Valore), 1);

          
          Moltiplicatore := Moltiplicatore * 16;
        End;

   
   Result := Risultato;
End;
