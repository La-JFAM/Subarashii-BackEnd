package com.jfam.subarashii.services;

import com.jfam.subarashii.configs.exception.ResourceApiNotFoundException;
import com.jfam.subarashii.entities.Genre;
import com.jfam.subarashii.entities.SecretQuestion;
import com.jfam.subarashii.repositories.SecretQuestionRepository;
import com.jfam.subarashii.repositories.UserListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecretQuestionService {

    @Autowired
    private SecretQuestionRepository secretQuestionRepository;

    public List<SecretQuestion> getAll() {
        List<SecretQuestion> secretQuestionList = secretQuestionRepository.findAll();
        return secretQuestionList;
    }
}
