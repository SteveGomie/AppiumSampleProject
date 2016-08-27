To execute test on Genymotion emulator, you need to pass the emulator udid to the device config file. When you run "adb devices" command it will show you the udid of the running emulator. It would be typically like "192.168.57.101:5555". You need to pass this value against the udid in the device config file. This is not mandatory if you are running just one instance of emulator and appium server. But if you are attempting parallel run it will make sense to specify udid and bind it with one of the appium server.+

#P.S : Uncheck the Launch AVD option in Appium under Android Section
# When running Test with TestNG by triggering the Appium Server Programtically,take care to add ANDROID_HOME variable to the Run Configurations under *Environment* tab
