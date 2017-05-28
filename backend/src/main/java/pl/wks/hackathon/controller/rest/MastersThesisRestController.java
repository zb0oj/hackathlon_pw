package pl.wks.hackathon.controller.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.wks.hackathon.dto.MastersThesisDTO;
import pl.wks.hackathon.dto.mini.MasterThesisTableDTO;
import pl.wks.hackathon.dto.request.TagsQuery;
import pl.wks.hackathon.services.MastersThesisService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
    public ResponseEntity<List<MastersThesisDTO>> getListTagsByQuery(@RequestParam Map<String, String> body) throws IOException {
        ObjectMapper om = new ObjectMapper();
        List<String> temp = new ArrayList<>();
        temp.addAll(body.keySet());
        TagsQuery tq = om.readValue(temp.get(0), TagsQuery.class);

        if (Objects.nonNull(tq) && CollectionUtils.isNotEmpty(tq.getTags()))
            return ResponseEntity.ok(defaultMastersThesisService.inlineSearch(tq.getTags()));
        else
            return ResponseEntity.ok(defaultMastersThesisService.getAll());
    }

    @RequestMapping(value = "/byPromotorId/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<MastersThesisDTO>> getListByAuthorId(@PathVariable Long id) {
        return ResponseEntity.ok(defaultMastersThesisService.findByAuthorId(id));
    }

    @RequestMapping(value = "/byPromotorIdArchive/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<MastersThesisDTO>> getArchiveListByAuthorId(@PathVariable Long id) {
        return ResponseEntity.ok(defaultMastersThesisService.findArchivedByAuthorId(id));
    }

    @RequestMapping(value = "/mini/{id}", method = RequestMethod.GET)
    public ResponseEntity<MasterThesisTableDTO> getMasterThesisMinById(@PathVariable Long id) {
        return ResponseEntity.ok(defaultMastersThesisService.getMiniById(id));
    }

}