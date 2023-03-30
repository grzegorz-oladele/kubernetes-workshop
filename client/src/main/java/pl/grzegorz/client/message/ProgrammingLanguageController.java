package pl.grzegorz.client.message;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
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
    void createLanguage(@RequestBody LanguageDto languageDto) {
        programingLanguageService.createLanguage(languageDto);
    }

    @DeleteMapping("/{languageId}")
    void removeLanguageById(@PathVariable long languageId) {
        programingLanguageService.removeLanguage(languageId);
    }
}