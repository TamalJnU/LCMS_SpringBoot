package tamal.lcms_spring_boot.rest;

import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tamal.lcms_spring_boot.model.JudgeDTO;
import tamal.lcms_spring_boot.service.JudgeService;


@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RequestMapping(value = "/api/judges", produces = MediaType.APPLICATION_JSON_VALUE)
public class JudgeResource {

    private final JudgeService judgeService;

    public JudgeResource(final JudgeService judgeService) {
        this.judgeService = judgeService;
    }

    @GetMapping
    public ResponseEntity<List<JudgeDTO>> getAllJudges() {
        return ResponseEntity.ok(judgeService.findAll());
    }

    @GetMapping("/{ajJudgeId}")
    public ResponseEntity<JudgeDTO> getJudge(@PathVariable final Long ajJudgeId) {
        return ResponseEntity.ok(judgeService.get(ajJudgeId));
    }

    @PostMapping
    public ResponseEntity<Long> createJudge(@RequestBody @Valid final JudgeDTO judgeDTO) {
        final Long createdAjJudgeId = judgeService.create(judgeDTO);
        return new ResponseEntity<>(createdAjJudgeId, HttpStatus.CREATED);
    }

    @PutMapping("/{ajJudgeId}")
    public ResponseEntity<Void> updateJudge(@PathVariable final Long ajJudgeId,
            @RequestBody @Valid final JudgeDTO judgeDTO) {
        judgeService.update(ajJudgeId, judgeDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{ajJudgeId}")
    public ResponseEntity<Void> deleteJudge(@PathVariable final Long ajJudgeId) {
        judgeService.delete(ajJudgeId);
        return ResponseEntity.noContent().build();
    }

}
