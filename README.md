### Dormum - Android Renting App

####  1 - About the App
Dormum is app based on Airbnb and Uber created for users whose travels without any preparation or planning.
The app allows the users to find houses, apartments or rooms nearby and offers the option for the users to rent a place based on the hours spent on that place.

This allows the user to pay only for the time they estemate to stay in an Dormum (house, apartment, rooms, etc).

#### 2 - Import the Project
#####    On Android Studio:
```
File > New > Import Project
```

#### 3 - Setting Up Parser Server
##### Paste this in your dependencies into your Gradle
```
implementation "com.github.parse-community.Parse-SDK-Android:parse:1.18.5"
```

##### Paste this meta tags into your AndroidManifest.xml
```
<meta-data
  android:name="com.parse.SERVER_URL"
  android:value="@string/back4app_server_url" />
<meta-data
  android:name="com.parse.APPLICATION_ID"
  android:value="@string/back4app_app_id" />
<meta-data
  android:name="com.parse.CLIENT_KEY"
  android:value="@string/back4app_client_key" />
```
For more information: https://dashboard.back4app.com/apidocs
#### 4 - Rebuild and Run Project

```
Build > Rebuild Project
```
