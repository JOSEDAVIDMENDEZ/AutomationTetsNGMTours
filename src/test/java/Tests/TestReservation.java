/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package Tests;

import Methods.PageReservation;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author David
 */
public class TestReservation {
    PageReservation reservation;
    private WebDriver driver;
    
    public TestReservation() {
    }

    @BeforeClass
    public void setUpClass() throws Exception {
        reservation = new PageReservation(driver);
        driver = reservation.DriverConnection();
        reservation.Visit("https://demo.guru99.com/test/newtours/");
        driver.manage().window().maximize();
    }
    
    @Test   
    public void TestReservation() throws InterruptedException{
              
        assertTrue(reservation.SelectPassed(2, "London", "July", 25, "Acapulco", "August", 12));
    }
    
    @AfterClass
    public void tearDownClass() throws Exception {
        driver.quit();
    }
    
}
