/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.controller;

import com.gut.practice.entity.Faq;
import com.gut.practice.entity.JobOffer;
import com.gut.practice.entity.Practice;
import com.gut.practice.entity.file.News;
import com.gut.practice.service.FaqService;
import com.gut.practice.service.JobOfferService;
import com.gut.practice.service.NewsService;
import com.gut.practice.service.PracticeService;
import com.gut.practice.util.ConfirmationStatus;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author janusz
 */
@ManagedBean
public class MainCtrl implements Serializable {

    @EJB
    NewsService newsService;
    @EJB
    FaqService faqService;
    @EJB
    PracticeService practiceService;
    @EJB
    JobOfferService jobOfferService;

    private final List<String> availbleRoles = new ArrayList<>();
    private String selectedRole;

    private final List<String> availableOpinions = new ArrayList<>();
    private String selectedOpinion;

    public MainCtrl() {
        System.out.println("[MainCtrl] init");
    }

    @PostConstruct
    private void init() {
        initNews();
        initRoles();
        initOptions();
        initFaq();
//        initPractice();
//        initJobOffers();
    }

    public List<String> getAvailableOpinions() {
        return availableOpinions;
    }

    public String getSelectedOpinion() {
        return selectedOpinion;
    }

    public final void setSelectedOpinion(String selectedOpinion) {
        this.selectedOpinion = selectedOpinion;
    }

    @Deprecated
    private void initOptions() {
        if (availableOpinions.isEmpty()) {
            availableOpinions.add("1_POOR");
            availableOpinions.add("2_WEEK");
            availableOpinions.add("3_OK");
            availableOpinions.add("4_NICE");
            availableOpinions.add("5_GREAT");
            setSelectedOpinion(availableOpinions.get(2));
        };
    }

    @Deprecated
    private void initRoles() {
        if (availbleRoles.isEmpty()) {
            this.selectedRole = null;
            availbleRoles.add("STUDENT");
            availbleRoles.add("COORDINATOR");
            availbleRoles.add("EMPLOYER");
            selectedRole = availbleRoles.get(0);
        };
    }

    @Deprecated
    private void initNews() {
        if (newsService.getAll().isEmpty()) {
            String desc = "";
            for (int i = 1; i < 5; i++) {
                desc = desc.concat("Description-" + i + "  ");

                News oneNew = new News();
                oneNew.setDescription(desc);
                oneNew.setTitle("Title " + i);
                oneNew.setUrlPhoto("url");
                System.out.println("I'm adding " + oneNew.getTitle());
                newsService.add(oneNew);
            }
        }
    }

    @Deprecated
    private void initFaq() {
        if (faqService.getAll().isEmpty()) {
            Faq question = new Faq();
            for (int i = 1; i < 5; i++) {
                question = new Faq();
                question.setQuestion("QUESTION " + i);
                question.setAnswer("ANSWER " + i);
                faqService.add(question);
            }
        }
    }

    @Deprecated
    private void initPractice() {
        if (practiceService.getAll().isEmpty()) {
            Practice practice;
            for (int i = 1; i < 5; i++) {
                practice = new Practice();
                practice.setTitle("Praktyka nr. " + i);
                practice.setDescription("To jest opis dla praktyki nr" + i);
                practice.setConfirmationStatus(ConfirmationStatus.values()[ConfirmationStatus.values().length % i]);
                practice.setHours(i * 55 % 80);
                practiceService.add(practice);
            }
        }
    }

    @Deprecated
    private void initJobOffers() {
        if (jobOfferService.getAll().isEmpty()) {
            JobOffer jobOffer;
            for (int i = 1; i < 5; i++) {
                jobOffer = new JobOffer();
                jobOffer.setMainDuty("Duty nr" + i);
                jobOffer.setSalaryMax(2000*i % 2500);
                jobOffer.setDateTo(new Date());
                jobOfferService.add(jobOffer);
            }
        }
    }

}
