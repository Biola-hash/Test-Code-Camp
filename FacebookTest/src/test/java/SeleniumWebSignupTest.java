import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class SeleniumWebSignupTest {
    //import selenium webdriver
    private WebDriver driver;

@BeforeTest
public void start() throws InterruptedException {
    //1.locate where the chromedriver
    System.setProperty("webdriver.chrome.driver", "resources/chromedriver-win64/chromedriver.exe");
    //Open Chrome browser
    driver = new ChromeDriver();
    //2. Input Selenium Demo Page URl (https://selenium-blog.herokuapp.com)
    driver.get("https://selenium-blog.herokuapp.com/");
    // Test1. Verify the user input the right url and his on the right webpage
    if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/"))
        //pass
        System.out.println("Correct webpage");
    else
        System.out.println("Wrong webpage");
    //3.Wait globally for full loading
    Thread.sleep(5000);
    //4. Maximize the browser
    driver.manage().window().maximize();
    Thread.sleep(5000);
}

@Test(priority = 0)
public void Signup () throws InterruptedException {
    //5. Click on Signup button to open the Signup page
    driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
    //Test2. Verify that when user clicks on the signup button, the user is directed to the signup page
    String expectedUrl = "https://selenium-blog.herokuapp.com/signup";
    String actualUrl = driver.getCurrentUrl();
    if (actualUrl.contains(expectedUrl))
        //pass
        System.out.println("Current Url");
    else
        System.out.println("Wrong Url");
    Thread.sleep(5000);
}

@Test (priority = 1)
public void PositiveSignup() throws InterruptedException {
    //6. Input your username on the username field
    driver.findElement(By.id("user_username")).sendKeys("boseabqw241");
    //7. Locate the email address field and Input an email address on the email field
    driver.findElement(By.id("user_email")).sendKeys("boseabqw2412@gmail.com");
    //8. Locate the password field and Input your password on the username
    driver.findElement(By.id("user_password")).sendKeys("admin");
    //9. Click on the signup button
    driver.findElement(By.id("submit")).click();
    //Test3. Verify that user is successfully signed up when valid details are inputted.
    if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/users.3907"))
        //pass
        System.out.println("Correct webpage");
    else
        System.out.println("Wrong webpage");
    Thread.sleep(5000);
}

@Test (priority = 2)
public void User1item() throws InterruptedException {
    //9. Click on User1 item on the list page driver
    driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
    //Test4. Verify that User1 item is present on the item list page.
    String expectedPageTitle = "Alphablog";
    String actualPageTitle = driver.getTitle();
    if (actualPageTitle.contains(expectedPageTitle))
        //pass
        System.out.println("Correct User1PageTitle");
    else
        System.out.println("Wrong User1PageTitle");
    Thread.sleep(5000);
}

@Test (priority = 3)
public void searchforanitem() throws InterruptedException {
    //10.search for an item (creator of selenium) and confirm it is present
    driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/a")).click();
    //Test5. Verify that the item searched for on the User1 page is present.
    String expectedPageUrl = "https://selenium-blog.herokuapp.com/users/1";
    String actualPageUrl = driver.getCurrentUrl();
    if (actualPageUrl.contains(expectedPageUrl))
        //pass
        System.out.println("Correct Url");
    else
        System.out.println("Wrong Url");
    Thread.sleep(5000);
}

@Test (priority = 4)
public void logout() throws InterruptedException {
    //11.click on logout
    driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
    //Test6. Verify that when the user logout, he/she is directed back to the home page
    String expectedPageUrl = "https://selenium-blog.herokuapp.com/";
    String actualPageUrl = driver.getCurrentUrl();
    if (actualPageUrl.contains(expectedPageUrl))
        //pass
        System.out.println("Correct Url");
    else
        System.out.println("Wrong Url");

    Thread.sleep(5000);
}

@Test (priority = 5)
public void NegativeSignup() throws InterruptedException {
        //1. Click on Signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        //6. Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("bos");
        //7. Locate the email address field and Input an email address on the email field
        driver.findElement(By.id("user_email")).sendKeys("");
        //8. Locate the password field and Input your password on the username
        driver.findElement(By.id("user_password")).sendKeys("");
        //9. Click on the signup button
        driver.findElement(By.id("submit")).click();
        //Test7. Verify that user cannot signup with username less than 3 characters
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/signup"))
            //pass
            System.out.println("Correct webpage");
        else
            System.out.println("Wrong webpage");
        Thread.sleep(5000);
}

@Test (priority = 6)
public void NegativeSignup1() throws InterruptedException {
        //1. Click on Signup button to open the Signup page
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        //6. Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("bos");
        //7. Locate the email address field and Input an email address on the email field
        driver.findElement(By.id("user_email")).sendKeys("gmail.com");
        //8. Locate the password field and Input your password on the username
        driver.findElement(By.id("user_password")).sendKeys("");
        //9. Click on the signup button
        driver.findElement(By.id("submit")).click();
        //Test8. Verify user cannot signup with invalid email address
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/signup"))
            //pass
            System.out.println("Correct webpage");
        else
            System.out.println("Wrong webpage");
        Thread.sleep(5000);
}

@Test (priority = 7)
public void NegativeSignup2() throws InterruptedException {
        //1. Click on Signup button to open the Signup page
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        //6. Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("bos");
        //7. Locate the email address field and Input an email address on the email field
        driver.findElement(By.id("user_email")).sendKeys("gmail.com");
        //8. Locate the password field and Input your password on the username
        driver.findElement(By.id("user_password")).sendKeys("");
        //9. Click on the signup button
        driver.findElement(By.id("submit")).click();
        //Test9. Verify user cannot login with password less than or equal to one character
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/signup"))
            //pass
            System.out.println("Correct webpage");
        else
            System.out.println("Wrong webpage");
        Thread.sleep(5000);
}

@Test (priority = 8)
public void NegativeSignup3() throws InterruptedException {
        //1. Click on Signup button to open the Signup page
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        //6. Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("");
        //7. Locate the email address field and Input an email address on the email field
        driver.findElement(By.id("user_email")).sendKeys("");
        //8. Locate the password field and Input your password on the username
        driver.findElement(By.id("user_password")).sendKeys("");
        //9. Click on the signup button
        driver.findElement(By.id("submit")).click();
        //Test10. Verify user cannot signup with either/all of the fields blank
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/signup"))
            //pass
            System.out.println("Correct webpage");
        else
            System.out.println("Wrong webpage");
        Thread.sleep(5000);
    }

@AfterTest
public void closeBrowser() {
    //12. Quit Browser
    driver.quit();
}





}

