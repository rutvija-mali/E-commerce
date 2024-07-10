#!/bin/bash

# Set Tomcat home directory (update this path to your Tomcat installation)
export CATALINA_HOME=/path/to/tomcat

# Deploy the project to Tomcat
cp -R web $CATALINA_HOME/webapps/MyProject

# Start Tomcat
$CATALINA_HOME/bin/catalina.sh run
