package com.imhaider.springbootmysql.controller.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/exercises")
public class ExerciseController {

    private final ExerciseService exerciseService;

    @PostMapping
    public Exercise createExercise(@RequestBody Exercise exercise) {
        return exerciseService.createExercise(exercise);
    }

    @GetMapping("/{exerciseId}")
    public Exercise getExerciseById(@PathVariable Long exerciseId) {
        return exerciseService.getExerciseById(exerciseId);
    }

    // Add more endpoints for fetching all exercises, updating exercises, deleting exercises, etc.
}

