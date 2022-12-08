package cog.caseStudy.roshan.QnAportal.springQnAportal.controller;

import cog.caseStudy.roshan.QnAportal.springQnAportal.dto.SubQnADto;
import cog.caseStudy.roshan.QnAportal.springQnAportal.service.SubQnAService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subQnA")
@AllArgsConstructor
@Slf4j
public class SubQnAController {

    private final SubQnAService subQnAService;

    @PostMapping
    public ResponseEntity<SubQnADto> createSubQnA(@RequestBody SubQnADto subQnADto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(subQnAService.save(subQnADto));
    }

    @GetMapping
    public ResponseEntity<List<SubQnADto>> getAllSubQnAs() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(subQnAService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubQnADto> getSubQnA(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(subQnAService.getSubQnA(id));
    }
}
