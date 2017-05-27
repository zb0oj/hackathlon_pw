package pl.wks.hackathon.controller;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.wks.hackathon.dto.TagDTO;
import pl.wks.hackathon.model.Tag;
import pl.wks.hackathon.services.TagService;

/**
 * Created by Marek Paczóski on 27.05.2017.
 */
@RequestMapping(value = "/tst")
@Controller
public class WelcomeController {

    private static final Logger LOG = LoggerFactory.getLogger(WelcomeController.class);

    @Autowired
    private TagService defaultTagService;

    @Autowired
    private Mapper mapper;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> getHelloPage(){
        LOG.info("Welcome in hello controller.");

        Tag tag = new Tag(1L,"Tag#1");
        defaultTagService.save(tag);
        TagDTO dto = new TagDTO();
        mapper.map(defaultTagService.getById(1L),dto);
        return ResponseEntity.ok(dto.toString());
    }

}