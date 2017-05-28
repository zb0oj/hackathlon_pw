package pl.wks.hackathon.dto;

import java.math.BigDecimal;
import java.util.List;

/**
 * DTO of master's thesis representation
 * <p>
 * Created by Marek Paczóski on 27.05.2017.
 */
public class MastersThesisDTO {

    private Long id;

    private String title;

    private BigDecimal difficulity;

    private ThesisSupervisorDTO author;

    private List<TagDTO> tags;

    private Boolean isDone;

    private String diplomeType;

    public MastersThesisDTO() {
        // default constructor
    }

    public MastersThesisDTO(Long id, String title, BigDecimal difficulity, ThesisSupervisorDTO author, List<TagDTO> tags, Boolean isDone, String diplomeType) {
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

    public ThesisSupervisorDTO getAuthor() {
        return author;
    }

    public void setAuthor(ThesisSupervisorDTO author) {
        this.author = author;
    }

    public List<TagDTO> getTags() {
        return tags;
    }

    public void setTags(List<TagDTO> tags) {
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
        return "MastersThesisDTO{" +
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
