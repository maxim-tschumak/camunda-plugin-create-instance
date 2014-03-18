Create Instance Plugin
======================

Plugin for Camunda Cockpit

This Plugin is used to create a process instace right from the Camunda Cockpit App. It creates a list of deployed process definitions and buttons to create a new instance.

Usage
=====
If you want to restrict the process to be shown, add "create-instance-plugin.properties" file in your classpath with following content:

process.name.pattern=^Process: .*$

All deployed proccesses matching the RegEx ^Process: .*$  will be shown in the cockpit.

License
=======

The content of this project is licensed under the Creative Commons Attribution 3.0 license
