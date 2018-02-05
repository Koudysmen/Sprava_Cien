/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DML;

import Connect.DBManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Michal
 */
public class UniquePK {
    private DBManager DbManager;
     

    public UniquePK(DBManager dbManager) {
        DbManager = dbManager;
    }
    
    public boolean uniqueICO(String ICO) {
        ICO = addApostrofs(ICO);
        boolean result = false;
        ResultSet rs = DbManager.querySQL("SELECT"
                + " count(*) as count"
                + " FROM"
                + " Firma"
                + " WHERE ICO like " + ICO
        );
        try {
            if (rs != null) {

                rs.next();
                //Retrieve by column name
                int count = rs.getInt("count");
                if (count == 0) {
                    result = true;
                }
                rs.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
    
    public boolean uniqueRC(String rc) {
        rc = addApostrofs(rc);
        boolean result = false;
        ResultSet rs = DbManager.querySQL("SELECT"
                + " count(*) as count"
                + " FROM"
                + " Osoba"
                + " WHERE rod_cislo = " + rc
        );
        try {
            if (rs != null) {

                rs.next();
                //Retrieve by column name
                int count = rs.getInt("count");
                if (count == 0) {
                    result = true;
                }
                rs.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
    
    public boolean uniqueEmail(String email) {
        email = addApostrofs(email);
        boolean result = false;
        ResultSet rs = DbManager.querySQL("SELECT"
                + " count(*) as count"
                + " FROM"
                + " registrovany_uzivatel"
                + " WHERE email = " + email
        );
        try {
            if (rs != null) {

                rs.next();
                //Retrieve by column name
                int count = rs.getInt("count");
                if (count == 0) {
                    result = true;
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
    
}
