package webservice.SampleWebService;

import java.io.*;
import java.net.*;
import java.util.Scanner;

// This class is written write methods associated to Get API 's
public class GetTest {
	


	
	static String get(String url) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        conn.setDoInput(true);
        conn.setRequestMethod("GET");

        InputStream is = conn.getInputStream();
        String result = convertStreamToString(is);

        is.close();
        conn.disconnect();
        return result;
    }
	
    static String convertStreamToString(InputStream is) {
        Scanner s = new Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
