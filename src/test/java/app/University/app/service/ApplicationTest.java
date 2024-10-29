package app.University.app.service;

import com.erkosh.dto.StudentDTO;
import com.erkosh.mappers.StudentMapper;
import com.erkosh.services.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ApplicationTest {

    @Mock
    private StudentService studentService;

    @Test
    void shoulReturnStudents() {
        StudentDTO student1 = new StudentDTO();
        student1.setName("John");
        student1.setAge(20);

        StudentDTO student2 = new StudentDTO();
        student2.setName("Jane");
        student2.setAge(30);

        List<StudentDTO> mockStudents = Arrays.asList(student1, student2);

        Mockito.when(studentService.getAllStudents()).thenReturn(mockStudents);

        List<StudentDTO> students = studentService.getAllStudents();
    }
}
