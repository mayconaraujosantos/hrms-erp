package com.mkdata.company.infra.persistence;

import com.mkdata.company.domain.entity.JobPosting;
import com.mkdata.company.domain.enums.EducationLevel;
import com.mkdata.company.domain.enums.ExperienceLevel;
import com.mkdata.company.domain.enums.JobStatus;
import com.mkdata.company.domain.enums.JobType;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JobPostingRepository extends JpaRepository<JobPosting, Long> {

    // Retorna a lista de trabalhos com salário acima de um determinado valor e ordena por ordem
    // decrescente de salário
    List<JobPosting> findBySalaryGreaterThanOrderBySalaryDesc(Double salary);

    // Retorna a lista de trabalhos com uma determinada descrição de trabalho
    List<JobPosting> findByJobDescriptionContainingIgnoreCase(String jobDescription);

    // Retorna a lista de trabalhos postados após uma determinada data
    List<JobPosting> findByJobPostedDateAfter(Date date);

    // Retorna a lista de trabalhos com um determinado tipo de trabalho e nível de experiência
    List<JobPosting> findByJobTypeAndExperienceLevel(JobType jobType, ExperienceLevel experienceLevel);

    // Retorna a lista de trabalhos com um determinado status de trabalho e data de postagem antes de
    // uma determinada data
    List<JobPosting> findByJobStatusAndJobPostedDateBefore(JobStatus jobStatus, Date date);

    // Retorna a lista de trabalhos com um determinado nível de escolaridade ou superior e com um
    // determinado tipo de trabalho
    List<JobPosting> findByEducationLevelGreaterThanEqualAndJobType(EducationLevel educationLevel, JobType jobType);

    // Retorna a lista de trabalhos que estão com a data limite de inscrição para a vaga dentro do
    // prazo ou ainda não passou do prazo
    @Query(
            "SELECT jp FROM JobPosting jp WHERE jp.jobStatus <> 'CLOSED' AND (jp.applicationDeadline IS NULL OR jp.applicationDeadline >= CURRENT_DATE)")
    List<JobPosting> findOpenJobPostings();

    // Consulta que retorna a lista de trabalhos ordenados por ordem decrescente da data de postagem
    List<JobPosting> findAllByOrderByJobPostedDateDesc();

    // Consulta que retorna a lista de trabalhos com uma data limite de inscrição posterior a uma
    // determinada data
    List<JobPosting> findByApplicationDeadlineAfter(Date date);

    // Consulta que retorna a lista de trabalhos com um determinado tipo de trabalho e nível de
    // escolaridade
    List<JobPosting> findByJobTypeAndEducationLevel(JobType jobType, EducationLevel educationLevel);

    // Consulta que retorna a lista de trabalhos com um determinado status de trabalho e uma data de
    // postagem entre duas datas
    List<JobPosting> findByJobStatusAndJobPostedDateBetween(JobStatus jobStatus, Date startDate, Date endDate);

    // Consulta que retorna a lista de trabalhos com um determinado nível de experiência ou superior e
    // salário superior a um determinado valor
    List<JobPosting> findByExperienceLevelGreaterThanEqualAndSalaryGreaterThanEqual(
            ExperienceLevel experienceLevel, Double salary);

    // Consulta personalizada que retorna a lista de trabalhos que ainda não tiveram o prazo de
    // inscrição expirado, ordenados por ordem crescente de data de postagem
    @Query(
            "SELECT jp FROM JobPosting jp WHERE jp.applicationDeadline IS NULL OR jp.applicationDeadline >= CURRENT_DATE ORDER BY jp.jobPostedDate ASC")
    List<JobPosting> findActiveJobPostings();
}
