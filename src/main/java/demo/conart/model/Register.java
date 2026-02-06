package demo.conart.model;

import demo.conart.model.entity.Artist;
import demo.conart.model.entity.Spectator;
import demo.conart.model.entity.Sponsor;
import demo.conart.model.entity.User;

public class Register {


    public User login(String username, String password) {

        validateCredentials(username, password);

        if (artistDao.exists(username, password))
            return artistDao.findByUsername(username);

        if (spectatorDao.exists(username, password))
            return spectatorDao.findByUsername(username);

        if (sponsorDao.exists(username, password))
            return sponsorDao.findByUsername(username);

        throw new IllegalArgumentException("Credenziali non valide");
    }

    public void registerArtist(String username, String password, String tipo) {

        validateCredentials(username, password);
        checkUsernameUniqueness(username);

        Artist artist = new Artist();
        artist.setUsername(username);
        artist.setPassword(password);
        artist.setTipo(tipo);

        artistDao.add(artist);
    }


    public void registerSpectator(String username, String password,
                                  String nome, String cognome,
                                  String email, String cf) {

        validateCredentials(username, password);
        checkUsernameUniqueness(username);

        Spectator s = new Spectator();
        s.setUsername(username);
        s.setPassword(password);
        s.setNome(nome);
        s.setCognome(cognome);
        s.setEmail(email);
        s.setCf(cf);

        spectatorDao.add(s);
    }


    public void registerSponsor(String username, String password) {

        validateCredentials(username, password);
        checkUsernameUniqueness(username);

        Sponsor sponsor = new Sponsor();
        sponsor.setUsername(username);
        sponsor.setPassword(password);

        sponsorDao.add(sponsor);
    }

    private void validateCredentials(String username, String password) {

        if (username == null || username.isBlank())
            throw new IllegalArgumentException("Username vuoto");

        if (password == null || password.isBlank())
            throw new IllegalArgumentException("Password vuota");
    }


    private void checkUsernameUniqueness(String username) {

        if (artistDao.existsByUsername(username)
                || spectatorDao.existsByUsername(username)
                || sponsorDao.existsByUsername(username)) {

            throw new IllegalStateException("Username già esistente");
        }
    }







}
