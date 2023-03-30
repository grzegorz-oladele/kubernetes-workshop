package pl.grzegorz.client.message;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
class ProgramingLanguageService {

    private static final String URL = "http://localhost:8181/languages";

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    List<ProgramingLanguageDto> getAllMessages() {
        return getMessagesFromExistingService();
    }

    List<String> getAllLanguagesNames() {
        return getMessagesFromExistingService()
                .stream()
                .map(ProgramingLanguageDto::getName)
                .toList();
    }

    ProgramingLanguageDto getLanguageById(long languageId) {
        return getMessageByIdFromExistingValue(languageId);
    }

    void createLanguage(LanguageDto languageDto) {
        createLanguageDto(languageDto);
    }

    void removeLanguage(long languageId) {
        deleteLanguageById(languageId);
    }

    private List<ProgramingLanguageDto> getMessagesFromExistingService() {
        ProgramingLanguageDto[] messageList = restTemplate.getForObject(URL, ProgramingLanguageDto[].class);
        return objectMapper.convertValue(messageList, new TypeReference<>() {
        });
    }

    private ProgramingLanguageDto getMessageByIdFromExistingValue(long messageId) {
        ProgramingLanguageDto message = restTemplate.getForObject(URL + "/" + messageId, ProgramingLanguageDto.class);
        return objectMapper.convertValue(message, ProgramingLanguageDto.class);
    }

    private void createLanguageDto(LanguageDto languageDto) {
        restTemplate.postForObject(URL, languageDto, LanguageDto.class);
    }

    private void deleteLanguageById(long languageId) {
        restTemplate.delete(URL + "/" + languageId);
    }
}