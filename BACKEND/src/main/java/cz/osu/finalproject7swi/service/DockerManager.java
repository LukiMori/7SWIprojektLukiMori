package cz.osu.finalproject7swi.service;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DockerManager {

    public static void startDockerContainer() {
        try {
            Path currentRelativePath = Paths.get("");
            String absolutePath = currentRelativePath.toAbsolutePath().toString();
            String dockerComposeFilePath = absolutePath + "/src/docker-compose.yaml";

            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.directory(new File(absolutePath));
            processBuilder.command("docker-compose", "-f", dockerComposeFilePath, "up", "-d");

            Process process = processBuilder.start();
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.out.println("Docker container started successfully.");
            } else {
                System.err.println("Failed to start Docker container.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
