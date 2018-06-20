package serviceimpl;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.GsonBuilder;

import dao.DaoRecommendation;
import daoimpl.DaoRecommendationImpl;
import daoimpl.DaoSearchImpl;
import service.ServiceRecommend;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
public class ServiceRecommendImpl implements ServiceRecommend{

	@Autowired
	private DaoRecommendationImpl daoRecommendationImpl;
	
	public String getRecommend(String content) {
		JSONObject jsonObject = new JSONObject(content);
		String JWT = jsonObject.getString("JWT");
		int inception = jsonObject.getInt("inception");
		String VorQ = jsonObject.getString("VorQ");
		if (VorQ.equals("Question")) {
			return new GsonBuilder().serializeNulls().create().toJson(
					daoRecommendationImpl.getRecommendOfQuesion(inception)
					);
		
		}else if (VorQ.equals("Video")) {
			return new GsonBuilder().serializeNulls().create().toJson(
					daoRecommendationImpl.getRecommendOfVideo(inception)
					);
			
		}else{
			return null;
		}
	}

}
