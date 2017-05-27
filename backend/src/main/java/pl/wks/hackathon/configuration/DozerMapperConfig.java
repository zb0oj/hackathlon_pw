package pl.wks.hackathon.configuration;

import org.dozer.CustomConverter;
import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.wks.hackathon.converters.TagConverter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Configuration of Dozer Bean Mapper
 * Created by Marek Paczóski on 27.05.2017.
 */
@Configuration
public class DozerMapperConfig {

    @Bean(name = "org.dozer.Mapper")
    public DozerBeanMapper dozerBean() {
        List<String> mappingFiles = Arrays.asList("config/dozer-configuration-mapping.xml");

        DozerBeanMapper dozerBean = new DozerBeanMapper();
        dozerBean.setMappingFiles(mappingFiles);

        // custom converters.
        Map<String, CustomConverter> customConverters = new HashMap<>();
        customConverters.put("tagConverter", tagConverter());
        dozerBean.setCustomConvertersWithId(customConverters);

        return dozerBean;
    }

    @Bean
    public CustomConverter tagConverter() {
        return new TagConverter();
    }

}
