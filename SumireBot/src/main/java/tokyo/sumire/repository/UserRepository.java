package tokyo.sumire.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tokyo.sumire.domain.User;

@Mapper
@Repository
public interface UserRepository {

	@Transactional
	void registUser(User user);

	@Transactional
	void unregistUser(User user);
}
