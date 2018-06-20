package dao;

import java.util.List;

import entity.Question;
import entity.Video;

public interface DaoRecommendation {

	public List<Question> getRecommendOfQuesion(int inception);
	public List<Video> getRecommendOfVideo(int inception);
}
