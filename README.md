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
