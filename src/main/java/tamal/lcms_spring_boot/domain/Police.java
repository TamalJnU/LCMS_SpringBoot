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
public class Police {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long apPoliceId;

    @Column
    private String apFirstName;
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


    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime dateCreated;

    @LastModifiedDate
    @Column(nullable = false)
    private OffsetDateTime lastUpdated;

}
