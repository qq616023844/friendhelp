package dao;

import entity.Account;

public interface DaoUser {
	public boolean addUser(entity.Account user);
	public Account checkUser(String phoneNumber,String password);
	public boolean uploadpicture();
	public boolean changePassword(String user_id,String oldpassword,String newpassword);
	public Account checkUserByQQ(String phoneNumber,String nickname);
}
