pipeline {
  agent any
  stages {
    stage('Verify browsers are installed') {
      steps {
        sh 'google-chrome --version'
        // sh 'firefox --version'
        echo 'chrome browser is installed'
      }
    }
    stage('Run Tests') {
      steps {
        sh './mvnw clean test'
        // sh 'mvn -Dtest=JenkinsHomepageTest test'
      }
    }
    stage('Publish HTML Report') {
      steps {
        publishHTML(target: [
          allowMissing: false,
          alwaysLinkToLastBuild: true,
          keepAll: true,
          reportDir: 'target/surefire-reports',
          reportFiles: 'index.html',
          reportName: 'Test Report',
          reportTitles: 'Test Results'
        ])
      }
    }
  }
}
