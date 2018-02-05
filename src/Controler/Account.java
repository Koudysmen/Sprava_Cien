/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Connect.DBManager;
import Model_Object.City;
import Model_Object.Person;
import Model_Object.UserCompany;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Michal
 */
public class Account {
    private DBManager DbManager;
    private UserCompany UserCompany;
    private Person Person;
    private City City;

    public Account(DBManager dbManager) {
        DbManager = dbManager;
    }
    
    public boolean logIn(String userName, String password) {
        boolean result = false;
        userName = addApostrofs(userName);
        String hashPassword = addApostrofs(hashPassword(password));
        ResultSet rs = DbManager.querySQL("SELECT"
                + "  email,"
                + "  heslo,"
                + "  rod_cislo,"
                + "  meno,"
                + "  priezvisko,"
                + "  PSC,"
                + "  nazov,"
                + "  ulica,"
                + "  ru.ICO"
                + " FROM"
                + " registrovany_uzivatel ru join Osoba using(rod_cislo)"
                + " join Mesto using(PSC)"
                + " WHERE email like " + userName + "AND heslo like " + hashPassword
        );
        try {
            if (rs != null) {

                while (rs.next()) {
                    //Retrieve by column name
                    String login = rs.getString("email");
                    String hash = rs.getString("heslo");
                    String RC = rs.getString("rod_cislo");
                    String name = rs.getString("meno");
                    String surname = rs.getString("priezvisko");
                    String street = rs.getString("ulica");
                    String PSC = rs.getString("PSC");
                    String nameOfCity = rs.getString("nazov");
                    String ICO = rs.getString("ICO");
                    result = true;
                    if(ICO == null){
                        this.UserCompany = new UserCompany(false, login, hash, RC, null);
                        this.Person = new Person(RC, name, surname, PSC);
                        this.City = new City(street, nameOfCity);
                    }else{
                        this.UserCompany = new UserCompany(true, login, hash, null, ICO);
                    }
                }
                rs.close();

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
    
    public String getNameOfCompany(String ICO) {
        String result = null;
        
        String query = "SELECT"
                + "  nazov"
                + " FROM"
                + " Firma"
                + " WHERE nazov like " + addApostrofs(ICO);

        ResultSet rs = DbManager.querySQL(query);
        try {
            if (rs != null) {

                while (rs.next()) {
                    //Retrieve by column name
                    result = rs.getString("nazov");
                }
                rs.close();

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        

        return result;
    }


    
    public static String hashPassword(String passwordToHash) {
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(passwordToHash.getBytes());
            //Get the hash's bytes
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
    
    private String addApostrofs(String name) {
        return "'" + name + "'";
    }
    
    public UserCompany getUser() {
        return UserCompany;
    }
    
    public Person getPerson() {
        return Person;
    }
     public City getCity() {
        return City;
    }
}
