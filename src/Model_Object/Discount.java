/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model_Object;

/**
 *
 * @author tomas
 */
public class Discount {
    private int id_discnt;
    private int id_type;
    private int id_price_discnt;
    private int id_per_discnt;
    private String describe;

    public Discount(int id_discnt, int id_type, int id_price_discnt, int id_per_discnt, String describe) {
        this.id_discnt = id_discnt;
        this.id_type = id_type;
        this.id_price_discnt = id_price_discnt;
        this.id_per_discnt = id_per_discnt;
        this.describe = describe;
    }

    public String getDescribe() {
        return describe;
    }

    public int getId_discnt() {
        return id_discnt;
    }

    public int getId_per_discnt() {
        return id_per_discnt;
    }

    public int getId_price_discnt() {
        return id_price_discnt;
    }

    public int getId_type() {
        return id_type;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public void setId_discnt(int id_discnt) {
        this.id_discnt = id_discnt;
    }

    public void setId_per_discnt(int id_per_discnt) {
        this.id_per_discnt = id_per_discnt;
    }

    public void setId_price_discnt(int id_price_discnt) {
        this.id_price_discnt = id_price_discnt;
    }

    public void setId_type(int id_type) {
        this.id_type = id_type;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }



}
