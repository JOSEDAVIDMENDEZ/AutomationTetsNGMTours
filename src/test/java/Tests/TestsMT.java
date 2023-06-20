/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package Tests;

import Base.BaseClass;
import Methods.MTmethods;
import Methods.PageReservation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *      https://demo.guru99.com/test/newtours/
 * @author David
 */
public class TestsMT {
    MTmethods pageobject; 
    private WebDriver driver;
    
    public TestsMT() {
    }

    @org.testng.annotations.BeforeClass
    public  void setUpClass() throws Exception {
        pageobject= new MTmethods(driver);
        driver = pageobject.DriverConnection();
        pageobject.Visit("https://demo.guru99.com/test/newtours/");
        driver.manage().window().maximize();//este metodo maximize lo puedo hacer
    
    }

    @Test
    public void TestLogin(){
        assertTrue(pageobject.LoginPassed("admin", "admin"));
    }
    
    @Test
    public void TestRegister() throws InterruptedException{
        assertTrue(pageobject.RegisterPassed("admin", "admin"));
    }
    
    
    
    
    
    @org.testng.annotations.AfterClass
    public void tearDownClass() throws Exception {
        driver.quit();//puedo hacer un metodo close
    }
    
}
