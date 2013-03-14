package com.slidingmenu.example;

import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.slidingmenu.lib.SlidingMenu;
import com.slidingmenu.lib.app.SlidingFragmentActivity;

public class BaseActivity extends SlidingFragmentActivity {

	private int mTitleRes;
	protected ListFragment mFrag;

	public BaseActivity(int titleRes) {
		mTitleRes = titleRes;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setTitle(mTitleRes);

		// set the Behind View
		setBehindContentView(R.layout.menu_frame);
		FragmentTransaction t = this.getFragmentManager().beginTransaction();
		mFrag = new SampleListFragment();
		t.replace(R.id.menu_frame, mFrag);
		t.commit();

		// customize the SlidingMenu
		SlidingMenu sm = getSlidingMenu();
		sm.setShadowWidthRes(R.dimen.shadow_width);
		sm.setShadowDrawable(R.drawable.shadow);
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		sm.setFadeDegree(0.35f);
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			toggle();
			return true;
		case R.id.github:
			Util.goToGitHub(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	// COMMENTED OUT BECAUSE NOT IN USE AND USES SUPPORT LIBRARY API
	
//	public class BasePagerAdapter extends FragmentPagerAdapter {
//		private List<Fragment> mFragments = new ArrayList<Fragment>();
//		private ViewPager mPager;
//
//		public BasePagerAdapter(FragmentManager fm, ViewPager vp) {
//			super(fm);
//			mPager = vp;
//			mPager.setAdapter(this);
//			for (int i = 0; i < 3; i++) {
//				addTab(new SampleListFragment());
//			}
//		}
//
//		public void addTab(Fragment frag) {
//			mFragments.add(frag);
//		}
//
//		@Override
//		public Fragment getItem(int position) {
//			return mFragments.get(position);
//		}
//
//		@Override
//		public int getCount() {
//			return mFragments.size();
//		}
//	}

}
