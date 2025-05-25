package cloudBees.tests;

import org.testng.annotations.Test;

import cloudBees.utilities.GitUtils;

import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.AfterMethod;

public class TestCase2_GIT {

	@BeforeMethod
	public void beforeMethod() {

		GitUtils.setup();
	}

	@Test
	public void updateFileInGitRepo() throws IOException, InterruptedException {

		// Clone the repository
		GitUtils.runCommand(new String[] { "git", "clone", GitUtils.getRepoUrl(), GitUtils.getLocalDir() },
				new File("."));

		File targetFile = new File(GitUtils.getWorkingDir(), GitUtils.getFileName());

		if (GitUtils.getChoice() == 1) {
			if (targetFile.exists()) {
				System.out.println("File already exists. Aborting.");
				return;
			}
			GitUtils.writeFile(targetFile, GitUtils.getContent(), false);
		} else if (GitUtils.getChoice() == 2) {
			if (!targetFile.exists()) {
				System.out.println("File does not exist. Aborting.");
				return;
			}
			GitUtils.writeFile(targetFile, GitUtils.getContent(), true);
		} else {
			System.out.println("Invalid choice.");
			return;
		}

		// Stage, commit, and push
		GitUtils.runCommand(new String[] { "git", "add", GitUtils.getFileName() }, GitUtils.getWorkingDir());
		GitUtils.runCommand(new String[] { "git", "commit", "-m", "Updated via automation" }, GitUtils.getWorkingDir());
		GitUtils.runCommand(new String[] { "git", "push" }, GitUtils.getWorkingDir());

		System.out.println("Operation completed successfully.");
	}

	@AfterMethod
	public void afterMethod() throws IOException, InterruptedException {

	}

}
