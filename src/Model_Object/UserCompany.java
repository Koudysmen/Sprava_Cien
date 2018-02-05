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
public class UserCompany {
    private boolean IfCompany;
    private String emailLog;
    private String hashPassw;
    private String ICO;
     private String RC;

    public UserCompany(Boolean IfCompany, String emailLog, String hashPassw,String RC, String ICO) {
        if(IfCompany == true){
            this.emailLog = emailLog;
            this.hashPassw = hashPassw;
            this.RC = null;
            this.ICO = ICO;
        }else{
            this.emailLog = emailLog;
            this.hashPassw = hashPassw;
            this.RC = RC;
            this.ICO = null;
        }
    }

    public String getRC() {
        return RC;
    }

    

    public String getEmailLog() {
        return emailLog;
    }

    public String getHashPassw() {
        return hashPassw;
    }

    public void setEmailLog(String emailLog) {
        this.emailLog = emailLog;
    }

    public void setHashPassw(String hashPassw) {
        this.hashPassw = hashPassw;
    }

    public String getICO() {
        return ICO;
    }

    public void setICO(String ICO) {
        this.ICO = ICO;
    }
    
    
    
    
    
}
