package demo.conart.model.dao;

import demo.conart.exception.AccessDeniedException;
import demo.conart.exception.ItemNotFoundException;

public class ArtistImplDao implements ArtistDao<String>{

    /*
     *classe per la gestione dei dati di artista come registrazione di un artista sia su db sia su csv
     * quindi anche inserimento e cancellazione e ricerca
     */


    @Override
    public String eseguiArtista(Object... param) throws AccessDeniedException, ItemNotFoundException {
        return "eseguiartista";
    }

    //una procedura consiste nel mettere gli inserimenti tutti in una classe
    //classe inserimenti: dove ci sono inserisci artista, utente, sponsor

    //poi una classe dove ci sono tutti le eliminazioni
    //elimina artista, utente, sponsor

    //e cosi via

    //un'altra procedura consiste in una classe dove ci sono tutte le operazioni per l'artista
    //ad esempio classe artista: aggiungi artista, elimina artista, cerca artista

    //in un'altra classe ci saranno tutte le operazioni relative allo sponsor
    //un'altra ancora conterrà tutte le operazioni per l'utente

    //il primo approccio può essere utile in un contesto piccolo ma non è questo il caso
    //seguiamo il secondo approccio


}
