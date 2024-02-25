import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class ToyStorePageText {
    public static void main(String[] args) {
        // Set the path to chromedriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\laksh\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the URL
        driver.get("https://qatoystore.ccbp.tech/");

        // Click the product element
        WebElement productElement = driver.findElement(By.className("element-selector-class"));
        productElement.click();

        // Get handles of all windows
        Set<String> windowHandles = driver.getWindowHandles();

        // Switch to the child window
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
        }

        // Print the product name
        WebElement productNameElement = driver.findElement(By.className("product-name-class"));
        System.out.println("Product Name: " + productNameElement.getText());

        // Print the product price
        WebElement productPriceElement = driver.findElement(By.className("product-price-class"));
        System.out.println("Product Price: " + productPriceElement.getText());

        // Print the product description
        WebElement productDescriptionElement = driver.findElement(By.className("product-description-class"));
        System.out.println("Product Description: " + productDescriptionElement.getText());

        // Close the child window
        driver.close();

        // Quit the parent window
        driver.quit();
    }
}