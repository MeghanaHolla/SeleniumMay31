package kdf;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.GenericMethods;

public class Application {
	
	@Test
	
	public void verifyInvalidLogin() throws IOException {
		String[][] data = GenericMethods.getData("D:\\May2_2020\\TestData.xlsx", "Sheet2");
		
		for(int i = 1;i<data.length;i++) {
			switch(data[i][3]) {
			//Making code changes after R1.1
			case "openBrowser":
				Methods.openBrowser();
				break;
			case "maxBrowser":
				Methods.maximizeBrowserWindow();
				break;
			case "impWait":
				Methods.implementImpWait();
				break;
			case "navigateToAUT":
				Methods.navigateToApp(data[i][6]);
				break;
			case "enterUserID":
				Methods.enteruserID(data[i][4],data[i][5], data[i][6]);
				break;
			case "enterPassword":
				Methods.enterPassword(data[i][4],data[i][5], data[i][6]);
				break;
			case "clickSignIn":
				Methods.clicButton(data[i][4],data[i][5]);
				break;
			case "verifyErrmsg":
				String actualMsg = Methods.getErrMsg(data[i][5]);
				String expectedMsg = data[i][6];
				Assert.assertEquals(actualMsg, expectedMsg);
				break;
			case "closeAUT":
				Methods.closeApplication();
				break;
			}
		}
	}
	

}
