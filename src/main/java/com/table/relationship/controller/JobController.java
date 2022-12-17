package com.table.relationship.controller;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/v1/batch")
public class JobController {
//
//    private final JobLauncher jobLauncher;
//    private final Job job;
//
//    @Autowired
//    public JobController(JobLauncher jobLauncher, Job job){
//        this.jobLauncher = jobLauncher;
//        this.job = job;
//    }
//
//    @PostMapping("/import-customer-csv")
//    public void importCsv(){
//        JobParameters jobParameter = new JobParametersBuilder()
//                .addLong("startAt", System.currentTimeMillis()).toJobParameters();
//        try {
//            jobLauncher.run(job, jobParameter);
//        } catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException | JobParametersInvalidException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
