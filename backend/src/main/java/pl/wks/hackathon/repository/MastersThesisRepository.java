package pl.wks.hackathon.repository;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import pl.wks.hackathon.model.MastersThesis;

import java.util.List;

/**
 * Master's Thesis repository
 * <p>
 * Created by Marek Paczóski on 27.05.2017.
 */
public interface MastersThesisRepository extends ElasticsearchRepository<MastersThesis, Long> {

    @Query("{\"bool\": {\"must\": [{\"match\": {\"tags.tagName\": \"?0\"}}]}}")
    List<MastersThesis> findByTagNames(String name);

}
