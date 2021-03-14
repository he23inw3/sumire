package tokyo.sumire.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import tokyo.sumire.domain.QuizList;

@Mapper
@Repository
public interface QuizRepository {

	QuizList getQuizList(@Param("startDate") String startDate,
			@Param("endDate") String endDate);
}
