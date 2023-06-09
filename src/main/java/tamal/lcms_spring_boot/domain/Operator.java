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
public class Operator {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aoOperatorId;

    @Column
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

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime dateCreated;

    @LastModifiedDate
    @Column(nullable = false)
    private OffsetDateTime lastUpdated;

}
