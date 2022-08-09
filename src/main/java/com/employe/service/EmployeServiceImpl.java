package com.employe.service;

import com.employe.Exceptions.StatutNotActiveException;
import com.employe.dto.*;
import com.employe.entity.Activite;
import com.employe.entity.Employe;
import com.employe.entity.Statut;
import com.employe.mapper.ActiviteMapper;
import com.employe.mapper.EmployeMapper;
import com.employe.repository.ActiviteRepository;
import com.employe.repository.EmployeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmployeServiceImpl implements EmployeService {

    EmployeRepository employeRepository;
    ActiviteRepository activiteRepository;
    EmployeMapper employeMapper;
    ActiviteMapper activiteMapper;

    public EmployeServiceImpl(EmployeRepository employeRepository, ActiviteRepository activiteRepository, EmployeMapper employeMapper, ActiviteMapper activiteMapper) {
        this.employeRepository = employeRepository;
        this.activiteRepository = activiteRepository;
        this.employeMapper = employeMapper;
        this.activiteMapper = activiteMapper;
    }

    @Override
    public EmployeResponseDTO save(EmployeRequestDTO employeRequestDTO) {

        Employe employe =employeMapper.EmployeRequestDTOEmploye(employeRequestDTO);
        employe.setMatricule(UUID.randomUUID().toString());
        Employe saveEmploye=employeRepository.save(employe);
        EmployeResponseDTO employeResponseDTO=employeMapper.EmployeTOEmployeResponseDTO(saveEmploye);

        return employeResponseDTO;
    }

    @Override
    public EmployeResponseDTO getEmploye(String id) {

        Employe employe =employeRepository.findById(id).get();

        return employeMapper.EmployeTOEmployeResponseDTO(employe);
    }

    @Override
    public List<EmployeResponseDTO> listActiveEmployes(){
        List<Employe> employes=employeRepository.findEmployesByStatutActiver();
        List<EmployeResponseDTO>employeResponseDTOS=employes.stream()
                .map(cust->employeMapper.EmployeTOEmployeResponseDTO(cust))
                .collect(Collectors.toList());

        return employeResponseDTOS;
    }


    @Override
    public List<EmployeResponseDTO> listEmployes() {

        List<Employe> employes=employeRepository.findAll();

        List<EmployeResponseDTO>employeResponseDTOS=employes.stream()
                .map(cust->employeMapper.EmployeTOEmployeResponseDTO(cust))
                .collect(Collectors.toList());

        return employeResponseDTOS;
    }


    @Override
    public void delete(String id) {
       Employe employe= employeRepository.findById(id).get();
        for (Activite activite:employe.getQualifications())
        {
            activite.getEmployes().remove(employe);
        }
        employeRepository.delete(employe);
    }
    @Override
    public void affecterActiviteToEmploye(String code, String matricule) {

        Activite activite = activiteRepository.findById(code).get();
        if (activite.getStatut().equals(Statut.Activer)){
        Employe employe = employeRepository.findById(matricule).get();
        employe.getQualifications().add(activite);
        employeRepository.save(employe);}
        else throw new StatutNotActiveException("This Activite is not active ");


    }

    @Override
    public void updateEmployeDTO(EmployeUpdateDTO dto) {
        Employe myEmploye =employeRepository.findById(dto.getMatricule()).get();
        employeMapper.updateEmployeFromDto(dto, myEmploye);
        employeRepository.save(myEmploye);
    }
    /*@Override
    public void desaffecterEmployeDuActivite(String employeId, String depId)
    {
        Activite dep = activiteRepository.findById(depId).get();
        int employeNb = dep.getEmployes().size();
        for(int index = 0; index < employeNb; index++){
            if(dep.getEmployes().get(index).getMatricule() == employeId){
                dep.getEmployes().remove(index);
                break;//a revoir
            }
        }
    }*/
}
