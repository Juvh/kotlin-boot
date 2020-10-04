object Version {
    val kotlin = "1.4.10"
    val spring = "2.3.4.RELEASE"
    val spring_dependency_management = "1.0.10.RELEASE"
}

object Library {
    object Build {
        val kotlin_stdlib = Dependency(group = "org.jetbrains.kotlin",
                name = "kotlin-stdlib",
                version = Version.kotlin)
        val spring_boot_starter_web = Dependency(group = "org.springframework.boot", name = "spring-boot-starter-web")
    }

    object Test {
        val spring_boot_starter_test = Dependency(group = "org.springframework.boot", name = "spring-boot-starter-test")
    }
}

data class Dependency(
        val group: String,
        val name: String,
        val version: String? = null
) {

    fun groupId(): String {
        return "${group}:${name}"
    }

    override fun toString(): String {
        return "${groupId()}:${version}"
    }
}