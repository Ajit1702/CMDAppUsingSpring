package com.HiberSpringMenuDrivenApp.Dao;

import com.HiberSpringMenuDrivenApp.Entity.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class StudentDaoImpl implements StudentDao{
    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public int insert(Student student) {
        this.hibernateTemplate.save(student);
        return 1;
    }

    @Override
    public Student getStudentById(int studentId) {
        Student student = this.hibernateTemplate.get(Student.class,studentId);
        return student;
    }

    @Override
    public List<Student> getAllStudent() {
        List<Student> students = this.hibernateTemplate.loadAll(Student.class);
        return students;
    }

    @Override
    public int deleteStudentById(int studentId) {
        Student student = this.hibernateTemplate.get(Student.class, studentId);
        this.hibernateTemplate.delete(student);
        return 1;
    }

    @Override
    public Student updateById(int studentId) {
        Student student = this.hibernateTemplate.get(Student.class, studentId);
        if(student != null){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Name");
            String name =sc.next();
            System.out.println("Enter Address");
            String add =sc.next();
            System.out.println("Enter Email");
            String email =sc.next();
            student.setName(name);
            student.setAddress(add);
            student.setEmail(email);
        }
        this.hibernateTemplate.update(student);

        return null;
    }
}
