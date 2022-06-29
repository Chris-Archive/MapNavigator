# MapNavigator

## Description
This is an Android application that uses Google's map APIs to find the user's current location. The user can place markers on the map and the application will find and draw the shortest path between the user and the marker.

Please note that due to emulation, the current location will always be Google's headquarters. Outside of emulation, it will be able to detect your location.

## Prerequisites
[Android Studio](https://developer.android.com/studio) is required.
- Android Studio SDK running on Android API 33.
- A Pixel 5 API 29 was used for emulation and testing.

A Google API key on the Google Maps Platform is required with the following APIs:
- Directions API
- Distance Matrix API
- Maps SDK for Android<br>

The API key must be added in the following file:
- [strings.xml](https://github.com/Chris-Archive/MapNavigator/blob/main/app/src/main/res/values/strings.xml) in *API_KEY*
<br>

## Credits
- Michale Friedrich: For designing and developing the initial button functionalities and their algorithms as well the UI.

## Example Images

![Current Location](/Image%20Examples/Current%20Location.png)