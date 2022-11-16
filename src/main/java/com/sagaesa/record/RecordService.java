package com.sagaesa.record;

import com.sagaesa.record.dto.RecordCreateDto;
import com.sagaesa.record.dto.RecordFindDto;
import com.sagaesa.user.User;
import com.sagaesa.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional
public class RecordService {
    @Autowired
    private final RecordRepository recordRepository;
    private final UserRepository userRepository;

    public void recordCreate(RecordCreateDto recordCreateDto) {
        Record record = new Record();

        Optional<User> user = userRepository.findById(recordCreateDto.getUserId());
        record.save(recordCreateDto.getDate(), recordCreateDto.getContent(), user.get());

        recordRepository.save(record);
    }

    public RecordFindDto findOne(Long recordId) {
        Optional<Record> record = recordRepository.findById(recordId);

        return RecordFindDto.builder()
                .date(record.get().getDate())
                .content(record.get().getContent())
                .build();
    }
}
