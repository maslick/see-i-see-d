# =see i see d=

## Installation

```shell
$ git clone https://github.com/maslick/see-i-see-d.git
$ ./gradlew clean build
```

## Usage

1. Start the server:
```zsh
$ java -jar build/libs/see-i-see-d-1.0.jar                         // default port 7777
$ java -Dserver.port=8080 -jar build/libs/see-i-see-d-1.0.jar      // override port
```

2. Fire a get request:
```zsh
$ curl http://localhost:8080
  { "hello": "Hello world" }
```

## Docker

Instead of writing your own Dockerfile, you can leverage [s2i-java](https://hub.docker.com/r/fabric8/s2i-java/) builder images:

1. Install s2i:
```zsh
$ brew install source-to-image
```

2. Create Docker image:
```zsh
$ git clone https://github.com/maslick/see-i-see-d.git
$ s2i build --copy . fabric8/s2i-java:latest-java11 vesna:jdk8
```
Or directly from the repo.
```zsh
$ s2i build https://github.com/maslick/see-i-see-d.git fabric8/s2i-java vesna:jdk8
```

3. After this run the docker container:
```zsh
$ docker run -d -p 8081:6666 -e JAVA_OPTIONS=-Dserver.port=6666 vesna:jdk8
$ curl http://localhost:8081
  { "hello": "Hello world" }
```

More info on ``s2i`` can be found [here](https://github.com/openshift/source-to-image).


## Openshift

To deploy to an Openshift cluster, run:
```zsh
oc new-project prishla
oc new-app fabric8/s2i-java~https://github.com/maslick/see-i-see-d.git --name vesna
oc set env dc/vesna JAVA_OPTIONS=-Dserver.port=8080
oc expose svc/vesna
```

And finally (I'm using Minishift):
```zsh
$ curl vesna-prishla.$(minishift ip).nip.io
  { "hello": "Hello world" }
```
