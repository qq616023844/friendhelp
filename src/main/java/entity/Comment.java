package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "comment")
public class Comment {
	//因为hibernate必须有主键
    @Id
    @GeneratedValue(generator="system-uuid")  
    @GenericGenerator(name = "system-uuid",strategy="uuid")
    @Column(name="key_id")
    private String keyid = null;
    
	//视频或问题id
	@Column(name="id")
	private String id = null;
	@Column(name="text")
	private String text = null;
	//服务端从JWT获取id，此处为前端接收数据时需要
	@Column(name="author")
	private String author = null;
	//true代表视频,flase代表问题
	@Column(name="vorq")
	private boolean vorq = true;
	//服务端获取当前服务器时间，此处为前端接收数据时需要
	@Column(name="create_time")
	private Date create_time = null;
	
	public Comment(){};
	
	public Comment(String id,String text, String author, Date create_time) {
		super();
		this.id = id;
		this.text = text;
		this.author = author;
		this.create_time = create_time;
	}
	
	public String getKeyid() {
		return keyid;
	}

	public void setKeyid(String keyid) {
		this.keyid = keyid;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public boolean isVorq() {
		return vorq;
	}

	public void setVorq(boolean vorq) {
		this.vorq = vorq;
	}


}
