package pl.wks.hackathon.services.impl;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import pl.wks.hackathon.model.ThesisSupervisor;
import pl.wks.hackathon.repository.ThesisSupervisorRepository;
import pl.wks.hackathon.services.ThesisSupervisorServices;

import javax.annotation.Resource;
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


    @Override
    public ThesisSupervisor getById(Long thesisSupervisorId) {
        return thesisSupervisorRepository.findOne(thesisSupervisorId);
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
    public void delete(ThesisSupervisor thesisSupervisor) {
        thesisSupervisorRepository.delete(thesisSupervisor);
    }
}
