package com.example.demo.garbage;

import com.example.demo.entity.Student;
import com.example.demo.StudentService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Repository {
    static Logger log = Logger.getLogger(Repository.class.getName());
    private final SessionFactory factory = getSessionFactory();
    private final Session session = factory.openSession();
    StudentService studentServiceImlementation;

    public void save(Student student) {
        session.save(student);
        closed();
    }


    public List<Student> getById(int id) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(session.get(Student.class, id));
        closed();
        return studentList.stream()
                .filter(student -> student.getId() == id)
                .collect(Collectors.toList());
    }

    public void update(Integer id) {
        Student getStudent = session.get(Student.class, id);
        getStudent.setCourse(3);
        getStudent.setFirstName("Anton");
        closed();
    }

    public void delete(Integer id) {
        session.delete(id);
        closed();
    }


    public static SessionFactory getSessionFactory() {
        try {
            StandardServiceRegistry builder = new StandardServiceRegistryBuilder().configure().build();
            Metadata metadata = new MetadataSources(builder).getMetadataBuilder().build();
            return metadata.getSessionFactoryBuilder().build();
        } catch (Throwable e) {
            //log.info("Виключення " + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public void closed() {
        session.close();
    }
}
