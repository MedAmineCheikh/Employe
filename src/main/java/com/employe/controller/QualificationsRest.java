package com.employe.controller;

import com.employe.dto.*;
import com.employe.entity.Employe;
import com.employe.entity.Qualifications;
import com.employe.service.EmployeService;
import com.employe.service.QualificationsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "Qualifications management")
@CrossOrigin(origins="http://localhost:4200")
public class QualificationsRest {

   QualificationsService qualificationsService;

    public QualificationsRest(QualificationsService qualificationsService) {
        this.qualificationsService = qualificationsService;
    }

    @ApiOperation(value = "Récupérer la liste des Qualifications")
    @GetMapping(path="/qualificationss")
    public List<QualificationsResponseDTO> allQualificationss()
    {

        return qualificationsService.listQualifications();
    }
    @ApiOperation(value = "ajoute Qualifications")
    @PostMapping(path="/savequalifications")
    public QualificationsResponseDTO save(@RequestBody QualificationsRequestDTO qualificationsRequestDTO){
        return qualificationsService.save(qualificationsRequestDTO);
    }
    @ApiOperation(value = "Récupérer Qualifications")
    @GetMapping(path = "/qualifications/{id}")
    public QualificationsResponseDTO getQualifications(@PathVariable String id){

        return qualificationsService.getQualifications(id);
    }
    @ApiOperation(value = "Update Qualifications")
    @PutMapping("/update-qualifications")
    @ResponseBody
    public void UpdateQualifications(@RequestBody QualificationsUpdateDTO dto) {
        qualificationsService.updateQualifications(dto);
    }

    @ApiOperation(value = "Delete Qualifications")
    @DeleteMapping("/remove-qualifications/{qualifications-id}")
    @ResponseBody
    public void delete(@PathVariable("qualifications-id") String matricule) {
        qualificationsService.delete(matricule);
    }

    @ApiOperation(value = "Récupérer la liste des Qualifications Active")
    @GetMapping(path="/qualificationsActive")
    public List<QualificationsResponseDTO> listQualificationsActive() {
        return qualificationsService.listQualificationsActive();
    }

}
