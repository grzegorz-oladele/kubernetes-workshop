package pl.grzegorz.serwer.message;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static pl.grzegorz.serwer.message.DifficultyLevel.*;

@Component
@RequiredArgsConstructor
class WarmUp implements CommandLineRunner {

    private final ProgramingLanguageRepository repository;

    @Override
    public void run(String... args) {
        if (repository.findAll().isEmpty()) {
            repository.save(ProgramingLanguage.builder().name("Java").difficultyLevel(MEDIUM).build());
            repository.save(ProgramingLanguage.builder().name("Python").difficultyLevel(EASY).build());
            repository.save(ProgramingLanguage.builder().name("Ruby").difficultyLevel(MEDIUM).build());
            repository.save(ProgramingLanguage.builder().name("Scala").difficultyLevel(HARD).build());
        }
    }
}
