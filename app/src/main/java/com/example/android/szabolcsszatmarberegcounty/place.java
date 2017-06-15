package com.example.android.szabolcsszatmarberegcounty;

public class place {
    /**
     * Constant value that represents no image was provided for this place
     */
    private static final int NO_IMAGE_PROVIDED = -1;
    // Name of place (or famous people). For simplicity we refer with the instances of place class to famous people as well.
    private String mName;
    // Brief summery of the place.
    private String mDescription;
    // This refers to the Url of the place
    private String mUrl;
    /**
     * Image resource ID for the place
     */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /**
     * Constructs a new {@link place} object.
     *
     * @param name        is the name of the place
     * @param description description of the place
     * @param url         is the website address of the place
     */

    public place(String name, String description, String url, int imageResourceId) {
        mName = name;
        mDescription = description;
        mUrl = url;
        mImageResourceId = imageResourceId;

    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getUrl() {
        return mUrl;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }


}
