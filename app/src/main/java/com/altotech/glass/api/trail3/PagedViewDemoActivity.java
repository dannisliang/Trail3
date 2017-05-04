package com.altotech.glass.api.trail3;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterPagedView;
import android.widget.AdapterPagedView.OnDownSlidingBackListener;
import android.widget.AdapterPagedView.OnItemClickListener;
import android.widget.AdapterPagedView.OnItemLongPressListener;
import android.widget.AdapterPagedView.OnPageSelectedListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PagedView;
import android.widget.TextView;

public class PagedViewDemoActivity extends Activity implements
		OnItemClickListener, OnDownSlidingBackListener,
		OnItemLongPressListener, OnPageSelectedListener {
	private FrameLayout mContainer;
	private AdapterPagedView mPagedView;
	private ArrayList<Integer> mPagedViewList = new ArrayList<Integer>();
	private PagedView mMenuPagedView;
	private Integer cards[] = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e};
	private final int DEL_ID = 0;
	private final int ADD_ID = 1;
	private final int DEL_ALL_ID = 2;
	private final int THREE_PAGE_IN_SCREEN_ID = 3;

	private ImageAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_paged_viewgroup_demo);
		mContainer = (FrameLayout) findViewById(R.id.container_paged_viewgroup);
		// 通过xml布局findViewById获取, 也可以直接new
		mPagedView = (AdapterPagedView) findViewById(R.id.paged_view);

		for (int i = 0; i < cards.length; i++)
			mPagedViewList.add(cards[i]);
		mAdapter = new ImageAdapter(this, mPagedViewList);

		/*
		 * 配置PagedView的属性参数
		 */
		mPagedView.setAdapter(mAdapter);

		// 用来显示滑动位置的view传给PagedView，PagedView会根据当前卡片的位置将indicator显示在屏幕下方相应位置，
		// (非必须功能项)。
		mPagedView.setScrollIndicator(findViewById(R.id.paged_view_indicator));

		// 设置一屏幕显示几张卡片，默认1张即全屏显示，位于中间的卡片为选中卡片，用户可以添加高亮框以提示选中，
		// 注意：参数必须为奇数，(非必须功能项)。
		mPagedView.setPageCountInScreen(1);

		// 设置每张卡片的间距，默认为0即每张卡片都是紧挨着的，(非必须功能项)。
		mPagedView.setPageMargin(0);

		// 设置是否允许快滑缩小功能，默认不支持，当滑动距离和速度都超过一定阈值且卡片总数大于5张才有效，(非必须功能项)。
        mPagedView.setFlyFlip(true);

		// 设置是否允许循环切换功能，(非必须功能项)。
		mPagedView.setCircleFlip(true);

		// 设置快滑缩小的比例，setFlyFlip为true才有效，(非必须功能项)。
		mPagedView.setFlyPageSizeScale(0.5f);

		// 设置是否允许横向滑动到头后继续滑动卡片会继续滑动松手后弹回，默认为true，
		// 注意：只有在非循环状态下有效，(非必须功能项)。
		mPagedView.setCanHorizontalOverScroll(true);

		// 设置是否允许纵向向上滑动卡片会继续滑动松手后弹回，默认为true，(非必须功能项)。
		mPagedView.setCanVerticalOverScroll(true);

		// 设置是否允许滑动音效，默认为true，(非必须功能项)。
		mPagedView.setUseSoundEffect(true);

		// 设置点击事件监听，当用户点击后回调通知用户点击的PagedView、卡片view和卡片position,(非必须功能项)。
		mPagedView.setOnItemClickListener(this);

		// 设置长按事件监听，当用户长按后回调通知用户长按的PagedView、卡片view和卡片position,(非必须功能项)。
		mPagedView.setOnItemLongPressListener(this);

		// 设置下滑事件监听，当用户下滑后回调通知用户下滑的PagedView，(非必须功能项)。
		mPagedView.setOnDownSlidingBackListener(this);

		// 设置卡片滑动事件监听，当用户滑动卡片PagedView停止滑动后回调通知用户滑动到的页数，(非必须功能项)。
		mPagedView.setOnPageSelectedListener(this);

		// menu

		mPagedView.setCurrentScreen(0);
	}

	private void setupMenu() {
		mMenuPagedView = new PagedView(this);

		LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);

		View delItem = getLayoutInflater().inflate(R.layout.card_item, null);
		((TextView) delItem.findViewById(R.id.tv)).setText("Delete");
		delItem.setId(DEL_ID);
		delItem.setLayoutParams(lp);
		mMenuPagedView.addItem(delItem);

		View addItem = getLayoutInflater().inflate(R.layout.card_item, null);
		((TextView) addItem.findViewById(R.id.tv)).setText("Add");
		addItem.setId(ADD_ID);
		addItem.setLayoutParams(lp);
		mMenuPagedView.addItem(addItem);

		View clearItem = getLayoutInflater().inflate(R.layout.card_item, null);
		((TextView) clearItem.findViewById(R.id.tv)).setText("Del all");
		clearItem.setId(DEL_ALL_ID);
		clearItem.setLayoutParams(lp);
		mMenuPagedView.addItem(clearItem);

		View pageCountItem = getLayoutInflater().inflate(R.layout.card_item,
				null);
		((TextView) pageCountItem.findViewById(R.id.tv))
				.setText("3 page in screen");
		pageCountItem.setId(THREE_PAGE_IN_SCREEN_ID);
		pageCountItem.setLayoutParams(lp);
		mMenuPagedView.addItem(pageCountItem);

		mMenuPagedView.setAlpha(0.9f);
		mMenuPagedView.setPageMargin(5);
		mMenuPagedView.setCircleFlip(true);
		// 设置进入和退出动画，(非必须功能项)。
		// 注意：目前只有在可见性发生变化时才会启动动画，所以在setvisibility时才会有动画
		mMenuPagedView.setInOutAnimation(this, R.anim.push_down_in,
				R.anim.push_down_out);
		mMenuPagedView
				.setOnDownSlidingBackListener(new PagedView.OnDownSlidingBackListener() {
					@Override
					public void onDownSlidingBack(PagedView pagedView) {
						mContainer.removeView(mMenuPagedView);
					}
				});
		mMenuPagedView
				.setOnItemClickListener(new PagedView.OnItemClickListener() {
					@Override
					public void onItemClick(PagedView pagedView, View view,
							int position) {
						mContainer.removeView(mMenuPagedView);
						switch (view.getId()) {
						case DEL_ID:
							// 动态删除卡片,不要忘记做notifyDataSetChanged通知PagedView做更新
							mPagedViewList.remove(mPagedView.getCurScreen());
							mAdapter.notifyDataSetChanged();
							break;

						case ADD_ID:
							// 动态添加卡片,不要忘记做notifyDataSetChanged通知PagedView做更新
							mPagedViewList.add(mPagedView.getCurScreen(),
									1);//////////////////////////!!!!!!!!!!
							mAdapter.notifyDataSetChanged();
							break;

						case DEL_ALL_ID:
							// 删除所有卡片,不要忘记做notifyDataSetChanged通知PagedView做更新
							mPagedViewList.clear();
							mAdapter.notifyDataSetChanged();
							break;

						case THREE_PAGE_IN_SCREEN_ID:
							// 定位到第3张卡片
							mPagedView.setSelection(2);
							break;

						default:
							break;
						}
					}
				});
	}

	@Override
	public void onItemLongPress(AdapterPagedView pagedView, View view,
			int position) {
		mMenuPagedView.setCurrentScreen(0);
		mContainer.addView(mMenuPagedView);
	}

	@Override
	public void onDownSlidingBack(AdapterPagedView pagedView) {
		finish();
	}

	@Override
	public void onItemClick(AdapterPagedView pagedView, View view, int position) {
		Intent intent = new Intent();
		if(position==0){
			intent.setClass(this,GestureDemoActivity.class);
		}else if(position==1){
			intent.setClass(this, VoiceRecognizerDemoActivity.class);
		}
		startActivity(intent);
	}

	@Override
	public void onPageSelected(AdapterPagedView pagedView, View view,
			int position) {
//		Toast.makeText(this,
//				"You slide to position " + position + " of main pagedview.",
//				Toast.LENGTH_SHORT).show();
	}

}