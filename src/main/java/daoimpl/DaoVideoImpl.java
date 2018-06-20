package daoimpl;



import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import dao.DaoVideo;
import entity.Danmaku;
import entity.Video;

@Repository
public class DaoVideoImpl extends DaoBaseDaoImpl implements DaoVideo{

	public Video getDetailVideo(String video_id) {
		try {
			String sql = "from Video v where v.video_id = :video_id ";
			Query query = getSession().createQuery(sql);
			
			query.setParameter("video_id", video_id);
	
	        query.setMaxResults(1);  
	       
	        Video video = (Video) query.uniqueResult();
			return video;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean addVideo(Video video) {
		try {
			getSession().save(video);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Danmaku> getDanmaku(String video_id,long date_start, long date_end) {
		try {
			String sql = "from Danmaku d where d.create_time >= :date_start and d.create_time <= :date_end ";
			Query query = getSession().createQuery(sql);
			query.setParameter("date_start", date_start);
			query.setParameter("date_end", date_end);
			List<Danmaku> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public boolean sendDanmaku(Danmaku danmaku) {
        try {  
            getSession().save(danmaku);
            return true;
        } catch (HibernateException e) {  
            e.printStackTrace();
            return false;
        }    
	}

}
