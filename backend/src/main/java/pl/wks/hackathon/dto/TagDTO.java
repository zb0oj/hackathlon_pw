package pl.wks.hackathon.dto;

/**
 * DTO of tags representation
 * <p>
 * Created by Marek Paczóski on 27.05.2017.
 */
public class TagDTO {

    private Long tagsValue;

    private String tagName;

    private Integer frequency;

    public TagDTO() {
        // default constructor
    }

    // constructor for all fields
    public TagDTO(Long tagsValue, String tagName, Integer frequency) {
        this.tagsValue = tagsValue;
        this.tagName = tagName;
        this.frequency = frequency;
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

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "TagDTO{" +
                "tagsValue=" + tagsValue +
                ", tagName='" + tagName + '\'' +
                ", frequency=" + frequency +
                '}';
    }

}
