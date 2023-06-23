package com.HiberSpringMenuDrivenApp;

import com.HiberSpringMenuDrivenApp.Dao.StudentDao;
import com.HiberSpringMenuDrivenApp.Entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * MenuDriven Application
 * Core Spring
 * Hibernate Orm
 *by Ajit Kumar Mandal
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        System.out.println( "***************HibernateORM***************" );
        System.out.println( "***********MenuDrivenApplication**********" );
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
        BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in));
        boolean run= true;
        while(run) {
            System.out.println("Enter: 1 for Add New Student");
            System.out.println("Enter: 2 for Get Student Details By ID ");
            System.out.println("Enter: 3 for Get All Student Details");
            System.out.println("Enter: 4 for Delete Student By ID");
            System.out.println("Enter: 5 for Update Student BY ID");
            System.out.println("Enter: 6 for  exit");
            int choice= Integer.parseInt(bufferedReader.readLine());
            switch (choice){
                case 1:
                    System.out.println("****Thanks for choosing option 1 for Add New Student****\n\n");
                    System.out.println("Enter Student name");
                    String name = bufferedReader.readLine();
                    System.out.println("Enter Student Address");
                    String address = bufferedReader.readLine();
                    System.out.println("Enter Student Email");
                    String email = bufferedReader.readLine();
                    Student student = new Student(name,address,email);
                    int result = studentDao.insert(student);
                    if(result > 0){
                        System.out.println("One Student Added Successfully !");
                    }else {
                        System.out.println("Something Wrong ...!");
                    }
                    break;
                case 2:
                    System.out.println("****Thanks for choosing option 2 for Get Student Details By ID****\n");
                    System.out.println("Enter Student id");
                    int id= Integer.parseInt(bufferedReader.readLine());
                    Student s = studentDao.getStudentById(id);
                    System.out.println(s);
                    break;
                case 3:
                    System.out.println("****Thanks for choosing option 3 for Get All Student Details ****");
                    List<Student> allStudent = studentDao.getAllStudent();
                    for(Student st :allStudent){
                        System.out.println(st);
                    }
                    break;
                case 4:
                    System.out.println("****Thanks for choosing option 4 for Delete Student By ID****");
                    System.out.println("Enter Student ID");
                    int sid= Integer.parseInt(bufferedReader.readLine());
                    int delete = studentDao.deleteStudentById(sid);
                    if(delete > 0){
                        System.out.println("One Student Deleted Successfully !");
                    }else {
                        System.out.println("Something Wrong ...!");
                    }
                    break;
                case 5:
                    System.out.println("****Thanks for choosing option 5 for Update Student Details By ID****");
                    System.out.println("Enter Student id");
                    int uid=Integer.parseInt(bufferedReader.readLine());
                    studentDao.updateById(uid);
                    break;
                case 6:
                    System.out.println("****Thanks Bye Bye! See you Again!****");
                    run = false;
                    break;
                default:
                    System.out.println("Ohh! Wrong Choice, Enter Valid Choice");
            }
        }
    }
}
