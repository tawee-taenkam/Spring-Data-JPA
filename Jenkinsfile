pipeline {
    agent any
    stages {
        stage('parallel stage1') {
            parallel {
                stage("stages1") {
                 steps {
                    // One or more steps need to be included within the steps block
                    echo "Hello world"
                 }
                }
                stage("stages2") {
                 steps {
                     withMaven(jdk: 'jdk 8u212', maven: 'maven-3.6.1', mavenSettingsConfig: 'maven-setting-golf') {               
                        sh "mvn --version"
                    }
                 }
                }
                stage("stages3") {
                 steps {
                     withMaven(jdk: 'jdk 8u212', maven: 'maven-3.6.1', mavenSettingsConfig: 'maven-setting-golf') {               
                        sh "mvn clean install"
                    }
                 }
                }
            }
        }
  }
}
