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
@Table(name = "video")
public class Video {
	//因为hibernate必须有主键
    @Id
    @GeneratedValue(generator="system-uuid")  
    @GenericGenerator(name = "system-uuid",strategy="uuid")
    @Column(name="video_id")
	private String video_id = null;
	@Column(name="title")
	private String title = null;
	//视频内容
	@Column(name="content")
	private String content = null;
	@Column(name="author")
	private String author = null;
	@Column(name="publish_time")
	private Date publish_time = null;
	//封面图片
	@Column(name="pic_url")
	private String pic_url = null;
	@Column(name="comment_count")
	private int comment_count = 0;
	@Column(name="behot_time")
	private Date behot_time = null;
	
	@Column(name="group_id")
	private String group = null;
	
	public Video(){};
	
	public Video(String video_id, String title, String content, String author, Date publish_time, String pic_url,
			int comment_count, Date behot_time, String group) {
		super();
		this.video_id = video_id;
		this.title = title;
		this.content = content;
		this.author = author;
		this.publish_time = publish_time;
		this.pic_url = pic_url;
		this.comment_count = comment_count;
		this.behot_time = behot_time;
		this.group = group;
	}

	public String getVideo_id() {
		return video_id;
	}

	public void setVideo_id(String video_id) {
		this.video_id = video_id;
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
