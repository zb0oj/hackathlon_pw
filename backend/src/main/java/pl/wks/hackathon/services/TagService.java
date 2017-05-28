package pl.wks.hackathon.services;

import pl.wks.hackathon.dto.TagDTO;
import pl.wks.hackathon.model.Tag;

import java.util.List;

/**
 * interface to define method which should be implemented in development mode
 * <p>
 * Created by Marek Paczóski (marek.paczoski@execon.pl) on 27.05.2017.
 */
public interface TagService {

    Tag getById(Long tagId);

    Tag save(Tag tag);

    void saveCollection(List<Tag> lists);

    List<Tag> getAll();

    void delete(Tag tag);

    List<TagDTO> inlineSearch(String query);
}
