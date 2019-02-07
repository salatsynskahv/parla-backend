package com.parla.controller;


import com.parla.pojo.Record;
import com.parla.pojo.front.RecordView;
import com.parla.service.RecordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController("/record")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class RecordController {

    //todo: autowire existing user
//    private final AuthenticatedUser user;

    private final RecordService recordService;

    @GetMapping
    public List<Record> getRecordsByUserId(@RequestParam("userid") String userId) {
        log.info("getRecordsByUserId: userId: {}", userId);
        return recordService.getRecordsByUserId(userId);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Record createRecord(@RequestBody RecordView recordView) {
        log.info("createRecord: record: {}", recordView);
        return recordService.createRecord(recordView);
    }
}
