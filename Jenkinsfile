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
    }

    post {
      success {
        publishHTML([
          allowMissing: false,
          alwaysLinkToLastBuild: false,
          keepAll: false,
          reportDir: 'target',
          reportFiles: 'surefire-report.html',
          reportName: 'Surefire Report',
        ])
      }
    }
  }
}
