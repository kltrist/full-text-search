package com.instinctools.search.controller;

import com.instinctools.search.entity.Doc;
import com.instinctools.search.service.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;

import org.springframework.data.solr.core.query.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class DocController {

    private DocService service;

    @Autowired
    public DocController(DocService service) {
        this.service = service;
    }


    @GetMapping("/search")
    public Iterable<String> getDocsIdBySentence(@RequestParam(name = "q") String sentence) {
        ArrayList<String> ids = new ArrayList<>();
        Iterable<Doc> docs = service.findSentence(sentence);
        int maxEntryCount =0;

        docs.forEach((Doc d) -> ids.add(d.getId()));
        return ids;
    }

    @GetMapping("/getDoc")
    public ResponseEntity<Doc> getDocById(@RequestParam String id) {
        if (service.getDocById(id).isPresent())
            return new ResponseEntity<>(service.getDocById(id).get(), HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping("/getDoc/all")
    public Iterable<Doc> getAllDocs() {
        return service.getAll();
    }



}
