package subd.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import subd.models.Driver;

import java.util.List;
import java.util.Scanner;

public class DriverService {
    public void DriverMenu(SessionFactory sf) {
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
            System.out.println("Input firstname of driver:");
            String firstname = scanner.next();
            System.out.println("Input lastname of driver:");
            String lastname = scanner.next();
            System.out.println("Input fathername of driver:");
            String fathername = scanner.next();
            Driver teacher = new Driver(firstname, lastname, fathername);
            session.save(teacher);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }

    private void Read(Session session) {
        List<Driver> teachers = session.createQuery("SELECT d from Driver d", Driver.class).getResultList();
        System.out.println(teachers);
    }

    private void Update(Session session) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input id of teacher:");
            Long id = scanner.nextLong();
            System.out.println("Input firstname of driver:");
            String firstname = scanner.next();
            System.out.println("Input lastname of driver:");
            String lastname = scanner.next();
            System.out.println("Input fathername of driver:");
            String fathername = scanner.next();
            Driver driver = session.get(Driver.class, id);
            driver.setFirst_name(firstname);
            driver.setSecond_name(lastname);
            driver.setFather_name(fathername);
            session.save(driver);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }

    private void Delete(Session session) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input id of driver:");
            Long id = scanner.nextLong();
            Driver driver = session.get(Driver.class, id);
            session.delete(driver);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }

    private void Filter(Session session) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input firstname:");
            String firstname = scanner.next();
            List<Driver> drivers = session.createQuery("SELECT d from Driver d WHERE firstname = \'" + firstname + "\'", Driver.class).getResultList();
            System.out.println(drivers);
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }
}
