package pl.wks.hackathon.converters;

import org.dozer.DozerConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.wks.hackathon.dto.mini.MasterThesisTableDTO;
import pl.wks.hackathon.model.MastersThesis;

import java.util.Objects;

/**
 * Created by Marek Paczóski on 28.05.2017.
 */
public class MastersThesisTableConverter extends DozerConverter<MastersThesis, MasterThesisTableDTO> {

    private Logger logger = LoggerFactory.getLogger(MastersThesisTableConverter.class);

    public MastersThesisTableConverter() {
        super(MastersThesis.class, MasterThesisTableDTO.class);
    }

    @Override
    public MasterThesisTableDTO convertTo(MastersThesis mastersThesis, MasterThesisTableDTO masterThesisTableDTO) {
        MasterThesisTableDTO result = new MasterThesisTableDTO();
        if (Objects.isNull(masterThesisTableDTO)) {
            result = masterThesisTableDTO;
        }

        result.setTitle(mastersThesis.getTitle());
        result.setStage(mastersThesis.getDiplomeType());
        result.setDepartment(mastersThesis.getAuthor().getDepartment());
        result.setAuthorName(mastersThesis.getAuthor().getName());
        result.setAuthorId(mastersThesis.getAuthor().getId());

        return result;
    }

    @Override
    public MastersThesis convertFrom(MasterThesisTableDTO masterThesisTableDTO, MastersThesis mastersThesis) {
        logger.warn("Method not supported!");
        return null;
    }
}
