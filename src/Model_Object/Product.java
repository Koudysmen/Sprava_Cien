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
public class Product {
  private String nameOfProduct;
  private String brand;
  private double Price;
  private int zlava;

    public Product(String nameOfProduct, String brand, double Price, int zlava) {
        this.nameOfProduct = nameOfProduct;
        this.brand = brand;
        this.Price = Price;
        this.zlava = zlava;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return Price;
    }

    public int getZlava() {
        return zlava;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public void setZlava(int zlava) {
        this.zlava = zlava;
    }

    @Override
    public String toString() {
        return "Product{" + "nameOfProduct=" + nameOfProduct + ", brand=" + brand + ", Price=" + Price + ", zlava=" + zlava + '}';
    }
  
  
}
