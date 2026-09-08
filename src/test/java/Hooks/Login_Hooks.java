package Hooks;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.io.FileHandler;

import Base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Login_Hooks extends BaseClass {
	
	
	@Before ("@login")
	public void start_browser() throws InterruptedException {
		EdgeOptions option = new EdgeOptions();
		option.addArguments("--start-maximized");
		
		
		setDriver(new EdgeDriver(option));
		getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	
	@After
	public void close_session(Scenario scenario ) throws IOException {
		if(scenario.isFailed())
		{
			TakesScreenshot ts = (TakesScreenshot) getDriver();
			File source = ts.getScreenshotAs(OutputType.FILE);
			String scenario_name = scenario.getName().replace(" ", "_");
			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			String file_name = scenario_name + "_" + timeStamp + ".png";
			File file_destination = new File("target/Screenshots/"+file_name);
			if (!file_destination.exists()) {
				file_destination.mkdirs();
			}
			FileHandler.copy(source,file_destination);
			
		}
		getDriver().quit();
		unload();
	}
}
