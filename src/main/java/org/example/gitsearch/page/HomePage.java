package org.example.gitsearch.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    By bySearchBar = By.xpath("//input[@data-testid='search-bar']");
    By bySearchButton = By.xpath("//input[@data-testid='search-bar']//following-sibling::button[@type='submit']");
    By byRepos = By.xpath("//p[text()='repos']//preceding-sibling::h3");
    By byFollowers = By.xpath("//p[text()='followers']//preceding-sibling::h3");
    By byFollowing = By.xpath("//p[text()='following']//preceding-sibling::h3");
    By byGists = By.xpath("//p[text()='gists']//preceding-sibling::h3");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchName(String name){
        this.driver.findElement(bySearchBar).clear();
        this.driver.findElement(bySearchBar).sendKeys(name);
    }

    public void clickSearchButton(){
        boolean exceptionOccurred = false;
        int numberOfTries = 0;

        do {
            try {
                ++numberOfTries;
                WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(30L));
                WebElement element = (WebElement)wait.until(ExpectedConditions.elementToBeClickable(bySearchButton));
                (new Actions(this.driver)).scrollToElement(element).moveToElement(element);
                ((WebElement)wait.until(ExpectedConditions.visibilityOfElementLocated(bySearchButton))).click();
            } catch (Exception var6) {
                exceptionOccurred = true;
            }
        } while(exceptionOccurred && numberOfTries < 3);
    }

    public boolean isTheNumberOfReposEqualTO(String repos){
        try {
            WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(45L));
            return wait.until(ExpectedConditions.textToBePresentInElementLocated(byRepos, repos));
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isTheNumberOfFollowersEqualTO(String followers){
        try {
            WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(45L));
            return wait.until(ExpectedConditions.textToBePresentInElementLocated(byFollowers, followers));
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isTheNumberOfFollowingEqualTO(String following){
        try {
            WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(45L));
            return wait.until(ExpectedConditions.textToBePresentInElementLocated(byFollowing, following));
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isTheNumberOfGistsEqualTO(String gists){
        try {
            WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(45L));
            return wait.until(ExpectedConditions.textToBePresentInElementLocated(byGists, gists));
        } catch (Exception e) {
            return false;
        }
    }
}
