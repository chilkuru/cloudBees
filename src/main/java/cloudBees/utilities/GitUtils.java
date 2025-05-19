package cloudBees.utilities;
import java.io.*;

public class GitUtils {

    public static void runCommand(String[] command, File workingDir) throws IOException, InterruptedException {
        ProcessBuilder builder = new ProcessBuilder(command);
        builder.directory(workingDir);
        builder.redirectErrorStream(true);
        Process process = builder.start();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }

        int exitCode = process.waitFor();
        if (exitCode != 0) {
            throw new RuntimeException("Command failed: " + String.join(" ", command));
        }
    }
    

    public static void writeFile(File file, String content, boolean append) throws IOException {
        try (FileWriter fw = new FileWriter(file, append)) {
            fw.write(content);
        }
    }
}