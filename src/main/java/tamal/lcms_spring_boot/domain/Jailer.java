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
public class Jailer {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ajailerJailerId;

    @Column
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

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime dateCreated;

    @LastModifiedDate
    @Column(nullable = false)
    private OffsetDateTime lastUpdated;

}
