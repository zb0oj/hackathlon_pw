package pl.wks.hackathon.controller;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    private Mapper mapper;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> getHelloPage() {
        LOG.info("Welcome in hello controller.");

//        ThesisSupervisor thesisSupervisor = preparMock();
//        defaultThesisSupervisorServices.save(thesisSupervisor);
        MastersThesis mastersThesis = prepareMockMaster();
        defaultMastersThesisService.save(mastersThesis);
        defaultMastersThesisService.countTag("Pingwiny");
        MastersThesisDTO dto = new MastersThesisDTO();
        mapper.map(mastersThesis, dto);
        return ResponseEntity.ok(dto.toString());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<MastersThesisDTO> getJSON(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.map(defaultMastersThesisService.getById(id), MastersThesisDTO.class));
    }

    private static MastersThesis prepareMockMaster() {
        MastersThesis mastersThesis = new MastersThesis();
        mastersThesis.setId(1L);
        mastersThesis.setTitle("Wpływ zorzy na akty masturbacji pingwinów Adeli");
        mastersThesis.setDifficulity(BigDecimal.valueOf(5));
        mastersThesis.setAuthor(preparMock());

        //tags
        Tag tag1 = new Tag(12L, "Pingwiny");
        Tag tag2 = new Tag(2L, "Adeli");

        mastersThesis.setTags(Arrays.asList(tag1, tag2));

        return mastersThesis;
    }

    private static ThesisSupervisor preparMock() {
        ThesisSupervisor thesisSupervisor = new ThesisSupervisor();
        thesisSupervisor.setId(1L);
        thesisSupervisor.setRate(BigDecimal.valueOf(4.4));
        thesisSupervisor.setName("Tomasz Rębelski");
        thesisSupervisor.setDepartment(PWDepartment.EITI);
        thesisSupervisor.setMail("piekny.tom@gmail.com");
        thesisSupervisor.setPhone("0700-880-774");

        // Rates
        Rate rate1 = new Rate(1L, "Dostępność", "fa-dupa", BigDecimal.valueOf(4.4));
        Rate rate2 = new Rate(2L, "Komunikatywność", "fa-dupa", BigDecimal.valueOf(3.5));
        thesisSupervisor.setRates(Arrays.asList(rate1, rate2));

        //tags
        Tag tag1 = new Tag(12L, "Pingwiny");
        Tag tag2 = new Tag(3L, "ESB");
        Tag tag3 = new Tag(4L, "Mercedes");

        thesisSupervisor.setRelatedTags(Arrays.asList(tag1, tag2, tag3));

        return thesisSupervisor;
    }

}
