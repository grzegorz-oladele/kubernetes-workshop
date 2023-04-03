package pl.grzegorz.client.programing_languages;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class ProgrammingLanguageDto {

    private String name;
    private String difficultyLevel;
}