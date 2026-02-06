package demo.conart.model.dao.spectator;

import demo.conart.model.entity.Spectator;

import java.io.*;
import java.util.ArrayList;

public class SpectatorDaoCsv implements SpectatorDao {


    private static final String FILENAME = "Spectators.csv";


    @Override
    public ArrayList<Spectator> getSpectators() {


        ArrayList<Spectator> Spectators = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {

            String line;
            br.readLine();

            while((line = br.readLine())!=null) {
                String[] data = line.split(",");

                Spectator Spectator = new Spectator();
                Spectator.setUsername(data[0]);
                Spectator.setPassword(data[1]);

                Spectators.add(Spectator);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return Spectators;


    }














    @Override
    public Spectator getSpectator(int id) {

        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))){

            String line;
            br.readLine();

            while((line = br.readLine())!= null){
                String[] data = line.split(",");
                if (Integer.parseInt(data[0]) == id) {

                    Spectator Spectator = new Spectator();
                    Spectator.setUsername(data[1]);
                    Spectator.setPassword(data[2]);
                    return Spectator;
                }
            }

        }
        catch(IOException e){
            e.printStackTrace();
        }

        return null;
    }
















    @Override
    public boolean addSpectator(Spectator spectator) {

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME,true ))) {
            String line = spectator.getUsername() + "," + spectator.getPassword();
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
    public boolean updateSpectator(Spectator spectator) {

        File input = new File(FILENAME);
        File temp = new File("tempSpectators.csv");

        boolean updated = false;

        try (BufferedReader br = new BufferedReader(new FileReader(input));
             BufferedWriter bw = new BufferedWriter(new FileWriter(temp))) {

            String line = br.readLine();
            bw.write(line);
            bw.newLine();

            while ((line = br.readLine()) != null){
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);

                if (id == spectator.getId()) {
                    String updateLine = Spectator.getUsername() + "," + Spectator.getPassword();
                    bw.write(updateLine);
                    updated = true;
                }
                else{
                    bw.write(line);
                }
                bw.newLine();
            }


        }
        catch (IOException e){
            e.printStackTrace();
        }

        if(input.delete() && temp.renameTo(input)){
            return updated;
        }

        return false;


    }











    @Override
    public boolean deleteSpectator(int id) {

        File input = new File(FILENAME);
        File temp = new File("tempSpectators.csv");

        boolean deleted = false;

        try (BufferedReader br = new BufferedReader(new FileReader(input));
           BufferedWriter bw = new BufferedWriter(new FileWriter(temp))) {

            String line = br.readLine();
            bw.write(line);
            bw.newLine();

            while((line = br.readLine()) != null){
                String[] data = line.split(",");
                int currentId = Integer.parseInt(data[0]);

                if (currentId == id) {
                    deleted = true;
                    continue;
                }

                bw.write(line);
                bw.newLine();


            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

        if(input.delete() && temp.renameTo(input)){
            return deleted;
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
