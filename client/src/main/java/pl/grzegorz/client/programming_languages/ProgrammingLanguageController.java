package pl.grzegorz.client.programming_languages;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/programming-languages")
@RequiredArgsConstructor
class ProgrammingLanguageController {

    private final ProgramingLanguageService programingLanguageService;

    @GetMapping
    List<ProgramingLanguageDto> getAllLanguages() {
        return programingLanguageService.getAllMessages();
    }

    @GetMapping("/names")
    List<String> getAllLanguagesNames() {
        return programingLanguageService.getAllLanguagesNames();
    }

    @GetMapping("/{languageId}")
    ProgramingLanguageDto getLanguageById(@PathVariable long languageId) {
        return programingLanguageService.getLanguageById(languageId);
    }

    @PostMapping
    void createLanguage(@RequestBody ProgrammingLanguageDto programmingLanguageDto) {
        programingLanguageService.createLanguage(programmingLanguageDto);
    }

    @DeleteMapping("/{languageId}")
    void removeLanguageById(@PathVariable long languageId) {
        programingLanguageService.removeLanguage(languageId);
    }
}