package chamath.css.BudgetApp.controller;

import chamath.css.BudgetApp.dto.DemoRequest;
import chamath.css.BudgetApp.dto.DemoResponse;
import chamath.css.BudgetApp.service.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo-controller")
@RequiredArgsConstructor
public class DemoController {

    @Autowired
    private final DemoService demoService;


    @GetMapping("/demo")
    public ResponseEntity<DemoResponse> demo(
            @RequestBody DemoRequest demoRequest
            ) {
        return ResponseEntity.ok(demoService.demo(demoRequest));
    }
}
