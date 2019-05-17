package com.address.manage.repository;

import com.address.manage.entity.AddressManage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressManageRepository extends JpaRepository<AddressManage, Integer> {
}
