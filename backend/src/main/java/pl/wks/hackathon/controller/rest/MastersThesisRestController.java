package pl.wks.hackathon.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.wks.hackathon.dto.MastersThesisDTO;
import pl.wks.hackathon.dto.request.TagsQuery;
import pl.wks.hackathon.services.MastersThesisService;

import java.util.List;
import java.util.Objects;

/**
 * Created by Marek Paczóski on 28.05.2017.
 */
@RequestMapping("/api/v1/mastersThesis")
@Controller
public class MastersThesisRestController {

    @Autowired
    private MastersThesisService defaultMastersThesisService;

    @RequestMapping(value = "/inlineSearch", method = RequestMethod.POST)
    public ResponseEntity<List<MastersThesisDTO>> getListTagsByQuery(@RequestParam(required = false) TagsQuery tags) {
        if (Objects.nonNull(tags))
            return ResponseEntity.ok(defaultMastersThesisService.inlineSearch(tags.getTags()));
        else
            return ResponseEntity.ok(defaultMastersThesisService.getAll());
    }

    @RequestMapping(value = "/byPromotorId/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<MastersThesisDTO>> getListByAuthorId(@PathVariable Long id) {
        return ResponseEntity.ok(defaultMastersThesisService.findByAuthorId(id));
    }

}