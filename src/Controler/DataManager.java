/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Connect.DBManager;
import Model_Object.Discount;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author tomas
 */
public class DataManager {
       private DBManager DbManager;
    SimpleDateFormat Formater = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    public DataManager(DBManager dbManager) {
        DbManager = dbManager;
    }
    
    
     public ArrayList<Integer> getDiscountsId(int userId) {
        ArrayList<Integer> result = new ArrayList<>();
        ResultSet rs = DbManager.querySQL("select"
                + " id_zlavy"
                + " FROM"
                + " uzivatel_zlavy"
                + " where id_uzivatela = " + userId                
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

    
     public ArrayList<Discount> getAllDiscounts(String email) throws SQLException {
        
        ArrayList<Discount> zlavy = new ArrayList<>();  
        ResultSet rsUser = DbManager.querySQL("SELECT id_uzivatela FROM registrovany_uzivatel where email = '"+email+"'");
                 
        ArrayList<Integer> zlavyId = getDiscountsId(rsUser.getInt("id_uzivatela"));  // id zliav ktore ma prihlaseny uzivatel
      
       
        
        for(int i : zlavyId)
        {
                ResultSet rs = DbManager.querySQL("SELECT"
                + " z.id_zlavy, z.id_typu, z.id_cenovej_zlavy, z.id_per_zlavy, zu.kod_zlavy "
                + " FROM"
                + " zlava z JOIN zlava_uzivatel zu ON(z.id_zlavy=zu.id_zlavy)"
                + " WHERE zu.id_zlavy = "+i
        );
                        
            zlavy.add(new Discount(i, rs.getInt("id_typu"), rs.getInt("id_cenovej_zlavy"), rs.getInt("id_per_zlavy"), rs.getString("kod_zlavy")));
        }
        
        
        return zlavy;
        
   
    }

}
