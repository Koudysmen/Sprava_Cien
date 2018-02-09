/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model_Object;

import java.util.Date;

/**
 *
 * @author Michal
 */
public class CreateOrder {
   private int Id;
   private int IdSeller;
   private int IdBuyer;
   private Date dateOrder;
   private String state;

    public CreateOrder(int Id, int IdSeller, int IdBuyer, Date dateOrder, String state) {
        this.Id = Id;
        this.IdSeller = IdSeller;
        this.IdBuyer = IdBuyer;
        this.dateOrder = dateOrder;
        this.state = state;
    }

    public int getId() {
        return Id;
    }

    public int getIdSeller() {
        return IdSeller;
    }

    public int getIdBuyer() {
        return IdBuyer;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public String getState() {
        return state;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setIdSeller(int IdSeller) {
        this.IdSeller = IdSeller;
    }

    public void setIdBuyer(int IdBuyer) {
        this.IdBuyer = IdBuyer;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public void setState(String state) {
        this.state = state;
    }
   
   
   
}
