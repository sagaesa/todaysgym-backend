package com.sagaesa.record;

import com.sagaesa.record.dto.RecordCreateDto;
import com.sagaesa.record.dto.RecordFindDto;
import com.sagaesa.record.dto.RecordUpdateDto;
import com.sagaesa.user.User;
import com.sagaesa.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional
public class RecordService {
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

    public List<RecordFindDto> findAll(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        List<Record> records = recordRepository.findAllByUserId(user);
        List<RecordFindDto> recordFindDtos = new ArrayList<>();

        for (Record record : records) {
            RecordFindDto recordFindDto = RecordFindDto.builder()
                    .date(record.getDate())
                    .content(record.getContent())
                    .build();

            recordFindDtos.add(recordFindDto);
        }

        return recordFindDtos;
    }

    public RecordFindDto update(RecordUpdateDto recordUpdateDto) {
        Record record = recordRepository.findById(recordUpdateDto.getRecordId()).orElseThrow();
        record.update(recordUpdateDto.getDate(), recordUpdateDto.getContent());

        return RecordFindDto.builder()
                .date(record.getDate())
                .content(record.getContent())
                .build();
    }

    public void delete(Long recordId) {
        recordRepository.deleteById(recordId);
    }
}
