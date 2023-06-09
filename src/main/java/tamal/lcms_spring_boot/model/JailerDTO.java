package tamal.lcms_spring_boot.model;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JailerDTO {

    private Long ajailerJailerId;

    @Size(max = 255)
    private String ajailerFirstName;
    private String ajailerLastName;
    private String ajailerFatherName;
    private String ajailerMotherName;
    private String ajailerGender;
    private String ajailerDoB;
    private String ajailerJailId;
    private String ajailerPoliceId;
    private String ajailerJailType;
    private String ajailerJailCity;
    private String ajailerJailName;
    private String ajailerPlacementDate;
    private String ajailerEmail;
    private String ajailerOfficePhone;
    private String ajailerPersonalPhone;
    private String ajailerPresentAddress;
    private String ajailerPermanentAddress;
    private String ajailerUserName;
    private String ajailerPassword;
    private String ajailerConfirmPassword;

}
