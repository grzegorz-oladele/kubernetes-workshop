package pl.grzegorz.serwer.languages;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.EnumType.STRING;

@Entity
@Table(name = "programing_languages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
class ProgramingLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(STRING)
    private DifficultyLevel difficultyLevel;
}