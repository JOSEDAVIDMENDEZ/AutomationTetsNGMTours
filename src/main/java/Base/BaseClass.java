/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Base;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *  Esta clase es para poner todos los metodos de selenium que serian utilizados en el test
 * @author David
 */
public abstract class BaseClass {
    public WebDriver driver;

    public BaseClass(WebDriver driver) {
        this.driver = driver;
    }
    
    public WebDriver DriverConnection(){
        System.setProperty("webdriver.com.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
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
