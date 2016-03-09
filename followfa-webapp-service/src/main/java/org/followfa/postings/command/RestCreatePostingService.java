package org.followfa.postings.command;

import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class RestCreatePostingService implements CreatePostingService {
	private final RestTemplate restTemplate = new RestTemplate();

	public RestCreatePostingService() {
		HttpMessageConverter formHttpMessageConverter = new FormHttpMessageConverter();
		HttpMessageConverter stringHttpMessageConverternew = new StringHttpMessageConverter();
		restTemplate.setMessageConverters(Arrays.asList(formHttpMessageConverter, stringHttpMessageConverternew));
	}

	@Override
	public void createNewPosting(long userId, String postingText) {
		String url = "http://localhost:10081/posting-events";

		final MultiValueMap<String, String> request = new LinkedMultiValueMap<>();
		request.add("userId", String.valueOf(userId));
		request.add("postingText", postingText);

		restTemplate.put(url, request, String.class);
	}
}
