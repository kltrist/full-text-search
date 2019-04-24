package com.instinctools.search.service;
import com.instinctools.search.entity.Doc;
import com.instinctools.search.repository.DocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class DocServiceImpl implements DocService {

    private final DocRepository repository;
    @Autowired
    public DocServiceImpl(DocRepository repository) {
        this.repository = repository;
    }


    @Override
    public Optional<Doc> getDocById(String id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Doc> getAll() {
        return repository.findAll();
    }

    @Override
    public Iterable<Doc> findSentence(String sentence) {
        return repository.findSentence(sentence);
    }

    @Override
    public void save(Doc doc) {
        repository.save(doc);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }


}
