package com.traini8.backend_traini8.controller;

import com.traini8.backend_traini8.model.TrainingCenter;
import com.traini8.backend_traini8.service.TrainingCenterService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
/**
 * REST controller for managing training center resources.
 * Provides endpoints for creating and retrieving training centers.
 */
@RestController
@RequestMapping("/training-centers")
public class TrainingCenterController {

    private final TrainingCenterService service;

    public TrainingCenterController(TrainingCenterService service) {

        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TrainingCenter> createTrainingCenter(@Valid @RequestBody TrainingCenter trainingCenter) {
        TrainingCenter savedCenter = service.saveTrainingCenter(trainingCenter);
        return ResponseEntity.ok(savedCenter);
    }

    @GetMapping
    public ResponseEntity<List<TrainingCenter>> getTrainingCenters(
            @RequestParam Optional<String> city,
            @RequestParam Optional<String> state,
            @RequestParam Optional<String> course
           ) {

        // If no filter parameters are provided, return all centers
        if (city.isEmpty() && state.isEmpty() && course.isEmpty()) {
            return ResponseEntity.ok(service.getAllTrainingCenters());
        }

        // Otherwise, apply filters
        List<TrainingCenter> centers = service.getFilteredTrainingCenters(city, state, course);
        return ResponseEntity.ok(centers);
    }
}
