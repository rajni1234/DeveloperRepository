package com.example.rajninegi.proofofconcept;

import android.content.Context;

class ActionBarTitle {

    public ActionBarTitle(Context context) {

        Context mContext = context;
    }
    /**
     * Variables for the json Data
     */
    private String title;

    private Rows[] rows;

    /**
     * Method to get title
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Method to set Title
     *
     * @param title:Action Bar title
     */
    public void setTitle(String title)

    {
        this.title = title;
    }

    /**
     * Method to get the rows
     *
     * @return rows : List Rows
     */
    public Rows[] getRows()

    {
        return rows;
    }

    /**
     * Method to set the rows
     *
     * @param rows :list rows
     */
    public void setRows(Rows[] rows)

    {
        this.rows = rows;
    }
}
