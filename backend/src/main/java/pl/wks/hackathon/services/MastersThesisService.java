package pl.wks.hackathon.services;

import pl.wks.hackathon.dto.MastersThesisDTO;
import pl.wks.hackathon.dto.mini.MasterThesisTableDTO;
import pl.wks.hackathon.model.MastersThesis;
import pl.wks.hackathon.model.Tag;

import java.util.Collection;
import java.util.List;

/**
 * interface to define method which should be implemented in development mode
 * Created by Marek Paczóski on 27.05.2017.
 */
public interface MastersThesisService {

    MastersThesis getById(Long mastersThesisId);

    MasterThesisTableDTO getMiniById(Long mastersThesisId);

    MastersThesis save(MastersThesis mastersThesis);

    List<MastersThesisDTO> getAll();

    void delete(MastersThesis mastersThesis);

    void saveCollection(Collection<MastersThesis> lists);

    Integer countTag(String tagName);

    List<MastersThesisDTO> findByAuthorId(Long id);

    List<MastersThesisDTO> findArchivedByAuthorId(Long id);

    List<MastersThesisDTO> inlineSearch(List<String> tags);
}
