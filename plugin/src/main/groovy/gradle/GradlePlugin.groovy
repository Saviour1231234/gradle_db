package gradle

import gradle.tasks.CreateTable

import gradle.tasks.InsertData
import org.gradle.api.Plugin
import org.gradle.api.Project

class GradlePlugin implements Plugin<Project> {

    void apply(Project project) {
        // Register a task
        project.tasks.register("createTable", CreateTable) {
            setGroup("plugins")
        }
        project.tasks.register("insertData", InsertData) {
            setGroup("plugins")
        }
    }
}
