package pl.wks.hackathon.controller.rest;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.wks.hackathon.dto.TagDTO;
import pl.wks.hackathon.services.TagService;

import java.util.List;

/**
 * Rest controller of Tags
 * <p>
 * Created by Marek Paczóski on 28.05.2017.
 */
@RequestMapping("/api/v1/tags")
@Controller
public class TagsRestController {

    @Autowired
    private TagService defaultTagService;

    @RequestMapping(value = "/{query}", method = RequestMethod.GET)
    public ResponseEntity<List<TagDTO>> getListTagsByQuery(@PathVariable(name = "query") String query) {
        return ResponseEntity.ok(defaultTagService.inlineSearch(query));
    }
}
