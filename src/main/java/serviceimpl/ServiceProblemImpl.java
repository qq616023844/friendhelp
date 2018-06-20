package serviceimpl;

import java.util.Date;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dao.DaoProblem;
import daoimpl.DaoCommentImpl;
import daoimpl.DaoProblemImpl;
import entity.Comment;
import entity.Question;
import entity.Reason;
import service.ServiceProblem;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
public class ServiceProblemImpl implements ServiceProblem{

	@Autowired
	private DaoProblemImpl daoProblemImpl;
	
	public String sendProblem(String jsonstring) {
		JSONObject jsonObject = new JSONObject(jsonstring);
		String JWT = jsonObject.getString("JWT");
		Question question = new Gson().fromJson((String) jsonObject.get("question"), Question.class);
		
		question.setAuthor(JWT);//ÔÝÊ±Õ¼Î»
		question.setPublish_time(new Date());
		question.setBehot_time(new Date());
		
		Reason reason = new Reason();
		try {			
			reason.setResult(daoProblemImpl.addProblem(question));
		} catch (Exception e) {
			reason.setResult(false);
		}		
		return new GsonBuilder().serializeNulls().create().toJson(reason);
	}

	public String getDetailProblem(String content) {
		JSONObject jsonObject = new JSONObject(content);
		String question_id = jsonObject.getString("question_id");
		
		return new Gson().toJson(
				daoProblemImpl.getDetailProblem(question_id)
				);
	}

}
