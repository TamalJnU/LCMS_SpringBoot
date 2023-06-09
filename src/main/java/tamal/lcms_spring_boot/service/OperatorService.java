package tamal.lcms_spring_boot.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tamal.lcms_spring_boot.domain.Operator;
import tamal.lcms_spring_boot.model.OperatorDTO;
import tamal.lcms_spring_boot.repos.OperatorRepository;
import tamal.lcms_spring_boot.util.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class OperatorService {

    private final OperatorRepository operatorRepository;

    public OperatorService(final OperatorRepository operatorRepository) {
        this.operatorRepository = operatorRepository;
    }

    public List<OperatorDTO> findAll() {
        final List<Operator> operators = operatorRepository.findAll(Sort.by("aoOperatorId"));
        return operators.stream()
                .map((operator) -> mapToDTO(operator, new OperatorDTO()))
                .collect(Collectors.toList());   //.toList() cilo age
    }

    public OperatorDTO get(final Long aoOperatorId) {
        return operatorRepository.findById(aoOperatorId)
                .map((operator) -> mapToDTO(operator, new OperatorDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final OperatorDTO operatorDTO) {
        final Operator operator= new Operator();
        mapToEntity(operatorDTO, operator);
        return operatorRepository.save(operator).getAoOperatorId();
    }

    public void update(final Long aoOperatorId, final OperatorDTO operatorDTO) {
        final Operator operator = operatorRepository.findById(aoOperatorId)
                .orElseThrow(NotFoundException::new);
        mapToEntity(operatorDTO, operator);
        operatorRepository.save(operator);
    }

    public void delete(final Long aoOperatorId) {
        operatorRepository.deleteById(aoOperatorId);
    }

    private OperatorDTO mapToDTO(final Operator operator, final OperatorDTO operatorDTO) {
        operatorDTO.setAoOperatorId(operator.getAoOperatorId());
        operatorDTO.setAoOperatorOf(operator.getAoOperatorOf());
        operatorDTO.setAoFirstName(operator.getAoFirstName());
        operatorDTO.setAoLastName(operator.getAoLastName());
        operatorDTO.setAoFatherName(operator.getAoFatherName());
        operatorDTO.setAoMotherName(operator.getAoMotherName());
        operatorDTO.setAoGender(operator.getAoGender());
        operatorDTO.setAoDoB(operator.getAoDoB());
        operatorDTO.setAoDepartmentId(operator.getAoDepartmentId());
        operatorDTO.setAoDepartmentType(operator.getAoDepartmentType());
        operatorDTO.setAoDistrictName(operator.getAoDistrictName());
        operatorDTO.setAoThanaName(operator.getAoThanaName());
        operatorDTO.setAoBatch(operator.getAoBatch());
        operatorDTO.setAoRank(operator.getAoRank());
        operatorDTO.setAoPlacementDate(operator.getAoPlacementDate());
        operatorDTO.setAoWeaponSerial(operator.getAoWeaponSerial());
        operatorDTO.setAoPresentAddress(operator.getAoPresentAddress());
        operatorDTO.setAoPermanentAddress(operator.getAoPermanentAddress());
        operatorDTO.setAoEmail(operator.getAoEmail());
        operatorDTO.setAoOfficePhone(operator.getAoOfficePhone());
        operatorDTO.setAoPersonalPhone(operator.getAoPersonalPhone());
        operatorDTO.setAoUserName(operator.getAoUserName());
        operatorDTO.setAoPassword(operator.getAoPassword());
        operatorDTO.setAoConfirmPassword(operator.getAoConfirmPassword());
        return operatorDTO;
    }

    private Operator mapToEntity(final OperatorDTO operatorDTO, final Operator operator) {
        operator.setAoOperatorOf(operatorDTO.getAoOperatorOf());
        operator.setAoFirstName(operatorDTO.getAoFirstName());
        operator.setAoLastName(operatorDTO.getAoLastName());
        operator.setAoFatherName(operatorDTO.getAoFatherName());
        operator.setAoMotherName(operatorDTO.getAoMotherName());
        operator.setAoGender(operatorDTO.getAoGender());
        operator.setAoDoB(operatorDTO.getAoDoB());
        operator.setAoDepartmentId(operatorDTO.getAoDepartmentId());
        operator.setAoDepartmentType(operatorDTO.getAoDepartmentType());
        operator.setAoDistrictName(operatorDTO.getAoDistrictName());
        operator.setAoThanaName(operatorDTO.getAoThanaName());
        operator.setAoBatch(operatorDTO.getAoBatch());
        operator.setAoRank(operatorDTO.getAoRank());
        operator.setAoPlacementDate(operatorDTO.getAoPlacementDate());
        operator.setAoWeaponSerial(operatorDTO.getAoWeaponSerial());
        operator.setAoPresentAddress(operatorDTO.getAoPresentAddress());
        operator.setAoPermanentAddress(operatorDTO.getAoPermanentAddress());
        operator.setAoEmail(operatorDTO.getAoEmail());
        operator.setAoOfficePhone(operatorDTO.getAoOfficePhone());
        operator.setAoPersonalPhone(operatorDTO.getAoPersonalPhone());
        operator.setAoUserName(operatorDTO.getAoUserName());
        operator.setAoPassword(operatorDTO.getAoPassword());
        operator.setAoConfirmPassword(operatorDTO.getAoConfirmPassword());
        return operator;
    }

}
