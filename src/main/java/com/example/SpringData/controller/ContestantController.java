package com.example.SpringData.controller;

import com.example.SpringData.dto.ContestantDTO;
import com.example.SpringData.service.ContestantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contestants")
public class ContestantController {
    @Autowired
    private ContestantService contestantService;

    @PostMapping("/")
    public ResponseEntity<ContestantDTO> createContest(@RequestBody ContestantDTO contestantDTO){
        return ResponseEntity.ok(contestantService.saveContestant(contestantDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContestantDTO> getContest(@PathVariable int id){
        return ResponseEntity.ok(contestantService.getContest(id));
    }

//    @DeleteMapping("/{id}")
//    public void deleteStudent(@PathVariable int id) {
//        ContestantService.deleteContestant(id);
//    }
}
