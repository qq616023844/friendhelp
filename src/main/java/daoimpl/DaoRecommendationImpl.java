package daoimpl;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import dao.DaoRecommendation;
import entity.Question;
import entity.Video;

@Repository
public class DaoRecommendationImpl extends DaoBaseDaoImpl implements DaoRecommendation{

	public List<Question> getRecommendOfQuesion(int inception) {
		String hql = "from Question q ";
		Query query = getSession().createQuery(hql);
		
		List<Question> list = query.list();
		return list;
	}

	public List<Video> getRecommendOfVideo(int inception) {
		String hql = "from Video v ";
		Query query = getSession().createQuery(hql);
		
		List<Video> list = query.list();
		return list;
	}

}
