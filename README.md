
# CloudBees Software QA Assessment

This repository contains a sample automation framework developed as part of a Software QA assessment. It utilizes Java, Maven, and TestNG to demonstrate automated testing capabilities.

## 📁 Project Structure

```
cloudBees/
├── src/                   # Source code for tests
├── test-output/           # TestNG output reports
├── reports/               # Custom test reports
├── pom.xml                # Maven project configuration
├── testng.xml             # TestNG suite configuration
└── (WATCH ME) CloudBeesFrameworkDemo.mp4  # Demo video
```

## 🛠️ Prerequisites

Before setting up the project, ensure the following are installed:

* **Java Development Kit (JDK)**: Version 8 or higher
* **Apache Maven**: For project build and dependency management
* **TestNG Plugin**: Recommended for IDEs like Eclipse for seamless test execution
* **Git**: For cloning the repository

## 🚀 Setup Instructions

1. **Clone the Repository**:

   ```bash
   git clone https://github.com/chilkuru/cloudBees.git
   ```

2. **Import as a Maven Project**:

   * Open your preferred IDE (e.g., Eclipse).
   * Choose to import an existing Maven project.
   * Navigate to the cloned `cloudBees` directory and import.

3. **Build the Project**:

   ```bash
   mvn clean install
   ```
   This command will download necessary dependencies and build the project.
   
   * **Via IDE**:
 
   * Right-click and select Maven -> Update Project.
   
   

4. **Run Tests**:

   * **Via IDE**:

     * Open `testng.xml`.
     * Right-click and select "Run as TestNG Suite".
   * **Via Command Line**:

     ```bash
     mvn test
     ```

## 🎥 Demonstration Video

For a comprehensive walkthrough of the framework and its functionalities, refer to the demo video:

[![CloudBees Framework Demo](https://drive.google.com/file/d/1AcA02sDE1v72I4sxvrTygk1_OHug_bOS/view?usp=drive_link)]

*Note: Replace `VIDEO_ID` with the actual YouTube video ID if available.*

## 📄 Test Cases Overview

* **TestCase1**: Ensure the project imports correctly as a Maven project with all dependencies resolved. The presence of the TestNG plugin in your IDE will facilitate smoother test executions.

* **TestCase2**: Verify that Git is installed and properly configured in your system's environment variables. This ensures seamless cloning and version control operations.

## 📬 Feedback and Contributions

Feedback is highly appreciated to enhance the framework's robustness and usability. If you encounter issues or have suggestions:

* Open an [issue](https://github.com/chilkuru/cloudBees/issues).
* Submit a [pull request](https://github.com/chilkuru/cloudBees/pulls) with proposed enhancements.

---

