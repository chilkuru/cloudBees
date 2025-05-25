package cloudBees.utilities;

import java.io.*;
import java.util.Scanner;

//import org.testng.annotations.Parameters;

public class GitUtils {
	private static String repoUrl;
	private static String localDir;
	private static int choice; // 1 = Add new file, 2 = Append
	private static String fileName;
	private static String content;
	private static File workingDir;

	public static void runCommand(String[] command, File workingDir) throws IOException, InterruptedException {
		ProcessBuilder builder = new ProcessBuilder(command);
		builder.directory(workingDir);
		builder.redirectErrorStream(true);
		Process process = builder.start();

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
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


	public static void setup() {

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter Git repo URL:");
		 repoUrl = scanner.nextLine();

		System.out.println("Enter local directory name:");
		 localDir = scanner.nextLine();

		System.out.println("Choose operation (1: Add new file, 2: Append to file):");
		 choice = Integer.parseInt(scanner.nextLine());

		System.out.println("Enter file name:");
		 fileName = scanner.nextLine();

		System.out.println("Enter content:");
		 content = scanner.nextLine();

	      workingDir = new File(localDir);
	}

	public static String getRepoUrl() {
		return repoUrl;
	}

	public void setRepoUrl(String repoUrl) {
		GitUtils.repoUrl = repoUrl;
	}

	public static String getLocalDir() {
		return localDir;
	}

	public void setLocalDir(String localDir) {
		GitUtils.localDir = localDir;
	}

	public static int getChoice() {
		return choice;
	}

	public void setChoice(int choice) {
		GitUtils.choice = choice;
	}

	public static String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		GitUtils.fileName = fileName;
	}

	public static String getContent() {
		return content;
	}

	public void setContent(String content) {
		GitUtils.content = content;
	}

	public static File getWorkingDir() {
		return workingDir;
	}

	public void setWorkingDir(File workingDir) {
		GitUtils.workingDir = workingDir;
	}
}