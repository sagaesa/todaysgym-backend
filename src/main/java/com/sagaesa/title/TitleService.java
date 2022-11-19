package com.sagaesa.title;

import com.sagaesa.record.RecordService;
import com.sagaesa.title.dto.TitleFindDto;
import com.sagaesa.user.User;
import com.sagaesa.user.UserRepository;
import com.sagaesa.user_title.UserTitle;
import com.sagaesa.user_title.UserTitleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TitleService {
    private final TitleRepository titleRepository;
    private final UserRepository userRepository;
    private final UserTitleRepository userTitleRepository;
    private final RecordService recordService;

    public List<TitleFindDto> findAll(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        List<UserTitle> userTitles = userTitleRepository.findAllByUserId(user);
        List<Title> titles = new ArrayList<>();
        List<TitleFindDto> titleFindDtos = new ArrayList<>();

        for(UserTitle userTitle : userTitles) {
            titles.add(userTitle.getTitleId());
        }

        for(Title title : titles) {
            TitleFindDto titleFindDto = TitleFindDto.builder()
                    .name(title.getName())
                    .build();

            titleFindDtos.add(titleFindDto);
        }

        return titleFindDtos;
    }

    public void titleGet(Long userId) { // 운동을 기록했을 때, 조건을 달성하면 title을 얻는 로직
        if(recordService.findAll(userId).size() >= 10) { // 기록한 운동이 10개 이상이면 ...
            UserTitle userTitle = UserTitle.builder()
                    .titleId(titleRepository.findById(1L).get())
                    .userId(userRepository.findById(userId).get())
                    .build();

            userTitleRepository.save(userTitle);
        }
    }
}
