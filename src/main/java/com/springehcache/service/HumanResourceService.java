package com.springehcache.service;

import com.springehcache.model.HumanResource;
import com.springehcache.repository.HumanResourceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class HumanResourceService {

    private final HumanResourceRepository humanResourceRepository;

    @Cacheable(value = "hrByDepartmentCache")
    public Map<String, List<HumanResource>> getHrByDepartment() {
        log.info("]-----] hrTxManager getHrByDepartment [-----[");
        Map<String, List<HumanResource>> map = new HashMap<>();

        for (HumanResource.Department department : HumanResource.Department.values()) {
            map.put(department.toString(), humanResourceRepository.findByDepartment(department));
        }

        return map;
    }

    @Cacheable(value = "hrListCache")
    public List<HumanResource> getHrList() {
        log.info("]-----] hrTxManager getHrList [-----[");
        return humanResourceRepository.findAll();
    }

    @Cacheable(value = "hrListByDepartmentCache", key = "#department")
    public List<HumanResource> getHrListByDepartment(String department) {
        log.info("]-----] hrTxManager getHrListByDepartment [-----[");
        return humanResourceRepository.findByDepartment(new HumanResource().getStringDepartment(department));
    }

    @Cacheable(value = "hrListByDepartmentAndNameCache", key = "{#department, #name}") // 2개 이상의 키 사용. 두 개의 키가 모두 일치해야 캐시 데이터를 찾을 수 있음.
    public List<HumanResource> getHrListByDepartmentAndName(String department, String name) {
        log.info("]-----] hrTxManager hrListByDepartmentAndNameCache : {}, {} [-----[", department, name);
        return humanResourceRepository.findByDepartmentAndName(new HumanResource().getStringDepartment(department), name);
    }

}
