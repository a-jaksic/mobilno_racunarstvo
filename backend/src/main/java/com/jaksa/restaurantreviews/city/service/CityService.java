package com.jaksa.restaurantreviews.city.service;

import com.jaksa.restaurantreviews.city.domain.City;
import com.jaksa.restaurantreviews.city.dtos.CityCreateDTO;
import com.jaksa.restaurantreviews.city.dtos.CityDTO;
import com.jaksa.restaurantreviews.city.mapper.CityMapper;
import com.jaksa.restaurantreviews.city.repository.CityRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service managing cities within the system.
 * Handles retrieval, creation, and deletion of city entries.
 * @author Aleksa Jaksic (a-jaksic)
 */
@Service
public class CityService {

    private final CityRepository cityRepository;

    private final CityMapper cityMapper;

    public CityService(CityRepository cityRepository, CityMapper cityMapper){
        this.cityRepository = cityRepository;
        this.cityMapper = cityMapper;
    }

    /**
     * Retrieves a specific city by its unique identifier.
     * @param id unique identifier of the city.
     * @return CityDTO containing the mapped city data.
     * @throws jakarta.persistence.EntityNotFoundException If no city matches the provided identifier.
     */
    public CityDTO get(Long id) {
        return cityRepository.findById(id)
                .map(cityMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("No city found with id: " + id));
    }

    /**
     * Retrieves all cities registered in the system.
     * @return List of CityDTO objects.
     */
    public List<CityDTO> list() {
        return cityRepository.findAll()
                .stream()
                .map(cityMapper::toDTO)
                .toList();
    }

    /**
     * Creates and registers a new city in the database.
     * @param cityCreateDTO DTO data required to build a city entity.
     * @return CityDTO of the newly saved city.
     */
    @Transactional
    public CityDTO create(CityCreateDTO cityCreateDTO) {
        City city = cityMapper.toEntity(cityCreateDTO);
        return cityMapper.toDTO(cityRepository.save(city));
    }

    /**
     * Deletes a city from the database by its unique identifier.
     * @param id unique identifier of the city to delete.
     * @throws jakarta.persistence.EntityNotFoundException If the city with the given identifier does not exist.
     */
    @Transactional
    public void delete(Long id) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Could not find city with given id!"));

        cityRepository.delete(city);
    }
}

