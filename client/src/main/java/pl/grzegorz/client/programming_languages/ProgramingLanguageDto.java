package pl.grzegorz.client.programming_languages;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class ProgramingLanguageDto {

    private long id;
    private String name;
    private String difficultyLevel;
}