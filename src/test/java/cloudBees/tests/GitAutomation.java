package cloudBees.tests;
import java.io.File;
import java.util.Scanner;

import cloudBees.utilities.GitUtils;

public class GitAutomation {

    public static void main(String[] args) throws Exception {
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Git repo URL:");
        String repoUrl = scanner.nextLine();

        System.out.println("Enter local directory name:");
        String localDir = scanner.nextLine();

        System.out.println("Choose operation (1: Add new file, 2: Append to file):");
        int choice = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter file name:");
        String fileName = scanner.nextLine();

        System.out.println("Enter content:");
        String content = scanner.nextLine();

        File workingDir = new File(localDir);


        
        // Clone the repository
        GitUtils.runCommand(new String[]{"git", "clone", repoUrl, localDir}, new File("."));
        
        

        File targetFile = new File(workingDir, fileName);
        
        if (choice == 1) {
            if (targetFile.exists()) {
                System.out.println("File already exists. Aborting.");
                return;
            }
            GitUtils.writeFile(targetFile, content, false);
        } else if (choice == 2) {
            if (!targetFile.exists()) {
                System.out.println("File does not exist. Aborting.");
                return;
            }
            GitUtils.writeFile(targetFile, content, true);
        } else {
            System.out.println("Invalid choice.");
            return;
        }

        // Stage, commit, and push
        GitUtils.runCommand(new String[]{"git", "add", fileName}, workingDir);
        GitUtils.runCommand(new String[]{"git", "commit", "-m", "Updated via automation"}, workingDir);
        GitUtils.runCommand(new String[]{"git", "push"}, workingDir);

        System.out.println("Operation completed successfully.");
    }
}
 