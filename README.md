camunda-plugin-create-instance
==============================

Plugin for Camunda Cockpit

This Plugin is used to create a process instace right from the Camunda Cockpit App. It creates a list of deployed process definitions. If you want to restrict the process to be shown, add "create-instance-plugin.properties" file in your classpath:

process.name.pattern=^Process: .*$

Where ^Process: .*$ is a RegEx for the process definition name.
