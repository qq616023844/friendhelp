package localtest;

import java.sql.Time;

public class Danma {
	private String text = null;
	//����˴�JWT��ȡid���˴�Ϊǰ�˽�������ʱ��Ҫ
	private long author = 0;
	//������ʱ��
	private Time create_time = null;
	
	public Danma(){};
	
	public Danma(String text, long author, Time create_time) {
		super();
		this.text = text;
		this.author = author;
		this.create_time = create_time;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public long getAuthor() {
		return author;
	}

	public void setAuthor(long author) {
		this.author = author;
	}

	public Time getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Time create_time) {
		this.create_time = create_time;
	}

}
