package org.followfa.postings.query.posting;

import org.followfa.postings.query.event.EventType;

public enum EventTypeObject implements EventType {
	CREATED {
		@Override
		public void onEventType(final Runnable onCreated) {
			onCreated.run();
		}
	}
}
