package daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import dao.DaoProblem;
import entity.CommentList;
import entity.Question;

@Repository
public class DaoProblemImpl extends DaoBaseDaoImpl implements DaoProblem{

	public boolean addProblem(Question question) {
		try {  
            getSession().save(question);
            return true;
        } catch (HibernateException e) {  
            e.printStackTrace();
            return false;
        }       
		
	}

	public Question getDetailProblem(String question_id) {
		try{
			String hql = "from Question q where q.question_id = :question_id ";
			Query query = getSession().createQuery(hql);
			  
			query.setParameter("question_id", question_id);
			
			List<Question> list = query.list();
			
			if (list.size()==1) {
				return list.get(0);
			}else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
