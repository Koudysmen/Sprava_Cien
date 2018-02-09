/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Connect.DBManager;
import static Controler.Account.hashPassword;
import Model_Object.City;
import Model_Object.Person;
import Model_Object.Product;
import Model_Object.UserCompany;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Michal
 */
public class ControlerProductDetails {
     private DBManager DbManager;
     private Product Product;

    public ControlerProductDetails(DBManager DbManager) {
        this.DbManager = DbManager;
    }
     
        public boolean getDetails(String brand,String category , double maxPrice, int index) {
        boolean result = false;
         if (!isNullOrEmpty(brand)) {
            brand = " AND p.znacka like " + addApostrofs(brand);
        }
        if (!isNullOrEmpty(category)) {
            category = " AND k.nazov like " + addApostrofs(category);
        }
        
        ResultSet rs = DbManager.querySQL("SELECT p.nazov as nazov_predm,"
                + " p.cena as Price,"
                + " ku.id_zlavy as zlava,"
                + " p.znacka as znacka"
                + " from Predmet_predaja p"
                + " join Kategorie k using (id_kategorie)"
                + " left join Kumulacia_zliav ku using (id_predmetu)"
                + " where p.cena <=  " + maxPrice
                + category +brand
        );
        try {
            if (rs != null) {
                int i = 0;
                while (rs.next()) {
                    String belt = rs.getString("znacka");
                    String nameOfItem = rs.getString("nazov_predm");
                    int idDiscout = rs.getInt("zlava");
                    double Price = rs.getDouble("Price");
                    if(index == i){
                        this.Product = new Product(nameOfItem,belt,Price,idDiscout);
                        result = true;
                    }
                    i++;
                }
                rs.close();

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
    public String getPopis(String name) {
        String result = null;

        String query = "SELECT"
                + " popis"
                + " FROM"
                + " Predmet_predaja"
                + " WHERE nazov like " + addApostrofs(name);

        ResultSet rs = DbManager.querySQL(query);
        try {
            if (rs != null) {

                while (rs.next()) {
                    //Retrieve by column name
                    result = rs.getString("popis");
                }
                rs.close();

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
      return result;
    }
    
     public String getSerialNumber(String name) {
        String result = null;

        String query = "SELECT"
                + " seriove_cislo"
                + " FROM"
                + " Predmet_predaja"
                + " WHERE nazov like " + addApostrofs(name);

        ResultSet rs = DbManager.querySQL(query);
        try {
            if (rs != null) {

                while (rs.next()) {
                    //Retrieve by column name
                    result = rs.getString("seriove_cislo");
                }
                rs.close();

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
      return result;
    }
    
         
    public Product getProduct() {
        return Product;
    }
         
    public boolean isNullOrEmpty(String term) {
        return term == null || term.equals("") || term.equals("null");
    }
    
    private String addApostrofs(String name) {
        return "'" + name + "'";
    }
}
