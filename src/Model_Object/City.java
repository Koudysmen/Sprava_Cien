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
public class City {
  private String Street;
  private String NameOfTown;

    public City(String Street, String NameOfTown) {
        this.Street = Street;
        this.NameOfTown = NameOfTown;
    }

    public String getStreet() {
        return Street;
    }

    public String getNameOfTown() {
        return NameOfTown;
    }

    public void setStreet(String Street) {
        this.Street = Street;
    }

    public void setNameOfTown(String NameOfTown) {
        this.NameOfTown = NameOfTown;
    }
  
  
}
