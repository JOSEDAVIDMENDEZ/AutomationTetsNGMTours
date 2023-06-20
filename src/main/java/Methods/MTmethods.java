/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Methods;

import Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/** esta es la page object, aqui hago la declaracion de todas las variables que usare en los test 
 *  ademas de los metodos a utilizar, asi dejo los test impecables
 * @author David
 */
public class MTmethods extends BaseClass {
   
    By link = By.linkText("REGISTER");
    By xpathLoginSuccesfull = By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/h3"); 
    By email = By.name("email");
    By password = By.name("password");
    By confirmpassword = By.name("confirmPassword");
    By buttonSubmit = By.name("submit");
    By username = By.name("userName");
    By xpathRegister1 = By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/"
            + "tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p/font");
   // By xpathRegister2 = By.xpath("/html/body/div[2]/table/tbody/tr/td[2]"
     //       + "/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/font/b");
     By xpathImageRegSuccessfull = By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/"
             + "tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/img");
    
    
    public MTmethods(WebDriver driver) {
        super(driver);
    }
    
    public boolean RegisterPassed(String user, String passw) throws InterruptedException{
        Click(link);
        Thread.sleep(3000);
            if(isDisplayed(xpathRegister1)){
                SendKeys(email, user);
                SendKeys(password, passw);
                SendKeys(confirmpassword, passw);
            }else{
                return false;
            }
            
        return isDisplayed(xpathImageRegSuccessfull);
    }
    
    public boolean LoginPassed(String user, String passw){
        SendKeys(username, user);
        SendKeys(password, passw);
        Click(buttonSubmit);
        return Contains("Login Successfully",xpathLoginSuccesfull);
    }
    
    
}
