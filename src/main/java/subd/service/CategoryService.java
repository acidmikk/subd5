package subd.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import subd.models.Category;

import java.util.List;
import java.util.Scanner;

public class CategoryService {
    public void CategoryMenu(SessionFactory sf) {
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
            System.out.println("Input category:");
            String categoryname = scanner.next();
            Category category = new Category(categoryname);
            session.save(category);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }

    private void Read(Session session) {
        List<Category> categories = session.createQuery("SELECT c from Category c", Category.class).getResultList();
        System.out.println(categories);
    }

    private void Update(Session session) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input id of category:");
            int id = scanner.nextInt();
            System.out.println("Input category:");
            String categoryname = scanner.next();
            Category category = session.get(Category.class, id);
            category.setCategory(categoryname);
            session.save(category);
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
            Category category = session.get(Category.class, id);
            session.delete(category);
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }

    private void Filter(Session session) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input categoryName of category:");
            String categoryname = scanner.next();
            List<Category> categories = session.createQuery("SELECT c from Category c WHERE category = \'" + categoryname + "\'", Category.class).getResultList();
            System.out.println(categories);
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }
}
