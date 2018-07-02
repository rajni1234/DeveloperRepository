package com.example.rajninegi.proofofconcept;

import android.content.Context;
import android.support.transition.Transition;
import android.view.View;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by Rajni Negi on 7/1/2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class RowAdapterTest {

    private static final String TITLE = "title";
    private static final String DESCRIPTION = "description";
    private static final String IMAGE_URL = "image url";
    //As we don't have access to Context in our JUnit test classes, we need to mock it
    @Mock
    Context mMockContext;
    @Mock
    private RowAdapter rowAdapter;

    @Mock
    private Rows myrows;
    @Mock
    private ActionBarTitle actionBarTitle;


    @Before
    public void setUp() throws Exception
    {
        //Creates an object of the Rows with the mock context
        myrows=new Rows(mMockContext);
        actionBarTitle=new ActionBarTitle(mMockContext);

    }

    @Test
    public void checkItemCount() {
        int count=rowAdapter.getItemCount();
        assertNotNull(count);
    }

}