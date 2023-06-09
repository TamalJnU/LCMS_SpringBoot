package tamal.lcms_spring_boot.rest;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tamal.lcms_spring_boot.model.OperatorDTO;
import tamal.lcms_spring_boot.service.OperatorService;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RequestMapping(value = "/api/operators", produces = MediaType.APPLICATION_JSON_VALUE)
public class OperatorResource {

    private final OperatorService operatorService;

    public OperatorResource(final OperatorService operatorService) {
        this.operatorService = operatorService;
    }

    @GetMapping
    public ResponseEntity<List<OperatorDTO>> getAllOperators() {
        return ResponseEntity.ok(operatorService.findAll());
    }

    @GetMapping("/{aoOperatorId}")
    public ResponseEntity<OperatorDTO> getOperator(@PathVariable final Long aoOperatorId) {
        return ResponseEntity.ok(operatorService.get(aoOperatorId));
    }

    @PostMapping
    public ResponseEntity<Long> createOperator(@RequestBody @Valid final OperatorDTO operatorDTO) {
        final Long createdAoOperatorId = operatorService.create(operatorDTO);
        return new ResponseEntity<>(createdAoOperatorId, HttpStatus.CREATED);
    }

    @PutMapping("/{aoOperatorId}")
    public ResponseEntity<Void> updateOperator(@PathVariable final Long aoOperatorId,
            @RequestBody @Valid final OperatorDTO operatorDTO) {
        operatorService.update(aoOperatorId, operatorDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{aoOperatorId}")
    public ResponseEntity<Void> deleteOperator(@PathVariable final Long aoOperatorId) {
        operatorService.delete(aoOperatorId);
        return ResponseEntity.noContent().build();
    }

}
