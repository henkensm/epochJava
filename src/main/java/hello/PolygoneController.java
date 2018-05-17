package hello;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import hello.model.Polygone;

@Controller
public class PolygoneController {

	@Autowired
	SessionFactory sessionFactory;

	@MessageMapping("/polygone/save")
	@SendTo("/polygone/list")
	public Polygone polygoneUpdate(Polygone polygone) throws Exception {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(polygone);
			polygone = session.get(Polygone.class, polygone.getId());
			session.flush();
			return polygone;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
