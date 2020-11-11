package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTest {

	public static void main(String[] args) {
		SeleniumTest selTest = new SeleniumTest();
		selTest.crawl();
	}
	private WebDriver driver;
	
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "C:\\chromedriver\\chromedriver.exe";
	
	private String base_url;
	
	public SeleniumTest() {
		super();
		
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		
		driver = new ChromeDriver();
		//상품안내 페이지주소
		base_url = "http://cu.bgfretail.com/product/index.do?category=product&depth1=1&sf=N";
		
		
	}
	
	public void crawl() {
		try {
			driver.get(base_url);

			//음료 카테고리 버튼 selector
			WebElement drinkbtn = driver.findElement(By.cssSelector("#contents > div.cateWrap > ul > li.cate06 > span > a > img"));
			drinkbtn.click();
			
						
			//할인 증정상품 메뉴 click
		
			
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dataTable > div.prodListWrap > ul > li:nth-child(1) > div > a > img")));
			WebElement plusbtn = driver.findElement(By.cssSelector("#setB > span > a"));
			plusbtn.click();
			
			//더보기 버튼으로 추가로 메뉴 불러오기
					
//			WebDriverWait wait4 = new WebDriverWait(driver,30);
//			wait4.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dataTable > div.prodListWrap > ul > li:nth-child(1) > div > a > img")));
			
			try {
				while(true) {
					Thread.sleep(3000);
					WebElement addbtn = driver.findElement(By.cssSelector("#dataTable > div.prodListBtn > div.prodListBtn-w > a"));						
					addbtn.click();
					}
			}catch(Exception e){
				e.printStackTrace();
			}
			System.out.println("false2");
						
			
////			WebElement plus = 
////			
////			String text = driver.getPageSource();
//			
//			System.out.println(text);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
//			driver.close();
		}
	}
}
