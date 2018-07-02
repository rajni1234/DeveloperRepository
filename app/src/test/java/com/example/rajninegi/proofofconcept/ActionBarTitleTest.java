package com.example.rajninegi.proofofconcept;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ActionBarTitleTest {

    private static final String TITLE = "title";
    private static final String DESCRIPTION = "description";
    private static final String IMAGE_URL = "image url";
    //As we don't have access to Context in our JUnit test classes, we need to mock it
    @Mock
    Context mMockContext;
    @Mock
    private ActionBarTitle actionBarTitle;

    @Before
    public void setUp() throws Exception {
        //Creates an object of the ActionBarTitle with the mock context
        actionBarTitle = new ActionBarTitle(mMockContext);
    }

    @Test
    public void activityShouldNotBeNull() throws Exception {
        assertNotNull(actionBarTitle);
    }

    @Test
    public void checkSetGetTitle() {
        //Set the title value
        actionBarTitle.setTitle(TITLE);
        //Stores the return value of getTitle() in result
        String result = actionBarTitle.getTitle();
        //Asserts that result is the value of TITLE_STRING
        assertThat(result, is(TITLE));
    }

    @Test
    public void checkSetGetRows() {
        Rows[] rows = new Rows[1];
        for (int i = 0; i < 1; i++) {
            Rows myRows = new Rows(this.mMockContext);
            myRows.setTitle(TITLE);
            myRows.setDescription(DESCRIPTION);
            myRows.setImageHref(IMAGE_URL);
            rows[i] = myRows;

        }
        actionBarTitle.setRows(rows);
        Rows[] getRowValues = actionBarTitle.getRows();
        assertArrayEquals(rows, getRowValues);
    }
}