package tamal.lcms_spring_boot.model;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JailDTO {

    private Long ajailJailId;

    @Size(max = 255)
    private String ajailJailName;
    private String ajailJailType;
    private String ajailJailCity;
    private String ajailJailSuperName;
    private String ajailJailSuperPoliceId;
    private String ajailJailEmail;
    private String ajailOfficePhone;
    private String ajailJailSuperPhone;
    private String ajailUserName;
    private String ajailPassword;
    private String ajailConfirmPassword;

}
