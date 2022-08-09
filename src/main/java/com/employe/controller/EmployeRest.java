package com.employe.controller;

import com.employe.dto.EmployeRequestDTO;
import com.employe.dto.EmployeResponseDTO;
import com.employe.dto.EmployeUpdateDTO;
import com.employe.entity.Employe;
import com.employe.service.ActiviteService;
import com.employe.service.EmployeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@Api(tags = "Employe management")

public class EmployeRest {
    EmployeService employeService;
    ActiviteService activiteService;

    public EmployeRest(EmployeService employeService, ActiviteService activiteService) {
        this.employeService = employeService;
        this.activiteService = activiteService;
    }

    @ApiOperation(value = "Récupérer la liste des Employes")
    @GetMapping(path="/employes")
    public List<EmployeResponseDTO> allEmployes()
    {

        return employeService.listEmployes();
    }
    @ApiOperation(value = "Récupérer la liste des Employes Active")
    @GetMapping(path="/activeemployes")
    public List<EmployeResponseDTO> listActiveEmployes(){
        return employeService.listActiveEmployes();
    }
    @ApiOperation(value = "ajoute Employe")
    @PostMapping(path="/saveemploye")
    public EmployeResponseDTO save(EmployeRequestDTO employeRequestDTO){
        return employeService.save(employeRequestDTO);
    }
    @ApiOperation(value = "Récupérer Employe")
    @GetMapping(path = "/employe/{id}")
    public EmployeResponseDTO getEmploye(@PathVariable String id){

        return employeService.getEmploye(id);
    }


    @ApiOperation(value = "Delete Employe")
    @DeleteMapping("/remove-employe/{employe-id}")
    @ResponseBody
    public void delete(@PathVariable("employe-id") String matricule) {
        employeService.delete(matricule);
    }
    @ApiOperation(value = "Affecter activite TO employe")
    @PutMapping(value = "/affecterActiviteAEmploye/{code-activite}/{matricule}")
    public void affecterActiviteTOEmploye(@PathVariable("code-activite")String code, @PathVariable("matricule")String matricule) {
        employeService.affecterActiviteToEmploye(code,matricule);
    }
   /* @PutMapping(value = "/desaffecterEmployeDuDepartement/{idemp}/{iddept}")
    public void desaffecterEmployeDuDepartement(@PathVariable("idemp")String employeId, @PathVariable("iddept")String depId)
    {
        employeService.desaffecterEmployeDuActivite(employeId, depId);
    }*/

    @ApiOperation(value = "Update Employe")
    @PutMapping("/update-employedto/")
    @ResponseBody
    public void UpdateEmployeDTO(@RequestBody EmployeUpdateDTO dto) {
         employeService.updateEmployeDTO(dto);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception e)
    {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
    }
}
