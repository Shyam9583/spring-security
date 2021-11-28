package in.technotap.springsecurity.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path = "/students", produces = "application/json")
public class StudentController {

    private static final List<Student> students = Arrays.asList(
            Student.builder().studentId(1L).firstName("Shyam").lastName("Sahoo").build(),
            Student.builder().studentId(2L).firstName("Nancy").lastName("Palocy").build(),
            Student.builder().studentId(3L).firstName("Alex").lastName("Jones").build()
    );

    @GetMapping("{studentId}")
    public Student getStudent(@PathVariable Long studentId) {
        return students.stream()
                .filter(s -> Objects.equals(s.getStudentId(), studentId))
                .findFirst()
                .orElseThrow(IllegalStateException::new);
    }
}
