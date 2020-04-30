package sarabjit.blog.applinkssample.manager

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.annotation.Nullable
import sarabjit.blog.applinkssample.activity.AppLinkExampleActivity
import sarabjit.blog.applinkssample.activity.DeepLinkExampleActivity
import sarabjit.blog.applinkssample.enums.AppLinks
import sarabjit.blog.applinkssample.enums.UniversalLinkViewModel


class AppLinkManager {

    /**
     * Create and return the App Supported AppLink  String
     */
    private fun getSupportedAppLinkStrings(scheme: String, host: String, path: String): String {
        return Uri.Builder().scheme(scheme).authority(host).path(path).build().toString()
    }

    /**
     * Iterate over the application supported AppLinks and return the matched AppLink
     */
    private fun checkAndVerifyAppLink(
        context: Context,
        appLinkViewModel: UniversalLinkViewModel?
    ): AppLinks? {
        val appLinks = AppLinks.values()
        appLinkViewModel?.run {
            for (link in appLinks) {
                if (appLinkViewModel.getUri().toString() == getSupportedAppLinkStrings(
                        context.getString(link.mScheme),
                        context.getString(link.mHost),
                        context.getString(link.mPath)
                    )
                ) {
                    return link
                }
            }
        }
        return null
    }

    @Nullable
    fun getAppUniversalLink(@Nullable intent: Intent?): UniversalLinkViewModel? {
        return if (intent == null || intent.data == null) {
            null
        } else UniversalLinkViewModel(intent.data)
    }

    /**
     * Resolve the app link for appropriate action
     */
    fun resolveLink(context: Context, intent: Intent) {
        val appLink = getAppUniversalLink(intent)
        val navigationAppLink = checkAndVerifyAppLink(context, appLink)
        navigate(context, navigationAppLink, appLink)
    }


    /**
     * Navigate the user to the directed Screen
     */
    private fun navigate(
        context: Context,
        appDeepLink: AppLinks?,
        appLinkViewModel: UniversalLinkViewModel?
    ) {
        val intent = getAppLinkIntent(context, appDeepLink)
        intent?.let {
            it.putExtra("Data", appLinkViewModel)
            context.startActivity(it)
        }
    }

    /**
     * This  method will check and return the entry point of the applink
     */
    private fun getAppLinkIntent(
        context: Context,
        appDeepLink: AppLinks?
    ): Intent? {
        return appDeepLink?.run {
            if (appDeepLink == AppLinks.APP_LINK) {
                return Intent(context, AppLinkExampleActivity::class.java)
            } else if (appDeepLink == AppLinks.DEEP_LINK) {
                return Intent(context, DeepLinkExampleActivity::class.java)
            }
            return null
        }
    }
}