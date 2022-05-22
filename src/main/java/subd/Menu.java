package subd;

import subd.service.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import subd.models.*;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Auto.class)
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(Driver.class)
                .addAnnotatedClass(Marsh.class)
                .addAnnotatedClass(MyDate.class)
                .buildSessionFactory();

        boolean isMenu = true;
        while(isMenu){
            try {
                System.out.println("\n\nInput a number to work with:"
                        + "\n1) Auto" + "\n2) Category" + "\n3) Driver" + "\n4) Marsh" + "\n5) MyDate"
                        + "\nInput 0 to finish");

                Scanner scn = new Scanner(System.in);
                int input = scn.nextInt();

                switch (input){
                    case 0:
                        isMenu = false;
                        break;
                    case 1:
                        AutoService autoService = new AutoService();
                        try {
                            autoService.AutoMenu(sessionFactory);
                        }
                        catch (Exception ex){
                            System.out.println(ex);
                            autoService.AutoMenu(sessionFactory);
                        }
                        break;
                    case 2:
                        CategoryService categoryService = new CategoryService();
                        try {
                            categoryService.CategoryMenu(sessionFactory);
                        }
                        catch (Exception ex){
                            System.out.println(ex);
                            categoryService.CategoryMenu(sessionFactory);
                        }

                        break;
                    case 3:
                        DriverService driverService = new DriverService();
                        try {
                            driverService.DriverMenu(sessionFactory);
                        }
                        catch (Exception ex){
                            System.out.println(ex);
                            driverService.DriverMenu(sessionFactory);
                        }

                        break;
                    case 4:
                        MarshService marshService = new MarshService();
                        try {
                            marshService.MarshMenu(sessionFactory);
                        }
                        catch (Exception ex){
                            System.out.println(ex);
                            marshService.MarshMenu(sessionFactory);
                        }

                        break;
                    case 5:
                        MyDateService myDateService = new MyDateService();
                        try {
                            myDateService.MyDateMenu(sessionFactory);
                        }
                        catch (Exception ex){
                            System.out.println(ex);
                            myDateService.MyDateMenu(sessionFactory);
                        }

                        break;
                }
            }
            catch (Exception ex){
                System.out.println(ex);
            }
        }
        sessionFactory.close();
    }
}
