/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DML;

import Connect.DBManager;
import Model_Object.Company;
import Model_Object.Person;
import Model_Object.UserCompany;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michal
 */
public class Inserts {
     private DBManager DbManager;
     

    public Inserts(DBManager dbManager) {
        DbManager = dbManager;
    }
    
    public void insertUserCompany(UserCompany userComp) {
        boolean result = false;
        String query
                = "INSERT INTO registrovany_uzivatel VALUES ("+ null +"," + addApostrofs(userComp.getEmailLog()) + ","
                + addApostrofs(userComp.getHashPassw()) + ", null,"
                + addApostrofs(userComp.getICO()) + ")";
                System.out.println(query);
        DbManager.insertSql(query);
    }
    
     public void insertUser(UserCompany userComp) {
        boolean result = false;
        String query
                = "INSERT INTO registrovany_uzivatel VALUES ("+ null +"," + addApostrofs(userComp.getEmailLog()) + ","
                + addApostrofs(userComp.getHashPassw()) + ","
                + addApostrofs(userComp.getRC()) + ",null)";
                   System.out.println(query);

        DbManager.insertSql(query);
    }
    
    public void insertCompany(Company company) {
        String query
                = "INSERT INTO FIRMA VALUES (" + addApostrofs(company.getICO()) + ","
                + addApostrofs(company.getPSC()) + ","
                + addApostrofs(company.getNameOfCompany()) + ","
                + addApostrofs(company.getEmail()) + ")";

        DbManager.insertSql(query);
    }
    
    public void insertPerson(Person person) {
        String query
                = "INSERT INTO OSOBA VALUES (" + addApostrofs(person.getBornNumber()) + ","
                + addApostrofs(person.getName()) + ","
                + addApostrofs(person.getSurname()) + ","
                + addApostrofs(person.getPSC()) + ",null)";

        DbManager.insertSql(query);
    }
    
    
    private String addApostrofs(String name) {
        return "'" + name + "'";
    }
}
