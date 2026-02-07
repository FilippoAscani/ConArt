package demo.conart.model.dao.artist;

import demo.conart.model.entity.Artist;

import java.util.ArrayList;

public interface ArtistDao<T> {

    public ArrayList<Artist> getArtists();
    public Artist getArtist(int id);
    public boolean addArtist(Artist artist);
    public boolean updateArtist(Artist artist);
    public boolean deleteArtist(int id);
    public boolean exists(String username, String password);
    public Artist getArtistByUsername(String username);

}
