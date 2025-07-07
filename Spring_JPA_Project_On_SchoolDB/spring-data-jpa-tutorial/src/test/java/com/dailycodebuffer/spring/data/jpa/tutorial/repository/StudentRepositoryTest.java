package  com.dailycodebuffer.spring.data.jpa.tutorial.repository;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Guardian;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Student;

@SpringBootTest
public class StudentRepositoryTest{
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                        .emailId("dastagiri2217@gmail.com")
                        .firstName("Dastagiri")
                        .lastName("Dudekula")
                        // .guardianName("Vannurappa")
                        // .guardianMobile("9963906714")
                        .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentwithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("Late")
                .mobile("911111111")
                .build();
        Student student = Student.builder()
                .firstName("Nithin")
                .emailId("nithin3259@gmail.com")
                .lastName("Kumar")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudents(){
        List<Student> studentList = 
        studentRepository.findAll();
        System.out.println(""+studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students = 
                 studentRepository.findByFirstName("Dastagiri");
        System.out.println("Students with firstname are : "+students);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students = 
                 studentRepository.findByFirstNameContaining("i");
        System.out.println("Students with firstname are : "+students);
    }

    @Test
    public void printgetStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("dastagiri2217@gmail.com");
        System.out.println("Student with email id is : "+student);
    }

     @Test
    public void printgetStudentFirstNameByEmailAddress(){
        String firstName= studentRepository.getStudentFirstNametByEmailAddress("dastagiri2217@gmail.com");
        System.out.println("Student with email id is : "+firstName);
    }

    @Test
    public void printgetStudentByEmailAddressNativeQuery(){
        Student student = studentRepository.getStudentEmailAddressByNativeQuery("dastagiri2217@gmail.com");
        System.out.println("Student with email id : "+student);
    }

    @Test
    public void getStudentLastNameByFirstName(){
        String lastName = studentRepository.getStudentLastNameByNativeQuery("Dastagiri");
        System.out.println("Student Last name is : "+lastName);
    }
    //Using Named Params and Native Query
    @Test
    public void getStudentLastNameByFirstNameUsingNamedParam(){
        String lastName = studentRepository.getStudentLastNameByNativeQueryNamed("Dastagiri");
        System.out.println("Last Name of Student is : "+lastName);
    }

    @Test
    public void  printupdateStudentNameByEmailId(){
        studentRepository.updateStudentNameByEmailId("Dastagiri Daya", "dastagiri2217@gmail.com");
    }
} 