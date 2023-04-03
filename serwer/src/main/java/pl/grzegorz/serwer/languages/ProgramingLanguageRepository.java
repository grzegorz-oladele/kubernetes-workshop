package pl.grzegorz.serwer.languages;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ProgramingLanguageRepository extends JpaRepository<ProgramingLanguage, Long> {
}
