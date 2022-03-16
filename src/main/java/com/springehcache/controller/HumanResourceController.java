package com.springehcache.controller;

import com.springehcache.model.HumanResource;
import com.springehcache.service.HumanResourceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hr")
@RequiredArgsConstructor
@Slf4j
public class HumanResourceController {

    private final HumanResourceService hrService;

    @GetMapping(path = "/map")
    public ResponseEntity<Map<String, List<HumanResource>>> getHrByDepartment() {
        log.info("call api getHrByDepartment");
        return ResponseEntity.ok(hrService.getHrByDepartment());
    }

    @GetMapping(path = "/list")
    public ResponseEntity<List<HumanResource>> getHrList() {
        log.info("call api getHrList");
        return ResponseEntity.ok(hrService.getHrList());
    }

    @GetMapping(path = "/list/{department}")
    public ResponseEntity<List<HumanResource>> getHrByDepartment(@PathVariable String department) {
        log.info("call api getHrByDepartment");
        return ResponseEntity.ok(hrService.getHrListByDepartment(department));
    }

    @GetMapping(path = "/list/{department}/{name}")
    public ResponseEntity<List<HumanResource>> getHrByDepartmentAndName(@PathVariable String department, @PathVariable String name) {
        log.info("call api getHrByDepartmentAndName");
        return ResponseEntity.ok(hrService.getHrListByDepartmentAndName(department, name));
    }

}
