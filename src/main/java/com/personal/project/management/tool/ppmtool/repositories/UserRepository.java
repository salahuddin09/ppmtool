package com.personal.project.management.tool.ppmtool.repositories;

import com.personal.project.management.tool.ppmtool.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}