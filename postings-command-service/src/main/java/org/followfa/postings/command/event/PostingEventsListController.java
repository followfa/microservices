package org.followfa.postings.command.event;

import net.davidtanzer.jdefensive.Args;
import net.davidtanzer.jdefensive.Returns;
import org.followfa.postings.query.event.PostingEventsListService;
import org.followfa.postings.query.event.UserPostingEvent;
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
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Controller
public class PostingEventsListController implements PostingEventsListService {
	private final PostingEventsListService postingEventService;

	@Autowired
	public PostingEventsListController(final PostingEventsListService postingEventService) {
		Args.notNull(postingEventService, "postingEventService");
		this.postingEventService = postingEventService;
	}

	@Override
	@RequestMapping(value="/posting-events", method=RequestMethod.GET)
	@ResponseBody
	public List<? extends UserPostingEvent> listNewestEventsForUser(final long userId, final Long lastEventId) {
		return postingEventService.listNewestEventsForUser(userId, lastEventId);
	}
}
