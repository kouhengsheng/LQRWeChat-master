package com.lqr.wechat.ui.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lqr.recyclerview.LQRRecyclerView;
import com.lqr.wechat.R;
import com.lqr.wechat.ui.base.BaseActivity;
import com.lqr.wechat.ui.presenter.NewFriendAtPresenter;
import com.lqr.wechat.ui.view.INewFriendAtView;
import com.lqr.wechat.util.UIUtils;

import butterknife.BindView;

/**
 * @创建者 CSDN_LQR
 * @描述 新的朋友界面
 */

public class NewFriendActivity extends BaseActivity<INewFriendAtView, NewFriendAtPresenter> implements INewFriendAtView {

    @BindView(R.id.llToolbarAddFriend)
    LinearLayout mLlToolbarAddFriend;
    @BindView(R.id.tvToolbarAddFriend)
    TextView mTvToolbarAddFriend;

    @BindView(R.id.llNoNewFriend)
    LinearLayout mLlNoNewFriend;
    @BindView(R.id.llHasNewFriend)
    LinearLayout mLlHasNewFriend;
    @BindView(R.id.rvNewFriend)
    LQRRecyclerView mRvNewFriend;

    @Override
    public void initView() {
        mLlToolbarAddFriend.setVisibility(View.VISIBLE);
        setToolbarTitle(UIUtils.getString(R.string.new_friend));
    }

    @Override
    public void initData() {
        mPresenter.loadNewFriendData();
    }

    @Override
    public void initListener() {
        mTvToolbarAddFriend.setOnClickListener(v -> jumpToActivity(AddFriendActivity.class));
    }

    @Override
    protected NewFriendAtPresenter createPresenter() {
        return new NewFriendAtPresenter(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_new_friend;
    }

    @Override
    public LinearLayout getLlNoNewFriend() {
        return mLlNoNewFriend;
    }

    @Override
    public LinearLayout getLlHasNewFriend() {
        return mLlHasNewFriend;
    }

    @Override
    public LQRRecyclerView getRvNewFriend() {
        return mRvNewFriend;
    }
}
