package pl.grzegorz.serwer.languages;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class ProgramingLanguageDto {

    private String name;
    private String difficultyLevel;
}
