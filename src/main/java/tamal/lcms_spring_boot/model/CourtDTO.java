package tamal.lcms_spring_boot.model;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CourtDTO {

    private Long acCourtId;

    @Size(max = 255)
    private String acCourtType;
    private String acCourtCity;
    private String acCourtName;
    private String acCourtNo;
    private String acTribunalName;
    private String acChiefJustice;
    private String acChiefJusticeId;
    private String acPublicProsecutor;
    private String acPublicProsecutorId;
    private String acEmail;
    private String acCourtPhone;
    private String acUserName;
    private String acPassword;
    private String acConfirmPassword;

}
