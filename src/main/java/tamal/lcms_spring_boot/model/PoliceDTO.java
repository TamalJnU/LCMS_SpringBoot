package tamal.lcms_spring_boot.model;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PoliceDTO {

    private Long apPoliceId;

    @Size(max = 255)
    private String apFirstName;

    @Size(max = 255)
    private String apLastName;
    private String apFatherName;
    private String apMotherName;
    private String apGender;
    private String apDoB;
    private String apDepartmentId;
    private String apDepartmentType;
    private String apDistrictName;
    private String apThanaName;
    private String apBatch;
    private String apRank;
    private String apPlacementDate;
    private String apWeaponSerial;
    private String apPresentAddress;
    private String apPermanentAddress;
    private String apEmail;
    private String apOfficePhone;
    private String apPersonalPhone;
    private String apUserName;
    private String apPassword;
    private String apConfirmPassword;

}
