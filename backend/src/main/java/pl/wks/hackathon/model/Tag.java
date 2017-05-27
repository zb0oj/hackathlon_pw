package pl.wks.hackathon.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Tag entity.
 * <p>
 * Created by Marek Paczóski on 27.05.2017.
 */
@Document(indexName = "tag", type = "tags")
public class Tag {

    @Id
    private Long tagsValue;

    private String tagName;

    public Tag() {
        // default constructor
    }

    // constructor for all fields
    public Tag(Long tagsValue, String tagName) {
        this.tagsValue = tagsValue;
        this.tagName = tagName;
    }

    public Long getTagsValue() {
        return tagsValue;
    }

    public void setTagsValue(Long tagsValue) {
        this.tagsValue = tagsValue;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "tagsValue=" + tagsValue +
                ", tagName='" + tagName + '\'' +
                '}';
    }
}
