# Castle-Android-App 


# App provides list of Castles of Ireland and subsequent pages of information 


# Castle: 
    // Initialises Castle object with parameters from castles.xml 
    // Also creates getters and setters for each parameter 

# MainActivity 
    // First page of the app 
    // Initialises spinner and the custom recycler adapter 
    // Uses activity_main.xml and row_layout.xml 
    // Spinner provides options to sort the recycler adapter list by
        // - province 
        // - oldest castle to newest 
        // - newest castle to oldest 

# CastleActivity 
    // Provides image, a textView and a clickable button for more info 
    // Uses activity_build.xml 

# DetailsActivity 
    // Provides image, textView with more details about the castle and two buttons - 
    // one for web info and another produces a map 
    // Uses activity_details.xml 

# WebActivity 
    // Provides URL to webpage with more information baout the castle 
    // Uses activity_web.xml 

# MapActivity 
    // Provides a map with a marker on the location of the castle 
    // Uses Open Street map declared in the build.gradle module 
    // Uses activity_map.xml 
    // Added user permission to manifest for the fine/coarse location 
    // Uses IMapController and GeoPoint to get the map location from the co-ordinates in castles.xml 
    // Uses Marker to make marker logo on the locatiom point 
    // Reference to code found for the map: //https://stackoverflow.com/questions/22295768/how-to-use-osm-map-in-an-android-application-is-there-any-tutorial-to-learn-ab
                                            //https://github.com/osmdroid/osmdroid/wiki/How-to-use-the-osmdroid-library-(Java)
                                            //https://github.com/osmdroid/osmdroid/wiki/Markers,-Lines-and-Polygons-(Java) 

# XMLCastles 
    // Used to parse the XML 
    // Added in functions to sort on the mainActivity spinner 
![image](https://github.com/user-attachments/assets/d4c35c21-ffc8-4d64-8e39-a20a02eef78b) 
![image](https://github.com/user-attachments/assets/60c4a654-33c3-4907-a86d-74e3eae49990)
![image](https://github.com/user-attachments/assets/b2c2c8f3-c9c6-4a2b-a8e9-0f9ef4020353)



  
