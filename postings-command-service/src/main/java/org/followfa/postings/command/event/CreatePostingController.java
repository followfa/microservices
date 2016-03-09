package org.followfa.postings.command.event;

import net.davidtanzer.jdefensive.Args;
import net.davidtanzer.jdefensive.Returns;
import org.followfa.postings.command.CreatePostingService;
import org.followfa.web.posting.PostingTranslationService;
import org.followfa.web.posting.PostingViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


@Controller
public class CreatePostingController implements CreatePostingService {
	private final PostingEventService postingEventService;

	@Autowired
	public CreatePostingController(final PostingEventService postingEventService) {
		Args.notNull(postingEventService, "postingEventService");
		this.postingEventService = postingEventService;
	}

	@Override
	@RequestMapping(value = "/posting-events", method = RequestMethod.PUT)
	@ResponseBody
	public void createNewPosting(final long userId, final String postingText) {
		System.out.println("Creating posting for "+userId+", text="+postingText);
		postingEventService.createNewPosting(userId, postingText);
	}
}
