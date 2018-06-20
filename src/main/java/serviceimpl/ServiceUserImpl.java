package serviceimpl;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.aliyuncs.exceptions.ClientException;
import com.google.gson.GsonBuilder;

import daoimpl.DaoUserImpl;
import entity.Account;
import entity.Reason;
import service.ServiceUser;
import tool.MessageAPI;
import tool.MessageMap;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
public class ServiceUserImpl implements ServiceUser{

	@Resource
	private DaoUserImpl daoUserImpl;
	
	public String myQuestion(String content) {
		JSONObject jsonObject = new JSONObject(content);
		String phoneNumber = jsonObject.getString("phoneNumber");
		
		return new GsonBuilder().serializeNulls().create().toJson(
				daoUserImpl.myQuestion(phoneNumber)				
				);
	}
	
	public String login(String content) {
		JSONObject jsonObject = new JSONObject(content);
		String phoneNumber = jsonObject.getString("phoneNumber");
		String password = jsonObject.getString("password");
		
		return new GsonBuilder().serializeNulls().create().toJson(
				daoUserImpl.checkUser(phoneNumber, password)				
				);
	}
	
	public String loginByQQ(String content) {
		JSONObject jsonObject = new JSONObject(content);
		String phoneNumber = jsonObject.getString("phone");
		String nickname = jsonObject.getString("nickname");
		
		return new GsonBuilder().serializeNulls().create().toJson(
				daoUserImpl.checkUserByQQ(phoneNumber,nickname)			
				);
	}
	
	public String register(String content) {
		JSONObject jsonObject = new JSONObject(content);
		String phoneNumber = jsonObject.getString("phoneNumber");
		int code = (int)((Math.random()*9+1)*100000);
		
		MessageMap.addMap(phoneNumber, code);
		
		Reason reason = new Reason();
		try {
			MessageAPI.message(phoneNumber, Integer.toString(code));
			reason.setResult(true);
			return new GsonBuilder().serializeNulls().create().toJson(reason);
		} catch (ClientException e) {
			e.printStackTrace();
			reason.setResult(false);
			return new GsonBuilder().serializeNulls().create().toJson(reason);
		}
	}

	public String registerCheck(String content) {
		JSONObject jsonObject = new JSONObject(content);
		String phoneNumber = jsonObject.getString("phoneNumber");
		int code = jsonObject.getInt("code");
		
		int code2 = MessageMap.searchMap(phoneNumber);
		System.out.println("code2 = "+code2);
		
		Reason reason = new Reason();
		
		if (code==code2) {
			MessageMap.removeMap(phoneNumber);
			
			reason.setResult(true);
			return new GsonBuilder().serializeNulls().create().toJson(reason);
		}else {
			reason.setResult(false);
			return new GsonBuilder().serializeNulls().create().toJson(reason);
		}
	}
	
	public String registerCheckend(String content) {
		JSONObject jsonObject = new JSONObject(content);
		String phoneNumber = jsonObject.getString("phoneNumber");
		String password = jsonObject.getString("password");
		
		Reason reason = new Reason();
		
		try {
			
			reason.setResult(
					daoUserImpl.addUser(new Account(null, phoneNumber, null, password))
					);
			return new GsonBuilder().serializeNulls().create().toJson(reason);			
		} catch (Exception e) {
			e.printStackTrace();
			reason.setResult(false);
			return new GsonBuilder().serializeNulls().create().toJson(reason);	
		}
		
	}
	
	public String registerCheckendByQQ(String content) {
		JSONObject jsonObject = new JSONObject(content);
		String phoneNumber = jsonObject.getString("phone");

		String nickname = jsonObject.getString("nickname");
		
		Reason reason = new Reason();
		
		try {
			
			reason.setResult(
					daoUserImpl.addUser(new Account(null, phoneNumber, nickname, null))
					);
			return new GsonBuilder().serializeNulls().create().toJson(reason);			
		} catch (Exception e) {
			e.printStackTrace();
			reason.setResult(false);
			return new GsonBuilder().serializeNulls().create().toJson(reason);	
		}
		
	}
	

}
