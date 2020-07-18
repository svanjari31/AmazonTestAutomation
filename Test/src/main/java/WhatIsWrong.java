import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WhatIsWrong {
 

	@FindBy(xpath = "//span[contains(@class,'a-size-base' and @dir ='auto')]")
	WebElement ratingForWashingMachine;
	
	
}


