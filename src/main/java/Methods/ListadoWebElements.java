/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Methods;

import Base.BaseClass;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author David
 */
public class ListadoWebElements extends BaseClass{
 
    public ListadoWebElements(WebDriver driver) {
        super(driver);
    }
 
    public boolean ListInput(int cantinput){
       List<WebElement > inputs = FindElements(By.tagName("input"));
       return inputs.size() == cantinput;
    }
    
    
}
