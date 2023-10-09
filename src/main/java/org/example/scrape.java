package org.example;
import com.ilovethislanguagesomuch.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class scrape {
    private static void checkSelectList(List<WebElement> select){
        if (!select.isEmpty()){
            select.get(0).click();
        } else {
            System.out.println("lol");
        }
    }
    public static void scraping(FirefoxDriver ao, String word) throws InterruptedException, NoSuchElementException {
        List<WebElement> select = ao.findElements(By.className("btn-action"));
        checkSelectList(select);
        WebElement input = ao.findElement(By.id("word"));
        input.sendKeys(word);
        input.sendKeys(Keys.ENTER);
        Thread.sleep(10000);
        WebElement outer = ao.findElement(By.id("sen0"));
        WebElement Inner = outer.findElement(By.className("sm2_link"));
        String link = Inner.getAttribute("href");
        //hardcoded lol
        String substr = link.substring(34);

        download.downplease(link, "D:\\sekolah\\tik\\" + substr); // done banh please
    }
}
