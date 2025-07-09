package dev.korryr.navigation

interface NavigationApi {
    fun starNavGraph(
        navHostController: NavHostController,
        navGraphBuilder: NavGraphBuilder,
        navOptions: NavOptions? = null
    )
}