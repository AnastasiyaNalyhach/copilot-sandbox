package org.runner;

import io.cucumber.core.options.Constants;
import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("classpath*:features/ui/**")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "classpath:org.example.ui.steps_definition,classpath:org.example.ui.hooks")
@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "not @ignore")
public class TestRunner {
}
