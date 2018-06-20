package entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "danmaku")
public class Danmaku {
	//��Ϊhibernate����������
    @Id
    @GeneratedValue(generator="system-uuid")  
    @GenericGenerator(name = "system-uuid",strategy="uuid")
    @Column(name="key_id")
    private String keyid = null;
    
    @Column(name="text")
	private String text = null;
	//��Ƶ/����id
    @Column(name="video_id")
	private String video_id = null;
	//����˴�JWT��ȡid���˴�Ϊǰ�˽�������ʱ��Ҫ
    @Column(name="author")
	private String author = null;
	//������ʱ��
    @Column(name="create_time")
	private long create_time = 0;
	
	public Danmaku(){};
	
	public Danmaku(String text, String author, long create_time,String video_id) {
		super();
		this.text = text;
		this.author = author;
		this.create_time = create_time;
		this.video_id = video_id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public long getCreate_time() {
		return create_time;
	}

	public void setCreate_time(long create_time) {
		this.create_time = create_time;
	}

	public String getVideo_id() {
		return video_id;
	}

	public void setVideo_id(String video_id) {
		this.video_id = video_id;
	}
}
