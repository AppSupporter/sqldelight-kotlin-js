plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.sqlDelight)
}

kotlin {
    compilerOptions {
        freeCompilerArgs.add("-Xexpect-actual-classes")
    }

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }

    js {
        browser {
        }
        generateTypeScriptDefinitions()
        binaries.executable()
        useEsModules()
    }
    
    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlinx.datetime)
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.sqlDelight.runtime)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        androidMain.dependencies {
            implementation(libs.sqlDelight.android.driver)
        }
        jsMain.dependencies {
            implementation(libs.sqlDelight.web.worker.driver)

            implementation(devNpm("copy-webpack-plugin", "9.1.0"))

            implementation(npm("sql.js", "1.8.0"))
            implementation(npm("@cashapp/sqldelight-sqljs-worker", libs.versions.sqlDelight.get()))
        }
    }

    task("testClasses")
}

android {
    namespace = "de.codecreators.youtrackkotlinjs"
    compileSdk = 34
    defaultConfig {
        minSdk = 26
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

sqldelight {
    databases {
        create("TestDB") {
            packageName = "de.codecreators.youtrackotlinjs"
            deriveSchemaFromMigrations = true
            generateAsync = true
        }
    }
}