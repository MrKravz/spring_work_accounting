package ru.egar.spring_work_accounting.total;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TotalAdapterService {

    private final TotalService totalService;
    private final TotalDtoMapper totalDtoMapper;


    public TotalDto findById(Long id) {
        return totalDtoMapper.map(totalService.findById(id));
    }

    @Transactional
    public Long generateTotal(GenerateTotalRequest entity) {
        return totalService.generateTotal(entity);
    }

    @Transactional
    public void delete(Long id) {
        totalService.delete(id);
    }

}
