 # Use an official Tomcat runtime as a parent image
FROM tomcat:10.1.20

# Remove the default Tomcat ROOT application
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# Set environment variables for the container
ENV CATALINA_HOME /usr/local/tomcat

# Copy your application files to the Tomcat webapps directory
COPY ./ /usr/local/tomcat/webapps/ROOT/


# Expose port 8080
EXPOSE 8080

# Run Tomcat
CMD ["catalina.sh", "run"]
