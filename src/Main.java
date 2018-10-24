import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {

	public static void main(String[] args) throws IOException {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nicole\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String filename = "usernames." + new Date().getMonth() + "." + new Date().getDate() + "." + new Date().getYear() + ".txt";
		System.out.println(filename);
    	
        String baseUrl = "https://secure.runescape.com/m=hiscore_oldschool/overall.ws?table=0&page=";
        int pages = 1000;
        
        File file = new File(filename);
		PrintWriter pw = new PrintWriter(file);
        
        for (int page = 1; page <= pages; page++) {
        	driver.get(baseUrl + page);
        	
        	new WebDriverWait(driver, 15000).until(
        	          webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        	
        	for (int i = 2; i <= 26; i++) {
            	WebElement element = driver.findElement(By.cssSelector("#contentHiscores > table > tbody > tr:nth-child(" + i + ") > td.left > a"));
            	pw.print(element.getText().replace(" ", "_") + " ");
            }
        }
        
        pw.close();
        
        driver.close();
       
    }

}
