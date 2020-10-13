package nutriscore.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import nutriscore.Nutriscore;
import nutriscore.dto.ParametersDto;
import nutriscore.dto.RequestDto;

/**
 * Action listener for the timer.
 */
public class TimerActionListener implements ActionListener {

	/**
	 * Random API constants.
	 */
	private static final String API_URL = "https://api.random.org/json-rpc/2/invoke";
	private static final String API_KEY = "d2469a85-1999-41ea-ac90-fac5ddd97c96";
	private static final String API_METHOD = "generateIntegers";
	private static final String API_VERSION = "2.0";
	
	private HttpClient httpClient;
	private HttpPost request;
	private ObjectMapper objectMapper;
	
	public TimerActionListener() throws JsonProcessingException, UnsupportedEncodingException {
		objectMapper = new ObjectMapper();
		ParametersDto parameters = new ParametersDto(TimerActionListener.API_KEY, 1, 0, 4);
		RequestDto requestDto = new RequestDto(1, TimerActionListener.API_VERSION, TimerActionListener.API_METHOD, parameters);
		
		httpClient = HttpClientBuilder.create().build();
		request = new HttpPost(TimerActionListener.API_URL);
		String json = objectMapper.writeValueAsString(requestDto);
	    StringEntity entity = new StringEntity(json);
	    request.setEntity(entity);
	    request.setHeader("Accept", "application/json");
	    request.setHeader("Content-type", "application/json");
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			//Get random number and change slider value
			int value = requestRandomNumber();
    		Nutriscore.getInstance().getSlider().setValue(value);
    		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Execute request to get the random number.
	 * @return the random number value
	 * @throws Exception if the request fails
	 */
	public int requestRandomNumber() throws Exception {
		
		//Execute request
		HttpResponse response = httpClient.execute(request);
		if (response.getStatusLine().getStatusCode() != 200) {
			throw new Exception();
		}
		
		//Read response and return the random number value
		JsonNode jsonNode = objectMapper.readTree(EntityUtils.toString(response.getEntity()));
		int value = jsonNode.get("result").get("random").get("data").elements().next().asInt();
		System.out.println("Value = " + value);
		return value;
		
	}

}
