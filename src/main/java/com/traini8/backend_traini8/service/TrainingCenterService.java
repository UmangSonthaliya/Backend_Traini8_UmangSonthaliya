package com.traini8.backend_traini8.service;

import com.traini8.backend_traini8.model.TrainingCenter;
import com.traini8.backend_traini8.repository.TrainingCenterRepository;
//import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TrainingCenterService {

    private final TrainingCenterRepository repository;

    public TrainingCenterService(TrainingCenterRepository repository) {
        this.repository = repository;
    }

    public TrainingCenter saveTrainingCenter(TrainingCenter trainingCenter) {
        return repository.save(trainingCenter);
    }

    public List<TrainingCenter> getAllTrainingCenters() {

        return repository.findAll();
    }

    public List<TrainingCenter> getFilteredTrainingCenters(
            Optional<String> city,
            Optional<String> state,
            Optional<String> course){

        // Fetch all centers from the database
        List<TrainingCenter> centers = repository.findAll();

        return centers.stream()
                .filter(tc -> city.map(c -> tc.getAddress().getCity().equalsIgnoreCase(c)).orElse(true))
                .filter(tc -> state.map(s -> tc.getAddress().getState().equalsIgnoreCase(s)).orElse(true))
                .filter(tc -> course.map(crs -> tc.getCoursesOffered().contains(crs)).orElse(true))
                .collect(Collectors.toList());


    }
}
