/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model_Object;

import java.util.Date;

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
    private String active;
    private Date dat_from;
    private Date dat_to;

    public Discount(int id_discnt, int id_type, int id_price_discnt, int id_per_discnt, String describe, String active, Date dat_from, Date dat_to) {
        this.id_discnt = id_discnt;
        this.id_type = id_type;
        this.id_price_discnt = id_price_discnt;
        this.id_per_discnt = id_per_discnt;
        this.describe = describe;
        this.active = active;
        this.dat_from = dat_from;
        this.dat_to = dat_to;
    }

    

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
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

    public Date getDat_from() {
        return dat_from;
    }

    public Date getDat_to() {
        return dat_to;
    }

    public void setDat_from(Date dat_from) {
        this.dat_from = dat_from;
    }

    public void setDat_to(Date dat_to) {
        this.dat_to = dat_to;
    }

    
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }



}
