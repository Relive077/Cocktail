plugins {
    id("org.sonarqube") version app.web.relive.buildsrc.Depends.Versions.sonarqubeVersion
    detekt
    id("com.github.ben-manes.versions") version app.web.relive.buildsrc.Depends.Versions.checkDependencyVersionsVersion
    id("com.osacky.doctor") version app.web.relive.buildsrc.Depends.Versions.gradleDoctorVersion
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(app.web.relive.buildsrc.Depends.ClassPaths.gradle)
        classpath(
            kotlin(
                app.web.relive.buildsrc.Depends.ClassPaths.kotlin_gradle_plugin,
                version = app.web.relive.buildsrc.Depends.Versions.kotlinVersion
            )
        )
        classpath(app.web.relive.buildsrc.Depends.ClassPaths.navigation_safe_args_gradle_plugin)
        classpath(app.web.relive.buildsrc.Depends.ClassPaths.hilt_android_gradle_plugin)
        classpath(app.web.relive.buildsrc.Depends.ClassPaths.sonarqube_gradle_plugin)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.0")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.google.com/")
        maven("https://jitpack.io")
        maven("https://plugins.gradle.org/m2/")
    }
}
