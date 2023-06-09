package tamal.lcms_spring_boot.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tamal.lcms_spring_boot.domain.Jailer;
import tamal.lcms_spring_boot.model.JailerDTO;
import tamal.lcms_spring_boot.repos.JailerRepository;
import tamal.lcms_spring_boot.util.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class JailerService {

    private final JailerRepository jailerRepository;

    public JailerService(final JailerRepository jailerRepository) {
        this.jailerRepository = jailerRepository;
    }

    public List<JailerDTO> findAll() {
        final List<Jailer> jailers = jailerRepository.findAll(Sort.by("ajailerJailerId"));
        return jailers.stream()
                .map((jailer) -> mapToDTO(jailer, new JailerDTO()))
                .collect(Collectors.toList());  //.toList() cilo age
    }

    public JailerDTO get(final Long ajailerJailerId) {
        return jailerRepository.findById(ajailerJailerId)
                .map((jailer) -> mapToDTO(jailer, new JailerDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final JailerDTO jailerDTO) {
        final Jailer jailer = new Jailer();
        mapToEntity(jailerDTO, jailer);
        return jailerRepository.save(jailer).getAjailerJailerId();
    }

    public void update(final Long ajailerJailerId, final JailerDTO jailerDTO) {
        final Jailer jailer = jailerRepository.findById(ajailerJailerId)
                .orElseThrow(NotFoundException::new);
        mapToEntity(jailerDTO, jailer);
        jailerRepository.save(jailer);
    }

    public void delete(final Long ajailerJailerId) {
        jailerRepository.deleteById(ajailerJailerId);
    }

    private JailerDTO mapToDTO(final Jailer jailer, final JailerDTO jailerDTO) {
        jailerDTO.setAjailerJailerId(jailer.getAjailerJailerId());
        jailerDTO.setAjailerFirstName(jailer.getAjailerFirstName());
        jailerDTO.setAjailerLastName(jailer.getAjailerLastName());
        jailerDTO.setAjailerFatherName(jailer.getAjailerFatherName());
        jailerDTO.setAjailerMotherName(jailer.getAjailerMotherName());
        jailerDTO.setAjailerGender(jailer.getAjailerGender());
        jailerDTO.setAjailerDoB(jailer.getAjailerDoB());
        jailerDTO.setAjailerJailId(jailer.getAjailerJailId());
        jailerDTO.setAjailerPoliceId(jailer.getAjailerPoliceId());
        jailerDTO.setAjailerJailType(jailer.getAjailerJailType());
        jailerDTO.setAjailerJailCity(jailer.getAjailerJailCity());
        jailerDTO.setAjailerJailName(jailer.getAjailerJailName());
        jailerDTO.setAjailerPlacementDate(jailer.getAjailerPlacementDate());
        jailerDTO.setAjailerEmail(jailer.getAjailerEmail());
        jailerDTO.setAjailerOfficePhone(jailer.getAjailerOfficePhone());
        jailerDTO.setAjailerPersonalPhone(jailer.getAjailerPersonalPhone());
        jailerDTO.setAjailerPresentAddress(jailer.getAjailerPresentAddress());
        jailerDTO.setAjailerPermanentAddress(jailer.getAjailerPermanentAddress());
        jailerDTO.setAjailerUserName(jailer.getAjailerUserName());
        jailerDTO.setAjailerPassword(jailer.getAjailerPassword());
        jailerDTO.setAjailerConfirmPassword(jailer.getAjailerConfirmPassword());
        return jailerDTO;
    }

    private Jailer mapToEntity(final JailerDTO jailerDTO, final Jailer jailer) {
        jailer.setAjailerFirstName(jailerDTO.getAjailerFirstName());
        jailer.setAjailerLastName(jailerDTO.getAjailerLastName());
        jailer.setAjailerFatherName(jailerDTO.getAjailerFatherName());
        jailer.setAjailerMotherName(jailerDTO.getAjailerMotherName());
        jailer.setAjailerGender(jailerDTO.getAjailerGender());
        jailer.setAjailerDoB(jailerDTO.getAjailerDoB());
        jailer.setAjailerJailId(jailerDTO.getAjailerJailId());
        jailer.setAjailerPoliceId(jailerDTO.getAjailerPoliceId());
        jailer.setAjailerJailType(jailerDTO.getAjailerJailType());
        jailer.setAjailerJailCity(jailerDTO.getAjailerJailCity());
        jailer.setAjailerJailName(jailerDTO.getAjailerJailName());
        jailer.setAjailerPlacementDate(jailerDTO.getAjailerPlacementDate());
        jailer.setAjailerEmail(jailerDTO.getAjailerEmail());
        jailer.setAjailerOfficePhone(jailerDTO.getAjailerOfficePhone());
        jailer.setAjailerPersonalPhone(jailerDTO.getAjailerPersonalPhone());
        jailer.setAjailerPresentAddress(jailerDTO.getAjailerPresentAddress());
        jailer.setAjailerPermanentAddress(jailerDTO.getAjailerPermanentAddress());
        jailer.setAjailerUserName(jailerDTO.getAjailerUserName());
        jailer.setAjailerPassword(jailerDTO.getAjailerPassword());
        jailer.setAjailerConfirmPassword(jailerDTO.getAjailerConfirmPassword());
        return jailer;
    }

}
