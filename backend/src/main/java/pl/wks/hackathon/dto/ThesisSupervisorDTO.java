package pl.wks.hackathon.dto;

import pl.wks.hackathon.enums.PWDepartment;

import java.math.BigDecimal;
import java.util.List;

/**
 * DTO of ThesisSupervisor representation.
 * <p>
 * Created by Marek Paczóski on 27.05.2017.
 */
public class ThesisSupervisorDTO {

    private Long id;

    private String name;

    private BigDecimal rate;

    private PWDepartment department;

    private String mail;

    private String phone;

    private List<TagDTO> relatedTags;

    private List<RateDTO> rates;

    public ThesisSupervisorDTO() {
        // default constructor
    }

    public ThesisSupervisorDTO(Long id, String name, BigDecimal rate, PWDepartment department, String mail, String phone, List<TagDTO> relatedTags, List<RateDTO> rates) {
        this.id = id;
        this.name = name;
        this.rate = rate;
        this.department = department;
        this.mail = mail;
        this.phone = phone;
        this.relatedTags = relatedTags;
        this.rates = rates;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public PWDepartment getDepartment() {
        return department;
    }

    public void setDepartment(PWDepartment department) {
        this.department = department;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<TagDTO> getRelatedTags() {
        return relatedTags;
    }

    public void setRelatedTags(List<TagDTO> relatedTags) {
        this.relatedTags = relatedTags;
    }

    public List<RateDTO> getRates() {
        return rates;
    }

    public void setRates(List<RateDTO> rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "ThesisSupervisorDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rate=" + rate +
                ", department=" + department +
                ", mail='" + mail + '\'' +
                ", phone='" + phone + '\'' +
                ", relatedTags=" + relatedTags +
                ", rates=" + rates +
                '}';
    }
}
