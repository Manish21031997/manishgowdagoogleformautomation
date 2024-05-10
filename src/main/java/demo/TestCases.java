package demo;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01() throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        driver.get("https://forms.gle/wjPkzeSEk1CM7KgGA");
        Thread.sleep(2000);

        WebElement name= driver.findElement(By.xpath("//input[@aria-describedby='i2 i3']"));
        name.sendKeys("Manishgowda");
        System.out.println("sent1");
        Thread.sleep(2000);

        long epochTime=Instant.now().getEpochSecond();
        String message= "I want to be the best QA Engineer!" + epochTime;
        System.out.println(message);
        WebElement automation= driver.findElement(By.xpath("//textarea[@aria-label='Your answer']"));
        automation.sendKeys(message);
        System.out.println("sent2");
        Thread.sleep(2000);

        WebElement radiobtn= driver.findElement(By.xpath("(//div[@class='AB7Lab Id5V1'])[3]"));
        radiobtn.click();
        System.out.println("clicked");
        Thread.sleep(2000);


        // List<WebElement> buttons= driver.findElements(By.xpath("//div[@class='uHMk6b fsHoPb']"));
        // for(int i=0; i<Math.min(2, buttons.size()); i++){
        //     WebElement button=buttons.get(i);
        //     button.click();

            WebElement java= driver.findElement(By.xpath("(//div[@class='uHMk6b fsHoPb'])[1]"));
             java.click();
             Thread.sleep(2000);
             

            WebElement selenium= driver.findElement(By.xpath("(//div[@class='uHMk6b fsHoPb'])[2]"));
            selenium.click();
            Thread.sleep(2000);

            WebElement testng= driver.findElement(By.xpath("(//div[@class='uHMk6b fsHoPb'])[4]"));
            testng.click();
            Thread.sleep(2000);

        // for(WebElement btns: buttons){
        //     String radiobtns= btns.getAttribute("id");
        //     System.out.println(radiobtns);
        //     if(btns.equals("Java") || btns.equals("Selenium") || btns.equals("TestNG")){
        //         btns.click();
        //     }
        // }
            // System.out.println("clicked java and selenium");
        //  Thread.sleep(2000);

        WebElement choose= driver.findElement(By.xpath("(//span[@class='vRMGwf oJeWuf'])[1]"));
        choose.click();
        Thread.sleep(2000);


        WebElement options= driver.findElement(By.xpath("(//span[contains(text(),'Mr')])[3]"));
        options.click();
        Thread.sleep(2000);
        
        LocalDate currentdate=LocalDate.now();
        LocalDate sevendaysago=currentdate.minusDays(7);
        DateTimeFormatter formater= DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String datetoenter=formater.format(sevendaysago);
        WebElement date= driver.findElement(By.xpath("//input[@type='date']"));
        date.sendKeys(datetoenter);
        Thread.sleep(2000);

        LocalTime currenttime=LocalTime.now();
        DateTimeFormatter timeformater= DateTimeFormatter.ofPattern("hh:mm a");
        String timetoenter=currenttime.format(timeformater);
        WebElement hour= driver.findElement(By.xpath("(//input[@jsname='YPqjbf'])[3]"));
        hour.sendKeys(timetoenter);
        WebElement min= driver.findElement(By.xpath("(//input[@jsname='YPqjbf'])[4]"));
         min.sendKeys("0");
        Thread.sleep(2000);
   
        driver.executeScript("window.open('https://www.amazon.in','_blank');");
        Thread.sleep(3000);
        Set<String>windowids= driver.getWindowHandles();
        List<String> windowidslist= new ArrayList<>(windowids);
        String parentid= windowidslist.get(0);
        String childid= windowidslist.get(1);
        System.out.println(parentid);
        System.out.println(childid);
        driver.switchTo().window(parentid);
        Thread.sleep(3000);
        // WebElement name1= driver.findElement(By.xpath("//input[@aria-describedby='i2 i3']"));
        // name1.clear();
        // name1.sendKeys("Manishgowda");
   
        // driver.switchTo().window(childid);
        // Thread.sleep(3000);
        // try{
        // Alert alert= driver.switchTo().alert();
        // alert.dismiss();
        // }catch(NoAlertPresentException e){

        // }
        // Thread.sleep(2000);
         WebElement submit= driver.findElement(By.xpath(" (//span[@class='NPEfkd RveJvd snByac'])[1]"));
        submit.click();
        Thread.sleep(3000);

        WebElement text= driver.findElement(By.xpath("//div[@class='vHW8K']"));
        String textmessage= text.getText();
        System.out.println(textmessage);
        
        
        System.out.println("end Test case: testCase02");
    }
}


