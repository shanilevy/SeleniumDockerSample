package sample;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DockerBasic {

    @Test(enabled = true)
    public void googleTest1() throws Throwable{
        //WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver","/app/bin/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        System.setProperty("webdriver.chrome.args", "--disable-logging");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--disable-gpu"); // applicable to windows os only
        options.addArguments("window-size=1024,768"); // Bypass OS security model
        //options.setCapability("chrome.verbose", false); //disable logging
        WebDriver driver = new ChromeDriver(options);
        /* WebDriver driver = new ChromeDriver(); */
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.name("q")).sendKeys("Stop Watch");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("(//span[contains(@class,'act-tim-resume-lbl')])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[contains(@class,'act-tim-pause-lbl')])[1]")).click();
        String text = driver.findElement(By.xpath("(//div[@class='act-tim-txt-cnt'])[1]")).getText();
        System.out.println(text);
        Thread.sleep(2000);
        driver.quit();
    }

    @Test(enabled=true)
    public void googleTest2() throws Throwable{
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxDockerOptions = new FirefoxOptions();
        System.setProperty("webdriver.gecko.driver","/app/bin/geckodriver");
        firefoxDockerOptions.addArguments("--headless");
        firefoxDockerOptions.addArguments("--no-sandbox");
        System.setProperty("webdriver.gecko.args", "--disable-logging");
        System.setProperty("webdriver.gecko.silentOutput", "true");
        firefoxDockerOptions.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        firefoxDockerOptions.addArguments("disable-infobars"); // disabling infobars
        firefoxDockerOptions.addArguments("--disable-extensions"); // disabling extensions
        firefoxDockerOptions.addArguments("--disable-gpu"); // applicable to windows os only
        firefoxDockerOptions.addArguments("--width=1920"); // Bypass OS security model
        firefoxDockerOptions.addArguments("--height=1080");
        FirefoxDriver driver = new FirefoxDriver(firefoxDockerOptions);
        //WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.name("q")).sendKeys("Stop Watch");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("(//span[contains(@class,'act-tim-resume-lbl')])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[contains(@class,'act-tim-pause-lbl')])[1]")).click();
        String text = driver.findElement(By.xpath("(//div[@class='act-tim-txt-cnt'])[1]")).getText();
        System.out.println(text);
        Thread.sleep(2000);
        driver.quit();
    }
}
