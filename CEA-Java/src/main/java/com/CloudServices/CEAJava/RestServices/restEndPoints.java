
package com.CloudServices.CEAJava.RestServices;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class restEndPoints {
	
	@Value("${authToken}")
	String auth;
	
	@RequestMapping(value="/listDirectory", method = RequestMethod.GET)
	public String list(
			@RequestParam(value = "input", required = true) String in
			) {
		String folderContents;
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", auth);
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> entity = new HttpEntity<>("options",headers);;
		ResponseEntity<String> response;
		
		try{
			Long.parseLong(in);
			folderContents = "https://staging.cloud-elements.com/"+
                "elements/api-v2/folders/" +in+ "/contents";
		}
		catch(NumberFormatException e){
			folderContents = "https://staging.cloud-elements.com/"+
                    "elements/api-v2/folders/contents?path="+in;
		}
		
		System.out.println(folderContents);
		response = restTemplate.exchange(folderContents, 
										HttpMethod.GET, entity, String.class);
		
		return response.getBody();
	}
	
	@RequestMapping(value="/downloadFile", method = RequestMethod.GET)
	public String down(
			@RequestParam(value = "input", required = true) String in
			) {
		String downloadFileURL;
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", auth);
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> entity = new HttpEntity<>("options",headers);;
		ResponseEntity<String> response;
		try {
			Long.parseLong(in);
			downloadFileURL = "https://staging.cloud-elements.com/"+
			        "elements/api-v2/files/" + in +
			        "/links?access-level=collaborators";
		}
		catch(NumberFormatException e) {
			downloadFileURL = "https://staging.cloud-elements.com/"+
                    "elements/api-v2/files/links?path=" + in +
                    "&access-level=collaborators";
		}
		
		System.out.println(downloadFileURL);
		response = restTemplate.exchange(downloadFileURL, 
										HttpMethod.GET, entity, String.class);
		
		return response.getBody();
	}
}
