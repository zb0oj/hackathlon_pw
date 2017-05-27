package pl.wks.hackathon.converters;

import org.dozer.DozerConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.wks.hackathon.dto.TagDTO;
import pl.wks.hackathon.model.Tag;
import pl.wks.hackathon.services.MastersThesisService;

import java.util.Objects;

/**
 * Converter of tag objects
 * Created by Marek Paczóski on 27.05.2017.
 */
@Component("tagConverter")
public class TagConverter extends DozerConverter<Tag, TagDTO> {

    /**
     * The constant LOG.
     */
    private static final Logger logger = LoggerFactory.getLogger(TagConverter.class);

    @Autowired
    private MastersThesisService defaultMastersThesisService;

    public TagConverter() {
        super(Tag.class, TagDTO.class);
    }

    @Override
    public TagDTO convertTo(Tag tag, TagDTO tagDTO) {
        TagDTO result;
        if (Objects.nonNull(tagDTO)) {
            result = tagDTO;
        } else {
            result = new TagDTO();
        }
        result.setTagId(tag.getTagId());
        result.setTagName(tag.getTagName());
        //result.setFrequency(getDefaultMastersThesisService().countTag(tag.getTagName()));
        return result;
    }

    @Override
    public Tag convertFrom(TagDTO tagDTO, Tag tag) {
        tag.setTagName(tagDTO.getTagName());
        tag.setTagId(tagDTO.getTagId());

        return tag;
    }


    public MastersThesisService getDefaultMastersThesisService() {
        return defaultMastersThesisService;
    }
}
