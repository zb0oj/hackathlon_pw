package pl.wks.hackathon.converters;

import org.dozer.DozerConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import pl.wks.hackathon.dto.TagDTO;
import pl.wks.hackathon.model.Tag;

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
        result.setTagsValue(tag.getTagsValue());
        result.setTagName(tag.getTagName());
        return result;
    }

    @Override
    public Tag convertFrom(TagDTO tagDTO, Tag tag) {
        tag.setTagName(tagDTO.getTagName());
        tag.setTagsValue(tagDTO.getTagsValue());

        return tag;
    }

}
