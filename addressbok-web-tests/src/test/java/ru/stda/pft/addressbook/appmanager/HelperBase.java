package ru.stda.pft.addressbook.appmanager;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

public class HelperBase {
    public boolean acceptNextAlert = true;
    protected static WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    protected static void click(By locator) {
        wd.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        click(locator);
        if (text != null) {
            String existingText = wd.findElement(locator).getAttribute("value");
            if (!text.equals(existingText)) {
                wd.findElement(locator).clear();
                wd.findElement(locator).sendKeys(text);
            }
        }}

        protected void attach(By locator, File file) {
            if (file != null) {
              wd.findElement(locator).sendKeys(file.getAbsolutePath());
                }
            }
/*    protected void list_check (By locator) {
        new Select(wd.findElement(locator)).getFirstSelectedOption();
    }*/


    protected void chois(By locator, String text) {
        if (text!=null){
        click(locator);
        if (IsElementOfListPresent(locator,text) ){
        new Select(wd.findElement(locator)).selectByVisibleText(text);}
    }}

    public static boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }

    }

    protected boolean IsElementOfListPresent(By locator, String text) {
        try {
            new Select(wd.findElement(locator)).selectByVisibleText(text);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }

    }

    private boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public String closeAlertAndGetItsText() {
        try {
            Alert alert = wd.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

/*    protected void clickButton(By text) {
        wd.findElement(text).click();

    }

    protected void clickId(By id) {

        wd.findElement(id).click();

    }*/
}
