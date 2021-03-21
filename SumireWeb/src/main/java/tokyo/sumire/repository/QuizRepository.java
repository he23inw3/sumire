package tokyo.sumire.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import tokyo.sumire.domain.Quiz;

@Mapper
@Repository
public interface QuizRepository {

	List<Quiz> getQuizList();

	Quiz getQuizDetail(String quizId);
}
