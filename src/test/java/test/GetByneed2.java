package test;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import com.google.gson.Gson;

import entity.Comment;

public class GetByneed2 {
	public static String httpPostWithJSON(String url) throws Exception {

        HttpPost httpPost = new HttpPost(url);
        CloseableHttpClient client = HttpClients.createDefault();
        String respContent = null;
        
//        json方式
		JSONObject js = new JSONObject();
		js.put("JWT", "jjjj");
		js.put("keyword", "emmm");
		js.put("type","化学" );
		js.put("inception",0 );
		js.put("VorQ","Question" );
		Map<String,JSONObject> m = new HashMap<String,JSONObject>();
		m.put("content",js);
		/*
		 * 		String JWT = jsonObject.getString("JWT");
		String keyword = jsonObject.getString("keyword");
		String type = jsonObject.getString("type");
		int inception = jsonObject.getInt("inception");
		String VorQ = jsonObject.getString("VorQ");
		 */
        StringEntity entity = new StringEntity(new Gson().toJson(m),"utf-8");//解决中文乱码问题    
        entity.setContentEncoding("UTF-8");    
        entity.setContentType("application/json");    
        httpPost.setEntity(entity);
        httpPost.started();
        System.out.println();
        
    
//        表单方式
//        List<BasicNameValuePair> pairList = new ArrayList<BasicNameValuePair>(); 
//        pairList.add(new BasicNameValuePair("name", "admin"));
//        pairList.add(new BasicNameValuePair("pass", "123456"));
//        httpPost.setEntity(new UrlEncodedFormEntity(pairList, "utf-8"));   
        
        
        HttpResponse resp = client.execute(httpPost);
        if(resp.getStatusLine().getStatusCode() == 200) {
            HttpEntity he = resp.getEntity();
            respContent = EntityUtils.toString(he,"UTF-8");
        }
        return respContent;
    }

    
    public static void main(String[] args) throws Exception {
    	//localhost:8080
        String result = httpPostWithJSON("http://111.231.199.35/friendhelper/research/getByNeed");
        System.out.println(result);
    }
}
