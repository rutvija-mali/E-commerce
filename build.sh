#!/bin/bash

# Create necessary directories
mkdir -p web/WEB-INF/classes

# Compile Java source files
javac -d web/WEB-INF/classes src/main/java/com/example/*.java

# Copy JSP files and other static resources if needed
# cp -R src/main/webapp/* web/
