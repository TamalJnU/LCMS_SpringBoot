package tamal.lcms_spring_boot.rest;

import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tamal.lcms_spring_boot.model.PpDTO;
import tamal.lcms_spring_boot.service.PpService;


@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RequestMapping(value = "/api/pps", produces = MediaType.APPLICATION_JSON_VALUE)
public class PpResource {

    private final PpService ppService;

    public PpResource(final PpService ppService) {
        this.ppService = ppService;
    }

    @GetMapping
    public ResponseEntity<List<PpDTO>> getAllPps() {
        return ResponseEntity.ok(ppService.findAll());
    }

    @GetMapping("/{appPpId}")
    public ResponseEntity<PpDTO> getPp(@PathVariable final Long appPpId) {
        return ResponseEntity.ok(ppService.get(appPpId));
    }

    @PostMapping
    public ResponseEntity<Long> createPp(@RequestBody @Valid final PpDTO ppDTO) {
        final Long createdAppPpId = ppService.create(ppDTO);
        return new ResponseEntity<>(createdAppPpId, HttpStatus.CREATED);
    }

    @PutMapping("/{appPpId}")
    public ResponseEntity<Void> updatePp(@PathVariable final Long appPpId,
            @RequestBody @Valid final PpDTO ppDTO) {
        ppService.update(appPpId, ppDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{appPpId}")
    public ResponseEntity<Void> deletePp(@PathVariable final Long appPpId) {
        ppService.delete(appPpId);
        return ResponseEntity.noContent().build();
    }

}
