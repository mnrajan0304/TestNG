package RetryLogicDemo;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyse implements IRetryAnalyzer{

	int a= 1;
	int b= 3;
	
	@Override
	public boolean retry(ITestResult result) {
		if (a<b) {
			a++;
			return true;
		}
		else
		return false;
	}

}
