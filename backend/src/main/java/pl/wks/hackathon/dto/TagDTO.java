package pl.wks.hackathon.dto;

/**
 * DTO of tags representation
 * <p>
 * Created by Marek Paczóski on 27.05.2017.
 */
public class TagDTO {

    private Long tagId;

    private String tagName;

    private Integer frequency;

    public TagDTO() {
        // default constructor
    }

    // constructor for all fields
    public TagDTO(Long tagId, String tagName, Integer frequency) {
        this.tagId = tagId;
        this.tagName = tagName;
        this.frequency = frequency;
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

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "TagDTO{" +
                "tagId=" + tagId +
                ", tagName='" + tagName + '\'' +
                ", frequency=" + frequency +
                '}';
    }

}
