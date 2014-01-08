package de.zalando.camunda.resource;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.camunda.bpm.cockpit.plugin.resource.AbstractPluginRootResource;

import de.zalando.camunda.CreateInstancePlugin;

@Path("plugin/" + CreateInstancePlugin.ID)
public class CreateInstancePluginRootResource extends AbstractPluginRootResource {

    public CreateInstancePluginRootResource() {
        super(CreateInstancePlugin.ID);
    }

    @Path("{engineName}/process-instance")
    public ProcessDefinitionResource getProcessInstanceResource(@PathParam("engineName") final String engineName) {
        return subResource(new ProcessDefinitionResource(engineName), engineName);
    }
}
