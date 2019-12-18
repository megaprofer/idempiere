pipeline {
    agent none
    options {
        disableConcurrentBuilds()
    }
    environment {
        PROJECT_NAME = 'atix-7'
        REGISTRY_DNS = 'registry.megapos.alquimiasoft.com.ec'
        REGISTRY = credentials('alquimiabot-mega-registry-pass')
    }
    stages {
        stage('Starting') {
            agent {
                docker {
                    image 'maven:3.6.0'
                    label 'docker'
                }
            }
            stages {
                stage('Install Dependencies') {
                    steps {
                        sh 'apt-get update'
                        sh 'apt-get install -y openjdk-11-jdk'
                        sh 'apt-get install -y unzip'
                    }
                }
                stage('Build') {
                    steps {
                        sh 'mvn verify -U'
                        stash includes: 'org.idempiere.p2/target/products/org.adempiere.server.product/linux/gtk/x86_64/', name: 'build'
                    }
                }
            }
        }
        stage('Publish to Registry') {
            agent { label 'docker' }
            when {
                anyOf {
                    branch 'atix-7.1'
                }
            }
            steps {
                unstash 'build'
                sh 'docker login $REGISTRY_DNS -u $REGISTRY_USR -p $REGISTRY_PSW'
                sh 'docker build -t $REGISTRY_DNS/$PROJECT_NAME:latest -t $REGISTRY_DNS/$PROJECT_NAME:$GIT_COMMIT .'
                sh 'docker push $REGISTRY_DNS/$PROJECT_NAME:latest'
                sh 'docker push $REGISTRY_DNS/$PROJECT_NAME:$GIT_COMMIT'
            }
        }
    }
}
