package api;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class API_HTTP_Req {

	public static void main(String[] args) {
		// String result;
		try {
			String result = sendPost("https://gorest.co.in/public/v2/users");
			System.out.println(result);
			//String accessToken = "your_access_token_here";
		} catch (IOException e) {

			e.printStackTrace();
		}
		// System.out.println(result);

	}

	private static String sendPost(String url) throws IOException {

		String result = "";
		String accessToken = "cb62fbf9be072b1893f3112a4293ca4b035a27d8af94e2b97a22027bac4f326c";
		HttpPost post = new HttpPost(url);

		List<NameValuePair> urlParams = new ArrayList();
		urlParams.add(new BasicNameValuePair("name", "sambha00"));
		urlParams.add(new BasicNameValuePair("email", "sambha00@gm.com"));
		urlParams.add(new BasicNameValuePair("gender", "male"));
		urlParams.add(new BasicNameValuePair("status", "inactive"));

		post.setEntity(new UrlEncodedFormEntity(urlParams));
		post.setHeader("Authorization", "Bearer " + accessToken);


		try (CloseableHttpClient httpClient = HttpClients.createDefault();
				CloseableHttpResponse response = httpClient.execute(post)) {
			result = EntityUtils.toString(response.getEntity());
		}

		return result;
	}

}
