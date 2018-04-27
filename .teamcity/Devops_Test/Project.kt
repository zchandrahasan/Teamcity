package Devops_Test

import Devops_Test.buildTypes.*
import Devops_Test.vcsRoots.*
import Devops_Test.vcsRoots.Devops_Test_TeamcitySettings
import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.Project
import jetbrains.buildServer.configs.kotlin.v2017_2.projectFeatures.VersionedSettings
import jetbrains.buildServer.configs.kotlin.v2017_2.projectFeatures.versionedSettings

object Project : Project({
    uuid = "7b51d15c-6fda-4813-b79d-a695edb2b6ad"
    id = "Devops_Test"
    parentId = "Devops"
    name = "Test"

    vcsRoot(Devops_Test_TeamcitySettings)
    vcsRoot(Devops_Test_TraderSharpSDK)

    buildType(Devops_Test_TraderSharpSdk)

    features {
        versionedSettings {
            id = "PROJECT_EXT_2"
            mode = VersionedSettings.Mode.ENABLED
            buildSettingsMode = VersionedSettings.BuildSettingsMode.USE_CURRENT_SETTINGS
            rootExtId = Devops_Test_TeamcitySettings.id
            showChanges = false
            settingsFormat = VersionedSettings.Format.KOTLIN
            storeSecureParamsOutsideOfVcs = true
        }
    }
})
