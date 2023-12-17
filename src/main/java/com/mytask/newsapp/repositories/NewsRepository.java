package com.mytask.newsapp.repositories;

import com.mytask.newsapp.models.News;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


//DAO layer to get data from DB
@Repository
//Use interface instead of class because in this case we do not have to use jdbc to fetch data from DB
//we don't have to write sql query and get a lot of data and iterate through data and convert it to list of News class
//because in dependencies we got spring JPA that's enough to fetch and save data by extending
// JpaRepository<WhatTypeOfTableWeAreWorkingWith, TypeOfPrimaryKey>

public interface NewsRepository extends JpaRepository<News, Long> {
}
