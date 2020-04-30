package sarabjit.blog.applinkssample.enums

import sarabjit.blog.applinkssample.R

/**
 * Enums that corresponds to the Supported DeepLinks
 */
enum class AppLinks(val mScheme: Int, val mHost: Int, val mPath: Int) {
    APP_LINK(
        R.string.deep_link_scheme,
        R.string.deep_link_host_kotlin,
        R.string.path_kotlin
    ),
    DEEP_LINK(
        R.string.deep_link_scheme,
        R.string.deep_link_host_java,
        R.string.path_java
    );
}