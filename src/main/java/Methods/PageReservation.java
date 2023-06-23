/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Methods;

import Base.BaseClass;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author David
 */
public class PageReservation extends BaseClass{
    By linkFlight = By.linkText("Flights");
    By imageReservation = By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td"
            + "/table/tbody/tr/td[2]/table/tbody/tr[1]/td/img");
    By passcount = By.name("passCount");
    By fromport = By.name("fromPort");
    By frommonth = By.name("fromMonth");
    By fromday = By.name("fromDay");
    By toport = By.name("toPort");
    By tomonth = By.name("toMonth");
    By today = By.name("toDay");
    By buttoncontinue = By.name("findFlights");
    By buttonback = By.xpath("/html/body/div[2]/table/tbody/tr/td[2]"
            + "/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/a");
    
    public PageReservation(WebDriver driver, String browser) {
        super(driver, browser);
    }
    
    public boolean SelectPassed(int numeroPasajeros, String department, 
                                String on, int day, String to, String returning, int dayreturn) throws InterruptedException{
        Thread.sleep(3000);
        Click(linkFlight);
        Thread.sleep(8000);
        
       /* WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(8000));
        if(wait.until(ExpectedConditions.alertIsPresent()) == null){
            System.out.println("Alert no dispalyed");
        }else{
            driver.switchTo().alert().accept();
            //driver.switchTo().alert().dismiss();
        }
        */
        
        if(isDisplayed(imageReservation)){
            Select numpas = new Select(FindElement(passcount));
            numpas.selectByVisibleText(Integer.toString(numeroPasajeros));
            
            Select depart = new Select(FindElement(fromport));
            depart.selectByVisibleText(department);
            
            Select mes = new Select(FindElement(frommonth));
            mes.selectByVisibleText(on);
            
            Select dayida = new Select(FindElement(fromday));
            dayida.selectByVisibleText(Integer.toString(day));
            
            Select toports = new Select(FindElement(toport));
            toports.selectByVisibleText(to);
            
            Select returnn = new Select(FindElement(tomonth));
            returnn.selectByVisibleText(returning);
            
            Select dayr = new Select(FindElement(today));
            dayr.selectByVisibleText(Integer.toString(dayreturn));
            
            Click(buttoncontinue);
            //me faltaron varias para marcarlas todas
            
        } else{
        return false;
        }
        
        return isDisplayed(buttonback);
    }
    
}
