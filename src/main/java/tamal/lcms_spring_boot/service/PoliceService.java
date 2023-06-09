package tamal.lcms_spring_boot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tamal.lcms_spring_boot.domain.Police;
import tamal.lcms_spring_boot.model.PoliceDTO;
import tamal.lcms_spring_boot.repos.PoliceRepository;
import tamal.lcms_spring_boot.util.NotFoundException;


@Service
public class PoliceService {

    private final PoliceRepository policeRepository;

    public PoliceService(final PoliceRepository policeRepository) {
        this.policeRepository = policeRepository;
    }

    public List<PoliceDTO> findAll() {
        final List<Police> polices = policeRepository.findAll(Sort.by("apPoliceId"));
        return polices.stream()
                .map((police) -> mapToDTO(police, new PoliceDTO()))
                .collect(Collectors.toList());   //.toList() cilo age
    }

    public PoliceDTO get(final Long apPoliceId) {
        return policeRepository.findById(apPoliceId)
                .map((police) -> mapToDTO(police, new PoliceDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final PoliceDTO policeDTO) {
        final Police police = new Police();
        mapToEntity(policeDTO, police);
        return policeRepository.save(police).getApPoliceId();
    }

    public void update(final Long apPoliceId, final PoliceDTO policeDTO) {
        final Police police = policeRepository.findById(apPoliceId)
                .orElseThrow(NotFoundException::new);
        mapToEntity(policeDTO, police);
        policeRepository.save(police);
    }

    public void delete(final Long apPoliceId) {
        policeRepository.deleteById(apPoliceId);
    }

    private PoliceDTO mapToDTO(final Police police, final PoliceDTO policeDTO) {
        policeDTO.setApPoliceId(police.getApPoliceId());
        policeDTO.setApFirstName(police.getApFirstName());
        policeDTO.setApLastName(police.getApLastName());
        policeDTO.setApFatherName(police.getApFatherName());
        policeDTO.setApMotherName(police.getApMotherName());
        policeDTO.setApGender(police.getApGender());
        policeDTO.setApDoB(police.getApDoB());
        policeDTO.setApDepartmentId(police.getApDepartmentId());
        policeDTO.setApDepartmentType(police.getApDepartmentType());
        policeDTO.setApDistrictName(police.getApDistrictName());
        policeDTO.setApThanaName(police.getApThanaName());
        policeDTO.setApBatch(police.getApBatch());
        policeDTO.setApRank(police.getApRank());
        policeDTO.setApPlacementDate(police.getApPlacementDate());
        policeDTO.setApWeaponSerial(police.getApWeaponSerial());
        policeDTO.setApPresentAddress(police.getApPresentAddress());
        policeDTO.setApPermanentAddress(police.getApPermanentAddress());
        policeDTO.setApEmail(police.getApEmail());
        policeDTO.setApOfficePhone(police.getApOfficePhone());
        policeDTO.setApPersonalPhone(police.getApPersonalPhone());
        policeDTO.setApUserName(police.getApUserName());
        policeDTO.setApPassword(police.getApPassword());
        policeDTO.setApConfirmPassword(police.getApConfirmPassword());
        return policeDTO;
    }

    private Police mapToEntity(final PoliceDTO policeDTO, final Police police) {
        police.setApFirstName(policeDTO.getApFirstName());
        police.setApLastName(policeDTO.getApLastName());
        police.setApFatherName(policeDTO.getApFatherName());
        police.setApMotherName(policeDTO.getApMotherName());
        police.setApGender(policeDTO.getApGender());
        police.setApDoB(policeDTO.getApDoB());
        police.setApDepartmentId(policeDTO.getApDepartmentId());
        police.setApDepartmentType(policeDTO.getApDepartmentType());
        police.setApDistrictName(policeDTO.getApDistrictName());
        police.setApThanaName(policeDTO.getApThanaName());
        police.setApBatch(policeDTO.getApBatch());
        police.setApRank(policeDTO.getApRank());
        police.setApPlacementDate(policeDTO.getApPlacementDate());
        police.setApWeaponSerial(policeDTO.getApWeaponSerial());
        police.setApPresentAddress(policeDTO.getApPresentAddress());
        police.setApPermanentAddress(policeDTO.getApPermanentAddress());
        police.setApEmail(policeDTO.getApEmail());
        police.setApOfficePhone(policeDTO.getApOfficePhone());
        police.setApPersonalPhone(policeDTO.getApPersonalPhone());
        police.setApUserName(policeDTO.getApUserName());
        police.setApPassword(policeDTO.getApPassword());
        police.setApConfirmPassword(policeDTO.getApConfirmPassword());
        return police;
    }

}
