package dao;

import entity.CommentList;

public interface DaoComment {

	public boolean addComment(entity.Comment comment);
		
	public CommentList searchCommentOFVideoByheat(String id,int inception);
	
	public CommentList searchCommentOFVideoBydate(String id,int inception);
}
