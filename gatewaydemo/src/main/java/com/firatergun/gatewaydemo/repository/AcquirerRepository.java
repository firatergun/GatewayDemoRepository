package com.firatergun.gatewaydemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firatergun.gatewaydemo.entity.Acquirer;

public interface AcquirerRepository extends JpaRepository<Acquirer, Long>{

}
