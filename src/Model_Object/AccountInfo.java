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
public class AccountInfo {
  private String bornNumber;
  private String Name;
  private String Surname;
  private String PSC;
  private String ICO;
  private String nameOfCompany;
  private String email;
  private String Street;
  private String NameOfTown;

    public AccountInfo(String bornNumber, String Name, String Surname, String PSC, String ICO, String nameOfCompany, String email, String Street, String NameOfTown) {
        this.bornNumber = bornNumber;
        this.Name = Name;
        this.Surname = Surname;
        this.PSC = PSC;
        this.ICO = ICO;
        this.nameOfCompany = nameOfCompany;
        this.email = email;
        this.Street = Street;
        this.NameOfTown = NameOfTown;
    }

    public String getBornNumber() {
        return bornNumber;
    }

    public String getName() {
        return Name;
    }

    public String getSurname() {
        return Surname;
    }

    public String getPSC() {
        return PSC;
    }

    public String getICO() {
        return ICO;
    }

    public String getNameOfCompany() {
        return nameOfCompany;
    }

    public String getEmail() {
        return email;
    }

    public String getStreet() {
        return Street;
    }

    public String getNameOfTown() {
        return NameOfTown;
    }

    public void setBornNumber(String bornNumber) {
        this.bornNumber = bornNumber;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    public void setPSC(String PSC) {
        this.PSC = PSC;
    }

    public void setICO(String ICO) {
        this.ICO = ICO;
    }

    public void setNameOfCompany(String nameOfCompany) {
        this.nameOfCompany = nameOfCompany;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStreet(String Street) {
        this.Street = Street;
    }

    public void setNameOfTown(String NameOfTown) {
        this.NameOfTown = NameOfTown;
    }
  
  
}
