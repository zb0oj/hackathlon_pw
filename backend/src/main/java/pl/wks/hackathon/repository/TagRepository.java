package pl.wks.hackathon.repository;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import pl.wks.hackathon.model.Tag;

import java.util.List;

/**
 * Tags repository
 * <p>
 * Created by Marek Paczóski on 27.05.2017.
 */
public interface TagRepository extends ElasticsearchRepository<Tag, Long> {

    @Query("{\"query\":{\"query_string\":{\"query\":\"?0\"}}}")
    List<Tag> inlineSearch(String query);
}
