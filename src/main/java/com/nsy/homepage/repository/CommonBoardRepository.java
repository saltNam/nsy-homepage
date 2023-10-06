package com.nsy.homepage.repository;


import com.nsy.homepage.domain.CommonBoard;
import com.nsy.homepage.repository.custom.CommonBoardRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommonBoardRepository extends JpaRepository<CommonBoard, Long>, CommonBoardRepositoryCustom {
}
