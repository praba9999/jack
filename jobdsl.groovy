job('example') {
    description('My first job')

    scm {
        github('https://github.com/jitpack/maven-simple.git')
    }
    steps {
        maven('verify')
        maven('clean verify', 'module-a/pom.xml')
        maven {
            goals('clean')
            goals('verify')
            mavenOpts('-Xms256m')
            mavenOpts('-Xmx512m')
            localRepository(LocalRepositoryLocation.LOCAL_TO_WORKSPACE)
            properties(skipTests: true)
            mavenInstallation('Maven 3.1.1')
            providedSettings('central-mirror')
        }
    }
    steps {
    shell("echo : this is now completed")
    }
}
