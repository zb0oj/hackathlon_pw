package pl.wks.hackathon.services.impl;

import com.google.common.collect.Lists;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;
import pl.wks.hackathon.dto.ThesisSupervisorDTO;
import pl.wks.hackathon.model.ThesisSupervisor;
import pl.wks.hackathon.repository.ThesisSupervisorRepository;
import pl.wks.hackathon.services.ThesisSupervisorServices;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * Implementation of {@link ThesisSupervisorServices}
 * <p>
 * Created by Marek Paczóski on 27.05.2017.
 */
@Service
public class DefaultThesisSupervisorServices implements ThesisSupervisorServices {

    @Resource
    private ThesisSupervisorRepository thesisSupervisorRepository;

    @Resource
    private Mapper mapper;

    @Override
    public ThesisSupervisorDTO getById(Long thesisSupervisorId) {
        return mapper.map(thesisSupervisorRepository.findOne(thesisSupervisorId), ThesisSupervisorDTO.class);
    }

    @Override
    public ThesisSupervisor save(ThesisSupervisor thesisSupervisor) {
        return thesisSupervisorRepository.save(thesisSupervisor);
    }

    @Override
    public List<ThesisSupervisor> getAll() {
        return Lists.newArrayList(thesisSupervisorRepository.findAll());
    }

    @Override
    public void saveCollection(Collection<ThesisSupervisor> lists) {
        thesisSupervisorRepository.save(lists);
    }

    @Override
    public void delete(ThesisSupervisor thesisSupervisor) {
        thesisSupervisorRepository.delete(thesisSupervisor);
    }
}
