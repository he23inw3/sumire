package tokyo.sumire.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import tokyo.sumire.controller.response.VersionResponse;
import tokyo.sumire.service.VersionService;

@RestController
@AllArgsConstructor
public class VersionController {

	private final VersionService versionService;

	@GetMapping("/version")
	public VersionResponse getLatestVersion() {
		return new VersionResponse(versionService.getLatestVersion());
	}
}
