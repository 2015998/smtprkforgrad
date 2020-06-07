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


public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityTestRule = new ActivityTestRule<LoginActivity>(LoginActivity.class);

    private LoginActivity mActivity = null;

    Instrumentation.ActivityMonitor Rmonitor= getInstrumentation().addMonitor(RegisterActivity.class.getName(),null,false );
    Instrumentation.ActivityMonitor Mmonitor= getInstrumentation().addMonitor(MainActivity.class.getName(),null,false );

    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();

    }

    @Test
    public void testLaunch() {

        assertNotNull(mActivity.findViewById(R.id.password));
        assertNotNull(mActivity.findViewById(R.id.email));
        assertNotNull(mActivity.findViewById(R.id.btnLogin));
        assertNotNull(mActivity.findViewById(R.id.btnLinkToRegisterScreen));

        onView(withId(R.id.btnMenu)).perform(click()); //click action test
        onView(withId(R.id.btnLogout)).perform(click());

        Activity exRegister= getInstrumentation().waitForMonitorWithTimeout(Rmonitor,5000); //timeout test
        Activity exMain= getInstrumentation().waitForMonitorWithTimeout(Mmonitor,5000); //timeout test
        assertNotNull(exRegister);
        assertNotNull(exMain);



    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}