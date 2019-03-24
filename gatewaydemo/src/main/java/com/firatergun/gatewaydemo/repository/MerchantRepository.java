package com.firatergun.gatewaydemo.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.firatergun.gatewaydemo.entity.Merchant;

public interface MerchantRepository extends JpaRepository<Merchant, Long>, QueryByExampleExecutor<Merchant>{

	@Query("select m from Merchant m where name like %?1%")
	Page<Merchant> findByName(Optional<String> name, Pageable pageable);
}
