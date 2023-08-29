package chamath.css.BudgetApp.service;

import chamath.css.BudgetApp.dto.DemoRequest;
import chamath.css.BudgetApp.dto.DemoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DemoService {

    public DemoResponse demo(DemoRequest demoRequest){
        return DemoResponse
                .builder()
                .message(demoRequest.getMessage())
                .build();
    }
}
