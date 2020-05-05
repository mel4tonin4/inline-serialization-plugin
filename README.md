# inline-serialization-plugin
An ΛRROW Meta Kotlin compiler plugin for inline serialization 

## Notes
This plug-in is not a polished product meant to be reused in other projects.

This current version of this plug-in based against on Kotlin 1.3.61 and Serialization Runtime 0.14.0.

Kotlin 1.3.70+ and thus Serialization Runtime 0.20.0 are not supported by ΛRROW Meta at the moment (https://github.com/arrow-kt/arrow-meta/issues/554).

## Usage
### Build
From the console:

```./gradlew clean :example-application:shadowJar```

### Run
From the console:

```java -jar example-application/build/libs/example-application-all.jar```
