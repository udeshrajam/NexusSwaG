package assessment.web.ui.pages;

import assessment.web.ui.utility.Constants;
import assessment.web.ui.utility.testBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LandingPage extends testBase {

    By dropDrown_sort = By.xpath("//*[@id='header_container']/div[2]/div/span/select");
    By btn_addToCart = By.cssSelector(".btn.btn_primary.btn_small.btn_inventory");
    By item_Card = By.xpath("./ancestor::div[@class='inventory_item']");

    By productGrid = By.className("inventory_list");
    By lbl_productName = By.className("inventory_item_name");
    By lbl_productPrice = By.className("inventory_item_price");

    List<String> productNames = new ArrayList<>();
    List<Double> productValue = new ArrayList<>();
    List<String> itemNameList;
    List<Double> itemPrice;
    List<String> expectedOrder;
    List<Double> expectedPriceOrder;

    public LandingPage() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TimeOut));
    }

    public void dropDownSort(String Sort) {
        element = wait.until(ExpectedConditions.elementToBeClickable(dropDrown_sort));
        Select select = new Select(element);
        value = Sort;
        switch (Sort) {
            case "Name (A to Z)" -> Sort = "az";
            case "Name (Z to A)" -> Sort = "za";
            case "Price (low to high)" -> Sort = "lohi";
            case "Price (high to low)" -> Sort = "hilo";
        }
        select.selectByValue(Sort);
    }

    public void addProductsToCart() {
        List<WebElement> addToCartButtons = driver.findElements(btn_addToCart);
        List<String> failedItemsNames = new ArrayList<>();

        for (WebElement button : addToCartButtons) {
            button.click();
        }

        List<WebElement> addButtons = driver.findElements(btn_addToCart);
        for (WebElement addToCartButton : addButtons) {
            WebElement parentElement = addToCartButton.findElement(item_Card);
            WebElement productNameElement = parentElement.findElement(lbl_productName);

            String productName = productNameElement.getText();
            failedItemsNames.add(productName);
        }

        if (failedItemsNames.size() > 0) {
            System.out.println("The following items failed to get added to the cart:");
            for (String itemName : failedItemsNames) {
                System.out.println(itemName);
            }
        } else {
            System.out.println("All items were successfully added to the cart.");
        }
    }

    public void sortAndVerifyProductList() {

        WebElement productListElement = driver.findElement(productGrid);

        List<WebElement> productItems = productListElement.findElements(lbl_productName);
        List<WebElement> productItemsPrice = productListElement.findElements(lbl_productPrice);

        if (value.equals("Name (A to Z)") || value.equals("Name (Z to A)")) {
            for (WebElement productItem : productItems) {
                productNames.add(productItem.getText());
            }
            itemNameList = new ArrayList<>(productNames);
            System.out.println("UI Product List is -> " + itemNameList);
        } else {
            for (WebElement productPrice : productItemsPrice) {
                productValue.add(Double.valueOf(productPrice.getText().replace("$", "")));
            }
            itemPrice = new ArrayList<>(productValue);
            System.out.println("UI Product List Price is -> " + itemPrice);
        }

        switch (value) {
            case "Name (A to Z)" -> {
                expectedOrder = new ArrayList<>(productNames);
                Collections.sort(expectedOrder);
                System.out.println("Expected -> " + expectedOrder);
                Assert.assertEquals(itemNameList, expectedOrder);
            }
            case "Name (Z to A)" -> {
                expectedOrder = new ArrayList<>(productNames);
                Collections.sort(expectedOrder);
                Collections.reverse(expectedOrder);
                System.out.println("Expected -> " + expectedOrder);
                Assert.assertEquals(itemNameList, expectedOrder);
            }
            case "Price (low to high)" -> {
                expectedPriceOrder = new ArrayList<>(productValue);
                Collections.sort(expectedPriceOrder);
                System.out.println("Expected -> " + expectedPriceOrder);
                Assert.assertEquals(itemPrice, expectedPriceOrder);
            }
            case "Price (high to low)" -> {
                expectedPriceOrder = new ArrayList<>(productValue);
                Collections.sort(expectedPriceOrder);
                Collections.reverse(expectedPriceOrder);
                System.out.println("Expected -> " + expectedPriceOrder);
                Assert.assertEquals(itemPrice, expectedPriceOrder);
            }
        }

    }

}
