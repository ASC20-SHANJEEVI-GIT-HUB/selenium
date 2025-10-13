package pac1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC002_FindElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com");	        
		List<WebElement> flipkartlinks=driver.findElements(By.tagName("a"));
		System.out.println("Total no of links:"+flipkartlinks.size());
		for(WebElement link: flipkartlinks)
		{
			System.out.println("link is:"+link.getText());

		}
		

	}

}
