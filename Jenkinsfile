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

      post {
        success {
          publishHTML (target : [allowMissing: false,
          alwaysLinkToLastBuild: true,
          keepAll: true,
          reportDir: 'reports',
          reportFiles: 'myreport.html',
          reportName: 'My Reports',
          reportTitles: 'The Report'])
        }
      }
    }
  }
}
