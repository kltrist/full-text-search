package com.instinctools.search.service;

import com.instinctools.search.entity.Doc;

import java.util.Optional;

public interface DocService {
    Optional<Doc> getDocById(String id);
    Iterable<Doc> getAll();
    Iterable<Doc> findSentence(String sentence );
    void save(Doc doc);
    void delete(String id);
}
