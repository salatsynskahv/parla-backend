package com.parla.service;

import com.parla.pojo.Record;
import com.parla.pojo.front.RecordView;

import java.util.List;

public interface RecordService {

    Record save(Record record);

    List<Record> getRecordsByUserId(String userId);

    Record createRecord(RecordView recordView);
}
