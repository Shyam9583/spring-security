package in.technotap.springsecurity.student;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {
    private Long studentId;
    private String firstName;
    private String lastName;
}
