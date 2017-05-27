package pl.wks.hackathon.services;

import pl.wks.hackathon.model.MastersThesis;

import java.util.List;

/**
 * interface to define method which should be implemented in development mode
 * Created by Marek Paczóski on 27.05.2017.
 */
public interface MastersThesisService {

    MastersThesis getById(Long mastersThesisId);

    MastersThesis save(MastersThesis mastersThesis);

    List<MastersThesis> getAll();

    void delete(MastersThesis mastersThesis);

    Integer countTag(String tagName);
}
