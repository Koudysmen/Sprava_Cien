/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Connect.DBManager;
import Model_Object.AccountMyOrder;
import Model_Object.Discount;
import Model_Object.OrderDetail;
import Model_Object.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Michal
 */
public class Reports {

    private DBManager DbManager;
    SimpleDateFormat Formater = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    public Reports(DBManager dbManager) {
        DbManager = dbManager;
    }

    public List<AccountMyOrder> getUserOrder(String Email) {
        String query = "SELECT id_objednavky,"
                + " dat_objednavky,"
                + " stav,"
                + " sum(cena*mnozstvo) as Price"
                + " from Objednavka o"
                + " join registrovany_uzivatel ru on(ru.id_uzivatela = o.kupujuci)"
                + " join Polozka using (id_objednavky)"
                + " where ru.email like " + addApostrofs(Email)
                + " group by id_objednavky, dat_objednavky, stav,o.kupujuci";

        List<AccountMyOrder> result = new ArrayList<>();
        ResultSet rs = DbManager.querySQL(query);
        try {
            if (rs != null) {
                while (rs.next()) {
                    int IdOrder = rs.getInt("id_objednavky");
                    Date DateOfOrder = rs.getDate("dat_objednavky");
                    String stateOrder = rs.getString("stav");
                    double Price = rs.getDouble("Price");
                    AccountMyOrder userOrder = new AccountMyOrder(IdOrder, DateOfOrder, stateOrder, Price);
                    result.add(userOrder);
                }
                rs.close();

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
    
    public boolean getPerCenDiscount(int userId, String disCode) throws SQLException
    {
        int perId=-1;
        int cenId=-1;
        
        String query = "select id_per_zlavy from uzivatel_zlavy"
                      +" JOIN zlava USING(id_zlavy)"
                      +" where kod_zlavy = '"+disCode+"' and id_uzivatela = "+userId;
        ResultSet rs = DbManager.querySQL(query);
        
        if(rs.next())
        {
        perId = rs.getInt("id_per_zlavy");
        }
     
        
        
        query = "select id_cenovej_zlavy from uzivatel_zlavy"
                      +" JOIN zlava USING(id_zlavy)"
                      +" where kod_zlavy = '"+disCode+"' and id_uzivatela = "+userId;
          rs = DbManager.querySQL(query);
          
          if(rs.next())
          {
          cenId = rs.getInt("id_cenovej_zlavy");
          }
              
                   
        return perId>0;
        
        /*
        String query = "SELECT * "
        + " FROM uzivatel_zlavy"
        + " JOIN zlava USING(id_zlavy)"
        + " JOIN cenova_zlava USING(id_cenovej_zlavy)"
        + " JOIN percentualna_zlava USING(id_per_zlavy)"
        + " WHERE id_uzivatela = "+userId
        + " AND kod_zlavy = '"+disId+"'";
        ResultSet rs = DbManager.querySQL(query);
         */
        
    }
    
    public double getCenDis(int userId, String disCode) throws SQLException
    {
        double discount = 0.0;
    String query = "SELECT hodnota_zlavy"
            + " FROM uzivatel_zlavy"
            + " JOIN zlava USING(id_zlavy)"
            + " JOIN cenova_zlava USING(id_cenovej_zlavy)"
            + " WHERE id_uzivatela = "+userId
            + " AND kod_zlavy = '"+disCode+"'";
        ResultSet rs = DbManager.querySQL(query);
    
        if(rs.next())
        {
         discount = rs.getDouble("hodnota_zlavy");
        }
        return discount; 
    }
    
      public double getPerDis(int userId, String disCode) throws SQLException
    {
        double discount = 0.0;
    String query = "SELECT percent_zlavy"
            + " FROM uzivatel_zlavy"
            + " JOIN zlava USING(id_zlavy)"
            + " JOIN percentualna_zlava USING(id_per_zlavy)"
            + " WHERE id_uzivatela = "+userId
            + " AND kod_zlavy = '"+disCode+"'";
        ResultSet rs = DbManager.querySQL(query);
    
        if(rs.next())
        {
         discount = rs.getDouble("percent_zlavy");
        }
        return discount; 
    }
    
    
    public List<AccountMyOrder> getUserOrderSended(String Email) {
       String query = "SELECT id_objednavky,"
                + " dat_objednavky,"
                + " stav,"
                + " sum(cena*mnozstvo) as Price"
                + " from Objednavka o"
                + " join registrovany_uzivatel ru on(ru.id_uzivatela = o.kupujuci)"
                + " left join Polozka using (id_objednavky)"
                + " where ru.email like " + addApostrofs(Email)
                + " and o.stav like 'S'"
                + " group by id_objednavky, dat_objednavky, stav,o.kupujuci";

        List<AccountMyOrder> result = new ArrayList<>();
        ResultSet rs = DbManager.querySQL(query);
        try {
            if (rs != null) {
                while (rs.next()) {
                    int IdOrder = rs.getInt("id_objednavky");
                    Date DateOfOrder = rs.getDate("dat_objednavky");
                    String stateOrder = rs.getString("stav");
                    double Price = rs.getDouble("Price");
                    AccountMyOrder userOrder = new AccountMyOrder(IdOrder, DateOfOrder, stateOrder, Price);
                    result.add(userOrder);
                }
                rs.close();

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
    
     public double getOrderPrice(int idOrder) {
         double result = 0;
         String query = "SELECT"
                + " sum(cena*mnozstvo) as Price"
                + " from Polozka "
                + " where id_objednavky = " + idOrder;

       ResultSet rs = DbManager.querySQL(query);
        try {
            if (rs != null) {

                rs.next();
                //Retrieve by column name
                result = rs.getDouble("Price");
                rs.close();

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
     
     public Date getOrderDate(int idOrder) {
         Date result = null; 
         String query = "SELECT"
                + " dat_objednavky"
                + " from Objednavka "
                + " where id_objednavky = " + idOrder;

       ResultSet rs = DbManager.querySQL(query);
        try {
            if (rs != null) {

                rs.next();
                //Retrieve by column name
                result = rs.getDate("dat_objednavky");
                rs.close();

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
     
     public int getMaxIdOrder() {
         int result = 0; 
         String query = "SELECT"
                + " max(id_objednavky) as max"
                + " from Objednavka "
            ;

       ResultSet rs = DbManager.querySQL(query);
        try {
            if (rs != null) {

                rs.next();
                //Retrieve by column name
                result = rs.getInt("max");
                rs.close();

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
     
     public int getIdDiscout(String code) {
         int result = 0; 
         String query = "SELECT"
                + " id_zlavy as zlava"
                + " from uzivatel_zlavy"
                + " where kod_zlavy like" + addApostrofs(code)
            ;

       ResultSet rs = DbManager.querySQL(query);
        try {
            if (rs != null) {

                rs.next();
                //Retrieve by column name
                result = rs.getInt("zlava");
                rs.close();

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
    
    public int getIDProduct(String nameOfProduct) {
         int result = 0; 
         String query = "SELECT"
                + " id_predmetu as predmet"
                + " from Predmet_predaja"
                + " where nazov like" + addApostrofs(nameOfProduct)
            ;

       ResultSet rs = DbManager.querySQL(query);
        try {
            if (rs != null) {

                rs.next();
                //Retrieve by column name
                result = rs.getInt("predmet");
                rs.close();

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
    
    
    public List<OrderDetail> getOrderDetail(int IdOrder) {
       String query = "SELECT p.id_predmetu,"
                + " p.cena as Price,"
                + " p.mnozstvo as mnozstvo,"
                + " p.id_zlavy as zlava,"
                + " pp.znacka as znacka,"
                + " pp.nazov nazov_predm"
                + " from Polozka p"
                + " join Predmet_predaja pp using(id_predmetu)"
                + " join Kategorie using (id_kategorie)"
                + " where p.id_objednavky = " + IdOrder;
                

        List<OrderDetail> result = new ArrayList<>();
        ResultSet rs = DbManager.querySQL(query);
        try {
            if (rs != null) {
                while (rs.next()) {
                    int IdOrderInput = rs.getInt("id_predmetu");
                    String belt = rs.getString("znacka");
                    String nameOfItem = rs.getString("nazov_predm");
                    int idDiscout = rs.getInt("zlava");
                    double Price = rs.getDouble("Price");
                    double ks = rs.getDouble("mnozstvo");
                    OrderDetail ordDetail = new OrderDetail(IdOrderInput, Price, nameOfItem, belt, ks, idDiscout);
                    result.add(ordDetail);
                }
                rs.close();

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
    
    public List<Product> getProduct(String brand,String category , double maxPrice) {
        if (!isNullOrEmpty(brand)) {
            brand = " AND p.znacka like " + addApostrofs(brand);
        }
        if (!isNullOrEmpty(category)) {
            category = " AND k.nazov like " + addApostrofs(category);
        }
      
        
        String query = "SELECT p.nazov as nazov_predm,"
                + " p.cena as Price,"
                + " ku.id_zlavy as zlava,"
                + " p.znacka as znacka"
                + " from Predmet_predaja p"
                + " join Kategorie k using (id_kategorie)"
                + " left join Kumulacia_zliav ku using (id_predmetu)"
                + " where p.cena <=  " + maxPrice
                + category +brand;
                

        List<Product> result = new ArrayList<>();
        ResultSet rs = DbManager.querySQL(query);
        try {
            if (rs != null) {
                while (rs.next()) {
                    String belt = rs.getString("znacka");
                    String nameOfItem = rs.getString("nazov_predm");
                    int idDiscout = rs.getInt("zlava");
                    double Price = rs.getDouble("Price");
                    Product prod = new Product(nameOfItem,belt,Price,idDiscout);
                    result.add(prod);
                }
                rs.close();

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
    
    
    
    public ArrayList<Discount> getAktivValidDiscount(int userId)
    {
    ArrayList<Discount> discounts = new ArrayList<>();
    
    String query =   " SELECT id_zlavy, id_typu, id_cenovej_zlavy, id_per_zlavy, kod_zlavy, aktivna, dat_od, dat_do"
                   + " FROM zlava JOIN uzivatel_zlavy USING(id_zlavy)"
                   + " WHERE aktivna = 'Y'"
                   + " AND (dat_do IS NULL OR dat_do > sysdate())"
                   + " AND id_uzivatela = "+userId;
    
    ResultSet rs = DbManager.querySQL(query);
         try {
            if (rs != null) {
                while (rs.next()) {
                    int id_discount = rs.getInt("id_zlavy");
                    int id_type = rs.getInt("id_typu");
                    int id_price_disc = rs.getInt("id_cenovej_zlavy");
                    int id_per_disc = rs.getInt("id_per_zlavy");
                    String disc_code = rs.getString("kod_zlavy");
                    String active = rs.getString("aktivna");
                    Date date_from = rs.getDate("dat_od");
                    Date date_to = rs.getDate("dat_do");
                    Discount discount = new Discount(id_discount, id_type, id_price_disc, id_per_disc, disc_code, active, date_from, date_to);
                
                    discounts.add(discount);
                }
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
         return discounts;
    }
    
      public ArrayList<Discount> getAktivInvalidDiscount(int userId)
    {
    ArrayList<Discount> discounts = new ArrayList<>();
    
    String query =   " SELECT id_zlavy, id_typu, id_cenovej_zlavy, id_per_zlavy, kod_zlavy, aktivna, dat_od, dat_do"
                   + " FROM zlava JOIN uzivatel_zlavy USING(id_zlavy)"
                   + " WHERE aktivna = 'Y'"
                   + " AND dat_do < sysdate()"
                   + " AND id_uzivatela = "+userId;
    
    ResultSet rs = DbManager.querySQL(query);
         try {
            if (rs != null) {
                while (rs.next()) {
                    int id_discount = rs.getInt("id_zlavy");
                    int id_type = rs.getInt("id_typu");
                    int id_price_disc = rs.getInt("id_cenovej_zlavy");
                    int id_per_disc = rs.getInt("id_per_zlavy");
                    String disc_code = rs.getString("kod_zlavy");
                    String active = rs.getString("aktivna");
                    Date date_from = rs.getDate("dat_od");
                    Date date_to = rs.getDate("dat_do");
                    Discount discount = new Discount(id_discount, id_type, id_price_disc, id_per_disc, disc_code, active, date_from, date_to);
                
                    discounts.add(discount);
                }
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
         return discounts;
    }
      
        public ArrayList<Discount> getInaktivValidDiscount(int userId)
    {
    ArrayList<Discount> discounts = new ArrayList<>();
    
    String query =   " SELECT id_zlavy, id_typu, id_cenovej_zlavy, id_per_zlavy, kod_zlavy, aktivna, dat_od, dat_do"
                   + " FROM zlava JOIN uzivatel_zlavy USING(id_zlavy)"
                   + " WHERE aktivna = 'N'"
                   + " AND (dat_do IS NULL OR dat_do > sysdate())"
                   + " AND id_uzivatela = "+userId;
    
    ResultSet rs = DbManager.querySQL(query);
         try {
            if (rs != null) {
                while (rs.next()) {
                    int id_discount = rs.getInt("id_zlavy");
                    int id_type = rs.getInt("id_typu");
                    int id_price_disc = rs.getInt("id_cenovej_zlavy");
                    int id_per_disc = rs.getInt("id_per_zlavy");
                    String disc_code = rs.getString("kod_zlavy");
                    String active = rs.getString("aktivna");
                    Date date_from = rs.getDate("dat_od");
                    Date date_to = rs.getDate("dat_do");
                    Discount discount = new Discount(id_discount, id_type, id_price_disc, id_per_disc, disc_code, active, date_from, date_to);
                
                    discounts.add(discount);
                }
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
         return discounts;
    }
        
          public ArrayList<Discount> getInaktivInvalidDiscount(int userId)
    {
    ArrayList<Discount> discounts = new ArrayList<>();
    
    String query =   " SELECT id_zlavy, id_typu, id_cenovej_zlavy, id_per_zlavy, kod_zlavy, aktivna, dat_od, dat_do"
                   + " FROM zlava JOIN uzivatel_zlavy USING(id_zlavy)"
                   + " WHERE aktivna = 'N'"
                   + " AND dat_do < sysdate()"
                   + " AND id_uzivatela = "+userId;
    
    ResultSet rs = DbManager.querySQL(query);
         try {
            if (rs != null) {
                while (rs.next()) {
                    int id_discount = rs.getInt("id_zlavy");
                    int id_type = rs.getInt("id_typu");
                    int id_price_disc = rs.getInt("id_cenovej_zlavy");
                    int id_per_disc = rs.getInt("id_per_zlavy");
                    String disc_code = rs.getString("kod_zlavy");
                    String active = rs.getString("aktivna");
                    Date date_from = rs.getDate("dat_od");
                    Date date_to = rs.getDate("dat_do");
                    Discount discount = new Discount(id_discount, id_type, id_price_disc, id_per_disc, disc_code, active, date_from, date_to);
                
                    discounts.add(discount);
                }
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
         return discounts;
    }
    
       public String getNameOfTypeDiscount(int idType) throws SQLException
       {
           String nazov = "";
           String query = "SELECT nazov_typu FROM typ_zlavy WHERE id_typu ="+idType;
           ResultSet rs = DbManager.querySQL(query);
            try {
           if (rs != null) {
                while (rs.next()) {
                    nazov = rs.getString("nazov_typu");
                  }
                rs.close();
            }
           } catch (SQLException e) {
        }
           return nazov;
       }
    
    
        public int getUserId(String email)
        {
        int userId = 0;
        String query = "SELECT id_uzivatela FROM registrovany_uzivatel where email= '"+email+"'";
        ResultSet rs = DbManager.querySQL(query);
           try {
            if (rs != null) {
                while (rs.next()) {
                    userId = rs.getInt("id_uzivatela");
                  }
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
          
           return userId;
        }
    
        public ArrayList<Integer> getDiscountsId(int userId) {
        ArrayList<Integer> result = new ArrayList<>();
        ResultSet rs = DbManager.querySQL("select id_zlavy FROM uzivatel_zlavy WHERE id_uzivatela = " + userId                
        );
        try {
            if (rs != null) {
                while (rs.next()) {
                    result.add(rs.getInt("id_zlavy"));
                }
                rs.close();

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
    
    public ArrayList<String> getIdOrder(String Email) {
         ArrayList<String> result = new ArrayList<>();
         ResultSet rs = DbManager.querySQL( "SELECT"
                + " id_objednavky"
                + " FROM"
                + " Objednavka o"
                + " join Registrovany_uzivatel ru on(ru.id_uzivatela = o.kupujuci)"
                + " WHERE ru.email like " + addApostrofs(Email));

        try {
            if (rs != null) {
                while (rs.next()) {
                    result.add(rs.getString("id_objednavky"));
                }
                rs.close();

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
    
     public ArrayList<String> getCategories() {
         ArrayList<String> result = new ArrayList<>();
         ResultSet rs = DbManager.querySQL( "SELECT"
                + " nazov"
                + " FROM"
                + " Kategorie"
            );

        try {
            if (rs != null) {
                while (rs.next()) {
                    result.add(rs.getString("nazov"));
                }
                rs.close();

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
     
     public ArrayList<String> getBrand() {
         ArrayList<String> result = new ArrayList<>();
         ResultSet rs = DbManager.querySQL( "SELECT distinct"
                + " znacka"
                + " FROM"
                + " Predmet_predaja"
                + " where znacka is not null"
            );

        try {
            if (rs != null) {
                while (rs.next()) {
                    result.add(rs.getString("znacka"));
                }
                rs.close();

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
        
    private String addApostrofs(String name) {
        return "'" + name + "'";
    }

    public boolean isNullOrEmpty(String term) {
        return term == null || term.equals("") || term.equals("null");
    }
    
    
    
    
}
