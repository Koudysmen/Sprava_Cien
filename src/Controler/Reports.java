/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Connect.DBManager;
import Model_Object.AccountMyOrder;
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
    
    public List<AccountMyOrder> getUserOrderSended(String Email) {
       String query = "SELECT id_objednavky,"
                + " dat_objednavky,"
                + " stav,"
                + " sum(cena*mnozstvo) as Price"
                + " from Objednavka o"
                + " join registrovany_uzivatel ru on(ru.id_uzivatela = o.kupujuci)"
                + " join Polozka using (id_objednavky)"
                + " where ru.email like " + addApostrofs(Email)
                + " and o.stav like 'N'"
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

    private String addApostrofs(String name) {
        return "'" + name + "'";
    }

    public boolean isNullOrEmpty(String term) {
        return term == null || term.equals("") || term.equals("null");
    }
}
