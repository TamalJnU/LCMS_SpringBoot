package tamal.lcms_spring_boot.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tamal.lcms_spring_boot.domain.Jail;
import tamal.lcms_spring_boot.model.JailDTO;
import tamal.lcms_spring_boot.repos.JailRepository;
import tamal.lcms_spring_boot.util.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class JailService {

    private final JailRepository jailRepository;

    public JailService(final JailRepository jailRepository) {
        this.jailRepository = jailRepository;
    }

    public List<JailDTO> findAll() {
        final List<Jail> jails = jailRepository.findAll(Sort.by("ajailJailId"));
        return jails.stream()
                .map((jail) -> mapToDTO(jail, new JailDTO()))
                .collect(Collectors.toList());  //.toList() cilo age
    }

    public JailDTO get(final Long ajailJailId) {
        return jailRepository.findById(ajailJailId)
                .map((jail) -> mapToDTO(jail, new JailDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final JailDTO jailDTO) {
        final Jail jail = new Jail();
        mapToEntity(jailDTO, jail);
        return jailRepository.save(jail).getAjailJailId();
    }

    public void update(final Long ajailJailId, final JailDTO jailDTO) {
        final Jail jail = jailRepository.findById(ajailJailId)
                .orElseThrow(NotFoundException::new);
        mapToEntity(jailDTO, jail);
        jailRepository.save(jail);
    }

    public void delete(final Long ajailJailId) {
        jailRepository.deleteById(ajailJailId);
    }

    private JailDTO mapToDTO(final Jail jail, final JailDTO jailDTO) {
        jailDTO.setAjailJailId(jail.getAjailJailId());
        jailDTO.setAjailJailName(jail.getAjailJailName());
        jailDTO.setAjailJailType(jail.getAjailJailType());
        jailDTO.setAjailJailCity(jail.getAjailJailCity());
        jailDTO.setAjailJailSuperName(jail.getAjailJailSuperName());
        jailDTO.setAjailJailSuperPoliceId(jail.getAjailJailSuperPoliceId());
        jailDTO.setAjailJailEmail(jail.getAjailJailEmail());
        jailDTO.setAjailOfficePhone(jail.getAjailOfficePhone());
        jailDTO.setAjailJailSuperPhone(jail.getAjailJailSuperPhone());
        jailDTO.setAjailUserName(jail.getAjailUserName());
        jailDTO.setAjailPassword(jail.getAjailPassword());
        jailDTO.setAjailConfirmPassword(jail.getAjailConfirmPassword());
        return jailDTO;
    }

    private Jail mapToEntity(final JailDTO jailDTO, final Jail jail) {
        jail.setAjailJailName(jailDTO.getAjailJailName());
        jail.setAjailJailType(jailDTO.getAjailJailType());
        jail.setAjailJailCity(jailDTO.getAjailJailCity());
        jail.setAjailJailSuperName(jailDTO.getAjailJailSuperName());
        jail.setAjailJailSuperPoliceId(jailDTO.getAjailJailSuperPoliceId());
        jail.setAjailJailEmail(jailDTO.getAjailJailEmail());
        jail.setAjailOfficePhone(jailDTO.getAjailOfficePhone());
        jail.setAjailJailSuperPhone(jailDTO.getAjailJailSuperPhone());
        jail.setAjailUserName(jailDTO.getAjailUserName());
        jail.setAjailPassword(jailDTO.getAjailPassword());
        jail.setAjailConfirmPassword(jailDTO.getAjailConfirmPassword());
        return jail;
    }

}
