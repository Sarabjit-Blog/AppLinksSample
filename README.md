Deep Linking Application

This Application is used to demonstrate the simple implementation of Deep Links

Clone this project using https://github.com/Sarabjit-Blog/AppLinksSample

- [x] Downloaad the application
- [x] Run the application
- [x] Put the application in background
- [x] Run the following command
 
 - Select qaDebug build variant and run following command:
adb shell am start -a android.intent.action.VIEW -c android.intent.category.BROWSABLE -d http://www.androidinformative.com/deep-linking-in-android

 - Select prodDebug build variant and run following command:
 adb shell am start -a android.intent.action.VIEW -c android.intent.category.BROWSABLE -d http://www.androidinformative.com/app-links-in-android
