package com.employe.service;

import com.employe.dto.QualificationsResponseDTO;
import com.employe.dto.QualificationsRequestDTO;
import com.employe.dto.QualificationsResponseDTO;
import com.employe.dto.QualificationsUpdateDTO;
import com.employe.entity.Employe;
import com.employe.entity.Qualifications;
import com.employe.mapper.QualificationsMapper;
import com.employe.repository.QualificationsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class QualificationsServiceImpl implements QualificationsService {
    QualificationsRepository qualificationsRepository;
    QualificationsMapper qualificationsMapper;

    public QualificationsServiceImpl(QualificationsRepository qualificationsRepository, QualificationsMapper qualificationsMapper) {
        this.qualificationsRepository = qualificationsRepository;
        this.qualificationsMapper = qualificationsMapper;
    }

    @Override
    public QualificationsResponseDTO save(QualificationsRequestDTO qualificationsRequestDTO) {

        Qualifications qualifications =qualificationsMapper.QualificationsRequestDTOQualifications(qualificationsRequestDTO);
         qualifications.setCode(UUID.randomUUID().toString());
        Qualifications saveQualifications=qualificationsRepository.save(qualifications);
        QualificationsResponseDTO qualificationsResponseDTO=qualificationsMapper.QualificationsTOQualificationsResponseDTO(saveQualifications);


        return qualificationsResponseDTO;
    }

    @Override
    public QualificationsResponseDTO getQualifications(String id) {

        Qualifications qualifications =qualificationsRepository.findById(id).get();

        return qualificationsMapper.QualificationsTOQualificationsResponseDTO(qualifications);
    }



    @Override
    public List<QualificationsResponseDTO> listQualifications() {

        List<Qualifications> qualificationss=qualificationsRepository.findAll();
        List<QualificationsResponseDTO>qualificationsResponseDTOS=qualificationss.stream()
                .map(cust->qualificationsMapper.QualificationsTOQualificationsResponseDTO(cust))
                .collect(Collectors.toList());

        return qualificationsResponseDTOS;
    }
    @Override
    public void updateQualifications(QualificationsUpdateDTO dto) {

        Qualifications myQualifications =qualificationsRepository.findById(dto.getCode()).get();
        qualificationsMapper.updateQualificationsFromDto(dto, myQualifications);
        qualificationsRepository.save(myQualifications);

    }

    @Override
    public void delete(String id) {
        qualificationsRepository.deleteById(id);
    }

    @Override
    public List<QualificationsResponseDTO> listQualificationsActive() {
        List<Qualifications> qualifications=qualificationsRepository.findByActiveQualifications();
        List<QualificationsResponseDTO>qualificationsResponseDTOS=qualifications.stream()
                .map(cust->qualificationsMapper.QualificationsTOQualificationsResponseDTO(cust))
                .collect(Collectors.toList());

        return qualificationsResponseDTOS;
    }
}
