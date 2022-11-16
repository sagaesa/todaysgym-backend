package com.sagaesa.record;

import com.sagaesa.record.dto.RecordDto;
import com.sagaesa.user.User;
import com.sagaesa.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
public class RecordService {
    @Autowired
    private final RecordRepository recordRepository;
    private final UserRepository userRepository;

    public void recordCreate(RecordDto recordDto) {
        Record record = new Record();

        User user = userRepository.findById(recordDto.getUserId()).orElseThrow();
        record.save(recordDto.getDate(), recordDto.getContent(), user);

        recordRepository.save(record);
    }
}
