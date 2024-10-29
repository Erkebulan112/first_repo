package com.erkosh.services;

import com.erkosh.dto.PassportDTO;
import com.erkosh.entities.PassportEntity;
import com.erkosh.mappers.PassportMapper;
import com.erkosh.mappers.StudentMapper;
import com.erkosh.repositories.PassportRepository;
import com.erkosh.repositories.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class PassportService {

    private final PassportRepository passportRepository;
    private final PassportMapper passportMapper;

    public PassportService(PassportRepository passportRepository, PassportMapper passportMapper) {
        this.passportRepository = passportRepository;
        this.passportMapper = passportMapper;
    }

    public List<PassportDTO> getAllPassports() {
        List<PassportEntity> passports = passportRepository.findAll();
        return passports.stream()
                .map(passportMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PassportDTO getPassportById(long id) {
        PassportEntity passport = passportRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Passport not found id:" + id));
        return passportMapper.toDTO(passport);
    }

    @Transactional
    public PassportDTO addPassport(PassportDTO passportDTO) {
        PassportEntity passport = passportMapper.toEntity(passportDTO);
        PassportEntity newPassport = passportRepository.save(passport);
        return passportMapper.toDTO(newPassport); // исправлено
    }

    @Transactional
    public PassportDTO updatePassport(long id, PassportDTO passportDTO) {
        PassportEntity passport = passportRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Passport not found"));
        passport.setPassportNumber(Long.parseLong(passportDTO.getPassportNumber())); // Валидация здесь
        PassportEntity updatedPassport = passportRepository.save(passport);
        return passportMapper.toDTO(updatedPassport);
    }

    @Transactional
    public String deletePassport(long id) {
        passportRepository.deleteById(id);
        return "Passport deleted";
    }
}
