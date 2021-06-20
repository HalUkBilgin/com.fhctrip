package com.fhctrip.tests;

import com.fhctrip.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
//Tests packagenin altina class olusturun: CreateHotel
//Bir method olusturun: createHotel
//http://www.fhctrip.com/admin/HotelAdmin/Create adresine gidin.
//Username textbox ve password textboxlarini locate edin ve asagidaki verileri girin.
//Username : manager2
//Password : Man1ager2!
//Login butonuna basin.
//Acilan sayfadaki butun textboxlara istediginiz verileri girin (en sondaki dropdowna dikkat edin).
//Save butonuna basin.
//“Hotel was inserted successfully” textinin goruntulendigini dogrulayin.
//OK butonuna tiklayin.
public class CreateHotelPozitifTest extends TestBase {
    @Test
    public void  createHotel(){
        driver.get("http://fhctrip.com/admin/HotelAdmin/Create");
        WebElement userId = driver.findElement(By.id("UserName"));
        userId.sendKeys("manager2");
        WebElement passwordBox = driver.findElement(By.id("Password"));
        passwordBox.sendKeys("Man1ager2!");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        WebElement code = driver.findElement(By.id("Code"));
        WebElement name = driver.findElement(By.id("Name"));
        WebElement address = driver.findElement(By.id("Address"));
        WebElement phone = driver.findElement(By.id("Phone"));
        WebElement email = driver.findElement(By.id("Email"));
        WebElement iDGroup = driver.findElement(By.id("IDGroup"));
        Select idGroupSelect = new Select(iDGroup);
        code.sendKeys("1");
        name.sendKeys("Adam & Eva Hotel");
        address.sendKeys("Athens Greece");
        phone.sendKeys("2103456543");
        email.sendKeys("adamevahotel@gmail.com");
        idGroupSelect.selectByIndex(1);
        WebElement save = driver.findElement(By.id("btnSubmit"));
        save.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean isTrue=  wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class='bootbox-body']"), "Hotel was inserted successfully"));
        Assert.assertTrue(isTrue);
        //WebElement submitMesssage = driver.findElement(By.xpath("//div[@class='bootbox-body']"));
        //Assert.assertTrue(submitMesssage.isDisplayed());
        WebElement okButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        okButton.click();
        driver.close();
        driver.manage().window().maximize();
    }
}
