package pl.wks.hackathon.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import pl.wks.hackathon.enums.PWDepartment;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Supervisor entity
 * <p>
 * Created by Marek Paczóski on 27.05.2017.
 */
@Document(indexName = "hackathlon_pw", type = "thesisSupervisors")
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

    @Field(type = FieldType.Nested)
    private List<Rate> rates;

    public ThesisSupervisor() {
        // default constructor
    }

    public ThesisSupervisor(Long id, String name, BigDecimal rate, PWDepartment department, String mail, String phone, List<Tag> relatedTags, List<Rate> rates) {
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

    public List<Tag> getRelatedTags() {
        return relatedTags;
    }

    public void setRelatedTags(List<Tag> relatedTags) {
        this.relatedTags = relatedTags;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
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
                ", rates=" + rates +
                '}';
    }

    public ThesisSupervisor clone() {
        ThesisSupervisor ts = new ThesisSupervisor();
        ts.setId(this.id);
        ts.setRates(this.rates);
        ts.setRate(this.rate);
        ts.setPhone(this.phone);
        ts.setName(this.name);
        ts.setMail(this.mail);
        ts.setDepartment(this.department);
        ts.setRelatedTags(new ArrayList<>());
        this.getRelatedTags().forEach(k ->
                ts.getRelatedTags().add(k.clone())
        );
        return ts;
    }

}
