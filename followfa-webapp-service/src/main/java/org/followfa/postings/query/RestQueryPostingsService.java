package org.followfa.postings.query;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RestQueryPostingsService implements QueryPostingsService {
	private final RestTemplate restTemplate = new RestTemplate();

	@Override
	public List<? extends QueriedPosting> listPostingsForCurrentUser(long userId, int maxResults) {
		String url = "http://localhost:10082/postings?userId=" + userId+"&maxResults="+maxResults;

		ResponseEntity<List<QueriedPostingObject>> response =
				restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<QueriedPostingObject>>() {});
		return response.getBody();
	}
}
