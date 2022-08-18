# scacchi

<h1>aggiornamento 10/08 </h1>

>corretti indici matrice scacchiera 
<ul>
<li>se hai riga e colonna di una data posizione, queste corrispondono a riga-1 e colonna-1 nella matrice.<br>Questo perchè la matrice scacchiera è una 8x8 con dimensioni da 0 a 7.
<br><b>potrebbero essercene ancora in giro</b></li>
</ul>

>corretto calcolo spostamenti
<ul>
<li> nelle condizioni sono state escluse le "posizioni fantasma" multiple di 10, dato che la scacchiera non ha caselle con pos multiplo di 10.
</ul>
<hr>
<hr>
<hr>


<h1>aggiornamento 9/08 , 2 ore e mezza di lavoro</h1>

>completato Re

>completato cavallo

>corretto caselle, stato, pezzo, scacchiera (modifiche piuttosto importanti e necessarie)

>continuato stato (ancora da finire)

<hr>
<hr>
<hr>


<h1>aggiornamento 6/08 , 13:43, 1 ora di lavoro</h1>

>aggiornato Re: creati listaSpostamentoPotenziale e SpostamentoPotenziale

>aggiunti vari commenti xhtml ai metodi per una maggiore comprensione

<hr>
<hr>
<hr>


<h1>aggiornamento 5/08, 1 ora e mezza di lavoro</h1>
c'è ancora tanto da fare

>controllati e corretti(del tutto o quasi):
<ul><li>Pezzo</li>
<li>Caselle</li>
<li>Scacchiera</li>
<li>Stato</li>
</ul>

>GiocatorePM è stato deciso essere int (1=bianco, 2=nero)

>modificato il costruttore di Pezzo per includere la lettera(viene passata dai figli grazie a un operatore ternario. in questo modo si può avere un identificatore, anche se non ancora del tutto univoco)

>modifiche piccole alla classe Giocatore
