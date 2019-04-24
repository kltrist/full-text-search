package com.instinctools.search.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.util.Objects;


@Data
@NoArgsConstructor
@AllArgsConstructor
@SolrDocument(collection = "core")
public class Doc {

    @Id
    @Indexed(name = "id",type = "string")
    private String id;

    @Indexed(name = "file_name",type = "string")
    private String fileName;


    @Indexed(name = "text",type = "text_ru")
    private String text;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doc doc = (Doc) o;
        return id.equals(doc.id) &&
                fileName.equals(doc.fileName) &&
                Objects.equals(text, doc.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fileName, text);
    }
}
