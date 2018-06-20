package serviceimpl;

import java.util.Date;
import java.util.Map;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import daoimpl.DaoCommentImpl;
import entity.Comment;
import entity.Reason;
import service.ServiceComment;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
public class ServiceCommentImpl implements ServiceComment{

	@Autowired
	private DaoCommentImpl daoCommentImpl;

	public String test(){return "1111111";}
	
	public String sendComment(String jsonstring) {
		
		JSONObject jsonObject = new JSONObject(jsonstring);
		String JWT = jsonObject.getString("JWT");
		String VorQ = jsonObject.getString("VorQ");
		String id = jsonObject.getString("id");
		Comment comment = new Gson().fromJson((String) jsonObject.get("Comment"), Comment.class);
		
		comment.setId(id);
		comment.setAuthor(JWT);//暂时占位
		comment.setCreate_time(new Date());
		
		Reason reason = new Reason();
		
		if ("Video".equals(VorQ)) {
			comment.setVorq(true);
			reason.setResult(daoCommentImpl.addComment(comment));

			return new GsonBuilder().serializeNulls().create().toJson(reason);
		}else if ("Question".equals(VorQ)) {
			comment.setVorq(false);
			reason.setResult(daoCommentImpl.addComment(comment));
			
			return new GsonBuilder().serializeNulls().create().toJson(reason);
		}else{
			reason.setResult(false);
			reason.setReason("查询类型错误");
			
			return new GsonBuilder().serializeNulls().create().toJson(reason);
		}
	}

	public String getComment(String jsonstring) {
		
		JSONObject jsonObject = new JSONObject(jsonstring);
		String JWT = jsonObject.getString("JWT");
		String id = jsonObject.getString("id");
		String orderby = jsonObject.getString("orderby");
		int inception = jsonObject.getInt("inception");
		
		
		if ("heat".equals(orderby)) {
			return new Gson().toJson(
					daoCommentImpl.searchCommentOFVideoByheat(id, inception)
					);
		}else if("date".equals(orderby)) {
			return new Gson().toJson(
					daoCommentImpl.searchCommentOFVideoBydate(id, inception)
					);
		}else{
			return null;
		}
		
	}

}
