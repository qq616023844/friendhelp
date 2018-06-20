package daoimpl;



import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;


import dao.DaoUser;
import entity.Account;
import entity.Question;

@Repository
public class DaoUserImpl extends DaoBaseDaoImpl implements DaoUser{

	
	public List<Question> myQuestion(String phoneNumber){
		try {
			String hql = "from Question q where q.author = :phoneNumber ";
			Query query = getSession().createQuery(hql);
			query.setParameter("phoneNumber", phoneNumber);
			List<Question> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean addUser(entity.Account user) {
		try {
			getSession().save(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public Account checkUser(String phoneNumber, String password) {
		try {
			String hql = "from Account a where a.user_id = :phoneNumber and a.password = :password";
			Query query = getSession().createQuery(hql);
			query.setParameter("phoneNumber", phoneNumber);
			query.setParameter("password", password);
			List<entity.Account> list = query.list();
			if (list.size()!=0) {
				return list.get(0);
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Account checkUserByQQ(String phoneNumber,String nickname) {
		try {
			String hql = "from Account a where a.user_id = :phoneNumber ";
			Query query = getSession().createQuery(hql);
			query.setParameter("phoneNumber", phoneNumber);
			List<entity.Account> list = query.list();
			if (list.size()!=0) {
				return list.get(0);
			}else {
				Account account = new Account(null, phoneNumber, nickname, null);
				getSession().save(account);
				return account;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean uploadpicture() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean changePassword(String user_id,String oldpassword,String newpassword) {
		try {
			String sql = "UPDATE account SET password = '"+newpassword+"' WHERE password = '"+oldpassword+"' and user_id = '"+user_id+"'";
			Query query = getSession().createSQLQuery(sql);
			int i = query.executeUpdate();
			if (i != 0) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean changeNickname(String user_id,String password,String nickname) {
		try {
			String sql = "UPDATE account SET nickname = '"+nickname+"' WHERE password = '"+password+"' and user_id = '"+user_id+"'";
			Query query = getSession().createSQLQuery(sql);
			int i = query.executeUpdate();
			if (i != 0) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
