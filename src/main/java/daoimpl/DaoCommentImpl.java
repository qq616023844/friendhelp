package daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entity.Comment;
import entity.CommentList;

@Repository
public class DaoCommentImpl extends DaoBaseDaoImpl implements dao.DaoComment{

	
	public boolean addComment(Comment comment) {
        try {  
            getSession().save(comment);
            return true;
        } catch (HibernateException e) {  
            e.printStackTrace();
            return false;
        }       
		
	}

	public CommentList searchCommentOFVideoByheat(String id, int inception) {
		try{
			String hql = "from Comment c where c.id = :id ";
			Query query = getSession().createQuery(hql);
			
			query.setFirstResult(inception);
			query.setMaxResults(10);
			
			query.setParameter("id", id);
			List<entity.Comment> list = query.list();
			System.out.println(list.size());
			return new CommentList( (list.size()<10)?false:true, 10, list);			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public CommentList searchCommentOFVideoBydate(String id, int inception) {
		try {
			String hql = "from Comment c where c.id = :id ";
			Query query = getSession().createQuery(hql);
			  
			query.setFirstResult(inception);
			query.setMaxResults(10);
			  
			query.setParameter("id", id);
			List<entity.Comment> list = query.list();
			  
			return new CommentList( (list.size()<10)?false:true, 10, list);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
