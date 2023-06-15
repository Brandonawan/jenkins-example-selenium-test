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

    stage('Prepare Directory') {
      steps {
        sh 'mkdir -p coverage'
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
          keepAll: true,
          reportDir: 'coverage',
          reportFiles: 'index.html',
          reportName: "RCov Report"
        ])
      }
    }
  }
}
