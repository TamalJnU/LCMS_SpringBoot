package tamal.lcms_spring_boot.model;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OperatorDTO {

    private Long aoOperatorId;

    @Size(max = 255)
    private String aoOperatorOf;
    private String aoBpCourtId;
    private String aoFirstName;
    private String aoLastName;
    private String aoFatherName;
    private String aoMotherName;
    private String aoGender;
    private String aoDoB;
    private String aoDepartmentId;
    private String aoDepartmentType;
    private String aoDistrictName;
    private String aoThanaName;
    private String aoBatch;
    private String aoRank;
    private String aoPlacementDate;
    private String aoWeaponSerial;
    private String aoPresentAddress;
    private String aoPermanentAddress;
    private String aoEmail;
    private String aoOfficePhone;
    private String aoPersonalPhone;
    private String aoUserName;
    private String aoPassword;
    private String aoConfirmPassword;

}
