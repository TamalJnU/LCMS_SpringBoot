package tamal.lcms_spring_boot.model;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserDTO {

    private Long id;

    @Size(max = 255)
    private String name;
    private String email;
    private String gender;
    private String departmentId;
    private String department;
    private String password;
    private String confirmPassword;

}
