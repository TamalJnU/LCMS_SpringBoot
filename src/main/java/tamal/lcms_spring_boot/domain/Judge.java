package tamal.lcms_spring_boot.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Judge {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ajJudgeId;

    @Column
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

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime dateCreated;

    @LastModifiedDate
    @Column(nullable = false)
    private OffsetDateTime lastUpdated;

}
