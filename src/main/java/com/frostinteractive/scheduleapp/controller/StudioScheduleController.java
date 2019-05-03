package com.frostinteractive.scheduleapp.controller;


import com.frostinteractive.scheduleapp.domain.AvailabilityCheckDTO;
import com.frostinteractive.scheduleapp.domain.StudioSchedule;
import com.frostinteractive.scheduleapp.service.StudioScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
public class StudioScheduleController {

    @Autowired
    private StudioScheduleService service;

    @PostMapping("/schedule/check")
    public ResponseEntity<StudioSchedule> getByStudioNameAndDate(@RequestBody AvailabilityCheckDTO dto){
        Optional<StudioSchedule> optionalStudioSchedule = service.loadSchedule(dto);
        if(optionalStudioSchedule.isPresent())
            return ResponseEntity.ok(optionalStudioSchedule.get());
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/schedule")
    public ResponseEntity<Response> createSchedule(@RequestBody StudioSchedule studioSchedule){
        if(studioSchedule.getStudioScheduleId() == null || studioSchedule.getStudioScheduleId().isEmpty()){
            studioSchedule.setStudioScheduleId(UUID.randomUUID().toString());
        }
        service.createOrUpdateSchedule(studioSchedule);
        return ResponseEntity.ok(new Response("Schedule successfully created"));
    }

    @PutMapping("/schedule")
    public ResponseEntity<Response> updateSchedule(@RequestBody StudioSchedule studioSchedule){
        service.createOrUpdateSchedule(studioSchedule);
        return ResponseEntity.ok(new Response("Schedule successfully updated"));
    }
}
