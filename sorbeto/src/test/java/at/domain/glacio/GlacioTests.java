package at.domain.glacio;

import com.github.fridujo.glacio.running.api.configuration.GlacioConfiguration;

@GlacioConfiguration(
  featurePaths = "classpath:at/domain/glacio",
  gluePaths    = "at.domain.glacio.stepdefs"
)
public class GlacioTests {
}