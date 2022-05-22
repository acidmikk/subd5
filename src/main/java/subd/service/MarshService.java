package subd.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import subd.models.Marsh;

import java.util.List;
import java.util.Scanner;

public class MarshService {
    public void MarshMenu(SessionFactory sf) {
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
            System.out.println("Input num:");
            int num = scanner.nextInt();
            System.out.println("Input description:");
            String description = scanner.next();
            System.out.println("Input length:");
            int length = scanner.nextInt();
            Marsh student = new Marsh(num, description, length);
            session.save(student);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }

    private void Read(Session session) {
        List<Marsh> marshes = session.createQuery("SELECT m from Marsh m", Marsh.class).getResultList();
        System.out.println(marshes);
    }

    private void Update(Session session) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input id of student:");
            int id = scanner.nextInt();
            System.out.println("Input num:");
            int num = scanner.nextInt();
            System.out.println("Input description:");
            String description = scanner.next();
            System.out.println("Input length:");
            int length = scanner.nextInt();
            Marsh marsh = session.get(Marsh.class, id);
            marsh.setNum(num);
            marsh.setDiscription(description);
            marsh.setLenght(length);
            session.save(marsh);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }

    private void Delete(Session session) {
        try {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Input id of Marsh:");
            int id = scanner.nextInt();
            Marsh marsh = session.get(Marsh.class, id);
            session.delete(marsh);
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }

    private void Filter(Session session) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input length of marsh:");
            String length = scanner.next();
            List<Marsh> students = session.createQuery("SELECT m from Marsh m WHERE length = \'" + length + "\'", Marsh.class).getResultList();
            System.out.println(students);
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }
}
