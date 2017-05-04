package com.altotech.glass.api.trail3;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.GestureDetector;
import android.widget.TextView;

import com.ingenic.glass.voicerecognizer.api.VoiceRecognizerActivity;

public class VoiceRecognizerDemoActivity extends VoiceRecognizerActivity {
	private final String TAG = "VoiceRecognizerDemoActivity";
	private final String VOICE_CMD_CONFIRM = "确定";
	private final String VOICE_CMD_CANCEL = "取消";
	private final String VOICE_CMD_SHARE_TO_WECHAT = "分享到微信";
	private final String VOICE_CMD_SHARE_TO_WEIBO = "分享到微薄";
	private final String VOICE_CMD_TAKE_PHOTO = "拍照";
	private final String VOICE_CMD_TAKE_VIDEO = "录像";
	private final String VOICE_CMD_SEND_MESSAGE = "发短信";
	private final String VOICE_CMD_DIAL = "打电话";
	private final String VOICE_CMD_NAVIGATION = "导航";
	private final String VOICE_CMD_DELETE = "删除";
	private final String VOICE_CMD_PLAY = "播放";
	private final String VOICE_CMD_SURROUND = "附近";
	private final String VOICE_CMD_SEARCH = "搜索";
	private final String VOICE_CMD_TRANLATE = "翻译";
	private final String VOICE_CMD_REPLAY = "重新播放";
	private final String VOICE_CMD_NEXT = "下一个";
	private final String VOICE_CMD_PREVIOS = "上一个";
	private final String VOICE_CMD_STOP = "暂停";
	private final String VOICE_CMD_BACK = "返回";
	private final String VOICE_CMD_ROAD_SIGN = "路牌识别";
	private final String 故宫 = "故宫";
	private final String 故宫午门  = "故宫午门";
	private final String 午门 = "午门";
	private final String 金阁寺 = "金阁寺";
	private final String 墨尔本维多利亚女王市场 = "墨尔本维多利亚女王市场";
	private final String 维多利亚 = "维多利亚";
	private final String QUEEN = "女王";
	private final String MARKET = "市场";
	GestureDetector mGestureDetector = null;
	private final String[] VOICE_CMDS = { VOICE_CMD_CONFIRM, VOICE_CMD_CANCEL,
			VOICE_CMD_SHARE_TO_WECHAT, VOICE_CMD_SHARE_TO_WEIBO,
			VOICE_CMD_TAKE_PHOTO, VOICE_CMD_TAKE_VIDEO, VOICE_CMD_SEND_MESSAGE,
			VOICE_CMD_DIAL, VOICE_CMD_NAVIGATION, VOICE_CMD_DELETE,
			VOICE_CMD_PLAY,VOICE_CMD_SURROUND, VOICE_CMD_SEARCH,VOICE_CMD_TRANLATE,VOICE_CMD_REPLAY,VOICE_CMD_NEXT,
			VOICE_CMD_PREVIOS,VOICE_CMD_STOP,VOICE_CMD_BACK,VOICE_CMD_ROAD_SIGN,故宫午门,故宫,午门,金阁寺,墨尔本维多利亚女王市场,维多利亚,QUEEN,MARKET};
	private TextView mTextView = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_voice_recognizer_demo);
		mTextView = (TextView) findViewById(R.id.result);
		// 方式一添加语音命令，包含“退出”命令，无需而外添加
		for (int i = 0; i < VOICE_CMDS.length; i++) {
			// 添加语音识别命令
			addRecognizeCommand(VOICE_CMDS[i]);
		}
		/*
		 * 方式二添加语音命令，较方式一而言，没有包含“退出”命令 ArrayList<String> al = new
		 * ArrayList<String>(); for (int i = 0; i < VOICE_CMDS.length; i++) { //
		 * addRecognizeCommand(getString(VOICE_CMDS[i])); al.add(VOICE_CMDS[i]);
		 * } setRecognizeCommands(al);
		 */
		mGestureDetector = new GestureDetector(this,
				new MySimpleGestureDetectorListener());
	}

	// return false,可继续进行识别
	@Override
	protected boolean onCommandResult(String result, float score) {
		if (score > -11.0f) {
			mTextView.setText(result);
		}
		return false;
	}

	// 语音"退出"命令,实现该接口即可
	@Override
	protected boolean onExit(float score) {
		if (score > -11.0f) {
			finish();
			return true;
		}
		return false;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return mGestureDetector.onTouchEvent(event);
	}

	class MySimpleGestureDetectorListener extends
			GestureDetector.SimpleOnGestureListener {

		@Override
		public boolean onDown(boolean fromPhone) {
			Log.d(TAG, "onDown");
			return super.onDown(fromPhone);
		}

		@Override
		public boolean onLongPress(boolean fromPhone) {
			Log.d(TAG, "onLongPress");
			return super.onLongPress(fromPhone);
		}

		@Override
		public boolean onScroll(MotionEvent e1, MotionEvent e2,
				float distanceX, float distanceY, boolean fromPhone) {
			Log.d(TAG, "onScroll");
			return super.onScroll(e1, e2, distanceX, distanceY, fromPhone);
		}

		@Override
		public boolean onSlideDown(boolean fromPhone) {
			Log.d(TAG, "onSlideDown");
			finish();
			return super.onSlideDown(fromPhone);
		}

		@Override
		public boolean onSlideLeft(boolean fromPhone) {
			Log.d(TAG, "onSlideLeft");
			return super.onSlideLeft(fromPhone);
		}

		@Override
		public boolean onSlideRight(boolean fromPhone) {
			return super.onSlideRight(fromPhone);
		}

		@Override
		public boolean onSlideUp(boolean fromPhone) {
			return super.onSlideUp(fromPhone);
		}

		@Override
		public boolean onTap(boolean fromPhone) {
			return super.onTap(fromPhone);
		}

		@Override
		public boolean onUp(MotionEvent ev, boolean fromPhone) {
			Log.d(TAG, "onUp");
			return super.onUp(ev, fromPhone);
		}

	}
}