package pl.wks.hackathon.services.impl;

import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;
import pl.wks.hackathon.dto.MastersThesisDTO;
import pl.wks.hackathon.model.MastersThesis;
import pl.wks.hackathon.repository.MastersThesisRepository;
import pl.wks.hackathon.services.MastersThesisService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Implementation of {@link MastersThesisService}
 * <p>
 * Created by Marek Paczóski on 27.05.2017.
 */
@Service
public class DefaultMastersThesisService implements MastersThesisService {

    @Resource
    private MastersThesisRepository mastersThesisRepository;

    @Resource
    private Mapper mapper;

    @Override
    public MastersThesis getById(Long mastersThesisId) {
        return mastersThesisRepository.findOne(mastersThesisId);
    }

    @Override
    public MastersThesis save(MastersThesis mastersThesis) {
        return mastersThesisRepository.save(mastersThesis);
    }

    @Override
    public void delete(MastersThesis mastersThesis) {
        mastersThesisRepository.delete(mastersThesis);
    }

    @Override
    public Integer countTag(String tagName) {
        List<MastersThesis> lists = mastersThesisRepository.findByTagNames(tagName);
        return Objects.nonNull(lists) ? lists.size() : NumberUtils.INTEGER_ZERO;
    }

    @Override
    public List<MastersThesisDTO> inlineSearch(List<String> tags) {
        List<MastersThesis> lists = mastersThesisRepository.inlineSearch(StringUtils.join(tags, StringUtils.SPACE));
        List<MastersThesisDTO> dtos = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(lists)) {
            dtos = lists.stream().map(tag -> mapper.map(tag, MastersThesisDTO.class)).collect(Collectors.toList());
        }
        return dtos;
    }

    @Override
    public List<MastersThesisDTO> getAll() {
        List<MastersThesis> lists = Lists.newArrayList(mastersThesisRepository.findAll());
        List<MastersThesisDTO> dtos = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(lists)) {
            dtos = lists.stream().map(tag -> mapper.map(tag, MastersThesisDTO.class)).collect(Collectors.toList());
        }
        return dtos;
    }


}
