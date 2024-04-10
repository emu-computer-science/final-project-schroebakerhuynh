# Use an official OpenJDK image that has a JRE installed (or JDK if you need to compile)
FROM openjdk:17-slim

# Set the working directory inside the container
WORKDIR /app

# Copy Java source files into the container
COPY *.java /app/

# If you need to compile the Java code inside the Docker container, you would copy the JDK as follows:
# COPY openjdk-11-jdk ...

# Copy the data files into the container
COPY mlb_al_batter_stats_2023.txt /app/
COPY mlb_al_pitching_stats_2023.txt /app/

# Compile the Java source code (if needed), and clean up source files afterwards
# (Uncomment and adjust these lines if you're compiling within the Docker build process)
RUN javac Driver.java && \
    find . -name "*.java" -delete

# Specify the command to run your Java application (replace 'Driver' with your main class name)
CMD ["java", "Driver"]


# run these to build and run the Docker image

# docker build -t my-java-app .

# docker run -it my-java-app
