package demo.conart.model;

import demo.conart.model.dao.artist.ArtistDao;
import demo.conart.model.entity.Artist;

public class AuthServiceArtist {

    private ArtistDao artistDao;

    public void registerArtist(String username, String password) {

        if (username == null || username.isBlank())
            throw new IllegalArgumentException("Username vuoto");

        if (password == null || password.isBlank())
            throw new IllegalArgumentException("Password vuota");

        if (artistDao.exists(username,password))
            throw new IllegalStateException("Username già esistente");

        Artist artist = new Artist();
        artist.setUsername(username);
        artist.setPassword(password);

        artistDao.addArtist(artist);
    }

    public Artist loginArtist(String username, String password) {

        if (!artistDao.exists(username, password))
            throw new IllegalArgumentException("Credenziali errate");

        return artistDao.getArtistByUsername(username);
    }
}

