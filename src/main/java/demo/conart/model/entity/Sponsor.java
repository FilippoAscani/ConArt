package demo.conart.model.entity;

import demo.conart.enums.Ruolo;

public class Sponsor extends User {

    /*
     * lo sponsor crea e invia le richieste per gli spettacoli che verranno accettate o meno dagli artisti.
     * visualizza le recensioni degli spettacoli dove hanno partecipato gli artisti da lui contattati
     */


    public Sponsor() {
        this.ruolo = Ruolo.SPONSOR;
    }


}
