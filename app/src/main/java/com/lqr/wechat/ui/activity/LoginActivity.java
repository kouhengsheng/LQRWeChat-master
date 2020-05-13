package com.lqr.wechat.ui.activity;


import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.lqr.wechat.R;
import com.lqr.wechat.ui.base.BaseActivity;
import com.lqr.wechat.ui.presenter.LoginAtPresenter;
import com.lqr.wechat.ui.view.ILoginAtView;
import com.lqr.wechat.util.UIUtils;

import butterknife.BindView;

/**
 * @创建者 CSDN_LQR
 * @描述 登录界面
 */
public class LoginActivity extends BaseActivity<ILoginAtView, LoginAtPresenter> implements ILoginAtView {

    @BindView(R.id.ibAddMenu)
    ImageButton mIbAddMenu;

    @BindView(R.id.etPhone)
    EditText mEtPhone;
    @BindView(R.id.vLinePhone)
    View mVLinePhone;

    @BindView(R.id.etPwd)
    EditText mEtPwd;
    @BindView(R.id.vLinePwd)
    View mVLinePwd;

    @BindView(R.id.tvProblems)
    TextView mTvProblems;
    @BindView(R.id.btnLogin)
    Button mBtnLogin;
    @BindView(R.id.tvOtherLogin)
    TextView mTvOtherLogin;

    TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            mBtnLogin.setEnabled(canLogin());
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    @Override
    public void initView() {
        mIbAddMenu.setVisibility(View.GONE);
    }

    @Override
    public void initListener() {
        mEtPwd.addTextChangedListener(watcher);
        mEtPhone.addTextChangedListener(watcher);
        mEtPwd.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                mVLinePwd.setBackgroundColor(UIUtils.getColor(R.color.green0));
            } else {
                mVLinePwd.setBackgroundColor(UIUtils.getColor(R.color.line));
            }
        });
        mEtPhone.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                mVLinePhone.setBackgroundColor(UIUtils.getColor(R.color.green0));
            } else {
                mVLinePhone.setBackgroundColor(UIUtils.getColor(R.color.line));
            }
        });

        mBtnLogin.setOnClickListener(v -> mPresenter.login());
    }

    private boolean canLogin() {
        int pwdLength = mEtPwd.getText().toString().trim().length();
        int phoneLength = mEtPhone.getText().toString().trim().length();
        if (pwdLength > 0 && phoneLength > 0) {
            return true;
        }
        return false;
    }


    @Override
    protected LoginAtPresenter createPresenter() {
        return new LoginAtPresenter(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    public EditText getEtPhone() {
        return mEtPhone;
    }

    @Override
    public EditText getEtPwd() {
        return mEtPwd;
    }
}