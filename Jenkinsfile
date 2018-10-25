pipeline {
  agent any
  stages {
    stage('Recuperer des sources') {
      steps {
        git(url: 'https://github.com/phat93/projet-GDA.git', credentialsId: 'idGithub')
      }
    }
  }
}