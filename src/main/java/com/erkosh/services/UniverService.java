package com.erkosh.services;

import com.erkosh.dto.UniverDTO;
import com.erkosh.entities.UniverEntity;
import com.erkosh.mappers.UniverMapper;
import com.erkosh.repositories.UniverRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class UniverService {

    private final UniverRepository univerRepository;
    private final UniverMapper univerMapper;

    public UniverService(UniverRepository univerRepository, UniverMapper univerMapper) {
        this.univerRepository = univerRepository;
        this.univerMapper = univerMapper;
    }

    public List<UniverDTO> getAllUnivers() {
        List<UniverEntity> univers = univerRepository.findAll();
        return univers.stream()
                .map(univerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public UniverDTO getUniverById(long id) {
        UniverEntity univer = univerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Univer not found" + id));
        return univerMapper.toDTO(univer);
    }

    @Transactional
    public UniverDTO addUniver(UniverDTO univerDTO) {
        UniverEntity univer = univerMapper.toEntity(univerDTO);
        UniverEntity newUniver = univerRepository.save(univer);
        return univerMapper.toDTO(newUniver);
    }

    @Transactional
    public UniverDTO updateUniver(long id,UniverDTO univerDTO) {
        UniverEntity univer = univerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Univer not found" + id));
        univer.setUniverName(univerDTO.getUniverName());
        univer.setLocation(univerDTO.getLocation());
        return univerMapper.toDTO(univerRepository.save(univer));
    }

    @Transactional
    public void deleteUniver(Long id) {
        if (univerRepository.existsById(id)) {
            univerRepository.deleteById(id);
        } else
            throw new EntityNotFoundException("Univer not found" + id);
    }
}
