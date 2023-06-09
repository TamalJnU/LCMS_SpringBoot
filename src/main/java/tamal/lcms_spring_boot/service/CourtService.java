package tamal.lcms_spring_boot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tamal.lcms_spring_boot.domain.Court;
import tamal.lcms_spring_boot.model.CourtDTO;
import tamal.lcms_spring_boot.repos.CourtRepository;
import tamal.lcms_spring_boot.util.NotFoundException;


@Service
public class CourtService {

    private final CourtRepository courtRepository;

    public CourtService(final CourtRepository courtRepository) {
        this.courtRepository = courtRepository;
    }

    public List<CourtDTO> findAll() {
        final List<Court> courts = courtRepository.findAll(Sort.by("acCourtId"));
        return courts.stream()
                .map((court) -> mapToDTO(court, new CourtDTO()))
                .collect(Collectors.toList());  //.toList() cilo age
    }

    public CourtDTO get(final Long acCourtId) {
        return courtRepository.findById(acCourtId)
                .map((court) -> mapToDTO(court, new CourtDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final CourtDTO courtDTO) {
        final Court court = new Court();
        mapToEntity(courtDTO, court);
        return courtRepository.save(court).getAcCourtId();
    }

    public void update(final Long acCourtId, final CourtDTO courtDTO) {
        final Court court = courtRepository.findById(acCourtId)
                .orElseThrow(NotFoundException::new);
        mapToEntity(courtDTO, court);
        courtRepository.save(court);
    }

    public void delete(final Long acCourtId) {
        courtRepository.deleteById(acCourtId);
    }

    private CourtDTO mapToDTO(final Court court, final CourtDTO courtDTO) {
        courtDTO.setAcCourtId(court.getAcCourtId());
        courtDTO.setAcCourtType(court.getAcCourtType());
        courtDTO.setAcCourtCity(court.getAcCourtCity());
        courtDTO.setAcCourtName(court.getAcCourtName());
        courtDTO.setAcCourtNo(court.getAcCourtNo());
        courtDTO.setAcTribunalName(court.getAcTribunalName());
        courtDTO.setAcChiefJustice(court.getAcChiefJustice());
        courtDTO.setAcChiefJusticeId(court.getAcChiefJusticeId());
        courtDTO.setAcPublicProsecutor(court.getAcPublicProsecutor());
        courtDTO.setAcPublicProsecutorId(court.getAcPublicProsecutorId());
        courtDTO.setAcEmail(court.getAcEmail());
        courtDTO.setAcCourtPhone(court.getAcCourtPhone());
        courtDTO.setAcUserName(court.getAcUserName());
        courtDTO.setAcPassword(court.getAcPassword());
        courtDTO.setAcConfirmPassword(court.getAcConfirmPassword());
        return courtDTO;
    }

    private Court mapToEntity(final CourtDTO courtDTO, final Court court) {
        court.setAcCourtType(courtDTO.getAcCourtType());
        court.setAcCourtCity(courtDTO.getAcCourtCity());
        court.setAcCourtName(courtDTO.getAcCourtName());
        court.setAcCourtNo(courtDTO.getAcCourtNo());
        court.setAcTribunalName(courtDTO.getAcTribunalName());
        court.setAcChiefJustice(courtDTO.getAcChiefJustice());
        court.setAcChiefJusticeId(courtDTO.getAcChiefJusticeId());
        court.setAcPublicProsecutor(courtDTO.getAcPublicProsecutor());
        court.setAcPublicProsecutorId(courtDTO.getAcPublicProsecutorId());
        court.setAcEmail(courtDTO.getAcEmail());
        court.setAcCourtPhone(courtDTO.getAcCourtPhone());
        court.setAcUserName(courtDTO.getAcUserName());
        court.setAcPassword(courtDTO.getAcPassword());
        court.setAcConfirmPassword(courtDTO.getAcConfirmPassword());
        return court;
    }

}
