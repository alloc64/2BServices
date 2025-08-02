/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.dao;

import jakarta.transaction.Transactional;
import net.twobid.googleads.dao.model.CustomConversionActionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface CustomConversionActionRepository extends JpaRepository<CustomConversionActionEntity, Long> {
    Optional<CustomConversionActionEntity> findByUserIdAndCustomerIdAndId(String name, long customerId, long actionId);

    List<CustomConversionActionEntity> findAllByUserIdAndCustomerId(String name, long customerId);

    void deleteByUserIdAndCustomerIdAndId(String name, long conversionActionId, long actionId);
}
