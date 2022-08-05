# scacchi
scacchi semplici

<h1>DIFETTI (e domande) PRINCIPALI trovati fin'ora</h1> -- 15/07/2022 : 01:02 --

<ul>
<h2>PROBLEMI EVIDENZIATI IN <b>Scacchiera.java</b></h2>

-import java.util.ArrayList inutilizzato (non è veramente un problema)

-problema dei for: in toString vanno da 1 a dimensione, mentre in creaScacchiera vanno da 0 a 7...

-in toString mancano i caratteri di Newline (facilmente risolvibile)

-perchè colorecasella1 è True e colorecasella2 è True?? Bianco e Bianco o Nero e Nero??

-getPos non implementata(ha del codice che non c'entra proprio: che senso ha usare pos??? 
	il metodo vuole come input un pezzo. Pos globale??ma perchè??)

-le variabili di stato pos, riga, colonna?? perchè?
</div>
</ul>


<ul><h2>PROBLEMI EVIDENZIATI IN <b>Pezzo.java + Scacchiera.java</b></h2>

-Pezzo sembra avere diversi problemi; alcuni metodi non astratti ma non implementati. Immagino sia per un Override più avanti. 
	Approfondisco l'analisi. 
	listaSpostamentoPotenziale impostata in maniera molto ambigua (vuoi farle l'override o la vuoi astratta?)

-serve davvero la variabile pos in Pezzo?
	
-IMPORTANTE: usare pos come identificativo fa perdere di utilità la funzione getPos di Scacchiera!!!! 
	USARE UN ID! ad es. un codice: "alfiere bianco" può avere codice "AB1", "pedina nera" può avere codice "PN0", e così via...
</ul>

