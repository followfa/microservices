package org.followfa.postings.query.posting;

import org.followfa.postings.query.event.PostingEventsListService;
import org.followfa.postings.query.event.UserPostingEvent;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RestPostingEventsListService implements PostingEventsListService {
	private final RestTemplate restTemplate = new RestTemplate();

	@Override
	public List<? extends UserPostingEvent> listNewestEventsForUser(long userId, Long lastEventId) {
		String url = "http://localhost:10081/posting-events?userId=" + userId;
		if(lastEventId != null) {
			url += "&lastEventId="+lastEventId;
		}

		ResponseEntity<List<UserPostingEventObject>> response =
				restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<UserPostingEventObject>>() {});
		return response.getBody();
	}
}
