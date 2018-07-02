package com.example.rajninegi.proofofconcept;

import android.content.Context;

public class Rows {

    /**
     * Variables used for jsonData
     */
        private String title;

        private String description;

        private String imageHref;
     Context mContext;
    public Rows(Context context) {
        mContext = context;
    }
    /**
     * Method to get title
     * @return title : row title
     */
        public String getTitle ()
        {
            return title;
        }

    /**
     * Method to set title
     * @param title :row title
     */
        public void setTitle (String title)
        {
            this.title = title;
        }

    /**
     * Method to get description
     * @ row description
     */
        public String getDescription ()
        {
            return description;
        }

    /**
     * Method to set Description
     * @param  description: Row description
     */
        public void setDescription (String description)
        {
            this.description = description;
        }

    /**
     * Method to get Image Url
     * @return image url
     */
        public String getImageHref ()
        {

            return imageHref;
        }

    /**
     * Method to set image url
     * @param imageHref image url
     */
        public void setImageHref (String imageHref)
        {
            this.imageHref = imageHref;
        }

    }

