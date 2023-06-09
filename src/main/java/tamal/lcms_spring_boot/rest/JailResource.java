package tamal.lcms_spring_boot.rest;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tamal.lcms_spring_boot.model.JailDTO;
import tamal.lcms_spring_boot.service.JailService;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RequestMapping(value = "/api/jails", produces = MediaType.APPLICATION_JSON_VALUE)
public class JailResource {

    private final JailService jailService;

    public JailResource(final JailService jailService) {
        this.jailService = jailService;
    }

    @GetMapping
    public ResponseEntity<List<JailDTO>> getAllJails() {
        return ResponseEntity.ok(jailService.findAll());
    }

    @GetMapping("/{ajailJailId}")
    public ResponseEntity<JailDTO> getJail(@PathVariable final Long ajailJailId) {
        return ResponseEntity.ok(jailService.get(ajailJailId));
    }

    @PostMapping
    public ResponseEntity<Long> createJail(@RequestBody @Valid final JailDTO jailDTO) {
        final Long createdAjailJailId = jailService.create(jailDTO);
        return new ResponseEntity<>(createdAjailJailId, HttpStatus.CREATED);
    }

    @PutMapping("/{ajailJailId}")
    public ResponseEntity<Void> updateJail(@PathVariable final Long ajailJailId,
            @RequestBody @Valid final JailDTO jailDTO) {
        jailService.update(ajailJailId, jailDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{ajailJailId}")
    public ResponseEntity<Void> deleteJail(@PathVariable final Long ajailJailId) {
        jailService.delete(ajailJailId);
        return ResponseEntity.noContent().build();
    }

}
