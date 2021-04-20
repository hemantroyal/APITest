package webservice.SampleWebService;

	import java.sql.Date;
	import java.sql.Time;

	import org.testng.ITestContext;
	import org.testng.ITestListener;
	import org.testng.ITestResult;
	
	//Listener class for triggering the exevnts based on test outcome to log information associated to Tests results.

	public class ListenerUtility implements ITestListener
	{
		//Invoked after all the tests have run and 
		//all their Configuration methods have been called.
		public void onFinish(ITestContext context)
		{
			System.out.println("onFinish method " + context.getAllTestMethods());
		}
		
		//   Invoked after the test class is instantiated and 
		//before any configuration method is called.
		public void onStart(ITestContext context)
		{
			System.out.println("onStart method " + context.getName());
		}
		
		//ignored for test results
		public void onTestFailedButWithinSuccessPercentage(ITestResult result)
		{
			
		}
		
		
		// Invoked each time a test fails.
		public void onTestFailure(ITestResult result)
		{
				//report
			System.out.println("onFailure method " + result.getMethod());
		}
		
		// Invoked each time a test is skipped.
		public void onTestSkipped(ITestResult result)
		{
			System.out.println("onTestSkipped method " + result.getMethod());
		}
		
		// Invoked each time before a test will be invoked.
		public void onTestStart(ITestResult result)
		{
			System.out.println("onTestStart method " + result.getMethod());
		}
		
		//  Invoked each time a test succeeds.
		public void onTestSuccess(ITestResult result)
		{
			System.out.println("onTestSuccess method " + result.getMethod());
		}
		
	

}
