package com.firatergun.gatewaydemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firatergun.gatewaydemo.entity.CustomerInfo;

public interface CustomerInfoRepository extends JpaRepository<CustomerInfo, Long>{

}
