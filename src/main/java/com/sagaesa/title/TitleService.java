package com.sagaesa.title;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TitleService {
    private final TitleRepository titleRepository;
}
