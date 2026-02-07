package com.SpringProject.Spring_java_jpa.repository;

import com.SpringProject.Spring_java_jpa.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface studentRepo extends JpaRepository<Student , Long> {

    public List<Student> findByFirstName(String firstName);
    public List<Student> findStudentByLastName(String lastName);
    public List<Student> findByLastNameContaining(String firstName);
   // public List<Student> findByNameContaining(String name);

    //JPQL Qiery
    @Query("Select s from Student s where s.emailId = ?1")
    public List<Student> findStudentByEmailAddress(String emaiId);

    @Query("Select s.firstName from Student s where s.emailId = ?1")
    public String findStudentFirstNameByEmailAddress(String emaiId);

    //Using the Native SQL query
    //Using Native in the method name is optional, it doesn't affect the functioning of JPA internal query framing
    @Query( value = "Select * from Student s where s.last_name = ?1",
            nativeQuery = true)
    public List<Student> findStudentByLastNameNative(String lastName);

    //Using @Param
    @Query(value = "Select * from Student s where s.first_name = :firstName",
    nativeQuery = true)
    public List<Student> findByFirstNameParam(@Param("firstName") String firstName);

    @Transactional
    @Modifying
    @Query(
            value = "update student s set s.first_name = :firstName where s.email_Id = :emailId",
            nativeQuery = true
    )
    public int updateStudentNameByEmailId(@Param("firstName") String firstName ,@Param("emailId") String emailId);
}
