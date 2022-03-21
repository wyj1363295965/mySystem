package com.tik.mysystem.system.mybatisPlus;

import com.tik.mysystem.system.entity.DemoData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface DemoDAO extends JpaRepository<DemoData,Long> {
}
