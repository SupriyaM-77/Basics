package com.example.SpringData.service;

import com.example.SpringData.dto.ContestantDTO;
import com.example.SpringData.exception.NotFoundException;
import com.example.SpringData.model.Contestant;
import com.example.SpringData.repository.ContestantRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ContestantService {
    @Autowired
    private ContestantRepository contestantRepository;

    public ContestantDTO saveContestant(ContestantDTO contestantDTO) {
        Contestant contestant = new Contestant( contestantDTO.getName(), contestantDTO.getVotes());
        Contestant response = contestantRepository.save(contestant);
        contestantDTO.setId(response.getId());
        return contestantDTO;
    }


    public ContestantDTO getContest(int id) {
       Contestant response = contestantRepository.findById(id).orElse(null);
       ContestantDTO contestantDTO = new ContestantDTO();
        if(Objects.nonNull(response)){
            BeanUtils.copyProperties(response, contestantDTO);

        }
        else
        {
            //todo need to add a custom exception
            throw new NotFoundException("ID does not exist!!!");
        }

        return contestantDTO;
    }

//    public void deleteEmployee(int id) {
//        contestantRepository.deleteById(id);
//    }
}
