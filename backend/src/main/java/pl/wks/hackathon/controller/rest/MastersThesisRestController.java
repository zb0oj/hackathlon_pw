package pl.wks.hackathon.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.wks.hackathon.dto.MastersThesisDTO;
import pl.wks.hackathon.services.MastersThesisService;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Marek Paczóski on 28.05.2017.
 */
@RequestMapping("/api/v1/mastersThesis")
@Controller
public class MastersThesisRestController {

    @Autowired
    private MastersThesisService defaultMastersThesisService;

    @RequestMapping(value = "/inlineSearch", method = RequestMethod.POST)
    public ResponseEntity<List<MastersThesisDTO>> getListTagsByQuery(@RequestParam(name = "tags") String[] tags) {
        return ResponseEntity.ok(defaultMastersThesisService.inlineSearch(Arrays.asList(tags)));
    }
}
