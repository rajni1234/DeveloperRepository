package com.example.rajninegi.proofofconcept;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class RowsTest {

    private static final String TITLE = "title";
    private static final String DESCRIPTION = "description";
    private static final String IMAGE_URL = "image url";
    //As we don't have access to Context in our JUnit test classes, we need to mock it
    @Mock
    Context mMockContext;
    @Mock
    private Rows rows;

    @Before
    public void setUp() throws Exception
    {
        //Creates an object of the Rows with the mock context
        rows=new Rows(mMockContext);
    }

    @Test
    public void activityShouldNotBeNull() throws Exception
    {
        assertNotNull( rows );
    }

    @Test
    public void checkSetGetTitle() {
        rows.setTitle(TITLE);
        String result = rows.getTitle();
        assertThat(result, is(TITLE));
    }

    @Test
    public void checkSetGetDescription() {
        rows.setDescription(DESCRIPTION);
        String result = rows.getDescription();
        assertThat(result, is(DESCRIPTION));
    }

    @Test
    public void checkSetGetImageUrl() {
        rows.setImageHref(IMAGE_URL);
        String result = rows.getImageHref();
        assertThat(result, is(IMAGE_URL));
    }
}