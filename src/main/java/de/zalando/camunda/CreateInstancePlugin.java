package de.zalando.camunda;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.camunda.bpm.cockpit.plugin.spi.impl.AbstractCockpitPlugin;

import de.zalando.camunda.resource.CreateInstancePluginRootResource;

public class CreateInstancePlugin extends AbstractCockpitPlugin {

    public static final String ID = "createInstancePlugin";

    public static final String PROCESS_PATTERN_PROPERTY = "process.name.pattern";
    public static final String DEFAULT_PROCESS_NAME_PATTERN = ".*";

    public String getId() {
        return ID;
    }

    @Override
    public List<String> getMappingFiles() {
        return Arrays.asList("de/zalando/camunda/queries/sample.xml");
    }

    @Override
    public Set<Class<?>> getResourceClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(CreateInstancePluginRootResource.class);
        return classes;
    }
}
