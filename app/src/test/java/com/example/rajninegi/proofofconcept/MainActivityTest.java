package com.example.rajninegi.proofofconcept;

import android.support.v7.app.AppCompatActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class MainActivityTest {

    @Mock
    private MainActivity activity;
    @Mock
    private AppCompatActivity appCompatActivity;


    private static final String SAMPLE_TEXT = "sample text";

    @Before
    public void setUp() throws Exception {
        activity = new MainActivity();
    }

    @Test
    public void activityShouldNotBeNull() throws Exception {
        assertNotNull(activity);

    }
}