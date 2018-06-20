package entity;

import java.util.List;

public class CommentList {
	//是否还有评论
	private boolean has_more = false;
	//本次评论条数
	private int total = 0;
	private List<Comment> comments = null;
	
	public CommentList(){};
	
	public CommentList(boolean has_more, int total, List<Comment> comments) {
		super();
		this.has_more = has_more;
		this.total = total;
		this.comments = comments;
	}

	public boolean isHas_more() {
		return has_more;
	}

	public void setHas_more(boolean has_more) {
		this.has_more = has_more;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}
