package entity;

import java.net.URL;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "question")
public class Question {
	
    @Id
    @GeneratedValue(generator="system-uuid")  
    @GenericGenerator(name = "system-uuid",strategy="uuid")
    @Column(name="question_id")
	private String question_id = null;
    
    @Column(name="title")
	private String title = null;
	
    //问题内容
    @Column(name="content")
	private String content = null;
	
    //作者
    @Column(name="author")
	private String author = null;
	
    //发布时间
    @Column(name="publish_time")
	private Date publish_time = null;
	
    //问题图片
    @Column(name="pic_url")
	private String pic_url = null;
	
    //评论数量
    @Column(name="comment_count")
	private int comment_count = 0;
	
    //最新回复
    @Column(name="behot_time")
	private Date behot_time = null;
	
    //分组(最多可填1种分组)
    @Column(name="group_id")
	private String group = null;
	
	public Question(){};
	
	public Question(String question_id, String title, String content, String author, Date publish_time, String pic_url,
			int comment_count, Date behot_time, String group) {
		super();
		this.question_id = question_id;
		this.title = title;
		this.content = content;
		this.author = author;
		this.publish_time = publish_time;
		this.pic_url = pic_url;
		this.comment_count = comment_count;
		this.behot_time = behot_time;
		this.group = group;
	}

	public String getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(String question_id) {
		this.question_id = question_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getPublish_time() {
		return publish_time;
	}
	public void setPublish_time(Date publish_time) {
		this.publish_time = publish_time;
	}
	public String getPic_url() {
		return pic_url;
	}
	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}
	public int getComment_count() {
		return comment_count;
	}
	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}
	public Date getBehot_time() {
		return behot_time;
	}
	public void setBehot_time(Date behot_time) {
		this.behot_time = behot_time;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}

}
