package tamal.lcms_spring_boot.rest;

import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tamal.lcms_spring_boot.model.CourtDTO;
import tamal.lcms_spring_boot.service.CourtService;


@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RequestMapping(value = "/api/courts", produces = MediaType.APPLICATION_JSON_VALUE)
public class CourtResource {

    private final CourtService courtService;

    public CourtResource(final CourtService courtService) {
        this.courtService = courtService;
    }

    @GetMapping
    public ResponseEntity<List<CourtDTO>> getAllCourts() {
        return ResponseEntity.ok(courtService.findAll());
    }

    @GetMapping("/{acCourtId}")
    public ResponseEntity<CourtDTO> getCourt(@PathVariable final Long acCourtId) {
        return ResponseEntity.ok(courtService.get(acCourtId));
    }

    @PostMapping
    public ResponseEntity<Long> createCourt(@RequestBody @Valid final CourtDTO courtDTO) {
        final Long createdAcCourtId = courtService.create(courtDTO);
        return new ResponseEntity<>(createdAcCourtId, HttpStatus.CREATED);
    }

    @PutMapping("/{acCourtId}")
    public ResponseEntity<Void> updateCourt(@PathVariable final Long acCourtId,
            @RequestBody @Valid final CourtDTO courtDTO) {
        courtService.update(acCourtId, courtDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{acCourtId}")
    public ResponseEntity<Void> deleteCourt(@PathVariable final Long acCourtId) {
        courtService.delete(acCourtId);
        return ResponseEntity.noContent().build();
    }

}
