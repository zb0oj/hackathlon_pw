package pl.wks.hackathon.dto.mini;

import pl.wks.hackathon.enums.PWDepartment;

/**
 * Created by Marek Paczóski on 28.05.2017.
 */
public class MasterThesisTableDTO {

    private String title;

    private String authorName;

    private Long authorId;

    private PWDepartment department;

    private String stage;

    public MasterThesisTableDTO() {
        // default constructor
    }

    public MasterThesisTableDTO(String title, String authorName, Long authorId, PWDepartment department, String stage) {
        this.title = title;
        this.authorName = authorName;
        this.authorId = authorId;
        this.department = department;
        this.stage = stage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public PWDepartment getDepartment() {
        return department;
    }

    public void setDepartment(PWDepartment department) {
        this.department = department;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }
}
