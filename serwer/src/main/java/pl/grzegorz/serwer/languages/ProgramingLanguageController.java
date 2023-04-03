package pl.grzegorz.serwer.languages;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/languages")
class ProgramingLanguageController {

    private final ProgramingLanguageService programingLanguageService;

    @GetMapping
    List<ProgramingLanguage> getAllLanguages() {
        return programingLanguageService.getAllLanguages();
    }

    @GetMapping("/{messageId}")
    ProgramingLanguage getLanguageById(@PathVariable long messageId) {
        return programingLanguageService.getLanguageById(messageId);
    }

    @PostMapping
    void createLanguage(@RequestBody ProgramingLanguageDto programingLanguageDto) {
        programingLanguageService.createLanguage(programingLanguageDto);
    }

    @DeleteMapping("/{languageId}")
    void removeLanguageById(@PathVariable long languageId) {
        programingLanguageService.deleteLanguage(languageId);
    }
}