# MapNavigator

## Description
This is an Android application that uses Google's map APIs to find the user's current location. The user can place markers on the map and the application will find and draw the shortest path between the user and the marker.

## Prerequisites
[Android Studio](https://developer.android.com/studio) is required.
- Android Studio SDK is Android API 33.
- A Pixel 5 API 29 was used for emulation and testing.

A Google API key on the Google Maps Platform is required with the following APIs:
- Directions API
- Maps SDK for Android<br>

The API key must be added in the following files:
- [Android Manifest.xml](https://github.com/Chris-Archive/MapNavigator/blob/main/app/src/main/AndroidManifest.xml) in **android:value** under **com.google.android.geo.API_KEY**
- [strings.xml](https://github.com/Chris-Archive/MapNavigator/blob/main/app/src/main/res/values/strings.xml) in *API_KEY*
<br>
