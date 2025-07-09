import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

/**
 * Extension functions for DependencyHandler to simplify adding dependencies
 */

// String version
fun DependencyHandler.implementation(dependencyNotation: String): Dependency? = add("implementation", dependencyNotation)

// Generic version that accepts any dependency notation
fun DependencyHandler.implementation(dependencyNotation: Any): Dependency? = add("implementation", dependencyNotation)

fun DependencyHandler.api(dependencyNotation: String): Dependency? = add("api", dependencyNotation)

fun DependencyHandler.kapt(dependencyNotation: String): Dependency? = add("kapt", dependencyNotation)

fun DependencyHandler.ksp(dependencyNotation: String): Dependency? = add("ksp", dependencyNotation)

fun DependencyHandler.testImplementation(dependencyNotation: String): Dependency? = add("testImplementation", dependencyNotation)

fun DependencyHandler.androidTestImplementation(dependencyNotation: String): Dependency? =
    add("androidTestImplementation", dependencyNotation)

fun DependencyHandler.debugImplementation(dependencyNotation: String): Dependency? = add("debugImplementation", dependencyNotation)

fun DependencyHandler.projectImplementation(path: String): Dependency? = add("implementation", project(path))

/**
 * Adds core dependencies to a module
 */
fun DependencyHandler.addCoreAndroidDependencies() {
    implementation(Dependencies.coreKtx)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.lifecycleRuntimeKtx)
}

/**
 * Adds compose related dependencies
 */
fun DependencyHandler.addComposeDependencies() {
    add("implementation", Dependencies.activityCompose)
    add("implementation", platform(Dependencies.composeBom))
    add("implementation", Dependencies.composeUi)
    add("implementation", Dependencies.composeUiGraphics)
    add("implementation", Dependencies.composeUiToolingPreview)
    add("implementation", Dependencies.composeMaterial3)
    add("implementation", Dependencies.coilNetwork)
    add("implementation", Dependencies.coilCompose)
    add("implementation", Dependencies.extendedIcons)
    add("implementation", Dependencies.composeUiTextAndroid)
    add("debugImplementation", Dependencies.composeUiTooling)
    add("debugImplementation", Dependencies.composeTestManifest)
}

/**
 * Adds test dependencies
 */
fun DependencyHandler.addTestDependencies() {
    testImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.androidXJunit)
    androidTestImplementation(Dependencies.espressoCore)
    androidTestImplementation(Dependencies.workTest)
    testImplementation(Dependencies.mockk)
    testImplementation(Dependencies.roboelectric)
}

/**
 * Adds work dependencies
 */
fun DependencyHandler.addWorkManagerDependencies() {
    implementation(Dependencies.work)
    implementation(Dependencies.hiltWorker)
}

/**
 * Adds datastore dependencies
 */
fun DependencyHandler.addDataStoreDependencies() {
    implementation(Dependencies.cryptoDatastore)
    implementation(Dependencies.datastorePrefs)
}

/**
 * Adds Hilt dependencies
 */
fun DependencyHandler.addHiltDependencies() {
    implementation(Dependencies.hiltAndroid)
    ksp(Dependencies.hiltCompiler)
    implementation(Dependencies.hiltNavigation)
    implementation(Dependencies.composeNavigation)
}

/**
 * Adds paging dependencies
 */
fun DependencyHandler.addPagingDependencies() {
    implementation(Dependencies.pagingCompose)
    implementation(Dependencies.pagingRuntime)
}

fun DependencyHandler.addFirebaseDependencies() {
    implementation(platform("com.google.firebase:firebase-bom:33.10.0"))
    implementation("com.google.firebase:firebase-messaging")
    implementation("com.google.firebase:firebase-analytics")
}

/**
 * Adds Room dependencies
 */
fun DependencyHandler.addRoomDependencies() {
    implementation(Dependencies.roomRuntime)
    implementation(Dependencies.roomKtx)
    ksp(Dependencies.roomCompiler)
}

/**
 * Adds Retrofit dependencies
 */
fun DependencyHandler.addRetrofitDependencies() {
    implementation(Dependencies.retrofit)
    implementation(Dependencies.retrofit2Converter)
    implementation(Dependencies.gsonConverter)
    implementation(Dependencies.kotlinxSerialization)
    implementation(Dependencies.okhttpLogger)
    implementation(Dependencies.timber)
}
