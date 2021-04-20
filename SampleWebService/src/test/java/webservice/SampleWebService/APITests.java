package webservice.SampleWebService;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



//This class is a TestNG class file used to create API Tests.
// Added assertions to verify the test outcome.

@Listeners(webservice.SampleWebService.ListenerUtility.class)
public class APITests {
	
	@SuppressWarnings("deprecation")
	@Test
	public void hitGet() throws IOException
	{
		String ActualResult = "String here";		
		Assert.assertEquals(GetTest.get("https://rapidapi.com/api-sports/api/api-football?endpoint=apiendpoint_0e6d2450-e2f3-4bef-87d7-54eb20907568"),ActualResult);
		
	}
	
	@Test
	public void hitPost() throws IOException
	{
		String ActualResult = "String here";
		Assert.assertEquals(hitPost.post("http://example.com/", "foo=bar&baz=moo"),ActualResult);
		
	}
	
	
}
