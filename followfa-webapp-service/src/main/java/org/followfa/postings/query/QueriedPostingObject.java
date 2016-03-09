package org.followfa.postings.query;

public class QueriedPostingObject implements QueriedPosting {
	private String postingText;

	@Override
	public String getPostingText() {
		return postingText;
	}
}
