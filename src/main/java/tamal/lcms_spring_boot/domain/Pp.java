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
public class Pp {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appPpId;

    @Column
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

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime dateCreated;

    @LastModifiedDate
    @Column(nullable = false)
    private OffsetDateTime lastUpdated;

}
