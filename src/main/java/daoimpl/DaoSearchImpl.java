package daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import dao.DaoSearch;
import entity.Question;
import entity.Video;

@Repository
public class DaoSearchImpl extends DaoBaseDaoImpl implements DaoSearch{

	public List<Object> getAllType() {
		List<Object> list = new ArrayList<Object>();
		List<String> list_name = new ArrayList<String>();
		
		List<String> list2 = new ArrayList<String>();
		List<String> list3 = new ArrayList<String>();
		List<String> list4 = new ArrayList<String>();
		List<String> list5 = new ArrayList<String>();
		list2.add("历史");
		list2.add("政治");
		list2.add("语文");
		list2.add("哲学");
		
		list3.add("数学");		
		list3.add("计算机");
		list3.add("工程");
		list3.add("电子");
		
		list4.add("美食");
		list4.add("养生");
		list4.add("居家");
		list4.add("旅行");
		
		list5.add("西洋");
		list5.add("古典");
		list5.add("现代");
		list5.add("民风");
		
		list_name.add("文史");
		list_name.add("理工");
		list_name.add("生活");
		list_name.add("艺术");
		list.add(list_name);
		list.add(list2);
		list.add(list3);
		list.add(list4);
		list.add(list5);
		
		return list;
	}

	public List<Question> getByNeedOfQuestion(String keyword, String type, int inception) {
		String hql = "from Question q where q.title like :title and q.group = :group";
		Query query = getSession().createQuery(hql);
		query.setParameter("title", "%"+keyword+"%");
		query.setString("group", type);
		List<Question> list = query.list();
		System.out.println(list.size());
		return list;
	}
	
	public List<Video> getByNeedOfVideo(String keyword, String type, int inception) {
		String hql = "from Video v where v.title like :title and v.group =:group";
		Query query = getSession().createQuery(hql);
		query.setString("title", "%"+keyword+"%");
		query.setString("group", type);
		List<Video> list = query.list();
		return list;
	}



}
