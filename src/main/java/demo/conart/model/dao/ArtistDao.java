package demo.conart.model.dao;

import demo.conart.exception.AccessDeniedException;
import demo.conart.exception.ItemNotFoundException;

import java.util.Objects;

public interface ArtistDao<T> {

    /*
    proviamo con un metodo diverso dichiarando un solo tipo di metodo che cambierà di volta in volta
     */

    public T eseguiArtista(Object... param) throws AccessDeniedException, ItemNotFoundException;

}
