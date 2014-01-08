package de.zalando.camunda.resource;

import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.ws.rs.GET;

import org.camunda.bpm.cockpit.db.QueryParameters;
import org.camunda.bpm.cockpit.plugin.resource.AbstractPluginResource;

import de.zalando.camunda.CreateInstancePlugin;
import de.zalando.camunda.db.ProcessDefinitionDto;

public class ProcessDefinitionResource extends AbstractPluginResource {

    private final String RESOURCE_PATH = "/de/zalando/camunda/create-instance-plugin.properties";

    private String pattern;

    public ProcessDefinitionResource(final String engineName) {
        super(engineName);
        loadProcessNamePattern();
    }

    @GET
    public List<ProcessDefinitionDto> getProcessDefinitions() {
        List<ProcessDefinitionDto> processes = getQueryService().executeQuery(
                "create.instance.selectLastVersionOfProcessDefinitions", new QueryParameters<ProcessDefinitionDto>());

        return getMatchingProcesses(processes);
    }

    private List<ProcessDefinitionDto> getMatchingProcesses(final List<ProcessDefinitionDto> processes) {
        List<ProcessDefinitionDto> matchingProcesses = new ArrayList<ProcessDefinitionDto>();
        if (processes != null) {
            for (ProcessDefinitionDto p : processes) {
                if (p.getName().matches(pattern)) {
                    matchingProcesses.add(p);
                }
            }
        }

        return matchingProcesses;
    }

    private void loadProcessNamePattern() {
        Properties props = new Properties();
        InputStream stream = getClass().getResourceAsStream(RESOURCE_PATH);
        if (stream != null) {
            try {
                System.out.println("loading..");
                props.load(stream);
            } catch (IOException e) { }
        }

        pattern = props.getProperty(CreateInstancePlugin.PROCESS_PATTERN_PROPERTY,
                CreateInstancePlugin.DEFAULT_PROCESS_NAME_PATTERN);
    }

    public String getPattern() {
        return pattern;
    }
}
