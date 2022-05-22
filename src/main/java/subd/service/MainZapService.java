package subd.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import subd.models.Auto;

import java.util.List;

public class MainZapService {
    public void work (SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        List<Auto> autos = session.createQuery("SELECT c FROM Auto c", Auto.class).getResultList();
        System.out.print("~Autos~");
        for (int i = 0; i < autos.size(); i++) {
            System.out.format("\nName: %s, Cost 1km: %s;", autos.get(i).getName(),
                    autos.get(i).getCost_1km());
        }
        session.getTransaction().commit();
    }
}
