/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *  Esta clase es para poner todos los metodos de selenium que serian utilizados en el test
 * @author David
 */
public abstract class BaseClass {
    public WebDriver driver;
    public String browser ;
    
    public BaseClass(WebDriver driver, String browser) {
        this.driver = driver;
        this.browser = browser;
    }
    
    public WebDriver DriverConnection(){
        
        
        //voy a validar ahora para cualquier browser dependiendo del quue se ponga en este proyecto
        if(browser.equals("Firefox")){
            WebDriverManager.firefoxdriver().setup();
            return driver = new FirefoxDriver();
        }else if(browser.equals("edge")){
            WebDriverManager.edgedriver().setup();
           return driver = new EdgeDriver();
           
        }else //if(browser.equals("edge")){
            WebDriverManager.chromedriver().setup();
            return driver = new ChromeDriver(); 
       // }
        //System.setProperty("webdriver.com.driver","drivers/chromedriver.exe");
        //driver = new ChromeDriver();
        
    }
    
    public void UrlNavegation(String url){
        driver.navigate().to(url);
    }
    
    public void Visit(String url){
        driver.get(url);
    }
    
    public WebElement FindElement(By locator){
        return driver.findElement(locator);
    }
    
    public String GetText(WebElement element){
        return element.getText();
    }
    
    public Boolean Contains(String cadena, By locator){
        return driver.findElement(locator).getText().contains(cadena);
    }
    
    public List<WebElement> FindElements(By locator){
        return driver.findElements(locator);
    }
    
    public void Type(String inputText,By locator){//metodo teclear
        driver.findElement(locator).sendKeys(inputText);
    }
    
    public void Click(By locator){//metodo teclear
        driver.findElement(locator).click();
    }
    
    public boolean isDisplayed(By locator){
        try{
             driver.findElement(locator).isDisplayed();
             return true;
        }catch (org.openqa.selenium.NoSuchElementException e){
             e.printStackTrace();
             return false;
            }
        }
    
    public void SendKeys(By locator, String text){
        driver.findElement(locator).sendKeys(text);
    }
    
    
}
