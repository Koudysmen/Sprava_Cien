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
public class AccountMyOrder {
    private int idCustOrder;
    private Date DateOfOrder;
    private String state;
    private double TotalPrice;

    public AccountMyOrder(int idCustOrder, Date DateOfOrder, String state, double TotalPrice) {
        this.idCustOrder = idCustOrder;
        this.DateOfOrder = DateOfOrder;
        this.state = state;
        this.TotalPrice = TotalPrice;
    }

    public int getIdCustOrder() {
        return idCustOrder;
    }

    public Date getDateOfOrder() {
        return DateOfOrder;
    }

    public String getState() {
        return state;
    }

    public double getTotalPrice() {
        return TotalPrice;
    }
    
    

    public void setIdCustOrder(int idCustOrder) {
        this.idCustOrder = idCustOrder;
    }

    public void setDateOfOrder(Date DateOfOrder) {
        this.DateOfOrder = DateOfOrder;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    
}
