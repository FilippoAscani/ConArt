package demo.conart.model.dao.user;

import demo.conart.model.entity.User;

import java.io.*;
import java.util.ArrayList;

public class UserDaoCsv implements UserDao {


    @Override
    public ArrayList<User> getUsers() {


        ArrayList<User> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("users.csv"))) {
            String line;
            br.readLine();

            while((line = br.readLine())!=null) {
                String[] data = line.split(",");

                User user = new User();
                user.setUsername(data[0]);
                user.setPassword(data[1]);

                users.add(user);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return users;


    }














    @Override
    public User getUser(int id) {

        try (BufferedReader br = new BufferedReader(new FileReader("users.csv"))){

            String line;
            br.readLine();

            while((line = br.readLine())!= null){
                String[] data = line.split(",");
                if (Integer.parseInt(data[0]) == id) {

                    User user = new User();
                    user.setUsername(data[1]);
                    user.setPassword(data[2]);
                    return user;
                }
            }

        }
        catch(IOException e){
            e.printStackTrace();
        }

        return null;
    }
















    @Override
    public boolean addUser(User user) {

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("users.csv",true ))) {
            String line = user.getUsername() + "," + user.getPassword();
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
    public boolean updateUser(User user) {

        File input = new File("users.csv");
        File temp = new File("tempusers.csv");

        boolean updated = false;

        try (BufferedReader br = new BufferedReader(new FileReader(input));
             BufferedWriter bw = new BufferedWriter(new FileWriter(temp))) {

            String line = br.readLine();
            bw.write(line);
            bw.newLine();

            while ((line = br.readLine()) != null){
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);

                if (id == user.getId()) {
                    String updateLine = user.getUsername() + "," + user.getPassword();
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
    public boolean deleteUser(int id) {

        File input = new File("users.csv");
        File temp = new File("tempusers.csv");

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
}
