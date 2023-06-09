package tamal.lcms_spring_boot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tamal.lcms_spring_boot.domain.Judge;
import tamal.lcms_spring_boot.model.JudgeDTO;
import tamal.lcms_spring_boot.repos.JudgeRepository;
import tamal.lcms_spring_boot.util.NotFoundException;


@Service
public class JudgeService {

    private final JudgeRepository judgeRepository;

    public JudgeService(final JudgeRepository judgeRepository) {
        this.judgeRepository = judgeRepository;
    }

    public List<JudgeDTO> findAll() {
        final List<Judge> judges = judgeRepository.findAll(Sort.by("ajJudgeId"));
        return judges.stream()
                .map((judge) -> mapToDTO(judge, new JudgeDTO()))
                .collect(Collectors.toList());  //.toList() cilo age
    }

    public JudgeDTO get(final Long ajJudgeId) {
        return judgeRepository.findById(ajJudgeId)
                .map((judge) -> mapToDTO(judge, new JudgeDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final JudgeDTO judgeDTO) {
        final Judge judge = new Judge();
        mapToEntity(judgeDTO, judge);
        return judgeRepository.save(judge).getAjJudgeId();
    }

    public void update(final Long ajJudgeId, final JudgeDTO judgeDTO) {
        final Judge judge = judgeRepository.findById(ajJudgeId)
                .orElseThrow(NotFoundException::new);
        mapToEntity(judgeDTO, judge);
        judgeRepository.save(judge);
    }

    public void delete(final Long ajJudgeId) {
        judgeRepository.deleteById(ajJudgeId);
    }

    private JudgeDTO mapToDTO(final Judge judge, final JudgeDTO judgeDTO) {
        judgeDTO.setAjJudgeId(judge.getAjJudgeId());
        judgeDTO.setAjFirstName(judge.getAjFirstName());
        judgeDTO.setAjLastName(judge.getAjLastName());
        judgeDTO.setAjFatherName(judge.getAjFatherName());
        judgeDTO.setAjMotherName(judge.getAjMotherName());
        judgeDTO.setAjGender(judge.getAjGender());
        judgeDTO.setAjDoB(judge.getAjDoB());
        judgeDTO.setAjCourtId(judge.getAjCourtId());
        judgeDTO.setAjCourtType(judge.getAjCourtType());
        judgeDTO.setAjCourtCity(judge.getAjCourtCity());
        judgeDTO.setAjCourtName(judge.getAjCourtName());
        judgeDTO.setAjCourtNo(judge.getAjCourtNo());
        judgeDTO.setAjTribunalName(judge.getAjTribunalName());
        judgeDTO.setAjChiefJustice(judge.getAjChiefJustice());
        judgeDTO.setAjChiefJusticeId(judge.getAjChiefJusticeId());
        judgeDTO.setAjPlacementDate(judge.getAjPlacementDate());
        judgeDTO.setAjEmail(judge.getAjEmail());
        judgeDTO.setAjOfficePhone(judge.getAjOfficePhone());
        judgeDTO.setAjPersonalPhone(judge.getAjPersonalPhone());
        judgeDTO.setAjPresentAddress(judge.getAjPresentAddress());
        judgeDTO.setAjPermanentAddress(judge.getAjPermanentAddress());
        judgeDTO.setAjUserName(judge.getAjUserName());
        judgeDTO.setAjPassword(judge.getAjPassword());
        judgeDTO.setAjConfirmPassword(judge.getAjConfirmPassword());
        return judgeDTO;
    }

    private Judge mapToEntity(final JudgeDTO judgeDTO, final Judge judge) {
        judge.setAjFirstName(judgeDTO.getAjFirstName());
        judge.setAjLastName(judgeDTO.getAjLastName());
        judge.setAjFatherName(judgeDTO.getAjFatherName());
        judge.setAjMotherName(judgeDTO.getAjMotherName());
        judge.setAjGender(judgeDTO.getAjGender());
        judge.setAjDoB(judgeDTO.getAjDoB());
        judge.setAjCourtId(judgeDTO.getAjCourtId());
        judge.setAjCourtType(judgeDTO.getAjCourtType());
        judge.setAjCourtCity(judgeDTO.getAjCourtCity());
        judge.setAjCourtName(judgeDTO.getAjCourtName());
        judge.setAjCourtNo(judgeDTO.getAjCourtNo());
        judge.setAjTribunalName(judgeDTO.getAjTribunalName());
        judge.setAjChiefJustice(judgeDTO.getAjChiefJustice());
        judge.setAjChiefJusticeId(judgeDTO.getAjChiefJusticeId());
        judge.setAjPlacementDate(judgeDTO.getAjPlacementDate());
        judge.setAjEmail(judgeDTO.getAjEmail());
        judge.setAjOfficePhone(judgeDTO.getAjOfficePhone());
        judge.setAjPersonalPhone(judgeDTO.getAjPersonalPhone());
        judge.setAjPresentAddress(judgeDTO.getAjPresentAddress());
        judge.setAjPermanentAddress(judgeDTO.getAjPermanentAddress());
        judge.setAjUserName(judgeDTO.getAjUserName());
        judge.setAjPassword(judgeDTO.getAjPassword());
        judge.setAjConfirmPassword(judgeDTO.getAjConfirmPassword());
        return judge;
    }

}
