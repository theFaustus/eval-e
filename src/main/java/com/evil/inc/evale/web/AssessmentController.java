package com.evil.inc.evale.web;

import com.evil.inc.evale.domain.User;
import com.evil.inc.evale.service.AssessmentService;
import com.evil.inc.evale.service.UserService;
import com.evil.inc.evale.service.dto.AssessmentSummaryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/assessments")
@RequiredArgsConstructor
public class AssessmentController {

    private final AssessmentService assessmentService;

    @GetMapping
    public ModelAndView viewAllAssessments(){
        final List<AssessmentSummaryDto> all = assessmentService.getAll();
        final ModelAndView modelAndView = new ModelAndView("assessments");
        modelAndView.addObject("assessments", all);
        return modelAndView;
    }
}
