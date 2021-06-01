package sample.Database;

import Models.donationmdl;
import Models.userregmdl;
import Models.voluntmdl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class dbConnection {

    public static Connection connect(){

        Connection conn = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost: 3306/dbhelpinghand";
            String user = "root";
            String pass = "";

            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection Successful");

        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error Occurred" + ex );
        }

        return conn;
    }

    public static ObservableList<voluntmdl> getVolInfo(){

        ObservableList<voluntmdl> listVols = FXCollections.observableArrayList();

        try{
            Connection conn = connect();
            PreparedStatement pst = conn.prepareStatement("select * from volunteerstbl");
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                voluntmdl m = new voluntmdl();
                int id = Integer.parseInt(rs.getString("id"));
                String timing = rs.getString("timing");
                String days = rs.getString("days");

                m.setId(id);
                m.setTiming(timing);
                m.setDays(days);

                listVols.addAll(m);
            }

        }catch(Exception ex){
            System.out.println(ex + "Happened");
        }
        return listVols;
    }

    public static ObservableList<donationmdl> getDonationInfo(){

        ObservableList<donationmdl> listDonations = FXCollections.observableArrayList();

        try{
            Connection conn = connect();
            PreparedStatement pst = conn.prepareStatement("select * from donationstbl");
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                donationmdl d = new donationmdl();
                int id = Integer.parseInt(rs.getString("id"));
                int amount = Integer.parseInt(rs.getString("amount"));
                String purpose = rs.getString("purpose");
                String comment = rs.getString("comment");
                String cardno = rs.getString("cardno");
                int cvv = Integer.parseInt(rs.getString("cvv"));

                d.setId(id);
                d.setAmount(amount);
                d.setPurpose(purpose);
                d.setComment(comment);
                d.setCardNo(cardno);
                d.setCvv(cvv);

                listDonations.addAll(d);
            }

        }catch(Exception ex){
            System.out.println(ex + "Happened");
        }
        return listDonations;
    }

    public static ObservableList<userregmdl> getUserInfo(){

        ObservableList<userregmdl> listUser = FXCollections.observableArrayList();

        try{
            Connection conn = connect();
            PreparedStatement pst = conn.prepareStatement("select * from userstbl");
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                userregmdl e = new userregmdl();
                int id = Integer.parseInt(rs.getString("id"));
                String name = rs.getString("name");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String password = rs.getString("password");

                e.setId(id);
                e.setName(name);
                e.setUsername(username);
                e.setEmail(email);
                e.setPhone(phone);
                e.setPassword(password);

                listUser.addAll(e);
            }
        }catch(Exception ex){
            System.out.println(ex + "Happened");
        }
        return listUser;
    }
}


