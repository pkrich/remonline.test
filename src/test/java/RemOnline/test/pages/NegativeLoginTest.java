package RemOnline.test.pages;

import org.testng.annotations.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;

public class NegativeLoginTest extends RemOnline.test.pages.TestBase {

    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Test
    public void testRem() throws Exception {
        openPage();
        try {
            assertTrue(isElementPresent(By.xpath("//li[5]/span")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.xpath("//li[5]/span")).click();
//		driver.findElement(By.id("l-auth-login")).clear();
        driver.findElement(By.id("l-auth-login")).sendKeys("pkrich");
//		driver.findElement(By.id("l-auth-pass")).clear();
        driver.findElement(By.id("l-auth-pass")).sendKeys("43210");
        driver.findElement(By.xpath("html/body/form/div[3]/button")).click();
        for (int second = 0;; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            try {
                if (isElementPresent(By
                        .cssSelector("h2.h-page-title.h-page-title_type_inline"))) {
                    break;
                }
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

        assertEquals(
                "Заказы",
                driver.findElement(
                By.cssSelector("h2.h-page-title.h-page-title_type_inline"))
                .getText());
        try {
            assertTrue(isElementPresent(By
                    .xpath("//div[@id='container']/div/div[3]/button")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        for (int second = 0;; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            try {
                if (isElementPresent(By.cssSelector("span.text-label"))) {
                    break;
                }
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

        driver.findElement(By.linkText("Выйти")).click();
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
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
}