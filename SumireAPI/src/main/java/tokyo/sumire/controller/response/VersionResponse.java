package tokyo.sumire.controller.response;

import lombok.Data;
import tokyo.sumire.domain.Version;

@Data
public class VersionResponse {

	public VersionResponse(Version version) {
		this.version = version.getVersion();
	}

	private String version;

}
