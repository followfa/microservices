package org.followfa.postings.query.posting;

import org.followfa.postings.query.event.EventType;
import org.followfa.postings.query.event.UserPostingEvent;

import java.sql.Timestamp;

public class UserPostingEventObject implements UserPostingEvent {
	private Long postingEventId;
	private Long postingId;
	private long userId;
	private Timestamp createdAt;
	private String clientEventId;
	private EventTypeObject postingEventType;
	private String postingText;

	@Override
	public Long getPostingEventId() {
		return postingEventId;
	}

	@Override
	public Long getPostingId() {
		return postingId;
	}

	@Override
	public long getUserId() {
		return userId;
	}

	@Override
	public Timestamp getCreatedAt() {
		return createdAt;
	}

	@Override
	public String getClientEventId() {
		return clientEventId;
	}

	@Override
	public EventType getPostingEventType() {
		return postingEventType;
	}

	@Override
	public String getPostingText() {
		return postingText;
	}
}
