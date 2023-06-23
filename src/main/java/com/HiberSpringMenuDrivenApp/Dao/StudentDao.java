package com.HiberSpringMenuDrivenApp.Dao;

import com.HiberSpringMenuDrivenApp.Entity.Student;

import javax.transaction.Transactional;
import java.util.List;

public interface StudentDao {
    @Transactional
    public int insert(Student student);

    public Student getStudentById(int studentId);
    public List<Student> getAllStudent();
    @Transactional
    public int deleteStudentById(int studentId);
    @Transactional
    public Student updateById(int studentId);
}
