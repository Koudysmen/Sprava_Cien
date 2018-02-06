/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model_Object;

/**
 *
 * @author Michal
 */
public class OrderDetail {
   private String IdItem;
   private double Price;
   private String NameOfItem;
   private String Brand;
   private double Ks;
   private String Discount;

    public OrderDetail(String IdItem, double Price, String NameOfItem, String Brand, double Ks, String Discount) {
        this.IdItem = IdItem;
        this.Price = Price;
        this.NameOfItem = NameOfItem;
        this.Brand = Brand;
        this.Ks = Ks;
        this.Discount = Discount;
    }

    public String getIdItem() {
        return IdItem;
    }

    public double getPrice() {
        return Price;
    }

    public String getNameOfItem() {
        return NameOfItem;
    }

    public String getBrand() {
        return Brand;
    }

    public double getKs() {
        return Ks;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setIdItem(String IdItem) {
        this.IdItem = IdItem;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public void setNameOfItem(String NameOfItem) {
        this.NameOfItem = NameOfItem;
    }

    public void setBrand(String Brand) {
        this.Brand = Brand;
    }

    public void setKs(double Ks) {
        this.Ks = Ks;
    }

    public void setDiscount(String Discount) {
        this.Discount = Discount;
    }
   
   
   
}
