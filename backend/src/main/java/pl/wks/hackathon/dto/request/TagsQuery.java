package pl.wks.hackathon.dto.request;

import java.util.List;

/**
 * Created by MParada on 28.05.2017.
 */
public class TagsQuery {
    List<String> tags;

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
