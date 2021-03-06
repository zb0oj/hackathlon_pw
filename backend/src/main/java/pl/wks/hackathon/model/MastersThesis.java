package pl.wks.hackathon.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.math.BigDecimal;
import java.util.List;

/**
 * Representation of subject
 * <p>
 * Created by Marek Paczóski on 27.05.2017.
 */
@Document(indexName = "hackathlon_pw", type = "mastershhesises")
public class MastersThesis {

    @Id
    private Long id;

    private String title;

    private BigDecimal difficulity;

    @Field(type = FieldType.Nested)
    private ThesisSupervisor author;

    @Field(type = FieldType.Nested)
    private List<Tag> tags;

    private Boolean isDone;

    private String diplomeType;

    public MastersThesis() {
        // default constructor
    }

    public MastersThesis(Long id, String title, BigDecimal difficulity, ThesisSupervisor author, List<Tag> tags, Boolean isDone, String diplomeType) {
        this.id = id;
        this.title = title;
        this.difficulity = difficulity;
        this.author = author;
        this.tags = tags;
        this.isDone = isDone;
        this.diplomeType = diplomeType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getDifficulity() {
        return difficulity;
    }

    public void setDifficulity(BigDecimal difficulity) {
        this.difficulity = difficulity;
    }

    public ThesisSupervisor getAuthor() {
        return author;
    }

    public void setAuthor(ThesisSupervisor author) {
        this.author = author;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    public String getDiplomeType() {
        return diplomeType;
    }

    public void setDiplomeType(String diplomeType) {
        this.diplomeType = diplomeType;
    }

    @Override
    public String toString() {
        return "MastersThesis{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", difficulity=" + difficulity +
                ", author=" + author +
                ", tags=" + tags +
                ", isDone=" + isDone +
                ", diplomeType='" + diplomeType + '\'' +
                '}';
    }
}
