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
    private Long tagId;

    private String tagName;

    public Tag() {
        // default constructor
    }

    // constructor for all fields
    public Tag(Long tagId, String tagName) {
        this.tagId = tagId;
        this.tagName = tagName;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
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
                "tagId=" + tagId +
                ", tagName='" + tagName + '\'' +
                '}';
    }
}
