package pl.wks.hackathon.services.impl;

import com.google.common.collect.Lists;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Service;
import pl.wks.hackathon.model.MastersThesis;
import pl.wks.hackathon.repository.MastersThesisRepository;
import pl.wks.hackathon.services.MastersThesisService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * Implementation of {@link MastersThesisService}
 * <p>
 * Created by Marek Paczóski on 27.05.2017.
 */
@Service
public class DefaultMastersThesisService implements MastersThesisService {

    @Resource
    private MastersThesisRepository mastersThesisRepository;

    @Override
    public MastersThesis getById(Long mastersThesisId) {
        return mastersThesisRepository.findOne(mastersThesisId);
    }

    @Override
    public MastersThesis save(MastersThesis mastersThesis) {
        return mastersThesisRepository.save(mastersThesis);
    }

    @Override
    public List<MastersThesis> getAll() {
        return Lists.newArrayList(mastersThesisRepository.findAll());
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
}
