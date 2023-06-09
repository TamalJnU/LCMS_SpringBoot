package tamal.lcms_spring_boot.model;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class JudgeDTO {

    private Long ajJudgeId;

    @Size(max = 255)
    private String ajFirstName;
    private String ajLastName;
    private String ajFatherName;
    private String ajMotherName;
    private String ajGender;
    private String ajDoB;
    private String ajCourtId;
    private String ajCourtType;
    private String ajCourtCity;
    private String ajCourtName;
    private String ajCourtNo;
    private String ajTribunalName;
    private String ajChiefJustice;
    private String ajChiefJusticeId;
    private String ajPlacementDate;
    private String ajEmail;
    private String ajOfficePhone;
    private String ajPersonalPhone;
    private String ajPresentAddress;
    private String ajPermanentAddress;
    private String ajUserName;
    private String ajPassword;
    private String ajConfirmPassword;

}
