node("dev7") {
    checkout scm

    stage('1: Build src') {
        docker.image('amazoncorretto:11').inside("-v $env.HOME/.gradle:/root/.gradle") {
            stage('1.1: Initialize') {
                sh "java -version"
            }

            stage('1.2: Build') {
                sh "./gradlew --no-daemon clean build -x test -Dsnapshot=true"
            }

            stage('1.3: Test') {
                sh "./gradlew test -Dsnapshot=true"
            }

            stage('1.4: Sonarqube') {
                sh "#./gradlew sonarqube -Dsonar.host.url=http://sonarqube:9000 -Dsnapshot=true"
            }

            stage('1.5: Nexus') {
                sh "./gradlew build publishToMavenLocal -x test -Dsnapshot=true"
                sh "#./gradlew publish -x -DnexusUser=xxx -DnexusPassword=xxx -DnexusRepo=xxx -DnexusSnapshot=xxx -Dsnapshot=true"
            }

            stage('1.6: Prepare Dockerfile') {
                sh "./gradlew createDockerfile -Dsnapshot=true"
                sh "./gradlew properties -q | grep \"version:\" | awk '{print \$2}' > .version"
                sh "./gradlew properties -q | grep \"name:\" | awk '{print \$2}' > .name"
            }
        }
    }

    stage('2: Build docker image') {
        sh "ls -l build/libs"
        sh "cat .version"
        def appName = sh(script: "cat .name", returnStdout: true).trim()
        def appVersion = sh(script: "cat .version", returnStdout: true).trim()
        def imageName = "$appName-$appVersion-$env.BRANCH_NAME:$env.BUILD_NUMBER"
        sh "docker build -t $imageName build/libs"
    }

    stage('3: Push to docker registry') {
        sh "echo Stage #3"
    }

    stage('4: Push to GCP docker registry') {
        sh "echo Stage #4"
    }
}