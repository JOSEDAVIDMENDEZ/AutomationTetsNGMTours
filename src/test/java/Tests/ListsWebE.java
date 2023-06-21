/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package Tests;

import Methods.ListadoWebElements;
import java.io.File;
import java.io.IOException;
import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.*;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author David
 */
public class ListsWebE {
    WebDriver driver;
    ListadoWebElements listado;
    
    
    public ListsWebE() {
    }

    @BeforeClass
    public void setUpClass() throws Exception {
        listado = new ListadoWebElements(driver, "chrome");
        driver = listado.DriverConnection();
        listado.Visit("https://demo.guru99.com/test/newtours/");
        driver.manage().window().maximize();
    }

    @Test
    public void ListInputs(){
        assertFalse(listado.ListInput(15));
    }
    
    @AfterMethod
    public void tearDown(ITestResult result){
        //metodo parfa hacer capturas a los errores, manana poner esto en la clase base
        if(!result.isSuccess()){
            File myScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //crea este file virtual
            try{
                FileUtils.copyFile(myScreenshot,new File("Error "+System.currentTimeMillis()+".png"));
            }catch(IOException e){
                e.printStackTrace();;
            }
        }
        driver.close();
    }
    
    @AfterClass
    public void tearDownClass() throws Exception {
        driver.quit();
    }
    
}
