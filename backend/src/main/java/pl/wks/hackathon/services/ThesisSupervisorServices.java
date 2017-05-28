package pl.wks.hackathon.services;

import pl.wks.hackathon.model.Tag;
import pl.wks.hackathon.model.ThesisSupervisor;

import java.util.Collection;
import java.util.List;

/**
 * interface to define method which should be implemented in development mode
 * <p>
 * Created by Marek Paczóski on 27.05.2017.
 */
public interface ThesisSupervisorServices {

    ThesisSupervisor getById(Long thesisSupervisorId);

    ThesisSupervisor save(ThesisSupervisor thesisSupervisor);

    List<ThesisSupervisor> getAll();

    void saveCollection(Collection<ThesisSupervisor> lists);

    void delete(ThesisSupervisor thesisSupervisor);

}
