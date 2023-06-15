pipeline {
  agent any

  stages {
    stage('Verify browsers are installed') {
      steps {
        sh 'google-chrome --version'
        // sh 'firefox --version'
        echo 'Chrome browser is installed'
      }
    }

    stage('Run Tests') {
      steps {
        sh './mvnw clean test'
        // sh 'mvn -Dtest=JenkinsHomepageTest test'
      }
        post {
        success {
          script {
            // Define the HTML report directory and file
            def reportDir = 'target'
            def reportFile = 'surefire-report.html'

            // Publish the HTML report using the HTML Publisher Plugin
            publishHTML([
              allowMissing: false,
              alwaysLinkToLastBuild: false,
              keepAll: false,
              reportDir: reportDir,
              reportFiles: reportFile,
              reportName: 'Surefire Report',
              reportTitles: '',
            ])

            // Display the HTML report in the Jenkins job's sidebar
            publishHTML([
              allowMissing: false,
              alwaysLinkToLastBuild: false,
              keepAll: false,
              reportDir: reportDir,
              reportFiles: reportFile,
              reportName: 'Surefire Report',
              reportTitles: '',
              reportLinks: true,
          ])
        }
    }
    }
  }

  }
}
