package pl.wks.hackathon.dto.importers;

import java.util.List;

/**
 * Created by MParada on 27.05.2017.
 */
public class Diplome {

    String diplomeType;

    String author;

    String title;

    String promotor;

    String studies;

    String department;

    String year;

    List<String> tagsPL;

    List<String> tagsENG;

    public String getDiplomeType() {
        return diplomeType;
    }

    public void setDiplomeType(String diplomeType) {
        this.diplomeType = diplomeType;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPromotor() {
        return promotor;
    }

    public void setPromotor(String promotor) {
        this.promotor = promotor;
    }

    public String getStudies() {
        return studies;
    }

    public void setStudies(String studies) {
        this.studies = studies;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<String> getTagsPL() {
        return tagsPL;
    }

    public void setTagsPL(List<String> tagsPL) {
        this.tagsPL = tagsPL;
    }

    public List<String> getTagsENG() {
        return tagsENG;
    }

    public void setTagsENG(List<String> tagsENG) {
        this.tagsENG = tagsENG;
    }

    @Override
    public String toString() {
        return "Diplome{" +
                "diplomeType='" + diplomeType + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", promotor='" + promotor + '\'' +
                ", studies='" + studies + '\'' +
                ", department='" + department + '\'' +
                ", year='" + year + '\'' +
                ", tagsPL=" + tagsPL +
                ", tagsENG=" + tagsENG +
                '}';
    }
}