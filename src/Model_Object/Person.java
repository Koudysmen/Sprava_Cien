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
public class Person {
  private String bornNumber;
  private String Name;
  private String Surname;
  private String PSC;

    public Person(String bornNumber, String Name, String Surname, String PSC) {
        this.bornNumber = bornNumber;
        this.Name = Name;
        this.Surname = Surname;
        this.PSC = PSC;
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
  
  

}
