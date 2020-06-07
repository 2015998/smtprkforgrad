package com.example.smtprk.activity;

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
import static junit.framework.TestCase.assertNotNull;


public class MapsActivityTest {

    @Rule
    public ActivityTestRule<MapsActivity> mActivityTestRule = new ActivityTestRule<MapsActivity>(MapsActivity.class);

    private MapsActivity mActivity = null;



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


    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}