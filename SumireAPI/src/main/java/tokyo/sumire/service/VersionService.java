package tokyo.sumire.service;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import tokyo.sumire.domain.Version;
import tokyo.sumire.repository.VersionRepository;

@Service
@AllArgsConstructor
public class VersionService {

	private final VersionRepository versionRepository;

	public Version getLatestVersion() {
		return this.versionRepository.getLatestVersion();
	}
}
