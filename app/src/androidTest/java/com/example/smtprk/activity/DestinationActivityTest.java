package com.example.smtprk.activity;

import android.app.Activity;
import android.app.Instrumentation;
import android.view.View;

import androidx.test.rule.ActivityTestRule;

import com.example.smtprk.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static junit.framework.TestCase.assertNotNull;


public class DestinationActivityTest {

    @Rule
    public ActivityTestRule<DestinationActivity> mActivityTestRule = new ActivityTestRule<DestinationActivity>(DestinationActivity.class);

    private DestinationActivity mActivity = null;

    Instrumentation.ActivityMonitor monitor= getInstrumentation().addMonitor(MapsActivity.class.getName(),null,false );

    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch() {
        View view = mActivity.findViewById(R.id.ImgBtnKKM); //view test
        assertNotNull(view);
        View nView = mActivity.findViewById(R.id.ImgBtnS);
        assertNotNull(nView);

        onView(withId(R.id.ImgBtnS)).perform(click()); //click action test
        onView(withId(R.id.ImgBtnKKM)).perform(click());

        Activity exMapActivity= getInstrumentation().waitForMonitorWithTimeout(monitor,5000); //timeout test
        assertNotNull(exMapActivity);

    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}