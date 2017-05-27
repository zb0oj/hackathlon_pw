package pl.wks.hackathon.services.impl;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import pl.wks.hackathon.model.Tag;
import pl.wks.hackathon.repository.TagRepository;
import pl.wks.hackathon.services.TagService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Implementation of {@link TagService}
 * <p>
 * Created by Marek Paczóski (marek.paczoski@execon.pl) on 27.05.2017.
 */
@Service
public class DefaultTagService implements TagService {


    @Resource
    private TagRepository tagRepository;

    @Override
    public Tag getById(Long tagId) {
        return tagRepository.findOne(tagId);
    }

    @Override
    public Tag save(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public List<Tag> getAll() {
        return Lists.newArrayList(tagRepository.findAll());
    }

    @Override
    public void delete(Tag tag) {
        tagRepository.delete(tag);
    }
}
