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
		list2.add("��ʷ");
		list2.add("����");
		list2.add("����");
		list2.add("��ѧ");
		
		list3.add("��ѧ");		
		list3.add("�����");
		list3.add("����");
		list3.add("����");
		
		list4.add("��ʳ");
		list4.add("����");
		list4.add("�Ӽ�");
		list4.add("����");
		
		list5.add("����");
		list5.add("�ŵ�");
		list5.add("�ִ�");
		list5.add("���");
		
		list_name.add("��ʷ");
		list_name.add("��");
		list_name.add("����");
		list_name.add("����");
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
