package commons;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryTestFailed implements IRetryAnalyzer{
	private int retryCount =0;
	private int maxRetryCount =3;
	public boolean retry(ITestResult result) {
		if(retryCount < maxRetryCount ) {
			System.out.println("Retry test name: " + result.getName() + "with : " + (retryCount+1) + "times");
			retryCount ++;
			return true;
		}
		return false;
	}
}
