package tamal.lcms_spring_boot.rest;

import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tamal.lcms_spring_boot.model.PoliceDTO;
import tamal.lcms_spring_boot.service.PoliceService;


@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RequestMapping(value = "/api/polices", produces = MediaType.APPLICATION_JSON_VALUE)
public class PoliceResource {

    private final PoliceService policeService;

    public PoliceResource(final PoliceService policeService) {
        this.policeService = policeService;
    }

    @GetMapping
    public ResponseEntity<List<PoliceDTO>> getAllPolices() {
        return ResponseEntity.ok(policeService.findAll());
    }

    @GetMapping("/{apPoliceId}")
    public ResponseEntity<PoliceDTO> getPolice(@PathVariable final Long apPoliceId) {
        return ResponseEntity.ok(policeService.get(apPoliceId));
    }

    @PostMapping
    public ResponseEntity<Long> createPolice(@RequestBody @Valid final PoliceDTO policeDTO) {
        final Long createdApPoliceId = policeService.create(policeDTO);
        return new ResponseEntity<>(createdApPoliceId, HttpStatus.CREATED);
    }

    @PutMapping("/{apPoliceId}")
    public ResponseEntity<Void> updatePolice(@PathVariable final Long apPoliceId,
            @RequestBody @Valid final PoliceDTO policeDTO) {
        policeService.update(apPoliceId, policeDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{apPoliceId}")
    public ResponseEntity<Void> deletePolice(@PathVariable final Long apPoliceId) {
        policeService.delete(apPoliceId);
        return ResponseEntity.noContent().build();
    }

}
