package de.zalando.camunda;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import java.util.List;

import org.camunda.bpm.cockpit.Cockpit;
import org.camunda.bpm.cockpit.db.QueryParameters;
import org.camunda.bpm.cockpit.db.QueryService;
import org.camunda.bpm.cockpit.plugin.spi.CockpitPlugin;
import org.camunda.bpm.cockpit.plugin.test.AbstractCockpitPluginTest;

import org.junit.Test;

import de.zalando.camunda.db.ProcessDefinitionDto;
import de.zalando.camunda.resource.ProcessDefinitionResource;

public class CreateInstancePluginsTest extends AbstractCockpitPluginTest {

    @Test
    public void testPluginDiscovery() {
        CockpitPlugin plugin = Cockpit.getRuntimeDelegate().getPluginRegistry().getPlugin("createInstancePlugin");

        assertNotNull(plugin);
    }

    @Test
    public void testSampleQueryWorks() {

        QueryService queryService = getQueryService();

        List<ProcessDefinitionDto> processDefinitions = queryService.executeQuery(
                "create.instance.selectLastVersionOfProcessDefinitions", new QueryParameters<ProcessDefinitionDto>());

        assertEquals(0, processDefinitions.size());
    }

    @Test
    public void testProcessNamePattern() throws IOException {
        ProcessDefinitionResource pluginResource = new ProcessDefinitionResource(":engine");
        assertNotNull(pluginResource.getPattern());
        assertEquals("^Release .* Management$", pluginResource.getPattern());
    }
}
