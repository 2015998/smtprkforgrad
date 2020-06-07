package com.example.smtprk.activity;

import android.app.Activity;
import android.app.Instrumentation;

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


public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    private MainActivity mActivity = null;

    Instrumentation.ActivityMonitor Lmonitor= getInstrumentation().addMonitor(LoginActivity.class.getName(),null,false );
    Instrumentation.ActivityMonitor Dmonitor= getInstrumentation().addMonitor(DestinationActivity.class.getName(),null,false );

    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();

    }

    @Test
    public void testLaunch() {

        assertNotNull(mActivity.findViewById(R.id.name));
        assertNotNull(mActivity.findViewById(R.id.email));
        assertNotNull(mActivity.findViewById(R.id.btnMenu));
        assertNotNull(mActivity.findViewById(R.id.btnLogout));

        onView(withId(R.id.btnMenu)).perform(click()); //click action test
        onView(withId(R.id.btnLogout)).perform(click());

        Activity exDestination= getInstrumentation().waitForMonitorWithTimeout(Dmonitor,5000); //timeout test
        Activity exLogin= getInstrumentation().waitForMonitorWithTimeout(Lmonitor,5000); //timeout test
        assertNotNull(exDestination);
        assertNotNull(exLogin);


    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}