package pl.wks.hackathon.converters;

import org.dozer.DozerConverter;
import org.dozer.Mapper;
import org.dozer.MapperAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.wks.hackathon.dto.TagDTO;
import pl.wks.hackathon.model.Tag;

/**
 * Converter of tag objects
 * Created by Marek Paczóski on 27.05.2017.
 */
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
        tagDTO.setTagId(tag.getTagId());
        tagDTO.setTagName(tag.getTagName());

        return tagDTO;
    }

    @Override
    public Tag convertFrom(TagDTO tagDTO, Tag tag) {
        tag.setTagName(tagDTO.getTagName());
        tag.setTagId(tagDTO.getTagId());

        return tag;
    }


}
