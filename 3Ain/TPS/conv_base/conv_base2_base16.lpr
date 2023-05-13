program conv_base2_base16;

{$mode objfpc}{$H+}

uses
  {$IFDEF UNIX}{$IFDEF UseCThreads}
  cthreads,
  {$ENDIF}{$ENDIF}
  Classes
  { you can add units after this };


Const
  Digit : String = '0123456789ABCDEF'; // Questi sono i digit validi
Var
  Esadecimale_To_Decimale(Valore : String) : Integer;
  Moltiplicatore : Integer;
  Risultato      : Integer;
  S              : String;
Begin
  // ------------------------------------
  // Inizializzzazioni
  // ------------------------------------
  Moltiplicatore := 1;
  Risultato      := 0;

  // ------------------------------------
  // Ciclo di conversione
  // ------------------------------------
  While (Valore <> '') Do
        Begin
          // ------------------------------------
          // Prelevamento digit più a destra
          // ------------------------------------
          S := Copy(Valore, Length(Valore), 1);

          // ------------------------------------
          // Aggiornamento risultato
          // ------------------------------------
          Risultato := Risultato + Pos(S, Digit)*Moltiplicatore;

          // ------------------------------------
          // Eliminazione digit più a destra
          // ------------------------------------
          Delete(Valore, Length(Valore), 1);

          // ------------------------------------
          // Aggiornamento fattore
          // ------------------------------------
          Moltiplicatore := Moltiplicatore * 16;
        End;

   // ------------------------------------
   // Settaggio uscita
   // ------------------------------------
   Result := Risultato;
End;

