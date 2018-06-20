package com.porsche;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PorscheSearch {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.porsche.com/usa/modelstart/");
		driver.findElement(By.linkText("718")).click();
		
		WebElement priceFrom = driver.findElement(By.xpath("//*[@id=\"m982120\"]/div[1]/div[2]/div[2]"));
		int prFrom = Integer.parseInt(priceFrom.getText().substring(7, 13).replace(",", ""));
			
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		// Perform the click operation that opens new window
		driver.findElement(By.xpath("//*[@id=\"m982120\"]/div[2]/div/a/span")).click();
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// Perform the actions on new window
		WebElement priceBase = driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[1]/div[2]"));
		int prBase = Integer.parseInt(priceBase.getText().substring(1).replace(",", ""));
		WebElement equipment = driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[2]/div[2]"));
		int prEquipment = Integer.parseInt(equipment.getText().substring(1));
		WebElement delivery = driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[3]/div[2]"));
		int prDelivery = Integer.parseInt(delivery.getText().substring(1).replace(",", ""));
		WebElement total = driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[4]/div[2]"));
		int prTotal = Integer.parseInt(total.getText().substring(1).replace(",", ""));
		
		if (prFrom == prBase && prEquipment == 0 && prBase+prDelivery == prTotal) {
			System.out.println("6. 7. 8. pass");
		} else {
			System.out.println("fail");
		}
		//9
		driver.findElement(By.xpath("//*[@id=\"s_exterieur_x_FJ5\"]/span")).click();
		
		WebElement bluePrice = driver.findElement(By.xpath("//*[@id=\"s_exterieur_x_FJ5\"]"));
		int blPrice  = Integer.parseInt(bluePrice.getAttribute("data-price").substring(1).replace(",", ""));
		equipment = driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[2]/div[2]"));
		prEquipment = Integer.parseInt(equipment.getText().substring(1).replace(",", ""));
		
		//10
		if (blPrice == prEquipment) {
			System.out.println("10. pass");
		} else {
			System.out.println("10. fail");
		}
		
		//11
		total = driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[4]/div[2]"));
		prTotal = Integer.parseInt(total.getText().substring(1).replace(",", ""));
		if (prBase+prEquipment+prDelivery == prTotal) {
			System.out.println("11. pass");
		} else {
			System.out.println("11. fail");
		}
		//12
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,200)", "");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"s_exterieur_x_MXRD\"]/span/span")).click();
		
		WebElement wheelPrice = driver.findElement(By.xpath("//*[@id=\"s_exterieur_x_MXRD\"]"));
		int whPrice  = Integer.parseInt(wheelPrice.getAttribute("data-price").substring(1).replace(",", ""));
		
		equipment = driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[2]/div[2]"));
		prEquipment = Integer.parseInt(equipment.getText().substring(1).replace(",", ""));
		//13
		if (blPrice + whPrice == prEquipment) {
			System.out.println("13. pass");
		} else {
			System.out.println("13. fail");
		}
		//14
		total = driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[4]/div[2]"));
		prTotal = Integer.parseInt(total.getText().substring(1).replace(",", ""));
		if (prBase+prEquipment+prDelivery == prTotal) {
			System.out.println("14. pass");
		} else {
			System.out.println("14. fail");
		}
		//15
		jsx.executeScript("window.scrollBy(0,1000)", "");
		driver.findElement(By.xpath("//*[@id=\"s_interieur_x_PP06\"]")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		//16
		WebElement psSeats = driver.findElement(By.xpath("//*[@id=\"seats_73\"]/div[2]/div[1]/div[3]/div"));
		int psSeatsPrice = Integer.parseInt(psSeats.getText().substring(1).replace(",", ""));
		equipment = driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[2]/div[2]"));
		prEquipment = Integer.parseInt(equipment.getText().substring(1).replace(",", ""));
		if (blPrice + whPrice + psSeatsPrice == prEquipment) {
			System.out.println("16. pass");
		} else {
			System.out.println("16. fail");
		}
		//17
		total = driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[4]/div[2]"));
		prTotal = Integer.parseInt(total.getText().substring(1).replace(",", ""));
		if (prBase+prEquipment+prDelivery == prTotal) {
			System.out.println("17. pass");
		} else {
			System.out.println("17. fail");
		}
		//18
		jsx.executeScript("window.scrollBy(0,1000)", "");
		driver.findElement(By.xpath("//*[@id=\"IIC_wrapper\"]/div")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		//19
		driver.findElement(By.xpath("//*[@id=\"vs_table_IIC_x_PEKH_x_c01_PEKH\"]")).click();
		//20
		WebElement interiorTrim = driver.findElement(By.xpath("//*[@id=\"vs_table_IIC_x_PEKH\"]/div[1]/div[2]/div"));
		int interiorTrimPrice = Integer.parseInt(interiorTrim.getText().substring(1).replace(",", ""));
		equipment = driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[2]/div[2]"));
		prEquipment = Integer.parseInt(equipment.getText().substring(1).replace(",", ""));
		if (blPrice + whPrice + psSeatsPrice + interiorTrimPrice == prEquipment) {
			System.out.println("20. pass");
		} else {
			System.out.println("20. fail");
		}
		//21
		total = driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[4]/div[2]"));
		prTotal = Integer.parseInt(total.getText().substring(1).replace(",", ""));
		if (prBase+prEquipment+prDelivery == prTotal) {
			System.out.println("21. pass");
		} else {
			System.out.println("21. fail");
		}
		//22
		jsx.executeScript("window.scrollBy(0,-300)", "");
		driver.findElement(By.xpath("//*[@id=\"IMG_wrapper\"]/div")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		//23
		driver.findElement(By.xpath("//*[@id=\"vs_table_IMG_x_M250_x_c11_M250\"]")).click();
		jsx.executeScript("window.scrollBy(0,500)", "");
		//24
		driver.findElement(By.xpath("//*[@id=\"vs_table_IMG_x_M450_x_c91_M450\"]")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		//25
		WebElement pdk = driver.findElement(By.xpath("//*[@id=\"vs_table_IMG_x_M250\"]/div[1]/div[2]/div"));
		int pdkPrice = Integer.parseInt(pdk.getText().substring(1).replace(",", ""));
		WebElement pccb = driver.findElement(By.xpath("//*[@id=\"vs_table_IMG_x_M450\"]/div[1]/div[2]/div"));
		int pccbPrice = Integer.parseInt(pccb.getText().substring(1).replace(",", ""));
		equipment = driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[2]/div[2]"));
		prEquipment = Integer.parseInt(equipment.getText().substring(1).replace(",", ""));
		if (blPrice + whPrice + psSeatsPrice + interiorTrimPrice + pdkPrice + pccbPrice == prEquipment) {
			System.out.println("25. pass");
		} else {
			System.out.println("25. fail");
		}
		//26
		total = driver.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[4]/div[2]"));
		prTotal = Integer.parseInt(total.getText().substring(1).replace(",", ""));
		if (prBase+prEquipment+prDelivery == prTotal) {
			System.out.println("26. pass");
		} else {
			System.out.println("26. fail");
		}
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		// Close the new window, if that window no more required
		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);

		// Continue with original browser (first window)
		
		driver.close();
		

		
		
		
		
	}

}
