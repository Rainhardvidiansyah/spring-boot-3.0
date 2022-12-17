package com.table.relationship.config.batching;

import com.table.relationship.entity.Customer;
import com.table.relationship.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomItemWriter implements ItemWriter<Customer> {

        private final CustomerRepository customerRepository;

    @Override
    public void write(Chunk<? extends Customer> customers) throws Exception {
        customerRepository.saveAll(customers);
    }
}
