package pl.wks.hackathon.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import pl.wks.hackathon.enums.PWDepartment;

import java.math.BigDecimal;
import java.util.List;

/**
 * Supervisor entity
 * <p>
 * Created by Marek Paczóski (marek.paczoski@execon.pl) on 27.05.2017.
 */
@Document(indexName = "supervisor", type = "thesisSupervisors")
public class ThesisSupervisor {

    @Id
    private Long id;

    private String name;

    private BigDecimal rate;

    private PWDepartment department;

    private String mail;

    private String phone;

    @Field(type = FieldType.Nested)
    private List<Tag> relatedTags;

    public ThesisSupervisor() {
        // default constructor
    }

    // constructor with default values;
    public ThesisSupervisor(Long id, String name, BigDecimal rate, PWDepartment department, String mail, String phone, List<Tag> relatedTags) {
        this.id = id;
        this.name = name;
        this.rate = rate;
        this.department = department;
        this.mail = mail;
        this.phone = phone;
        this.relatedTags = relatedTags;
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

    public List<Tag> getRelatedTags() {
        return relatedTags;
    }

    public void setRelatedTags(List<Tag> relatedTags) {
        this.relatedTags = relatedTags;
    }

    @Override
    public String toString() {
        return "ThesisSupervisor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rate=" + rate +
                ", department=" + department +
                ", mail='" + mail + '\'' +
                ", phone='" + phone + '\'' +
                ", relatedTags=" + relatedTags +
                '}';
    }
}
