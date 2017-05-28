package pl.wks.hackathon.controller;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.wks.hackathon.dto.MastersThesisDTO;
import pl.wks.hackathon.enums.PWDepartment;
import pl.wks.hackathon.model.MastersThesis;
import pl.wks.hackathon.model.Rate;
import pl.wks.hackathon.model.Tag;
import pl.wks.hackathon.model.ThesisSupervisor;
import pl.wks.hackathon.services.MastersThesisService;
import pl.wks.hackathon.services.TagService;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Created by Marek Paczóski on 27.05.2017.
 */
@RequestMapping(value = "/tst")
@Controller
public class WelcomeController {

    private static final Logger LOG = LoggerFactory.getLogger(WelcomeController.class);

    @Autowired
    private MastersThesisService defaultMastersThesisService;

    @Autowired
    private TagService defaultTagService;

    @Autowired
    private Mapper mapper;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> getHelloPage() {
        LOG.info("Welcome in hello controller.");

        MastersThesis mastersThesis = prepareMockMaster();
        defaultMastersThesisService.save(mastersThesis);
        //defaultMastersThesisService.countTag("Pingwiny");

        System.out.print(defaultMastersThesisService.inlineSearch(Arrays.asList("Mateuszka", "dupa")));

        MastersThesisDTO dto = new MastersThesisDTO();
        mapper.map(mastersThesis, dto);
        return ResponseEntity.ok(dto.toString());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<MastersThesisDTO> getJSON(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.map(defaultMastersThesisService.getById(id), MastersThesisDTO.class));
    }

    @RequestMapping(value = "/tag/{id}", method = RequestMethod.GET)
    public ResponseEntity<Tag> getTagJSON(@PathVariable Long id) {
        return ResponseEntity.ok(defaultTagService.getById(id));
    }

    private MastersThesis prepareMockMaster() {
        MastersThesis mastersThesis = new MastersThesis();
        mastersThesis.setId(2L);
        mastersThesis.setTitle("Wpływ Mateuszka na rozwój developmentu");
        mastersThesis.setDifficulity(BigDecimal.valueOf(5));
        mastersThesis.setAuthor(preparMock());

        //tags
        Tag tag1 = new Tag(30L, "matueszek");
        Tag tag2 = new Tag(31L, "makarena");
        Tag tag3 = new Tag(30L, "pik");
        Tag tag4 = new Tag(31L, "gik");

        Tag tag11 = new Tag(30L, "matueszek");
        Tag tag21 = new Tag(31L, "makarena");
        Tag tag31 = new Tag(30L, "pik");
        Tag tag41 = new Tag(31L, "gik");

        mastersThesis.setTags(Arrays.asList(tag1, tag2, tag3, tag4));
        defaultTagService.saveCollection(Arrays.asList(tag11, tag21, tag31, tag41));
//
//        IndexQuery indexQuery = new IndexQuery();
//        indexQuery.setId(mastersThesis.getId().toString());
//        indexQuery.setObject(mastersThesis);
//
//        //creating mapping
//        elasticsearchTemplate.putMapping(MastersThesis.class);
//        //indexing document
//        elasticsearchTemplate.index(indexQuery);
//        //refresh
//        elasticsearchTemplate.refresh(MastersThesis.class);
//
//        elasticsearchTemplate.putMapping(Tag.class);
       // elasticsearchTemplate.refresh("hackathlon_pw");

        return mastersThesis;
    }

    private ThesisSupervisor preparMock() {
        ThesisSupervisor thesisSupervisor = new ThesisSupervisor();
        thesisSupervisor.setId(2L);
        thesisSupervisor.setRate(BigDecimal.valueOf(4.5));
        thesisSupervisor.setName("Super Kieras");
        thesisSupervisor.setDepartment(PWDepartment.MINI);
        thesisSupervisor.setMail("filong.bjutiful@gmail.com");
        thesisSupervisor.setPhone("123-123-123");

        // Rates
        Rate rate1 = new Rate(3L, "Yoł", "fa-cyka", BigDecimal.valueOf(4.6));
        Rate rate2 = new Rate(4L, "Elo", "fa-cyka", BigDecimal.valueOf(3.8));
        thesisSupervisor.setRates(Arrays.asList(rate1, rate2));

        //tags
        Tag tag1 = new Tag(20L, "mat");
        Tag tag2 = new Tag(21L, "szynka");
        Tag tag3 = new Tag(22L, "LPG");

        thesisSupervisor.setRelatedTags(Arrays.asList(tag1, tag2, tag3));

        return thesisSupervisor;
    }

}
