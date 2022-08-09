package com.employe.service;

import com.employe.dto.ActiviteRequestDTO;
import com.employe.dto.ActiviteResponseDTO;
import com.employe.dto.ActiviteUpdateDTO;
import com.employe.dto.EmployeResponseDTO;
import com.employe.entity.Activite;
import com.employe.entity.Employe;
import com.employe.entity.Qualifications;
import com.employe.mapper.ActiviteMapper;
import com.employe.repository.ActiviteRepository;
import com.employe.repository.EmployeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class ActiviteServiceImpl implements ActiviteService {

    ActiviteRepository activiteRepository;
    ActiviteMapper activiteMapper;
    EmployeRepository employeRepository;

    public ActiviteServiceImpl(ActiviteRepository activiteRepository, ActiviteMapper activiteMapper, EmployeRepository employeRepository) {
        this.activiteRepository = activiteRepository;
        this.activiteMapper = activiteMapper;
        this.employeRepository = employeRepository;
    }

    @Override
    public ActiviteResponseDTO save(ActiviteRequestDTO activiteRequestDTO) {
        Activite activite =activiteMapper.ActiviteRequestDTOActivite(activiteRequestDTO);
        activite.setCode(UUID.randomUUID().toString());
        Activite saveActivite=activiteRepository.save(activite);
        ActiviteResponseDTO activiteResponseDTO=activiteMapper.ActiviteTOActiviteResponseDTO(saveActivite);


        return activiteResponseDTO;
    }

    @Override
    public ActiviteResponseDTO getActivite(String id) {

        Activite activite =activiteRepository.findById(id).get();

        return activiteMapper.ActiviteTOActiviteResponseDTO(activite);
    }

    @Override
    public void updateActivite(ActiviteUpdateDTO dto) {
        Activite myActivite =activiteRepository.findById(dto.getCode()).get();
        activiteMapper.updateActiviteFromDto(dto, myActivite);
        activiteRepository.save(myActivite);

    }

    @Override
    public void delete(String id) {
        Activite activite= activiteRepository.findById(id).get();

        for (Employe employe:activite.getEmployes()){
            employe.getQualifications().remove(activite);
        }

        activiteRepository.delete(activite);

    }

    @Override
    public List<ActiviteResponseDTO> listActivitesActive() {
        List<Activite> activites=activiteRepository.findByActive();
        List<ActiviteResponseDTO>activiteResponseDTOS=activites.stream()
                .map(cust->activiteMapper.ActiviteTOActiviteResponseDTO(cust))
                .collect(Collectors.toList());

        return activiteResponseDTOS;
    }

    @Override
    public List<ActiviteResponseDTO> listActivites() {

        List<Activite> activites=activiteRepository.findAll();
        List<ActiviteResponseDTO>activiteResponseDTOS=activites.stream()
                .map(cust->activiteMapper.ActiviteTOActiviteResponseDTO(cust))
                .collect(Collectors.toList());

        return activiteResponseDTOS;
    }
}
