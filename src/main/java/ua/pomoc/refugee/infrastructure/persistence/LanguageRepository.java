package ua.pomoc.refugee.infrastructure.persistence;

import com.neovisionaries.i18n.LanguageCode;
import org.springframework.stereotype.Repository;
import ua.pomoc.refugee.domain.model.Language;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

@Repository
public class LanguageRepository {
    private final Map<LanguageCode, Language> languages;

    public LanguageRepository() {
        languages = new ConcurrentHashMap<>();
        languages.put(LanguageCode.uk, new Language(LanguageCode.uk.name(), "Ukrainian", "Украинский"));
        languages.put(LanguageCode.en, new Language(LanguageCode.en.name(), "English", "Английский"));
        languages.put(LanguageCode.ru, new Language(LanguageCode.ru.name(), "Russian", "Русский"));
        languages.put(LanguageCode.pl, new Language(LanguageCode.pl.name(), "Polish", "Польский"));
    }


    public Language findByName(String name) {
        Pattern pattern = Pattern.compile(name);
        Optional<LanguageCode> languageCode = LanguageCode.findByName(pattern).stream().findFirst();
        Optional<Language> languageEntity = languageCode.map(it -> languages.get(it));
        return languageEntity.orElseThrow(() -> new IllegalArgumentException("Unknown language"));
    }

    public Language findByCode(String code) {
        LanguageCode languageCode = LanguageCode.getByCode(code, false);
        Optional<Language> languageEntity = Optional.ofNullable(languages.get(languageCode));
        return languageEntity.orElseThrow(() -> new IllegalArgumentException("Unknown language"));
    }
}
