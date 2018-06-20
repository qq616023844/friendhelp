package dao;

import java.util.List;

import entity.Question;
import entity.Video;

public interface DaoSearch {
	public List<Object> getAllType();
	public List<Video> getByNeedOfVideo(String keyword, String type, int inception);
	public List<Question> getByNeedOfQuestion(String keyword, String type, int inception);
}
