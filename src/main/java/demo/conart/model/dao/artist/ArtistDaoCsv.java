package demo.conart.model.dao.artist;

import demo.conart.model.entity.Artist;

import java.io.*;
import java.util.ArrayList;

public class ArtistDaoCsv implements ArtistDao {

    private static final String FILENAME = "artists.csv";


    @Override
    public ArrayList<Artist> getArtists() {

        ArrayList<Artist> artists = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            br.readLine();

            while((line = br.readLine()) != null){

                String[] data = line.split(",");

                Artist artist = new Artist();
                artist.setUsername(data[0]);
                artist.setPassword(data[1]);

                artists.add(artist);
            }

        }
        catch(IOException e){
            e.printStackTrace();
        }
        return artists;

    }
















    @Override
    public Artist getArtist(int id) {

        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            br.readLine();

            while((line = br.readLine()) != null){
                String[] data = line.split(",");

                if(Integer.parseInt(data[0]) == id){

                    Artist artist = new Artist();
                    artist.setUsername(data[0]);
                    artist.setPassword(data[1]);
                    return artist;
                }
            }

        }
        catch(IOException e){
            e.printStackTrace();
        }
        return null;

    }










    @Override
    public boolean addArtist(Artist artist) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME, true))) {
            String line = artist.getUsername() + "," + artist.getPassword();
            bw.newLine();
            bw.write(line);
            return true;
        }
        catch(IOException e){
            e.printStackTrace();
        }

        return false;

    }















    @Override
    public boolean updateArtist(Artist artist) {

        File input = new File(FILENAME);
        File temp = new File("tempartists.csv");

        boolean update = false;

        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME));
            BufferedWriter bw = new BufferedWriter(new FileWriter(temp))) {

            String line = br.readLine();
            bw.write(line);
            bw.newLine();

            while((line = br.readLine()) != null){
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);

                if(id == artist.getId()){
                    String updateLine = artist.getUsername() + "," + artist.getPassword();
                    bw.write(updateLine);
                    update = true;
                }
                else{
                    bw.write(line);
                }
                bw.newLine();
            }

        }
        catch(IOException e){
            e.printStackTrace();
        }

        if (input.delete() && temp.renameTo(input)) {
            return update;
        }

        return false;

    }














    @Override
    public boolean deleteArtist(int id) {
        File input = new File(FILENAME);
        File temp = new File("tempartists.csv");

        boolean delete = false;

        try (BufferedReader br = new BufferedReader(new FileReader(input));
           BufferedWriter bw = new BufferedWriter(new FileWriter(temp))){

            String line = br.readLine();
            bw.write(line);
            bw.newLine();

            while((line = br.readLine()) != null){
                String[] data = line.split(",");
                int currentId = Integer.parseInt(data[0]);

                if(currentId == id){
                    delete = true;
                    continue;
                }

                bw.write(line);
                bw.newLine();

            }

        }
        catch(IOException e){
            e.printStackTrace();
        }

        if (input.delete() && temp.renameTo(input)) {
            return delete;
        }
        return false;


    }











}
