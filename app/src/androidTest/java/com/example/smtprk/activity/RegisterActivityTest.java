package com.example.smtprk.activity;

import android.app.Instrumentation;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;


public class RegisterActivityTest {

    @Rule
    public ActivityTestRule<RegisterActivity> mActivityTestRule = new ActivityTestRule<RegisterActivity>(RegisterActivity.class);

    private RegisterActivity mActivity = null;

    Instrumentation.ActivityMonitor Rmonitor= getInstrumentation().addMonitor(LoginActivity.class.getName(),null,false );
    Instrumentation.ActivityMonitor Mmonitor= getInstrumentation().addMonitor(MainActivity.class.getName(),null,false );

    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();

    }

    @Test
   /* public void testLaunch() {


        assertNotNull(mActivity.findViewById(R.id.password));
        assertNotNull(mActivity.findViewById(R.id.email));
        assertNotNull(mActivity.findViewById(R.id.name));
        assertNotNull(mActivity.findViewById(R.id.btnRegister));
        assertNotNull(mActivity.findViewById(R.id.btnLinkToLoginScreen));

        onView(withId(R.id.btnRegister)).perform(click()); //click action test
        onView(withId(R.id.btnLinkToLoginScreen)).perform(click());

        Activity exRegister= getInstrumentation().waitForMonitorWithTimeout(Rmonitor,5000); //timeout test
        Activity exMain= getInstrumentation().waitForMonitorWithTimeout(Mmonitor,5000); //timeout test
        assertNotNull(exRegister);
        assertNotNull(exMain);



    }
*/
    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}