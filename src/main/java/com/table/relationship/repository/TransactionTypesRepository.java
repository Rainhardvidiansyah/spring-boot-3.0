package com.table.relationship.repository;

import com.table.relationship.entity.TransactionTypes;
import com.table.relationship.enumeration.ETYPE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface TransactionTypesRepository extends JpaRepository<TransactionTypes, Long> {

    Optional<TransactionTypes> findTransactionTypeByTypes(ETYPE etype);


}
