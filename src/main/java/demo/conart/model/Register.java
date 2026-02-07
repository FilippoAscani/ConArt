package demo.conart.model;

import demo.conart.model.dao.spectator.SpectatorDao;
import demo.conart.model.dao.sponsor.SponsorDao;
import demo.conart.model.entity.Artist;
import demo.conart.model.entity.Spectator;
import demo.conart.model.entity.Sponsor;
import demo.conart.model.entity.User;
import demo.conart.model.dao.artist.ArtistDao;

public class Register {

    ArtistDao artistDao;
    SponsorDao sponsorDao;
    SpectatorDao spectatorDao;


    public User login(String username, String password) {

        validateCredentials(username, password);

        if (artistDao.exists(username, password))
            return artistDao.getArtistByUsername(username);

        if (spectatorDao.exists(username, password))
            return spectatorDao.getSpectatorByUsername(username);

        if (sponsorDao.exists(username, password))
            return sponsorDao.getSponsorByUsername(username);

        throw new IllegalArgumentException("Credenziali non valide");
    }

    public void registerArtist(String username, String password, String tipo) {

        validateCredentials(username, password);
        checkUsernameUniqueness(username,password);

        Artist artist = new Artist();
        artist.setUsername(username);
        artist.setPassword(password);
        artist.setTipo(tipo);

        artistDao.addArtist(artist);
    }


    public void registerSpectator(String username, String password,
                                  String nome, String cognome,
                                  String email, String cf) {

        validateCredentials(username, password);
        checkUsernameUniqueness(username,password);

        Spectator s = new Spectator();
        s.setUsername(username);
        s.setPassword(password);
        s.setNome(nome);
        s.setCognome(cognome);
        s.setEmail(email);
        s.setCf(cf);

        spectatorDao.addSpectator(s);
    }


    public void registerSponsor(String username, String password) {

        validateCredentials(username, password);
        checkUsernameUniqueness(username,password);

        Sponsor sponsor = new Sponsor();
        sponsor.setUsername(username);
        sponsor.setPassword(password);

        sponsorDao.addSponsor(sponsor);
    }

    private void validateCredentials(String username, String password) {

        if (username == null || username.isBlank())
            throw new IllegalArgumentException("Username vuoto");

        if (password == null || password.isBlank())
            throw new IllegalArgumentException("Password vuota");
    }


    private void checkUsernameUniqueness(String username, String password) {

        if (artistDao.exists(username,password)
                || spectatorDao.exists(username,password)
                || sponsorDao.exists(username,password)) {

            throw new IllegalStateException("Username già esistente");
        }
    }







}
