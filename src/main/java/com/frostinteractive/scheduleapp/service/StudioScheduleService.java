package com.frostinteractive.scheduleapp.service;

import com.frostinteractive.scheduleapp.domain.AvailabilityCheckDTO;
import com.frostinteractive.scheduleapp.domain.StudioSchedule;
import com.frostinteractive.scheduleapp.domain.StudioScheduleSlot;
import com.frostinteractive.scheduleapp.domain.repository.StudioScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudioScheduleService {

    @Autowired
    private StudioScheduleRepository repository;

    public Optional<StudioSchedule> loadSchedule(AvailabilityCheckDTO availabilityCheckDTO){
        return repository.findByStudioNameAndDate(availabilityCheckDTO.getStudioName(),availabilityCheckDTO.getLocalDate());
    }


    public void createOrUpdateSchedule(StudioSchedule studioSchedule){
        repository.save(studioSchedule);
    }

    public void deleteSchedule(String studioScheduleId){
        repository.deleteById(studioScheduleId);
    }

    public List<StudioScheduleSlot> loadScheduleByfaculty(String faculty){
        List<StudioSchedule> studioSchedules = new ArrayList<>();
        repository.findAll().forEach(x->studioSchedules.add(x));
        List<StudioScheduleSlot> studioScheduleSlots = studioSchedules.stream()
                .flatMap(x->x.getStudioScheduleSlotList().stream())
                .filter(y->y.getFaculty().equals(faculty))
                .collect(Collectors.toList());
        return studioScheduleSlots;
    }
}
