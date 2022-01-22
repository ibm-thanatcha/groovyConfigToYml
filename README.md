# GroovyConfigToYml
Convert application.groovy to application.yaml for Grails projects

## How to use:
1. Using Gradle
Main class is `com.ConfigParser`, you can compile and run using this command
`./gradlew run`

2. Using Jar

```java -jar groovyConfigToYml.jar [input_file_path] [output_path]```

for example `java -jar groovyConfigToYml.jar ./input_folder/application.groovy ./output/`



## Input
Default input file `./input/application.groovy`
```
//Sample input groovy

config {
    application = 'Sample App'
    version = '1.0.1'
    autoStart = true

    database {
        url = 'jdbc:db//localhost'
    }
}

environments {
    development {
        env = 'dev'
        app.port = 8080
    }

    test {
        env = 'test'
        app.port = 8081
    }

    staging {
        env = 'staging'
        app.port = 8082
    }

    production {
        env = 'production'
        app.port = 80
    }
}
```

## Output
Default output will be saved in `./output/application-<env_name>.yaml`

For example: 
- `./output/applicaton-development.yaml`
```
---
config:
  application: "Sample App"
  version: "1.0.1"
  autoStart: true
  database:
    url: "jdbc:db//localhost"
env: "dev"
app:
  port: 8080

```

- `./output/applicaton-test.yaml`
```
---
config:
  application: "Sample App"
  version: "1.0.1"
  autoStart: true
  database:
    url: "jdbc:db//localhost"
env: "test"
app:
  port: 8081

```
