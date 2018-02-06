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
   private int IdItem;
   private double Price;
   private String NameOfItem;
   private String Brand;
   private double Ks;
   private int Discount;

    public OrderDetail(int IdItem, double Price, String NameOfItem, String Brand, double Ks, int Discount) {
        this.IdItem = IdItem;
        this.Price = Price;
        this.NameOfItem = NameOfItem;
        this.Brand = Brand;
        this.Ks = Ks;
        this.Discount = Discount;
    }

    public int getIdItem() {
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

    public int getDiscount() {
        return Discount;
    }

    public void setIdItem(int IdItem) {
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

    public void setDiscount(int Discount) {
        this.Discount = Discount;
    }
   
   
   
}
