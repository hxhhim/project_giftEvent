package selenium;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pro.gift.productVO.productVO;

public class SeleniumTest {

	public static void main(String[] args) {
		SeleniumTest selTest = new SeleniumTest();
		selTest.crawl();
	}

	private WebDriver driver;
 
	public static List<productVO> plist = new ArrayList<productVO>();
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "C:\\chromedriver\\chromedriver.exe";

	private String base_url;

	public SeleniumTest() {
		super();

		

	}

	public void crawl() {
		//카테고리별 cssSelector
		String snack = "#contents > div.cateWrap > ul > li.cate03 > span > a > img";
		String icecream = "#contents > div.cateWrap > ul > li.cate04 > span > a > img";
		String food ="#contents > div.cateWrap > ul > li.cate05 > span > a > img";
		String drink ="#contents > div.cateWrap > ul > li.cate06 > span > a > img";
		String goods ="#contents > div.cateWrap > ul > li.cate07 > span > a > img";
		
		
		//리스트에 item selector 넣기
		List<String> itemList = new ArrayList();
		itemList.add(snack);
		itemList.add(icecream);
		itemList.add(food);
		itemList.add(drink);
		itemList.add(goods);
		String[] itemName = {"snack","icecream","food","drink","goods"};
		
		

		for(String item : itemList) {
			int k = 0;
			
		try {
			System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

			driver = new ChromeDriver();
			// 상품안내 페이지주소
			base_url = "http://cu.bgfretail.com/product/index.do?category=product&depth1=1&sf=N";
			driver.get(base_url);

			// 카테고리 버튼 클릭
			WebElement itembtn = driver
					.findElement(By.cssSelector(item));
			itembtn.click();
			
			//카테고리 별 클릭위치 지정
			
			
			// 할인 증정상품 메뉴 click

			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(
					By.cssSelector("#dataTable > div.prodListWrap > ul > li:nth-child(1) > div > a > img")));
			WebElement plusbtn = driver.findElement(By.cssSelector("#setB > span > a"));
			plusbtn.click();

			// 더보기 버튼으로 추가로 메뉴 불러오기

//			WebDriverWait wait4 = new WebDriverWait(driver,30);
//			wait4.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dataTable > div.prodListWrap > ul > li:nth-child(1) > div > a > img")));

			try {
				while (true) {
					Thread.sleep(3000);
					WebElement addbtn = driver
							.findElement(By.cssSelector("#dataTable > div.prodListBtn > div.prodListBtn-w > a"));
					addbtn.click();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("false2");
			
			WebElement dataTable = driver.findElement(By.id("dataTable"));

			// 제품명,가격,행사정보 가져오기
			List<WebElement> prodName = dataTable.findElements(By.className("prodName"));
			List<WebElement> prodPrice = dataTable.findElements(By.className("prodPrice"));
			List<WebElement> event = dataTable.findElements(By.cssSelector("div.prodListWrap>ul>li>ul>li"));
			List<WebElement> imgUrl = dataTable.findElements(By.cssSelector("div.photo>a>img"));

			System.out.println(prodName.size());
			System.out.println(prodPrice.size());
			System.out.println(event.size());
			System.out.println(imgUrl.size());
//			System.out.println(prodName.get(6).getText());
//			System.out.println(prodPrice.get(6).getText());
//			System.out.println(event.get(6).getText());
//			System.out.println(imgUrl.get(6).getAttribute("src"));
			
			for(int i=0; i<prodName.size(); i++) {
				
				productVO pVO = new productVO();
				//fileName과 pcode 추출
				String fileName =imgUrl.get(i).getAttribute("alt");
				String pcode = fileName.substring(0,fileName.length()-4); 
				System.out.println(fileName);
				System.out.println(pcode);
	
				
				//현재날짜,행사달 저장
				SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("yy/MM/dd",Locale.KOREA);
				SimpleDateFormat eventMonthFormat = new SimpleDateFormat("yy/MM",Locale.KOREA);
				Date currentTime = new Date();
				String creationDate = mSimpleDateFormat.format(currentTime);
				String eventMonth = eventMonthFormat.format(currentTime);
				String imageName = imgUrl.get(i).getAttribute("alt");
				
				System.out.println(creationDate);
				System.out.println(eventMonth);
				pVO.setPcode(pcode);
				pVO.setPrice(prodPrice.get(i).getText());
				pVO.setItem(itemName[k]);
				pVO.setImageFileName(imageName);
				pVO.setPname(prodName.get(i).getText());
				pVO.setEvent(event.get(i).getText());
				pVO.setBrand("CU");
				pVO.setCreationDate(creationDate);
				pVO.setEventMonth(eventMonth);
//				System.out.println(pVO);
//				System.out.println(i);
				plist.add(pVO);
				
			
				//카테고리 전체 이미지 저장
			
			}
			k++;
			for (int j = 0; j < prodName.size(); j++) {
				String imageName = imgUrl.get(j).getAttribute("alt");
				String url = imgUrl.get(j).getAttribute("src");
				URL pUrl = new URL(url);
				BufferedImage jpg = ImageIO.read(pUrl);
				File file = new File("C:\\testimg\\" + imageName);
				ImageIO.write(jpg, "jpg", file);
			}
//			
//			//이미지파일명 가져오기
//			String imageName = imgUrl.get(6).getAttribute("alt");
//			//이미지 url가져오기
//			String url = imgUrl.get(6).getAttribute("src");
//
//			URL pUrl = new URL(url);
//			BufferedImage jpg = ImageIO.read(pUrl);
//			//이미지 저장경로 지정
//			File file = new File("C:\\testimg\\"+imageName);
//			ImageIO.write(jpg, "jpg", file);
//

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
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
			
		
	 
	}
		int count=0;
		for(productVO pVO:plist) {
			System.out.println(pVO);
			count++;
		}
		System.out.println(count);
	}
	
}
