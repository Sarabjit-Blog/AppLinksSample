package sarabjit.blog.applinkssample.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import sarabjit.blog.applinkssample.manager.AppLinkManager

class AppLinkHandlingActivity : AppCompatActivity() {
    private lateinit var mAppLinkManager: AppLinkManager

    /**
     * Deep Link Manager will handle the deep link and then we will quit our DeepLinkHandling
     * activity as it has performed its task successfully
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mAppLinkManager = AppLinkManager()

        intent?.run {
            handleDeepLink()
            intent.setData(null);
        }
        finish()
    }

    /**
     * Deep Link Manager takes the appropriate action
     */
    private fun handleDeepLink() {
        mAppLinkManager.resolveLink(this, intent)
    }
}