package pl.grzegorz.serwer.message;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class ProgramingLanguageService {

    private final ProgramingLanguageRepository programingLanguageRepository;

    List<ProgramingLanguage> getAllLanguages() {
        return programingLanguageRepository.findAll();
    }

    ProgramingLanguage getLanguageById(long languageId) {
        return programingLanguageRepository.findById(languageId)
                .orElseThrow(() -> new IllegalArgumentException("Message not found"));
    }

    void createLanguage(ProgramingLanguageDto dto) {
        ProgramingLanguage programingLanguage = ProgramingLanguage.builder()
                .name(dto.getName())
                .difficultyLevel(DifficultyLevel.valueOf(dto.getDifficultyLevel()))
                .build();
        programingLanguageRepository.save(programingLanguage);
    }

    void deleteLanguage(long languageId) {
        programingLanguageRepository.deleteById(languageId);
    }
}