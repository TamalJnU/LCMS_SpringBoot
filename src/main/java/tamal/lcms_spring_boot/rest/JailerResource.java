package tamal.lcms_spring_boot.rest;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tamal.lcms_spring_boot.model.JailerDTO;
import tamal.lcms_spring_boot.service.JailerService;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RequestMapping(value = "/api/jailers", produces = MediaType.APPLICATION_JSON_VALUE)
public class JailerResource {

    private final JailerService jailerService;

    public JailerResource(final JailerService jailerService) {
        this.jailerService = jailerService;
    }

    @GetMapping
    public ResponseEntity<List<JailerDTO>> getAllJailers() {
        return ResponseEntity.ok(jailerService.findAll());
    }

    @GetMapping("/{ajailerJailerId}")
    public ResponseEntity<JailerDTO> getJailer(@PathVariable final Long ajailerJailerId) {
        return ResponseEntity.ok(jailerService.get(ajailerJailerId));
    }

    @PostMapping
    public ResponseEntity<Long> createJailer(@RequestBody @Valid final JailerDTO jailerDTO) {
        final Long createdAjailerJailerId = jailerService.create(jailerDTO);
        return new ResponseEntity<>(createdAjailerJailerId, HttpStatus.CREATED);
    }

    @PutMapping("/{ajailerJailerId}")
    public ResponseEntity<Void> updateJailer(@PathVariable final Long ajailerJailerId,
            @RequestBody @Valid final JailerDTO jailerDTO) {
        jailerService.update(ajailerJailerId, jailerDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{ajailerJailerId}")
    public ResponseEntity<Void> deleteJailer(@PathVariable final Long ajailerJailerId) {
        jailerService.delete(ajailerJailerId);
        return ResponseEntity.noContent().build();
    }

}
