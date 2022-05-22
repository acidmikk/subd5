package subd.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import subd.models.MyDate;

import java.util.List;
import java.util.Scanner;

public class MyDateService {
    public void MyDateMenu(SessionFactory sf) {
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
            System.out.println("Input drive date:");
            String dd = scanner.next();
            java.sql.Date drivedate = java.sql.Date.valueOf(dd);
            System.out.println("Input smena:");
            int smena = scanner.nextInt();
            MyDate myDate = new MyDate(drivedate, smena);
            session.save(myDate);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }

    private void Read(Session session) {
        List<MyDate> students = session.createQuery("SELECT d from MyDate d", MyDate.class).getResultList();
        System.out.println(students);
    }

    private void Update(Session session) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input id of date:");
            int id = scanner.nextInt();
            System.out.println("Input drive date:");
            String dd = scanner.next();
            java.sql.Date drivedate = java.sql.Date.valueOf(dd);
            System.out.println("Input smena:");
            int smena = scanner.nextInt();
            MyDate myDate = session.get(MyDate.class, id);
            myDate.setDrive_date(drivedate);
            myDate.setSmena(smena);
            session.save(myDate);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }

    private void Delete(Session session) {
        try {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Input id of student:");
            int id = scanner.nextInt();
            MyDate myDate = session.get(MyDate.class, id);
            session.delete(myDate);
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }

    private void Filter(Session session) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input smena of marsh:");
            String smena = scanner.next();
            List<MyDate> myDates = session.createQuery("SELECT d from Date d WHERE smena = \'" + smena + "\'", MyDate.class).getResultList();
            System.out.println(myDates);
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }
}
