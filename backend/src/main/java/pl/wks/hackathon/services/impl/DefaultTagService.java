package pl.wks.hackathon.services.impl;

import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wks.hackathon.dto.TagDTO;
import pl.wks.hackathon.model.Tag;
import pl.wks.hackathon.repository.TagRepository;
import pl.wks.hackathon.services.TagService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of {@link TagService}
 * <p>
 * Created by Marek Paczóski on 27.05.2017.
 */
@Service
public class DefaultTagService implements TagService {

    @Autowired
    private Mapper mapper;

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
    public void saveCollection(Collection<Tag> lists){
        tagRepository.save(lists);
    }

    @Override
    public List<Tag> getAll() {
        return Lists.newArrayList(tagRepository.findAll());
    }

    @Override
    public void delete(Tag tag) {
        tagRepository.delete(tag);
    }

    @Override
    public List<TagDTO> inlineSearch(String query) {
        List<Tag> lists = tagRepository.inlineSearch(query);
        List<TagDTO> dtos = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(lists)) {
            dtos = lists.stream().map(tag -> mapper.map(tag, TagDTO.class)).collect(Collectors.toList());
        }
        return dtos;
    }
}
