package com.SpringProject.Spring_java_jpa.repository;

import com.SpringProject.Spring_java_jpa.entity.Guardian;
import com.SpringProject.Spring_java_jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.Guard;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentRepoTest {
    @Autowired
    private studentRepo studrepo;

    @Test
    public void saveStud(){
        Student stud = Student.builder()
                .firstName("Rishabh")
                .lastName("Negi")
                .emailId("rishabh@example.com")
//                .guardianName("Mr. Negi")
//                .guardianEmail("guardian@example.com")
//                .guardianMobile("9876543210")
                .build();

        studrepo.save(stud);
    }

    @Test
    public void saveStudWithGuardian(){
        Guardian Studguard = Guardian.builder()
                .name("Pradeep")
                .email("pradeepnegi@gmail.com")
                .mobile("8126919971")
                .build();

        Student stud = Student.builder()
                .firstName("Rishi")
                .lastName("Negi")
                .emailId("rishinegi@gmail.com")
                .guard(Studguard)
                .build();

        studrepo.save(stud);
    }

    @Test
    public void showStud(){
        List<Student> allStud = studrepo.findAll();
        //System.out.println(allStud);
        for(Student s : allStud)
            System.out.println(s.toString());
    }

    @Test
    public void getStudentByFirstName(){
        List<Student> stud = studrepo.findByFirstName("Rishi");
        System.out.println(stud);
    }

    @Test
    public void getStudentByLastName(){
        List<Student> stud = studrepo.findStudentByLastName("Negi");
        System.out.println(stud);
    }

    @Test
    public void getStudentByfirstNameContaining(){
        List<Student> stud = studrepo.findByLastNameContaining("rma");
        System.out.println(stud);
    }

//    @Test
//    public void getStudentByNameContaining(){
//        List<Student> stud = studrepo.findByNameContaining("Pradeep");
//        System.out.println(stud);
//    }

    @Test
    public void getStudentByEmail(){
        List<Student> stud  = studrepo.findStudentByEmailAddress("rishinegi@gmail.com");
        System.out.println(stud);
    }

    @Test
    public void getStudentNameByEmail(){
        String stud  = studrepo.findStudentFirstNameByEmailAddress("rishinegi@gmail.com");
        System.out.println("Student Name : " +stud);
    }

    @Test
    public void getStudentNameByEmailContaining(){
        List<Student> stud  = studrepo.findStudentByLastNameNative("Sharma");
        System.out.println("Students : " +stud);
    }

    @Test
    public void getByFirstName(){
        List<Student> stud  = studrepo.findByFirstNameParam("Rishi");
        System.out.println("Students : " +stud);
    }

    @Test
    public void updateStudentNameByEmailId(){
        int rows = studrepo.updateStudentNameByEmailId("Risha" ,"rishabh@example.com" );
        System.out.println("Affected rows :" + rows);
    }


}