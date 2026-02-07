package demo.conart.model;

import demo.conart.model.dao.artist.ArtistDao;
import demo.conart.model.dao.spectator.SpectatorDao;
import demo.conart.model.dao.sponsor.SponsorDao;


public class AuthService {

    private final ArtistDao artistDao;
    private final SpectatorDao spectatorDao;
    private final SponsorDao sponsorDao;

    public AuthService(ArtistDao artistDao, SpectatorDao spectatorDao, SponsorDao sponsorDao) {

        this.artistDao = artistDao;
        this.spectatorDao = spectatorDao;
        this.sponsorDao = sponsorDao;

    }

}

