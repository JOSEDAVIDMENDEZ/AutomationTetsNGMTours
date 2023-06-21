/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Methods;

import Base.BaseClass;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author David
 */
public class PrintLinks extends BaseClass {
     
    public PrintLinks(WebDriver driver, String browser) {
     super(driver, browser);   
    }
    
    public boolean checkpages() {
        //despues hacer el test de esta clase
        
        List<WebElement> links = FindElements(By.tagName("a"));;//lista de web elements
        String url = "";//variable donde se van a poner cada link para crear las listas de string
        ArrayList<String> linksOK = new ArrayList<String>();//lista para links ok   
        ArrayList<String> linksBAD = new ArrayList<String>();//lista para links mal

        HttpURLConnection connection = null;
        int responsecode = 0;
        Iterator<WebElement> it = links.iterator();

        while (it.hasNext()) {
            url = it.next().getAttribute("href");
            if (url == null || url.isEmpty()) {
                System.out.println("Link is not configurated or is not valid");
                continue;
            }
            try {
                connection = (HttpURLConnection) new URL(url).openConnection();//creacion de la conexion
                connection.setRequestMethod("HEAD");
                connection.connect();
                responsecode = connection.getResponseCode();

                if (responsecode > 400) {
                    System.out.println("ERROR BROKEN LINKS --- " + url);//links con respuesta de 4**,5**
                    linksBAD.add(url);
                } else {
                    System.out.println("VALID LINKS --- " + url);//links con respuesta de 1**,2**,3**
                    linksOK.add(url);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("VALID lINKS " + linksOK.size());
        System.out.println("INVALID lINKS " + linksBAD.size());

        if (linksBAD.size() > 0) {
            System.out.println("ERROR LINKS **** ----- ");
            for (String string : linksBAD) {
                System.out.println("Error links ---- " + string);
            }
            return false;
        } else {
            return true;
        }
    }
}
