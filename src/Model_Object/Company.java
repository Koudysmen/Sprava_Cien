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
public class Company {
    private String ICO;
    private String nameOfCompany;
    private String PSC;
    private String email;

    public Company(String ICO, String PSC, String nameOfCompany, String email) {
        this.ICO = ICO;
        this.PSC = PSC;
        this.nameOfCompany = nameOfCompany;
        this.email = email;
    }
//k
    public String getICO() {
        return ICO;
    }

    public String getNameOfCompany() {
        return nameOfCompany;
    }

    public String getPSC() {
        return PSC;
    }

    public String getEmail() {
        return email;
    }

    public void setICO(String ICO) {
        this.ICO = ICO;
    }

    public void setNameOfCompany(String nameOfCompany) {
        this.nameOfCompany = nameOfCompany;
    }

    public void setPSC(String PSC) {
        this.PSC = PSC;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
