package com.instinctools.search.repository;
import com.instinctools.search.entity.Doc;

import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface DocRepository extends SolrCrudRepository<Doc, String> {


    @Query(value = "text:?0")
    Iterable<Doc> findSentence(String sentence );
}
