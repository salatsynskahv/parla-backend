package com.parla.service.impl;

import com.parla.mapper.RecordMapper;
import com.parla.pojo.Record;
import com.parla.pojo.User;
import com.parla.pojo.front.RecordView;
import com.parla.repository.RecordRepository;
import com.parla.service.RecordService;
import com.parla.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class RecordServiceImpl implements RecordService {

    private final RecordRepository recordRepository;

    private final UserService userService;


    @Override
    public Record save(Record record) {
        return recordRepository.save(record);
    }

    @Override
    public List<Record> getRecordsByUserId(String userId) {
        return Collections.emptyList();
    }

    @Override
    public Record createRecord(RecordView recordView) {
        Record recordDto = RecordMapper.INSTANCE.mapToDto(recordView);
        AtomicReference<Record> savedRecord = new AtomicReference<>();
        User user = userService.findByUsername(recordView.getUserName());
        Optional.ofNullable(user).ifPresent(value -> {
            Optional.ofNullable(user.getRecords()).orElseGet(() -> {
                List<String> list = new ArrayList<>();
                user.setRecords(list);
                return list;
            });
            Record resultRecord = save(recordDto);
            user.getRecords().add(resultRecord.getId());
            userService.save(user);

        });
        return savedRecord.get();
    }

}
