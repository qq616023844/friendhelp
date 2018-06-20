package serviceimpl;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.GsonBuilder;

import daoimpl.DaoCommentImpl;
import daoimpl.DaoSearchImpl;
import service.ServiceSearch;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
public class ServiceSearchImpl implements ServiceSearch{

	@Autowired
	private DaoSearchImpl daoSearchImpl;
	
	public String getAllType(String content) {
		return new GsonBuilder().serializeNulls().create().toJson(
				daoSearchImpl.getAllType()
				);
	}

	public String getByNeed(String content) {
		JSONObject jsonObject = new JSONObject(content);
		String JWT = jsonObject.getString("JWT");
		String keyword = jsonObject.getString("keyword");
		String type = jsonObject.getString("type");
		int inception = jsonObject.getInt("inception");
		String VorQ = jsonObject.getString("VorQ");
		
		if (VorQ.equals("Question")) {
			return new GsonBuilder().serializeNulls().create().toJson(
					daoSearchImpl.getByNeedOfQuestion(keyword, type, inception)
					);
		
		}else if (VorQ.equals("Video")) {
			return new GsonBuilder().serializeNulls().create().toJson(
					daoSearchImpl.getByNeedOfVideo(keyword, type, inception)
					);
			
		}else{
			return null;
		}
	}

}
