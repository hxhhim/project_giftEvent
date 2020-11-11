package selenium;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
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
			
			//제품명,가격,행사정보 가져오기
			List<WebElement> prodName = driver.findElements(By.className("prodName"));
			List<WebElement> prodPrice = driver.findElements(By.className("prodPrice"));
			List<WebElement> event = driver.findElements(By.cssSelector("div.prodListWrap>ul>li>ul>li"));
			List<WebElement> imgUrl = driver.findElements(By.cssSelector("div.photo>a>img"));
			
			System.out.println(prodName.get(6).getText());
			System.out.println(prodPrice.get(6).getText());
			System.out.println(event.get(6).getText());
			System.out.println(imgUrl.get(6).getAttribute("src"));
			System.out.println(imgUrl.get(6).getAttribute("alt"));

			//제품이미지 가져오기, 이미지파일명 가져오기
			//이미지 url가져오기
			
			

//			String nowUrl = driver.getCurrentUrl();
			
//			try {
//				Document doc = Jsoup.connect(nowUrl).get();
//				Elements contents = doc.select(".prodName");
//				String text = contents.text();
//				System.out.println(text);
//			}catch (IOException e) {
//				e.printStackTrace();
//			}
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
