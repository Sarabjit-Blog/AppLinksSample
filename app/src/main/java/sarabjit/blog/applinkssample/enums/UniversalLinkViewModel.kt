package sarabjit.blog.applinkssample.enums

import android.net.Uri
import android.os.Parcel
import android.os.Parcelable

class UniversalLinkViewModel(val mUri: Uri?) : Parcelable {

    //You can read the data from the applink like this
    // val someData: String? = mUri?.getQueryParameter("someKey")

    fun getUri(): Uri? {
        return mUri
    }

    constructor(source: Parcel) : this(
        source.readParcelable<Uri>(Uri::class.java.classLoader)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeParcelable(mUri, 0)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<UniversalLinkViewModel> =
            object : Parcelable.Creator<UniversalLinkViewModel> {
                override fun createFromParcel(source: Parcel): UniversalLinkViewModel =
                    UniversalLinkViewModel(source)

                override fun newArray(size: Int): Array<UniversalLinkViewModel?> =
                    arrayOfNulls(size)
            }
    }
}