package com.table.relationship.config.batching;

import com.table.relationship.entity.Customer;
import com.table.relationship.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;



//@Configuration
//@EnableBatchProcessing
@RequiredArgsConstructor
public class SpringBatchConfiguration {
//
//    private JobBuilder jobBuilder; //JobBuilderFactory is Deprecated
//    private final CustomerRepository customerRepository;
//    private final JobRepository jobRepository;
//
//    private final CustomItemWriter customItemWriter;
//
//
//    @Bean
//    public FlatFileItemReader<Customer> reader(){
//        FlatFileItemReader<Customer> itemReader = new FlatFileItemReader<>();
//        itemReader.setResource(new FileSystemResource("src/main/resources/customers.csv"));
//        itemReader.setName("csvReader");
//        itemReader.setLinesToSkip(1);
//        itemReader.setLineMapper(lineMapper());
//        return itemReader;
//    }
//
//    private LineMapper<Customer> lineMapper() {
//        DefaultLineMapper<Customer> lineMapper = new DefaultLineMapper<>();
//
//        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
//        lineTokenizer.setDelimiter(","); //comma separated value (CSV)
//        lineTokenizer.setStrict(false);
//        lineTokenizer.setNames("id,firstName,lastName,email,gender,contactNo,country,dob"); //this so called as header
//
//        BeanWrapperFieldSetMapper<Customer> wrapperFieldMapper = new BeanWrapperFieldSetMapper<>();
//        wrapperFieldMapper.setTargetType(Customer.class);
//
//        lineMapper.setLineTokenizer(lineTokenizer);
//        lineMapper.setFieldSetMapper(wrapperFieldMapper);
//        return lineMapper;
//    }
//
//    @Bean
//    public CustomerProcessor customerProcessor(){
//        return new CustomerProcessor();
//    }
//
//    @Bean
//    public RepositoryItemWriter<Customer> repositoryItemWriter(){
//        RepositoryItemWriter<Customer> itemWriter = new RepositoryItemWriter<>();
//        itemWriter.setRepository(customerRepository);
//        itemWriter.setMethodName("save"); //this save comes from jpa repository which is being used by CustomerRepository
//        return itemWriter;
//    }
//
//    @Bean
//    public Job job(JobRepository jobRepository) {
//        return new JobBuilder("myJob").repository(jobRepository).start(step()).build();
//    }
//
//    @Bean
//    public Step step(){
//        return new StepBuilder("mystep")
//                .chunk(10)
//                .build();
//    }
//
//    @Bean
//    public StepBuilder stepBuilder(){
//        return new StepBuilder("myStep");
//    }



}
