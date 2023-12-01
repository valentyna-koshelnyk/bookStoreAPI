package org.startsteps.service;

import org.startsteps.model.Authors;

import java.util.List;

public interface AuthorsService {
        void addAuthor(Authors author);
        List<Authors> getAllAuthors();
        Authors getAuthorByName(String authorName);
        List<Authors> getAuthorsByYearRange(int yearStart, int yearEnd);
        List<Authors> getAuthorsByOrigin(String originCountry);
        void deleteAuthor(String authorName);
        void updateAuthor(Authors authors);






}
