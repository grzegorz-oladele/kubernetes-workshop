package pl.grzegorz.client.message;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
class ProgramingLanguageService {
    private final String url;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public ProgramingLanguageService(RestTemplate restTemplate, ObjectMapper objectMapper,
                                     @Value("${rest-template.host}") String address) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
        this.url = "http://" + address + ":8181/languages";
    }

    List<ProgramingLanguageDto> getAllMessages() {
        log.info(url);
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
        ProgramingLanguageDto[] messageList = restTemplate.getForObject(url, ProgramingLanguageDto[].class);
        return objectMapper.convertValue(messageList, new TypeReference<>() {
        });
    }

    private ProgramingLanguageDto getMessageByIdFromExistingValue(long messageId) {
        ProgramingLanguageDto message = restTemplate.getForObject(url + "/" + messageId, ProgramingLanguageDto.class);
        return objectMapper.convertValue(message, ProgramingLanguageDto.class);
    }

    private void createLanguageDto(LanguageDto languageDto) {
        restTemplate.postForObject(url, languageDto, LanguageDto.class);
    }

    private void deleteLanguageById(long languageId) {
        restTemplate.delete(url + "/" + languageId);
    }
}