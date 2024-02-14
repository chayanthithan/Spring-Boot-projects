package com.sonchayan.Question_demo.Repostory;

import com.sonchayan.Question_demo.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer> {
    List<Question> findByCategory(String category);
    @Query(value = "SELECT * FROM Question_Details a where a.category = :category order by RAND() LIMIT :numQ",nativeQuery = true)
    List<Question> findRandomQuestionByCategory(@Param("category") String category,@Param("numQ") int numQ);
}
