package com.springehcache.repository;

import com.springehcache.model.HumanResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HumanResourceRepository extends JpaRepository<HumanResource, Long> {

    List<HumanResource> findByDepartment(HumanResource.Department department);
    List<HumanResource> findByDepartmentAndName(HumanResource.Department department, String name);

}
