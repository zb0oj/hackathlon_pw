package pl.wks.hackathon.dto;

import java.math.BigDecimal;

/**
 * DTO of rates representation
 * <p>
 * Created by Marek Paczóski on 27.05.2017.
 */
public class RateDTO {

    private Long id;

    private String title;

    private String icon;

    private BigDecimal frequency;

    public RateDTO() {
        // default constructor
    }

    public RateDTO(Long id, String title, String icon, BigDecimal frequency) {
        this.id = id;
        this.title = title;
        this.icon = icon;
        this.frequency = frequency;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public BigDecimal getFrequency() {
        return frequency;
    }

    public void setFrequency(BigDecimal frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "RateDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", icon='" + icon + '\'' +
                ", frequency=" + frequency +
                '}';
    }
}
