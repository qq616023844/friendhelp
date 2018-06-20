package serviceimpl;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import daoimpl.DaoProblemImpl;
import daoimpl.DaoVideoImpl;
import entity.Comment;
import entity.Danmaku;
import entity.Reason;
import entity.Video;
import service.ServiceVideo;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
public class ServiceVideoImpl implements ServiceVideo{

	@Autowired
	private DaoVideoImpl daoVideoImpl;
	
	public String getDetailVideo(String content) {
		JSONObject jsonObject = new JSONObject(content);
		String JWT = jsonObject.getString("JWT");
		String video_id = jsonObject.getString("video_id");
		
		return new GsonBuilder().serializeNulls().create().toJson(
				daoVideoImpl.getDetailVideo(video_id)
				);
	}
	
	public String sendVideo(String pic_url,String title,String group) {
		Video video = new Video(null, title,null , "Admin", new Date(), pic_url, 0, new Date(), group);
		
		Reason reason = new Reason();
		reason.setResult(daoVideoImpl.addVideo(video));
		return new GsonBuilder().serializeNulls().create().toJson(reason);
	}

	public String getDanmaku(String content) {
		
		SimpleDateFormat df= new SimpleDateFormat("HH:mm:ss");
		
		JSONObject jsonObject = new JSONObject(content);
		String JWT = jsonObject.getString("JWT");
		String video_id = jsonObject.getString("video_id");
		
		long date_start = jsonObject.getLong("date_start");
		long date_end = jsonObject.getLong("date_end");
		
		return new GsonBuilder().serializeNulls().create().toJson(
				daoVideoImpl.getDanmaku(video_id, date_start, date_end)
				);
	}

	public String sendDanmaku(String content) {
		JSONObject jsonObject = new JSONObject(content);
		String JWT = jsonObject.getString("JWT");
		String video_id = jsonObject.getString("video_id");
		Danmaku danmaku = new Gson().fromJson((String) jsonObject.get("danmaku"), Danmaku.class);
		
		danmaku.setAuthor(JWT);
		danmaku.setVideo_id(video_id);
		
		Reason reason = new Reason();
		reason.setResult(daoVideoImpl.sendDanmaku(danmaku));
		
		return new GsonBuilder().serializeNulls().create().toJson(reason);
	}
	


}
