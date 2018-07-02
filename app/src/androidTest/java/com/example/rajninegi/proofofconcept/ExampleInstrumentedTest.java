package com.example.rajninegi.proofofconcept;

import android.app.Activity;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.android.volley.toolbox.JsonObjectRequest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleInstrumentedTest {
    private MainActivity mainActivity;

    @Before
    public void createMainActivity(){
        mainActivity=new MainActivity();
    }
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.rajninegi.proofofconcept", appContext.getPackageName());
    }

    @Test
    public void validateTextViewContent() {
        assertNotNull("Action bar is null", mainActivity.getSupportActionBar().getTitle());
        assertTrue("TextView contains incorrect text",
                "About Canada".equals(mainActivity.getSupportActionBar().getTitle()));
    }
}
