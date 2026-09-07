package Runner;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("Feature/Login.feature")
@ConfigurationParameter(key=GLUE_PROPERTY_NAME, value="Step_Definition,Hooks")
@ConfigurationParameter(key=PLUGIN_PROPERTY_NAME, value="pretty, html:target/Cucumber_Reports/report.html,json:target/Cucumber_Reports/report.json,junit:target/Cucumber_Reports/report.xml,rerun:target/Failed_Scenarios_Report/failed_scenarios.txt")

public class Login_Test {
	
}
