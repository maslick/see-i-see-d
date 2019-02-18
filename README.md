# =see i see d=

## Installation

```
$ git clone https://github.com/maslick/see-i-see-d.git
$ ./gradlew clean build
```

## Usage

1. Start the server:
```
$ java -jar build/libs/see-i-see-d-1.0.jar                         // default port 7777
$ java -Dserver.port=8080 -jar build/libs/see-i-see-d-1.0.jar      // override port
```

2. Fire a get request:
```
$ curl http://localhost:8080
  {"hello": "Hello world"}
```

## Docker

Instead of writing your own Dockerfile, you can leverage [s2i-java](https://github.com/fabric8io-images/s2i/tree/master/java/examples/binary):

1. Install s2i:
```
$ brew install source-to-image
```

2. Create Docker image:
```
$ git clone https://github.com/maslick/see-i-see-d.git
$ s2i build --copy . fabric8/s2i-java:latest-java11 vesna:0.1

# OR directly from git:

$ s2i build https://github.com/maslick/see-i-see-d.git fabric8/s2i-java:latest-java11 vesna:latest
```

3. After this run the docker container:
```
docker run -d -p 8081:8080 vesna:latest
```

More info on ``s2i`` can be found [here](https://github.com/openshift/source-to-image).
