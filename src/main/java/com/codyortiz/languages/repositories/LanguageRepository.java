package com.codyortiz.languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codyortiz.languages.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository {
	List<Language> findAll();
}
