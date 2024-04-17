# Use an official OpenJDK image that has a JRE installed (or JDK if you need to compile)
FROM openjdk:17-slim

# Set the working directory inside the container
WORKDIR /app

# Copy all Java source files into the container
COPY src /app/src

# Copy the data files into the container
COPY player_stats /app/player_stats

# If you have a 'lib' directory, copy it into the container
COPY lib /app/lib

# Compile the Java source code
RUN javac -cp .:/app/lib/* /app/src/*.java

# Specify the command to run your Java application
CMD ["java", "-cp", ".:/app/lib/*:/app/src", "Driver"]

# to run docker container
#docker build -t my-java-app .
#docker run -it my-java-app
