package pl.wks.hackathon.controller.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.wks.hackathon.dto.ThesisSupervisorDTO;
import pl.wks.hackathon.services.ThesisSupervisorServices;

import javax.annotation.Resource;

/**
 * Created by Marek Paczóski on 28.05.2017.
 */
@RequestMapping("/api/v1/thesisSupervisor")
@Controller
public class ThesisSupervisorRestController {

    @Resource
    private ThesisSupervisorServices defaultThesisSupervisorServices;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ThesisSupervisorDTO> getAuthorById(@PathVariable Long id) {
        return ResponseEntity.ok(defaultThesisSupervisorServices.getById(id));
    }

}
