package com.frostinteractive.scheduleapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "studio_schedule_slot")
public class StudioScheduleSlot {

    @Id
    @Column(name = "studio_schedule_slot_id")
    private String studioScheduleSlotId = UUID.randomUUID().toString();

//    @Column(name = "studio_name")
//    private String studioName;

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "end_time")
    private String endTime;

    @Column(name = "faculty")
    private String faculty;

    @Column(name = "assignerName")
    private String assignerName;
}
