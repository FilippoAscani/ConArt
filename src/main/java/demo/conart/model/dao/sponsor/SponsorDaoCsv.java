package demo.conart.model.dao.sponsor;

import demo.conart.model.entity.Sponsor;

import java.io.*;
import java.util.ArrayList;

public class SponsorDaoCsv implements SponsorDao {


    private static final String FILENAME = "sponsors.csv";



    @Override
    public ArrayList<Sponsor> getSponsors() {

        ArrayList<Sponsor> sponsors = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {

            String line;
            br.readLine();

            while((line = br.readLine()) != null){

                String[] data = line.split(",");
                Sponsor sponsor = new Sponsor();
                sponsor.setUsername(data[0]);
                sponsor.setPassword(data[1]);

                sponsors.add(sponsor);

            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return sponsors;

    }















    @Override
    public Sponsor getSponsor(int id) {

        try (BufferedReader br = new BufferedReader( new FileReader(FILENAME))) {

            String line;
            br.readLine();

            while((line = br.readLine()) != null){
                String[] data = line.split(",");

                if(Integer.parseInt(data[0]) == id){
                    Sponsor sponsor = new Sponsor();
                    sponsor.setUsername(data[0]);
                    sponsor.setPassword(data[1]);
                    return sponsor;
                }
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }



    @Override
    public Sponsor getSponsorByUsername(String username) {
        //aggiungere metodo
        return null;
    }







    @Override
    public boolean addSponsor(Sponsor sponsor) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {
            String line = sponsor.getUsername() + "," + sponsor.getPassword();
            bw.newLine();
            bw.write(line);
            return true;
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }








    @Override
    public boolean updateSponsor(Sponsor sponsor) {

        File input = new File(FILENAME);
        File temp = new File("tempsponsors.csv");

        boolean update = false;

        try (BufferedReader br = new BufferedReader(new FileReader(input));
           BufferedWriter bw = new BufferedWriter(new FileWriter(temp))) {

            String line = br.readLine();
            bw.write(line);
            bw.newLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);

                if (id == sponsor.getId()) {
                    String updateLine = sponsor.getUsername() + "," + sponsor.getPassword();
                    bw.write(updateLine);
                    update = true;
                }
                else{
                    bw.write(line);
                }
                bw.newLine();
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        if(input.delete() && temp.renameTo(input)){
            return update;
        }

        return false;

    }












    @Override
    public boolean deleteSponsor(int id) {

        File input = new File(FILENAME);
        File temp = new File("tempsponsors.csv");


        boolean delete = false;

        try (BufferedReader br = new BufferedReader( new FileReader(input));
           BufferedWriter bw = new BufferedWriter (new FileWriter(temp))) {

            String line = br.readLine();
            bw.write(line);
            bw.newLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int currentId = Integer.parseInt(data[0]);

                if (currentId == id) {
                    delete = true;
                    continue;
                }

                bw.write(line);
                bw.newLine();
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        if(input.delete() && temp.renameTo(input)){
            return delete;
        }

        return false;

    }


    @Override
    public boolean exists(String username, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            br.readLine(); // skip header
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals(username) && data[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // o meglio logger
        }
        return false;
    }
}
