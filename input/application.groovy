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