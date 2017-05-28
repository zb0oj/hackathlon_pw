package pl.wks.hackathon.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import pl.wks.hackathon.model.ThesisSupervisor;

/**
 * ThesisSupervisor repository
 * <p>
 * Created by Marek Paczóski on 27.05.2017.
 */
public interface ThesisSupervisorRepository extends ElasticsearchRepository<ThesisSupervisor, Long> {
}
