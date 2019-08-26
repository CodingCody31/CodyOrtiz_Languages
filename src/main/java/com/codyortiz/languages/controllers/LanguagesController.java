package com.codyortiz.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codyortiz.languages.models.Language;
import com.codyortiz.languages.services.LanguageService;


@Controller
public class LanguagesController {
	private final LanguageService languageService;
	
	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping("/languages")
	public String index(Model model) {
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		return "languages/index.jsp";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
		} else {
			languageService.createLang(language);
			return "redirect:/languages";
		}
	}
	@RequestMapping(value="/languages/{id}")
    public String showLang(@PathVariable("id")Long id, Model model) {
    	Language language = languageService.findLang(id);
    	model.addAttribute("language", language);
    	return "languages/show.jsp";
    }
	
	
		@RequestMapping("/languages/delete/{id}")
		public String delete(@PathVariable("id") Long id) {
			languageService.deleteLang(id);
			return "redirect:/languages";
		}

		
		@RequestMapping("/languages/edit/{id}")
		public String edit(@PathVariable("id") Long id, Model model) {
			
			Language language = languageService.findLang(id);
			model.addAttribute("language", language);
			return "languages/edit.jsp";
		}

		@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
		public String update(@Valid @ModelAttribute("lang") Languages lang, BindingResult result) {
			languageService.createLanguage(lang);
			return "redirect:/languages";
					
		}
	
	
}
