package tamal.lcms_spring_boot.model;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PpDTO {

    private Long appPpId;

    @Size(max = 255)
    private String appFirstName;
    private String appLastName;
    private String appFatherName;
    private String appMotherName;
    private String appGender;
    private String appDoB;
    private String appCourtId;
    private String appCourtType;
    private String appCourtCity;
    private String appCourtName;
    private String appCourtNo;
    private String appTribunalName;
    private String appChiefJustice;
    private String appChiefJusticeId;
    private String appPlacementDate;
    private String appEmail;
    private String appOfficePhone;
    private String appPersonalPhone;
    private String appPresentAddress;
    private String appPermanentAddress;
    private String appUserName;
    private String appPassword;
    private String appConfirmPassword;

}
