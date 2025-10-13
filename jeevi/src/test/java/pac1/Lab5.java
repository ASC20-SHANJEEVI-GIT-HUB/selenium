package pac1;
 
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class Lab5 {
 
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?");
		System.out.println("The title is:" +driver.getTitle());
		driver.manage().window().maximize();
		String title = driver.getTitle();
        System.out.println("Page Title: " + title);
        if (title.equals("Your Store")){
            System.out.println("Title is matched");
        } else{
            System.out.println("Title is not matched");
        }
		
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();
        
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
        String warning =driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
        System.out.println("Warning message is:" +warning);
        if (warning.equals("You must agree to the Privacy Policy!")){
        	System.out.println("warning is matched");
        } else {
        	System.out.println("warning is not matched");
        }
        
        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.sendKeys("Shanjeevi");
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
        String fnameError = driver.findElement(By.cssSelector("div.text-danger")).getText();
        if (fnameError.contains("First Name must be between 1 and 32 characters!")) {
            System.out.println("First name length validation works");
        }
        WebElement firstName1 = driver.findElement(By.id("input-firstname"));
        firstName1.click();
        firstName1.sendKeys(Keys.CONTROL + "a");
        firstName1.sendKeys(Keys.BACK_SPACE);
        firstName1.clear();
        firstName1.sendKeys("Shanjeevi");
        
        WebElement lastName = driver.findElement(By.id("input-lastname"));
        lastName.sendKeys("M");
        
        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys("abc@gmail.com");
        
        WebElement telephone = driver.findElement(By.id("input-telephone"));
        telephone.sendKeys("9874555062");
        
        driver.findElement(By.id("input-password")).sendKeys("Shan5433");
        driver.findElement(By.id("input-confirm")).sendKeys("Shan5433");
        
        driver.findElement(By.xpath("//input[@name='newsletter' and @value='1']")).click();
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
        
        String successMsg = driver.findElement(By.tagName("h1")).getText();
        if (successMsg.contains("Your Account Has Been Created!")) {
            System.out.println("Account created successfully!");
        } else {
            System.out.println("Account creation failed");
        }
        
        driver.findElement(By.cssSelector("a.btn.btn-primary")).click();
        driver.findElement(By.linkText("Order History")).click();
        System.out.println("Navigated to Order History");

	}
 
}
 