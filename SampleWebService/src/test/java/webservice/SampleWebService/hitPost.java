package webservice.SampleWebService;

import java.io.IOException;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import static java.nio.charset.StandardCharsets.UTF_8;

import org.testng.annotations.Test;



//This class is written write methods associated to Post API 's


public class hitPost {
	

	
	
	 static String post(String url, String content) throws IOException {
	        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
	        conn.setDoOutput(true);
	        conn.setDoInput(true);
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	        conn.setRequestProperty("Content-Length", String.valueOf(content.length()));

	        OutputStream os = conn.getOutputStream();
	        os.write(content.getBytes(UTF_8));
	        InputStream is = conn.getInputStream();
	        String result = convertStreamToString(is);

	        os.flush();
	        os.close();
	        is.close();
	        conn.disconnect();
	        return result;
	    }

    static String convertStreamToString(InputStream is) {
        Scanner s = new Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

}
