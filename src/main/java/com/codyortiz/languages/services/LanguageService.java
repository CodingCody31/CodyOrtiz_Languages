package com.codyortiz.languages.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codyortiz.languages.models.Language;
import com.codyortiz.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository languageRepository;
	
	public LanguageService (LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	public List<Language> allLanguages(){
		return languageRepository.findAll();
	}
	
	public Language createLang (Language lang) {
		return languageRepository.save(lang);
	}
	
	public Language findLang(Long id) {
		Optional<Language> optionalLang = languageRepository.findById(id);
        if(optionalLang.isPresent()) {
            return optionalLang.get();
        } else {
            return null;
        }
	}
	
	public void deleteLang(Long id) {
		languageRepository.deleteById(id);
	}

}
