package com.employe.controller;

import com.employe.dto.*;
import com.employe.entity.Activite;
import com.employe.entity.Qualifications;
import com.employe.service.ActiviteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "Activite management")

public class ActiviteRest {

    ActiviteService activiteService;

    public ActiviteRest(ActiviteService activiteService) {
        this.activiteService = activiteService;
    }

    @ApiOperation(value = "Récupérer la liste des Qualifications")
    @GetMapping(path="/activites")
    public List<ActiviteResponseDTO> allActivites()
    {

        return activiteService.listActivites();
    }
    @ApiOperation(value = "ajoute Activite")
    @PostMapping(path="/activite")
    public ActiviteResponseDTO save(ActiviteRequestDTO activiteRequestDTO){
        return activiteService.save(activiteRequestDTO);
    }
    @ApiOperation(value = "Récupérer Activite")
    @GetMapping(path = "/activite/{id}")
    public ActiviteResponseDTO getActivite(@PathVariable String id){

        return activiteService.getActivite(id);
    }
    @ApiOperation(value = "Update Activite")
    @PutMapping("/update-activite/")
    @ResponseBody
    public void UpdateActivite(@RequestBody ActiviteUpdateDTO dto) {
        activiteService.updateActivite(dto);
    }

    @ApiOperation(value = "Delete Activite")
    @DeleteMapping("/remove-activite/{activite-id}")
    @ResponseBody
    public void delete(@PathVariable("activite-id") String code) {
        activiteService.delete(code);
    }

    @ApiOperation(value = "Récupérer la liste des Qualifications Active")
    @GetMapping(path="/activitesActive")
    public List<ActiviteResponseDTO> listActivitesActive()
    {
        return activiteService.listActivitesActive();
    }
}
