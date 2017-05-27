package pl.wks.hackathon.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.wks.hackathon.dto.importers.Diplome;
import pl.wks.hackathon.enums.PWDepartment;
import pl.wks.hackathon.model.MastersThesis;
import pl.wks.hackathon.model.Tag;
import pl.wks.hackathon.model.ThesisSupervisor;
import pl.wks.hackathon.services.MastersThesisService;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by MParada on 27.05.2017.
 */
@RequestMapping(value = "/import")
@Controller
public class ImportController {
    private static final Logger LOG = LoggerFactory.getLogger(ImportController.class);

    @Autowired
    private MastersThesisService defaultMastersThesisService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> importer() throws IOException {
        LOG.info("Welcome in import method.");
        ObjectMapper om = new ObjectMapper();
        ClassLoader classLoader = getClass().getClassLoader();
        ArrayList<Diplome> dimplomes = om.readValue(new File(classLoader.getResource("files/mini.json").getFile()), new TypeReference<List<Diplome>>() {
        });
        List<MastersThesis> masters = new ArrayList<>();
        Map<String, ThesisSupervisor> promotors = new HashMap<>();
        Map<String, Tag> tags = new HashMap<>();
        AtomicLong iterator = new AtomicLong(0L);
        dimplomes.forEach(k -> {
            MastersThesis mt = new MastersThesis();
            mt.setTitle(k.getTitle());
            List<Tag> tempTags = new ArrayList<>();
            k.getTagsPL().forEach(l -> {
                if (tags.containsKey(l)) tempTags.add(tags.get(l));
                else {
                    Tag tag = new Tag();
                    tag.setTagName(l);
                    tag.setTagsValue(iterator.incrementAndGet());
                    tags.put(l, tag);
                    tempTags.add(tag);

                }
            });
            mt.setTags(tempTags);
            mt.setDifficulity(getRandomBigDecimal());
            mt.setId(iterator.incrementAndGet());
            mt.setDone(true);
            if (promotors.containsKey(k.getAuthor())) {
                mt.setAuthor(promotors.get(k.getAuthor()));
            } else {
                ThesisSupervisor ts = new ThesisSupervisor();
                ts.setId(iterator.incrementAndGet());
                ts.setName(k.getAuthor());
                ts.setMail(k.getAuthor().replace(" ", ".").concat("@pw.edu.pl"));
                ts.setRelatedTags(tempTags);
                ts.setDepartment(PWDepartment.MINI);
                mt.setAuthor(ts);
                promotors.put(k.getAuthor(), ts);
            }
            masters.add(mt);
        });
        masters.forEach(k -> defaultMastersThesisService.save(k));
        return ResponseEntity.ok("OK");
    }

    private static BigDecimal getRandomBigDecimal() {
        BigDecimal max = new BigDecimal(5 + ".0");
        BigDecimal randFromDouble = new BigDecimal(Math.random());
        BigDecimal actualRandomDec = randFromDouble.divide(max, BigDecimal.ROUND_DOWN);

        return actualRandomDec;
    }
}
