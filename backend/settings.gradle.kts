rootProject.name = "backend"

include(":app")

include(":former-teammate-domain")
project(":former-teammate-domain").projectDir = file("module-former-teammate/domain")

include(":former-teammate-infrastructure")
project(":former-teammate-infrastructure").projectDir = file("module-former-teammate/infrastructure")

include(":user-domain")
project(":user-domain").projectDir = file("module-user/domain")

include(":user-infrastructure")
project(":user-infrastructure").projectDir = file("module-user/infrastructure")
