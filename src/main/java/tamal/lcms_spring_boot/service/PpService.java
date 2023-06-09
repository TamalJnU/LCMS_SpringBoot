package tamal.lcms_spring_boot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tamal.lcms_spring_boot.domain.Pp;
import tamal.lcms_spring_boot.model.PpDTO;
import tamal.lcms_spring_boot.repos.PpRepository;
import tamal.lcms_spring_boot.util.NotFoundException;


@Service
public class PpService {

    private final PpRepository ppRepository;

    public PpService(final PpRepository ppRepository) {
        this.ppRepository = ppRepository;
    }

    public List<PpDTO> findAll() {
        final List<Pp> pps = ppRepository.findAll(Sort.by("appPpId"));
        return pps.stream()
                .map((pp) -> mapToDTO(pp, new PpDTO()))
                .collect(Collectors.toList());    //.toList() cilo age
    }

    public PpDTO get(final Long appPpId) {
        return ppRepository.findById(appPpId)
                .map((pp) -> mapToDTO(pp, new PpDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final PpDTO ppDTO) {
        final Pp pp = new Pp();
        mapToEntity(ppDTO, pp);
        return ppRepository.save(pp).getAppPpId();
    }

    public void update(final Long appPpId, final PpDTO ppDTO) {
        final Pp pp = ppRepository.findById(appPpId)
                .orElseThrow(NotFoundException::new);
        mapToEntity(ppDTO, pp);
        ppRepository.save(pp);
    }

    public void delete(final Long appPpId) {
        ppRepository.deleteById(appPpId);
    }

    private PpDTO mapToDTO(final Pp pp, final PpDTO ppDTO) {
        ppDTO.setAppPpId(pp.getAppPpId());
        ppDTO.setAppFirstName(pp.getAppFirstName());
        ppDTO.setAppLastName(pp.getAppLastName());
        ppDTO.setAppFatherName(pp.getAppFatherName());
        ppDTO.setAppMotherName(pp.getAppMotherName());
        ppDTO.setAppGender(pp.getAppGender());
        ppDTO.setAppDoB(pp.getAppDoB());
        ppDTO.setAppCourtId(pp.getAppCourtId());
        ppDTO.setAppCourtType(pp.getAppCourtType());
        ppDTO.setAppCourtCity(pp.getAppCourtCity());
        ppDTO.setAppCourtName(pp.getAppCourtName());
        ppDTO.setAppCourtNo(pp.getAppCourtNo());
        ppDTO.setAppTribunalName(pp.getAppTribunalName());
        ppDTO.setAppChiefJustice(pp.getAppChiefJustice());
        ppDTO.setAppChiefJusticeId(pp.getAppChiefJusticeId());
        ppDTO.setAppPlacementDate(pp.getAppPlacementDate());
        ppDTO.setAppEmail(pp.getAppEmail());
        ppDTO.setAppOfficePhone(pp.getAppOfficePhone());
        ppDTO.setAppPersonalPhone(pp.getAppPersonalPhone());
        ppDTO.setAppPresentAddress(pp.getAppPresentAddress());
        ppDTO.setAppPermanentAddress(pp.getAppPermanentAddress());
        ppDTO.setAppUserName(pp.getAppUserName());
        ppDTO.setAppPassword(pp.getAppPassword());
        ppDTO.setAppConfirmPassword(pp.getAppConfirmPassword());
        return ppDTO;
    }

    private Pp mapToEntity(final PpDTO ppDTO, final Pp pp) {
        pp.setAppFirstName(ppDTO.getAppFirstName());
        pp.setAppLastName(ppDTO.getAppLastName());
        pp.setAppFatherName(ppDTO.getAppFatherName());
        pp.setAppMotherName(ppDTO.getAppMotherName());
        pp.setAppGender(ppDTO.getAppGender());
        pp.setAppDoB(ppDTO.getAppDoB());
        pp.setAppCourtId(ppDTO.getAppCourtId());
        pp.setAppCourtType(ppDTO.getAppCourtType());
        pp.setAppCourtCity(ppDTO.getAppCourtCity());
        pp.setAppCourtName(ppDTO.getAppCourtName());
        pp.setAppCourtNo(ppDTO.getAppCourtNo());
        pp.setAppTribunalName(ppDTO.getAppTribunalName());
        pp.setAppChiefJustice(ppDTO.getAppChiefJustice());
        pp.setAppChiefJusticeId(ppDTO.getAppChiefJusticeId());
        pp.setAppPlacementDate(ppDTO.getAppPlacementDate());
        pp.setAppEmail(ppDTO.getAppEmail());
        pp.setAppOfficePhone(ppDTO.getAppOfficePhone());
        pp.setAppPersonalPhone(ppDTO.getAppPersonalPhone());
        pp.setAppPresentAddress(ppDTO.getAppPresentAddress());
        pp.setAppPermanentAddress(ppDTO.getAppPermanentAddress());
        pp.setAppUserName(ppDTO.getAppUserName());
        pp.setAppPassword(ppDTO.getAppPassword());
        pp.setAppConfirmPassword(ppDTO.getAppConfirmPassword());
        return pp;
    }

}
