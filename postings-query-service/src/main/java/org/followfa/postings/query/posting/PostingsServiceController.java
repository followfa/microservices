package org.followfa.postings.query.posting;

import org.followfa.postings.query.QueriedPosting;
import org.followfa.postings.query.QueryPostingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PostingsServiceController implements QueryPostingsService {
	private final PostingsService postingsService;

	@Autowired
	public PostingsServiceController(final PostingsService postingsService) {
		this.postingsService = postingsService;
	}

	@Override
	@RequestMapping(value="/postings", method= RequestMethod.GET)
	@ResponseBody
	public List<? extends QueriedPosting> listPostingsForCurrentUser(long userId, int maxResults) {
		return postingsService.listPostingsForCurrentUser(userId, maxResults);
	}
}
