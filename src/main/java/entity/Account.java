package entity;

import java.net.URL;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "account")
public class Account {
	//因为hibernate必须有主键
    @Id
    @Column(name="key_id")
    private String user_id = null;
	//头像
	@Column(name="picture_url")
	private URL picture_url = null;
	//昵称
	@Column(name="nickname")
	private String nickname = null;
	//密码
	@Column(name="password")
	private String password = null;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Account(){};
	
	public Account(URL picture_url,String user_id,String nickname,String password){
		this.picture_url = picture_url;
		this.user_id = user_id;
		this.nickname = nickname;
		this.password = password;
	}
	
	public URL getPicture_url() {
		return picture_url;
	}
	public void setPicture_url(URL picture_url) {
		this.picture_url = picture_url;
	}

	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}
