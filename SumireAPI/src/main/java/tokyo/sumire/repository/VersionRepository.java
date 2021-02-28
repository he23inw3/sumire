package tokyo.sumire.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import tokyo.sumire.domain.Version;

@Mapper
@Repository
public interface VersionRepository {

	Version getLatestVersion();
}
