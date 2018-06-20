package localtest;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import daoimpl.DaoCommentImpl;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"spring-hibernate.xml","springMVC-servlet.xml"});
        DaoCommentImpl daoCommentImpl = (DaoCommentImpl) context.getBean("daoCommentImpl");
     //   daoCommentImpl.addCommenOFVideo(comment);
        
	}

}
