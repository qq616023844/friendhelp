package test;

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

public class GetVideo {
	public static String httpPostWithJSON(String url) throws Exception {

        HttpPost httpPost = new HttpPost(url);
        CloseableHttpClient client = HttpClients.createDefault();
        String respContent = null;
        
//        json��ʽ
		JSONObject js = new JSONObject();
		js.put("JWT", "jjjj");
		js.put("video_id","53d7622762019f590162019f95bd0000" );
	//	js.put("Comment", new Gson().toJson(new Comment("8", "8", 9, null)));
        StringEntity entity = new StringEntity(js.toString(),"utf-8");//���������������    
        entity.setContentEncoding("UTF-8");    
        entity.setContentType("application/json");    
        httpPost.setEntity(entity);
        httpPost.started();
        System.out.println();
        
    
//        ����ʽ
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
        String result = httpPostWithJSON("http://localhost:8080/friendhelper/video/getDetailVideo");
        System.out.println(result);
        JSONObject j2 = new JSONObject(result);
        String s = j2.getString("pic_url");
        System.out.println(s);
    }
}
