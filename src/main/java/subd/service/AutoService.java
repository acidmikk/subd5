package subd.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import subd.models.Auto;
import subd.models.Category;

import java.util.List;
import java.util.Scanner;

public class AutoService {
    public void AutoMenu(SessionFactory sf) {
        System.out.println("Input a number to choose the action:"
                + "\n1) Create" + "\n2) Read" + "\n3) Update" + "\n4) Delete" + "\n5) Filter");
        Scanner scn = new Scanner(System.in);
        int input = scn.nextInt();

        Session session = null;
        session = sf.getCurrentSession();
        session.beginTransaction();

        try {
            switch (input){
                case 1:
                    Create(session);
                    break;
                case 2:
                    Read(session);
                    break;
                case 3:
                    Update(session);
                    break;
                case 4:
                    Delete(session);
                    break;
                case 5:
                    Filter(session);
                    break;
            }
            session.getTransaction().commit();
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }

    private void Create(Session session) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input Name:");
            String name = scanner.next();
            System.out.println("Input id of group:");
            Long categoryid = scanner.nextLong();
            System.out.println("Input cost 1km:");
            int cost_1km = scanner.nextInt();
            Auto auto = new Auto(name, cost_1km, categoryid);
            session.save(auto);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }

    private void Read(Session session) {
        List<Auto> autos = session.createQuery("SELECT a from Auto a", Auto.class).getResultList();
        System.out.println(autos);
    }

    private void Update(Session session) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input id of auto:");
            int id = scanner.nextInt();
            System.out.println("Input name:");
            String name = scanner.next();
            System.out.println("Input id of group:");
            Long categoryid = scanner.nextLong();
            System.out.println("Input cost 1km:");
            int cost_1km = scanner.nextInt();
            Auto auto = session.get(Auto.class, id);
            auto.setName(name);
            auto.setCost_1km(cost_1km);
            auto.setCategory_fk(categoryid);
            session.save(auto);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }

    private void Delete(Session session) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input id of auto:");
            int id = scanner.nextInt();
            Auto auto = session.get(Auto.class, id);
            session.delete(auto);
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }

    private void Filter(Session session) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input name id of auto:");
            String name = scanner.nextLine();
            List<Auto> autos = session.createQuery("SELECT a from Auto a WHERE Name ='" + name + "'", Auto.class).getResultList();
            System.out.println(autos);
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }
}
